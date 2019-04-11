package com.fupengfei.thesis.entity;

import com.fupengfei.thesis.entity.core.AbstractEntity;
import com.fupengfei.thesis.entity.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.entity.core.StaffSecrecy
 * @Author: fpfos
 * @Date: 2019-04-08 23:19 员工隐私信息
 */
@Setter
@Getter
public class StaffSecrecy extends AbstractEntity {

    private String staffPrimaryCode;

    private String staffAddress;

    private String staffIDCard;

    private String staffIDCardPhoto;

    private String emergencyContact;

    private String emergencyContactMobile;

    private BigDecimal salary;

}
