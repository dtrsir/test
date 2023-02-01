package com.zhong.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Dologin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        HttpSession session = req.getSession();
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        System.out.println(config.getInitParameter("username"));
        if(userName.equals(config.getInitParameter("username")) && pwd.equals(config.getInitParameter("password"))) {
            session.setAttribute("userName", userName);
            resp.sendRedirect("Logined.jsp");
        }else {
            session.setAttribute("status", "no");
            resp.sendRedirect("Login.jsp");

        }
    }
}
