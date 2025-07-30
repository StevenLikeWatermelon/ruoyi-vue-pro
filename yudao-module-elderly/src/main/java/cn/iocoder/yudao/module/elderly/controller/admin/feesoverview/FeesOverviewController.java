package cn.iocoder.yudao.module.elderly.controller.admin.feesoverview;

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

import cn.iocoder.yudao.module.elderly.controller.admin.feesoverview.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesoverview.FeesOverviewDO;
import cn.iocoder.yudao.module.elderly.service.feesoverview.FeesOverviewService;

@Tag(name = "管理后台 - 老人费用余额")
@RestController
@RequestMapping("/elderly/fees-overview")
@Validated
public class FeesOverviewController {

    @Resource
    private FeesOverviewService feesOverviewService;

    @PostMapping("/create")
    @Operation(summary = "创建老人费用余额")
    @PreAuthorize("@ss.hasPermission('elderly:fees-overview:create')")
    public CommonResult<Long> createFeesOverview(@Valid @RequestBody FeesOverviewSaveReqVO createReqVO) {
        return success(feesOverviewService.createFeesOverview(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新老人费用余额")
    @PreAuthorize("@ss.hasPermission('elderly:fees-overview:update')")
    public CommonResult<Boolean> updateFeesOverview(@Valid @RequestBody FeesOverviewSaveReqVO updateReqVO) {
        feesOverviewService.updateFeesOverview(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除老人费用余额")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:fees-overview:delete')")
    public CommonResult<Boolean> deleteFeesOverview(@RequestParam("id") Long id) {
        feesOverviewService.deleteFeesOverview(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除老人费用余额")
                @PreAuthorize("@ss.hasPermission('elderly:fees-overview:delete')")
    public CommonResult<Boolean> deleteFeesOverviewList(@RequestParam("ids") List<Long> ids) {
        feesOverviewService.deleteFeesOverviewListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得老人费用余额")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:fees-overview:query')")
    public CommonResult<FeesOverviewRespVO> getFeesOverview(@RequestParam("id") Long id) {
        FeesOverviewDO feesOverview = feesOverviewService.getFeesOverview(id);
        return success(BeanUtils.toBean(feesOverview, FeesOverviewRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得老人费用余额分页")
    @PreAuthorize("@ss.hasPermission('elderly:fees-overview:query')")
    public CommonResult<PageResult<FeesOverviewRespVO>> getFeesOverviewPage(@Valid FeesOverviewPageReqVO pageReqVO) {
        PageResult<FeesOverviewDO> pageResult = feesOverviewService.getFeesOverviewPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FeesOverviewRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出老人费用余额 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:fees-overview:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFeesOverviewExcel(@Valid FeesOverviewPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FeesOverviewDO> list = feesOverviewService.getFeesOverviewPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "老人费用余额.xls", "数据", FeesOverviewRespVO.class,
                        BeanUtils.toBean(list, FeesOverviewRespVO.class));
    }

}