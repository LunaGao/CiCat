package com.cicat.utils;

import com.cicat.entity.User;
import com.cicat.service.IUserService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lunagao on 16/7/27.
 */
public class CookieHandlerInterceptor implements HandlerInterceptor {

    @Resource
    IUserService service;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestUri = httpServletRequest.getRequestURI();
        String contextPath = httpServletRequest.getContextPath();
        String url = requestUri.substring(contextPath.length());
        if ("/".equals(url)) {
            HttpSession session = httpServletRequest.getSession();
            User u = (User) session.getAttribute("User");
            if (null==u) {
                Cookie[] cookies = httpServletRequest.getCookies();
                u = CookieHelper.getCookiesUser(cookies, service);
            }
            if (null==u) {
                return true;
            }
        } else {
            HttpSession session = httpServletRequest.getSession();
            User u = (User) session.getAttribute("User");
            if (null == u) {
                Cookie[] cookies = httpServletRequest.getCookies();
                u = CookieHelper.getCookiesUser(cookies, service);
            }
            if (null == u) {
                httpServletResponse.sendRedirect("/");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        User u = CookieHelper.getCookiesUser(httpServletRequest.getCookies(), service);
        if (u != null) {
            modelAndView.addObject("name", u.getUserName());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        System.out.println("afterCompletion");
    }
}
