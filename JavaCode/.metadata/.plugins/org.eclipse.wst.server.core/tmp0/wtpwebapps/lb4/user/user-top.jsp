<%@ page import="com.tsgl.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #head {
           background: url("images/bg2.jpg");
            height: 80px;
        }
        #logout {
            position: absolute;
            font-size: 20px;
            top:40px;
            right: 20px;
        }

        #welcome {
            position: absolute;
            font-size: 20px;
            left: 900px;
            top:40px;
        }
        #sysname{
            position: absolute;
            text-decoration:none;
            font-size: 60px;
            align:left;
            left: 84px;
        }
        a{
         font-family: Arial;
         font-size: 14px;
         text-align: center;
         margin: 3px;
         }
         a:link,a:visited {
  		 color:  #000000;
  		 padding: 4px 10px 4px 10px;
  		 background-color: #ddd;
  		 text-decoration: none;
  		 border-top: 1px solid #eee;
  		 border-left: 1px solid #eee;
  		 border-bottom: 1px solid #717171;
  		 border-right: 1px solid #717171; 
  		 }
   		a:hover{
   		 color:  #FFFFFF;
   		 padding: 5px 8px 3px 12px;
   		 background-color:  #BDB76B;
   		 border-top: #717171;
   		 border-left: #717171;
   		 border-bottom: #eee;
   		 border-right: #eee;
    	 }
    </style>
</head>
<body>

<%--头部信息--%>
<%
	//改用fillter实现会更好
    User user = (User)session.getAttribute("user");
    if(user == null){
        response.sendRedirect("../login.jsp");
    }else {
%>
<div id="head">
    <table width="100%">
        <td><a href="/lb4/user/user-home.jsp" id="sysname"><img  src="./images/bg15.jpg" border="0"/></a></td>
        <td id="welcome">欢迎您：<%=user.getUsername()%></td>
        <td id="logout">
            <a href="/lb4/user/user-record.jsp">借阅记录</a>
            <a href="/lb4/user/user-bookshelf.jsp">我的书架</a>
            <a href="/lb4/logout.jsp">安全退出</a>
        </td>
    </table>
</div>
<%
    }
%>

</body>
</html>
