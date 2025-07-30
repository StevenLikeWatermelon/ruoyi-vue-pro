package cn.iocoder.yudao.module.elderly.controller.admin.feesoverview.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 老人费用余额新增/修改 Request VO")
@Data
public class FeesOverviewSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "6839")
    private Long id;

    @Schema(description = "老人id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25312")
    @NotNull(message = "老人id不能为空")
    private Long elderlyId;

    @Schema(description = "余额", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "余额不能为空")
    private BigDecimal balance;

    @Schema(description = "备注", example = "你猜")
    private String remark;

}