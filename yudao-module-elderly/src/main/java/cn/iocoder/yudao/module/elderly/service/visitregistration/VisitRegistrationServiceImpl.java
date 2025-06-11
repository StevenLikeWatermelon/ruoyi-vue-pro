package cn.iocoder.yudao.module.elderly.service.visitregistration;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.visitregistration.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.visitregistration.VisitRegistrationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.visitregistration.VisitRegistrationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;

/**
 * 来访登记 Service 实现类
 *
 * @author 沈文杰
 */
@Service
@Validated
public class VisitRegistrationServiceImpl implements VisitRegistrationService {

    @Resource
    private VisitRegistrationMapper visitRegistrationMapper;

    @Override
    public Long createVisitRegistration(VisitRegistrationSaveReqVO createReqVO) {
        // 插入
        VisitRegistrationDO visitRegistration = BeanUtils.toBean(createReqVO, VisitRegistrationDO.class);
        visitRegistrationMapper.insert(visitRegistration);
        // 返回
        return visitRegistration.getId();
    }

    @Override
    public void updateVisitRegistration(VisitRegistrationSaveReqVO updateReqVO) {
        // 校验存在
        validateVisitRegistrationExists(updateReqVO.getId());
        // 更新
        VisitRegistrationDO updateObj = BeanUtils.toBean(updateReqVO, VisitRegistrationDO.class);
        visitRegistrationMapper.updateById(updateObj);
    }

    @Override
    public void deleteVisitRegistration(Long id) {
        // 校验存在
        validateVisitRegistrationExists(id);
        // 删除
        visitRegistrationMapper.deleteById(id);
    }

    @Override
        public void deleteVisitRegistrationListByIds(List<Long> ids) {
        // 校验存在
        validateVisitRegistrationExists(ids);
        // 删除
        visitRegistrationMapper.deleteByIds(ids);
        }

    private void validateVisitRegistrationExists(List<Long> ids) {
        List<VisitRegistrationDO> list = visitRegistrationMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(VISIT_REGISTRATION_NOT_EXISTS);
        }
    }

    private void validateVisitRegistrationExists(Long id) {
        if (visitRegistrationMapper.selectById(id) == null) {
            throw exception(VISIT_REGISTRATION_NOT_EXISTS);
        }
    }

    @Override
    public VisitRegistrationDO getVisitRegistration(Long id) {
        return visitRegistrationMapper.selectById(id);
    }

    @Override
    public PageResult<VisitRegistrationDO> getVisitRegistrationPage(VisitRegistrationPageReqVO pageReqVO) {
        return visitRegistrationMapper.selectPage(pageReqVO);
    }

}