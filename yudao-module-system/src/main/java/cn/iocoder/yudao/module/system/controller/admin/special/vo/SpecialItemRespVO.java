package cn.iocoder.yudao.module.system.controller.admin.special.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 特殊服务项目 Response VO")
@Data
@ExcelIgnoreUnannotated
public class SpecialItemRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "23865")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "服务类别编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "6269")
    @ExcelProperty("服务类别编号")
    private Long specialTypeId;

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("项目名称")
    private String name;

    @Schema(description = "项目金额")
    @ExcelProperty("项目金额")
    private String money;

    @Schema(description = "项目描述", example = "随便")
    @ExcelProperty("项目描述")
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