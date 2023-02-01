<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<head>
    <title>图书管理系统</title>
    <style type="text/css">
        .left {
            float: left;
        }
        #cover{
            position:absolute;
            left:0px;
            top:0px;
            background:rgba(0, 0, 0, 0.4);
            width:100%;  /*宽度设置为100%，这样才能使隐藏背景层覆盖原页面*/
            height:100%;
            filter:alpha(opacity=60);  /*设置透明度为60%*/
            opacity:0.6;  /*非IE浏览器下设置透明度为60%*/
            display:none;
            z-Index:999;
        }
        #modal{
            position:absolute;
            width:500px;
            height:300px;
            top:50%;
            left:50%;
            background-color:#fff;
            display:none;
            cursor:pointer;
            z-Index:9999;
        }
    </style>
    <script>
        function showzhezhao() {
            let modal = document.getElementById("modal");
            let cover = document.getElementById("cover");
            modal.style.display="block";
            cover.style.display="block";
        }

        function closezhezhao() {
            let modal = document.getElementById("modal");
            let cover = document.getElementById("cover");
            modal.style.display="none";
            cover.style.display="none";
        }

    </script>
    <link href="/css/zhezhao.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<!--头部-->
<header>
    <h1>图书管理系统</h1>
    <div>
        <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.user.userName }</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/jsp/logout.do">退出</a>
    </div>
</header>
<%--头部结束--%>

<!--主体内容-->
<section>
    <div class="left">
        <h2><span></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="${pageContext.request.contextPath}/jsp/bill?method=query">图书管理</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/provider?method=query">借阅记录</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/user.do?method=query">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/pwdModify.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/logout.do">退出系统</a></li>
            </ul>
        </nav>
    </div>

