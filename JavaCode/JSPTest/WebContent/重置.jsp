<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()
	+ "://" + request.getServerName() + ":" 
	+  request.getServerPort()+path+"/";
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./第四章素材_更新/案例二素材/css/style.css">
<title>重置</title>
</head>
<body>
    <div id="header">
        <div id="logo">
            <img src="./static/images/logo.gif" alt="logo" border="0"><br/>
            <span>2015年春季学期    当前用户：小李（管理员）</span>
        </div>
        <div id="banner">好好学习，天天向上</div>
        <div id="menu">
            <ul>
                <li><a href="main.html">首页</a></li>
                <li><a href="#">在线学习</a></li>
                <li><a href="#">作业管理</a></li>
                <li><a href="<%=basePath%>重置2.jsp">后台管理</a></li>
                <li><a href="#">关于我们</a></li>
                <li><a href="<%=basePath%>case5.jsp">重新登陆</a></li>
            </ul>
        </div>
    <img src="<%=basePath%>images/head.gif" align="middle" alt="" id="computer">
    </div>
</body>
</html>