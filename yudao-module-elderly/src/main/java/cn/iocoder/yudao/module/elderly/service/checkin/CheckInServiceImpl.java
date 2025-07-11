package cn.iocoder.yudao.module.elderly.service.checkin;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.checkin.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.checkin.CheckInDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.checkin.CheckInMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import cn.iocoder.yudao.module.bpm.api.task.BpmProcessInstanceApi;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * 老人入住信息 Service 实现类
 *
 * @author 沈文杰
 */
@Service
@Validated
public class CheckInServiceImpl implements CheckInService {

    @Resource
    private CheckInMapper checkInMapper;

    public static final String PROCESS_KEY = "elderly_check_in";

    @Resource
    private BpmProcessInstanceApi processInstanceApi;

    @Override
    public Long createCheckIn(CheckInSaveReqVO createReqVO) {
        // 插入
        CheckInDO checkIn = BeanUtils.toBean(createReqVO, CheckInDO.class);
        checkInMapper.insert(checkIn);

         // 发起 BPM 流程
        // 获取备注
        String note = createReqVO.getNotes();
        Map<String, Object> processInstanceVariables = new HashMap<>();
        // 获取当前用户
        Long userId = getLoginUserId();
        processInstanceVariables.put("note", note);
        String processInstanceId = processInstanceApi.createProcessInstance(userId,
                new BpmProcessInstanceCreateReqDTO().setProcessDefinitionKey(PROCESS_KEY)
                        .setVariables(processInstanceVariables).setBusinessKey(String.valueOf(checkIn.getId())));
         // 将工作流的编号 赋值给 checkIn
        checkIn.setProcessInstanceId(processInstanceId);
        // 返回
        return checkIn.getId();
    }

    @Override
    public void updateCheckIn(CheckInSaveReqVO updateReqVO) {
        // 校验存在
        validateCheckInExists(updateReqVO.getId());
        // 更新
        CheckInDO updateObj = BeanUtils.toBean(updateReqVO, CheckInDO.class);
        checkInMapper.updateById(updateObj);
    }

    @Override
    public void deleteCheckIn(Long id) {
        // 校验存在
        validateCheckInExists(id);
        // 删除
        checkInMapper.deleteById(id);
    }

    @Override
        public void deleteCheckInListByIds(List<Long> ids) {
        // 校验存在
        validateCheckInExists(ids);
        // 删除
        checkInMapper.deleteByIds(ids);
        }

    private void validateCheckInExists(List<Long> ids) {
        List<CheckInDO> list = checkInMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(CHECK_IN_NOT_EXISTS);
        }
    }

    private void validateCheckInExists(Long id) {
        if (checkInMapper.selectById(id) == null) {
            throw exception(CHECK_IN_NOT_EXISTS);
        }
    }

    @Override
    public CheckInDO getCheckIn(Long id) {
        return checkInMapper.selectById(id);
    }

    @Override
    public PageResult<CheckInDO> getCheckInPage(CheckInPageReqVO pageReqVO) {
        return checkInMapper.selectPage(pageReqVO);
    }

}