package cn.iocoder.yudao.module.system.controller.admin.special.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialItemDO;

@Schema(description = "管理后台 - 特殊服务类别新增/修改 Request VO")
@Data
public class SpecialSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "29313")
    private Long id;

    @Schema(description = "服务类别", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "服务类别不能为空")
    private String name;

    @Schema(description = "服务图片")
    private String image;

    @Schema(description = "服务描述", example = "你说的对")
    private String description;

    @Schema(description = "特殊服务项目列表")
    private List<SpecialItemDO> specialItems;

}