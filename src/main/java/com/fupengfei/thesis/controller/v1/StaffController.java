package com.fupengfei.thesis.controller.v1;

import com.fupengfei.thesis.bean.request.LoginReq;
import com.fupengfei.thesis.bean.request.StaffCreateReq;
import com.fupengfei.thesis.bean.response.LoginResp;
import com.fupengfei.thesis.entity.Staff;
import com.fupengfei.thesis.entity.enums.Postion;
import com.fupengfei.thesis.exception.ApiException;
import com.fupengfei.thesis.exception.ApiExceptionCode;
import com.fupengfei.thesis.repository.jpa.StaffJpaRepository;
import com.fupengfei.thesis.repository.redis.StaffRedisRepository;
import com.fupengfei.thesis.utils.Md5Util;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    private StaffJpaRepository staffJpaRepository;
    @Autowired
    private StaffRedisRepository staffRedisRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("login")
    public LoginResp login(@RequestBody @Validated LoginReq req) {

        req

    }

    private boolean modifyPassword(String passwd){
        String newUserToken = UUID.randomUUID().toString().replace("-","");
        String newUserTokenSalt = Md5Util.generateSalt();
        String newUserTokenHash = Md5Util.generateMd5Hex(newUserTokenSalt, newUserToken);

        //  校验密码
//        if (Md5Util.verifyMd5Hex(user.getUserTokenSalt(),
//                userToken, user.getUserTokenHash())) {
//        }
    }

}
