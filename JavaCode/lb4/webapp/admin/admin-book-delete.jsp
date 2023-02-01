<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.tsgl.dao.BookDao" %>
<%@ page import="com.tsgl.dao.impl.BookDaoImpl" %>
<%@ page import="com.tsgl.pojo.Book" %>
<%@ page import="com.tsgl.service.BookService" %>
<%@ page import="com.tsgl.service.impl.BookServiceImpl" %>
<html>
<head>
    <title>删除图书</title>
    <style type="text/css">
        #before {
            text-align: center;
        }

        body {
            background-color: antiquewhite;
        }


    </style>
</head>
<body>

<%-- 头部 --%>
<jsp:include page="../top.jsp"/>

<%
    // 设置获取注册时的编码为UTF-8
    request.setCharacterEncoding("UTF-8");

    //获取admin.jsp页面的bookid
    Integer bookid = Integer.parseInt(request.getParameter("bookid"));


    //引入数据交互层
    BookService bookService = new BookServiceImpl();
    Book book = new Book();
    book = bookService.getBook(bookid);
    System.out.println("删除的图书信息：");
    System.out.println(book);
    boolean flag = bookService.deleteBook(bookid);

    if (flag) {
        response.sendRedirect("admin-book-manager.jsp");
    } else {
        response.sendRedirect("../errorPage/error.jsp");
    }
%>
</body>
</html>
