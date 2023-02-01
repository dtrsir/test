package com.zhong.filter;

import javax.servlet.*;
import java.io.IOException;

//字符编码过滤器，保证所有的请求都是utf-8，避免显示乱码
public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        //传递链
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
