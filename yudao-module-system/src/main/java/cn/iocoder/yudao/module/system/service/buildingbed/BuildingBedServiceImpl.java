package cn.iocoder.yudao.module.system.service.buildingbed;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.buildingbed.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.buildingbed.BuildingBedDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.buildingbed.BuildingBedMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 楼层床位 Service 实现类
 *
 * @author 沈文杰
 */
@Service
@Validated
public class BuildingBedServiceImpl implements BuildingBedService {

    @Resource
    private BuildingBedMapper buildingBedMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createBuildingBed(BuildingBedSaveReqVO createReqVO) {
        // 校验父级编号的有效性
        validateParentBuildingBed(null, createReqVO.getParentId());
        // 校验名字的唯一性
        validateBuildingBedNameUnique(null, createReqVO.getParentId(), createReqVO.getName());

        // 插入
        BuildingBedDO buildingBed = BeanUtils.toBean(createReqVO, BuildingBedDO.class);
        buildingBedMapper.insert(buildingBed);

        // // 如果是房间（level == 2）且存在房间等级，则自动创建床位
        // if ("2".equals(createReqVO.getLevel()) && createReqVO.getRoomLevel() != null) {
        //     int bedCount = 0;
        //     switch (createReqVO.getRoomLevel()) {
        //         case "1": // 单人间
        //             bedCount = 1;
        //             break;
        //         case "2": // 双人间
        //             bedCount = 2;
        //             break;
        //         case "3": // 三人间
        //             bedCount = 3;
        //             break;
        //         case "4": // 四人间
        //             bedCount = 4;
        //             break;
        //     }

        //     // 创建床位
        //     for (int i = 1; i <= bedCount; i++) {
        //         BuildingBedDO bed = new BuildingBedDO();
        //         bed.setParentId(buildingBed.getId());
        //         bed.setName(createReqVO.getName() + "-" + i + "号床");
        //         bed.setLevel("3"); // 设置层级为床位
        //         bed.setHasUsed("0");
        //         bed.setHasTried("0");
        //         bed.setHasReserved("0");
        //         buildingBedMapper.insert(bed);
        //     }
        // }

        // 返回
        return buildingBed.getId();
    }

    @Override
    public void updateBuildingBed(BuildingBedSaveReqVO updateReqVO) {
        // 校验存在
        validateBuildingBedExists(updateReqVO.getId());
        // 校验父级编号的有效性
        validateParentBuildingBed(updateReqVO.getId(), updateReqVO.getParentId());
        // 校验名字的唯一性
        validateBuildingBedNameUnique(updateReqVO.getId(), updateReqVO.getParentId(), updateReqVO.getName());

        // 更新
        BuildingBedDO updateObj = BeanUtils.toBean(updateReqVO, BuildingBedDO.class);
        buildingBedMapper.updateById(updateObj);
    }

    @Override
    public void deleteBuildingBed(Long id) {
        // 校验存在
        validateBuildingBedExists(id);
        // 校验是否有子楼层床位
        if (buildingBedMapper.selectCountByParentId(id) > 0) {
            throw exception(BUILDING_BED_EXITS_CHILDREN);
        }
        // 删除
        buildingBedMapper.deleteById(id);
    }

    @Override
    public void updateBedStatus(Long id, String hasReserved, String hasUsed, String hasTried) {
        // 校验存在
        validateBuildingBedExists(id);
        // 更新状态
        BuildingBedDO updateObj = new BuildingBedDO();
        updateObj.setId(id);
        updateObj.setHasReserved(hasReserved);
        updateObj.setHasUsed(hasUsed);
        updateObj.setHasTried(hasTried);
        buildingBedMapper.updateById(updateObj);
    }

    @Override
    public void updateBedReserve(Long id, String hasReserved, Long userBedId) {
        // 校验存在
        validateBuildingBedExists(id);
        // 更新状态
        BuildingBedDO updateObj = new BuildingBedDO();
        updateObj.setId(id);
        updateObj.setHasReserved(hasReserved);
        updateObj.setUserBedId(userBedId);
        buildingBedMapper.updateById(updateObj);
    }

    private void validateBuildingBedExists(Long id) {
        if (buildingBedMapper.selectById(id) == null) {
            throw exception(BUILDING_BED_NOT_EXISTS);
        }
    }

    private void validateParentBuildingBed(Long id, Long parentId) {
        if (parentId == null || BuildingBedDO.PARENT_ID_ROOT.equals(parentId)) {
            return;
        }
        // 1. 不能设置自己为父楼层床位
        if (Objects.equals(id, parentId)) {
            throw exception(BUILDING_BED_PARENT_ERROR);
        }
        // 2. 父楼层床位不存在
        BuildingBedDO parentBuildingBed = buildingBedMapper.selectById(parentId);
        if (parentBuildingBed == null) {
            throw exception(BUILDING_BED_PARENT_NOT_EXITS);
        }
        // 3. 递归校验父楼层床位，如果父楼层床位是自己的子楼层床位，则报错，避免形成环路
        if (id == null) { // id 为空，说明新增，不需要考虑环路
            return;
        }
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            // 3.1 校验环路
            parentId = parentBuildingBed.getParentId();
            if (Objects.equals(id, parentId)) {
                throw exception(BUILDING_BED_PARENT_IS_CHILD);
            }
            // 3.2 继续递归下一级父楼层床位
            if (parentId == null || BuildingBedDO.PARENT_ID_ROOT.equals(parentId)) {
                break;
            }
            parentBuildingBed = buildingBedMapper.selectById(parentId);
            if (parentBuildingBed == null) {
                break;
            }
        }
    }

    private void validateBuildingBedNameUnique(Long id, Long parentId, String name) {
        BuildingBedDO buildingBed = buildingBedMapper.selectByParentIdAndName(parentId, name);
        if (buildingBed == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的楼层床位
        if (id == null) {
            throw exception(BUILDING_BED_NAME_DUPLICATE);
        }
        if (!Objects.equals(buildingBed.getId(), id)) {
            throw exception(BUILDING_BED_NAME_DUPLICATE);
        }
    }

    @Override
    public BuildingBedDO getBuildingBed(Long id) {
        return buildingBedMapper.selectById(id);
    }

    @Override
    public List<BuildingBedDO> getBuildingBedList(BuildingBedListReqVO listReqVO) {
        return buildingBedMapper.selectList(listReqVO);
    }

}