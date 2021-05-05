package com.jinghuayuan.controller;
// Copyright 2021-2101 Pica.

import com.jinghuayuan.vo.BaseRespVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author 井华源
 * @Date 2021/5/5 19:32
 * @ModifyDate 2021/5/5 19:32
 * @Version 1.0
 */
@RestController
public class HelloController  {

    @RequestMapping("hello")
    public BaseRespVo hello1(@SessionAttribute("username")String userName) {
        System.out.println("username:"+userName);
        return BaseRespVo.ok();
    }
    @RequestMapping("hello/word")
    public BaseRespVo hello2() {
        System.out.println("hello/word");
        return BaseRespVo.ok();
    }
    @RequestMapping("hello/word/aaa")
    public BaseRespVo hello3() {
        System.out.println("hello/word/aaa");
        return BaseRespVo.ok();
    }

    @RequestMapping("login/{name}")
    public BaseRespVo login(HttpSession session,@PathVariable("name") String userName) {
        System.out.println("login");
        session.setAttribute("username",userName);
        return BaseRespVo.ok();
    }
}
