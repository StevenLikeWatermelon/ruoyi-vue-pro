package cn.iocoder.yudao.module.elderly.controller.admin.reserve.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 预约登记分页 Request VO")
@Data
public class ReservePageReqVO extends PageParam {

    @Schema(description = "咨询人姓名", example = "赵六")
    private String consultantName;

    @Schema(description = "咨询日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] consultationDate;

    @Schema(description = "老人姓名", example = "张三")
    private String elderlyName;

    @Schema(description = "咨询意向")
    private String consultationIntention;

    @Schema(description = "媒介渠道")
    private String mediaChannel;

    @Schema(description = "推荐人")
    private String referrer;

    @Schema(description = "创建者")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "计划入住时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] plannedCheckinTime;

    @Schema(description = "老人编号", example = "1024")
    private Long elderlyId;

}