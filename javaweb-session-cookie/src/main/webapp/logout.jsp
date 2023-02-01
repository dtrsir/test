<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/18
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>
</body>
</html>
