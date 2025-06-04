package cn.iocoder.yudao.module.system.dal.dataobject.special;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 特殊服务类别 DO
 *
 * @author 沈文杰
 */
@TableName("system_special")
@KeySequence("system_special_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 服务类别
     */
    private String name;
    /**
     * 服务图片
     */
    private String image;
    /**
     * 服务描述
     */
    private String description;


}