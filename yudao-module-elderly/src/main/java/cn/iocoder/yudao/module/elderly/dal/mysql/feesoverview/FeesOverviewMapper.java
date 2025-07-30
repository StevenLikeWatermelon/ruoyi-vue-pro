package cn.iocoder.yudao.module.elderly.dal.mysql.feesoverview;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesoverview.FeesOverviewDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.feesoverview.vo.*;

/**
 * 老人费用余额 Mapper
 *
 * @author 护理一组组长
 */
@Mapper
public interface FeesOverviewMapper extends BaseMapperX<FeesOverviewDO> {

    default PageResult<FeesOverviewDO> selectPage(FeesOverviewPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FeesOverviewDO>()
                .eqIfPresent(FeesOverviewDO::getId, reqVO.getId())
                .eqIfPresent(FeesOverviewDO::getElderlyId, reqVO.getElderlyId())
                .eqIfPresent(FeesOverviewDO::getBalance, reqVO.getBalance())
                .eqIfPresent(FeesOverviewDO::getRemark, reqVO.getRemark())
                .eqIfPresent(FeesOverviewDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(FeesOverviewDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(FeesOverviewDO::getUpdater, reqVO.getUpdater())
                .betweenIfPresent(FeesOverviewDO::getUpdateTime, reqVO.getUpdateTime())
                .orderByDesc(FeesOverviewDO::getId));
    }

}