package cn.iocoder.yudao.module.elderly.service.consultation;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.consultation.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.consultation.ConsultationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 咨询登记 Service 接口
 *
 * @author 芋道源码
 */
public interface ConsultationService {

    /**
     * 创建咨询登记
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createConsultation(@Valid ConsultationSaveReqVO createReqVO);

    /**
     * 更新咨询登记
     *
     * @param updateReqVO 更新信息
     */
    void updateConsultation(@Valid ConsultationSaveReqVO updateReqVO);

    /**
     * 删除咨询登记
     *
     * @param id 编号
     */
    void deleteConsultation(Long id);

    /**
    * 批量删除咨询登记
    *
    * @param ids 编号
    */
    void deleteConsultationListByIds(List<Long> ids);

    /**
     * 获得咨询登记
     *
     * @param id 编号
     * @return 咨询登记
     */
    ConsultationDO getConsultation(Long id);

    /**
     * 获得咨询登记分页
     *
     * @param pageReqVO 分页查询
     * @return 咨询登记分页
     */
    PageResult<ConsultationDO> getConsultationPage(ConsultationPageReqVO pageReqVO);

}