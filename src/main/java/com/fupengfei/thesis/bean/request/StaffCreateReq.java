package com.fupengfei.thesis.bean.request;

import com.fupengfei.thesis.bean.core.AbstractRequestBean;
import com.fupengfei.thesis.entity.enums.Gender;
import com.fupengfei.thesis.entity.enums.Postion;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Fu Pengfei
 * @Date 2019-04-11
 * @Description TODO
 */
@Setter
@Getter
public class StaffCreateReq extends AbstractRequestBean {

    private String realName;

    private Integer age;

    private Gender gender;

    private String selfie;

    private String mobile;

    private String email;

    private Postion postion;

    private String staffAddress;

    private String staffIDCard;

    private String staffIDCardPhoto;

    private String staffIDCardPhotoBack;

    private String emergencyContact;

    private String emergencyContactMobile;

    private BigDecimal salary;
}
