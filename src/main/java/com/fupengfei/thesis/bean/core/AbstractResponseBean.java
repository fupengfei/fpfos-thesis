package com.fupengfei.thesis.bean.core;

import com.fupengfei.thesis.entity.core.JsonBaseObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

/**
 * @author Fu Pengfei
 * @Date 2019-04-12
 * @Description TODO
 */
@Setter
@Getter
public class AbstractResponseBean extends JsonBaseObject {

    public AbstractResponseBean() {
        this.code = 0;
        this.timestamp = Calendar.getInstance().getTimeInMillis();
    }

    private Integer code;

    private String errMsg;

    private Long timestamp;
}
