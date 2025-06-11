package cn.iocoder.yudao.module.elderly.service.reserve;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.reserve.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.reserve.ReserveDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.reserve.ReserveMapper;
import cn.iocoder.yudao.module.system.service.buildingbed.BuildingBedService;
import cn.iocoder.yudao.module.system.dal.dataobject.buildingbed.BuildingBedDO;
import cn.iocoder.yudao.module.system.controller.admin.buildingbed.vo.BuildingBedSaveReqVO;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;

/**
 * 预约登记 Service 实现类
 *
 * @author 沈文杰
 */
@Service
@Validated
public class ReserveServiceImpl implements ReserveService {

    @Resource
    private ReserveMapper reserveMapper;

    @Resource
    private BuildingBedService buildingBedService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createReserve(ReserveSaveReqVO createReqVO) {
        // 校验床位状态
        BuildingBedDO bed = buildingBedService.getBuildingBed(createReqVO.getBedId());
        if (bed == null) {
            throw exception(BED_NOT_EXISTS);
        }
        if ("1".equals(bed.getHasReserved()) || "1".equals(bed.getHasUsed()) || "1".equals(bed.getHasTried())) {
            // 且床位占用人不是预订人自己，预订人取自请求中的elderlyId, 占用人取自bed信息中的getUserBedId
            if (!Objects.equals(bed.getUserBedId(), createReqVO.getElderlyId())) {
                throw exception(BED_ALREADY_OCCUPIED);
            }
        }

        // 插入预约记录
        ReserveDO reserve = BeanUtils.toBean(createReqVO, ReserveDO.class);
        reserveMapper.insert(reserve);

        // 更新床位状态为已预订，并设置预订人ID
        buildingBedService.updateBedReserve(createReqVO.getBedId(), "1", createReqVO.getElderlyId());

        return reserve.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateReserve(ReserveSaveReqVO updateReqVO) {
        // 校验存在
        ReserveDO oldReserve = validateReserveExists(updateReqVO.getId());
        
        // 校验新床位状态
        BuildingBedDO newBed = buildingBedService.getBuildingBed(updateReqVO.getBedId());
        if (newBed == null) {
            throw exception(BED_NOT_EXISTS);
        }
        if ("1".equals(newBed.getHasReserved()) || "1".equals(newBed.getHasUsed()) || "1".equals(newBed.getHasTried())) {
            // 且床位占用人不是预订人自己，预订人取自请求中的elderlyId, 占用人取自bed信息中的getUserBedId
            if (!Objects.equals(newBed.getUserBedId(), updateReqVO.getElderlyId())) {
                throw exception(BED_ALREADY_OCCUPIED);
            }
        }

        // 如果床位ID发生变化，需要释放旧床位
        if (!Objects.equals(oldReserve.getBedId(), updateReqVO.getBedId())) {
            // 释放旧床位
            buildingBedService.updateBedReserve(oldReserve.getBedId(), "0", null);

            // 占用新床位
            buildingBedService.updateBedReserve(updateReqVO.getBedId(), "1", updateReqVO.getElderlyId());
        } else if (!Objects.equals(oldReserve.getElderlyId(), updateReqVO.getElderlyId())) {
            // 如果床位没变但预订人变了，更新床位的预订人
            buildingBedService.updateBedReserve(updateReqVO.getBedId(), "1", updateReqVO.getElderlyId());
        }

        // 更新预约记录
        ReserveDO updateObj = BeanUtils.toBean(updateReqVO, ReserveDO.class);
        reserveMapper.updateById(updateObj);
    }

    @Override
    public void deleteReserve(Long id) {
        // 校验存在
        ReserveDO reserve = validateReserveExists(id);
        // 释放床位
        buildingBedService.updateBedReserve(reserve.getBedId(), "0", null);
        // 删除
        reserveMapper.deleteById(id);
    }

    @Override
    public void deleteReserveListByIds(List<Long> ids) {
        // 校验存在
        List<ReserveDO> reserves = validateReserveExists(ids);
        // 释放床位
        for (ReserveDO reserve : reserves) {
            buildingBedService.updateBedReserve(reserve.getBedId(), "0", null);
        }
        // 删除
        reserveMapper.deleteByIds(ids);
    }

    private List<ReserveDO> validateReserveExists(List<Long> ids) {
        List<ReserveDO> list = reserveMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(RESERVE_NOT_EXISTS);
        }
        return list;
    }

    private ReserveDO validateReserveExists(Long id) {
        ReserveDO reserve = reserveMapper.selectById(id);
        if (reserve == null) {
            throw exception(RESERVE_NOT_EXISTS);
        }
        return reserve;
    }

    @Override
    public ReserveDO getReserve(Long id) {
        return reserveMapper.selectById(id);
    }

    @Override
    public PageResult<ReserveDO> getReservePage(ReservePageReqVO pageReqVO) {
        return reserveMapper.selectPage(pageReqVO);
    }

}