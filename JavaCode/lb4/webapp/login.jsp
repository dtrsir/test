<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
	// 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
		+ request.getServerPort() + path + "/";
	//http://localhost:3306/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统登录</title>
	<link rel="stylesheet" type="text/css" href="css/headFoot.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	
	<!-- 设置根路径 -->
	<!-- html中的超链接就会相对与这个路径去找文件 -->
	<base href="<%=basePath %>" />
	
	<style type="text/css">
		body{
			background: url("images/bg5.jpg");
            text-align: center;
            }
    </style>
</head>
<body>
	<!-- 头部开始 -->
	<div id="header">
		<div id="logo">
			<img src="./images/bg16.jpg" border="0"/><br/>
		</div>
			
		<div id="banner">好好学习，天天向上</div>
			
		<img id="computer" src="./images/head.gif" align="middle"/>
	</div>
	<!-- 头部结束 -->
		
	<!-- 主体开始 -->
	<div id="page">
		<br/><br/><br/><br/>
		<!-- 登陆框开始 -->
		<div id="login">
			
			<!-- 登陆框标题 -->
			<div id="title">
				<h1><img alt="" src="images/quanx32.gif" width="32" height="32" align="middle"/>
				&nbsp;系统登录</h1>
			</div>
				
			<!-- 提交表单开始 -->
			<form id="form1" action="login-do-info.jsp" method="post">
				<div id="content">
				
               		<span>账号：</span>
               		<input type="text" name="username" id="username" placeholder="请输入您的账号" autofocus="autofocus"required="required">
           			<br/>
           			
           			<span>密码：</span>
               		<input type="password" name="password" id="password" placeholder="请输入您的密码"required="required">
               		<br/>
               		
               		<a href="search-password.jsp">找回密码</a>
           			<br/>
           			
                   	<input type="submit" value="登录"/>
                   	<input type="reset" value="重置"/>
                   	
                   	<!-- blank&&_blank -->
               		<a href="register.jsp" target="_blank">注册</a>
				</div>
			</form>
			<!-- 提交表单结束 -->
			<br/>
		</div>
		<!-- 登陆框结束 -->
	</div>
	<!-- 主体结束 -->
		
</body>
</html>