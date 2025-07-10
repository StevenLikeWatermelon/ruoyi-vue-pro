package cn.iocoder.yudao.module.elderly.service.checkin;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.checkin.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.checkin.CheckInDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 老人入住信息 Service 接口
 *
 * @author 沈文杰
 */
public interface CheckInService {

    /**
     * 创建老人入住信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCheckIn(@Valid CheckInSaveReqVO createReqVO);

    /**
     * 更新老人入住信息
     *
     * @param updateReqVO 更新信息
     */
    void updateCheckIn(@Valid CheckInSaveReqVO updateReqVO);

    /**
     * 删除老人入住信息
     *
     * @param id 编号
     */
    void deleteCheckIn(Long id);

    /**
    * 批量删除老人入住信息
    *
    * @param ids 编号
    */
    void deleteCheckInListByIds(List<Long> ids);

    /**
     * 获得老人入住信息
     *
     * @param id 编号
     * @return 老人入住信息
     */
    CheckInDO getCheckIn(Long id);

    /**
     * 获得老人入住信息分页
     *
     * @param pageReqVO 分页查询
     * @return 老人入住信息分页
     */
    PageResult<CheckInDO> getCheckInPage(CheckInPageReqVO pageReqVO);

}