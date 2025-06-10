package cn.iocoder.yudao.module.elderly.controller.admin.reserve.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 预约登记 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ReserveRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "27228")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "咨询人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("咨询人姓名")
    private String consultantName;

    @Schema(description = "与老人关系")
    @ExcelProperty("与老人关系")
    private String relationship;

    @Schema(description = "咨询日期")
    @ExcelProperty("咨询日期")
    private LocalDateTime consultationDate;

    @Schema(description = "联系方式", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("联系方式")
    private String contactPhone;

    @Schema(description = "老人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("老人姓名")
    private String elderlyName;

    @Schema(description = "老人性别", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("老人性别")
    private Integer elderlyGender;

    @Schema(description = "老人年龄", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("老人年龄")
    private Integer elderlyAge;

    @Schema(description = "自理情况")
    @ExcelProperty("自理情况")
    private String selfCareAbility;

    @Schema(description = "家庭住址")
    @ExcelProperty("家庭住址")
    private String elderlyAddress;

    @Schema(description = "咨询方式")
    @ExcelProperty("咨询方式")
    private String consultationMethod;

    @Schema(description = "咨询意向")
    @ExcelProperty("咨询意向")
    private String consultationIntention;

    @Schema(description = "咨询次数", requiredMode = Schema.RequiredMode.REQUIRED, example = "25402")
    @ExcelProperty("咨询次数")
    private Integer consultationCount;

    @Schema(description = "媒介渠道")
    @ExcelProperty("媒介渠道")
    private String mediaChannel;

    @Schema(description = "推荐人")
    @ExcelProperty("推荐人")
    private String referrer;

    @Schema(description = "负责人编号", example = "20537")
    @ExcelProperty("负责人编号")
    private Long managerId;

    @Schema(description = "负责人姓名", example = "赵六")
    @ExcelProperty("负责人姓名")
    private String managerName;

    @Schema(description = "备注", example = "随便")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建者")
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新者")
    @ExcelProperty("更新者")
    private String updater;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "是否删除", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否删除")
    private Boolean deleted;

    @Schema(description = "选择床位", requiredMode = Schema.RequiredMode.REQUIRED, example = "28007")
    @ExcelProperty("选择床位")
    private Long bedId;

    @Schema(description = "计划入住时间")
    @ExcelProperty("计划入住时间")
    private LocalDateTime plannedCheckinTime;

    @Schema(description = "预约金", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("预约金")
    private BigDecimal reservationFee;

    @Schema(description = "预留结束时间")
    @ExcelProperty("预留结束时间")
    private LocalDateTime reserveEndTime;

    @Schema(description = "预留开始时间")
    @ExcelProperty("预留开始时间")
    private LocalDateTime reserveStartTime;

    @Schema(description = "老人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("老人编号")
    private Long elderlyId;

}