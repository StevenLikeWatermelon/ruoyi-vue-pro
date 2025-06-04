package cn.iocoder.yudao.module.system.controller.admin.moneymanage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 基础费用管理新增/修改 Request VO")
@Data
public class MoneyManageSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13613")
    private Long id;

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

}