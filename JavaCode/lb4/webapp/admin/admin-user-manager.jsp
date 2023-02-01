<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.tsgl.pojo.Book" %>
<%@ page import="com.tsgl.pojo.User" %>
<%@ page import="com.tsgl.service.UserService" %>
<%@ page import="com.tsgl.service.impl.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查看用户</title>
    <style type="text/css">
        h1 {
            text-align: center;
        }

          body{
            background: url("../images/bg5.jpg");
            text-align: center;
            }
        #before {
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
			.wrap{
        width: 260px;
        height: 100%;
        background-color:#8FBC8F;
    }
 
    .header{
        width: 100%;
        height: 65px;
        background-color: #B0E0E6;
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
        background-color: #B0E0E6;
        text-align: center;
        font-size: 16px;
        color: #000000;
        transition: .5s;
    }
    .list h2.on{
        background-color: #B0E0E6;
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
        background-color: #B0E0E6;
        text-align: center;
        color:#fff;
        border-bottom:#42495d;
    }	
    </style>
</head>
<body>
<%-- 头部 --%>
<jsp:include page="../top.jsp"/>

<%--图书信息--%>
<%
    // 设置获取注册时的编码为UTF-8
    request.setCharacterEncoding("UTF-8");
    Book book = new Book();
    // 获取上一个页面传过来的值
    String username = request.getParameter("username");

    System.out.println("用户名:" + username);
    // 传入的空字符串处理,null不能使用equals
    if (username != null && username.equals("")) {
        username = null;
    }

    UserService userService = new UserServiceImpl();
    List<User> list = userService.selectUser(username);

%>
<h1>用户列表</h1>
<hr>
<div id="before">

    <form action="admin-user-manager.jsp" method="post">
        请输入用户名：<input type="text" name="username" placeholder="输入用户名搜索">
        <input type="submit" value="查询"/>
    </form>
    <a href="admin-home.jsp">返回主页</a>
    <table align="center" cellspacing="0" >
    <tr bgcolor="#5f9ea0" style="font-size: 20px;height:40px;text-align: center">
        <th style="width: 120px">编号</th>
        <th style="width: 120px">用户名</th>
        <th style="width: 120px">密码</th>
        <th style="width: 120px">邮箱</th>
        <th style="width: 120px">电话</th>
        <th style="width: 120px">是否管理员</th>
        <th style="width: 120px">操作用户</th>
    </tr>
    <%
        String bg = null;
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            if (i % 2 == 0) {
                bg = "Azure ";
            } else {
                bg = "PowderBlue ";
            }

    %>
    <tr bgcolor="<%=bg%>" style="width: 120px;height: 40px;text-align: center">
        <td><%=u.getUserid()%>
        </td>
        <td><%=u.getUsername()%>
        </td>
        <td><%=u.getPassword()%>
        </td>
        <td><%=u.getEmail()%>
        </td>
        <td><%=u.getPhone() %>
        </td>
        <td><%=u.getIsadmin() %>
        </td>
        <td>
            <a href="admin-user-update.jsp?userid=<%=u.getUserid()%>">修改</a>
            <a href="admin-user-delete.jsp?userid=<%=u.getUserid()%>">删除</a>
        </td>
    </tr>
    <%
        }
    %>

</table>
<table align="center">
    <tr>
        <td><a href="admin-user-add.jsp">新增用户</a></td>
    </tr>
    
</table>

</div>

<br>


</body>
</html>
