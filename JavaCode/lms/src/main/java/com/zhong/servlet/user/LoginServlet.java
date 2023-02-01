package com.zhong.servlet.user;

import com.zhong.pojo.User;
import com.zhong.service.user.UserService;
import com.zhong.service.user.UserServiceImpl;
import com.zhong.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//登陆控制层
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=================================================");
        System.out.println("进入login.do");
        System.out.println("=================================================");

        //拿到登陆的用户的账户和密码
        String userCode = req.getParameter("userCode");
        String pwd = req.getParameter("pwd");

        //引入业务层对象，并调用登陆方法，返回封装好的用户的完整信息
        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, pwd);

        //登陆成功，将用户信息存进会话，并重定向到系统首页
        if (user != null) {
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            resp.sendRedirect("jsp/frame.jsp");
        } else {//登陆失败，返回登陆页，带上失败信息给view层显示（一般是通过el表达式取出）
            req.setAttribute("errorMessage", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
