package com.fupengfei.thesis.context;

import com.fupengfei.thesis.thread.UserContextThreadLocal;

/**
 * @author Fu Pengfei
 * @Date 2019-04-14
 * @Description TODO
 */
public class UserContextHolder {

    private static final ThreadLocal<UserContext> USERCONTEXT_HOLDER = new UserContextThreadLocal("UserContext");

    public static void resetUsercontext() {
        USERCONTEXT_HOLDER.remove();
    }

    public static void setUsercontext(UserContext userContext) {
        USERCONTEXT_HOLDER.set(userContext);
    }

    public static UserContext getUserContext() {
        return (UserContext) USERCONTEXT_HOLDER.get();
    }
}
