<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="./css/headFoot.css">
        <link rel="stylesheet" href="./css/login.css">
        <title>案例五</title>
        <style>
            #footer {
                width: 100%;
                position:absolute;
                bottom: 0px;
            }
        </style>
    </head>

    <body>
        <!-- 页眉 -->
        <div id="header">
            <div id="logo">
                <img src="./static/images/logo.gif" alt="logo" border="0"><br />
                <span>2015年春季学期</span>
            </div>
            <div id="banner">好好学习，天天向上</div>
            <img id="computer" src="./static/images/head.gif" alt="" align="middle">
        </div>
        <!-- 主体 -->
        <div id="page">
            <div id="page">
                <div id="login">
                    <div id="title">
                        <h1><img src="./images/quanx32.gif" width="32px" height="32px" align="middle" alt=""> 系统登陆</h1>
                    </div>
                    <form action="userLogin" id="form1" method="post">
                        <div id="content">
                            <ul>
                                <li><label for="SUID">用户id：</label><input type="text" name="SUID" class="inputtext"
                                        id="username" size="20px" value="admin" required></li>
                                <li><label for="pwd">密 码：</label><input type="password" name="pwd" class="inputtext"
                                        id="passwd" size="20px" value="123456" required></li>
                                <li><input type="submit" value="提交" id="submit"></li>
                                <span style="color: #ff0000;">系统提示</span>
                            </ul>
                        </div>
                    </form>
                    <div id="btm"></div>
                    <div id="l"> </div>
                    <div id="r"></div>
                </div>
            </div>
        </div>
        <!-- 页脚 -->
        <div id="footer">
            <p>
                &copy;班级： 姓名： 学号： 制作
                <a href="#">学院网站</a>
            </p>
        </div>
    </body>

    </html>