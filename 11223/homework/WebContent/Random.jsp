<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成随机数</title>
</head>
<body>
<%
	Random random = new Random();
	String num = random.nextInt(101) + "";
	StringBuffer stringbuffer = new StringBuffer();
	for(int i = 0;i < 3 - num.length();i++) {
		stringbuffer.append("0");
	}
	num = stringbuffer.toString() + num;
%>
<h1>在这里显示一个随机数:<%=num %></h1>
</body>
</html>