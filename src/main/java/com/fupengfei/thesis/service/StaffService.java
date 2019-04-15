package com.fupengfei.thesis.service;

import com.fupengfei.thesis.bean.request.StaffCreateReq;
import com.fupengfei.thesis.dao.StaffDao;
import com.fupengfei.thesis.entity.Staff;
import com.fupengfei.thesis.entity.StaffSecrecy;
import com.fupengfei.thesis.repository.jpa.StaffJpaRepository;
import com.fupengfei.thesis.repository.jpa.StaffSecrecyJpaRepository;
import com.fupengfei.thesis.service.core.AbstractService;
import com.fupengfei.thesis.utils.BeanUtils;
import com.fupengfei.thesis.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Fu Pengfei
 * @Date 2019-04-11
 * @Description TODO
 */

@Service
public class StaffService extends AbstractService<Staff, StaffJpaRepository> {
    public StaffService() {
        super(Staff.class);
    }

    @Autowired
    private StaffDao staffDao;
    @Autowired
    private StaffSecrecyJpaRepository staffSecrecyJpaRepository;

    @Transactional(rollbackFor = Exception.class)
    public void doCreate(StaffCreateReq req) {

        Staff staff = BeanUtils.request2Entity(Staff.class, req);

        StaffSecrecy staffSecrecy = BeanUtils.request2Entity(StaffSecrecy.class, req);
        final String defaultPasswd = "123456";
        String passwdSalt = Md5Util.generateSalt();
        String passwdHash = Md5Util.generateMd5Hex(passwdSalt,defaultPasswd);
        staffSecrecy.setPasswordSalt(passwdSalt);
        staffSecrecy.setPasswordHash(passwdHash);
        staffDao.doCreate(staff, staffSecrecy);
    }
}
