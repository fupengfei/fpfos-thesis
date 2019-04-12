package com.fupengfei.thesis.service;

import com.fupengfei.thesis.entity.Staff;
import com.fupengfei.thesis.repository.jpa.StaffJpaRepository;
import com.fupengfei.thesis.service.core.AbstractService;

/**
 * @author Fu Pengfei
 * @Date 2019-04-11
 * @Description TODO
 */
public class StaffService extends AbstractService<Staff, String, StaffJpaRepository> {
    public StaffService() {
        super(Staff.class);
    }
}
