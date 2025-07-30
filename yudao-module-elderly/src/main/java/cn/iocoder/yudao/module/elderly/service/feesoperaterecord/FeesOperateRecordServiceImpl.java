package cn.iocoder.yudao.module.elderly.service.feesoperaterecord;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.feesoperaterecord.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesoperaterecord.FeesOperateRecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.feesoperaterecord.FeesOperateRecordMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;

/**
 * 费用操作记录 Service 实现类
 *
 * @author 沈文杰
 */
@Service
@Validated
public class FeesOperateRecordServiceImpl implements FeesOperateRecordService {

    @Resource
    private FeesOperateRecordMapper feesOperateRecordMapper;

    @Override
    public Long createFeesOperateRecord(FeesOperateRecordSaveReqVO createReqVO) {
        // 插入
        FeesOperateRecordDO feesOperateRecord = BeanUtils.toBean(createReqVO, FeesOperateRecordDO.class);
        feesOperateRecordMapper.insert(feesOperateRecord);
        // 返回
        return feesOperateRecord.getId();
    }

    @Override
    public void updateFeesOperateRecord(FeesOperateRecordSaveReqVO updateReqVO) {
        // 校验存在
        validateFeesOperateRecordExists(updateReqVO.getId());
        // 更新
        FeesOperateRecordDO updateObj = BeanUtils.toBean(updateReqVO, FeesOperateRecordDO.class);
        feesOperateRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteFeesOperateRecord(Long id) {
        // 校验存在
        validateFeesOperateRecordExists(id);
        // 删除
        feesOperateRecordMapper.deleteById(id);
    }

    @Override
        public void deleteFeesOperateRecordListByIds(List<Long> ids) {
        // 校验存在
        validateFeesOperateRecordExists(ids);
        // 删除
        feesOperateRecordMapper.deleteByIds(ids);
        }

    private void validateFeesOperateRecordExists(List<Long> ids) {
        List<FeesOperateRecordDO> list = feesOperateRecordMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(FEES_OPERATE_RECORD_NOT_EXISTS);
        }
    }

    private void validateFeesOperateRecordExists(Long id) {
        if (feesOperateRecordMapper.selectById(id) == null) {
            throw exception(FEES_OPERATE_RECORD_NOT_EXISTS);
        }
    }

    @Override
    public FeesOperateRecordDO getFeesOperateRecord(Long id) {
        return feesOperateRecordMapper.selectById(id);
    }

    @Override
    public PageResult<FeesOperateRecordDO> getFeesOperateRecordPage(FeesOperateRecordPageReqVO pageReqVO) {
        return feesOperateRecordMapper.selectPage(pageReqVO);
    }

}