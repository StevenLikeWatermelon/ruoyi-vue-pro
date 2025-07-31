package cn.iocoder.yudao.module.elderly.dal.mysql.checkin;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.elderly.dal.dataobject.checkin.CheckInDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.elderly.controller.admin.checkin.vo.*;

/**
 * 老人入住信息 Mapper
 *
 * @author 沈文杰
 */
@Mapper
public interface CheckInMapper extends BaseMapperX<CheckInDO> {

    default PageResult<CheckInDO> selectPage(CheckInPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CheckInDO>()
                .eqIfPresent(CheckInDO::getId, reqVO.getId())
                .likeIfPresent(CheckInDO::getVisitorName, reqVO.getVisitorName())
                .eqIfPresent(CheckInDO::getNotes, reqVO.getNotes())
                .eqIfPresent(CheckInDO::getAttachmentPath, reqVO.getAttachmentPath())
                .eqIfPresent(CheckInDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(CheckInDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(CheckInDO::getDeleted, reqVO.getDeleted())
                .orderByDesc(CheckInDO::getId));
    }

}