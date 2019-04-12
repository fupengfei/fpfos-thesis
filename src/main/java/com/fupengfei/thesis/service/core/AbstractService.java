package com.fupengfei.thesis.service.core;

import com.fupengfei.thesis.entity.core.AbstractEntity;
import com.fupengfei.thesis.repository.core.AbstractJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.service.core.AbstractService
 * @Author: fpfos
 * @Date: 2019-04-09 22:45
 */
public abstract class AbstractService<T extends AbstractEntity, ID extends Serializable, JR extends AbstractJpaRepository<T, ID>> {

    @Autowired
    private JR jresponse;

    private Class<T> poClass;

    public AbstractService(Class<T> poClass) {
        this.poClass = poClass;
    }
}
