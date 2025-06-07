package cn.iocoder.yudao.module.elderly.controller.admin.infobasic.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 老人基本信息新增/修改 Request VO")
@Data
public class InfoBasicSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "3280")
    private Long id;

    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @Schema(description = "性别", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "性别不能为空")
    private String gender;

    @Schema(description = "血型", example = "1")
    private String bloodType;

    @Schema(description = "户籍类型", example = "1")
    private String residenceType;

    @Schema(description = "身份证号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "身份证号不能为空")
    private String idCard;

    @Schema(description = "民族")
    private String ethnicity;

    @Schema(description = "政治面貌", example = "1")
    private String politicalStatus;

    @Schema(description = "出生日期")
    private LocalDateTime birthDate;

    @Schema(description = "手机号码")
    private String mobile;

    @Schema(description = "经济来源")
    private String incomeSource;

    @Schema(description = "宗教信仰")
    private String religion;

    @Schema(description = "家庭号码")
    private String homePhone;

    @Schema(description = "媒介渠道")
    private String mediaChannel;

    @Schema(description = "老人职业")
    private String occupation;

    @Schema(description = "文化程度")
    private String education;

    @Schema(description = "婚姻状况", example = "2")
    private String maritalStatus;

    @Schema(description = "老人类别", example = "2")
    private String elderlyType;

    @Schema(description = "退休单位")
    private String retirementUnit;

    @Schema(description = "服务类型", example = "2")
    private String serviceType;

    @Schema(description = "推荐人")
    private String referrer;

    @Schema(description = "医疗保险")
    private String medicalInsurance;

    @Schema(description = "供养形式", example = "2")
    private String supportType;

    @Schema(description = "推荐金额")
    private BigDecimal referralAmount;

    @Schema(description = "户籍地址")
    private String registeredAddress;

    @Schema(description = "居住地址")
    private String residentialAddress;

    @Schema(description = "过敏药物")
    private String allergicDrugs;

    @Schema(description = "饮食禁忌")
    private String dietaryRestrictions;

    @Schema(description = "主要疾病")
    private String mainDiseases;

    @Schema(description = "风险提示")
    private String riskWarning;

    @Schema(description = "身体状况")
    private String physicalCondition;

    @Schema(description = "饮食方式")
    private String dietStyle;

    @Schema(description = "老人头像")
    private String avatar;

    @Schema(description = "身份证照片")
    private String idCardPhoto;

}