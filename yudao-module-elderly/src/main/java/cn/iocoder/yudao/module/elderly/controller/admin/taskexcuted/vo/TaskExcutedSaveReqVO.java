package cn.iocoder.yudao.module.elderly.controller.admin.taskexcuted.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 任务编排执行管理新增/修改 Request VO")
@Data
public class TaskExcutedSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "10731")
    private Long id;

    @Schema(description = "任务名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "任务名称不能为空")
    private String name;

    @Schema(description = "任务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "任务类型不能为空")
    private String type;

    @Schema(description = "任务内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "任务内容不能为空")
    private String content;

    @Schema(description = "执行开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "执行开始时间不能为空")
    private String startTime;

    @Schema(description = "执行结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "执行结束时间不能为空")
    private String endTime;

    @Schema(description = "执行状态", example = "2")
    private String excutedStatus;

    @Schema(description = "执行负责人")
    private String assignee;

    @Schema(description = "执行负责人名称")
    private String assigneeName;

    @Schema(description = "关联的任务信息id", example = "13568")
    private String taskInfoId;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

    @Schema(description = "执行负责人名称")
    private String processInstanceId;
}