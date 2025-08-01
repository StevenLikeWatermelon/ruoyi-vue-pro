package cn.iocoder.yudao.module.elderly.dal.mysql.taskinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.taskinfo.TaskInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.taskinfo.vo.*;

/**
 * 任务信息管理 Mapper
 *
 * @author 护理一组组长
 */
@Mapper
public interface TaskInfoMapper extends BaseMapperX<TaskInfoDO> {

    default PageResult<TaskInfoDO> selectPage(TaskInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TaskInfoDO>()
                .eqIfPresent(TaskInfoDO::getId, reqVO.getId())
                .likeIfPresent(TaskInfoDO::getName, reqVO.getName())
                .eqIfPresent(TaskInfoDO::getType, reqVO.getType())
                .betweenIfPresent(TaskInfoDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(TaskInfoDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(TaskInfoDO::getNodeId, reqVO.getNodeId())
                .eqIfPresent(TaskInfoDO::getExecuteId, reqVO.getExecuteId())
                .eqIfPresent(TaskInfoDO::getStatus, reqVO.getStatus())
                .eqIfPresent(TaskInfoDO::getServiceCustomer, reqVO.getServiceCustomer())
                .eqIfPresent(TaskInfoDO::getRemark, reqVO.getRemark())
                .eqIfPresent(TaskInfoDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(TaskInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TaskInfoDO::getId));
    }

}