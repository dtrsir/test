<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新增图书</title>
    <style type="text/css">
        h1 {
            text-align: center;
        }

        h4 {
            text-align: center;
            color: red;
        }

        body{
            background: url("images/bg5.jpg");
            text-align: center;
            }
            
        div {
            text-align: center;
        }

        #before {
            text-align: center;
        }

    </style>
</head>
<body>
<%-- 头部 --%>
<jsp:include page="../top.jsp"/>

<h1>新增图书</h1>
<hr>

<div id="before">
   <a href="admin-home.jsp">返回主页</a>
</div>
</br>

<form action="admin-book-do-add.jsp" method="post" name="registerForm">
    <div>
        <tr>
            <label>图书名称：</label>
            <input type="text" name="bookname" id="bookname" placeholder="图书名称" autofocus="autofocus">
        </tr>
    </div>
    <div>
        <tr>
            <label>图书价格：</label></td>
            <input type="text" name="price" id="price" placeholder="图书价格(数字)">
        </tr>
    </div>
    <div>
        <tr>
            <label>图书作者：</label>
            <input type="text" name="author" id="author" placeholder="图书作者">
        </tr>
    </div>
    <div>
        <tr>
            <label>出版公司：</label>
            <input type="text" name="publish" id="publish" placeholder="出版公司">
        </tr>
    </div>
    <div>
        <tr>
            <label>类型编号：</label>
            <input type="text" name="categoryid" id="categoryid" placeholder="类型编号">
        </tr>
    </div>
    <div>
        <tr>
            <label>书籍链接：</label>
            <input type="text" name="booklink" id="booklink" placeholder="书籍链接">
        </tr>
    </div>

    <div id="submitbtn">
        <tr>
            <button type="submit" onclick="return checkForm()">添加</button>
            <button type="reset">重置</button>

        </tr>
    </div>
</form>

<script type="text/javascript">
    function checkForm() {
    	var bookname = registerForm.bookname.value;
        var price = registerForm.price.value;
        var author = registerForm.author.value;
        var publish = registerForm.publish.value;
        var categoryid = registerForm.categoryid.value;
        var booklink = registerForm.booklink.value;
        if (bookname == "" || bookname == null) {
            alert("请输入图书名称");
            registerForm.bookname.focus();
            return false;
        } else if (price == "" || price == null) {
            alert("请输入图书价格");
            registerForm.price.focus();
            return false;
        }else if (author == "" || author == null) {
            alert("请输入图书作者");
            registerForm.author.focus();
            return false;
        }else if (publish == "" || publish == null) {
            alert("请输入出版公司");
            registerForm.publish.focus();
            return false;
        }else if (categoryid == "" || categoryid == null) {
            alert("请输入类型编号");
            registerForm.categoryid.focus();
            return false;
        }else if (booklink == "" || booklink == null) {
            alert("请输入书籍链接");
            registerForm.booklink.focus();
            return false;
        }
        alert('添加成功！');
        return true;
    }
</script>
</body>
</html>