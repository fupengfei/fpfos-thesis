package com.fupengfei.thesis.entity;

import com.fupengfei.thesis.configure.annotation.RedisMapping;
import com.fupengfei.thesis.entity.core.AbstractEntity;
import com.fupengfei.thesis.entity.enums.Gender;
import com.fupengfei.thesis.entity.enums.Postion;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.entity.core.Staff
 * @Author: fpfos
 * @Date: 2019-04-08 23:19 员工公开信息
 */
@Setter
@Getter
@RedisHash(value = "rd:staff", timeToLive = 1 * 60 * 60 * 4)
@Table(name = "lw_staff")
@Entity
public class Staff extends AbstractEntity {

    @Column(name = "real_name", nullable = false)
    @RedisMapping
    private String realName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @RedisMapping
    private Gender gender;

    @Column(name = "selfie", nullable = false)
    private String selfie;

    @Column(name = "mobile", nullable = false)
    @RedisMapping
    private String mobile;

    @Column(name = "email", nullable = false, unique = true)
    @RedisMapping
    private String email;

    @Column(name = "postion", nullable = false)
    @Enumerated(EnumType.STRING)
    @RedisMapping
    private Postion postion;

    @Column(name = "last_login_time")
    @RedisMapping
    private String lastLoginTime;
}
