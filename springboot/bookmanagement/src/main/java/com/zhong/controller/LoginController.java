package com.zhong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    //系统首页设置为登陆页
    @RequestMapping("/")
    public String ToLoginPage() {
        return "login";
    }
}
