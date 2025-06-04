package cn.iocoder.yudao.module.system.dal.mysql.special;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.controller.admin.special.vo.SpecialItemPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialItemDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 特殊服务项目 Mapper
 *
 * @author 沈文杰
 */
@Mapper
public interface SpecialItemMapper extends BaseMapperX<SpecialItemDO> {

    default List<SpecialItemDO> selectListBySpecialTypeId(Long specialTypeId) {
        return selectList(SpecialItemDO::getSpecialTypeId, specialTypeId);
    }

    default int deleteBySpecialTypeId(Long specialTypeId) {
        return delete(SpecialItemDO::getSpecialTypeId, specialTypeId);
    }

	default int deleteBySpecialTypeIds(List<Long> specialTypeIds) {
	    return deleteBatch(SpecialItemDO::getSpecialTypeId, specialTypeIds);
	}

    PageResult<SpecialItemDO> selectPage(SpecialItemPageReqVO pageReqVO);
}