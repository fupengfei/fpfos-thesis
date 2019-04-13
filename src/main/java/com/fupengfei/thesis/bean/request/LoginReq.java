package com.fupengfei.thesis.bean.request;

import javax.validation.constraints.NotBlank;

/**
 * @author Fu Pengfei
 * @Date 2019-04-12
 * @Description TODO
 */
public class LoginReq {

    @NotBlank(message = "请输入邮箱")
    private String email;

    @NotBlank(message = "请输入密码")
    private String passwd;
}
