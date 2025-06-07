package cn.iocoder.yudao.module.elderly.controller.admin.infobasic.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 老人基本信息分页 Request VO")
@Data
public class InfoBasicPageReqVO extends PageParam {

    @Schema(description = "姓名", example = "张三")
    private String name;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "血型", example = "1")
    private String bloodType;

    @Schema(description = "户籍类型", example = "1")
    private String residenceType;

    @Schema(description = "身份证号")
    private String idCard;

    @Schema(description = "政治面貌", example = "1")
    private String politicalStatus;

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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}