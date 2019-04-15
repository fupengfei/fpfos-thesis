package com.fupengfei.thesis.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Fu Pengfei
 * @Date 2019-04-14
 * @Description TODO
 */
@AllArgsConstructor
public enum RedisKey {

    TOKEN("lw:token:%s", 1 * 60 * 60 * 24 * 7),

    ;

    @Getter
    private String template;
    @Getter
    private Integer expiredsecond;


    public String getRedisKey(String... args) {

        return String.format(this.template, args);
    }

}
