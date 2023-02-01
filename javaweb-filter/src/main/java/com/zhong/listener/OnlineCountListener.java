package com.zhong.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计网站在线人数 ： 统计session
public class OnlineCountListener implements HttpSessionListener {
    //一旦创建一次session就会触发一次事件
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println(httpSessionEvent.getSession().getId());
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");

        if (onlineCount == null) {
            onlineCount = new Integer(1);
        } else {
            int i = onlineCount.intValue();
            onlineCount = new Integer(i + 1);
        }
        servletContext.setAttribute("onlineCount", onlineCount);
    }

    //一旦销毁一次session就会触发一次事件
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if (onlineCount == null) {
            onlineCount = new Integer(0);
        } else {
            int i = onlineCount.intValue();
            onlineCount = new Integer(i - 1);
        }
        servletContext.setAttribute("onlineCount", onlineCount);
    }
}
