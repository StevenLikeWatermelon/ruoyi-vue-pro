package cn.iocoder.yudao.module.elderly.dal.dataobject.visitregistration;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 来访登记 DO
 *
 * @author 沈文杰
 */
@TableName("elderly_visit_registration")
@KeySequence("elderly_visit_registration_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitRegistrationDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 老人编号
     */
    private Long elderlyId;
    /**
     * 来访人姓名
     */
    private String visitorName;
    /**
     * 来访人数
     */
    private Integer visitorCount;
    /**
     * 有效证件类型
     *
     * 枚举 {@link TODO validate_cert_type 对应的类}
     */
    private String idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 与老人关系
     */
    private String relationship;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 来访时间
     */
    private LocalDateTime visitTime;
    /**
     * 离开时间
     */
    private LocalDateTime leaveTime;
    /**
     * 携带物品
     */
    private String itemsCarried;
    /**
     * 备注
     */
    private String notes;
    /**
     * 附件路径
     */
    private String attachmentPath;


}