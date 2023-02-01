<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/18
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div>
    <form action="dologin" method="post">
        <p><label for="username">用户名：</label>
            <input type="text" name="username" id="username" required placeholder="请输入用户名">
        </p>

        <p><label for="userpwd">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
            <input type="password" name="userpwd" id="userpwd" required placeholder="请输入密码">
        </p>
        <p> <input type="submit" value="登录"></p>

        <%
            String msg ="";
            String error= request.getParameter("error");
            if(error!=null &&error.equals("1"))
                msg = "用户名或者密码错误";
        %>
        <p style="color: red"><%=msg%></p>
    </form>


</div>
</body>
</html>
