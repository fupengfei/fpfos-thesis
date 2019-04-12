package com.fupengfei.thesis.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Fu Pengfei
 * @Date 2019-04-12
 * @Description TODO
 */
public class ApiException extends RuntimeException {

    private ApiExceptionCode code;
    private String errMsg;

    public ApiException(ApiExceptionCode code) {
        super();
        this.code = code;
    }

    public ApiException(ApiExceptionCode code, String errMsg) {
        super();

        this.code = code;
    }

    public Integer getErrCode(){
        return code.getErrCode();
    }

    public String getErrMsg(){
        if(StringUtils.isBlank(errMsg)){
            return code.getErrMsg();
        }
        return this.errMsg;
    }
}
