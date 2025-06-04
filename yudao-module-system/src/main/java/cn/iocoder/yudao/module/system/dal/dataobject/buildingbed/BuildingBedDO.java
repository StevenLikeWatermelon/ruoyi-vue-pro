package cn.iocoder.yudao.module.system.dal.dataobject.buildingbed;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 楼层床位 DO
 *
 * @author 沈文杰
 */
@TableName("system_building_bed")
@KeySequence("system_building_bed_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuildingBedDO extends BaseDO {

    public static final Long PARENT_ID_ROOT = 0L;

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 父级编号
     */
    private Long parentId;
    /**
     * 楼栋图片
     */
    private String buildingImage;
    /**
     * 室内定位楼栋ID
     */
    private String buildingId;
    /**
     * 室内吸顶定位信标
     */
    private String beaconId;
    /**
     * 地面防水定位信标
     */
    private String waterproofBeaconId;
    /**
     * X轴长度
     */
    private String floorLength;
    /**
     * Y轴长度
     */
    private String floorWidth;
    /**
     * 楼层ID
     */
    private String floorId;
    /**
     * 房间面积
     */
    private String roomArea;
    /**
     * 房间等级
     *
     * 枚举 {@link TODO room_level 对应的类}
     */
    private String roomLevel;
    /**
     * 房间类别
     *
     * 枚举 {@link TODO room_category 对应的类}
     */
    private String roomCategory;
    /**
     * 卫生间
     *
     * 枚举 {@link TODO has_or_no 对应的类}
     */
    private String toilet;
    /**
     * 厨房
     *
     * 枚举 {@link TODO has_or_no 对应的类}
     */
    private String kitchen;
    /**
     * 房间朝向
     *
     * 枚举 {@link TODO room_orientation 对应的类}
     */
    private String roomOrientation;
    /**
     * 房间采光
     *
     * 枚举 {@link TODO room_lighting 对应的类}
     */
    private String roomLighting;
    /**
     * 房间通风
     *
     * 枚举 {@link TODO room_ventilation 对应的类}
     */
    private String roomVentilation;
    /**
     * 室内地图坐标 X
     */
    private String roomX;
    /**
     * 室内地图坐标 Y
     */
    private String roomY;
    /**
     * 室内地图区域名称
     */
    private String roomAreaName;
    /**
     * 床位价格
     */
    private String bedPrice;
    /**
     * 床位类型
     *
     * 枚举 {@link TODO bed_type 对应的类}
     */
    private String bedType;


}