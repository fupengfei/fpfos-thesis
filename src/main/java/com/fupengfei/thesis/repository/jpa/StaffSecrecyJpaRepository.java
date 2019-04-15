package com.fupengfei.thesis.repository.jpa;

import com.fupengfei.thesis.entity.StaffSecrecy;
import com.fupengfei.thesis.repository.core.AbstractJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Fu Pengfei on 2018/8/14.
 */
@Repository
public interface StaffSecrecyJpaRepository extends AbstractJpaRepository<StaffSecrecy> {

    @Query(" from #{#entityName} e where e.staff.email = ?1 and e.isDel = false and e.staff.isDel = false ")
    StaffSecrecy findByEmail(String email);

}
