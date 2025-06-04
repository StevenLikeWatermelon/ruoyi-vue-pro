package cn.iocoder.yudao.module.system.service.moneymanage;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.moneymanage.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.moneymanage.MoneyManageDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.moneymanage.MoneyManageMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 基础费用管理 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MoneyManageServiceImpl implements MoneyManageService {

    @Resource
    private MoneyManageMapper moneyManageMapper;

    @Override
    public Long createMoneyManage(MoneyManageSaveReqVO createReqVO) {
        // 插入
        MoneyManageDO moneyManage = BeanUtils.toBean(createReqVO, MoneyManageDO.class);
        moneyManageMapper.insert(moneyManage);
        // 返回
        return moneyManage.getId();
    }

    @Override
    public void updateMoneyManage(MoneyManageSaveReqVO updateReqVO) {
        // 校验存在
        validateMoneyManageExists(updateReqVO.getId());
        // 更新
        MoneyManageDO updateObj = BeanUtils.toBean(updateReqVO, MoneyManageDO.class);
        moneyManageMapper.updateById(updateObj);
    }

    @Override
    public void deleteMoneyManage(Long id) {
        // 校验存在
        validateMoneyManageExists(id);
        // 删除
        moneyManageMapper.deleteById(id);
    }

    @Override
        public void deleteMoneyManageListByIds(List<Long> ids) {
        // 校验存在
        validateMoneyManageExists(ids);
        // 删除
        moneyManageMapper.deleteByIds(ids);
        }

    private void validateMoneyManageExists(List<Long> ids) {
        List<MoneyManageDO> list = moneyManageMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(MONEY_MANAGE_NOT_EXISTS);
        }
    }

    private void validateMoneyManageExists(Long id) {
        if (moneyManageMapper.selectById(id) == null) {
            throw exception(MONEY_MANAGE_NOT_EXISTS);
        }
    }

    @Override
    public MoneyManageDO getMoneyManage(Long id) {
        return moneyManageMapper.selectById(id);
    }

    @Override
    public PageResult<MoneyManageDO> getMoneyManagePage(MoneyManagePageReqVO pageReqVO) {
        return moneyManageMapper.selectPage(pageReqVO);
    }

}