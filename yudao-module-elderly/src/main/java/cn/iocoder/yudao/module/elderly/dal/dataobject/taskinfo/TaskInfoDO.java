package cn.iocoder.yudao.module.elderly.dal.dataobject.taskinfo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 任务信息管理 DO
 *
 * @author 护理一组组长
 */
@TableName("elderly_task_info")
@KeySequence("elderly_task_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskInfoDO extends BaseDO {

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
     * 任务开始时间
     */
    private String startTime;
    /**
     * 任务结束时间
     */
    private String endTime;
    /**
     * 任务拍照列表
     */
    private String photoList;
    /**
     * 任务经纬度信息
     */
    private String locationList;
    /**
     * 任务关联的节点id
     */
    private Long nodeId;

    /**
     * 任务节点名称
     */
    private String nodeName;
    /**
     * 任务状态
     */
    private String status;
    /**
     * 任务执行id
     */
    private Long executeId;
    /**
     * 任务服务客户
     */
    private String serviceCustomer;
    /**
     * 备注
     */
    private String remark;


}