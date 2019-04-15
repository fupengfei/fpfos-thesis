package com.fupengfei.thesis.utils;

import com.fupengfei.thesis.bean.core.AbstractRequestBean;
import com.fupengfei.thesis.context.UserContext;
import com.fupengfei.thesis.context.UserContextHolder;
import com.fupengfei.thesis.entity.core.AbstractEntity;
import com.fupengfei.thesis.exception.ApiException;
import com.fupengfei.thesis.exception.ApiExceptionCode;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Fu Pengfei
 * @Date 2019-04-14
 * @Description TODO
 */
@Slf4j
public class BeanUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static <T> T instance(Class<T> clazz) {
        try {
            T entity = clazz.newInstance();
            return entity;
        } catch (InstantiationException e) {
            log.error(" Instance entity instantiationException ", e);
            throw new ApiException(ApiExceptionCode.BAD_INSTANCE);
        } catch (IllegalAccessException e) {
            log.error(" Instance entity illegalAccessException ", e);
            throw new ApiException(ApiExceptionCode.BAD_INSTANCE);
        }
    }

    public static <T extends AbstractRequestBean, E extends AbstractEntity> E request2Entity(Class<E> clazz, T req) {


        UserContext userContext = UserContextHolder.getUserContext();

        E entity = copyProperties(clazz,req);
        entity.setPrimaryCode(uuid());
        entity.setIsDel(false);
        entity.setCreatedTime(LocalDateTime.now());
        entity.setModifiedTime(LocalDateTime.now());
        entity.setCreatePrimaryCode(userContext.getPrimaryCode());
        entity.setCreatedName(userContext.getEmail());
        entity.setModifiedPrimaryCode(userContext.getPrimaryCode());
        entity.setModifiedName(userContext.getEmail());

        return entity;
    }

    public static <T> T copyProperties(Class<T> targetClass, Object source) {

        T target = instance(targetClass);
        org.springframework.beans.BeanUtils.copyProperties(source, target);
        return target;
    }
}
