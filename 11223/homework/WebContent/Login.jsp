<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

	<%
	if (session.getAttribute("status")!=null && session.getAttribute("status").equals("no")) {
	%>
	<form action="LoginService.jsp" method="post">
		<span>用户名：</span> <input type="text" name="userName" id="" required>
		<span>密 码：</span> <input type="password" name="pwd" id="" required>
		<input type="submit" value="登录"> <span>用户名或密码输入错误，请重新输入</span>
	</form>
	<%
	} else {
	%>
	<form action="LoginService.jsp" method="post">
		<span>用户名：</span> <input type="text" name="userName" id="" required>
		<span>密 码：</span> <input type="password" name="pwd" id="" required>
		<input type="submit" value="登录">
	</form>
	<%
	}
	%>


</body>
</html>