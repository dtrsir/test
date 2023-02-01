package com.zhong.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //new一个模型和视图对象
        ModelAndView mv = new ModelAndView();
        //封装对象
        mv.addObject("msg","helloSpringMVC!");
        //封装要跳转的视图
        mv.setViewName("hello");//由于配置了视图解析器，这个名字会被加上前缀后后缀，再通过转发或者重定向
        return mv;//返回这个模型和视图对象
    }
}
