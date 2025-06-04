package cn.iocoder.yudao.module.system.dal.dataobject.special;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 特殊服务项目 DO
 *
 * @author 沈文杰
 */
@TableName("system_special_item")
@KeySequence("system_special_item_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialItemDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 服务类别编号
     */
    private Long specialTypeId;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目金额
     */
    private String money;
    /**
     * 项目描述
     */
    private String description;

}