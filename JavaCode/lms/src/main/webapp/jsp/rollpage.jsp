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
<div>
    <ul>
        <br/>
        <br/>
        <br/>
        <li>共${param.totalCount}条记录&nbsp;&nbsp; ${param.currentPageNo}/${param.totalPageCount}页</li>
        <c:if test="${param.currentPageNo > 1}">
            <a href="javascript:page_nav(document.forms[0],1);">首页</a>
            <a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1});">上一页</a>
        </c:if>
        <c:if test="${param.currentPageNo < param.totalPageCount }">
            <a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1 });">下一页</a>
            <a href="javascript:page_nav(document.forms[0],${param.totalPageCount });">最后一页</a>
        </c:if>
        &nbsp;&nbsp;
    </ul>
    <span>
        <label>跳转至</label>
        <input type="text" name="inputPage" id="inputPage"/>页
        <button type="button"
                 onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
    </span>
</div>
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