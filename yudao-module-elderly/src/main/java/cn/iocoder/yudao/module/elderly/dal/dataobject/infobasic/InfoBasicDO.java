package cn.iocoder.yudao.module.elderly.dal.dataobject.infobasic;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 老人基本信息 DO
 *
 * @author 沈文杰
 */
@TableName("elderly_info_basic")
@KeySequence("elderly_info_basic_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoBasicDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     *
     * 枚举 {@link TODO system_user_sex 对应的类}
     */
    private String gender;
    /**
     * 血型
     *
     * 枚举 {@link TODO blood_type 对应的类}
     */
    private String bloodType;
    /**
     * 户籍类型
     *
     * 枚举 {@link TODO residence_type 对应的类}
     */
    private String residenceType;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 身份证号是否随机（0-否，1-是）
     */
    private String isRandomId;
    /**
     * 民族
     */
    private String ethnicity;
    /**
     * 政治面貌
     *
     * 枚举 {@link TODO political_status 对应的类}
     */
    private String politicalStatus;
    /**
     * 出生日期
     */
    private LocalDateTime birthDate;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 经济来源
     *
     * 枚举 {@link TODO economy_source 对应的类}
     */
    private String incomeSource;
    /**
     * 宗教信仰
     *
     * 枚举 {@link TODO religion_type 对应的类}
     */
    private String religion;
    /**
     * 家庭号码
     */
    private String homePhone;
    /**
     * 媒介渠道
     *
     * 枚举 {@link TODO media_channel 对应的类}
     */
    private String mediaChannel;
    /**
     * 老人职业
     *
     * 枚举 {@link TODO elder_occupation 对应的类}
     */
    private String occupation;
    /**
     * 文化程度
     *
     * 枚举 {@link TODO education_level 对应的类}
     */
    private String education;
    /**
     * 婚姻状况
     *
     * 枚举 {@link TODO marital_status 对应的类}
     */
    private String maritalStatus;
    /**
     * 老人类别
     *
     * 枚举 {@link TODO elder_type 对应的类}
     */
    private String elderlyType;
    /**
     * 退休单位
     */
    private String retirementUnit;
    /**
     * 服务类型
     *
     * 枚举 {@link TODO service_type 对应的类}
     */
    private String serviceType;
    /**
     * 推荐人
     */
    private String referrer;
    /**
     * 医疗保险
     *
     * 枚举 {@link TODO medical_insurance 对应的类}
     */
    private String medicalInsurance;
    /**
     * 供养形式
     *
     * 枚举 {@link TODO support_type 对应的类}
     */
    private String supportType;
    /**
     * 推荐金额
     */
    private BigDecimal referralAmount;
    /**
     * 户籍地址
     */
    private String registeredAddress;
    /**
     * 居住地址
     */
    private String residentialAddress;
    /**
     * 过敏药物
     *
     * 枚举 {@link TODO allergic_drug_type 对应的类}
     */
    private String allergicDrugs;
    /**
     * 过敏药物列表（非数据库字段）
     */
    @TableField(exist = false)
    private List<String> allergicDrugsList;
    /**
     * 饮食禁忌
     *
     * 枚举 {@link TODO dietary_limit_type 对应的类}
     */
    private String dietaryRestrictions;
    /**
     * 饮食禁忌列表（非数据库字段）
     */
    @TableField(exist = false)
    private List<String> dietaryRestrictionsList;
    /**
     * 主要疾病
     *
     * 枚举 {@link TODO major_disease_type 对应的类}
     */
    private String mainDiseases;
    /**
     * 风险提示
     */
    private String riskWarning;
    /**
     * 身体状况
     *
     * 枚举 {@link TODO body_condition 对应的类}
     */
    private String physicalCondition;
    /**
     * 饮食方式
     *
     * 枚举 {@link TODO dietary_style 对应的类}
     */
    private String dietStyle;
    /**
     * 老人头像
     */
    private String avatar;
    /**
     * 身份证照片
     */
    private String idCardPhoto;


}