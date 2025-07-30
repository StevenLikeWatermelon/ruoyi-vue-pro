package cn.iocoder.yudao.module.elderly.controller.admin.feesoperaterecord.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 费用操作记录分页 Request VO")
@Data
public class FeesOperateRecordPageReqVO extends PageParam {

    @Schema(description = "操作类型", example = "2")
    private String operateType;

    @Schema(description = "操作金额")
    private BigDecimal operateAmount;

    @Schema(description = "操作老人id", example = "15143")
    private Long elderlyId;

    @Schema(description = "操作备注", example = "你说的对")
    private String remark;

    
    @Schema(description = "创建者")
    private String creator;


    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}