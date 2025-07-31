package cn.iocoder.yudao.module.elderly.dal.dataobject.feesdailyconsumpt;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 日常消费 DO
 *
 * @author 沈文杰
 */
@TableName("elderly_fees_daily_consumpt")
@KeySequence("elderly_fees_daily_consumpt_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeesDailyConsumptDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 消费名称
     */
    private String operateType;
    /**
     * 消费id列表
     */
    private String consumptIdList;
    /**
     * 消费费用列表
     */
    private String consumptMoneyList;
    /**
     * 总金额
     */
    private BigDecimal totalMoney;
    /**
     * 消费备注
     */
    private String remark;


}