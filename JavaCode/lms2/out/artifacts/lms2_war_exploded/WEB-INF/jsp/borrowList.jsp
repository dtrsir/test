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
                    <li><a href="#">借阅记录</a></li>
                    <li class="active"><a href="#">记录列表</a></li>
                </ol>
            </span>
        </div>

        <%--页内搜索框--%>
        <div class="row clearfix" >
            <div style="margin-top: -40px" class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>记录列表——显示所有记录</small>
                    </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 column ">
                    <a href="${pageContext.request.contextPath}/borrow/borrowList"><button style="margin-left: 15px" type="button" class="btn btn-primary">显示所有借阅记录</button></a>
                    <%--<a href="#"><button type="button" class="btn btn-primary"></button></a>--%>
                </div>

                <%--搜索框--%>
                <div class="col-md-9 column">
                    <div class="col-md-12 column" id="queryForm" style="padding-left: 95px">
                        <form onsubmit="return checkAge();" class="form-inline" action="${pageContext.request.contextPath}/borrow/borrowList" method="post">
                            <%--查询失败消息--%>
                            <span style="color: red" id="msg"></span>
                            <div class="form-group">
                                <label>书籍名称</label>&nbsp;
                                <input type="text" value="${queryBookName}" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称"/>
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <label>用户账号 </label>&nbsp;
                                <input type="text" value="${queryUserCode}" name="queryUserCode" class="form-control" placeholder="请输入要查询的用户账号"/>
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <label>查询的借阅日期范围 </label>&nbsp;
                                <input value="${starDate}" type="date" id="starDate" name="starDate" class="form-control" placeholder="请选择开始日期" />
                                &nbsp; - &nbsp;
                                <input value="${endDate}" type="date" id="endDate" name="endDate" class="form-control" placeholder="请选择开始日期" />
                            </div>

                            <input type="hidden" name="pageIndex" value="1"/>
                                <%--复用同一个控制器，区别搜索还是查询所有--%>
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
                        <th>记录id</th>
                        <th>借阅书籍名称</th>
                        <th>借阅人</th>
                        <th>借阅日期</th>
                        <th>归还日期</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <%--表格体--%>
                    <tbody>
                    <c:forEach var="borrow" items="${borrowList}">
                        <tr>
                            <td>${borrow.id}</td>
                            <td>${borrow.bookName}</td>
                            <td>${borrow.userName}</td>

                            <td>${borrow.borrowDate}</td>
                            <td>
                                <c:if test="${borrow.revertDate == null}">未还</c:if>
                                <c:if test="${borrow.revertDate != null}">${borrow.revertDate}</c:if>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/borrow/toModifyBorrow/${borrow.id}"><button type="button" class="btn btn-info btn-sm">修改</button></a>
                                &nbsp; | &nbsp;
                                <a href="${pageContext.request.contextPath}/borrow/deleteBorrow/${borrow.id}"><button type="button" class="btn btn-danger btn-sm">删除</button></a>
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
    var starDate = document.getElementById("starDate");
    var endDate = document.getElementById("endDate");
    function checkAge() {
        if (starDate.value != '' || endDate.value != '') {
            if (starDate.value == '' || endDate.value == '') {
                var msg = document.getElementById("msg");
                msg.innerHTML = '借阅日期范围缺省';
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