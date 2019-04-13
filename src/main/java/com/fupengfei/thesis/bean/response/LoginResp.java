package com.fupengfei.thesis.bean.response;

import com.fupengfei.thesis.bean.core.AbstractResponseBean;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Fu Pengfei
 * @Date 2019-04-12
 * @Description TODO
 */
@Getter
@Setter
public class LoginResp extends AbstractResponseBean {

    private String token;
}
