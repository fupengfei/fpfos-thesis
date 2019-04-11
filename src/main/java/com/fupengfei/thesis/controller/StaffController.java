package com.fupengfei.thesis.controller;

import com.fupengfei.thesis.repository.redis.StaffRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.controller.ApiController
 * @Author: fpfos
 * @Date: 2019-04-08 22:27
 */
@RestController
@RequestMapping("/v1/staff")
public class StaffController {

    @Autowired
    private StaffJpaRepository staffJpaRepository;
    @Autowired
    private StaffRedisRepository staffRedisRepository;


    @GetMapping("hello")
    public String hello() {

        PdUser user = new PdUser();
//        user.setPrimaryCode(Utils.UUID());
        user.setNickname("小恩");
        user.setMobile("15721093932");
        user.setCreateDate(System.currentTimeMillis());

        userJpaRepository.save(user);

        userRedisRepository.save(user);

        return "ok";
    }


}
