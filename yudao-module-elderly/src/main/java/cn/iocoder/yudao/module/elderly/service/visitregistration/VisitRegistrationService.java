package cn.iocoder.yudao.module.elderly.service.visitregistration;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.visitregistration.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.visitregistration.VisitRegistrationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 来访登记 Service 接口
 *
 * @author 沈文杰
 */
public interface VisitRegistrationService {

    /**
     * 创建来访登记
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createVisitRegistration(@Valid VisitRegistrationSaveReqVO createReqVO);

    /**
     * 更新来访登记
     *
     * @param updateReqVO 更新信息
     */
    void updateVisitRegistration(@Valid VisitRegistrationSaveReqVO updateReqVO);

    /**
     * 删除来访登记
     *
     * @param id 编号
     */
    void deleteVisitRegistration(Long id);

    /**
    * 批量删除来访登记
    *
    * @param ids 编号
    */
    void deleteVisitRegistrationListByIds(List<Long> ids);

    /**
     * 获得来访登记
     *
     * @param id 编号
     * @return 来访登记
     */
    VisitRegistrationDO getVisitRegistration(Long id);

    /**
     * 获得来访登记分页
     *
     * @param pageReqVO 分页查询
     * @return 来访登记分页
     */
    PageResult<VisitRegistrationDO> getVisitRegistrationPage(VisitRegistrationPageReqVO pageReqVO);

}