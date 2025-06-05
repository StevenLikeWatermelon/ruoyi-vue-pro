package cn.iocoder.yudao.module.system.controller.admin.buildingbed.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 楼层床位新增/修改 Request VO")
@Data
public class BuildingBedSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "24549")
    private Long id;

    @Schema(description = "名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "名字不能为空")
    private String name;

    @Schema(description = "父级编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "18050")
    @NotNull(message = "父级编号不能为空")
    private Long parentId;

    @Schema(description = "楼栋图片")
    private String buildingImage;

    @Schema(description = "室内定位楼栋ID", example = "2349")
    private String buildingId;

    @Schema(description = "室内吸顶定位信标", example = "31390")
    private String beaconId;

    @Schema(description = "地面防水定位信标", example = "30655")
    private String waterproofBeaconId;

    @Schema(description = "X轴长度")
    private String floorLength;

    @Schema(description = "Y轴长度")
    private String floorWidth;

    @Schema(description = "楼层ID", example = "15470")
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

    @Schema(description = "室内地图区域名称", example = "王五")
    private String roomAreaName;

    @Schema(description = "床位价格", example = "18072")
    private String bedPrice;

    @Schema(description = "床位类型", example = "1")
    private String bedType;

    @Schema(description = "父级id链条")
    private String parentIdChian;

    @Schema(description = "节点层级")
    private String level;

    @Schema(description = "已入住")
    private String hasUsed;

    @Schema(description = "已试住")
    private String hasTried;

    @Schema(description = "已预约")
    private String hasReserved;

}