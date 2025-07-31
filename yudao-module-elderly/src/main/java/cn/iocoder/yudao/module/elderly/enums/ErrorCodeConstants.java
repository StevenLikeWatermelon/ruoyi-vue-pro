package cn.iocoder.yudao.module.elderly.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * elderly 错误码枚举类
 * <p>
 * elderly 老人管理，使用 1-030-000-000 段
 */
public interface ErrorCodeConstants {
    // ========== elderly 咨询登记（1_001_001_000） ==========
    ErrorCode CONSULTATION_NOT_EXISTS = new ErrorCode(1_001_001_000, "咨询登记不存在");
    // ========== 预约登记 1_002_001_000 ==========
    ErrorCode RESERVE_NOT_EXISTS = new ErrorCode(1_002_001_000, "预约登记不存在");
    // ========== 床位相关 1_002_002_000 ==========
    ErrorCode BED_NOT_EXISTS = new ErrorCode(1_002_002_000, "床位不存在");
    ErrorCode BED_ALREADY_OCCUPIED = new ErrorCode(1_002_002_001, "床位已被预定/试住/入住，无法再次预定");
    // ========== 基本信息 1_003_001_000 ==========
    ErrorCode INFO_BASIC_NOT_EXISTS = new ErrorCode(1_003_001_000, "老人基本信息不存在");
    ErrorCode INFO_BASIC_ALLERGIC_DRUGS_CONVERT_ERROR = new ErrorCode(1_003_001_001, "过敏药物数据转换失败");
    ErrorCode INFO_BASIC_DIETARY_RESTRICTIONS_CONVERT_ERROR = new ErrorCode(1_003_001_002, "饮食禁忌数据转换失败");
    // ========== 来访登记 1_004_001_000 ==========
    ErrorCode VISIT_REGISTRATION_NOT_EXISTS = new ErrorCode(1_004_001_000, "来访登记不存在");
    // ========== 老人入住信息 1_005_001_000 ==========
    ErrorCode CHECK_IN_NOT_EXISTS = new ErrorCode(1_005_001_000, "老人入住信息不存在");
    ErrorCode CHECK_IN_STATUS_ERROR = new ErrorCode(1_005_001_001, "老人入住信息已审核，不能删除");
    // ========== 任务节点管理 1_006_001_000 ==========
    ErrorCode TASK_NODE_NOT_EXISTS = new ErrorCode(1_006_001_000, "任务节点管理不存在");
    // ========== 任务信息管理 1_007_001_000 ==========
    ErrorCode TASK_INFO_NOT_EXISTS = new ErrorCode(1_007_001_000, "任务信息管理不存在");

    ErrorCode TASK_EXCUTED_NOT_EXISTS = new ErrorCode(1_008_001_000, "任务编排执行管理不存在");
    // ========== 老人费用余额 1_009_001_000 ==========
    ErrorCode FEES_OVERVIEW_NOT_EXISTS = new ErrorCode(1_009_001_000, "老人费用余额不存在");
    // ========== 费用操作记录 1_010_001_000 ==========
    ErrorCode FEES_OPERATE_RECORD_NOT_EXISTS = new ErrorCode(1_010_001_000, "费用操作记录不存在");
    // ========== 日常消费 1_011_001_000 ==========
    ErrorCode FEES_DAILY_CONSUMPT_NOT_EXISTS = new ErrorCode(1_011_001_000, "日常消费不存在");
}
