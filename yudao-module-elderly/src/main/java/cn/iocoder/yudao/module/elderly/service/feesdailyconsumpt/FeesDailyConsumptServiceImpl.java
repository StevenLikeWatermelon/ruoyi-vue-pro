package cn.iocoder.yudao.module.elderly.service.feesdailyconsumpt;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.feesdailyconsumpt.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesdailyconsumpt.FeesDailyConsumptDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.feesdailyconsumpt.FeesDailyConsumptMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;

/**
 * 日常消费 Service 实现类
 *
 * @author 沈文杰
 */
@Service
@Validated
public class FeesDailyConsumptServiceImpl implements FeesDailyConsumptService {

    @Resource
    private FeesDailyConsumptMapper feesDailyConsumptMapper;

    @Override
    public Long createFeesDailyConsumpt(FeesDailyConsumptSaveReqVO createReqVO) {
        // 插入
        FeesDailyConsumptDO feesDailyConsumpt = BeanUtils.toBean(createReqVO, FeesDailyConsumptDO.class);
        feesDailyConsumptMapper.insert(feesDailyConsumpt);
        // 返回
        return feesDailyConsumpt.getId();
    }

    @Override
    public void updateFeesDailyConsumpt(FeesDailyConsumptSaveReqVO updateReqVO) {
        // 校验存在
        validateFeesDailyConsumptExists(updateReqVO.getId());
        // 更新
        FeesDailyConsumptDO updateObj = BeanUtils.toBean(updateReqVO, FeesDailyConsumptDO.class);
        feesDailyConsumptMapper.updateById(updateObj);
    }

    @Override
    public void deleteFeesDailyConsumpt(Long id) {
        // 校验存在
        validateFeesDailyConsumptExists(id);
        // 删除
        feesDailyConsumptMapper.deleteById(id);
    }

    @Override
        public void deleteFeesDailyConsumptListByIds(List<Long> ids) {
        // 校验存在
        validateFeesDailyConsumptExists(ids);
        // 删除
        feesDailyConsumptMapper.deleteByIds(ids);
        }

    private void validateFeesDailyConsumptExists(List<Long> ids) {
        List<FeesDailyConsumptDO> list = feesDailyConsumptMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(FEES_DAILY_CONSUMPT_NOT_EXISTS);
        }
    }

    private void validateFeesDailyConsumptExists(Long id) {
        if (feesDailyConsumptMapper.selectById(id) == null) {
            throw exception(FEES_DAILY_CONSUMPT_NOT_EXISTS);
        }
    }

    @Override
    public FeesDailyConsumptDO getFeesDailyConsumpt(Long id) {
        return feesDailyConsumptMapper.selectById(id);
    }

    @Override
    public PageResult<FeesDailyConsumptDO> getFeesDailyConsumptPage(FeesDailyConsumptPageReqVO pageReqVO) {
        return feesDailyConsumptMapper.selectPage(pageReqVO);
    }

}