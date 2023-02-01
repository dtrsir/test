package com.zhong.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("<h1>");
        resp.getWriter().print("JSP程序设计");
        resp.getWriter().print("</h1>");
        int result = (int)(Math.random() * (5 - 1 + 1) + 1);
        switch (result) {
            case 1: resp.getWriter().print("第1章 jsp技术概述");break;
            case 2: resp.getWriter().print("第2章 客户的技术");break;
            case 3: resp.getWriter().print("第3章 jsp开发环境");break;
            case 4: resp.getWriter().print("第4章 jsp基础语法");break;
            case 5: resp.getWriter().print("第5章 jsp内置环境");break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
