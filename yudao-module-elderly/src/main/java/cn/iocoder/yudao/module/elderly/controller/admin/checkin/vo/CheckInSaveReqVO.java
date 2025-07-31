package cn.iocoder.yudao.module.elderly.controller.admin.checkin.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 老人入住信息新增/修改 Request VO")
@Data
public class CheckInSaveReqVO { 

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "29770")
    private Long id;

    @Schema(description = "入住老人", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    private Long visitorName;

    @Schema(description = "备注")
    private String notes;

    @Schema(description = "合同上传")
    private String attachmentPath;

    @Schema(description = "床位编号", example = "101")
    private Long bedId;

    @Schema(description = "床位名称", example = "101 号床位")
    private String bedName;

    @Schema(description = "工作流实例编号")
    private String processInstanceId;

    @Schema(description = "工作流实例状态")
    private String status;
    
    @Schema(description = "消费套餐ID", example = "套餐1")
    private String dailyConsumptId;

    @Schema(description = "老人费用余额ID", example = "101")
    private Long overviewId;
}