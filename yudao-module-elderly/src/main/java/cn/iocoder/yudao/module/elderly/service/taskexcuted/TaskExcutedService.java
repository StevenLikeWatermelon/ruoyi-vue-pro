package cn.iocoder.yudao.module.elderly.service.taskexcuted;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.taskexcuted.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.taskexcuted.TaskExcutedDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 任务编排执行管理 Service 接口
 *
 * @author 护理一组组长
 */
public interface TaskExcutedService {

    /**
     * 创建任务编排执行管理
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTaskExcuted(@Valid TaskExcutedSaveReqVO createReqVO);

    /**
     * 更新任务编排执行管理
     *
     * @param updateReqVO 更新信息
     */
    void updateTaskExcuted(@Valid TaskExcutedSaveReqVO updateReqVO);

    /**
     * 删除任务编排执行管理
     *
     * @param id 编号
     */
    void deleteTaskExcuted(Long id);

    /**
    * 批量删除任务编排执行管理
    *
    * @param ids 编号
    */
    void deleteTaskExcutedListByIds(List<Long> ids);

    /**
     * 获得任务编排执行管理
     *
     * @param id 编号
     * @return 任务编排执行管理
     */
    TaskExcutedDO getTaskExcuted(Long id);

    /**
     * 获得任务编排执行管理分页
     *
     * @param pageReqVO 分页查询
     * @return 任务编排执行管理分页
     */
    PageResult<TaskExcutedDO> getTaskExcutedPage(TaskExcutedPageReqVO pageReqVO);

    /**
     * 更新任务编排执行管理的执行状态
     *
     * @param id 编号
     * @param status 执行状态
     */
    void updateExcutedStatus(Long id, Integer status);

}