package com.zhong.filter;

import com.zhong.pojo.User;
import com.zhong.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//权限拦截，屏蔽没有登陆的非法访问请求
public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //转化请求，拿到我们存session的那个请求
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //拿到user对象
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);

        //未登陆的请求都重定向到错误页面
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        } else {
            //对已经登陆的用户的请求放行
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
