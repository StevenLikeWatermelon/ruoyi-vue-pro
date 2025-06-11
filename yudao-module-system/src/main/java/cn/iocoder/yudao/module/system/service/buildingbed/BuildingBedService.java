package cn.iocoder.yudao.module.system.service.buildingbed;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.buildingbed.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.buildingbed.BuildingBedDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 楼层床位 Service 接口
 *
 * @author 沈文杰
 */
public interface BuildingBedService {

    /**
     * 创建楼层床位
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBuildingBed(@Valid BuildingBedSaveReqVO createReqVO);

    /**
     * 更新楼层床位
     *
     * @param updateReqVO 更新信息
     */
    void updateBuildingBed(@Valid BuildingBedSaveReqVO updateReqVO);

    /**
     * 更新床位状态
     *
     * @param id 床位编号
     * @param hasReserved 是否已预约
     * @param hasUsed 是否已入住
     * @param hasTried 是否已试住
     */
    void updateBedStatus(Long id, String hasReserved, String hasUsed, String hasTried);

    /**
     * 删除楼层床位
     *
     * @param id 编号
     */
    void deleteBuildingBed(Long id);


    /**
     * 获得楼层床位
     *
     * @param id 编号
     * @return 楼层床位
     */
    BuildingBedDO getBuildingBed(Long id);

    /**
     * 获得楼层床位列表
     *
     * @param listReqVO 查询条件
     * @return 楼层床位列表
     */
    List<BuildingBedDO> getBuildingBedList(BuildingBedListReqVO listReqVO);

    /**
     * 更新床位预订人
     *
     * @param id 床位编号
     * @param hasReserved 是否已预约
     * @param userBedId 预订人ID
     */
    void updateBedReserve(Long id, String hasReserved, Long userBedId);

}