package cn.iocoder.yudao.module.elderly.controller.admin.checkin;

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

import cn.iocoder.yudao.module.elderly.controller.admin.checkin.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.checkin.CheckInDO;
import cn.iocoder.yudao.module.elderly.service.checkin.CheckInService;

@Tag(name = "管理后台 - 老人入住信息")
@RestController
@RequestMapping("/elderly/check-in")
@Validated
public class CheckInController {

    @Resource
    private CheckInService checkInService;

    @PostMapping("/create")
    @Operation(summary = "创建老人入住信息")
    @PreAuthorize("@ss.hasPermission('elderly:check-in:create')")
    public CommonResult<Long> createCheckIn(@Valid @RequestBody CheckInSaveReqVO createReqVO) {
        return success(checkInService.createCheckIn(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新老人入住信息")
    @PreAuthorize("@ss.hasPermission('elderly:check-in:update')")
    public CommonResult<Boolean> updateCheckIn(@Valid @RequestBody CheckInSaveReqVO updateReqVO) {
        checkInService.updateCheckIn(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除老人入住信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:check-in:delete')")
    public CommonResult<Boolean> deleteCheckIn(@RequestParam("id") Long id) {
        checkInService.deleteCheckIn(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除老人入住信息")
                @PreAuthorize("@ss.hasPermission('elderly:check-in:delete')")
    public CommonResult<Boolean> deleteCheckInList(@RequestParam("ids") List<Long> ids) {
        checkInService.deleteCheckInListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得老人入住信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:check-in:query')")
    public CommonResult<CheckInRespVO> getCheckIn(@RequestParam("id") Long id) {
        CheckInDO checkIn = checkInService.getCheckIn(id);
        return success(BeanUtils.toBean(checkIn, CheckInRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得老人入住信息分页")
    @PreAuthorize("@ss.hasPermission('elderly:check-in:query')")
    public CommonResult<PageResult<CheckInRespVO>> getCheckInPage(@Valid CheckInPageReqVO pageReqVO) {
        PageResult<CheckInDO> pageResult = checkInService.getCheckInPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, CheckInRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出老人入住信息 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:check-in:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportCheckInExcel(@Valid CheckInPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<CheckInDO> list = checkInService.getCheckInPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "老人入住信息.xls", "数据", CheckInRespVO.class,
                        BeanUtils.toBean(list, CheckInRespVO.class));
    }

}