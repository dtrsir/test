<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
	String userName = request.getParameter("userName");
	String pwd = request.getParameter("pwd");
	if(userName.equals("root") && pwd.equals("123456")) {%>
		<jsp:forward page="Logined.jsp"></jsp:forward>
<%		
	}else {
%>
		<h1>登录失败</h1>
		<jsp:forward page="Login.jsp"></jsp:forward>
<%
	}
%>

</body>
</html>