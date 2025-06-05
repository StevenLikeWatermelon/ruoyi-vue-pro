package cn.iocoder.yudao.module.system.controller.admin.buildingbed.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 楼层床位列表 Request VO")
@Data
public class BuildingBedListReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "名字", example = "王五")
    private String name;

    @Schema(description = "床位类型", example = "1")
    private String bedType;

    @Schema(description = "节点层级", example = "1")
    private String level;

    @Schema(description = "已入住", example = "1")
    private String hasUsed;

    @Schema(description = "已试住", example = "1")
    private String hasTried;

    @Schema(description = "已预约", example = "1")
    private String hasReserved;

    @Schema(description = "创建者")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}