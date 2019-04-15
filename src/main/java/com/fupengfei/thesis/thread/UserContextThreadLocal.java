package com.fupengfei.thesis.thread;

import org.springframework.util.Assert;

/**
 * @author Fu Pengfei
 * @Date 2019-04-14
 * @Description TODO
 */
public class UserContextThreadLocal<T> extends ThreadLocal<T>  {

    private final String name;

    public UserContextThreadLocal(String name) {
        Assert.hasText(name, "Name must not be empty");
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
