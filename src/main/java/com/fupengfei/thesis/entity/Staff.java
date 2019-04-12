package com.fupengfei.thesis.entity;

import com.fupengfei.thesis.entity.core.AbstractEntity;
import com.fupengfei.thesis.annotation.RedisMapping;
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
@RedisHash("rd_staff")
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
    private Gender gender;

    @Column(name = "selfie", nullable = false)
    private String selfie;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "postion", nullable = false)
    @Enumerated(EnumType.STRING)
    private Postion postion;
}
