<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>系统登录 - 图书管理系统</title>
</head>
<body>
<%--登陆开始--%>
<h1>图书管理系统 - 登陆</h1>
<form method="post" action="${pageContext.request.contextPath}/login.do" name="login">
    <label>账号：</label>
    <input name="userCode" required placeholder="请输入账号" type="text"/>
    <br/>
    <label>密码：</label>
    <input name="pwd" required placeholder="请输入密码" type="password"/>
    <br/>
    ${errorMessage}
    <br/>
    <input type="submit" value="登陆"/>
    &nbsp;&nbsp;&nbsp;
    <input type="reset"  value="重置"/>
</form>
<%--登陆结束--%>
</body>
</html>
