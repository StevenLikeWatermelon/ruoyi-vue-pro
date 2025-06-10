package cn.iocoder.yudao.module.elderly.service.infobasic;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.elderly.controller.admin.infobasic.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.infobasic.InfoBasicDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.elderly.dal.mysql.infobasic.InfoBasicMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.elderly.enums.ErrorCodeConstants.*;

/**
 * 老人基本信息 Service 实现类
 *
 * @author 沈文杰
 */
@Service
@Validated
public class InfoBasicServiceImpl implements InfoBasicService {

    @Resource
    private InfoBasicMapper infoBasicMapper;

    @Resource
    private ObjectMapper objectMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createInfoBasic(InfoBasicSaveReqVO createReqVO) {
        // 插入
        InfoBasicDO infoBasic = BeanUtils.toBean(createReqVO, InfoBasicDO.class);
        // 处理过敏药物列表
        if (createReqVO.getAllergicDrugs() != null) {
            try {
                infoBasic.setAllergicDrugs(objectMapper.writeValueAsString(createReqVO.getAllergicDrugs()));
            } catch (JsonProcessingException e) {
                throw exception(INFO_BASIC_ALLERGIC_DRUGS_CONVERT_ERROR);
            }
        }
        // 处理饮食禁忌列表
        if (createReqVO.getDietaryRestrictions() != null) {
            Object dietaryRestrictions = createReqVO.getDietaryRestrictions();
            if (dietaryRestrictions instanceof List) {
                try {
                    infoBasic.setDietaryRestrictions(objectMapper.writeValueAsString(dietaryRestrictions));
                } catch (JsonProcessingException e) {
                    throw exception(INFO_BASIC_DIETARY_RESTRICTIONS_CONVERT_ERROR);
                }
            } else if (dietaryRestrictions instanceof String) {
                infoBasic.setDietaryRestrictions((String) dietaryRestrictions);
            }
        }
        infoBasicMapper.insert(infoBasic);
        // 返回
        return infoBasic.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateInfoBasic(InfoBasicSaveReqVO updateReqVO) {
        // 校验存在
        validateInfoBasicExists(updateReqVO.getId());
        // 更新
        InfoBasicDO updateObj = BeanUtils.toBean(updateReqVO, InfoBasicDO.class);
        // 处理过敏药物列表
        if (updateReqVO.getAllergicDrugs() != null) {
            try {
                updateObj.setAllergicDrugs(objectMapper.writeValueAsString(updateReqVO.getAllergicDrugs()));
            } catch (JsonProcessingException e) {
                throw exception(INFO_BASIC_ALLERGIC_DRUGS_CONVERT_ERROR);
            }
        }
        // 处理饮食禁忌列表
        if (updateReqVO.getDietaryRestrictions() != null) {
            try {
                updateObj.setDietaryRestrictions(objectMapper.writeValueAsString(updateReqVO.getDietaryRestrictions()));
            } catch (JsonProcessingException e) {
                throw exception(INFO_BASIC_DIETARY_RESTRICTIONS_CONVERT_ERROR);
            }
        }
        infoBasicMapper.updateById(updateObj);
    }

    @Override
    public void deleteInfoBasic(Long id) {
        // 校验存在
        validateInfoBasicExists(id);
        // 删除
        infoBasicMapper.deleteById(id);
    }

    @Override
        public void deleteInfoBasicListByIds(List<Long> ids) {
        // 校验存在
        validateInfoBasicExists(ids);
        // 删除
        infoBasicMapper.deleteByIds(ids);
        }

    private void validateInfoBasicExists(List<Long> ids) {
        List<InfoBasicDO> list = infoBasicMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(INFO_BASIC_NOT_EXISTS);
        }
    }

    private void validateInfoBasicExists(Long id) {
        if (infoBasicMapper.selectById(id) == null) {
            throw exception(INFO_BASIC_NOT_EXISTS);
        }
    }

    @Override
    public InfoBasicDO getInfoBasic(Long id) {
        InfoBasicDO infoBasic = infoBasicMapper.selectById(id);
        if (infoBasic != null) {
            // 处理过敏药物列表
            if (infoBasic.getAllergicDrugs() != null) {
                try {
                    List<String> allergicDrugs = objectMapper.readValue(infoBasic.getAllergicDrugs(), 
                        new TypeReference<List<String>>() {});
                    infoBasic.setAllergicDrugsList(allergicDrugs);
                } catch (JsonProcessingException e) {
                    throw exception(INFO_BASIC_ALLERGIC_DRUGS_CONVERT_ERROR);
                }
            }
            // 处理饮食禁忌列表
            if (infoBasic.getDietaryRestrictions() != null) {
                try {
                    List<String> dietaryRestrictions = objectMapper.readValue(
                        infoBasic.getDietaryRestrictions(), new TypeReference<List<String>>() {});
                    infoBasic.setDietaryRestrictionsList(dietaryRestrictions);
                } catch (JsonProcessingException e) {
                    throw exception(INFO_BASIC_DIETARY_RESTRICTIONS_CONVERT_ERROR);
                }
            }
        }
        return infoBasic;
    }

    @Override
    public PageResult<InfoBasicDO> getInfoBasicPage(InfoBasicPageReqVO pageReqVO) {
        PageResult<InfoBasicDO> pageResult = infoBasicMapper.selectPage(pageReqVO);
        // 处理过敏药物列表和饮食禁忌列表的转换
        pageResult.getList().forEach(infoBasic -> {
            // 处理过敏药物列表
            if (infoBasic.getAllergicDrugs() != null) {
                try {
                    List<String> allergicDrugs = objectMapper.readValue(infoBasic.getAllergicDrugs(), 
                        new TypeReference<List<String>>() {});
                    infoBasic.setAllergicDrugsList(allergicDrugs);
                } catch (JsonProcessingException e) {
                    throw exception(INFO_BASIC_ALLERGIC_DRUGS_CONVERT_ERROR);
                }
            }
            // 处理饮食禁忌列表
            if (infoBasic.getDietaryRestrictions() != null) {
                try {
                    List<String> dietaryRestrictions = objectMapper.readValue(infoBasic.getDietaryRestrictions(), 
                        new TypeReference<List<String>>() {});
                    infoBasic.setDietaryRestrictionsList(dietaryRestrictions);
                } catch (JsonProcessingException e) {
                    throw exception(INFO_BASIC_DIETARY_RESTRICTIONS_CONVERT_ERROR);
                }
            }
        });
        return pageResult;
    }

}