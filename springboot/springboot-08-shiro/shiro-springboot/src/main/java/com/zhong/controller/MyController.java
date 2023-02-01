package com.zhong.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping({"/", "/index", "/index.html"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "hello,world");
        return "index";

    }

    @RequestMapping("/user/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //将前端提交的表单数据封装成令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //使用令牌登陆
            subject.login(token);//执行登陆方法，shrio帮助我们认证用户
            //shiro会在这里帮助我们调用realm的认证方法。从而使用到userrealm类
            return "index";
        } catch (UnknownAccountException e) {//异常捕获，我们用来处理一些错误情况，给前端返回一些错误信息
            //用户不存在
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            //密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }


    //shiro注销实现在配置文件的内置过滤器，控制器只需要做跳转即可
    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/toLogin";
    }


    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized() {
        return "未经授权，无法访问";
    }
}
