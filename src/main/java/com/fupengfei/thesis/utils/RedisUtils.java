package com.fupengfei.thesis.utils;

import com.fupengfei.thesis.bean.enums.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Fu Pengfei
 * @Date 2019-04-14
 * @Description TODO
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    public void set(RedisKey redis, Object value, String... args) {

        String redisKey = redis.getRedisKey(args);
        redisTemplate.opsForValue().set(redisKey, value, redis.getExpiredsecond(), TimeUnit.SECONDS);
    }

    public Boolean exist(RedisKey redis, String... args) {

        String redisKey = redis.getRedisKey(args);
        return redisTemplate.hasKey(redisKey);
    }

    public Object get(RedisKey redis, String... args){

        String redisKey = redis.getRedisKey(args);
        return redisTemplate.opsForValue().get(redisKey);
    }

    public Boolean del(RedisKey redis, String... args) {

        String redisKey = redis.getRedisKey(args);
        return redisTemplate.delete(redisKey);
    }


}
