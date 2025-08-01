package cn.iocoder.yudao.module.elderly.dal.dataobject.taskexcuted;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 任务编排执行管理 DO
 *
 * @author 护理一组组长
 */
@TableName("elderly_task_excuted")
@KeySequence("elderly_task_excuted_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskExcutedDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 任务名称
     */
    private String name;
    /**
     * 任务类型
     *
     * 枚举 {@link TODO stuff_daily_task 对应的类}
     */
    private String type;
    /**
     * 任务内容
     */
    private String content;
    /**
     * 执行开始时间
     */
    private String startTime;
    /**
     * 执行结束时间
     */
    private String endTime;
    /**
     * 执行负责人
     */
    private String assignee;
    /**
     * 工作流实例编号
     */
    private String processInstanceId;
    /**
     * 工作流实例状态
     */
    private String status;
    /**
     * 执行负责人名称
     */
    private String assigneeName;
    /**
     * 关联的任务信息id
     */
    private String taskInfoId;
    /**
     * 备注
     */
    private String remark;


}