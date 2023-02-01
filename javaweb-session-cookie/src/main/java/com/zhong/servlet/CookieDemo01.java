package com.zhong.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        //通过request拿到一个cookie的数组
        Cookie[] cookies = req.getCookies();

        out.print("你第一次访问的时间是：");


        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lastTime")) {
                    long last = Long.parseLong(cookie.getValue());
                    Date date = new Date(last);
                    out.print(date.toLocaleString());
                }
            }

        } else {
            out.print("这是你第一次登陆");
        }

        //通过responds返回一个cookie
        Cookie cookie = new Cookie("lastTime", System.currentTimeMillis() + "");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
