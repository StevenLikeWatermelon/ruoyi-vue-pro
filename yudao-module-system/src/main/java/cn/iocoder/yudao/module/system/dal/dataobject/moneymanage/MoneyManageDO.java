package cn.iocoder.yudao.module.system.dal.dataobject.moneymanage;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 基础费用管理 DO
 *
 * @author 芋道源码
 */
@TableName("system_money_manage")
@KeySequence("system_money_manage_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoneyManageDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 费用名称
     */
    private String name;
    /**
     * 费用编码
     */
    private String code;
    /**
     * 收费方式
     *
     * 枚举 {@link TODO charge_way 对应的类}
     */
    private String chargeWay;
    /**
     * 出院是否退款
     *
     * 枚举 {@link TODO has_or_no 对应的类}
     */
    private String refund;
    /**
     * 状态
     */
    private String status;
    /**
     * 金额
     */
    private String amount;
    /**
     * 费用描述
     */
    private String description;


}