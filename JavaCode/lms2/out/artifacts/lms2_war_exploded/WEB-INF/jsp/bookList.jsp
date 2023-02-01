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
                    <li class="active"><a href="#">用户列表</a></li>
                </ol>
            </span>
        </div>

        <%--页内搜索框--%>
        <div class="row clearfix" >
            <div style="margin-top: -40px" class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>用户列表——显示所有用户</small>
                    </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 column ">
                    <a href="${pageContext.request.contextPath}/user/toAddUser"><button style="margin-left: 15px" type="button" class="btn btn-primary">添加用户</button></a>
                    <a href="${pageContext.request.contextPath}/user/userList"><button type="button" class="btn btn-primary">显示所有用户</button></a>
                </div>

                <%--搜索框--%>
                <div class="col-md-9 column">
                    <div class="col-md-12 column" id="queryForm" style="padding-left: 95px">
                        <form onsubmit="return checkAge();" class="form-inline" action="${pageContext.request.contextPath}/user/userList" method="post">
                            <span style="color: red" id="msg"></span>
                            <div class="form-group">
                                <label>用户名</label>&nbsp;
                                <input type="text" value="${queryUserName}" name="queryUserName" class="form-control" placeholder="请输入要查询的用户名称"/>
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <label>性别 </label>&nbsp;
                                <select class="form-control" name="queryGender">
                                    <option disabled selected>--请选择--</option>
                                    <option <c:if test="${queryGender == 1}">selected</c:if> value="1">男</option>
                                    <option <c:if test="${queryGender == 2}">selected</c:if> value="2">女</option>
                                </select>
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <label>角色名 </label>&nbsp;
                                <select class="form-control" name="queryUserRole">
                                    <option disabled selected>--请选择--</option>
                                    <c:forEach var="role" items="${roleList}">
                                        <option <c:if test="${role.id == queryUserRole}">selected</c:if> value="${role.id}">${role.roleName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <label>查询年龄范围 </label>&nbsp;
                                <input value="${starAge}" type="text" id="starAge" name="starAge" class="form-control" />
                                &nbsp; - &nbsp;
                                <input value="${endAge}" type="text" id="endAge" name="endAge" class="form-control" />
                            </div>

                            <input type="hidden" name="pageIndex" value="1"/>
                            <input type="hidden" name="flag" value="query"/>
                            &nbsp;
                            <input class="btn btn-primary" type="submit" value="查询" />
                        </form>
                    </div>
                </div>

            </div>
        </div>
        <br/>

        <%--展示主体--%>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr >
                        <th>用户id</th>
                        <th>账号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>电话</th>
                        <th>角色名</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <%--表格体--%>
                    <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.userCode}</td>
                            <td>${user.userName}</td>
                            <td>
                                <c:if test="${user.gender == 1}">男</c:if>
                                <c:if test="${user.gender == 2}">女</c:if>
                            </td>
                            <td>${user.age}</td>
                            <td>${user.phone}</td>
                            <td>${user.roleName}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/user/toModifyUser/${user.id}"><button type="button" class="btn btn-info btn-sm">修改</button></a>
                                &nbsp; | &nbsp;
                                <a href="${pageContext.request.contextPath}/user/delete/${user.id}"><button type="button" class="btn btn-danger btn-sm">删除</button></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>

        </div>


        <input type="hidden" id="addMsg" value="${addMsg}"/>


        <%--分页--%>

        <%--分页支持--%>
        <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
        <c:import url="rollpage.jsp">
            <c:param name="totalCount" value="${totalCount}"/>
            <c:param name="currentPageNo" value="${currentPageNo}"/>
            <c:param name="totalPageCount" value="${totalPageCount}"/>
        </c:import>

    </div>


</div>
</div>
</section>
<script>
    var starAge = document.getElementById("starAge");
    var endAge = document.getElementById("endAge");
    function checkAge() {
        if (starAge.value != '' || endAge.value != '') {
            if (starAge.value == '' || endAge.value == '') {
                var msg = document.getElementById("msg");
                msg.innerHTML = '年龄范围缺省';
                var queryForm = document.getElementById("queryForm");
                queryForm.style.paddingLeft = '7px';
                return false;
            }
        }
        return true;
    };

    function add() {
        var addMsg = document.getElementById('addMsg');
        if (addMsg.value == 'success') {
            alert('增加用户成功')
        }
        if (addMsg.value == 'fail') {
            alert('增加用户失败，请重试')
        }
    };
    window.onload=add();
</script>
<%--系统首页结束--%>
<%@ include file="/WEB-INF/jsp/common/foot.jsp" %>