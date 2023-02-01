package com.zhong.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter  implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;
        if (servletRequest1.getSession().getAttribute("USER_SESSION")==null) {
            servletResponse1.sendRedirect("/err/error.jsp");
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
