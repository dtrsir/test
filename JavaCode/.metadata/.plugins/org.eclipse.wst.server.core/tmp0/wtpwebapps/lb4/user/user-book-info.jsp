<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.tsgl.pojo.Book" %>
<%@ page import="com.tsgl.pojo.Comment" %>
<%@ page import="com.tsgl.service.BookService" %>
<%@ page import="com.tsgl.service.CommentService" %>
<%@ page import="com.tsgl.service.impl.BookServiceImpl" %>
<%@ page import="com.tsgl.service.impl.CommentServiceImpl" %>
<%@ page import="java.util.List" %>

<%
    // 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath %>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书详情</title>
    <style type="text/css">
        h1{
            text-align: center;
        }
        a{
            text-align:center;text-decoration: none;
        }
        a:hover{
            text-decoration: underline;font-size: 20px;
        }
        #before{
            text-align: center;
        }
        #content{
            text-align: center;
        }
        #content-title{
            text-align: center;
        }
          body{
            background: url("images/bg5.jpg");
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


    <h1>图书详情</h1>
    <hr>
    <div id="before">
        <a href="user/user-home.jsp">返回主页</a>
    </div>
    <%
        // 获取bookid,添加评论之后跳转没有带参数
        Integer bookid = 0;
        if(request.getParameter("bookid")==null){
            bookid = (Integer) session.getAttribute("bookid");
        }else {
            bookid = Integer.parseInt(request.getParameter("bookid"));
        }


        BookService bookService = new BookServiceImpl();
        Book book = bookService.getBook(bookid);

        // 获取留言
        CommentService commentService = new CommentServiceImpl();
        List<Comment> list = commentService.selectComment(bookid);

    %>
    <table align="center" cellpadding="20" cellspacing="20">
        <tr style="font-size: 20px">
            <td>图书编号</td>
            <td>图书名称</td>
            <td>图书价格</td>
            <td>图书作者</td>
            <td>图书出版社</td>
        </tr>
        <tr>
            <td><%=book.getBookid()%></td>
            <td><%=book.getBookname()%></td>
            <td><%=book.getPrice()%></td>
            <td><%=book.getAuthor()%></td>
            <td><%=book.getPublish()%></td>
        </tr>
        <tr>
            <td colspan="3"></td>
            <td></td>
            <td colspan="2"></td>
        </tr>
    </table>
    <div style="text-align:center;">
        <a  href="user/user-bookshelf-add.jsp?bookid=<%=book.getBookid()%>">加入书架</a>
        <a  href="user/user-home.jsp">图书列表</a>
    </div>
    <br>


    <%
        for(int i = 0;i<list.size();i++){
            Comment comment = list.get(i);
    %>

    <fieldset style="width:650px;margin: 0 auto;">
        <legend>留言<%=comment.getCommentid()%></legend>
        <div style="left: 900px">
            用户：<%=comment.getUsername()%>    留言内容:<%=comment.getComment()%>    留言时间：<%=comment.getTime()%>
        </div>
    </fieldset>

    <%
        }
    %>

    <h4 id="content-title">留言板</h4>
    <form action="user/user-comment-add.jsp?bookid=<%=book.getBookid()%>" method="post"  id="content">

        <textarea rows="10" cols="80" name="content" ></textarea>
        <br>
        <br>
        <button type="submit">添加</button>
    </form>
</body>
</html>
