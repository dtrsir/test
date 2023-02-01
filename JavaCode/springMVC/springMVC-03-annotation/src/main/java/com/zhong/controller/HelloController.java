package com.zhong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/123")//这里会出现多级目录首先进入/123
public class HelloController {

    @RequestMapping("/hello")//从/123中请求hello才能请求到这个方法（一般只使用方法上的注解而不使用类上的注解）
    public String hello(Model model) {
        //封装数据
        model.addAttribute("msg", "helloController");
        return "hello";//会被视图解析器处理，就是拼接的路径
    }
}
