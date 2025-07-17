package cn.iocoder.yudao.module.elderly.controller.admin.taskexcuted;

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

import cn.iocoder.yudao.module.elderly.controller.admin.taskexcuted.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.taskexcuted.TaskExcutedDO;
import cn.iocoder.yudao.module.elderly.service.taskexcuted.TaskExcutedService;

@Tag(name = "管理后台 - 任务编排执行管理")
@RestController
@RequestMapping("/elderly/task-excuted")
@Validated
public class TaskExcutedController {

    @Resource
    private TaskExcutedService taskExcutedService;

    @PostMapping("/create")
    @Operation(summary = "创建任务编排执行管理")
    @PreAuthorize("@ss.hasPermission('elderly:task-excuted:create')")
    public CommonResult<Long> createTaskExcuted(@Valid @RequestBody TaskExcutedSaveReqVO createReqVO) {
        return success(taskExcutedService.createTaskExcuted(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新任务编排执行管理")
    @PreAuthorize("@ss.hasPermission('elderly:task-excuted:update')")
    public CommonResult<Boolean> updateTaskExcuted(@Valid @RequestBody TaskExcutedSaveReqVO updateReqVO) {
        taskExcutedService.updateTaskExcuted(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除任务编排执行管理")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:task-excuted:delete')")
    public CommonResult<Boolean> deleteTaskExcuted(@RequestParam("id") Long id) {
        taskExcutedService.deleteTaskExcuted(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除任务编排执行管理")
                @PreAuthorize("@ss.hasPermission('elderly:task-excuted:delete')")
    public CommonResult<Boolean> deleteTaskExcutedList(@RequestParam("ids") List<Long> ids) {
        taskExcutedService.deleteTaskExcutedListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得任务编排执行管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:task-excuted:query')")
    public CommonResult<TaskExcutedRespVO> getTaskExcuted(@RequestParam("id") Long id) {
        TaskExcutedDO taskExcuted = taskExcutedService.getTaskExcuted(id);
        return success(BeanUtils.toBean(taskExcuted, TaskExcutedRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得任务编排执行管理分页")
    @PreAuthorize("@ss.hasPermission('elderly:task-excuted:query')")
    public CommonResult<PageResult<TaskExcutedRespVO>> getTaskExcutedPage(@Valid TaskExcutedPageReqVO pageReqVO) {
        PageResult<TaskExcutedDO> pageResult = taskExcutedService.getTaskExcutedPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TaskExcutedRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出任务编排执行管理 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:task-excuted:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTaskExcutedExcel(@Valid TaskExcutedPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TaskExcutedDO> list = taskExcutedService.getTaskExcutedPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "任务编排执行管理.xls", "数据", TaskExcutedRespVO.class,
                        BeanUtils.toBean(list, TaskExcutedRespVO.class));
    }

}