package com.jinghuayuan.controller;
// Copyright 2021-2101 Pica.

import com.jinghuayuan.bean.UserBo;
import com.jinghuayuan.exception.WordException;
import com.jinghuayuan.exception.WordException2;
import com.jinghuayuan.vo.BaseRespVo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 井华源
 * @Date 2021/5/5 21:01
 * @ModifyDate 2021/5/5 21:01
 * @Version 1.0
 */
@RestController
public class UserController {


    public BaseRespVo login(@Validated UserBo user, BindingResult bindingResult) { //通知要做参数校验
        if (bindingResult.hasFieldErrors()) {
            //有一个没通过就是true
            FieldError fieldError = bindingResult.getFieldError();//获得成员变量绑定的错误
            String field = fieldError.getField(); //没有通过校验的成员变量名 → 请求参数名
            Object rejectedValue = fieldError.getRejectedValue(); //拒绝值，你因为哪一个值没有通过校验
            String defaultMessage = fieldError.getDefaultMessage();//默认的消息
            String message = "你因为请求参数" + field + "没有通过校验,你传入的值为" + rejectedValue + ";" + defaultMessage;
            return BaseRespVo.fail(message);
        }
        return BaseRespVo.ok();
    }

    @RequestMapping("login/{username}/{password}")
    public BaseRespVo login(@PathVariable("username") String userName, @PathVariable("password") String passWord) throws WordException, WordException2 {
        if (userName.length() > 10) {
            //长度超过10
            throw new WordException("长度超过10", userName);
            //return BaseRespVo.fail(userName + "长度超过10");
        }
        if (passWord.length() < 6) {
            throw new WordException2("长度小于6", passWord);
           // return BaseRespVo.fail(passWord + "长度小于6");
        }
        if (userName.contains("yuanzhi")) {
            return BaseRespVo.ok(userName);
        }
        return BaseRespVo.ok();
    }

}
