package com.zhong.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser==null) {
//            System.out.println("======================================================2121212");
            request.setAttribute("loginError", "请先登录");
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        }else {
            return true;
        }
    }

}
