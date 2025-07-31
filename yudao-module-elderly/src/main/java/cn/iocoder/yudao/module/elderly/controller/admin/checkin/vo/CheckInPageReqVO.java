package cn.iocoder.yudao.module.elderly.controller.admin.checkin.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 老人入住信息分页 Request VO")
@Data
public class CheckInPageReqVO extends PageParam { 

    @Schema(description = "编号", example = "29770")
    private Long id;

    @Schema(description = "入住老人", example = "张三")
    private String visitorName;

    @Schema(description = "备注")
    private String notes;

    @Schema(description = "合同上传")
    private String attachmentPath;

    @Schema(description = "创建者")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "床位编号", example = "101")
    private Long bedId;

    @Schema(description = "床位名称", example = "101 号床位")
    private String bedName;
    // processInstanceId和status
    @Schema(description = "工作流实例编号")
    private String processInstanceId;

    @Schema(description = "工作流实例状态")
    private String status;


    @Schema(description = "是否删除")
    private Boolean deleted;
    
}