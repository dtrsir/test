<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="jk" uri="http://www.jkoss.com/ossjktaglib"%>
<%@include file="/WEB-INF/inc/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<jsp:include page="/WEB-INF/inc/common.jsp"></jsp:include>
<title>主页</title>
</head>
<body>
   <jk:topper logoName="JKOSS"></jk:topper>
   	         <!-- 以下是菜单 -->
               <dt><i class='Hui-iconfont'>&#xe62e;</i>系统管理<i class='Hui-iconfont menu_dropdown-arrow'>&#xe6d5;</i></dt>
               <dd><ul>
						<li><a data-href="${pageContext.request.contextPath}/system/user.do?method=list" data-title="用户列表" href="javascript:void(0)">用户列表</a></li>
						<li><a data-href="${pageContext.request.contextPath}/system/role.do?method=list" data-title="角色列表" href="javascript:void(0)">角色列表</a></li>
					</ul>
				</dd>
			  <!-- 以上是菜单 -->
			</dl>
		</div>
	</aside>
	<div class="dislpayArrow hidden-xs">
		<a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
	</div>
	<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active"><span title="我的桌面" data-href="${pageContext.request.contextPath}/system/index.do?method=toDesktop">我的桌面</span> <em></em></li>
				</ul>
			</div>
			<div class="Hui-tabNav-more btn-group">
				<a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
			</div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display: none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0" src="${pageContext.request.contextPath}/system/index.do?method=toDesktop"></iframe>
			</div>
		</div>
	</section>

	<div class="contextMenu" id="Huiadminmenu">
		<ul>
			<li id="closethis">关闭当前</li>
			<li id="closeall">关闭全部</li>
		</ul>
	</div>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
	<script type="text/javascript">
		$(function() {
			$("body").Huitab({
				tabBar : ".navbar-wrapper .navbar-levelone",
				tabCon : ".Hui-aside .menu_dropdown",
				className : "current",
				index : 0,
			});
		});
		/*登出*/
		function logout(){
			layer.confirm('确认要退出吗？', function(index) {
				 location.href="${pageContext.request.contextPath}/system/index.do?method=logout";
			});
		}
		/*个人信息*/
		function myselfinfo() {
			layer_show("个人信息", "${pageContext.request.contextPath}/system/user.do?method=toUpdate&id=${sessionScope.assetuser.id}", 800, 500);
		}

		 
	</script>


</body>
</html>