package cn.iocoder.yudao.module.elderly.dal.mysql.reserve;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.reserve.ReserveDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.reserve.vo.*;

/**
 * 预约登记 Mapper
 *
 * @author 沈文杰
 */
@Mapper
public interface ReserveMapper extends BaseMapperX<ReserveDO> {

    default PageResult<ReserveDO> selectPage(ReservePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ReserveDO>()
                .likeIfPresent(ReserveDO::getConsultantName, reqVO.getConsultantName())
                .betweenIfPresent(ReserveDO::getConsultationDate, reqVO.getConsultationDate())
                .likeIfPresent(ReserveDO::getElderlyName, reqVO.getElderlyName())
                .eqIfPresent(ReserveDO::getConsultationIntention, reqVO.getConsultationIntention())
                .eqIfPresent(ReserveDO::getMediaChannel, reqVO.getMediaChannel())
                .eqIfPresent(ReserveDO::getReferrer, reqVO.getReferrer())
                .eqIfPresent(ReserveDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(ReserveDO::getCreateTime, reqVO.getCreateTime())
                .betweenIfPresent(ReserveDO::getPlannedCheckinTime, reqVO.getPlannedCheckinTime())
                .eqIfPresent(ReserveDO::getElderlyId, reqVO.getElderlyId())
                .orderByDesc(ReserveDO::getId));
    }

}