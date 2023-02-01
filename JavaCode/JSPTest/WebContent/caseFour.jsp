<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <style>
            body {
                font-family: Verdana, Geneva, Tahoma, sans-serif;
                font-size: 12px;
                line-height: 1.5;
            }
            a {
                color: #000;
                text-decoration: none;
            }
            a:hover {
                color: #f00;
            }
            #nav {
                border: 1px solid #ccc;
                height: 26px;
                background: #eee;
            }
            #nav ul {
                list-style: none;
                margin: 0;
                padding: 0;
            }
            #nav li {
                float: left;
                padding: 0 8px;
                height: 26px;
                line-height: 26px;
            }

        </style>
        <title>案例四</title>
    </head>
    <body>
        <div id="header">
            <p>
                <img src="./static/images/logo.gif" alt="logo">
                图片img标签嵌套在段落p标签中
            </p>
        </div>
        <div id="nav">
            <ul>
                <li><a href="main.html"> 首页</a></li>
                <li><a href="121212.html"> 在线学习</a></li>
                <li><a href="#"> 空连接</a></li>
            </ul>
        </div>
        <hr />
        <div id="main">
            <iframe src="main.html" width="98%" height="300px" scrolling="auto" frameborder="0"></iframe>
        </div>
    </body>
    </html>