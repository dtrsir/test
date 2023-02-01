<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员主页</title>
    <style type="text/css">

          body{
            background: url("../images/bg5.jpg");
            text-align: center;
             color: #000000;
            }
            a:hover{
			color: 	#FFFFFF;
			padding: 5px 8px 3px 12px;
			background-color: 	#BDB76B;
			border-top: #717171;
			border-left: #717171;
			border-bottom: #eee;
			border-right: #eee;
				}
				 *{
        padding: 0;
        margin: 0;
    }
    html,body{
        height: 100%;
    }
    .wrap{
        width: 260px;
        height: 100%;
        background-color:#5F9EA0;
    }
 
    .header{
        width: 100%;
        height: 65px;
        background-color: #8FBC8F;
        font-size: 24px;
        color: #000000;
        text-align: center;
        line-height: 65px;
    }
    .nav{
        width:250px;
        margin: 10px 5px 0;
    }
    .list{
        margin-bottom: 5px;
    }
    .list h2{
        position: relative;
        padding: 15px 0;
        background-color: #8FBC8F;
        text-align: center;
        font-size: 16px;
        color: #000000;
        transition: .5s;
    }
    .list h2.on{
        background-color: #8FBC8F;
    }
    .list i{
        position: absolute;
        right: 10px;
        top: 16px;
        border: 8px solid transparent;
        border-left-color: #fff;/*triangle*/
        transform:rotate(0deg);
        transform-origin: 1px 8px;
        transition: .5s;
    }
    .list i.on{
        transform:rotate(90deg);
    }
    .hide{
        overflow: hidden;
        height: 0;
        transition: .5s;
    }
    .hide h5{
        padding: 10px 0;
        background-color: #8FBC8F;
        text-align: center;
        color:#fff;
        border-bottom:#42495d;
    }
    </style>
</head>
<body>
<%-- 头部 --%>
<jsp:include page="../top.jsp"/>
<h2>欢迎来到图书知识海洋</h2>
<h3>读书破万卷，下笔如有神</h3>
<br/>
<br/>
<hr>

    <div class="wrap">
        <div class="header">管理员操作</div>
        <div class="nav">
            <ul>
                <li class="list">
                    <h2><i></i>管理用户</h2>
                    <div class="hide">
                        <h5><h5><a href="admin-user-manager.jsp">管理用户</a><h5></h5>
                        <h5><a href="admin-user-add.jsp">新增用户</a></h5>
                    </div>
                </li>
                <li class="list">
                    <h2><i></i>管理图书</h2>
                    <div class="hide">
                        <h5><h5><a href="admin-book-manager.jsp">管理图书</a></h5></h5>
                        <h5><a href="admin-book-add.jsp">新增图书</a></h5>
                    </div>
                </li>
             
                
            </ul>
        </div>
    </div>
    <script>
        (function () {
            var oList = document.querySelectorAll('.list h2'),
                oHide = document.querySelectorAll('.hide'),
                oIcon = document.querySelectorAll('.list i'),
                lastIndex = 0;
            for(var i=0;i<oList.length;i++){
                oList[i].index = i;//自定义属性
                oList[i].isClick = false;
                oList[i].initHeight = oHide[i].clientHeight;
                oHide[i].style.height = '0';
                oList[i].onclick = function () {
                    if(this.isClick){
                        oHide[this.index].style.height = '0';
                        oIcon[this.index].className = '';
                        oList[this.index].className = '';
                        oList[this.index].isClick = false;
                    }
                    else{
                        oHide[lastIndex].style.height = '0';
                        oIcon[lastIndex].className = '';
                        oList[lastIndex].className = '';
                        oHide[this.index].style.height = '220px';
                        oIcon[this.index].className = 'on';
                        oList[this.index].className = 'on';
                        oList[lastIndex].isClick = false;
                        oList[this.index].isClick = true;
                        lastIndex = this.index;
                    }
                }
            }
        })();
    </script>
</body>
</html>
