package cn.iocoder.yudao.module.system.controller.admin.moneymanage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 基础费用管理 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MoneyManageRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13613")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "费用名称", example = "芋艿")
    @ExcelProperty("费用名称")
    private String name;

    @Schema(description = "费用编码")
    @ExcelProperty("费用编码")
    private String code;

    @Schema(description = "收费方式")
    @ExcelProperty(value = "收费方式", converter = DictConvert.class)
    @DictFormat("charge_way") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String chargeWay;

    @Schema(description = "出院是否退款")
    @ExcelProperty(value = "出院是否退款", converter = DictConvert.class)
    @DictFormat("has_or_no") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String refund;

    @Schema(description = "状态", example = "1")
    @ExcelProperty("状态")
    private String status;

    @Schema(description = "金额")
    @ExcelProperty("金额")
    private String amount;

    @Schema(description = "费用描述", example = "你说的对")
    @ExcelProperty("费用描述")
    private String description;

    @Schema(description = "创建者")
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新者")
    @ExcelProperty("更新者")
    private String updater;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

}