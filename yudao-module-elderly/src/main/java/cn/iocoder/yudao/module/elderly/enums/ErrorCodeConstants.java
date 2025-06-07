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
}
