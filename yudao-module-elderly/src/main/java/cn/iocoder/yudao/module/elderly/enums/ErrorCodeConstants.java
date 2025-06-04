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

}
