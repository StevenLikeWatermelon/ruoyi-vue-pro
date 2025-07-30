package cn.iocoder.yudao.module.elderly.controller.admin.feesoperaterecord;

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

import cn.iocoder.yudao.module.elderly.controller.admin.feesoperaterecord.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.feesoperaterecord.FeesOperateRecordDO;
import cn.iocoder.yudao.module.elderly.service.feesoperaterecord.FeesOperateRecordService;

@Tag(name = "管理后台 - 费用操作记录")
@RestController
@RequestMapping("/elderly/fees-operate-record")
@Validated
public class FeesOperateRecordController {

    @Resource
    private FeesOperateRecordService feesOperateRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建费用操作记录")
    @PreAuthorize("@ss.hasPermission('elderly:fees-operate-record:create')")
    public CommonResult<Long> createFeesOperateRecord(@Valid @RequestBody FeesOperateRecordSaveReqVO createReqVO) {
        return success(feesOperateRecordService.createFeesOperateRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新费用操作记录")
    @PreAuthorize("@ss.hasPermission('elderly:fees-operate-record:update')")
    public CommonResult<Boolean> updateFeesOperateRecord(@Valid @RequestBody FeesOperateRecordSaveReqVO updateReqVO) {
        feesOperateRecordService.updateFeesOperateRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除费用操作记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:fees-operate-record:delete')")
    public CommonResult<Boolean> deleteFeesOperateRecord(@RequestParam("id") Long id) {
        feesOperateRecordService.deleteFeesOperateRecord(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除费用操作记录")
                @PreAuthorize("@ss.hasPermission('elderly:fees-operate-record:delete')")
    public CommonResult<Boolean> deleteFeesOperateRecordList(@RequestParam("ids") List<Long> ids) {
        feesOperateRecordService.deleteFeesOperateRecordListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得费用操作记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:fees-operate-record:query')")
    public CommonResult<FeesOperateRecordRespVO> getFeesOperateRecord(@RequestParam("id") Long id) {
        FeesOperateRecordDO feesOperateRecord = feesOperateRecordService.getFeesOperateRecord(id);
        return success(BeanUtils.toBean(feesOperateRecord, FeesOperateRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得费用操作记录分页")
    @PreAuthorize("@ss.hasPermission('elderly:fees-operate-record:query')")
    public CommonResult<PageResult<FeesOperateRecordRespVO>> getFeesOperateRecordPage(@Valid FeesOperateRecordPageReqVO pageReqVO) {
        PageResult<FeesOperateRecordDO> pageResult = feesOperateRecordService.getFeesOperateRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FeesOperateRecordRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出费用操作记录 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:fees-operate-record:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportFeesOperateRecordExcel(@Valid FeesOperateRecordPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<FeesOperateRecordDO> list = feesOperateRecordService.getFeesOperateRecordPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "费用操作记录.xls", "数据", FeesOperateRecordRespVO.class,
                        BeanUtils.toBean(list, FeesOperateRecordRespVO.class));
    }

}