<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
<%--系统首页--%>
<div class="col-md-11" style="height: 750px;background-color: ghostwhite">

    <div class="container-fluid">

        <%--面包导航条--%>
        <div>
            <strong style="display: inline-block">你现在所在的位置是:</strong>
            <span>
                <ol class="breadcrumb">
                    <li><a href="#">用户管理</a></li>
                    <li class="active"><a href="#">添加用户</a></li>
                </ol>
            </span>
        </div>

            <%--用户增加表单--%>
            <form class="form-inline" action="${pageContext.request.contextPath}/user/addUser" method="post">
                <%--用户账号--%>
                <div id="userCodeDiv" class="form-group" style="margin: 0 0 20px 50px">
                    <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="userCode">账号 </label>
                    <input type="text" class="form-control" id="userCode" name="userCode" aria-describedby="userCodeStatus" placeholder="请输入账号" onblur="checkUserCode()">
                    <%--ajax校验账号唯一性--%>
                    <div id="checkInfo"></div>
                </div>
                    <span id="failInfo"></span>

                <br/>
                    <%--用户密码，ajax正则校验密码（省略）--%>
                <div id="passwordDiv" class="form-group" style="margin: 0 0 20px 50px">
                    <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="password">密码 </label>
                    <input type="password" class="form-control" id="password" name="password" aria-describedby="passwordStatus" placeholder="请输入密码" onblur="checkPassword()">
                    <div id="passwordCheckInfo"></div>
                </div>

                <br/>
                    <%--确认密码，ajax校验密码一致性--%>
                <div id="passwordAgainDiv" class="form-group" style="margin: 0 0 20px 50px">
                    <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="passwordAgain">确认密码 </label>
                    <input type="password" class="form-control" id="passwordAgain" aria-describedby="passwordAgainStatus" placeholder="请确认密码" onblur="checkPasswordAgain()">
                    <div id="passwordAgainCheckInfo"></div>
                </div>
                    <span id="passwordAgainFailInfo"></span>

                <br/>
                    <%--用户名--%>
                <div class="form-group" style="margin: 0 0 20px 50px">
                    <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="userName">用户名 </label>
                    <input type="text" class="form-control" id="userName" name="userName" aria-describedby="userNameStatus" placeholder="请输入用户名">
                </div>
                <br/>
                    <%--用户性别选择--%>
                <div class="form-group" style="margin: 0 0 20px 50px">
                    <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="gender">性别 </label>
                    <select name="gender" id="gender" class="form-control">
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </div>
                <br/>
                    <%--用户生日--%>
                <div class="form-group" style="margin: 0 0 20px 50px">
                    <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="birthday">生日 </label>
                    <input type="date" class="form-control" id="birthday" name="birthday2" aria-describedby="birthdayStatus" onblur="countAge()">
                </div>
                <br/>
                    <%--用户年龄根据生日自动生成--%>
                <div class="form-group" style="margin: 0 0 20px 50px">
                    <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="age">年龄 </label>
                    <input readonly type="text" class="form-control" id="age" name="age" aria-describedby="ageStatus" value="">
                </div>
                <br/>
                    <%--用户联系电话--%>
                <div class="form-group" style="margin: 0 0 20px 50px">
                    <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="phone">电话 </label>
                    <input type="text" class="form-control" id="phone" name="phone" aria-describedby="phoneStatus" placeholder="请输入电话">
                </div>
                <br/>
                    <%--用户角色选择，请求中存在roleList--%>
                <div class="form-group" style="margin: 0 0 20px 50px">
                    <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="userName">用户角色 </label>
                    <select name="userRole" id="userRole" class="form-control" >
                        <c:forEach items="${roleList}" var="role">
                            <option value="${role.id}" <c:if test="${role.id == 3}">selected</c:if> >${role.roleName}</option>
                        </c:forEach>
                    </select>

                </div>
                <br/>

                    <input type="hidden" id="createBy" name="createBy" value="${user.id}"/>
                <div class="form-group" style="margin-left: 120px">
                    <input type="submit" class="btn btn-success" value="添加"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" class="btn btn-warning" value="重置"/>
                </div>

            </form>

    </div>




</div>
</div>
</section>
<script>
/*    function add() {
        var addMsg = document.getElementById('addMsg');
        if (addMsg.value == 'success') {
            alert('增加用户成功')
        }
        if (addMsg.value == 'fail') {
            alert('增加用户失败，请重试')
        }
    };
    window.onload=add();*/

    function checkUserCode() {
        $.post({
            url:"${pageContext.request.contextPath}/ajaxUserCode",
            data:{
                "userCode":$("#userCode").val()
            },
            success:function (data) {
                if (data.toString() === 'ok') {
                    $("#failInfo").empty();
                    $("#userCodeDiv").removeClass("has-error");
                    $("#userCodeDiv").addClass("has-success");
                    $("#userCodeDiv").addClass("has-feedback");
                    $("#checkInfo").html("<span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span>\n" +
                        "<span id=\"userCodeStatus\" class=\"sr-only\">(success)</span>");
                }else if (data.toString() === 'fail') {
                    $("#failInfo").empty();
                    $("#userCodeDiv").removeClass("has-success");
                    $("#userCodeDiv").addClass("has-error");
                    $("#userCodeDiv").addClass("has-feedback");
                    $("#checkInfo").html("<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>\n" +
                        "<span id=\"userCodeStatus\" class=\"sr-only\">(error)</span>");
                    if ($("#userCode").val() !== "") {
                        $("#failInfo").css("color", "red");
                        $("#failInfo").html("账号已被注册");
                    }
                }
            }
        });
    };
    function checkPassword() {
        var password = $("#password").val();
        if (password !== "") {
            $("#passwordDiv").removeClass("has-error");
            $("#passwordDiv").addClass("has-success");
            $("#passwordDiv").addClass("has-feedback");
            $("#passwordCheckInfo").html("<span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span>\n" +
                "<span id=\"passwordStatus\" class=\"sr-only\">(success)</span>");
        }else {
            $("#passwordDiv").removeClass("has-success");
            $("#passwordDiv").addClass("has-error");
            $("#passwordDiv").addClass("has-feedback");
            $("#passwordCheckInfo").html("<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>\n" +
                "<span id=\"passwordStatus\" class=\"sr-only\">(error)</span>");
        }
    };
    function checkPasswordAgain() {
        var passwordAgain = $("#passwordAgain").val();
        var password = $("#password").val();
        if (passwordAgain === password && password !== "") {
            $("#passwordAgainFailInfo").empty();
            $("#passwordAgainDiv").removeClass("has-error");
            $("#passwordAgainDiv").addClass("has-success");
            $("#passwordAgainDiv").addClass("has-feedback");
            $("#passwordAgainCheckInfo").html("<span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span>\n" +
                "<span id=\"passwordAgainStatus\" class=\"sr-only\">(success)</span>");
        }else {
            $("#passwordAgainDiv").removeClass("has-success");
            $("#passwordAgainDiv").addClass("has-error");
            $("#passwordAgainDiv").addClass("has-feedback");
            $("#passwordAgainCheckInfo").html("<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>\n" +
                "<span id=\"passwordAgainStatus\" class=\"sr-only\">(error)</span>");
            $("#passwordAgainFailInfo").css("color", "red");
            $("#passwordAgainFailInfo").html("两次密码不一致");
        }
    };
    function countAge() {
        $.post({
            url: "${pageContext.request.contextPath}/countAge",
            data: {
                "birthday":$("#birthday").val()
            },
            success(data) {
                $("#age").attr("value", data);
            }
        })
    }
</script>
<%--系统首页结束--%>
<%@ include file="/WEB-INF/jsp/common/foot.jsp" %>