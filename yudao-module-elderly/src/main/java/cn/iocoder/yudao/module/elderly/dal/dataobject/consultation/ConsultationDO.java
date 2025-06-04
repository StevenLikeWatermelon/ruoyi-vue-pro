package cn.iocoder.yudao.module.elderly.dal.dataobject.consultation;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 咨询登记 DO
 *
 * @author 芋道源码
 */
@TableName("elderly_consultation")
@KeySequence("elderly_consultation_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 咨询人姓名
     */
    private String consultantName;
    /**
     * 与老人关系
     *
     * 枚举 {@link TODO elderly_relationship 对应的类}
     */
    private String relationship;
    /**
     * 咨询日期
     */
    private LocalDate consultationDate;
    /**
     * 联系方式
     */
    private String contactPhone;
    /**
     * 老人姓名
     */
    private String elderlyName;
    /**
     * 老人性别
     *
     * 枚举 {@link TODO system_user_sex 对应的类}
     */
    private Integer elderlyGender;
    /**
     * 老人年龄
     */
    private Integer elderlyAge;
    /**
     * 自理情况
     *
     * 枚举 {@link TODO self_care_ability 对应的类}
     */
    private String selfCareAbility;
    /**
     * 家庭住址
     */
    private String elderlyAddress;
    /**
     * 咨询方式
     *
     * 枚举 {@link TODO consultation_method 对应的类}
     */
    private String consultationMethod;
    /**
     * 咨询意向
     *
     * 枚举 {@link TODO consultation_intention 对应的类}
     */
    private String consultationIntention;
    /**
     * 咨询次数
     */
    private Integer consultationCount;
    /**
     * 媒介渠道
     *
     * 枚举 {@link TODO media_channel 对应的类}
     */
    private String mediaChannel;
    /**
     * 推荐人
     */
    private String referrer;
    /**
     * 负责人编号
     */
    private Long managerId;
    /**
     * 负责人姓名
     */
    private String managerName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 备注
     */
    private String creator;

}