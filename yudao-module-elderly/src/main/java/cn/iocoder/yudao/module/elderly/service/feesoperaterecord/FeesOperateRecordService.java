package cn.iocoder.yudao.module.elderly.service.feesoperaterecord;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.feesoperaterecord.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesoperaterecord.FeesOperateRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 费用操作记录 Service 接口
 *
 * @author 沈文杰
 */
public interface FeesOperateRecordService {

    /**
     * 创建费用操作记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFeesOperateRecord(@Valid FeesOperateRecordSaveReqVO createReqVO);

    /**
     * 更新费用操作记录
     *
     * @param updateReqVO 更新信息
     */
    void updateFeesOperateRecord(@Valid FeesOperateRecordSaveReqVO updateReqVO);

    /**
     * 删除费用操作记录
     *
     * @param id 编号
     */
    void deleteFeesOperateRecord(Long id);

    /**
    * 批量删除费用操作记录
    *
    * @param ids 编号
    */
    void deleteFeesOperateRecordListByIds(List<Long> ids);

    /**
     * 获得费用操作记录
     *
     * @param id 编号
     * @return 费用操作记录
     */
    FeesOperateRecordDO getFeesOperateRecord(Long id);

    /**
     * 获得费用操作记录分页
     *
     * @param pageReqVO 分页查询
     * @return 费用操作记录分页
     */
    PageResult<FeesOperateRecordDO> getFeesOperateRecordPage(FeesOperateRecordPageReqVO pageReqVO);

}