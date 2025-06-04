package cn.iocoder.yudao.module.elderly.controller.admin.consultation.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.time.LocalDate;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 咨询登记分页 Request VO")
@Data
public class ConsultationPageReqVO extends PageParam {

    @Schema(description = "咨询人姓名", example = "李四")
    private String consultantName;

    @Schema(description = "与老人关系")
    private String relationship;

    @Schema(description = "咨询日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] consultationDate;

    @Schema(description = "联系方式")
    private String contactPhone;

    @Schema(description = "老人姓名", example = "芋艿")
    private String elderlyName;

    @Schema(description = "老人性别")
    private Integer elderlyGender;

    @Schema(description = "老人年龄")
    private Integer elderlyAge;

    @Schema(description = "自理情况")
    private String selfCareAbility;

    @Schema(description = "家庭住址")
    private String elderlyAddress;

    @Schema(description = "咨询方式")
    private String consultationMethod;

    @Schema(description = "咨询意向")
    private String consultationIntention;

    @Schema(description = "咨询次数", example = "18013")
    private Integer consultationCount;

    @Schema(description = "媒介渠道")
    private String mediaChannel;

    @Schema(description = "推荐人")
    private String referrer;

    @Schema(description = "负责人编号", example = "13968")
    private Long managerId;

    @Schema(description = "负责人姓名", example = "李四")
    private String managerName;

    @Schema(description = "备注", example = "你猜")
    private String remark;

    @Schema(description = "创建人", example = "李四")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}