package cn.iocoder.yudao.module.elderly.service.consultation;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.consultation.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.consultation.ConsultationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.consultation.ConsultationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;

/**
 * 咨询登记 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ConsultationServiceImpl implements ConsultationService {

    @Resource
    private ConsultationMapper consultationMapper;

    @Override
    public Long createConsultation(ConsultationSaveReqVO createReqVO) {
        // 插入
        ConsultationDO consultation = BeanUtils.toBean(createReqVO, ConsultationDO.class);
        consultationMapper.insert(consultation);
        // 返回
        return consultation.getId();
    }

    @Override
    public void updateConsultation(ConsultationSaveReqVO updateReqVO) {
        // 校验存在
        validateConsultationExists(updateReqVO.getId());
        // 更新
        ConsultationDO updateObj = BeanUtils.toBean(updateReqVO, ConsultationDO.class);
        updateObj.setElderlyId(updateReqVO.getElderlyId());
        consultationMapper.updateById(updateObj);
    }

    @Override
    public void deleteConsultation(Long id) {
        // 校验存在
        validateConsultationExists(id);
        // 删除
        consultationMapper.deleteById(id);
    }

    @Override
        public void deleteConsultationListByIds(List<Long> ids) {
        // 校验存在
        validateConsultationExists(ids);
        // 删除
        consultationMapper.deleteByIds(ids);
        }

    private void validateConsultationExists(List<Long> ids) {
        List<ConsultationDO> list = consultationMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(CONSULTATION_NOT_EXISTS);
        }
    }

    private void validateConsultationExists(Long id) {
        if (consultationMapper.selectById(id) == null) {
            throw exception(CONSULTATION_NOT_EXISTS);
        }
    }

    @Override
    public ConsultationDO getConsultation(Long id) {
        return consultationMapper.selectById(id);
    }

    @Override
    public PageResult<ConsultationDO> getConsultationPage(ConsultationPageReqVO pageReqVO) {
        return consultationMapper.selectPage(pageReqVO);
    }

}