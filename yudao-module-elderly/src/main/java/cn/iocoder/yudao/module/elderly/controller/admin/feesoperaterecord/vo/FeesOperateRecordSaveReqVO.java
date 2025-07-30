package cn.iocoder.yudao.module.elderly.controller.admin.feesoperaterecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 费用操作记录新增/修改 Request VO")
@Data
public class FeesOperateRecordSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17555")
    private Long id;

    @Schema(description = "操作类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotEmpty(message = "操作类型不能为空")
    private String operateType;

    @Schema(description = "操作金额", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "操作金额不能为空")
    private BigDecimal operateAmount;

    @Schema(description = "操作老人id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15143")
    @NotNull(message = "操作老人id不能为空")
    private Long elderlyId;

    @Schema(description = "操作备注", example = "你说的对")
    private String remark;

}