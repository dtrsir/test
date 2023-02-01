﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>

<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,role-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<jsp:include page="/WEB-INF/inc/common.jsp"></jsp:include>
<title>管理员列表</title>
</head>
<body>
	<nav class="breadcrumb">
		<a class="btn-refresh btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>

	<div class="page-container">
		<div class="text-c">
			<%-- <form class="form form-horizontal" id="form" method="post" action="${pageContext.request.contextPath}/system/role.do?method=list">
				<input type="text" class="input-text" style="width: 250px" placeholder="名字" id="" name="name">
				<button type="submit" class="btn btn-success" id="" name="">
					<i class="Hui-iconfont">&#xe665;</i> 查询
				</button>
			</form> --%>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;"
				onclick="batchdel('${pageContext.request.contextPath}/device/deviceRepair.do?method=batchDelete')"
				class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
					批量删除 </a> <a href="javascript:;"
				onclick="insert('添加','${pageContext.request.contextPath}/device/deviceRepair.do?method=toInsert','1100','600')"
				class="btn btn-primary radius"> <i class="Hui-iconfont">&#xe600;</i>
					添加
			</a>
			<a href="javascript:;"
				onclick="insert('维修','${pageContext.request.contextPath}/device/deviceRepair.do?method=repair','1100','600')"
				class="btn btn-primary radius"> <i class="Hui-iconfont">&#xe600;</i>
					维修
			</a> </span> </span>
		</div>
		<table
			class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<%-- 这里是初始桌面需要展示数据的字段名（列名） --%>
					<th>设备流水号</th>
					<th>报修时间</th>
					<th>报修人</th>
					<th>维修日期</th>
					<th>维修人</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<%-- JSTL标签循环取出业务层传递过来的初始数据（record） --%>
				<c:forEach items="${requestScope.records }" var="record">
					<tr class="text-c">
					<%-- 这里的id是用来取数据库的数据的就是一个顺序，不需要修改 --%>
						<td><input type="checkbox" value="${record.id }"
							class="checkbox-box"></td>
							<%-- 这里把数据库中对应的字段名取出来 --%>
						<td>${record.did }</td>
						<td>${record.damagedate }</td>
						<td>${record.damager }</td>
						<td>${record.repairdate }</td>
						<td>${record.repairer }</td>
						<td>${record.status}</td>
						<td class="td-manage"><a title="编辑" href="javascript:;"
							onclick="update('编辑','${pageContext.request.contextPath}/device/deviceRepair.do?method=toUpdate&id=${record.id }','1','900','600')"
							class="ml-5" style="text-decoration: none"><i
								class="Hui-iconfont">&#xe6df;</i></a> <a title="删除"
							href="javascript:;"
							onclick="del(this,'${pageContext.request.contextPath}/device/deviceRepair.do?method=delete&id=${record.id}')"
							class="ml-5" style="text-decoration: none"><i
								class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$('.table-sort').dataTable({
			"bFilter" : true,//过滤功能
			"bPaginate" : true,//翻页信息
			"bInfo" : true,//数量信息
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, ]
			} // 制定列不参与排序
			]
		});
		/*
		 参数解释：
		 title	标题
		 url		请求的url
		 id		需要操作的数据id
		 w		弹出层宽度（缺省调默认值）
		 h		弹出层高度（缺省调默认值）
		 */
		/*增加*/
		function insert(title, url, w, h) {
			//hui自己封装的方法
			//里面底层实现就是layer.open()
			layer_show(title, url, w, h);
		}
		/*编辑*/
		function update(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}

		function batchdel(url) {
			if ($(".checkbox-box:checked")) {
				//如有选中的checkbox
				if ($(".checkbox-box:checked").length > 0) {
					var pars = '';
					//迭代
					$(".checkbox-box:checked").each(function(i, v) {
						pars += '&ids=' + $(v).val();
					});
					layer.confirm('确认要删除吗？', function(index) {
						$.ajax({
							type : 'POST',
							url : url,
							data : pars,
							success : function(data) {
								commonreuslt(data);
							}
						});
					});
				} else {
					layer.msg("请选择你要删除的内容", {
						icon : 5,
						time : 1000
					});
				}
			}

		}

		/*管理员-删除*/
		function del(obj, url) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : 'POST',
					url : url,
					dataType : 'json',
					success : function(data) {
						commonreuslt(data);
					}
				});
			});
		}
	</script>
</body>
</html>