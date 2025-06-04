package cn.iocoder.yudao.module.system.dal.mysql.buildingbed;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.buildingbed.BuildingBedDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.buildingbed.vo.*;

/**
 * 楼层床位 Mapper
 *
 * @author 沈文杰
 */
@Mapper
public interface BuildingBedMapper extends BaseMapperX<BuildingBedDO> {

    default List<BuildingBedDO> selectList(BuildingBedListReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<BuildingBedDO>()
                .likeIfPresent(BuildingBedDO::getName, reqVO.getName())
                .eqIfPresent(BuildingBedDO::getParentId, reqVO.getParentId())
                .eqIfPresent(BuildingBedDO::getBuildingImage, reqVO.getBuildingImage())
                .eqIfPresent(BuildingBedDO::getBuildingId, reqVO.getBuildingId())
                .eqIfPresent(BuildingBedDO::getBeaconId, reqVO.getBeaconId())
                .eqIfPresent(BuildingBedDO::getWaterproofBeaconId, reqVO.getWaterproofBeaconId())
                .eqIfPresent(BuildingBedDO::getFloorLength, reqVO.getFloorLength())
                .eqIfPresent(BuildingBedDO::getFloorWidth, reqVO.getFloorWidth())
                .eqIfPresent(BuildingBedDO::getFloorId, reqVO.getFloorId())
                .eqIfPresent(BuildingBedDO::getRoomArea, reqVO.getRoomArea())
                .eqIfPresent(BuildingBedDO::getRoomLevel, reqVO.getRoomLevel())
                .eqIfPresent(BuildingBedDO::getRoomCategory, reqVO.getRoomCategory())
                .eqIfPresent(BuildingBedDO::getToilet, reqVO.getToilet())
                .eqIfPresent(BuildingBedDO::getKitchen, reqVO.getKitchen())
                .eqIfPresent(BuildingBedDO::getRoomOrientation, reqVO.getRoomOrientation())
                .eqIfPresent(BuildingBedDO::getRoomLighting, reqVO.getRoomLighting())
                .eqIfPresent(BuildingBedDO::getRoomVentilation, reqVO.getRoomVentilation())
                .eqIfPresent(BuildingBedDO::getRoomX, reqVO.getRoomX())
                .eqIfPresent(BuildingBedDO::getRoomY, reqVO.getRoomY())
                .likeIfPresent(BuildingBedDO::getRoomAreaName, reqVO.getRoomAreaName())
                .likeIfPresent(BuildingBedDO::getBedName, reqVO.getBedName())
                .eqIfPresent(BuildingBedDO::getBedPrice, reqVO.getBedPrice())
                .eqIfPresent(BuildingBedDO::getBedType, reqVO.getBedType())
                .eqIfPresent(BuildingBedDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(BuildingBedDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(BuildingBedDO::getUpdater, reqVO.getUpdater())
                .betweenIfPresent(BuildingBedDO::getUpdateTime, reqVO.getUpdateTime())
                .eqIfPresent(BuildingBedDO::getDeleted, reqVO.getDeleted())
                .orderByDesc(BuildingBedDO::getId));
    }

	default BuildingBedDO selectByIdAndName(Long id, String name) {
	    return selectOne(BuildingBedDO::getId, id, BuildingBedDO::getName, name);
	}

    default Long selectCountById(Long id) {
        return selectCount(BuildingBedDO::getId, id);
    }

}