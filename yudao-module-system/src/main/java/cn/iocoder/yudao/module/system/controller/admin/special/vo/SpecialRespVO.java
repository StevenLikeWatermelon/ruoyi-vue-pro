package cn.iocoder.yudao.module.system.controller.admin.special.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 特殊服务类别 Response VO")
@Data
@ExcelIgnoreUnannotated
public class SpecialRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "29313")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "服务类别", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("服务类别")
    private String name;

    @Schema(description = "服务图片")
    @ExcelProperty("服务图片")
    private String image;

    @Schema(description = "服务描述", example = "你说的对")
    @ExcelProperty("服务描述")
    private String description;

    @Schema(description = "创建者")
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新者")
    @ExcelProperty("更新者")
    private String updater;

    @Schema(description = "更新时间")
    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

}