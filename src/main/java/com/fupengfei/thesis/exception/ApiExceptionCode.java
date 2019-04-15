package com.fupengfei.thesis.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ApiExceptionCode {

    USER_NOT_LOGIN(2000, "您尚未登录。"),
    USER_NOT_EXIST(2001, "用户不存在。"),
    INVALID_INPUT_DATA(9999, "输入数据有误"),
    BAD_ACCOUNT(1001, "账号不存在。"),
    BAD_PASSWORD(1005, "密码不正确。"),
    DATA_CORRUPT(9999, "数据错误。"),
    UNKNOWN_ERROR(9999, "未知错误。"),
    BAD_INSTANCE(1006,"对象构建失败。"),
    BAD_TOKEN(1001, "token验证失败。"),

    ;
    @Getter
    private final Integer errCode;
    @Getter
    private final String errMsg;
}
