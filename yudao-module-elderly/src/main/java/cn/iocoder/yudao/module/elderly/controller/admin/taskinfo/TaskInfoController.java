package cn.iocoder.yudao.module.elderly.controller.admin.taskinfo;

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

import cn.iocoder.yudao.module.elderly.controller.admin.taskinfo.vo.*;
import cn.iocoder.yudao.module.elderly.dal.dataobject.taskinfo.TaskInfoDO;
import cn.iocoder.yudao.module.elderly.service.taskinfo.TaskInfoService;
import cn.iocoder.yudao.module.elderly.service.tasknode.TaskNodeService;
import cn.iocoder.yudao.module.elderly.dal.dataobject.tasknode.TaskNodeDO;

@Tag(name = "管理后台 - 任务信息管理")
@RestController
@RequestMapping("/elderly/task-info")
@Validated
public class TaskInfoController {

    @Resource
    private TaskInfoService taskInfoService;

    @Resource
    private TaskNodeService taskNodeService;

    @PostMapping("/create")
    @Operation(summary = "创建任务信息管理")
    @PreAuthorize("@ss.hasPermission('elderly:task-info:create')")
    public CommonResult<Long> createTaskInfo(@Valid @RequestBody TaskInfoSaveReqVO createReqVO) {
        return success(taskInfoService.createTaskInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新任务信息管理")
    @PreAuthorize("@ss.hasPermission('elderly:task-info:update')")
    public CommonResult<Boolean> updateTaskInfo(@Valid @RequestBody TaskInfoSaveReqVO updateReqVO) {
        taskInfoService.updateTaskInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除任务信息管理")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('elderly:task-info:delete')")
    public CommonResult<Boolean> deleteTaskInfo(@RequestParam("id") Long id) {
        taskInfoService.deleteTaskInfo(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除任务信息管理")
                @PreAuthorize("@ss.hasPermission('elderly:task-info:delete')")
    public CommonResult<Boolean> deleteTaskInfoList(@RequestParam("ids") List<Long> ids) {
        taskInfoService.deleteTaskInfoListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得任务信息管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('elderly:task-info:query')")
    public CommonResult<TaskInfoRespVO> getTaskInfo(@RequestParam("id") Long id) {
        TaskInfoDO taskInfo = taskInfoService.getTaskInfo(id);
        return success(BeanUtils.toBean(taskInfo, TaskInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得任务信息管理分页")
    @PreAuthorize("@ss.hasPermission('elderly:task-info:query')")
    public CommonResult<PageResult<TaskInfoRespVO>> getTaskInfoPage(@Valid TaskInfoPageReqVO pageReqVO) {
        PageResult<TaskInfoDO> pageResult = taskInfoService.getTaskInfoPage(pageReqVO);
        // 处理 nodeName
        List<TaskInfoRespVO> voList = new ArrayList<>();
        for (TaskInfoDO taskInfo : pageResult.getList()) {
            TaskInfoRespVO vo = BeanUtils.toBean(taskInfo, TaskInfoRespVO.class);
            if (taskInfo.getNodeId() != null) {
                TaskNodeDO node = taskNodeService.getTaskNode(taskInfo.getNodeId());
                if (node != null) {
                    vo.setNodeName(node.getName());
                    vo.setNeedPhoto(node.getNeedPhoto());
                    vo.setNeedLocation(node.getNeedLocation());
                    vo.setNeedTime(node.getNeedTime());
                }
            }
            voList.add(vo);
        }
        return success(new PageResult<>(voList, pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出任务信息管理 Excel")
    @PreAuthorize("@ss.hasPermission('elderly:task-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTaskInfoExcel(@Valid TaskInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TaskInfoDO> list = taskInfoService.getTaskInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "任务信息管理.xls", "数据", TaskInfoRespVO.class,
                        BeanUtils.toBean(list, TaskInfoRespVO.class));
    }

}