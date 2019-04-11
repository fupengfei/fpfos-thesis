package com.fupengfei.thesis.repository.core;

import com.fupengfei.thesis.entity.core.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Fu Pengfei on 2018/8/2.
 */
@NoRepositoryBean
public interface AbstractJpaRepository<T extends AbstractEntity, ID> extends JpaRepository<T, ID> {

    T findByPrimaryCode(String primaryCode);
}
