package com.fupengfei.thesis.entity;

import com.fupengfei.thesis.entity.core.AbstractEntity;
import com.fupengfei.thesis.entity.enums.Gender;
import com.fupengfei.thesis.entity.enums.Postion;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

    @Column(name = "staff_name", nullable = false)
    private String staffName;

    @Column(name = "staff_name", nullable = false)
    private Integer staffAge;

    @Column(name = "staff_name", nullable = false)
    private Gender gender;

    @Column(name = "staff_name", nullable = false)
    private String selfie;

    @Column(name = "staff_name", nullable = false)
    private String mobile;

    @Column(name = "staff_name", nullable = false)
    private String email;

    @Column(name = "staff_name", nullable = false)
    private Postion postion;
}
