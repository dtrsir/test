package com.zhong.controller;

import com.zhong.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/u1")
public class UserController {

    @GetMapping("/t1")//一般用于表单更多，它不能和RestFul风格混用
    public String test1(@RequestParam("userName") String name, Model model) {
        model.addAttribute("msg", name);
        System.out.println(name);
        return "test";
    }

    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }
}
