package cn.iocoder.yudao.module.elderly.controller.admin.visitregistration.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 来访登记新增/修改 Request VO")
@Data
public class VisitRegistrationSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "16611")
    private Long id;

    @Schema(description = "老人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "老人编号不能为空")
    private Long elderlyId;

    @Schema(description = "来访人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "来访人姓名不能为空")
    private String visitorName;

    @Schema(description = "来访人数", requiredMode = Schema.RequiredMode.REQUIRED, example = "28542")
    @NotNull(message = "来访人数不能为空")
    private Integer visitorCount;

    @Schema(description = "有效证件类型", example = "2")
    private String idType;

    @Schema(description = "证件号码")
    private String idNumber;

    @Schema(description = "与老人关系")
    private String relationship;

    @Schema(description = "联系电话")
    private String contactPhone;

    @Schema(description = "来访时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "来访时间不能为空")
    private LocalDateTime visitTime;

    @Schema(description = "离开时间")
    private LocalDateTime leaveTime;

    @Schema(description = "携带物品")
    private String itemsCarried;

    @Schema(description = "备注")
    private String notes;

    @Schema(description = "附件路径")
    private String attachmentPath;

}