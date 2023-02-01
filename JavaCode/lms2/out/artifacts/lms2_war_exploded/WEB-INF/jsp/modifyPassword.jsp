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
                    <li class="active"><a href="#">用户密码修改</a></li>
                </ol>
            </span>
        </div>

        <%--用户增加表单--%>
        <form class="form-inline" action="${pageContext.request.contextPath}/user/modifyUser" method="post">

            <%--用户密码，ajax正则校验密码（省略）--%>
            <div id="passwordDiv" class="form-group" style="margin: 0 0 20px 50px">
                <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="password">密码 </label>
                <input type="text" class="form-control" id="password" name="password" aria-describedby="passwordStatus" value="${sessionScope.user.password}" onblur="checkPassword()">
                <div id="passwordCheckInfo"></div>
            </div>

            <br/>
            <%--确认密码，ajax校验密码一致性--%>
            <div id="passwordAgainDiv" class="form-group" style="margin: 0 0 20px 50px">
                <label style="color: black !important;width: 60px;text-align: right" class="control-label" for="passwordAgain">确认密码 </label>
                <input type="text" class="form-control" id="passwordAgain" aria-describedby="passwordAgainStatus" value="${sessionScope.user.password}" onblur="checkPasswordAgain()">
                <div id="passwordAgainCheckInfo"></div>
            </div>
            <span id="passwordAgainFailInfo"></span>
                <br/>



            <input type="hidden" id="id" name="id" value="${sessionScope.user.id}"/>
            <div class="form-group" style="margin-left: 120px">
                <input type="submit" class="btn btn-success" value="保存"/>
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
</script>
<%--系统首页结束--%>
<%@ include file="/WEB-INF/jsp/common/foot.jsp" %>