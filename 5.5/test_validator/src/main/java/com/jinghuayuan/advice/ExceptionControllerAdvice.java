package com.jinghuayuan.advice;
// Copyright 2021-2101 Pica.

/**
 * @ClassName UserExceptionHandler
 * @Description TODO
 * @Author 井华源
 * @Date 2021/5/5 21:10
 * @ModifyDate 2021/5/5 21:10
 * @Version 1.0
 */

import com.jinghuayuan.exception.WordException;
import com.jinghuayuan.exception.WordException2;
import com.jinghuayuan.vo.BaseRespVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 向上抛出异常 → 就会进入到resolveException方法中
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(WordException.class)
    public void result(WordException w, HttpServletResponse response) throws IOException {
        String message = w.getMessage();
        response.getWriter().println("Wrong Username:"+message+"word:"+w.getWord());
    }

    @ExceptionHandler(WordException2.class)
    public void result2(WordException2 w, HttpServletResponse response) throws IOException {
        String message = w.getMessage();
        response.getWriter().println("Wrong passWord:"+message+"word:"+w.getWord());
    }
}
