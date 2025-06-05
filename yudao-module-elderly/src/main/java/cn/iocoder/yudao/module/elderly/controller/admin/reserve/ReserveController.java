package cn.iocoder.yudao.module.elderly.controller.admin.reserve;

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

import cn.iocoder.yudao.module.elderly.controller.admin.reserve.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.reserve.ReserveDO;
import cn.iocoder.yudao.module.elderly.service.reserve.ReserveService;

@Tag(name = "管理后台 - 预约登记")
@RestController
@RequestMapping("/elderly/reserve")
@Validated
public class ReserveController {

    @Resource
    private ReserveService reserveService;

    @PostMapping("/create")
    @Operation(summary = "创建预约登记")
    @PreAuthorize("@ss.hasPermission('elderly:reserve:create')")
    public CommonResult<Long> createReserve(@Valid @RequestBody ReserveSaveReqVO createReqVO) {
        return success(reserveService.createReserve(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新预约登记")
    @PreAuthorize("@ss.hasPermission('elderly:reserve:update')")
    public CommonResult<Boolean> updateReserve(@Valid @RequestBody ReserveSaveReqVO updateReqVO) {
        reserveService.updateReserve(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除预约登记")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:reserve:delete')")
    public CommonResult<Boolean> deleteReserve(@RequestParam("id") Long id) {
        reserveService.deleteReserve(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除预约登记")
                @PreAuthorize("@ss.hasPermission('elderly:reserve:delete')")
    public CommonResult<Boolean> deleteReserveList(@RequestParam("ids") List<Long> ids) {
        reserveService.deleteReserveListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得预约登记")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:reserve:query')")
    public CommonResult<ReserveRespVO> getReserve(@RequestParam("id") Long id) {
        ReserveDO reserve = reserveService.getReserve(id);
        return success(BeanUtils.toBean(reserve, ReserveRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得预约登记分页")
    @PreAuthorize("@ss.hasPermission('elderly:reserve:query')")
    public CommonResult<PageResult<ReserveRespVO>> getReservePage(@Valid ReservePageReqVO pageReqVO) {
        PageResult<ReserveDO> pageResult = reserveService.getReservePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ReserveRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出预约登记 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:reserve:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportReserveExcel(@Valid ReservePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ReserveDO> list = reserveService.getReservePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "预约登记.xls", "数据", ReserveRespVO.class,
                        BeanUtils.toBean(list, ReserveRespVO.class));
    }

}