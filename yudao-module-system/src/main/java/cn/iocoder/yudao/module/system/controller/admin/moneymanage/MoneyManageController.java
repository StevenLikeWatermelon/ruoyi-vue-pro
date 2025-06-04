package cn.iocoder.yudao.module.system.controller.admin.moneymanage;

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

import cn.iocoder.yudao.module.system.controller.admin.moneymanage.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.moneymanage.MoneyManageDO;
import cn.iocoder.yudao.module.system.service.moneymanage.MoneyManageService;

@Tag(name = "管理后台 - 基础费用管理")
@RestController
@RequestMapping("/system/money-manage")
@Validated
public class MoneyManageController {

    @Resource
    private MoneyManageService moneyManageService;

    @PostMapping("/create")
    @Operation(summary = "创建基础费用管理")
    @PreAuthorize("@ss.hasPermission('system:money-manage:create')")
    public CommonResult<Long> createMoneyManage(@Valid @RequestBody MoneyManageSaveReqVO createReqVO) {
        return success(moneyManageService.createMoneyManage(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基础费用管理")
    @PreAuthorize("@ss.hasPermission('system:money-manage:update')")
    public CommonResult<Boolean> updateMoneyManage(@Valid @RequestBody MoneyManageSaveReqVO updateReqVO) {
        moneyManageService.updateMoneyManage(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基础费用管理")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:money-manage:delete')")
    public CommonResult<Boolean> deleteMoneyManage(@RequestParam("id") Long id) {
        moneyManageService.deleteMoneyManage(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除基础费用管理")
                @PreAuthorize("@ss.hasPermission('system:money-manage:delete')")
    public CommonResult<Boolean> deleteMoneyManageList(@RequestParam("ids") List<Long> ids) {
        moneyManageService.deleteMoneyManageListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基础费用管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:money-manage:query')")
    public CommonResult<MoneyManageRespVO> getMoneyManage(@RequestParam("id") Long id) {
        MoneyManageDO moneyManage = moneyManageService.getMoneyManage(id);
        return success(BeanUtils.toBean(moneyManage, MoneyManageRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基础费用管理分页")
    @PreAuthorize("@ss.hasPermission('system:money-manage:query')")
    public CommonResult<PageResult<MoneyManageRespVO>> getMoneyManagePage(@Valid MoneyManagePageReqVO pageReqVO) {
        PageResult<MoneyManageDO> pageResult = moneyManageService.getMoneyManagePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MoneyManageRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基础费用管理 Excel")
    @PreAuthorize("@ss.hasPermission('system:money-manage:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportMoneyManageExcel(@Valid MoneyManagePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MoneyManageDO> list = moneyManageService.getMoneyManagePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "基础费用管理.xls", "数据", MoneyManageRespVO.class,
                        BeanUtils.toBean(list, MoneyManageRespVO.class));
    }

}