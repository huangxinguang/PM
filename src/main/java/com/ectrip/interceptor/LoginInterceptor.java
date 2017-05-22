package com.ectrip.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huangxinguang on 2017/5/22 下午3:26.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    private static final String LOGIN_URL = "/login.html";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getServletPath().endsWith("login.html") || request.getServletPath().endsWith("loginIn.do")) {
            return true;
        }

        Object user = request.getSession().getAttribute("user");
        if(user != null) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + LOGIN_URL);


        log.info(request.getContextPath() + LOGIN_URL);
        return false;
    }
}

