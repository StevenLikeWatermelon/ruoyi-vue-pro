package cn.iocoder.yudao.module.elderly.service.feesdailyconsumpt;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.feesdailyconsumpt.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesdailyconsumpt.FeesDailyConsumptDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 日常消费 Service 接口
 *
 * @author 沈文杰
 */
public interface FeesDailyConsumptService {

    /**
     * 创建日常消费
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFeesDailyConsumpt(@Valid FeesDailyConsumptSaveReqVO createReqVO);

    /**
     * 更新日常消费
     *
     * @param updateReqVO 更新信息
     */
    void updateFeesDailyConsumpt(@Valid FeesDailyConsumptSaveReqVO updateReqVO);

    /**
     * 删除日常消费
     *
     * @param id 编号
     */
    void deleteFeesDailyConsumpt(Long id);

    /**
    * 批量删除日常消费
    *
    * @param ids 编号
    */
    void deleteFeesDailyConsumptListByIds(List<Long> ids);

    /**
     * 获得日常消费
     *
     * @param id 编号
     * @return 日常消费
     */
    FeesDailyConsumptDO getFeesDailyConsumpt(Long id);

    /**
     * 获得日常消费分页
     *
     * @param pageReqVO 分页查询
     * @return 日常消费分页
     */
    PageResult<FeesDailyConsumptDO> getFeesDailyConsumptPage(FeesDailyConsumptPageReqVO pageReqVO);

}