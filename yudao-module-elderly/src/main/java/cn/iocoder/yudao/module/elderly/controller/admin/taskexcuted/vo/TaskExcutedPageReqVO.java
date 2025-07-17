package cn.iocoder.yudao.module.elderly.controller.admin.taskexcuted.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 任务编排执行管理分页 Request VO")
@Data
public class TaskExcutedPageReqVO extends PageParam {

    @Schema(description = "编号", example = "10731")
    private Long id;

    @Schema(description = "任务名称", example = "李四")
    private String name;

    @Schema(description = "执行开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] startTime;

    @Schema(description = "执行结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] endTime;

    @Schema(description = "执行状态", example = "2")
    private String status;

    @Schema(description = "执行负责人")
    private String assignee;
    
    @Schema(description = "执行负责人名称")
    private String assigneeName;

    @Schema(description = "创建者")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}