package cn.iocoder.yudao.module.elderly.controller.admin.visitregistration;

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

import cn.iocoder.yudao.module.elderly.controller.admin.visitregistration.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.visitregistration.VisitRegistrationDO;
import cn.iocoder.yudao.module.elderly.service.visitregistration.VisitRegistrationService;

@Tag(name = "管理后台 - 来访登记")
@RestController
@RequestMapping("/elderly/visit-registration")
@Validated
public class VisitRegistrationController {

    @Resource
    private VisitRegistrationService visitRegistrationService;

    @PostMapping("/create")
    @Operation(summary = "创建来访登记")
    @PreAuthorize("@ss.hasPermission('elderly:visit-registration:create')")
    public CommonResult<Long> createVisitRegistration(@Valid @RequestBody VisitRegistrationSaveReqVO createReqVO) {
        return success(visitRegistrationService.createVisitRegistration(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新来访登记")
    @PreAuthorize("@ss.hasPermission('elderly:visit-registration:update')")
    public CommonResult<Boolean> updateVisitRegistration(@Valid @RequestBody VisitRegistrationSaveReqVO updateReqVO) {
        visitRegistrationService.updateVisitRegistration(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除来访登记")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:visit-registration:delete')")
    public CommonResult<Boolean> deleteVisitRegistration(@RequestParam("id") Long id) {
        visitRegistrationService.deleteVisitRegistration(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除来访登记")
                @PreAuthorize("@ss.hasPermission('elderly:visit-registration:delete')")
    public CommonResult<Boolean> deleteVisitRegistrationList(@RequestParam("ids") List<Long> ids) {
        visitRegistrationService.deleteVisitRegistrationListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得来访登记")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:visit-registration:query')")
    public CommonResult<VisitRegistrationRespVO> getVisitRegistration(@RequestParam("id") Long id) {
        VisitRegistrationDO visitRegistration = visitRegistrationService.getVisitRegistration(id);
        return success(BeanUtils.toBean(visitRegistration, VisitRegistrationRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得来访登记分页")
    @PreAuthorize("@ss.hasPermission('elderly:visit-registration:query')")
    public CommonResult<PageResult<VisitRegistrationRespVO>> getVisitRegistrationPage(@Valid VisitRegistrationPageReqVO pageReqVO) {
        PageResult<VisitRegistrationDO> pageResult = visitRegistrationService.getVisitRegistrationPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, VisitRegistrationRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出来访登记 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:visit-registration:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportVisitRegistrationExcel(@Valid VisitRegistrationPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<VisitRegistrationDO> list = visitRegistrationService.getVisitRegistrationPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "来访登记.xls", "数据", VisitRegistrationRespVO.class,
                        BeanUtils.toBean(list, VisitRegistrationRespVO.class));
    }

}