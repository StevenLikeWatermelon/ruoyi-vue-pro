package cn.iocoder.yudao.module.elderly.controller.admin.infobasic;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.elderly.controller.admin.infobasic.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.infobasic.InfoBasicDO;
import cn.iocoder.yudao.module.elderly.service.infobasic.InfoBasicService;

@Tag(name = "管理后台 - 老人基本信息")
@RestController
@RequestMapping("/elderly/info-basic")
@Validated
public class InfoBasicController {

    @Resource
    private InfoBasicService infoBasicService;

    @PostMapping("/create")
    @Operation(summary = "创建老人基本信息")
    @PreAuthorize("@ss.hasPermission('elderly:info-basic:create')")
    public CommonResult<Long> createInfoBasic(@Valid @RequestBody InfoBasicSaveReqVO createReqVO) {
        return success(infoBasicService.createInfoBasic(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新老人基本信息")
    @PreAuthorize("@ss.hasPermission('elderly:info-basic:update')")
    public CommonResult<Boolean> updateInfoBasic(@Valid @RequestBody InfoBasicSaveReqVO updateReqVO) {
        infoBasicService.updateInfoBasic(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除老人基本信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:info-basic:delete')")
    public CommonResult<Boolean> deleteInfoBasic(@RequestParam("id") Long id) {
        infoBasicService.deleteInfoBasic(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除老人基本信息")
                @PreAuthorize("@ss.hasPermission('elderly:info-basic:delete')")
    public CommonResult<Boolean> deleteInfoBasicList(@RequestParam("ids") List<Long> ids) {
        infoBasicService.deleteInfoBasicListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得老人基本信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:info-basic:query')")
    public CommonResult<InfoBasicRespVO> getInfoBasic(@RequestParam("id") Long id) {
        InfoBasicDO infoBasic = infoBasicService.getInfoBasic(id);
        return success(BeanUtils.toBean(infoBasic, InfoBasicRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得老人基本信息分页")
    @PreAuthorize("@ss.hasPermission('elderly:info-basic:query')")
    public CommonResult<PageResult<InfoBasicRespVO>> getInfoBasicPage(@Valid InfoBasicPageReqVO pageReqVO) {
        PageResult<InfoBasicDO> pageResult = infoBasicService.getInfoBasicPage(pageReqVO);
        List<InfoBasicRespVO> list = pageResult.getList().stream().map(infoBasic -> {
            InfoBasicRespVO vo = BeanUtils.toBean(infoBasic, InfoBasicRespVO.class);
            vo.setAllergicDrugs(infoBasic.getAllergicDrugsList());
            vo.setDietaryRestrictions(infoBasic.getDietaryRestrictionsList());
            return vo;
        }).collect(Collectors.toList());
        return success(new PageResult<>(list, pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出老人基本信息 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:info-basic:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportInfoBasicExcel(@Valid InfoBasicPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<InfoBasicDO> list = infoBasicService.getInfoBasicPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "老人基本信息.xls", "数据", InfoBasicRespVO.class,
                        BeanUtils.toBean(list, InfoBasicRespVO.class));
    }

}