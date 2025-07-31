package cn.iocoder.yudao.module.elderly.controller.admin.feesdailyconsumpt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 日常消费新增/修改 Request VO")
@Data
public class FeesDailyConsumptSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "543")
    private Long id;

    @Schema(description = "消费名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotEmpty(message = "消费名称不能为空")
    private String operateType;

    @Schema(description = "消费id列表")
    private String consumptIdList;

    @Schema(description = "消费费用列表")
    private String consumptMoneyList;

    @Schema(description = "总金额")
    private BigDecimal totalMoney;

    @Schema(description = "消费备注", example = "你猜")
    private String remark;

}