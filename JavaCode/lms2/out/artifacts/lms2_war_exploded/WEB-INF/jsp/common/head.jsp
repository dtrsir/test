<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<head>
    <title>图书管理系统</title>
    <style type="text/css">
        .left {
            float: left;
        }

        #cover {
            position: absolute;
            left: 0px;
            top: 0px;
            background: rgba(0, 0, 0, 0.4);
            width: 100%; /*宽度设置为100%，这样才能使隐藏背景层覆盖原页面*/
            height: 100%;
            filter: alpha(opacity=60); /*设置透明度为60%*/
            opacity: 0.6; /*非IE浏览器下设置透明度为60%*/
            display: none;
            z-Index: 999;
        }

        #modal {
            position: absolute;
            width: 500px;
            height: 300px;
            top: 50%;
            left: 50%;
            background-color: #fff;
            display: none;
            cursor: pointer;
            z-Index: 9999;
        }
    </style>
    <script>
        function showzhezhao() {
            let modal = document.getElementById("modal");
            let cover = document.getElementById("cover");
            modal.style.display = "block";
            cover.style.display = "block";
        }

        function closezhezhao() {
            let modal = document.getElementById("modal");
            let cover = document.getElementById("cover");
            modal.style.display = "none";
            cover.style.display = "none";
        }

    </script>
<%--    <link href="/css/zhezhao.css" type="text/css" rel="stylesheet"/>--%>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
</head>
<body>
    <header class="container-fluid">
        <div class="row" style="height: 84px">
            <div class="col-md-3">
                <img alt="系统图标" style="width: 50px; height: 50px" src="${pageContext.request.contextPath}/static/images/图标.png"/>
                <h3 style="display: inline;line-height: 84px">图书管理系统</h3>
            </div>
            <div class="col-md-3 col-md-offset-6" >
                <a href="${pageContext.request.contextPath}/user/logout"><button style="float: right;margin: 20px 0 0 15px" class="btn btn-success" type="button">退出</button></a>

                <span style="line-height: 80px;float:right;">${sessionScope.user.roleName} ${sessionScope.user.userName}，欢迎你！ </span>

            </div>
        </div>
    </header>

    <section class="container-fluid" style="height: 750px">
    <div class="row" style="height: 750px">
        <div class="col-md-1" style="background-color: gainsboro;height: 750px">
            <ul class="nav nav-list">
                <li class="nav-header">
                    功能列表
                </li>
                <li class="active">
                    <a href="${pageContext.request.contextPath}/book/bookList">图书管理</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/borrow/borrowList">借阅记录</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/user/userList">用户管理</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/user/toModifyPassword">密码修改</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/user/logout">退出系统</a>
                </li>
            </ul>
        </div>
