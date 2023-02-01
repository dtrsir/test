<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="./第四章素材_更新/案例二素材/css/style.css">
        <title>系统后台管理</title>
    </head>

    <body>
        <%@include file="./重置.jsp" %>
            <div id="main">
                <div id="left" style="width: 20%;">
                	<p>系统后台管理</p>
                    <div id="list" align="center">
                        <ul style="text-indent: 4px;">
                            <li><a href="#" target="rightFrame"> 用户管理</a></li>
                            <li><a href="#" target="rightFrame"> 学期管理</a></li>
                            <li><a href="#" target="rightFrame"> 课程管理</a></li>
                        </ul>
                    </div>
                </div>
                <div id="right" style="width: 79%;">
                    <iframe name="rightFrame" id="rightFrame" scrolling="auto" height="500" width="100%" src="./第四章素材_更新/案例二素材/default.html" 
                    marginwidth="0" marginheight="0" border="0" align="center" frameborder="0">不支持</iframe>
                </div>
            </div>
    </body>

    </html>