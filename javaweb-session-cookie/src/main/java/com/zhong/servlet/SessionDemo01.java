package com.zhong.servlet;

import org.apache.jasper.runtime.HttpJspBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("Text/html;charset=utf-8");
        //拿到session
        HttpSession session = req.getSession();
        //向session中存东西
        session.setAttribute("name", "张三");
        //获得session的id
        String id = session.getId();
        //判断session是不是新创建的
        if (session.isNew()) {
            System.out.println(id + "是新创建的");
        } else {
            System.out.println(id + "不是新创建的");
        }
        //拿到session中的值
        session.getAttribute("name");

        //手动注销session
        session.removeAttribute("name");
        session.invalidate();
        // 由服务器来注销session在web.xml中实现
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
