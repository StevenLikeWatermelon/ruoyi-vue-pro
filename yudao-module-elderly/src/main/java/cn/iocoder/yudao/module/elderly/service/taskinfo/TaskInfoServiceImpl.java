package cn.iocoder.yudao.module.elderly.service.taskinfo;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.taskinfo.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.taskinfo.TaskInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.taskinfo.TaskInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;

/**
 * 任务信息管理 Service 实现类
 *
 * @author 护理一组组长
 */
@Service
@Validated
public class TaskInfoServiceImpl implements TaskInfoService {

    @Resource
    private TaskInfoMapper taskInfoMapper;

    @Override
    public Long createTaskInfo(TaskInfoSaveReqVO createReqVO) {
        // 插入
        TaskInfoDO taskInfo = BeanUtils.toBean(createReqVO, TaskInfoDO.class);
        taskInfoMapper.insert(taskInfo);
        // 返回
        return taskInfo.getId();
    }

    @Override
    public void updateTaskInfo(TaskInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateTaskInfoExists(updateReqVO.getId());
        // 更新
        TaskInfoDO updateObj = BeanUtils.toBean(updateReqVO, TaskInfoDO.class);
        taskInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteTaskInfo(Long id) {
        // 校验存在
        validateTaskInfoExists(id);
        // 删除
        taskInfoMapper.deleteById(id);
    }

    @Override
        public void deleteTaskInfoListByIds(List<Long> ids) {
        // 校验存在
        validateTaskInfoExists(ids);
        // 删除
        taskInfoMapper.deleteByIds(ids);
        }

    private void validateTaskInfoExists(List<Long> ids) {
        List<TaskInfoDO> list = taskInfoMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(TASK_INFO_NOT_EXISTS);
        }
    }

    private void validateTaskInfoExists(Long id) {
        if (taskInfoMapper.selectById(id) == null) {
            throw exception(TASK_INFO_NOT_EXISTS);
        }
    }

    @Override
    public TaskInfoDO getTaskInfo(Long id) {
        return taskInfoMapper.selectById(id);
    }

    @Override
    public PageResult<TaskInfoDO> getTaskInfoPage(TaskInfoPageReqVO pageReqVO) {
        return taskInfoMapper.selectPage(pageReqVO);
    }

}