package com.fupengfei.thesis.bean.core;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * @author Fu Pengfei
 * @Date 2019-04-12
 * @Description TODO
 */
public abstract class VoJsonBasic implements Serializable {

    public static Gson GSON = new Gson();

    public String toJson() {

        return GSON.toJson(this);
    }
}