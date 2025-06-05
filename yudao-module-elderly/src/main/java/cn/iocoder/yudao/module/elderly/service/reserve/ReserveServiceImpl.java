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

    @Override
    public Long createReserve(ReserveSaveReqVO createReqVO) {
        // 插入
        ReserveDO reserve = BeanUtils.toBean(createReqVO, ReserveDO.class);
        reserveMapper.insert(reserve);
        // 返回
        return reserve.getId();
    }

    @Override
    public void updateReserve(ReserveSaveReqVO updateReqVO) {
        // 校验存在
        validateReserveExists(updateReqVO.getId());
        // 更新
        ReserveDO updateObj = BeanUtils.toBean(updateReqVO, ReserveDO.class);
        reserveMapper.updateById(updateObj);
    }

    @Override
    public void deleteReserve(Long id) {
        // 校验存在
        validateReserveExists(id);
        // 删除
        reserveMapper.deleteById(id);
    }

    @Override
        public void deleteReserveListByIds(List<Long> ids) {
        // 校验存在
        validateReserveExists(ids);
        // 删除
        reserveMapper.deleteByIds(ids);
        }

    private void validateReserveExists(List<Long> ids) {
        List<ReserveDO> list = reserveMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(RESERVE_NOT_EXISTS);
        }
    }

    private void validateReserveExists(Long id) {
        if (reserveMapper.selectById(id) == null) {
            throw exception(RESERVE_NOT_EXISTS);
        }
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