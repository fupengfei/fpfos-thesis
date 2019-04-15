package com.fupengfei.thesis.dao.core;

import com.fupengfei.thesis.entity.core.AbstractEntity;
import com.fupengfei.thesis.repository.core.AbstractJpaRepository;
import com.fupengfei.thesis.repository.core.AbstractRedisRepository;
import com.fupengfei.thesis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.service.core.AbstractService
 * @Author: fpfos
 * @Date: 2019-04-09 22:45
 */
public abstract class AbstractDao<T extends AbstractEntity, JR extends AbstractJpaRepository<T>, RR extends AbstractRedisRepository<T>> {

    protected Class<T> tClass;

    public AbstractDao(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Autowired
    protected JR jpaRepository;
    @Autowired
    protected RR redisRepository;
    @Autowired
    protected RedisUtils redisUtils;

    public T findByPrimaryCode(String primaryCode){

        T t = redisRepository.findByPrimaryCode(primaryCode);
        if( null != t){
            return t;
        }
        return jpaRepository.findByPrimaryCode(primaryCode);
    }

}
