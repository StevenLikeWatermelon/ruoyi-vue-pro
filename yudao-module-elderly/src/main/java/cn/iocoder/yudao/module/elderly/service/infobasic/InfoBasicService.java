package cn.iocoder.yudao.module.elderly.service.infobasic;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.elderly.controller.admin.infobasic.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.infobasic.InfoBasicDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 老人基本信息 Service 接口
 *
 * @author 沈文杰
 */
public interface InfoBasicService {

    /**
     * 创建老人基本信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInfoBasic(@Valid InfoBasicSaveReqVO createReqVO);

    /**
     * 更新老人基本信息
     *
     * @param updateReqVO 更新信息
     */
    void updateInfoBasic(@Valid InfoBasicSaveReqVO updateReqVO);

    /**
     * 删除老人基本信息
     *
     * @param id 编号
     */
    void deleteInfoBasic(Long id);

    /**
    * 批量删除老人基本信息
    *
    * @param ids 编号
    */
    void deleteInfoBasicListByIds(List<Long> ids);

    /**
     * 获得老人基本信息
     *
     * @param id 编号
     * @return 老人基本信息
     */
    InfoBasicDO getInfoBasic(Long id);

    /**
     * 获得老人基本信息分页
     *
     * @param pageReqVO 分页查询
     * @return 老人基本信息分页
     */
    PageResult<InfoBasicDO> getInfoBasicPage(InfoBasicPageReqVO pageReqVO);

}