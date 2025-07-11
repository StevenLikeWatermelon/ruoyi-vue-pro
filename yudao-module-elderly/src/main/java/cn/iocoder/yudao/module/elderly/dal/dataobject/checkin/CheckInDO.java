package cn.iocoder.yudao.module.elderly.dal.dataobject.checkin;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 老人入住信息 DO
 *
 * @author 沈文杰
 */
@TableName("elderly_check_in")
@KeySequence("elderly_check_in_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckInDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 入住老人
     */
    private String visitorName;
    /**
     * 备注
     */
    private String notes;
    /**
     * 合同上传
     */
    private String attachmentPath;
    /**
     * 床位编号
     */
    private Long bedId;
    /**
     * 床位名称
     */
    private String bedName;
    /**
     * 工作流实例编号
     */
    private String processInstanceId;
    /**
     * 工作流实例状态
     */
    private String status;

}