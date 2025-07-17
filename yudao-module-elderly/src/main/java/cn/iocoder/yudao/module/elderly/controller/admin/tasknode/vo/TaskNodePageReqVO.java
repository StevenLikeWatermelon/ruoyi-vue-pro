package cn.iocoder.yudao.module.elderly.controller.admin.tasknode.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 任务节点管理分页 Request VO")
@Data
public class TaskNodePageReqVO extends PageParam {

    @Schema(description = "编号", example = "3300")
    private Long id;

    @Schema(description = "节点名称", example = "李四")
    private String name;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}