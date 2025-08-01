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
import cn.iocoder.yudao.module.bpm.api.task.BpmProcessInstanceApi;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;
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

    @Resource
    private BpmProcessInstanceApi processInstanceApi;

    public static final String PROCESS_KEY = "elderly_task_excuted_modal";

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
        String status = updateReqVO.getStatus();
        // 如果status为completed，表示任务执行完成，下面异步发送给领导审批
        if (status.equals("completed")) {
            String name = updateReqVO.getName();
            // 发起 BPM 流程
            Map<String, Object> processInstanceVariables = new HashMap<>();
            // 获取当前用户
            Long userId = getLoginUserId();
            processInstanceVariables.put("note", name);
            String processInstanceId = processInstanceApi.createProcessInstance(userId,
                    new BpmProcessInstanceCreateReqDTO().setProcessDefinitionKey(PROCESS_KEY)
                            .setVariables(processInstanceVariables).setBusinessKey(String.valueOf(updateReqVO.getId())));
            // 打印processInstanceId
            System.out.println(processInstanceId);
            // 将工作流的编号，更新到老人入住订单中
            taskExcutedMapper.updateById(new TaskExcutedDO().setId(updateReqVO.getId()).setProcessInstanceId(processInstanceId));
        }
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