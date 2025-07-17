package cn.iocoder.yudao.module.elderly.dal.mysql.taskexcuted;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.taskexcuted.TaskExcutedDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.taskexcuted.vo.*;

/**
 * 任务编排执行管理 Mapper
 *
 * @author 护理一组组长
 */
@Mapper
public interface TaskExcutedMapper extends BaseMapperX<TaskExcutedDO> {

    default PageResult<TaskExcutedDO> selectPage(TaskExcutedPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TaskExcutedDO>()
                .eqIfPresent(TaskExcutedDO::getId, reqVO.getId())
                .likeIfPresent(TaskExcutedDO::getName, reqVO.getName())
                .betweenIfPresent(TaskExcutedDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(TaskExcutedDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(TaskExcutedDO::getStatus, reqVO.getStatus())
                .eqIfPresent(TaskExcutedDO::getAssignee, reqVO.getAssignee())
                .eqIfPresent(TaskExcutedDO::getAssigneeName, reqVO.getAssigneeName())
                .eqIfPresent(TaskExcutedDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(TaskExcutedDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TaskExcutedDO::getId));
    }

}