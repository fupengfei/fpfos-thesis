package com.fupengfei.thesis.configure.interceptor;

import com.fupengfei.thesis.bean.core.AbstractResponseBean;
import com.fupengfei.thesis.bean.enums.RedisKey;
import com.fupengfei.thesis.context.UserContext;
import com.fupengfei.thesis.context.UserContextHolder;
import com.fupengfei.thesis.dao.StaffDao;
import com.fupengfei.thesis.entity.Staff;
import com.fupengfei.thesis.exception.ApiException;
import com.fupengfei.thesis.exception.ApiExceptionCode;
import com.fupengfei.thesis.utils.BeanUtils;
import com.fupengfei.thesis.utils.Md5Util;
import com.fupengfei.thesis.utils.RedisUtils;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Sdms登陆拦截器，拦截验证所有请求
 */
@Slf4j
public class TokenVaildInterceptor implements HandlerInterceptor {

    public static final String HEADER_TOKNE = "TOKEN";

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private StaffDao staffDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj)
            throws Exception {

        String token = request.getHeader(HEADER_TOKNE);
        if (StringUtils.isBlank(token)) {
            log.error(ApiExceptionCode.USER_NOT_LOGIN.getErrMsg());
            writeResponse(response, ApiExceptionCode.USER_NOT_LOGIN);
            return false;
        }

        String tokenHash = token.substring(0,32);
        String primaryCode = token.substring(32);

        if (!redisUtils.exist(RedisKey.TOKEN, primaryCode)) {
            log.error(ApiExceptionCode.USER_NOT_LOGIN.getErrMsg());
            writeResponse(response, ApiExceptionCode.USER_NOT_LOGIN);
            return false;
        }

        String tokenSalt = (String) redisUtils.get(RedisKey.TOKEN, primaryCode);
        if (!Md5Util.verifyMd5Hex(tokenSalt, primaryCode, tokenHash)) {
            log.error(ApiExceptionCode.BAD_TOKEN.getErrMsg());
            throw new ApiException(ApiExceptionCode.BAD_TOKEN);
        }

        Staff staff = staffDao.findByPrimaryCode(primaryCode);
        if (null == staff) {
            log.error(ApiExceptionCode.USER_NOT_EXIST.getErrMsg());
            writeResponse(response, ApiExceptionCode.USER_NOT_EXIST);
            return false;
        }

        UserContext userContext = BeanUtils.copyProperties(UserContext.class, staff);
        UserContextHolder.setUsercontext(userContext);
        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        UserContextHolder.resetUsercontext();
    }

    @Override
    public void postHandle(
            HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

    public void writeResponse(HttpServletResponse response, ApiExceptionCode apiExceptionCode) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        AbstractResponseBean responseData = new AbstractResponseBean();
        responseData.setCode(apiExceptionCode.getErrCode());
        responseData.setErrMsg(apiExceptionCode.getErrMsg());
        response.getWriter().write(new Gson().toJson(responseData));
    }

//    @Override
//    public UserContext findUserContextByTicket(String ticket) throws Exception {
//
//        OmsUserInfoResp sdmsUserinfo =
//                platformService.omgUserInfoByToken(ticket, apolloConfig.getOmsUserUrl());
//        if (null == sdmsUserinfo || null == sdmsUserinfo.getData()) {
//            throw new IllegalAccessException(" ticket permission denied !");
//        }
//
//        UserVo userVo = new UserVo();
//        MallUserVo mallUserInfo = new MallUserVo();
//        mallUserInfo.setAccount(sdmsUserinfo.getData().getUserName());
//        mallUserInfo.setAccountId(Long.parseLong(sdmsUserinfo.getData().getUserId()));
//        userVo.setMallUserInfo(mallUserInfo);
//
//        UserContext userContext = new UserContext();
//        userContext.setUser(userVo);
//        userContext.setUsername(sdmsUserinfo.getData().getUserName());
//        return userContext;
//    }
}
