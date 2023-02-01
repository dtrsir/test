<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>

<div>
    <div>
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户添加页面</span>
    </div>
    <div>
        <form onsubmit="return check()" name="userForm" method="post"
              action="${pageContext.request.contextPath}/jsp/user.do">

            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="userCode">账号：</label>
                <input type="text" placeholder="请输入你的账号例如zhangshan" name="userCode" id="userCode"/>
                <!-- 放置提示信息 -->
            </div>
            <div>
                <label for="userName">用户名称：</label>
                <input type="text" placeholder="请输入你的用户名例如zhangsan" name="userName" id="userName"/>
            </div>
            <div>
                <label for="userPassword">用户密码：</label>
                <input type="password" placeholder="请输入你的密码例如123456" name="userPassword" id="userPassword"/>
            </div>
            <div>
                <label>用户性别：</label>
                <select name="gender" id="gender">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                </select>
            </div>
            <div>
                <label for="birthday">出生日期：</label>
                <input type="date" id="birthday" name="birthday"/>
            </div>
            <div>
                <label for="phone">用户电话：</label>
                <input type="text" name="phone" id="phone"/>
            </div>

            <div>
                <label>用户角色：</label>
                <!-- 列出所有的角色分类 -->
                <select name="userRole" id="userRole">
                    <c:if test="${roleList != null }">
                        <option value="0">--请选择--</option>
                        <c:forEach var="role" items="${roleList}">
                            <option value="${role.id}">${role.roleName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
            <br/>
            ${errorMessage}
            <br/>
            <div>
                <input type="submit" value="保存"/>
                <input type="button" onclick="back()" value="返回"/>
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script>
    var userCode = null;
    var userName = null;
    var userPassword = null;
    var phone = null;
    var birthday = null;
    var userRole = null;


    window.onload = function () {
        userCode = document.getElementById('userCode');
        userName = document.getElementById('userName');
        userPassword = document.getElementById('userPassword');
        phone = document.getElementById('phone');
        birthday = document.getElementById('birthday');
        userRole = document.getElementById('userRole');
    };

    function check() {
        if (userCode.value == null) {
            alert('账户名为空');
            return false;
        } else if (userName == null) {
            alert('用户名给为空');
            return false;
        } else if (userPassword == null) {
            alert('密码为空');
            return false;
        } else if (phone == null) {
            alert('手机号为空');
            return false;
        } else if (birthday == null) {
            alert('生日为空');
            return false;
        } else if (userRole == null) {
            alert('用户角色为空');
            return false;
        }
        return true;
    };

    function back() {
        history.back();
    };
</script>
