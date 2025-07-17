package cn.iocoder.yudao.module.elderly.service.tasknode;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.tasknode.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.tasknode.TaskNodeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.tasknode.TaskNodeMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;

/**
 * 任务节点管理 Service 实现类
 *
 * @author 护理一组组长
 */
@Service
@Validated
public class TaskNodeServiceImpl implements TaskNodeService {

    @Resource
    private TaskNodeMapper taskNodeMapper;

    @Override
    public Long createTaskNode(TaskNodeSaveReqVO createReqVO) {
        // 插入
        TaskNodeDO taskNode = BeanUtils.toBean(createReqVO, TaskNodeDO.class);
        taskNodeMapper.insert(taskNode);
        // 返回
        return taskNode.getId();
    }

    @Override
    public void updateTaskNode(TaskNodeSaveReqVO updateReqVO) {
        // 校验存在
        validateTaskNodeExists(updateReqVO.getId());
        // 更新
        TaskNodeDO updateObj = BeanUtils.toBean(updateReqVO, TaskNodeDO.class);
        taskNodeMapper.updateById(updateObj);
    }

    @Override
    public void deleteTaskNode(Long id) {
        // 校验存在
        validateTaskNodeExists(id);
        // 删除
        taskNodeMapper.deleteById(id);
    }

    @Override
        public void deleteTaskNodeListByIds(List<Long> ids) {
        // 校验存在
        validateTaskNodeExists(ids);
        // 删除
        taskNodeMapper.deleteByIds(ids);
        }

    private void validateTaskNodeExists(List<Long> ids) {
        List<TaskNodeDO> list = taskNodeMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(TASK_NODE_NOT_EXISTS);
        }
    }

    private void validateTaskNodeExists(Long id) {
        if (taskNodeMapper.selectById(id) == null) {
            throw exception(TASK_NODE_NOT_EXISTS);
        }
    }

    @Override
    public TaskNodeDO getTaskNode(Long id) {
        return taskNodeMapper.selectById(id);
    }

    @Override
    public PageResult<TaskNodeDO> getTaskNodePage(TaskNodePageReqVO pageReqVO) {
        return taskNodeMapper.selectPage(pageReqVO);
    }

}