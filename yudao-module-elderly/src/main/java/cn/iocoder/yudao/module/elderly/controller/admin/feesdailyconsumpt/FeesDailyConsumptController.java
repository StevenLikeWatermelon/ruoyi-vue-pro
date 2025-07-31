package cn.iocoder.yudao.module.elderly.controller.admin.feesdailyconsumpt;

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

import cn.iocoder.yudao.module.elderly.controller.admin.feesdailyconsumpt.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesdailyconsumpt.FeesDailyConsumptDO;
import cn.iocoder.yudao.module.elderly.service.feesdailyconsumpt.FeesDailyConsumptService;

@Tag(name = "管理后台 - 日常消费")
@RestController
@RequestMapping("/elderly/fees-daily-consumpt")
@Validated
public class FeesDailyConsumptController {

    @Resource
    private FeesDailyConsumptService feesDailyConsumptService;

    @PostMapping("/create")
    @Operation(summary = "创建日常消费")
    @PreAuthorize("@ss.hasPermission('elderly:fees-daily-consumpt:create')")
    public CommonResult<Long> createFeesDailyConsumpt(@Valid @RequestBody FeesDailyConsumptSaveReqVO createReqVO) {
        return success(feesDailyConsumptService.createFeesDailyConsumpt(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新日常消费")
    @PreAuthorize("@ss.hasPermission('elderly:fees-daily-consumpt:update')")
    public CommonResult<Boolean> updateFeesDailyConsumpt(@Valid @RequestBody FeesDailyConsumptSaveReqVO updateReqVO) {
        feesDailyConsumptService.updateFeesDailyConsumpt(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除日常消费")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:fees-daily-consumpt:delete')")
    public CommonResult<Boolean> deleteFeesDailyConsumpt(@RequestParam("id") Long id) {
        feesDailyConsumptService.deleteFeesDailyConsumpt(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除日常消费")
                @PreAuthorize("@ss.hasPermission('elderly:fees-daily-consumpt:delete')")
    public CommonResult<Boolean> deleteFeesDailyConsumptList(@RequestParam("ids") List<Long> ids) {
        feesDailyConsumptService.deleteFeesDailyConsumptListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得日常消费")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:fees-daily-consumpt:query')")
    public CommonResult<FeesDailyConsumptRespVO> getFeesDailyConsumpt(@RequestParam("id") Long id) {
        FeesDailyConsumptDO feesDailyConsumpt = feesDailyConsumptService.getFeesDailyConsumpt(id);
        return success(BeanUtils.toBean(feesDailyConsumpt, FeesDailyConsumptRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得日常消费分页")
    @PreAuthorize("@ss.hasPermission('elderly:fees-daily-consumpt:query')")
    public CommonResult<PageResult<FeesDailyConsumptRespVO>> getFeesDailyConsumptPage(@Valid FeesDailyConsumptPageReqVO pageReqVO) {
        PageResult<FeesDailyConsumptDO> pageResult = feesDailyConsumptService.getFeesDailyConsumptPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FeesDailyConsumptRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出日常消费 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:fees-daily-consumpt:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFeesDailyConsumptExcel(@Valid FeesDailyConsumptPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FeesDailyConsumptDO> list = feesDailyConsumptService.getFeesDailyConsumptPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "日常消费.xls", "数据", FeesDailyConsumptRespVO.class,
                        BeanUtils.toBean(list, FeesDailyConsumptRespVO.class));
    }

}