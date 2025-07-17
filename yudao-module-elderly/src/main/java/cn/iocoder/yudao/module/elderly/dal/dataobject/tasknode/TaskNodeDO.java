package cn.iocoder.yudao.module.elderly.dal.dataobject.tasknode;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 任务节点管理 DO
 *
 * @author 护理一组组长
 */
@TableName("elderly_task_node")
@KeySequence("elderly_task_node_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskNodeDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 节点名称
     */
    private String name;
    /**
     * 节点内容
     */
    private String content;
    /**
     * 是否需要拍照
     */
    private Boolean needPhoto;
    /**
     * 是否需要定位
     */
    private Boolean needLocation;
    /**
     * 是否需要按时完成
     */
    private Boolean needTime;
    /**
     * 备注
     */
    private String remark;


}