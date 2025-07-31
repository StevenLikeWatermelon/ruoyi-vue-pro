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
import cn.iocoder.yudao.module.elderly.service.feesdailyconsumpt.FeesDailyConsumptService;
import cn.iocoder.yudao.module.elderly.service.feesoverview.FeesOverviewService;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesdailyconsumpt.FeesDailyConsumptDO;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesoverview.FeesOverviewDO;
import cn.iocoder.yudao.module.elderly.controller.admin.feesoverview.vo.FeesOverviewSaveReqVO;
import java.math.BigDecimal;

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
    @Resource
    private FeesDailyConsumptService feesDailyConsumptService;
    @Resource
    private FeesOverviewService feesOverviewService;

    public static final String PROCESS_KEY = "elderly_check_in";

    @Resource
    private BpmProcessInstanceApi processInstanceApi;

    @Override
    public Long createCheckIn(CheckInSaveReqVO createReqVO) {
        // 获取createReqVO中的visitorName。作为老人标记elderlyId
        Long elderlyId = createReqVO.getVisitorName();
        // 老人的id就是id
        CheckInDO checkInDO = getCheckIn(elderlyId);
        // 打印checkInDO
        System.out.println("checkInDO");
        System.out.println(checkInDO);
        // 校验checkInDO是否存在
        if (checkInDO != null) {
            throw exception(CHECK_IN_EXISTS);
        }
        createReqVO.setId(elderlyId);
        // 获取createReqVO里面的dailyConsumptId
        String dailyConsumptId = createReqVO.getDailyConsumptId();
        // 打印dailyConsumptId
        System.out.println("dailyConsumptId");
        System.out.println(dailyConsumptId);
        // dailyConsumptId转化为数字
        Long dailyConsumptIdLong = Long.valueOf(dailyConsumptId);
        // 获取feesDailyConsumptDO中的totalMoney
        FeesDailyConsumptDO feesDailyConsumptDO = feesDailyConsumptService.getFeesDailyConsumpt(dailyConsumptIdLong);
        BigDecimal totalMoney = feesDailyConsumptDO.getTotalMoney();
        // 打印totalMoney
        System.out.println("totalMoney");
        System.out.println(totalMoney);
        // 获取createReqVO中的overviewId
        FeesOverviewDO feesOverview = feesOverviewService.getFeesOverview(elderlyId);
        // 先校验余额是否存在
        if (feesOverview == null) {
            throw exception(FEES_OVERVIEW_NOT_EXISTS);
        }
        long overviewId = feesOverview.getId();
        BigDecimal balance = feesOverview.getBalance();

        System.out.println("balance");
        System.out.println(balance);
        // 调用feesOverviewController中updateFeesOverview方法，更新余额，设置addBalance为null，subBalance为totalMoney，remark为"老人入住扣除"
        FeesOverviewSaveReqVO feesOverviewSaveReqVO = new FeesOverviewSaveReqVO();
        feesOverviewSaveReqVO.setId(overviewId);
        feesOverviewSaveReqVO.setElderlyId(elderlyId);
        feesOverviewSaveReqVO.setBalance(balance);
        feesOverviewSaveReqVO.setAddBalance(null);
        feesOverviewSaveReqVO.setSubBalance(totalMoney);
        feesOverviewSaveReqVO.setRemark("老人入住扣除");
        feesOverviewService.updateFeesOverview(feesOverviewSaveReqVO);
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
        // 打印processInstanceId
        System.out.println(processInstanceId);
        // 将工作流的编号，更新到老人入住订单中
        checkInMapper.updateById(new CheckInDO().setId(checkIn.getId()).setProcessInstanceId(processInstanceId));
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
        CheckInDO checkInDO = checkInMapper.selectById(id);
        // 用getCheckIn，根据id获取status
        CheckInDO checkIn = getCheckIn(id);
        String status = checkIn.getStatus();
        String processInstanceId = checkIn.getProcessInstanceId();
        // 打印status
        System.out.println("processInstanceId");
        System.out.println(processInstanceId);
        System.out.println(status);
        if (status != null) {
            throw exception(CHECK_IN_STATUS_ERROR);
        } else {
            // 获取当前用户
            Long userId = getLoginUserId();
            processInstanceApi.cancelProcessInstance(userId, processInstanceId, "取消入住");
            // 删除
            checkInMapper.deleteById(id);
        }
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

    @Override
    public void updateCheckInStatus(Long id, Integer status) {
        // 校验存在
        validateCheckInExists(id);
        // 更新状态
        CheckInDO updateObj = new CheckInDO();
        updateObj.setId(id);
        updateObj.setStatus(String.valueOf(status));
        checkInMapper.updateById(updateObj);
    }

}