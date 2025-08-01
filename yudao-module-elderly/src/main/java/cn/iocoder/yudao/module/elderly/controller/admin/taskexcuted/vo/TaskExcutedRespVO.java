package cn.iocoder.yudao.module.elderly.controller.admin.taskexcuted.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 任务编排执行管理 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TaskExcutedRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "10731")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "任务名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("任务名称")
    private String name;

    @Schema(description = "任务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "任务类型", converter = DictConvert.class)
    @DictFormat("stuff_daily_task") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String type;

    @Schema(description = "执行开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("执行开始时间")
    private String startTime;

    @Schema(description = "执行结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("执行结束时间")
    private String endTime;

    @Schema(description = "执行状态", example = "2")
    @ExcelProperty("执行状态")
    private String excutedStatus;

    @Schema(description = "审批状态")
    @ExcelProperty("审批状态")
    private Integer status;

    @Schema(description = "执行负责人")
    @ExcelProperty("执行负责人")
    private String assignee;

    @Schema(description = "执行负责人名称")
    @ExcelProperty("执行负责人名称")
    private String assigneeName;

    @Schema(description = "备注", example = "你说的对")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "任务内容", example = "你说的对")
    @ExcelProperty("任务内容")
    private String content;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}