package com.fupengfei.thesis.entity;

import com.fupengfei.thesis.entity.core.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.entity.core.StaffSecrecy
 * @Author: fpfos
 * @Date: 2019-04-08 23:19 员工隐私信息
 */
@Setter
@Getter
@Table(name = "lw_staff_secrecy")
@Entity
public class StaffSecrecy extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "staff_primary_code", referencedColumnName = "primary_code")
    private Staff staff;

    @Column(name = "passwd_salt")
    private String passwordSalt;

    @Column(name = "passwd_hash")
    private String passwordHash;

    @Column(name = "staff_address")
    private String staffAddress;

    @Column(name = "staff_id_card")
    private String staffIDCard;

    @Column(name = "staff_id_card_photo")
    private String staffIDCardPhoto;

    @Column(name = "staff_id_card_photo_back")
    private String staffIDCardPhotoBack;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @Column(name = "emergency_contact_mobile")
    private String emergencyContactMobile;

    @Column(name = "salary")
    private BigDecimal salary;

}
