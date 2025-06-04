package cn.iocoder.yudao.module.system.dal.mysql.special;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.special.vo.*;

/**
 * 特殊服务类别 Mapper
 *
 * @author 沈文杰
 */
@Mapper
public interface SpecialMapper extends BaseMapperX<SpecialDO> {

    default PageResult<SpecialDO> selectPage(SpecialPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SpecialDO>()
                .likeIfPresent(SpecialDO::getName, reqVO.getName())
                .betweenIfPresent(SpecialDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SpecialDO::getId));
    }

}