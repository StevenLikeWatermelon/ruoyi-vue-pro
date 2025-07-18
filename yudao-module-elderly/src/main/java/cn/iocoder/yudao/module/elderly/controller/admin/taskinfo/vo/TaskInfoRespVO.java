package cn.iocoder.yudao.module.elderly.controller.admin.taskinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 任务信息管理 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TaskInfoRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "299")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "任务名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("任务名称")
    private String name;

    @Schema(description = "任务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "任务类型", converter = DictConvert.class)
    @DictFormat("stuff_daily_task") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String type;

    @Schema(description = "任务内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("任务内容")
    private String content;

    @Schema(description = "任务开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("任务开始时间")
    private String startTime;

    @Schema(description = "任务结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("任务结束时间")
    private String endTime;

    @Schema(description = "任务关联的节点id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13658")
    @ExcelProperty("任务关联的节点id")
    private Long nodeId;

    // NodeName
     @Schema(description = "任务关联的节点名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "13658")
    @ExcelProperty("任务关联的节点名称")
    private String NodeName;


    @Schema(description = "备注", example = "你说的对")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建者")
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}