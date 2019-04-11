package com.fupengfei.thesis.entity.core;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.entity.core.JsonBaseObject
 * @Author: fpfos
 * @Date: 2019-04-08 23:12
 */
public abstract class JsonBaseObject implements Serializable {

    public static Gson GSON = new Gson();

    public String toJson() {

        return GSON.toJson(this);
    }
}






