package cn.iocoder.yudao.module.elderly.controller.admin.visitregistration.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 来访登记分页 Request VO")
@Data
public class VisitRegistrationPageReqVO extends PageParam {

    @Schema(description = "编号", example = "16611")
    private Long id;

    @Schema(description = "老人编号", example = "1024")
    private Long elderlyId;

    @Schema(description = "来访人姓名", example = "李四")
    private String visitorName;

    @Schema(description = "来访人数", example = "28542")
    private Integer visitorCount;

    @Schema(description = "有效证件类型", example = "2")
    private String idType;

    @Schema(description = "证件号码")
    private String idNumber;

    @Schema(description = "与老人关系")
    private String relationship;

    @Schema(description = "联系电话")
    private String contactPhone;

    @Schema(description = "来访时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] visitTime;

    @Schema(description = "离开时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] leaveTime;

    @Schema(description = "携带物品")
    private String itemsCarried;

    @Schema(description = "备注")
    private String notes;

    @Schema(description = "附件路径")
    private String attachmentPath;

    @Schema(description = "创建者")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}