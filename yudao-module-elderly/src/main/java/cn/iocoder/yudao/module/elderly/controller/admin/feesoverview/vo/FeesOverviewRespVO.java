package cn.iocoder.yudao.module.elderly.controller.admin.feesoverview.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 老人费用余额 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FeesOverviewRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "6839")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "老人id", requiredMode = Schema.RequiredMode.REQUIRED, example = "25312")
    @ExcelProperty("老人id")
    private Long elderlyId;

    @Schema(description = "余额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("余额")
    private BigDecimal balance;

    @Schema(description = "备注", example = "你猜")
    @ExcelProperty("备注")
    private String remark;

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