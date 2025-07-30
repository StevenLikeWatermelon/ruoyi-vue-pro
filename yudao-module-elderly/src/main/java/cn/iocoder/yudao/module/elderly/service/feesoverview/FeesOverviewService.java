package cn.iocoder.yudao.module.elderly.service.feesoverview;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.feesoverview.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesoverview.FeesOverviewDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 老人费用余额 Service 接口
 *
 * @author 护理一组组长
 */
public interface FeesOverviewService {

    /**
     * 创建老人费用余额
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFeesOverview(@Valid FeesOverviewSaveReqVO createReqVO);

    /**
     * 更新老人费用余额
     *
     * @param updateReqVO 更新信息
     */
    void updateFeesOverview(@Valid FeesOverviewSaveReqVO updateReqVO);

    /**
     * 删除老人费用余额
     *
     * @param id 编号
     */
    void deleteFeesOverview(Long id);

    /**
    * 批量删除老人费用余额
    *
    * @param ids 编号
    */
    void deleteFeesOverviewListByIds(List<Long> ids);

    /**
     * 获得老人费用余额
     *
     * @param id 编号
     * @return 老人费用余额
     */
    FeesOverviewDO getFeesOverview(Long id);

    /**
     * 获得老人费用余额分页
     *
     * @param pageReqVO 分页查询
     * @return 老人费用余额分页
     */
    PageResult<FeesOverviewDO> getFeesOverviewPage(FeesOverviewPageReqVO pageReqVO);

}