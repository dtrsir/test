<%--
  Created by IntelliJ IDEA.
  User: zhongzheng
  Date: 2022/9/12
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名:<input name="userName" type="text">
    密码:<input name="password" type="text">
    <input type="submit" value="提交">
</form>

</body>
</html>
