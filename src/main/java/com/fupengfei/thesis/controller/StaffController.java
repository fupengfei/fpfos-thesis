package com.fupengfei.thesis.controller;

import com.fupengfei.thesis.bean.request.StaffCreateReq;
import com.fupengfei.thesis.entity.Staff;
import com.fupengfei.thesis.entity.enums.Postion;
import com.fupengfei.thesis.exception.ApiException;
import com.fupengfei.thesis.exception.ApiExceptionCode;
import com.fupengfei.thesis.repository.jpa.StaffJpaRepository;
import com.fupengfei.thesis.repository.redis.StaffRedisRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
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

    private RedisTemplate<String,String> redisTemplate;


    @PostMapping("save")
    public String save(@RequestBody StaffCreateReq reqData) {

        Staff staff = new Staff();
        staff.setPrimaryCode(UUID.randomUUID().toString().replace("-", ""));
        staff.setRealName(reqData.getName());
        staff.setAge(reqData.getAge());
        staff.setGender(reqData.getGender());
        staff.setCreatePrimaryCode("0");
        staff.setEmail(reqData.getEmail());
        staff.setMobile("111");
        staff.setPostion(Postion.DIRECTOR);
        staff.setCreatedName("");
        staff.setCreatePrimaryCode("");
        staff.setModifiedName("");
        staff.setModifiedPrimaryCode("");
        staff.setIsDel(false);

        staffJpaRepository.save(staff);
        staffRedisRepository.save(staff);
        return "ok";
    }

    @GetMapping("{primary_code}")
    public String ss(@PathVariable("primary_code") String primaryCode){

        if(true){
            throw new ApiException(ApiExceptionCode.BAD_PASSWORD,"kakaka");
        }
        Staff staff = staffJpaRepository.getOne(primaryCode);
        return new Gson().toJson(staff);
    }

}
