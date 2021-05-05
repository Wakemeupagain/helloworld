package com.jinghuayuan.interceptor;
// Copyright 2021-2101 Pica.

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName UserHanblerIntercepter
 * @Description TODO
 * @Author 井华源
 * @Date 2021/5/5 19:40
 * @ModifyDate 2021/5/5 19:40
 * @Version 1.0
 */
@Component
public class UserHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if (username == null) {//session值为null
           response.getWriter().write("Please Register...");
            return false;
        }
        return true;//可以通过
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
