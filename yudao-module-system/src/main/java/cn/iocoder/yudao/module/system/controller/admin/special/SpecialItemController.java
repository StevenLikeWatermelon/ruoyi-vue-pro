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
import cn.iocoder.yudao.module.system.dal.dataobject.special.SpecialItemDO;
import cn.iocoder.yudao.module.system.service.special.SpecialItemService;

@Tag(name = "管理后台 - 特殊服务项目")
@RestController
@RequestMapping("/system/special-item")
@Validated
public class SpecialItemController {

    @Resource
    private SpecialItemService specialItemService;

    @PostMapping("/create")
    @Operation(summary = "创建特殊服务项目")
    @PreAuthorize("@ss.hasPermission('system:special-item:create')")
    public CommonResult<Long> createSpecialItem(@Valid @RequestBody SpecialItemSaveReqVO createReqVO) {
        return success(specialItemService.createSpecialItem(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新特殊服务项目")
    @PreAuthorize("@ss.hasPermission('system:special-item:update')")
    public CommonResult<Boolean> updateSpecialItem(@Valid @RequestBody SpecialItemSaveReqVO updateReqVO) {
        specialItemService.updateSpecialItem(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除特殊服务项目")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:special-item:delete')")
    public CommonResult<Boolean> deleteSpecialItem(@RequestParam("id") Long id) {
        specialItemService.deleteSpecialItem(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除特殊服务项目")
                @PreAuthorize("@ss.hasPermission('system:special-item:delete')")
    public CommonResult<Boolean> deleteSpecialItemList(@RequestParam("ids") List<Long> ids) {
        specialItemService.deleteSpecialItemListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得特殊服务项目")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:special-item:query')")
    public CommonResult<SpecialItemRespVO> getSpecialItem(@RequestParam("id") Long id) {
        SpecialItemDO specialItem = specialItemService.getSpecialItem(id);
        return success(BeanUtils.toBean(specialItem, SpecialItemRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得特殊服务项目分页")
    @PreAuthorize("@ss.hasPermission('system:special-item:query')")
    public CommonResult<PageResult<SpecialItemRespVO>> getSpecialItemPage(@Valid SpecialItemPageReqVO pageReqVO) {
        PageResult<SpecialItemDO> pageResult = specialItemService.getSpecialItemPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, SpecialItemRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出特殊服务项目 Excel")
    @PreAuthorize("@ss.hasPermission('system:special-item:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSpecialItemExcel(@Valid SpecialItemPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SpecialItemDO> list = specialItemService.getSpecialItemPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "特殊服务项目.xls", "数据", SpecialItemRespVO.class,
                        BeanUtils.toBean(list, SpecialItemRespVO.class));
    }

}