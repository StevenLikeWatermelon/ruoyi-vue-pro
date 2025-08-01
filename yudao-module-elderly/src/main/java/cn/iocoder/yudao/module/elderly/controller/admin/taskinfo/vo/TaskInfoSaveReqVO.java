package cn.iocoder.yudao.module.elderly.controller.admin.taskinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 任务信息管理新增/修改 Request VO")
@Data
public class TaskInfoSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "299")
    private Long id;

    @Schema(description = "任务名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "任务名称不能为空")
    private String name;

    @Schema(description = "任务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "任务类型不能为空")
    private String type;

    @Schema(description = "任务内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "任务内容不能为空")
    private String content;

    @Schema(description = "任务开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "任务开始时间不能为空")
    private String startTime;

    @Schema(description = "任务结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "任务结束时间不能为空")
    private String endTime;

    @Schema(description = "任务拍照列表")
    private String photoList;

    @Schema(description = "任务经纬度信息")
    private String locationList;

    @Schema(description = "任务关联的节点id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13658")
    private Long nodeId;

    @Schema(description = "任务执行id")
    private Long executeId;


    @Schema(description = "任务状态", example = "1")
    private String status;

    @Schema(description = "任务服务客户")
    private String serviceCustomer;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

}