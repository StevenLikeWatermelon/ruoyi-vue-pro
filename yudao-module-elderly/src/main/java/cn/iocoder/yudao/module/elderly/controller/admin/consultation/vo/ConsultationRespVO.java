package cn.iocoder.yudao.module.elderly.controller.admin.consultation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.time.LocalDate;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 咨询登记 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ConsultationRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "28846")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "老人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("老人编号")
    private Long elderlyId;

    @Schema(description = "咨询人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("咨询人姓名")
    private String consultantName;

    @Schema(description = "与老人关系", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "与老人关系", converter = DictConvert.class)
    @DictFormat("elderly_relationship") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String relationship;

    @Schema(description = "咨询日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("咨询日期")
    private LocalDate consultationDate;

    @Schema(description = "联系方式", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("联系方式")
    private String contactPhone;

    @Schema(description = "老人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("老人姓名")
    private String elderlyName;

    @Schema(description = "老人性别", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "老人性别", converter = DictConvert.class)
    @DictFormat("system_user_sex") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer elderlyGender;

    @Schema(description = "老人年龄", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("老人年龄")
    private Integer elderlyAge;

    @Schema(description = "自理情况", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "自理情况", converter = DictConvert.class)
    @DictFormat("self_care_ability") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String selfCareAbility;

    @Schema(description = "家庭住址", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("家庭住址")
    private String elderlyAddress;

    @Schema(description = "咨询方式", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "咨询方式", converter = DictConvert.class)
    @DictFormat("consultation_method") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String consultationMethod;

    @Schema(description = "咨询意向", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "咨询意向", converter = DictConvert.class)
    @DictFormat("consultation_intention") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String consultationIntention;

    @Schema(description = "咨询次数", requiredMode = Schema.RequiredMode.REQUIRED, example = "18013")
    @ExcelProperty("咨询次数")
    private Integer consultationCount;

    @Schema(description = "媒介渠道", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "媒介渠道", converter = DictConvert.class)
    @DictFormat("media_channel") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String mediaChannel;

    @Schema(description = "推荐人")
    @ExcelProperty("推荐人")
    private String referrer;

    @Schema(description = "负责人编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13968")
    @ExcelProperty("负责人编号")
    private Long managerId;

    @Schema(description = "负责人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("负责人姓名")
    private String managerName;

    @Schema(description = "备注", example = "你猜")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建人", example = "李四")
    @ExcelProperty("创建人")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}