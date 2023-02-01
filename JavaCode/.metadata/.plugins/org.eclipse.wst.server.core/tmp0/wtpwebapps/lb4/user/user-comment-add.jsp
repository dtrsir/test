<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.tsgl.pojo.User" %>
<%@ page import="com.tsgl.service.BookShelfService" %>
<%@ page import="com.tsgl.service.impl.BookShelfServiceImpl" %>
<%@ page import="com.tsgl.pojo.BookShelf" %>
<%@ page import="com.tsgl.pojo.Book" %>
<%@ page import="com.tsgl.service.BookService" %>
<%@ page import="com.tsgl.service.impl.BookServiceImpl" %>
<%@ page import="com.tsgl.service.CommentService" %>
<%@ page import="com.tsgl.service.impl.CommentServiceImpl" %>
<%@ page import="com.tsgl.pojo.Comment" %>
<html>
<head>
    <title>加入书架</title>
    <style type="text/css">

       body{
            background: url("../images/bg5.jpg");
            text-align: center;
            
            }

    </style>
</head>
<body>

<%-- 头部 --%>
<jsp:include page="../top.jsp"/>

<%
    // 设置获取注册时的编码为UTF-8
    request.setCharacterEncoding("UTF-8");

    // 获取user信息
    User user =(User)session.getAttribute("user");
    Integer userid = user.getUserid();
    String username = user.getUsername();

    //获取book信息
    Integer bookid = Integer.parseInt(request.getParameter("bookid"));
    BookService bookService = new BookServiceImpl();
    Book book = bookService.getBook(bookid);
    String bookname = book.getBookname();


    String content = request.getParameter("content");

    Comment comment = new Comment();
    comment.setUserid(userid);
    comment.setUsername(username);
    comment.setBookid(bookid);
    comment.setBookname(bookname);
    comment.setComment(content);

    session.setAttribute("bookid",bookid);


    //引入数据交互层
    CommentService commentService = new CommentServiceImpl();

    boolean flag = commentService.addComment(comment);

    if (flag) {
        response.sendRedirect("user-book-info.jsp");
    } else {
        response.sendRedirect("../errorPage/error.jsp");
    }
%>
</body>
</html>
