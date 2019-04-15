package com.fupengfei.thesis.service.core;

import com.fupengfei.thesis.entity.core.AbstractEntity;
import com.fupengfei.thesis.repository.core.AbstractJpaRepository;
import com.fupengfei.thesis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.service.core.AbstractService
 * @Author: fpfos
 * @Date: 2019-04-09 22:45
 */
public abstract class AbstractService<T extends AbstractEntity, JR extends AbstractJpaRepository<T>> {

    @Autowired
    protected JR jpaResponse;

    @Autowired
    protected RedisUtils redisUtils;

    protected Class<T> poClass;

    public AbstractService(Class<T> poClass) {
        this.poClass = poClass;
    }
}
