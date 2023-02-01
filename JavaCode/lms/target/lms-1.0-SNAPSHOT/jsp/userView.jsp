<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>
<div>
    <strong>你现在所在的位置是:</strong>
    <span>用户管理页面 >> 用户查看页面</span>
</div>
<div>
    <table name="userView">

        <div>
            <label for="userCode">账号：</label>
            <input type="text" value="${user.userCode}" readonly name="userCode" id="userCode"/>
        </div>

        <div>
            <label for="userName">用户名称：</label>
            <input type="text" value="${user.userName}" readonly name="userName" id="userName"/>
        </div>
        <div>
            <label for="userPassword">用户密码：</label>
            <input type="text" value="${user.password}" readonly name="userPassword" id="userPassword"/>
        </div>
        <div>
            <label>用户性别：</label>
            <select name="gender" id="gender">
                <c:if test="${user.gender == 1}">
                    <option value="1" selected="selected">男</option>
                </c:if>
                <c:if test="${user.gender == 2}">
                    <option value="2" selected="selected">女</option>
                </c:if>
            </select>
        </div>
        <div>
            <label for="birthday">出生日期：</label>
            <input type="text" value="${birthday}" readonly id="birthday" name="birthday"/>
        </div>
        <div>
            <label for="phone">用户电话：</label>
            <input type="text" value="${user.phone}" readonly name="phone" id="phone"/>
        </div>

        <div>
            <label>用户角色：</label>
            <select name="userRole" id="userRole">
                    <option selected>${user.roleName}</option>
            </select>
        </div>
        <div>
            <label for="age">年龄:</label>
            <input type="text" readonly value="${user.age}" name="age" id="age">
        </div>

        <input type="button" onclick="back()" value="返回"/>

    </table>
</div>
<script>

    function back() {
        window.location.href = '${pageContext.request.contextPath}/jsp/user.do?method=query';
    };

</script>

</section>
<%@include file="/jsp/common/foot.jsp" %>