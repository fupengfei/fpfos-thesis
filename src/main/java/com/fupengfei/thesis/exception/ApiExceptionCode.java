package com.fupengfei.thesis.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ApiExceptionCode {

    USER_NOT_LOGIN(2000, "您尚未登录。"),
    INVALID_INPUT_DATA(9999, "输入数据有误"),
    BAD_PASSWORD(1005, "密码不正确。"),
    DATA_CORRUPT(9999, "数据错误。"),
    UNKNOWN_ERROR(9999, "未知错误。"),

    ;
    @Getter
    private final Integer errCode;
    @Getter
    private final String errMsg;
}
