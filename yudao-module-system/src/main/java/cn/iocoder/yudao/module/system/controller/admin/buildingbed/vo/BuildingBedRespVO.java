package cn.iocoder.yudao.module.system.controller.admin.buildingbed.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 楼层床位 Response VO")
@Data
@ExcelIgnoreUnannotated
public class BuildingBedRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "24549")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("名字")
    private String name;

    @Schema(description = "父级编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "18050")
    @ExcelProperty("父级编号")
    private Long parentId;

    @Schema(description = "楼栋图片")
    @ExcelProperty("楼栋图片")
    private String buildingImage;

    @Schema(description = "室内定位楼栋ID", example = "2349")
    @ExcelProperty("室内定位楼栋ID")
    private String buildingId;

    @Schema(description = "室内吸顶定位信标", example = "31390")
    @ExcelProperty("室内吸顶定位信标")
    private String beaconId;

    @Schema(description = "地面防水定位信标", example = "30655")
    @ExcelProperty("地面防水定位信标")
    private String waterproofBeaconId;

    @Schema(description = "X轴长度")
    @ExcelProperty("X轴长度")
    private String floorLength;

    @Schema(description = "Y轴长度")
    @ExcelProperty("Y轴长度")
    private String floorWidth;

    @Schema(description = "楼层ID", example = "15470")
    @ExcelProperty("楼层ID")
    private String floorId;

    @Schema(description = "房间面积")
    @ExcelProperty("房间面积")
    private String roomArea;

    @Schema(description = "房间等级")
    @ExcelProperty(value = "房间等级", converter = DictConvert.class)
    @DictFormat("room_level") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String roomLevel;

    @Schema(description = "房间类别")
    @ExcelProperty(value = "房间类别", converter = DictConvert.class)
    @DictFormat("room_category") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String roomCategory;

    @Schema(description = "卫生间")
    @ExcelProperty(value = "卫生间", converter = DictConvert.class)
    @DictFormat("has_or_no") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String toilet;

    @Schema(description = "厨房")
    @ExcelProperty(value = "厨房", converter = DictConvert.class)
    @DictFormat("has_or_no") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String kitchen;

    @Schema(description = "房间朝向")
    @ExcelProperty(value = "房间朝向", converter = DictConvert.class)
    @DictFormat("room_orientation") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String roomOrientation;

    @Schema(description = "房间采光")
    @ExcelProperty(value = "房间采光", converter = DictConvert.class)
    @DictFormat("room_lighting") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String roomLighting;

    @Schema(description = "房间通风")
    @ExcelProperty(value = "房间通风", converter = DictConvert.class)
    @DictFormat("room_ventilation") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String roomVentilation;

    @Schema(description = "室内地图坐标 X")
    @ExcelProperty("室内地图坐标 X")
    private String roomX;

    @Schema(description = "室内地图坐标 Y")
    @ExcelProperty("室内地图坐标 Y")
    private String roomY;

    @Schema(description = "室内地图区域名称", example = "王五")
    @ExcelProperty("室内地图区域名称")
    private String roomAreaName;

    @Schema(description = "床位价格", example = "18072")
    @ExcelProperty("床位价格")
    private String bedPrice;

    @Schema(description = "父级id链条")
    @ExcelProperty("父级id链条")
    private String parentIdChian;

    @Schema(description = "床位类型", example = "1")
    @ExcelProperty(value = "床位类型", converter = DictConvert.class)
    @DictFormat("bed_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String bedType;

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

}