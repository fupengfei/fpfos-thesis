package com.fupengfei.thesis.controller.v1;

import com.fupengfei.thesis.bean.core.AbstractResponseBean;
import com.fupengfei.thesis.bean.request.StaffCreateReq;
import com.fupengfei.thesis.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.controller.ApiController
 * @Author: fpfos
 * @Date: 2019-04-08 22:27
 */
@RestController
@RequestMapping("/v1/staff")
@Slf4j
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping
    public AbstractResponseBean doCreate(@RequestBody @Validated StaffCreateReq req) {

        staffService.doCreate(req);
        return new AbstractResponseBean();
    }

}
