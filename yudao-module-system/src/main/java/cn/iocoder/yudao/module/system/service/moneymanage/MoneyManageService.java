package cn.iocoder.yudao.module.system.service.moneymanage;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.moneymanage.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.moneymanage.MoneyManageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 基础费用管理 Service 接口
 *
 * @author 芋道源码
 */
public interface MoneyManageService {

    /**
     * 创建基础费用管理
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMoneyManage(@Valid MoneyManageSaveReqVO createReqVO);

    /**
     * 更新基础费用管理
     *
     * @param updateReqVO 更新信息
     */
    void updateMoneyManage(@Valid MoneyManageSaveReqVO updateReqVO);

    /**
     * 删除基础费用管理
     *
     * @param id 编号
     */
    void deleteMoneyManage(Long id);

    /**
    * 批量删除基础费用管理
    *
    * @param ids 编号
    */
    void deleteMoneyManageListByIds(List<Long> ids);

    /**
     * 获得基础费用管理
     *
     * @param id 编号
     * @return 基础费用管理
     */
    MoneyManageDO getMoneyManage(Long id);

    /**
     * 获得基础费用管理分页
     *
     * @param pageReqVO 分页查询
     * @return 基础费用管理分页
     */
    PageResult<MoneyManageDO> getMoneyManagePage(MoneyManagePageReqVO pageReqVO);

}