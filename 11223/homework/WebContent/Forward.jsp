<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转请求</title>
</head>
<body>
<script>
    Windows.alert('这是一个跳转例子');
    Window.alert('这是一个跳转例子');
</script>
<jsp:forward page="CaseOne.jsp"></jsp:forward>

</body>
</html>