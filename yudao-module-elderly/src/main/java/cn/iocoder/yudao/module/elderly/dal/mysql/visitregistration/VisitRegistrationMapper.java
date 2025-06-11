package cn.iocoder.yudao.module.elderly.dal.mysql.visitregistration;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.visitregistration.VisitRegistrationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.visitregistration.vo.*;

/**
 * 来访登记 Mapper
 *
 * @author 沈文杰
 */
@Mapper
public interface VisitRegistrationMapper extends BaseMapperX<VisitRegistrationDO> {

    default PageResult<VisitRegistrationDO> selectPage(VisitRegistrationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<VisitRegistrationDO>()
                .eqIfPresent(VisitRegistrationDO::getId, reqVO.getId())
                .eqIfPresent(VisitRegistrationDO::getElderlyId, reqVO.getElderlyId())
                .likeIfPresent(VisitRegistrationDO::getVisitorName, reqVO.getVisitorName())
                .eqIfPresent(VisitRegistrationDO::getVisitorCount, reqVO.getVisitorCount())
                .eqIfPresent(VisitRegistrationDO::getIdType, reqVO.getIdType())
                .eqIfPresent(VisitRegistrationDO::getIdNumber, reqVO.getIdNumber())
                .eqIfPresent(VisitRegistrationDO::getRelationship, reqVO.getRelationship())
                .eqIfPresent(VisitRegistrationDO::getContactPhone, reqVO.getContactPhone())
                .betweenIfPresent(VisitRegistrationDO::getVisitTime, reqVO.getVisitTime())
                .betweenIfPresent(VisitRegistrationDO::getLeaveTime, reqVO.getLeaveTime())
                .eqIfPresent(VisitRegistrationDO::getItemsCarried, reqVO.getItemsCarried())
                .eqIfPresent(VisitRegistrationDO::getNotes, reqVO.getNotes())
                .eqIfPresent(VisitRegistrationDO::getAttachmentPath, reqVO.getAttachmentPath())
                .eqIfPresent(VisitRegistrationDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(VisitRegistrationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(VisitRegistrationDO::getId));
    }

}