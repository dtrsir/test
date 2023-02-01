<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>
<div>
    <div>
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面</span>
    </div>
    <div>
        <%--条件搜索框，首次进入参数为空--%>
        <form method="get" action="${pageContext.request.contextPath}/jsp/user.do">

            <input name="method" value="query" type="hidden">

            <span>用户名：</span>
            <%--设置value值，进入servlet时候跳转回来搜索框内的值不会被清除--%>
            <input name="queryUserName" type="text" value="${queryUserName}">

            <%--查询角色列表，需要在query方法中调用一次roleService的query方法--%>
            <span>用户角色：</span>
            <select name="queryUserRole">

                <c:if test="${roleList != null }">

                    <option value="0">--请选择--</option>

                    <c:forEach var="role" items="${roleList}">
                        <option
                                <c:if test="${role.id == queryUserRole }">selected="selected"</c:if>
                                value="${role.id}">${role.roleName}</option>
                    </c:forEach>
                </c:if>

            </select>

            <input type="hidden" name="pageIndex" value="1"/>
            <input value="查 询" type="submit"/>
            <a href="${pageContext.request.contextPath}/jsp/useradd.jsp">添加用户</a>
        </form>
    </div>
    <!--用户-->
    <table cellpadding="0" cellspacing="0">
        <tr>
            <th>账号</th>
            <th>用户名称</th>
            <th>性别</th>
            <th>年龄</th>
            <th>电话</th>
            <th>用户角色</th>
            <th>操作</th>
        </tr>
        <c:forEach var="user" items="${userList }" varStatus="status">
            <tr>
                <td>
                    <span>${user.userCode}</span>
                </td>
                <td>
                    <span>${user.userName}</span>
                </td>
                <td>
							<span>
								<c:if test="${user.gender==1}">男</c:if>
								<c:if test="${user.gender==2}">女</c:if>
							</span>
                </td>
                <td>
                    <span>${user.age}</span>
                </td>
                <td>
                    <span>${user.phone}</span>
                </td>
                <td>
                    <span>${user.roleName}</span>
                </td>

                    <%--对用户的操作--%>
                <td>
                    <span><a class="viewUser" href="${pageContext.request.contextPath}/jsp/user.do?method=viewUser&userId=${user.id}" userId=${user.id} userCode=${user.userCode}>
                        <img width="20px" height="20px" src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/>
                    </a></span>
                    <span><a class="modifyUser" href="${pageContext.request.contextPath}/jsp/user.do?method=viewUserByModify&userId=${user.id}" userId=${user.id} userCode=${user.userCode}>
                        <img width="20px" height="20px" src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/>
                    </a></span>
                    <span ><a class="deleteUser"  onclick="showzhezhao()" href="#" userId=${user.id} userName=${user.userName}>
                        <img width="20px" height="20px" src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/>
                    </a>${errorDelete}</span>

                    <!--点击删除按钮后弹出的页面-->
                    <div id="cover"></div>
                    <div id="modal">
                        <div>
                            <h2>提示</h2>
                            <div>
                                <p>你确定要删除该用户吗？</p>
                                <a href="${pageContext.request.contextPath}/jsp/user.do?method=delete&userId=${user.id}" onclick="closezhezhao()" id="yes">确定</a>
                                <a href="#" onclick="closezhezhao()" id="no">取消</a>
                            </div>
                        </div>
                    </div>


                </td>
            </tr>
        </c:forEach>
    </table>
    <%--分页支持--%>
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <c:import url="rollpage.jsp">
        <c:param name="totalCount" value="${totalCount}"/>
        <c:param name="currentPageNo" value="${currentPageNo}"/>
        <c:param name="totalPageCount" value="${totalPageCount}"/>
    </c:import>
</div>
</section>





<%@include file="/jsp/common/foot.jsp" %>
