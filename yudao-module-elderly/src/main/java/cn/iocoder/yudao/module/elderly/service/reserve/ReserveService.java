package cn.iocoder.yudao.module.elderly.service.reserve;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.reserve.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.reserve.ReserveDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 预约登记 Service 接口
 *
 * @author 沈文杰
 */
public interface ReserveService {

    /**
     * 创建预约登记
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createReserve(@Valid ReserveSaveReqVO createReqVO);

    /**
     * 更新预约登记
     *
     * @param updateReqVO 更新信息
     */
    void updateReserve(@Valid ReserveSaveReqVO updateReqVO);

    /**
     * 删除预约登记
     *
     * @param id 编号
     */
    void deleteReserve(Long id);

    /**
    * 批量删除预约登记
    *
    * @param ids 编号
    */
    void deleteReserveListByIds(List<Long> ids);

    /**
     * 获得预约登记
     *
     * @param id 编号
     * @return 预约登记
     */
    ReserveDO getReserve(Long id);

    /**
     * 获得预约登记分页
     *
     * @param pageReqVO 分页查询
     * @return 预约登记分页
     */
    PageResult<ReserveDO> getReservePage(ReservePageReqVO pageReqVO);

}