package cn.iocoder.yudao.module.elderly.dal.mysql.tasknode;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.tasknode.TaskNodeDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.tasknode.vo.*;

/**
 * 任务节点管理 Mapper
 *
 * @author 护理一组组长
 */
@Mapper
public interface TaskNodeMapper extends BaseMapperX<TaskNodeDO> {

    default PageResult<TaskNodeDO> selectPage(TaskNodePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TaskNodeDO>()
                .eqIfPresent(TaskNodeDO::getId, reqVO.getId())
                .likeIfPresent(TaskNodeDO::getName, reqVO.getName())
                .betweenIfPresent(TaskNodeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TaskNodeDO::getId));
    }

}