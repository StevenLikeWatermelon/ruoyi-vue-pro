package cn.iocoder.yudao.module.system.controller.admin.buildingbed;

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

import cn.iocoder.yudao.module.system.controller.admin.buildingbed.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.buildingbed.BuildingBedDO;
import cn.iocoder.yudao.module.system.service.buildingbed.BuildingBedService;

@Tag(name = "管理后台 - 楼层床位")
@RestController
@RequestMapping("/system/building-bed")
@Validated
public class BuildingBedController {

    @Resource
    private BuildingBedService buildingBedService;

    @PostMapping("/create")
    @Operation(summary = "创建楼层床位")
    @PreAuthorize("@ss.hasPermission('system:building-bed:create')")
    public CommonResult<Long> createBuildingBed(@Valid @RequestBody BuildingBedSaveReqVO createReqVO) {
        return success(buildingBedService.createBuildingBed(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新楼层床位")
    @PreAuthorize("@ss.hasPermission('system:building-bed:update')")
    public CommonResult<Boolean> updateBuildingBed(@Valid @RequestBody BuildingBedSaveReqVO updateReqVO) {
        buildingBedService.updateBuildingBed(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除楼层床位")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:building-bed:delete')")
    public CommonResult<Boolean> deleteBuildingBed(@RequestParam("id") Long id) {
        buildingBedService.deleteBuildingBed(id);
        return success(true);
    }


    @GetMapping("/get")
    @Operation(summary = "获得楼层床位")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:building-bed:query')")
    public CommonResult<BuildingBedRespVO> getBuildingBed(@RequestParam("id") Long id) {
        BuildingBedDO buildingBed = buildingBedService.getBuildingBed(id);
        return success(BeanUtils.toBean(buildingBed, BuildingBedRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得楼层床位列表")
    @PreAuthorize("@ss.hasPermission('system:building-bed:query')")
    public CommonResult<List<BuildingBedRespVO>> getBuildingBedList(@Valid BuildingBedListReqVO listReqVO) {
        List<BuildingBedDO> list = buildingBedService.getBuildingBedList(listReqVO);
        return success(BeanUtils.toBean(list, BuildingBedRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出楼层床位 Excel")
    @PreAuthorize("@ss.hasPermission('system:building-bed:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportBuildingBedExcel(@Valid BuildingBedListReqVO listReqVO,
              HttpServletResponse response) throws IOException {
        List<BuildingBedDO> list = buildingBedService.getBuildingBedList(listReqVO);
        // 导出 Excel
        ExcelUtils.write(response, "楼层床位.xls", "数据", BuildingBedRespVO.class,
                        BeanUtils.toBean(list, BuildingBedRespVO.class));
    }

}