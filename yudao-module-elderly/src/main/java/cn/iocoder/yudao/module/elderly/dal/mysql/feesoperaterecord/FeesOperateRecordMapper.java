package cn.iocoder.yudao.module.elderly.dal.mysql.feesoperaterecord;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesoperaterecord.FeesOperateRecordDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.feesoperaterecord.vo.*;

/**
 * 费用操作记录 Mapper
 *
 * @author 沈文杰
 */
@Mapper
public interface FeesOperateRecordMapper extends BaseMapperX<FeesOperateRecordDO> {

    default PageResult<FeesOperateRecordDO> selectPage(FeesOperateRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FeesOperateRecordDO>()
                .eqIfPresent(FeesOperateRecordDO::getOperateType, reqVO.getOperateType())
                .eqIfPresent(FeesOperateRecordDO::getOperateAmount, reqVO.getOperateAmount())
                .eqIfPresent(FeesOperateRecordDO::getElderlyId, reqVO.getElderlyId())
                .eqIfPresent(FeesOperateRecordDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(FeesOperateRecordDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FeesOperateRecordDO::getId));
    }

}