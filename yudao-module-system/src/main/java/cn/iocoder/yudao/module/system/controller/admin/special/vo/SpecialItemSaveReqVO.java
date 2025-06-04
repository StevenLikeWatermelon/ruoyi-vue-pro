package cn.iocoder.yudao.module.system.controller.admin.special.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 特殊服务项目新增/修改 Request VO")
@Data
public class SpecialItemSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "23865")
    private Long id;

    @Schema(description = "服务类别编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "6269")
    @NotNull(message = "服务类别编号不能为空")
    private Long specialTypeId;

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "项目名称不能为空")
    private String name;

    @Schema(description = "项目金额")
    private String money;

    @Schema(description = "项目描述", example = "随便")
    private String description;

}