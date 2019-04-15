package com.fupengfei.thesis.controller.common;

import com.fupengfei.thesis.bean.request.LoginReq;
import com.fupengfei.thesis.bean.response.LoginResp;
import com.fupengfei.thesis.service.StaffSecrecyService;
import com.fupengfei.thesis.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fu Pengfei
 * @Date 2019-04-14
 * @Description TODO
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Autowired
    private StaffSecrecyService staffSecrecyService;

    @Autowired
    private StaffService staffService;

    @PostMapping("login")
    public LoginResp login(@RequestBody @Validated LoginReq req) {

        String token = staffSecrecyService.login(req.getEmail(), req.getPasswd());
        LoginResp resp = new LoginResp();
        resp.setToken(token);
        return resp;
    }
}
