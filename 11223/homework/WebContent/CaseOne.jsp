<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>案例一</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>
<div id="main">
    <div id="left">
        <iframe src="user.html" frameborder="0" name="onlineUser" width="100%" height="310px" scrolling="auto"></iframe>
    </div>
    <div id="right">
        <p>
            <img src="./images/znz.gif" alt="">
        </p>
    </div>
</div>
<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>