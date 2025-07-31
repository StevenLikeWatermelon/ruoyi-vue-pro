package cn.iocoder.yudao.module.elderly.controller.admin.feesdailyconsumpt.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 日常消费分页 Request VO")
@Data
public class FeesDailyConsumptPageReqVO extends PageParam {

    @Schema(description = "编号", example = "543")
    private Long id;

    @Schema(description = "消费名称", example = "2")
    private String operateType;

    @Schema(description = "消费id列表")
    private String consumptIdList;

    @Schema(description = "消费费用列表")
    private String consumptMoneyList;

    @Schema(description = "总金额")
    private BigDecimal totalMoney;

    @Schema(description = "消费备注", example = "你猜")
    private String remark;

    @Schema(description = "创建者")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}