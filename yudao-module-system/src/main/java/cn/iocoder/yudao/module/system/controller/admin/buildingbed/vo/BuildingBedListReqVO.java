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

    @Schema(description = "名字", example = "王五")
    private String name;

    @Schema(description = "父级信息", example = "30220")
    private Long parentId;

    @Schema(description = "楼栋图片")
    private String buildingImage;

    @Schema(description = "室内定位楼栋ID", example = "15670")
    private String buildingId;

    @Schema(description = "室内吸顶定位信标", example = "15902")
    private String beaconId;

    @Schema(description = "地面防水定位信标", example = "22415")
    private String waterproofBeaconId;

    @Schema(description = "X轴长度")
    private String floorLength;

    @Schema(description = "Y轴长度")
    private String floorWidth;

    @Schema(description = "楼层ID", example = "29802")
    private String floorId;

    @Schema(description = "房间面积")
    private String roomArea;

    @Schema(description = "房间等级")
    private String roomLevel;

    @Schema(description = "房间类别")
    private String roomCategory;

    @Schema(description = "卫生间")
    private String toilet;

    @Schema(description = "厨房")
    private String kitchen;

    @Schema(description = "房间朝向")
    private String roomOrientation;

    @Schema(description = "房间采光")
    private String roomLighting;

    @Schema(description = "房间通风")
    private String roomVentilation;

    @Schema(description = "室内地图坐标 X")
    private String roomX;

    @Schema(description = "室内地图坐标 Y")
    private String roomY;

    @Schema(description = "室内地图区域名称", example = "赵六")
    private String roomAreaName;

    @Schema(description = "床位名称", example = "李四")
    private String bedName;

    @Schema(description = "床位价格", example = "32650")
    private String bedPrice;

    @Schema(description = "床位类型", example = "2")
    private String bedType;

    @Schema(description = "创建者")
    private String creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "更新者")
    private String updater;

    @Schema(description = "更新时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] updateTime;

    @Schema(description = "是否删除")
    private Boolean deleted;

}