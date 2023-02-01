package com.zhong.filter;


import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //过滤器在web服务启动的时候就会初始化，因为到等待过滤对象出现
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }
//chain是链的意思，有过滤器链
    //过滤器中的所有代码，在过滤特定请求的的时候都会执行
    //必须要让过滤器通行，写dofilter
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        System.out.println("过滤器执行前");//这里是固定写法，转交请求，如果还有过滤器则转交给过滤器，没有则交给servlet
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器执行后");
    }
//关闭服务器时销毁过滤器
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
