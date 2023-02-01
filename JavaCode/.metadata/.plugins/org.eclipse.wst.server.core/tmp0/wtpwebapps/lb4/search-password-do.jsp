<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.tsgl.service.impl.UserServiceImpl"%>
<%@page import="com.tsgl.pojo.User"%>

    <%
        // 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + path + "/";
    %>
<!DOCTYPE html>
<html>
<head>

    <base href="<%=basePath %>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>处理找回密码</title>
</head>
<body>
    <%
        //获取searchPassword.jsp页面提交的账号和密码
        String name = request.getParameter("name");


        UserServiceImpl service = new UserServiceImpl();
        List<User> list = service.selectUser(name);
        request.setAttribute("list", list);
        for(User u : list){
            request.setAttribute("user", u);
            out.print(u);
            
        }
        if(name != null){
            request.getRequestDispatcher("search-password-info.jsp").forward(request, response);
        }
    %>
</body>
</html>
