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
                .eqIfPresent(BuildingBedDO::getBedType, reqVO.getBedType())
                .eqIfPresent(BuildingBedDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(BuildingBedDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BuildingBedDO::getId));
    }

	default BuildingBedDO selectByParentIdAndName(Long parentId, String name) {
	    return selectOne(BuildingBedDO::getParentId, parentId, BuildingBedDO::getName, name);
	}

    default Long selectCountByParentId(Long parentId) {
        return selectCount(BuildingBedDO::getParentId, parentId);
    }

}