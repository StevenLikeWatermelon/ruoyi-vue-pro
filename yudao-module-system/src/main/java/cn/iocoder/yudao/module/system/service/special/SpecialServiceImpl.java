package cn.iocoder.yudao.module.system.service.special;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.special.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialDO;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.special.SpecialMapper;
import cn.iocoder.yudao.module.system.dal.mysql.special.SpecialItemMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 特殊服务类别 Service 实现类
 *
 * @author 沈文杰
 */
@Service
@Validated
public class SpecialServiceImpl implements SpecialService {

    @Resource
    private SpecialMapper specialMapper;
    @Resource
    private SpecialItemMapper specialItemMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createSpecial(SpecialSaveReqVO createReqVO) {
        // 插入
        SpecialDO special = BeanUtils.toBean(createReqVO, SpecialDO.class);
        specialMapper.insert(special);

        // 插入子表
        createSpecialItemList(special.getId(), createReqVO.getSpecialItems());
        // 返回
        return special.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSpecial(SpecialSaveReqVO updateReqVO) {
        // 校验存在
        validateSpecialExists(updateReqVO.getId());
        // 更新
        SpecialDO updateObj = BeanUtils.toBean(updateReqVO, SpecialDO.class);
        specialMapper.updateById(updateObj);

        // 更新子表
        updateSpecialItemList(updateReqVO.getId(), updateReqVO.getSpecialItems());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSpecial(Long id) {
        // 校验存在
        validateSpecialExists(id);
        // 删除
        specialMapper.deleteById(id);

        // 删除子表
        deleteSpecialItemBySpecialTypeId(id);
    }

    @Override
        @Transactional(rollbackFor = Exception.class)
    public void deleteSpecialListByIds(List<Long> ids) {
        // 校验存在
        validateSpecialExists(ids);
        // 删除
        specialMapper.deleteByIds(ids);
    
    // 删除子表
            deleteSpecialItemBySpecialTypeIds(ids);
    }

    private void validateSpecialExists(List<Long> ids) {
        List<SpecialDO> list = specialMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(SPECIAL_NOT_EXISTS);
        }
    }

    private void validateSpecialExists(Long id) {
        if (specialMapper.selectById(id) == null) {
            throw exception(SPECIAL_NOT_EXISTS);
        }
    }

    @Override
    public SpecialDO getSpecial(Long id) {
        return specialMapper.selectById(id);
    }

    @Override
    public PageResult<SpecialDO> getSpecialPage(SpecialPageReqVO pageReqVO) {
        return specialMapper.selectPage(pageReqVO);
    }

    // ==================== 子表（特殊服务项目） ====================

    @Override
    public List<SpecialItemDO> getSpecialItemListBySpecialTypeId(Long specialTypeId) {
        return specialItemMapper.selectListBySpecialTypeId(specialTypeId);
    }

    private void createSpecialItemList(Long specialTypeId, List<SpecialItemDO> list) {
        list.forEach(o -> o.setSpecialTypeId(specialTypeId).clean());
        specialItemMapper.insertBatch(list);
    }

    private void updateSpecialItemList(Long specialTypeId, List<SpecialItemDO> list) {
	    list.forEach(o -> o.setSpecialTypeId(specialTypeId).clean());
	    List<SpecialItemDO> oldList = specialItemMapper.selectListBySpecialTypeId(specialTypeId);
	    List<List<SpecialItemDO>> diffList = diffList(oldList, list, (oldVal, newVal) -> {
            boolean same = ObjectUtil.equal(oldVal.getId(), newVal.getId());
            if (same) {
                newVal.setId(oldVal.getId()).clean(); // 解决更新情况下：updateTime 不更新
            }
            return same;
	    });

	    // 第二步，批量添加、修改、删除
	    if (CollUtil.isNotEmpty(diffList.get(0))) {
	        specialItemMapper.insertBatch(diffList.get(0));
	    }
	    if (CollUtil.isNotEmpty(diffList.get(1))) {
	        specialItemMapper.updateBatch(diffList.get(1));
	    }
	    if (CollUtil.isNotEmpty(diffList.get(2))) {
	        specialItemMapper.deleteByIds(convertList(diffList.get(2), SpecialItemDO::getId));
	    }
    }

    private void deleteSpecialItemBySpecialTypeId(Long specialTypeId) {
        specialItemMapper.deleteBySpecialTypeId(specialTypeId);
    }

	private void deleteSpecialItemBySpecialTypeIds(List<Long> specialTypeIds) {
        specialItemMapper.deleteBySpecialTypeIds(specialTypeIds);
	}

}