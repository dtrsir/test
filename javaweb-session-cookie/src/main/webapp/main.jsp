<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/18
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<div>
    <%
        String username = (String) session.getAttribute("username");
        if (username != null) {%>
    <div id="left" style="float: left;width: 80%; text-align: center">欢迎你<%=username%>
    </div>
    <div id="right" style="float: right"><a href="logout.jsp">注销</a></div>
    <% } else {
        response.setHeader("refresh","3;login.jsp");
    %>
    <div> 请先登录 <a href="login.jsp">跳转到登录</a></div>
    <%}%>
</div>
</body>
</html>
