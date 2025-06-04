package cn.iocoder.yudao.module.system.controller.admin.special;

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

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.system.controller.admin.special.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialDO;
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialItemDO;
import cn.iocoder.yudao.module.system.service.special.SpecialService;

@Tag(name = "管理后台 - 特殊服务类别")
@RestController
@RequestMapping("/system/special")
@Validated
public class SpecialController {

    @Resource
    private SpecialService specialService;

    @PostMapping("/create")
    @Operation(summary = "创建特殊服务类别")
    @PreAuthorize("@ss.hasPermission('system:special:create')")
    public CommonResult<Long> createSpecial(@Valid @RequestBody SpecialSaveReqVO createReqVO) {
        return success(specialService.createSpecial(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新特殊服务类别")
    @PreAuthorize("@ss.hasPermission('system:special:update')")
    public CommonResult<Boolean> updateSpecial(@Valid @RequestBody SpecialSaveReqVO updateReqVO) {
        specialService.updateSpecial(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除特殊服务类别")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:special:delete')")
    public CommonResult<Boolean> deleteSpecial(@RequestParam("id") Long id) {
        specialService.deleteSpecial(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除特殊服务类别")
                @PreAuthorize("@ss.hasPermission('system:special:delete')")
    public CommonResult<Boolean> deleteSpecialList(@RequestParam("ids") List<Long> ids) {
        specialService.deleteSpecialListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得特殊服务类别")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:special:query')")
    public CommonResult<SpecialRespVO> getSpecial(@RequestParam("id") Long id) {
        SpecialDO special = specialService.getSpecial(id);
        return success(BeanUtils.toBean(special, SpecialRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得特殊服务类别分页")
    @PreAuthorize("@ss.hasPermission('system:special:query')")
    public CommonResult<PageResult<SpecialRespVO>> getSpecialPage(@Valid SpecialPageReqVO pageReqVO) {
        PageResult<SpecialDO> pageResult = specialService.getSpecialPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, SpecialRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出特殊服务类别 Excel")
    @PreAuthorize("@ss.hasPermission('system:special:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSpecialExcel(@Valid SpecialPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SpecialDO> list = specialService.getSpecialPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "特殊服务类别.xls", "数据", SpecialRespVO.class,
                        BeanUtils.toBean(list, SpecialRespVO.class));
    }

    // ==================== 子表（特殊服务项目） ====================

    @GetMapping("/special-item/list-by-special-type-id")
    @Operation(summary = "获得特殊服务项目列表")
    @Parameter(name = "specialTypeId", description = "服务类别编号")
    @PreAuthorize("@ss.hasPermission('system:special:query')")
    public CommonResult<List<SpecialItemDO>> getSpecialItemListBySpecialTypeId(@RequestParam("specialTypeId") Long specialTypeId) {
        return success(specialService.getSpecialItemListBySpecialTypeId(specialTypeId));
    }

}