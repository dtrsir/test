<%--
  Created by IntelliJ IDEA.
  User: zhongzheng
  Date: 2022/9/12
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" name="upload">
  </form>
  </body>
</html>
