package cn.iocoder.yudao.module.elderly.controller.admin.visitregistration.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 来访登记 Response VO")
@Data
@ExcelIgnoreUnannotated
public class VisitRegistrationRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "16611")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "老人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("老人编号")
    private Long elderlyId;

    @Schema(description = "来访人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("来访人姓名")
    private String visitorName;

    @Schema(description = "来访人数", requiredMode = Schema.RequiredMode.REQUIRED, example = "28542")
    @ExcelProperty("来访人数")
    private Integer visitorCount;

    @Schema(description = "有效证件类型", example = "2")
    @ExcelProperty(value = "有效证件类型", converter = DictConvert.class)
    @DictFormat("validate_cert_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String idType;

    @Schema(description = "证件号码")
    @ExcelProperty("证件号码")
    private String idNumber;

    @Schema(description = "与老人关系")
    @ExcelProperty("与老人关系")
    private String relationship;

    @Schema(description = "联系电话")
    @ExcelProperty("联系电话")
    private String contactPhone;

    @Schema(description = "来访时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("来访时间")
    private LocalDateTime visitTime;

    @Schema(description = "离开时间")
    @ExcelProperty("离开时间")
    private LocalDateTime leaveTime;

    @Schema(description = "携带物品")
    @ExcelProperty("携带物品")
    private String itemsCarried;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String notes;

    @Schema(description = "附件路径")
    @ExcelProperty("附件路径")
    private String attachmentPath;

    @Schema(description = "创建者")
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}