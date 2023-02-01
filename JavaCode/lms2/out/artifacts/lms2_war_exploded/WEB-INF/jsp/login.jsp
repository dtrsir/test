<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理系统</title>
    <link rel="stylesheet" type="text/css" href="../../static/bootstrap/css/bootstrap.css">
    <style>
        body {
            background-color: #FFDEE9;
            background-image: linear-gradient(315deg, #FFDEE9 26%, #B5FFFC 82%);
        }

        button {
            /*background-color: #FFDEE9 !important;
            background-image: linear-gradient(225deg, #FFDEE9 3%, #B5FFFC 38%) !important;*/
        }
    </style>
</head>
<body>

<h2 style="margin-left: 830px;margin-top: 200px">图书管理系统</h2>
<div style="width: 400px; height: 230px;border: solid 1px black;margin-left: 730px;margin-top: 15px;padding: 30px" >
    <form action="${pageContext.request.contextPath}/user/login" method="post" class="form-horizontal">

        <div class="form-group">
            <label for="userCode" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input type="text" name="userCode" class="form-control" id="userCode" placeholder="账号" required>
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" id="password" placeholder="密码" required>
                <br/>
                <span style="color: red">${loginFailMsg}</span>
                <br/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit"  class="btn btn-default" value="登陆"></input>
                &nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" class="btn btn-default" value="重置"></input>

            </div>
        </div>
    </form>
</div>



</body>
</html>
