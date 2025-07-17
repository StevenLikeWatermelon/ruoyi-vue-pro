package cn.iocoder.yudao.module.elderly.service.tasknode;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.tasknode.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.tasknode.TaskNodeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 任务节点管理 Service 接口
 *
 * @author 护理一组组长
 */
public interface TaskNodeService {

    /**
     * 创建任务节点管理
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTaskNode(@Valid TaskNodeSaveReqVO createReqVO);

    /**
     * 更新任务节点管理
     *
     * @param updateReqVO 更新信息
     */
    void updateTaskNode(@Valid TaskNodeSaveReqVO updateReqVO);

    /**
     * 删除任务节点管理
     *
     * @param id 编号
     */
    void deleteTaskNode(Long id);

    /**
    * 批量删除任务节点管理
    *
    * @param ids 编号
    */
    void deleteTaskNodeListByIds(List<Long> ids);

    /**
     * 获得任务节点管理
     *
     * @param id 编号
     * @return 任务节点管理
     */
    TaskNodeDO getTaskNode(Long id);

    /**
     * 获得任务节点管理分页
     *
     * @param pageReqVO 分页查询
     * @return 任务节点管理分页
     */
    PageResult<TaskNodeDO> getTaskNodePage(TaskNodePageReqVO pageReqVO);

}