package cn.iocoder.yudao.module.elderly.dal.dataobject.reserve;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 预约登记 DO
 *
 * @author 沈文杰
 */
@TableName("elderly_reserve")
@KeySequence("elderly_reserve_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReserveDO extends BaseDO {

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
     */
    private String relationship;
    /**
     * 咨询日期
     */
    private LocalDateTime consultationDate;
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
     */
    private Integer elderlyGender;
    /**
     * 老人年龄
     */
    private Integer elderlyAge;
    /**
     * 自理情况
     */
    private String selfCareAbility;
    /**
     * 家庭住址
     */
    private String elderlyAddress;
    /**
     * 咨询方式
     */
    private String consultationMethod;
    /**
     * 咨询意向
     */
    private String consultationIntention;
    /**
     * 咨询次数
     */
    private Integer consultationCount;
    /**
     * 媒介渠道
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
     * 选择床位
     */
    private Long bedId;
    /**
     * 计划入住时间
     */
    private LocalDateTime plannedCheckinTime;
    /**
     * 预约金
     */
    private BigDecimal reservationFee;
    /**
     * 预留结束时间
     */
    private LocalDateTime reserveEndTime;
    /**
     * 预留开始时间
     */
    private LocalDateTime reserveStartTime;


}