package cn.iocoder.yudao.module.elderly.dal.dataobject.feesoverview;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 老人费用余额 DO
 *
 * @author 护理一组组长
 */
@TableName("elderly_fees_overview")
@KeySequence("elderly_fees_overview_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeesOverviewDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 老人id
     */
    private Long elderlyId;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 备注
     */
    private String remark;


}