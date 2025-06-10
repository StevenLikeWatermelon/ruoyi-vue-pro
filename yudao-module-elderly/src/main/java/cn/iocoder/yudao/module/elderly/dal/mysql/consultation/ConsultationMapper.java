package cn.iocoder.yudao.module.elderly.dal.mysql.consultation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.consultation.ConsultationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.consultation.vo.*;

/**
 * 咨询登记 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ConsultationMapper extends BaseMapperX<ConsultationDO> {

    default PageResult<ConsultationDO> selectPage(ConsultationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ConsultationDO>()
                .eqIfPresent(ConsultationDO::getElderlyId, reqVO.getElderlyId())
                .likeIfPresent(ConsultationDO::getConsultantName, reqVO.getConsultantName())
                .eqIfPresent(ConsultationDO::getRelationship, reqVO.getRelationship())
                .betweenIfPresent(ConsultationDO::getConsultationDate, reqVO.getConsultationDate())
                .eqIfPresent(ConsultationDO::getContactPhone, reqVO.getContactPhone())
                .likeIfPresent(ConsultationDO::getElderlyName, reqVO.getElderlyName())
                .eqIfPresent(ConsultationDO::getElderlyGender, reqVO.getElderlyGender())
                .eqIfPresent(ConsultationDO::getElderlyAge, reqVO.getElderlyAge())
                .eqIfPresent(ConsultationDO::getSelfCareAbility, reqVO.getSelfCareAbility())
                .eqIfPresent(ConsultationDO::getElderlyAddress, reqVO.getElderlyAddress())
                .eqIfPresent(ConsultationDO::getConsultationMethod, reqVO.getConsultationMethod())
                .eqIfPresent(ConsultationDO::getConsultationIntention, reqVO.getConsultationIntention())
                .eqIfPresent(ConsultationDO::getConsultationCount, reqVO.getConsultationCount())
                .eqIfPresent(ConsultationDO::getMediaChannel, reqVO.getMediaChannel())
                .eqIfPresent(ConsultationDO::getReferrer, reqVO.getReferrer())
                .eqIfPresent(ConsultationDO::getManagerId, reqVO.getManagerId())
                .likeIfPresent(ConsultationDO::getManagerName, reqVO.getManagerName())
                .likeIfPresent(ConsultationDO::getCreator, reqVO.getCreator())
                .eqIfPresent(ConsultationDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(ConsultationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ConsultationDO::getId));
    }

}