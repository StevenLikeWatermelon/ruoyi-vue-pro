package cn.iocoder.yudao.module.elderly.controller.admin.tasknode.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 任务节点管理 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TaskNodeRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3300")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "节点名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("节点名称")
    private String name;

    @Schema(description = "节点内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("节点内容")
    private String content;

    @Schema(description = "是否需要拍照", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否需要拍照")
    private Boolean needPhoto;

    @Schema(description = "是否需要定位", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否需要定位")
    private Boolean needLocation;

    @Schema(description = "是否需要按时完成", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否需要按时完成")
    private Boolean needTime;

    @Schema(description = "备注", example = "随便")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建者")
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}