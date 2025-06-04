package cn.iocoder.yudao.module.system.service.special;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.special.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialDO;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 特殊服务类别 Service 接口
 *
 * @author 沈文杰
 */
public interface SpecialService {

    /**
     * 创建特殊服务类别
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSpecial(@Valid SpecialSaveReqVO createReqVO);

    /**
     * 更新特殊服务类别
     *
     * @param updateReqVO 更新信息
     */
    void updateSpecial(@Valid SpecialSaveReqVO updateReqVO);

    /**
     * 删除特殊服务类别
     *
     * @param id 编号
     */
    void deleteSpecial(Long id);

    /**
    * 批量删除特殊服务类别
    *
    * @param ids 编号
    */
    void deleteSpecialListByIds(List<Long> ids);

    /**
     * 获得特殊服务类别
     *
     * @param id 编号
     * @return 特殊服务类别
     */
    SpecialDO getSpecial(Long id);

    /**
     * 获得特殊服务类别分页
     *
     * @param pageReqVO 分页查询
     * @return 特殊服务类别分页
     */
    PageResult<SpecialDO> getSpecialPage(SpecialPageReqVO pageReqVO);

    // ==================== 子表（特殊服务项目） ====================

    /**
     * 获得特殊服务项目列表
     *
     * @param specialTypeId 服务类别编号
     * @return 特殊服务项目列表
     */
    List<SpecialItemDO> getSpecialItemListBySpecialTypeId(Long specialTypeId);

}