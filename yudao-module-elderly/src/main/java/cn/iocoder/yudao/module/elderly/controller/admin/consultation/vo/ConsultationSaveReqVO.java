package cn.iocoder.yudao.module.elderly.controller.admin.consultation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDate;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 咨询登记新增/修改 Request VO")
@Data
public class ConsultationSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "28846")
    private Long id;

    @Schema(description = "咨询人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "咨询人姓名不能为空")
    private String consultantName;

    @Schema(description = "与老人关系", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "与老人关系不能为空")
    private String relationship;

    @Schema(description = "咨询日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "咨询日期不能为空")
    private LocalDate consultationDate;

    @Schema(description = "联系方式", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "联系方式不能为空")
    private String contactPhone;

    @Schema(description = "老人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotEmpty(message = "老人姓名不能为空")
    private String elderlyName;

    @Schema(description = "老人性别", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "老人性别不能为空")
    private Integer elderlyGender;

    @Schema(description = "老人年龄", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "老人年龄不能为空")
    private Integer elderlyAge;

    @Schema(description = "自理情况", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "自理情况不能为空")
    private String selfCareAbility;

    @Schema(description = "家庭住址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "家庭住址不能为空")
    private String elderlyAddress;

    @Schema(description = "咨询方式", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "咨询方式不能为空")
    private String consultationMethod;

    @Schema(description = "咨询意向", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "咨询意向不能为空")
    private String consultationIntention;

    @Schema(description = "咨询次数", requiredMode = Schema.RequiredMode.REQUIRED, example = "18013")
    @NotNull(message = "咨询次数不能为空")
    private Integer consultationCount;

    @Schema(description = "媒介渠道", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "媒介渠道不能为空")
    private String mediaChannel;

    @Schema(description = "推荐人")
    private String referrer;

    @Schema(description = "负责人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13968")
    @NotNull(message = "负责人编号不能为空")
    private Long managerId;

    @Schema(description = "负责人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "负责人姓名不能为空")
    private String managerName;

    @Schema(description = "备注", example = "你猜")
    private String remark;

    @Schema(description = "创建人", example = "李四")
    private String creator;

}