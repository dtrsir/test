<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/18
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = config.getInitParameter("username");//从配置文件取得用户名
    String pwd = config.getInitParameter("password");//从配置文件取得密码
    String username = request.getParameter("username");
    String userpwd = request.getParameter("userpwd");

    if(username !=null && username.trim().equals(name.trim())
            && userpwd !=null && userpwd.trim().equals(pwd.trim())){
        //登录成功
        session.setAttribute("username",username);
        response.sendRedirect("main.jsp");
    }
    else {
        response.sendRedirect("login.jsp?error=1");
    }

%>
</body>
</html>
