package com.zhong.controller;

import com.zhong.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {


    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }



    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse httpServletResponse) throws IOException {
        if ("123".equals(name)) {
            httpServletResponse.getWriter().print("true");
        }else {
            httpServletResponse.getWriter().print("false");
        }
    }


    @RequestMapping("/a2")
    public List<User> a2() {
        List<User> list = new ArrayList<User>();
        list.add(new User("1", 1, "1"));
        list.add(new User("2", 1, "1"));
        list.add(new User("3", 1, "1"));

        return list;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd) {
        String msg = "";
        if (name != null) {
            if ("admin".equals(name)) {
                msg = "ok";
            }else {
                msg = "用户名不为admin";
            }
        }
        if (pwd != null) {
            if ("123456".equals(pwd)) {
                msg = "ok";
            }else {
                msg = "密码不为123456";
            }
        }
        return msg;
    }
}
