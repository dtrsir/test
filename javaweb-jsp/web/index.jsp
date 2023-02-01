<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%@include file="common/header.jsp" %>
$END$
<%
    pageContext.setAttribute("name1", "1");
    request.setAttribute("name2", "2");
    session.setAttribute("name3", "3");
    application.setAttribute("name4", "4");
%>

<%
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5");
%>

<h1>输出的值是：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${"欢迎您"}</h3>


<%@include file="common/footer.jsp" %>
<jsp:include page="common/header.jsp"></jsp:include>
</body>
</html>
