package com.fupengfei.thesis.repository.jpa;

import com.fupengfei.thesis.entity.Staff;
import com.fupengfei.thesis.repository.core.AbstractJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Fu Pengfei on 2018/8/14.
 */
@Repository
public interface StaffJpaRepository extends AbstractJpaRepository<Staff, String> {
}
