<%--
  Created by IntelliJ IDEA.
  User: zhongzheng
  Date: 2022/4/15
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="userName" id=""><br>
        密码：<input type="password" name="password" id=""><br>
        爱好：
        <input type="checkbox" name="hobbys" id="" value="乒乓球"> 乒乓球
        <input type="checkbox" name="hobbys" id="" value="羽毛球"> 羽毛球
        <input type="checkbox" name="hobbys" id="" value="篮球"> 篮球
        <input type="checkbox" name="hobbys" id="" value="足球"> 足球
        <br>
        性别：
        <input type="radio" name="sex" id="" value="男" checked> 男
        <input type="radio" name="sex" id="" value="女"> 女
        <input type="submit" value="提交">
    </form>
</div>


</body>
</html>
