<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.tsgl.pojo.Book" %>
<%@ page import="com.tsgl.service.impl.BookServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tsgl.service.BookShelfService" %>
<%@ page import="com.tsgl.service.impl.BookShelfServiceImpl" %>
<%@ page import="com.tsgl.pojo.BookShelf" %>
<%@ page import="com.tsgl.pojo.User" %>
<%@ page import="com.tsgl.service.RecordService" %>
<%@ page import="com.tsgl.service.impl.RecordServiceImpl" %>
<%@ page import="com.tsgl.pojo.Record" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>借阅记录</title>
    <style type="text/css">
        h1 {
            text-align: center;
        }

        #before {
            text-align: center;
        }
        
        body{
            background: url("../images/bg5.jpg");
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

<%--图书信息--%>
<%

    // 获取userid
    User user =(User)session.getAttribute("user");
    Integer userid = user.getUserid();

    // 获取该用户的书单
    RecordService recordService = new RecordServiceImpl();
    List<Record> list = recordService.selectRecords();
%>
<h1>借阅记录</h1>
<hr>
<div id="before">
    <form action="../user/user-home.jsp" method="post">
        请输入书名：<input type="text" name="bookname" placeholder="输入图书名称搜索">
        <input type="submit" value="查询"/>
    </form>
    <a href="javascript: window.history.go(-1)">返回上一级</a>
</div>
<br>
<table align="center" cellspacing="0">
    <tr bgcolor="#5f9ea0" style="font-size: 20px;height:40px;text-align: center">
        <td style="width: 120px">用户编号</td>
        <td style="width: 120px">图书编号</td>
        <td style="width: 120px">图书名称</td>
        <td style="width: 120px">书籍链接</td>
        <td style="width: 120px">借阅时间</td>
        <td style="width: 120px">操作借阅记录</td>
    </tr>
    <%
        String bg = null;
        for (int i = 0; i < list.size(); i++) {
            Record r = list.get(i);
            if (i % 2 == 0) {
                bg = "Azure ";
            } else {
                bg = "PowderBlue ";
            }

    %>
    <tr bgcolor="<%=bg%>" style="height:40px;text-align: center">
        <td><%=r.getUserid()%>
            </a></td>
        <td><%=r.getBookid()%>
        </a></td>
        <td><%=r.getBookname()%>
        </td>
        <td><%=r.getBooklink()%>
        </td>
        <td><%=r.getBorrowtime()%>
        </td>
        <td><a href="admin-record-delete.jsp?borrowid=<%=r.getBorrowid()%>">删除</a>
        </td>

    </tr>
    <%
        }
    %>
    <a href="admin-home.jsp" style="text-align: center">返回主页</a>
</table>
</body>
</html>
