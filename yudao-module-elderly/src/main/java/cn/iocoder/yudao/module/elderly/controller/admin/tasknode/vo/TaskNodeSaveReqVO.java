package cn.iocoder.yudao.module.elderly.controller.admin.tasknode.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 任务节点管理新增/修改 Request VO")
@Data
public class TaskNodeSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3300")
    private Long id;

    @Schema(description = "节点名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "节点名称不能为空")
    private String name;

    @Schema(description = "节点内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "节点内容不能为空")
    private String content;

    @Schema(description = "是否需要拍照", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否需要拍照不能为空")
    private Boolean needPhoto;

    @Schema(description = "是否需要定位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否需要定位不能为空")
    private Boolean needLocation;

    @Schema(description = "是否需要按时完成", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否需要按时完成不能为空")
    private Boolean needTime;

    @Schema(description = "备注", example = "随便")
    private String remark;

}