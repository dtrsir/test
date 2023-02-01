<%@ page import="com.tsgl.pojo.User" %>
<%@ page import="com.tsgl.service.UserService" %>
<%@ page import="com.tsgl.service.impl.UserServiceImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改用户</title>
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

<h1>修改用户</h1>
<hr/>
<%
    //获取admin-user-home.jsp页面的userid
    Integer userid = Integer.parseInt(request.getParameter("userid"));
    UserService userService = new UserServiceImpl();
    User user = userService.getUser(userid);
%>
 <a href="admin-home.jsp">返回主页</a>
<form action="admin-user-do-update.jsp" method="post" name="registerForm">
    <div>
        <tr>
            <label>编号：</label>
            <input type="text" name="userid" id="userid" readonly="readonly" value="<%=user.getUserid()%>">
        </tr>
    </div>
    <div>
        <tr>
            <label>用户：</label>
            <input type="text" name="username" id="username" readonly="readonly" value="<%=user.getUsername()%>">
        </tr>
    </div>
    <div>
        <tr>
            <label>密码：</label>
            <input type="text" name="password" id="password" value="<%=user.getPassword()%>">
        </tr>
    </div>
    <div>
        <tr>
            <label>邮箱：</label>
            <input type="text" name="email" id="email" value="<%=user.getEmail()%>">
        </tr>
    </div>
    <div>
        <tr>
            <label>电话：</label>
            <input type="text" name="phone" id="phone" value="<%=user.getPhone()%>">
        </tr>
    </div>
    <div>
        <tr>
            <label>是否管理员：</label>
            <input type="text" name="isadmin" id="isadmin" value="<%=user.getIsadmin()%>">
        </tr>
    </div>



    <div>
        <tr>
            <button type="submit" onclick="return checkForm()">修改</button>
            <button type="reset" value="重置">重置</button>
        </tr>
    </div>
</form>

<script type="text/javascript">
    function checkForm() {
        var password = registerForm.password.value;
        if (password == "" || password == null) {
            alert("请输入密码");
            registerForm.password.focus();
            return false;
        }
        alert('修改成功！');
        return true;
    }
</script>
</body>
</html>