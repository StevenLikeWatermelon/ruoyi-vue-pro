package cn.iocoder.yudao.module.elderly.service.feesoverview;

import cn.hutool.core.collection.CollUtil;
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

    @Override
    public Long createFeesOverview(FeesOverviewSaveReqVO createReqVO) {
        // 插入
        FeesOverviewDO feesOverview = BeanUtils.toBean(createReqVO, FeesOverviewDO.class);
        feesOverviewMapper.insert(feesOverview);
        // 返回
        return feesOverview.getId();
    }

    @Override
    public void updateFeesOverview(FeesOverviewSaveReqVO updateReqVO) {
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