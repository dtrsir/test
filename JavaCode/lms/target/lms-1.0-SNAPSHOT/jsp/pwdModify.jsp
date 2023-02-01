<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>
<div>
    <strong>你现在所在的位置是:</strong>
    <span>密码修改页面</span>
</div>
<div>
    <form name="pwdModify" onsubmit="return check()" method="post"
          action="${pageContext.request.contextPath}/jsp/user.do">
        <%--携带方法参数--%>
        <input type="hidden" name="method" value="pwdModify"/>

        <label for="newPassword">新密码：</label>
        <input type="password" name="newPassword" id="newPassword" placeholder="请输入新密码" required/>
        <br/>
        <p>${errorMessage}</p>
        <p>${successMessage}</p>
        <br/>
        <input type="submit" value="保存"/>
        <c:if test="${successCode == 1}">
            <input type="button" onclick="back()" value="退出"/>
        </c:if>

    </form>
</div>
<script>
    function check() {
        let newPassword = document.getElementById('newPassword');
        if (newPassword == null) {
            alert('新密码为空');
            return false;
        } else {
            return true;
        }
    };

    function back() {
        window.location.href = '${pageContext.request.contextPath}/login.jsp';
    };

</script>

</section>
<%@include file="/jsp/common/foot.jsp" %>