package com.fupengfei.thesis.bean.request;

import com.fupengfei.thesis.bean.core.AbstractRequestBean;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author Fu Pengfei
 * @Date 2019-04-12
 * @Description TODO
 */
@Getter
@Setter
public class LoginReq extends AbstractRequestBean {

    @NotBlank(message = "请输入邮箱")
    private String email;

    @NotBlank(message = "请输入密码")
    private String passwd;
}
