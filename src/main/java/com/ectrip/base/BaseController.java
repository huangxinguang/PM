package com.ectrip.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by huangxinguang on 2017/4/19 下午4:14.
 * </p>
 * Desc:
 */
public abstract class BaseController {

    private final static Logger _log = LoggerFactory.getLogger(BaseController.class);

    protected int pageSize = 10;

    public ModelAndView getModelAndView() {
        return new ModelAndView();
    }

    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public HttpSession getSession() {
        return getRequest().getSession();
    }

    public String getCurrentUser() {
        return getSession().getAttribute("user").toString();
    }

}
