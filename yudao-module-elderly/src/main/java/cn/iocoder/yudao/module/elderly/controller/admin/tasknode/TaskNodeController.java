package cn.iocoder.yudao.module.elderly.controller.admin.tasknode;

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

import cn.iocoder.yudao.module.elderly.controller.admin.tasknode.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.tasknode.TaskNodeDO;
import cn.iocoder.yudao.module.elderly.service.tasknode.TaskNodeService;

@Tag(name = "管理后台 - 任务节点管理")
@RestController
@RequestMapping("/elderly/task-node")
@Validated
public class TaskNodeController {

    @Resource
    private TaskNodeService taskNodeService;

    @PostMapping("/create")
    @Operation(summary = "创建任务节点管理")
    @PreAuthorize("@ss.hasPermission('elderly:task-node:create')")
    public CommonResult<Long> createTaskNode(@Valid @RequestBody TaskNodeSaveReqVO createReqVO) {
        return success(taskNodeService.createTaskNode(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新任务节点管理")
    @PreAuthorize("@ss.hasPermission('elderly:task-node:update')")
    public CommonResult<Boolean> updateTaskNode(@Valid @RequestBody TaskNodeSaveReqVO updateReqVO) {
        taskNodeService.updateTaskNode(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除任务节点管理")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:task-node:delete')")
    public CommonResult<Boolean> deleteTaskNode(@RequestParam("id") Long id) {
        taskNodeService.deleteTaskNode(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除任务节点管理")
                @PreAuthorize("@ss.hasPermission('elderly:task-node:delete')")
    public CommonResult<Boolean> deleteTaskNodeList(@RequestParam("ids") List<Long> ids) {
        taskNodeService.deleteTaskNodeListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得任务节点管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:task-node:query')")
    public CommonResult<TaskNodeRespVO> getTaskNode(@RequestParam("id") Long id) {
        TaskNodeDO taskNode = taskNodeService.getTaskNode(id);
        return success(BeanUtils.toBean(taskNode, TaskNodeRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得任务节点管理分页")
    @PreAuthorize("@ss.hasPermission('elderly:task-node:query')")
    public CommonResult<PageResult<TaskNodeRespVO>> getTaskNodePage(@Valid TaskNodePageReqVO pageReqVO) {
        PageResult<TaskNodeDO> pageResult = taskNodeService.getTaskNodePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TaskNodeRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出任务节点管理 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:task-node:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTaskNodeExcel(@Valid TaskNodePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TaskNodeDO> list = taskNodeService.getTaskNodePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "任务节点管理.xls", "数据", TaskNodeRespVO.class,
                        BeanUtils.toBean(list, TaskNodeRespVO.class));
    }

}