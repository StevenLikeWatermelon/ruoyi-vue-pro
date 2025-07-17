package cn.iocoder.yudao.module.elderly.service.taskexcuted;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.taskexcuted.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.taskexcuted.TaskExcutedDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.taskexcuted.TaskExcutedMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;

/**
 * 任务编排执行管理 Service 实现类
 *
 * @author 护理一组组长
 */
@Service
@Validated
public class TaskExcutedServiceImpl implements TaskExcutedService {

    @Resource
    private TaskExcutedMapper taskExcutedMapper;

    @Override
    public Long createTaskExcuted(TaskExcutedSaveReqVO createReqVO) {
        // 插入，且插入时的状态status一定是未分配，// 0: '未分配',0: '已分配未执行',1: '已执行未完成',2: '已完成'
        createReqVO.setStatus("0");
        TaskExcutedDO taskExcuted = BeanUtils.toBean(createReqVO, TaskExcutedDO.class);
        taskExcutedMapper.insert(taskExcuted);
        // 返回
        return taskExcuted.getId();
    }

    @Override
    public void updateTaskExcuted(TaskExcutedSaveReqVO updateReqVO) {
        // 校验存在
        validateTaskExcutedExists(updateReqVO.getId());
        // 更新
        TaskExcutedDO updateObj = BeanUtils.toBean(updateReqVO, TaskExcutedDO.class);
        taskExcutedMapper.updateById(updateObj);
    }

    @Override
    public void deleteTaskExcuted(Long id) {
        // 校验存在
        validateTaskExcutedExists(id);
        // 删除
        taskExcutedMapper.deleteById(id);
    }

    @Override
        public void deleteTaskExcutedListByIds(List<Long> ids) {
        // 校验存在
        validateTaskExcutedExists(ids);
        // 删除
        taskExcutedMapper.deleteByIds(ids);
        }

    private void validateTaskExcutedExists(List<Long> ids) {
        List<TaskExcutedDO> list = taskExcutedMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(TASK_EXCUTED_NOT_EXISTS);
        }
    }

    private void validateTaskExcutedExists(Long id) {
        if (taskExcutedMapper.selectById(id) == null) {
            throw exception(TASK_EXCUTED_NOT_EXISTS);
        }
    }

    @Override
    public TaskExcutedDO getTaskExcuted(Long id) {
        return taskExcutedMapper.selectById(id);
    }

    @Override
    public PageResult<TaskExcutedDO> getTaskExcutedPage(TaskExcutedPageReqVO pageReqVO) {
        return taskExcutedMapper.selectPage(pageReqVO);
    }

}