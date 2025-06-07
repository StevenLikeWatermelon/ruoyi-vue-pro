package cn.iocoder.yudao.module.elderly.service.infobasic;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.infobasic.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.infobasic.InfoBasicDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.infobasic.InfoBasicMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;

/**
 * 老人基本信息 Service 实现类
 *
 * @author 沈文杰
 */
@Service
@Validated
public class InfoBasicServiceImpl implements InfoBasicService {

    @Resource
    private InfoBasicMapper infoBasicMapper;

    @Override
    public Long createInfoBasic(InfoBasicSaveReqVO createReqVO) {
        // 插入
        InfoBasicDO infoBasic = BeanUtils.toBean(createReqVO, InfoBasicDO.class);
        infoBasicMapper.insert(infoBasic);
        // 返回
        return infoBasic.getId();
    }

    @Override
    public void updateInfoBasic(InfoBasicSaveReqVO updateReqVO) {
        // 校验存在
        validateInfoBasicExists(updateReqVO.getId());
        // 更新
        InfoBasicDO updateObj = BeanUtils.toBean(updateReqVO, InfoBasicDO.class);
        infoBasicMapper.updateById(updateObj);
    }

    @Override
    public void deleteInfoBasic(Long id) {
        // 校验存在
        validateInfoBasicExists(id);
        // 删除
        infoBasicMapper.deleteById(id);
    }

    @Override
        public void deleteInfoBasicListByIds(List<Long> ids) {
        // 校验存在
        validateInfoBasicExists(ids);
        // 删除
        infoBasicMapper.deleteByIds(ids);
        }

    private void validateInfoBasicExists(List<Long> ids) {
        List<InfoBasicDO> list = infoBasicMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(INFO_BASIC_NOT_EXISTS);
        }
    }

    private void validateInfoBasicExists(Long id) {
        if (infoBasicMapper.selectById(id) == null) {
            throw exception(INFO_BASIC_NOT_EXISTS);
        }
    }

    @Override
    public InfoBasicDO getInfoBasic(Long id) {
        return infoBasicMapper.selectById(id);
    }

    @Override
    public PageResult<InfoBasicDO> getInfoBasicPage(InfoBasicPageReqVO pageReqVO) {
        return infoBasicMapper.selectPage(pageReqVO);
    }

}