package com.fupengfei.thesis.dao;

import com.fupengfei.thesis.dao.core.AbstractDao;
import com.fupengfei.thesis.entity.Staff;
import com.fupengfei.thesis.entity.StaffSecrecy;
import com.fupengfei.thesis.repository.jpa.StaffJpaRepository;
import com.fupengfei.thesis.repository.jpa.StaffSecrecyJpaRepository;
import com.fupengfei.thesis.repository.redis.StaffRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Fu Pengfei
 * @Date 2019-04-14
 * @Description TODO
 */
@Component
public class StaffDao extends AbstractDao<Staff,StaffJpaRepository,StaffRedisRepository> {

    public StaffDao() {
        super(Staff.class);
    }

    @Autowired
    private StaffSecrecyJpaRepository staffSecrecyJpaRepository;

    @Transactional(rollbackFor = Exception.class)
    public void doCreate(Staff staff, StaffSecrecy staffSecrecy){

        jpaRepository.save(staff);
        redisRepository.save(staff);

        staffSecrecy.setStaff(staff);
        staffSecrecyJpaRepository.save(staffSecrecy);
    }



}
