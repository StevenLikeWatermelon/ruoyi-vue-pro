package cn.iocoder.yudao.module.elderly.dal.mysql.feesdailyconsumpt;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesdailyconsumpt.FeesDailyConsumptDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.feesdailyconsumpt.vo.*;

/**
 * 日常消费 Mapper
 *
 * @author 沈文杰
 */
@Mapper
public interface FeesDailyConsumptMapper extends BaseMapperX<FeesDailyConsumptDO> {

    default PageResult<FeesDailyConsumptDO> selectPage(FeesDailyConsumptPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FeesDailyConsumptDO>()
                .eqIfPresent(FeesDailyConsumptDO::getId, reqVO.getId())
                .eqIfPresent(FeesDailyConsumptDO::getOperateType, reqVO.getOperateType())
                .eqIfPresent(FeesDailyConsumptDO::getConsumptIdList, reqVO.getConsumptIdList())
                .eqIfPresent(FeesDailyConsumptDO::getConsumptMoneyList, reqVO.getConsumptMoneyList())
                .eqIfPresent(FeesDailyConsumptDO::getTotalMoney, reqVO.getTotalMoney())
                .eqIfPresent(FeesDailyConsumptDO::getRemark, reqVO.getRemark())
                .eqIfPresent(FeesDailyConsumptDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(FeesDailyConsumptDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FeesDailyConsumptDO::getId));
    }

}