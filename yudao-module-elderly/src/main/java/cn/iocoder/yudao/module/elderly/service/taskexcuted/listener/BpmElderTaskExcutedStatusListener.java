package cn.iocoder.yudao.module.elderly.service.taskexcuted.listener;

import cn.iocoder.yudao.module.bpm.api.event.BpmProcessInstanceStatusEvent;
import cn.iocoder.yudao.module.bpm.api.event.BpmProcessInstanceStatusEventListener;
import cn.iocoder.yudao.module.elderly.service.taskexcuted.TaskExcutedService;
import cn.iocoder.yudao.module.elderly.service.taskexcuted.TaskExcutedServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BpmElderTaskExcutedStatusListener extends BpmProcessInstanceStatusEventListener {

    @Resource
    private TaskExcutedService taskExcutedService;

    @Override
    protected String getProcessDefinitionKey() {
        return TaskExcutedServiceImpl.PROCESS_KEY;
    }

    @Override
    protected void onEvent(BpmProcessInstanceStatusEvent event) {
        // 打印触发了
        System.out.println("打印触发了excutedStatus");
        taskExcutedService.updateExcutedStatus(Long.parseLong(event.getBusinessKey()), event.getStatus());
    }

}
