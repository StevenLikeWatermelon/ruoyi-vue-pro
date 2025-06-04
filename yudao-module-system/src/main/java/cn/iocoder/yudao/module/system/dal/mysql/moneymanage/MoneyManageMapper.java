package cn.iocoder.yudao.module.system.dal.mysql.moneymanage;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.moneymanage.MoneyManageDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.moneymanage.vo.*;

/**
 * 基础费用管理 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MoneyManageMapper extends BaseMapperX<MoneyManageDO> {

    default PageResult<MoneyManageDO> selectPage(MoneyManagePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MoneyManageDO>()
                .likeIfPresent(MoneyManageDO::getName, reqVO.getName())
                .eqIfPresent(MoneyManageDO::getCode, reqVO.getCode())
                .eqIfPresent(MoneyManageDO::getChargeWay, reqVO.getChargeWay())
                .eqIfPresent(MoneyManageDO::getRefund, reqVO.getRefund())
                .eqIfPresent(MoneyManageDO::getStatus, reqVO.getStatus())
                .eqIfPresent(MoneyManageDO::getAmount, reqVO.getAmount())
                .eqIfPresent(MoneyManageDO::getDescription, reqVO.getDescription())
                .betweenIfPresent(MoneyManageDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MoneyManageDO::getId));
    }

}