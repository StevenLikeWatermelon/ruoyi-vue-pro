package cn.iocoder.yudao.module.elderly.controller.admin.infobasic.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 老人基本信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class InfoBasicRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "3280")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("姓名")
    private String name;

    @Schema(description = "性别", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "性别", converter = DictConvert.class)
    @DictFormat("system_user_sex") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String gender;

    @Schema(description = "血型", example = "1")
    @ExcelProperty(value = "血型", converter = DictConvert.class)
    @DictFormat("blood_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String bloodType;

    @Schema(description = "户籍类型", example = "1")
    @ExcelProperty(value = "户籍类型", converter = DictConvert.class)
    @DictFormat("residence_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String residenceType;

    @Schema(description = "身份证号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("身份证号")
    private String idCard;

    @Schema(description = "民族")
    @ExcelProperty("民族")
    private String ethnicity;

    @Schema(description = "政治面貌", example = "1")
    @ExcelProperty(value = "政治面貌", converter = DictConvert.class)
    @DictFormat("political_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String politicalStatus;

    @Schema(description = "出生日期")
    @ExcelProperty("出生日期")
    private LocalDateTime birthDate;

    @Schema(description = "手机号码")
    @ExcelProperty("手机号码")
    private String mobile;

    @Schema(description = "经济来源")
    @ExcelProperty(value = "经济来源", converter = DictConvert.class)
    @DictFormat("economy_source") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String incomeSource;

    @Schema(description = "宗教信仰")
    @ExcelProperty(value = "宗教信仰", converter = DictConvert.class)
    @DictFormat("religion_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String religion;

    @Schema(description = "家庭号码")
    @ExcelProperty("家庭号码")
    private String homePhone;

    @Schema(description = "媒介渠道")
    @ExcelProperty(value = "媒介渠道", converter = DictConvert.class)
    @DictFormat("media_channel") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String mediaChannel;

    @Schema(description = "老人职业")
    @ExcelProperty(value = "老人职业", converter = DictConvert.class)
    @DictFormat("elder_occupation") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String occupation;

    @Schema(description = "文化程度")
    @ExcelProperty(value = "文化程度", converter = DictConvert.class)
    @DictFormat("education_level") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String education;

    @Schema(description = "婚姻状况", example = "2")
    @ExcelProperty(value = "婚姻状况", converter = DictConvert.class)
    @DictFormat("marital_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String maritalStatus;

    @Schema(description = "老人类别", example = "2")
    @ExcelProperty(value = "老人类别", converter = DictConvert.class)
    @DictFormat("elder_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String elderlyType;

    @Schema(description = "退休单位")
    @ExcelProperty("退休单位")
    private String retirementUnit;

    @Schema(description = "服务类型", example = "2")
    @ExcelProperty(value = "服务类型", converter = DictConvert.class)
    @DictFormat("service_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String serviceType;

    @Schema(description = "推荐人")
    @ExcelProperty("推荐人")
    private String referrer;

    @Schema(description = "医疗保险")
    @ExcelProperty(value = "医疗保险", converter = DictConvert.class)
    @DictFormat("medical_insurance") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String medicalInsurance;

    @Schema(description = "供养形式", example = "2")
    @ExcelProperty(value = "供养形式", converter = DictConvert.class)
    @DictFormat("support_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String supportType;

    @Schema(description = "推荐金额")
    @ExcelProperty("推荐金额")
    private BigDecimal referralAmount;

    @Schema(description = "户籍地址")
    @ExcelProperty("户籍地址")
    private String registeredAddress;

    @Schema(description = "居住地址")
    @ExcelProperty("居住地址")
    private String residentialAddress;

    @Schema(description = "过敏药物")
    @ExcelProperty("过敏药物")
    private List<String> allergicDrugs;

    @Schema(description = "饮食禁忌")
    @ExcelProperty("饮食禁忌")
    private List<String> dietaryRestrictions;

    @Schema(description = "主要疾病")
    @ExcelProperty(value = "主要疾病", converter = DictConvert.class)
    @DictFormat("major_disease_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String mainDiseases;

    @Schema(description = "风险提示")
    @ExcelProperty("风险提示")
    private String riskWarning;

    @Schema(description = "身体状况")
    @ExcelProperty(value = "身体状况", converter = DictConvert.class)
    @DictFormat("body_condition") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String physicalCondition;

    @Schema(description = "饮食方式")
    @ExcelProperty(value = "饮食方式", converter = DictConvert.class)
    @DictFormat("dietary_style") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String dietStyle;

    @Schema(description = "老人头像")
    @ExcelProperty("老人头像")
    private String avatar;

    @Schema(description = "身份证照片")
    @ExcelProperty("身份证照片")
    private String idCardPhoto;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}