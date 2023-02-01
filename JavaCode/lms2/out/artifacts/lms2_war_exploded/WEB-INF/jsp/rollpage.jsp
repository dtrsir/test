<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<nav style="position: absolute;left: 40px;bottom: 0px" class="row clearfix"  aria-label="Page navigation">
    <ul class="pagination">
        <li>共${param.totalCount}条记录&nbsp;&nbsp; ${param.currentPageNo}/${param.totalPageCount}页</li>
        <ul class="pager">
            <li class="previous <c:if test="${param.currentPageNo <= 1}">disabled</c:if>"><a href="javascript:page_nav(document.forms[0],1);"><span aria-hidden="true"></span>首页</a></li>
            <li class="<c:if test="${param.currentPageNo == 1}">disabled</c:if> ">
                <a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1});" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <%--<li class="active"><a href="#">${param.currentPageNo}</a></li>--%>

            <c:set var="stop" value="1"/>
            <c:forEach var="i" begin="${param.currentPageNo}" end="${param.currentPageNo + 4}">
                <c:if test="${stop == 1}">
                    <li class=""><a href="javascript:page_nav(document.forms[0],<c:out value="${i}"/>);"><c:out value="${i}"/></a></li>
                    <c:if test="${i >= param.totalPageCount}">
                        <c:set var="stop" value="0"/>
                    </c:if>
                </c:if>

            </c:forEach>
            <li class="<c:if test="${param.currentPageNo == param.totalPageCount}">disabled</c:if> ">
                <a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1});" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <li class="next <c:if test="${param.currentPageNo >= param.totalPageCount}">disabled</c:if>"><a href="javascript:page_nav(document.forms[0],${param.totalPageCount });">尾页<span aria-hidden="true"></span></a></li>
        </ul>
    </ul>
    <span>
        <label>跳转至</label>

                <input style="width: 100px;display: inline" type="text" class="form-control inline" name="inputPage" id="inputPage"/> 页

        <button type="button" class="btn btn-default"
                onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>

    </span>
</nav>



<script>
    function page_nav(frm,num){
        frm.pageIndex.value = num;
        frm.submit();
    }

    function jump_to(frm,num){
        //alert(num);
        //验证用户的输入
        var regexp=/^[1-9]\d*$/;
        var totalPageCount = document.getElementById("totalPageCount").value;
        //alert(totalPageCount);
        if(!regexp.test(num)){
            alert("请输入大于0的正整数！");
            return false;
        }else if((num-totalPageCount) > 0){
            alert("请输入小于总页数的页码");
            return false;
        }else{
            page_nav(frm,num);
        }
    }
</script>
</body>
</html>