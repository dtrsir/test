<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="userName" id="">
    密码：<input type="password" name="password" id="">
    <input type="submit" value="登陆">
</form>

</body>
</html>
