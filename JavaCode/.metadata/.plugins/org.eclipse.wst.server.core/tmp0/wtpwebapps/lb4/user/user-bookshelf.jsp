<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.tsgl.pojo.Book" %>
<%@ page import="com.tsgl.service.impl.BookServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tsgl.service.BookShelfService" %>
<%@ page import="com.tsgl.service.impl.BookShelfServiceImpl" %>
<%@ page import="com.tsgl.pojo.BookShelf" %>
<%@ page import="com.tsgl.pojo.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查看图书</title>
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
<jsp:include page="user-top.jsp"/>

<%--图书信息--%>
<%

    // 获取userid
    User user =(User)session.getAttribute("user");
    Integer userid = user.getUserid();

    // 获取该用户的书单
    BookShelfService bookShelfService = new BookShelfServiceImpl();
    List<BookShelf> list = bookShelfService.selectBookShelf(userid);
%>
<h1>我的书架</h1>
<hr>


<!-- 搜索框 -->
<div id="before">
    <form action="user-home.jsp" method="post">
        请输入书名：<input type="text" name="bookname" placeholder="输入图书名称搜索">
        <input type="submit" value="查询"/>
    </form>
    <h3>记得看完准时归还噢!</h3>
</div>
<br>

<!-- 展示表 -->
<table align="center" cellspacing="0">
    <tr bgcolor="#5f9ea0" style="font-size: 20px;height:40px;text-align: center">
        <td style="width: 120px">图书编号</td>
        <td style="width: 120px">图书名称</td>
        <td style="width: 120px">加入时间</td>
        <td style="width: 120px">操作书架</td>
    </tr>
    <%
        String bg = null;
        for (int i = 0; i < list.size(); i++) {
            BookShelf b = list.get(i);
            if (i % 2 == 0) {
                bg = "Azure ";
            } else {
                bg = "PowderBlue ";
            }

    %>
    <tr bgcolor="<%=bg%>" style="height:40px;text-align: center">

        <td><%=b.getBookid()%>
        </a></td>
        <td><%=b.getBookname()%>
        </td>
        <td><%=b.getAdddate()%>
        </td>

        <td><a href="user-bookshelf-remove.jsp?bookid=<%=b.getBookid() %>">移出书架</a>
        </td>
    </tr>
    <%
        }
    %>
     <a href="user-home.jsp">返回主页</a>
</table>
</body>
</html>
