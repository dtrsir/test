<%--
  Created by IntelliJ IDEA.
  User: zhongzheng
  Date: 2022/5/9
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>当前在线人数 <span><%=this.getServletConfig().getServletContext().getAttribute("onlineCount")%></span> 人</h1>
</body>
</html>
