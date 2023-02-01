package com.zhong.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    //return true就是放行的意思，要么进入下一个拦截器，要么直接进入应用本身
    //return false会把请求拦截到这里
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入方法前，拦截");
        return true;
    }
}
