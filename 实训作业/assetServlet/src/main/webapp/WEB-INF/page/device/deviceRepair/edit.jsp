<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/taglib.jsp"%>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<jsp:include page="/WEB-INF/inc/common.jsp"></jsp:include>
</head>
<body>
	<article class="page-container">
	<%-- 这里让隐藏表单提交到deviceRepair.do来执行 --%>
		<form class="form form-horizontal" id="form" method="post"
			action="${pageContext.request.contextPath}${requestScope.record != null ?  '/device/deviceRepair.do?method=update' :'/device/deviceRepair.do?method=insert'  }">
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record != null }">
			<%-- 在这里把用户选中的数据项取到 --%>
				<input type="hidden" name="id" value="${requestScope.record.id }">
			</c:if>
			<%-- 这里修改设备ID --%>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>设备ID：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text"
						value="${requestScope.record.did }" placeholder="" id="did"
						name="did">
				</div>
			</div>
			<%-- 这里修改报修时间 --%>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>报修时间：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="datetime" class="input-text"
						value="${requestScope.record.damagedate }" placeholder="" id="damagedate"
						name="damagedate">
				</div>
			</div>
			<%-- 这里修改报修人 --%>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>报修人：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text"
						value="${requestScope.record.damager }" placeholder="" id="damager"
						name="damager">
				</div>
			</div>
<%-- 			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>设备id：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<select id="dtid" name="dtid">
					这里使用下拉框，所以需要循环遍历数据库中的id并且把设备id拿到
						<c:forEach items="${records}" var="itm">
							<option value="${itm.id}">${records.did}</option>
						</c:forEach>
					</select>

				</div>
			</div> --%>
			<%-- 这里修改备注 --%>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>报修备注：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text"
						value="${requestScope.record.damageremarks }" placeholder="" id="damageremarks"
						name="damageremarks">
				</div>
			</div>
						<%-- 这里修改维修日期 --%>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>维修日期：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="datetime" class="input-text"
						value="${requestScope.record.repairdate }" placeholder="" id="repairdate"
						name="repairdate">
				</div>
			</div>
						<%-- 这里修改维修人 --%>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>维修人：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text"
						value="${requestScope.record.repairer }" placeholder="" id="repairer"
						name="repairer">
				</div>
			</div>
						<%-- 这里修改状态 --%>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>状态：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text"
						value="${requestScope.record.status }" placeholder="" id="status"
						name="status">
				</div>
			</div>
			

<%-- 			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red"></span>报修备注：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<textarea name="remarks" cols="" rows="" class="textarea"
						placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true"
						nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)">${requestScope.record.remarks }</textarea>

				</div>
			</div> --%>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				</div>
			</div>
		</form>
	</article>

	<script type="text/javascript">
		$("#form").validate({
			rules : {
				name : {
					required : true,
					minlength : 2,
					maxlength : 50
				}

			},
			onkeyup : false,
			focusCleanup : true,
			submitHandler : function(form) {
				$(form).ajaxSubmit({
					type : form.method,
					url : form.action,
					success : function(data) {
						commonreuslt(data);
					}
				});
			}
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>