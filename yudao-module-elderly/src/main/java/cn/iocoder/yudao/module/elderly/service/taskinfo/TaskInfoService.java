package cn.iocoder.yudao.module.elderly.service.taskinfo;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.taskinfo.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.taskinfo.TaskInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 任务信息管理 Service 接口
 *
 * @author 护理一组组长
 */
public interface TaskInfoService {

    /**
     * 创建任务信息管理
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTaskInfo(@Valid TaskInfoSaveReqVO createReqVO);

    /**
     * 更新任务信息管理
     *
     * @param updateReqVO 更新信息
     */
    void updateTaskInfo(@Valid TaskInfoSaveReqVO updateReqVO);

    /**
     * 删除任务信息管理
     *
     * @param id 编号
     */
    void deleteTaskInfo(Long id);

    /**
    * 批量删除任务信息管理
    *
    * @param ids 编号
    */
    void deleteTaskInfoListByIds(List<Long> ids);

    /**
     * 获得任务信息管理
     *
     * @param id 编号
     * @return 任务信息管理
     */
    TaskInfoDO getTaskInfo(Long id);

    /**
     * 获得任务信息管理分页
     *
     * @param pageReqVO 分页查询
     * @return 任务信息管理分页
     */
    PageResult<TaskInfoDO> getTaskInfoPage(TaskInfoPageReqVO pageReqVO);

}