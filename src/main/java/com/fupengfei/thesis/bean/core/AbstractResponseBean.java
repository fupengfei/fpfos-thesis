package com.fupengfei.thesis.bean.core;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Fu Pengfei
 * @Date 2019-04-12
 * @Description TODO
 */
@Setter
@Getter
public class AbstractResponseBean extends VoJsonBasic {

    private Integer code;

    private String errMsg;

    private String timestamp;
}
