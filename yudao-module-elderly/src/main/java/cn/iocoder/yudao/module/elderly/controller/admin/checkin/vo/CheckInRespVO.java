package cn.iocoder.yudao.module.elderly.controller.admin.checkin.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 老人入住信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CheckInRespVO { 

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "29770")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "入住老人", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("入住老人")
    private String visitorName;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String notes;

    @Schema(description = "合同上传")
    @ExcelProperty("合同上传")
    private String attachmentPath;

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

    @Schema(description = "床位编号", example = "101")
    @ExcelProperty("床位编号")
    private Long bedId;

    @Schema(description = "床位名称", example = "101 号床位")
    @ExcelProperty("床位名称")
    private String bedName;
}