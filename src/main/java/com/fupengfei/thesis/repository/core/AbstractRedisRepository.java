package com.fupengfei.thesis.repository.core;

import com.fupengfei.thesis.entity.core.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Fu Pengfei on 2018/8/2.
 */
@NoRepositoryBean
public interface AbstractRedisRepository<T extends AbstractEntity> extends CrudRepository<T, String> {

    T findByPrimaryCode(String primaryCode);

}
