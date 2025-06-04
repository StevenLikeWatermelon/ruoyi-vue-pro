package cn.iocoder.yudao.module.system.service.special;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.special.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 特殊服务项目 Service 接口
 *
 * @author 沈文杰
 */
public interface SpecialItemService {

    /**
     * 创建特殊服务项目
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSpecialItem(@Valid SpecialItemSaveReqVO createReqVO);

    /**
     * 更新特殊服务项目
     *
     * @param updateReqVO 更新信息
     */
    void updateSpecialItem(@Valid SpecialItemSaveReqVO updateReqVO);

    /**
     * 删除特殊服务项目
     *
     * @param id 编号
     */
    void deleteSpecialItem(Long id);

    /**
    * 批量删除特殊服务项目
    *
    * @param ids 编号
    */
    void deleteSpecialItemListByIds(List<Long> ids);

    /**
     * 获得特殊服务项目
     *
     * @param id 编号
     * @return 特殊服务项目
     */
    SpecialItemDO getSpecialItem(Long id);

    /**
     * 获得特殊服务项目分页
     *
     * @param pageReqVO 分页查询
     * @return 特殊服务项目分页
     */
    PageResult<SpecialItemDO> getSpecialItemPage(SpecialItemPageReqVO pageReqVO);

}