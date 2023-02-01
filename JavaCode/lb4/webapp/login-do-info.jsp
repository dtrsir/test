<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.tsgl.dao.UserDao" %>
<%@ page import="com.tsgl.dao.impl.UserDaoImpl" %>
<%@ page import="com.tsgl.pojo.User" %>
<%@ page import="com.tsgl.service.UserService" %>
<%@ page import="com.tsgl.service.impl.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%

	/* 接收登陆数据 */
	
    // 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <style type="text/css">
        h1 {
            text-align: center;
        }

        h4 {
            text-align: center;
            color: red;
        }

        body {
            background-color: antiquewhite;
        }
    </style>
</head>
<body>
<h1>现存图书列表</h1>
<hr>
<%
	//其实就是控制层
    // 设置接收的编码为UTF-8
    request.setCharacterEncoding("utf-8");
    User user = new User();
    UserDao dao = new UserDaoImpl();

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    user.setUsername(username);
    user.setPassword(password);

    // 获取用户登录信息
    //返回一个用户对象，登陆失败就返回空
    User us = dao.login(user);

    // 把数据库里面的User获取出来
    UserService service = new UserServiceImpl();
    List<User> list = service.selectUser(username);
    for (int i = 0; i < list.size(); i++) {
        user = list.get(i);
    }

    System.out.println("----us的信息----");
    System.out.println(us);

    // 设置会话
    session.setAttribute("user", user);


    // 这里要对us判空处理，1是管理者，0是学生，此处的isadmin必须填写不能为空。
    if (us != null && us.getIsadmin().equals(1)) {
        response.sendRedirect("admin/admin-home.jsp");
    } else if (us != null && !us.getIsadmin().equals(1)) {
        response.sendRedirect("user/user-home.jsp");
    } else {
        response.sendRedirect("errorPage/login-fail.jsp");
    }
%>
</body>
</html>
