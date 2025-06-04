package cn.iocoder.yudao.module.elderly.controller.admin.consultation;

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

import cn.iocoder.yudao.module.elderly.controller.admin.consultation.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.consultation.ConsultationDO;
import cn.iocoder.yudao.module.elderly.service.consultation.ConsultationService;

@Tag(name = "管理后台 - 咨询登记")
@RestController
@RequestMapping("/elderly/consultation")
@Validated
public class ConsultationController {

    @Resource
    private ConsultationService consultationService;

    @PostMapping("/create")
    @Operation(summary = "创建咨询登记")
    @PreAuthorize("@ss.hasPermission('elderly:consultation:create')")
    public CommonResult<Long> createConsultation(@Valid @RequestBody ConsultationSaveReqVO createReqVO) {
        return success(consultationService.createConsultation(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新咨询登记")
    @PreAuthorize("@ss.hasPermission('elderly:consultation:update')")
    public CommonResult<Boolean> updateConsultation(@Valid @RequestBody ConsultationSaveReqVO updateReqVO) {
        consultationService.updateConsultation(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除咨询登记")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:consultation:delete')")
    public CommonResult<Boolean> deleteConsultation(@RequestParam("id") Long id) {
        consultationService.deleteConsultation(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除咨询登记")
                @PreAuthorize("@ss.hasPermission('elderly:consultation:delete')")
    public CommonResult<Boolean> deleteConsultationList(@RequestParam("ids") List<Long> ids) {
        consultationService.deleteConsultationListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得咨询登记")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:consultation:query')")
    public CommonResult<ConsultationRespVO> getConsultation(@RequestParam("id") Long id) {
        ConsultationDO consultation = consultationService.getConsultation(id);
        return success(BeanUtils.toBean(consultation, ConsultationRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得咨询登记分页")
    @PreAuthorize("@ss.hasPermission('elderly:consultation:query')")
    public CommonResult<PageResult<ConsultationRespVO>> getConsultationPage(@Valid ConsultationPageReqVO pageReqVO) {
        PageResult<ConsultationDO> pageResult = consultationService.getConsultationPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ConsultationRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出咨询登记 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:consultation:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportConsultationExcel(@Valid ConsultationPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ConsultationDO> list = consultationService.getConsultationPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "咨询登记.xls", "数据", ConsultationRespVO.class,
                        BeanUtils.toBean(list, ConsultationRespVO.class));
    }

}