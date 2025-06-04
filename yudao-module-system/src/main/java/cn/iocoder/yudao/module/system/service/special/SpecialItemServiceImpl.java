package cn.iocoder.yudao.module.system.service.special;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.special.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.special.SpecialItemMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 特殊服务项目 Service 实现类
 *
 * @author 沈文杰
 */
@Service
@Validated
public class SpecialItemServiceImpl implements SpecialItemService {

    @Resource
    private SpecialItemMapper specialItemMapper;

    @Override
    public Long createSpecialItem(SpecialItemSaveReqVO createReqVO) {
        // 插入
        SpecialItemDO specialItem = BeanUtils.toBean(createReqVO, SpecialItemDO.class);
        specialItemMapper.insert(specialItem);
        // 返回
        return specialItem.getId();
    }

    @Override
    public void updateSpecialItem(SpecialItemSaveReqVO updateReqVO) {
        // 校验存在
        validateSpecialItemExists(updateReqVO.getId());
        // 更新
        SpecialItemDO updateObj = BeanUtils.toBean(updateReqVO, SpecialItemDO.class);
        specialItemMapper.updateById(updateObj);
    }

    @Override
    public void deleteSpecialItem(Long id) {
        // 校验存在
        validateSpecialItemExists(id);
        // 删除
        specialItemMapper.deleteById(id);
    }

    @Override
        public void deleteSpecialItemListByIds(List<Long> ids) {
        // 校验存在
        validateSpecialItemExists(ids);
        // 删除
        specialItemMapper.deleteByIds(ids);
        }

    private void validateSpecialItemExists(List<Long> ids) {
        List<SpecialItemDO> list = specialItemMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(SPECIAL_ITEM_NOT_EXISTS);
        }
    }

    private void validateSpecialItemExists(Long id) {
        if (specialItemMapper.selectById(id) == null) {
            throw exception(SPECIAL_ITEM_NOT_EXISTS);
        }
    }

    @Override
    public SpecialItemDO getSpecialItem(Long id) {
        return specialItemMapper.selectById(id);
    }

    @Override
    public PageResult<SpecialItemDO> getSpecialItemPage(SpecialItemPageReqVO pageReqVO) {
        return specialItemMapper.selectPage(pageReqVO);
    }

}