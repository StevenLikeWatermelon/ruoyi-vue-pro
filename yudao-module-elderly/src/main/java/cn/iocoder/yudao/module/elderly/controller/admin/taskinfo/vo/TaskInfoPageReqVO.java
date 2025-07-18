package cn.iocoder.yudao.module.elderly.controller.admin.taskinfo.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 任务信息管理分页 Request VO")
@Data
public class TaskInfoPageReqVO extends PageParam {

    @Schema(description = "编号", example = "299")
    private Long id;

    @Schema(description = "任务名称", example = "张三")
    private String name;

    @Schema(description = "任务类型", example = "1")
    private String type;

    @Schema(description = "任务开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] startTime;

    @Schema(description = "任务结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] endTime;

    @Schema(description = "任务关联的节点id", example = "13658")
    private Long nodeId;

    @Schema(description = "任务执行id")
    private Long executeId;

    @Schema(description = "任务服务客户")
    private String serviceCustomer;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

    @Schema(description = "创建者")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}