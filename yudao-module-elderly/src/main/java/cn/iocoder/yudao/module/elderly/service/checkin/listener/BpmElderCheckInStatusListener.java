package cn.iocoder.yudao.module.elderly.service.checkin.listener;

import cn.iocoder.yudao.module.bpm.api.event.BpmProcessInstanceStatusEvent;
import cn.iocoder.yudao.module.bpm.api.event.BpmProcessInstanceStatusEventListener;
import cn.iocoder.yudao.module.elderly.service.checkin.CheckInService;
import cn.iocoder.yudao.module.elderly.service.checkin.CheckInServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BpmElderCheckInStatusListener extends BpmProcessInstanceStatusEventListener {

    @Resource
    private CheckInService checkInService;

    @Override
    protected String getProcessDefinitionKey() {
        return CheckInServiceImpl.PROCESS_KEY;
    }

    @Override
    protected void onEvent(BpmProcessInstanceStatusEvent event) {
        // 打印触发了
        System.out.println("打印触发了");
        checkInService.updateCheckInStatus(Long.parseLong(event.getBusinessKey()), event.getStatus());
    }

}
