package cn.iocoder.yudao.module.elderly.controller.admin.reserve.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 预约登记新增/修改 Request VO")
@Data
public class ReserveSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "27228")
    private Long id;

    @Schema(description = "咨询人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "咨询人姓名不能为空")
    private String consultantName;

    @Schema(description = "与老人关系")
    private String relationship;

    @Schema(description = "咨询日期")
    private LocalDateTime consultationDate;

    @Schema(description = "联系方式", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "联系方式不能为空")
    private String contactPhone;

    @Schema(description = "老人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "老人姓名不能为空")
    private String elderlyName;

    @Schema(description = "老人性别", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "老人性别不能为空")
    private Integer elderlyGender;

    @Schema(description = "老人年龄", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "老人年龄不能为空")
    private Integer elderlyAge;

    @Schema(description = "自理情况")
    private String selfCareAbility;

    @Schema(description = "家庭住址")
    private String elderlyAddress;

    @Schema(description = "咨询方式")
    private String consultationMethod;

    @Schema(description = "咨询意向")
    private String consultationIntention;

    @Schema(description = "咨询次数", requiredMode = Schema.RequiredMode.REQUIRED, example = "25402")
    @NotNull(message = "咨询次数不能为空")
    private Integer consultationCount;

    @Schema(description = "媒介渠道")
    private String mediaChannel;

    @Schema(description = "推荐人")
    private String referrer;

    @Schema(description = "负责人编号", example = "20537")
    private Long managerId;

    @Schema(description = "负责人姓名", example = "赵六")
    private String managerName;

    @Schema(description = "备注", example = "随便")
    private String remark;

    @Schema(description = "选择床位", requiredMode = Schema.RequiredMode.REQUIRED, example = "28007")
    @NotNull(message = "选择床位不能为空")
    private Long bedId;

    @Schema(description = "计划入住时间")
    private LocalDateTime plannedCheckinTime;

    @Schema(description = "预约金", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "预约金不能为空")
    private BigDecimal reservationFee;

    @Schema(description = "预留结束时间")
    private LocalDateTime reserveEndTime;

    @Schema(description = "预留开始时间")
    private LocalDateTime reserveStartTime;

}