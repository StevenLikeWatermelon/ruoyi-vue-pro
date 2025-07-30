package cn.iocoder.yudao.module.elderly.controller.admin.feesoperaterecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 费用操作记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FeesOperateRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17555")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "操作类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("操作类型")
    private String operateType;

    @Schema(description = "操作金额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("操作金额")
    private BigDecimal operateAmount;

    @Schema(description = "操作老人id", requiredMode = Schema.RequiredMode.REQUIRED, example = "15143")
    @ExcelProperty("操作老人id")
    private Long elderlyId;

    @Schema(description = "操作备注", example = "你说的对")
    @ExcelProperty("操作备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}