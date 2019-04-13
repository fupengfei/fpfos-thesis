package com.fupengfei.thesis.repository.redis;

import com.fupengfei.thesis.entity.Staff;
import com.fupengfei.thesis.repository.core.AbstractRedisRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Fu Pengfei on 2018/8/14.
 */

@Repository
public interface StaffRedisRepository extends AbstractRedisRepository<Staff, String> {

    void

}
