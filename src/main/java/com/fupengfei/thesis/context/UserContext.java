package com.fupengfei.thesis.context;

import com.fupengfei.thesis.entity.core.JsonBaseObject;
import com.fupengfei.thesis.entity.enums.Gender;
import com.fupengfei.thesis.entity.enums.Postion;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Fu Pengfei
 * @Date 2019-04-14
 * @Description TODO
 */
@Getter
@Setter
public class UserContext extends JsonBaseObject {

    private String token;

    private String primaryCode;

    private String realName;

    private String mobile;

    private String email;

    private Gender gender;

    private Postion postion;

    private String lastLoginTime;

}
