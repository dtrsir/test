<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计访问次数</title>
</head>
<body>
<% 
	if(session.getAttribute("ID")==null){
		session.setAttribute("ID", 1);
	}else if(session.getAttribute("ID")!=null) {
		int i = (int)session.getAttribute("ID");
		session.removeAttribute("ID");
		session.setAttribute("ID", ++i);
	}
%>

<p>访问次数:<%=session.getAttribute("ID") %></p>


</body>
</html>