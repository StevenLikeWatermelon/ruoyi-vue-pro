package cn.iocoder.yudao.module.elderly.service.feesoverview;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.module.elderly.controller.admin.feesoperaterecord.vo.FeesOperateRecordSaveReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.feesoverview.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesoverview.FeesOverviewDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.feesoverview.FeesOverviewMapper;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import cn.iocoder.yudao.module.elderly.service.infobasic.InfoBasicService;
import cn.iocoder.yudao.module.elderly.dal.dataobject.infobasic.InfoBasicDO;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;
import cn.iocoder.yudao.module.elderly.service.feesoperaterecord.FeesOperateRecordService;
import cn.iocoder.yudao.module.elderly.service.feesoverview.FeesOverviewService;

/**
 * 老人费用余额 Service 实现类
 *
 * @author 护理一组组长
 */
@Service
@Validated
public class FeesOverviewServiceImpl implements FeesOverviewService {

    @Resource
    private FeesOverviewMapper feesOverviewMapper;

    @Resource
    private AdminUserApi adminUserApi;

    @Resource
    private InfoBasicService infoBasicService;

    @Resource
    private FeesOperateRecordService feesOperateRecordService;


    @Override
    public Long createFeesOverview(FeesOverviewSaveReqVO createReqVO) {
        // 插入
        FeesOverviewDO feesOverview = BeanUtils.toBean(createReqVO, FeesOverviewDO.class);
        // 用getFeesOverview校验老人是否存在
        FeesOverviewDO feesOverviewExist = getFeesOverview(createReqVO.getElderlyId());
        if (feesOverviewExist != null) {
            throw exception(FEES_OVERVIEW_EXISTS);
        }
        // 插入id就以elderlyId
        feesOverview.setId(createReqVO.getElderlyId());
        feesOverviewMapper.insert(feesOverview);
        // 返回
        return feesOverview.getId();
    }

    @Override
    public void updateFeesOverview(FeesOverviewSaveReqVO updateReqVO) {
        // 调用feesoperaterecord中的createFeesOperateRecord方法，创建费用操作记录
        FeesOperateRecordSaveReqVO feesOperateRecordSaveReqVO = new FeesOperateRecordSaveReqVO();
        feesOperateRecordSaveReqVO.setElderlyId(updateReqVO.getElderlyId());
        feesOperateRecordSaveReqVO.setRemark(updateReqVO.getRemark());
        
        // 如果接口入参里有addBalance，说明是新增金额，要把addBalance加到balance上，然后更新balance
        if (updateReqVO.getAddBalance() != null) {
            feesOperateRecordSaveReqVO.setOperateType("add");
            feesOperateRecordSaveReqVO.setOperateAmount(updateReqVO.getAddBalance());
            // 创建记录
            feesOperateRecordService.createFeesOperateRecord(feesOperateRecordSaveReqVO);
            updateReqVO.setBalance(updateReqVO.getBalance().add(updateReqVO.getAddBalance()));
            updateReqVO.setAddBalance(null);
        }else if (updateReqVO.getSubBalance() != null) {
            feesOperateRecordSaveReqVO.setOperateType("sub");
            feesOperateRecordSaveReqVO.setOperateAmount(updateReqVO.getSubBalance());
            // 创建记录
            feesOperateRecordService.createFeesOperateRecord(feesOperateRecordSaveReqVO);
            updateReqVO.setBalance(updateReqVO.getBalance().subtract(updateReqVO.getSubBalance()));
            updateReqVO.setSubBalance(null);
        }
        // 校验存在
        validateFeesOverviewExists(updateReqVO.getId());
        // 更新
        FeesOverviewDO updateObj = BeanUtils.toBean(updateReqVO, FeesOverviewDO.class);
        feesOverviewMapper.updateById(updateObj);
    }

    @Override
    public void deleteFeesOverview(Long id) {
        // 校验存在
        validateFeesOverviewExists(id);
        // 删除
        feesOverviewMapper.deleteById(id);
    }

    @Override
        public void deleteFeesOverviewListByIds(List<Long> ids) {
        // 校验存在
        validateFeesOverviewExists(ids);
        // 删除
        feesOverviewMapper.deleteByIds(ids);
        }

    private void validateFeesOverviewExists(List<Long> ids) {
        List<FeesOverviewDO> list = feesOverviewMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(FEES_OVERVIEW_NOT_EXISTS);
        }
    }

    private void validateFeesOverviewExists(Long id) {
        if (feesOverviewMapper.selectById(id) == null) {
            throw exception(FEES_OVERVIEW_NOT_EXISTS);
        }
    }

    @Override
    public FeesOverviewDO getFeesOverview(Long id) {
        return feesOverviewMapper.selectById(id);
    }

    @Override
    public PageResult<FeesOverviewDO> getFeesOverviewPage(FeesOverviewPageReqVO pageReqVO) {
        return feesOverviewMapper.selectPage(pageReqVO);
    }

}