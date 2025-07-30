package cn.iocoder.yudao.module.elderly.dal.dataobject.feesoperaterecord;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 费用操作记录 DO
 *
 * @author 沈文杰
 */
@TableName("elderly_fees_operate_record")
@KeySequence("elderly_fees_operate_record_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeesOperateRecordDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 操作类型
     */
    private String operateType;
    /**
     * 操作金额
     */
    private BigDecimal operateAmount;
    /**
     * 操作老人id
     */
    private Long elderlyId;
    /**
     * 操作备注
     */
    private String remark;


}