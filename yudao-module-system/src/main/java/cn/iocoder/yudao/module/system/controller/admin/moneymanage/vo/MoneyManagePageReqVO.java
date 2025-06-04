package cn.iocoder.yudao.module.system.controller.admin.moneymanage.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 基础费用管理分页 Request VO")
@Data
public class MoneyManagePageReqVO extends PageParam {

    @Schema(description = "费用名称", example = "芋艿")
    private String name;

    @Schema(description = "费用编码")
    private String code;

    @Schema(description = "收费方式")
    private String chargeWay;

    @Schema(description = "出院是否退款")
    private String refund;

    @Schema(description = "状态", example = "1")
    private String status;

    @Schema(description = "金额")
    private String amount;

    @Schema(description = "费用描述", example = "你说的对")
    private String description;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}