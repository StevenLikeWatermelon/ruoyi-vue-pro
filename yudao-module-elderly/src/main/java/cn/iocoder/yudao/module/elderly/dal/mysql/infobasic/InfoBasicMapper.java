package cn.iocoder.yudao.module.elderly.dal.mysql.infobasic;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.infobasic.InfoBasicDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.infobasic.vo.*;

/**
 * 老人基本信息 Mapper
 *
 * @author 沈文杰
 */
@Mapper
public interface InfoBasicMapper extends BaseMapperX<InfoBasicDO> {

    default PageResult<InfoBasicDO> selectPage(InfoBasicPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InfoBasicDO>()
                .likeIfPresent(InfoBasicDO::getName, reqVO.getName())
                .eqIfPresent(InfoBasicDO::getGender, reqVO.getGender())
                .eqIfPresent(InfoBasicDO::getBloodType, reqVO.getBloodType())
                .eqIfPresent(InfoBasicDO::getResidenceType, reqVO.getResidenceType())
                .eqIfPresent(InfoBasicDO::getIdCard, reqVO.getIdCard())
                .eqIfPresent(InfoBasicDO::getPoliticalStatus, reqVO.getPoliticalStatus())
                .eqIfPresent(InfoBasicDO::getIncomeSource, reqVO.getIncomeSource())
                .eqIfPresent(InfoBasicDO::getReligion, reqVO.getReligion())
                .eqIfPresent(InfoBasicDO::getHomePhone, reqVO.getHomePhone())
                .eqIfPresent(InfoBasicDO::getMediaChannel, reqVO.getMediaChannel())
                .eqIfPresent(InfoBasicDO::getOccupation, reqVO.getOccupation())
                .eqIfPresent(InfoBasicDO::getEducation, reqVO.getEducation())
                .eqIfPresent(InfoBasicDO::getMaritalStatus, reqVO.getMaritalStatus())
                .eqIfPresent(InfoBasicDO::getElderlyType, reqVO.getElderlyType())
                .eqIfPresent(InfoBasicDO::getRetirementUnit, reqVO.getRetirementUnit())
                .eqIfPresent(InfoBasicDO::getServiceType, reqVO.getServiceType())
                .eqIfPresent(InfoBasicDO::getReferrer, reqVO.getReferrer())
                .eqIfPresent(InfoBasicDO::getMedicalInsurance, reqVO.getMedicalInsurance())
                .eqIfPresent(InfoBasicDO::getSupportType, reqVO.getSupportType())
                .eqIfPresent(InfoBasicDO::getReferralAmount, reqVO.getReferralAmount())
                .eqIfPresent(InfoBasicDO::getRegisteredAddress, reqVO.getRegisteredAddress())
                .eqIfPresent(InfoBasicDO::getResidentialAddress, reqVO.getResidentialAddress())
                .eqIfPresent(InfoBasicDO::getAllergicDrugs, reqVO.getAllergicDrugs())
                .eqIfPresent(InfoBasicDO::getDietaryRestrictions, reqVO.getDietaryRestrictions())
                .eqIfPresent(InfoBasicDO::getMainDiseases, reqVO.getMainDiseases())
                .eqIfPresent(InfoBasicDO::getRiskWarning, reqVO.getRiskWarning())
                .eqIfPresent(InfoBasicDO::getPhysicalCondition, reqVO.getPhysicalCondition())
                .eqIfPresent(InfoBasicDO::getDietStyle, reqVO.getDietStyle())
                .eqIfPresent(InfoBasicDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(InfoBasicDO::getIdCardPhoto, reqVO.getIdCardPhoto())
                .betweenIfPresent(InfoBasicDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(InfoBasicDO::getId));
    }

}