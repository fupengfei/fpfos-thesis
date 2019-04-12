package com.fupengfei.thesis.controller;

import bean.request.StaffCreateReq;
import com.fupengfei.thesis.entity.Staff;
import com.fupengfei.thesis.repository.jpa.StaffJpaRepository;
import com.fupengfei.thesis.repository.redis.StaffRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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


    @PostMapping("save")
    public String save(@RequestBody StaffCreateReq reqData) {

        Staff staff = new Staff();
        staff.setPrimaryCode(UUID.randomUUID().toString().replace("-", ""));
        staff.setRealName(reqData.getName());
        staff.setAge(reqData.getAge());
        staff.setGender(reqData.getGender());

        staffJpaRepository.save(staff);
        staffRedisRepository.save(staff);
        return "ok";
    }


}
