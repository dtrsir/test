<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/taglib.jsp"%>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<jsp:include page="/WEB-INF/inc/common.jsp"></jsp:include>
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form" method="post" action="${pageContext.request.contextPath}${requestScope.record != null ?  '/device/device.do?method=update' :'/device/device.do?method=insert'  }">
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record != null }">
				<input type="hidden" name="id" value="${requestScope.record.id }">
			</c:if>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备类型：</label>
				<div class="formControls col-xs-8 col-sm-9">
				
				    <select  id="dtid" name="dtid">
				         <c:forEach items="${records}" var="itm"   >
				            <option value="${itm.id}" >${itm.name}</option>
				         </c:forEach>
				    </select>
					 
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>流水号：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.record.code }" placeholder="" id="code" name="code">
				</div>
			</div>
			 
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>备注：</label>
				<div class="formControls col-xs-8 col-sm-9">
				<textarea name="remarks" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)">${requestScope.record.remarks }</textarea>
				
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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