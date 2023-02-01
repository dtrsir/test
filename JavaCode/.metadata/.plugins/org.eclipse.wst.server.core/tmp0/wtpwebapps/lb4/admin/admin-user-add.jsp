<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新增用户</title>
    <style type="text/css">
        h1 {
            text-align: center;
        }

        h4 {
            text-align: center;
            color: red;
        }
        
		 body{
            background: url("../images/bg5.jpg");
            text-align: center;
            }
            
        div {
            text-align: center;
        }

        #before {
            text-align: center;
        }
            a:hover{
			color: #06f;
			padding: 5px 8px 3px 12px;
			background-color: 	#BDB76B;
			border-top: #717171;
			border-left: #717171;
			border-bottom: #eee;
			border-right: #eee;
				}

    </style>
</head>
<body>
<%-- 头部 --%>
<jsp:include page="../top.jsp"/>

<h1>新增用户</h1>
<hr>

<div id="before">
     <a href="admin-home.jsp">返回主页</a>
</div>
</br>

<form action="admin-user-do-add.jsp" method="post" name="registerForm">
    <div>
        <tr>
            <label>账号：</label>
            <input type="text" name="username" id="username" placeholder="用户名" autofocus="autofocus">
        </tr>
    </div>
    <div>
        <tr>
            <label>密码：</label></td>
            <input type="text" name="password" id="password" placeholder="密码">
        </tr>
    </div>
    <div>
        <tr>
            <label>邮箱：</label>
            <input type="text" name="email" id="email" placeholder="邮箱">
        </tr>
    </div>
    <div>
        <tr>
            <label>电话：</label>
            <input type="text" name="phone" id="phone" placeholder="电话">
        </tr>
    </div>
    <div>
        <tr>
            <label>是否管理员：</label>
            <input type="text" name="isadmin" id="isadmin" placeholder="是否管理员（1是，0否）">
        </tr>
    </div>

    <div id="submitbtn">
        <tr>
            <button type="submit" onclick="return checkForm()">添加</button>
            <button type="reset">重置</button>

        </tr>
    </div>
</form>

<script type="text/javascript">
    function checkForm() {
        var username = registerForm.username.value;
        var password = registerForm.password.value;
        if (username == "" || username == null) {
            alert("请输入用户名");
            registerForm.username.focus();
            return false;
        } else if (password == "" || password == null) {
            alert("请输入密码");
            registerForm.password.focus();
            return false;
        }
        alert('添加成功！');
        return true;
    }
</script>
</body>
</html>