package com.fupengfei.thesis.exception;

import com.fupengfei.thesis.bean.core.AbstractResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * @author Fu Pengfei
 * @Date 2019-04-12
 * @Description TODO
 */
@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AbstractResponseBean> handleApiException(HttpServletRequest req, ApiException apiex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        AbstractResponseBean response = new AbstractResponseBean();

        response.setCode(apiex.getErrCode());
        response.setErrMsg(apiex.getErrMsg());
        response.setTimestamp(String.valueOf(Calendar.getInstance().getTimeInMillis()));

        log.info("Exception message:\n{}", response.toString());

        return new ResponseEntity<AbstractResponseBean>(response, headers, HttpStatus.OK);
    }

}
