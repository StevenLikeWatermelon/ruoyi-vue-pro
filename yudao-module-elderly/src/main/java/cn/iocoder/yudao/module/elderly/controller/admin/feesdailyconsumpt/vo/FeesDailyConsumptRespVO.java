package cn.iocoder.yudao.module.elderly.controller.admin.feesdailyconsumpt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 日常消费 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FeesDailyConsumptRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "543")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "消费名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("消费名称")
    private String operateType;

    @Schema(description = "消费id列表")
    @ExcelProperty("消费id列表")
    private String consumptIdList;

    @Schema(description = "消费费用列表")
    @ExcelProperty("消费费用列表")
    private String consumptMoneyList;

    @Schema(description = "总金额")
    @ExcelProperty("总金额")
    private BigDecimal totalMoney;

    @Schema(description = "消费备注", example = "你猜")
    @ExcelProperty("消费备注")
    private String remark;

    @Schema(description = "创建者")
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}