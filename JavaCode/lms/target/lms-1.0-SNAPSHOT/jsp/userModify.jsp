<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>
<div>
    <strong>你现在所在的位置是:</strong>
    <span>用户管理页面 >> 用户修改页面</span>
</div>
<div>
    <form name="userModify" onsubmit="return check()" method="post"
          action="${pageContext.request.contextPath}/jsp/user.do">
        <%--携带方法参数--%>
        <input type="hidden" name="method" value="userModify"/>

            <p>修改对应的信息即可，不修改就不填</p>

            <div>
                <label for="userCode">账号：</label>
                <input type="text" value="${user.userCode}" name="userCode" id="userCode"/>
                <!-- 放置提示信息 -->
            </div>
            <div>
                <label for="userName">用户名称：</label>
                <input type="text" value="${user.userName}" name="userName" id="userName"/>
            </div>
            <div>
                <label for="userPassword">用户密码：</label>
                <input type="text" value="${user.password}" name="userPassword" id="userPassword"/>
            </div>
            <div>
                <label>用户性别：</label>
                <select name="gender" id="gender">
                    <option value="1" <C:if test="${user.gender == 1}">selected</C:if> >男</option>
                    <option value="2" <C:if test="${user.gender == 2}">selected</C:if> >女</option>
                </select>
            </div>
            <div>
                <label for="birthday">出生日期：</label>
                <input type="date" id="birthday" value="${birthday}" name="birthday"/>
            </div>
            <div>
                <label for="phone">用户电话：</label>
                <input type="text" name="phone" value="${user.phone}" id="phone"/>
            </div>

            <div>
                <label>用户角色：</label>
                <!-- 列出所有的角色分类 -->
                <select name="userRole" id="userRole">
                    <c:if test="${roleList != null }">
                        <c:forEach var="role" items="${roleList}">
                            <option value="${role.id}" <c:if test="${user.userRole == role.id}">selected</c:if> >${role.roleName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
        <br/>
        <p>${errorMessage}</p>
        <p>${successMessage}</p>
        <br/>
            <c:if test="${successCode != 1}"><input type="submit" value="保存"/></c:if>

            <input type="button" onclick="back()" value="返回"/>

    </form>
</div>
<script>

    function back() {
        window.location.href = '${pageContext.request.contextPath}/jsp/user.do?method=query';
    };

</script>

</section>
<%@include file="/jsp/common/foot.jsp" %>