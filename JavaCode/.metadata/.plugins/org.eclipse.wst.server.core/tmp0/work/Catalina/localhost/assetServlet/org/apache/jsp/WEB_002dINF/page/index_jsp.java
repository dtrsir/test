/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-05-14 15:33:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(7);
    _jspx_dependants.put("jar:file:/D:/sourceCode/JavaCode/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/assetServlet/WEB-INF/lib/standard-1.1.2.jar!/META-INF/fn.tld", Long.valueOf(1098682290000L));
    _jspx_dependants.put("jar:file:/D:/sourceCode/JavaCode/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/assetServlet/WEB-INF/lib/toper.jar!/META-INF/top.tld", Long.valueOf(1541696308000L));
    _jspx_dependants.put("jar:file:/D:/sourceCode/JavaCode/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/assetServlet/WEB-INF/lib/standard-1.1.2.jar!/META-INF/c.tld", Long.valueOf(1098682290000L));
    _jspx_dependants.put("/WEB-INF/lib/toper.jar", Long.valueOf(1541737005661L));
    _jspx_dependants.put("/WEB-INF/inc/taglib.jsp", Long.valueOf(1535530041589L));
    _jspx_dependants.put("jar:file:/D:/sourceCode/JavaCode/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/assetServlet/WEB-INF/lib/standard-1.1.2.jar!/META-INF/fmt.tld", Long.valueOf(1098682290000L));
    _jspx_dependants.put("/WEB-INF/lib/standard-1.1.2.jar", Long.valueOf(1541731369616L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" />\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/inc/common.jsp", out, false);
      out.write("\r\n");
      out.write("<title>主页</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   ");
      if (_jspx_meth_jk_005ftopper_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("   	         <!-- 以下是菜单 -->\r\n");
      out.write("               <dt><i class='Hui-iconfont'>&#xe62e;</i>系统管理<i class='Hui-iconfont menu_dropdown-arrow'>&#xe6d5;</i></dt>\r\n");
      out.write("               <dd><ul>\r\n");
      out.write("						<li><a data-href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/system/user.do?method=list\" data-title=\"用户列表\" href=\"javascript:void(0)\">用户列表</a></li>\r\n");
      out.write("						<li><a data-href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/system/role.do?method=list\" data-title=\"角色列表\" href=\"javascript:void(0)\">角色列表</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</dd>\r\n");
      out.write("				<dt><i class='Hui-iconfont'>&#xe62e;</i>设备管理<i class='Hui-iconfont menu_dropdown-arrow'>&#xe6d5;</i></dt>\r\n");
      out.write("               <dd><ul>\r\n");
      out.write("						<li><a data-href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/device/deviceType.do?method=list\" data-title=\"设备类型\" href=\"javascript:void(0)\">类型列表</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("                <ul>\r\n");
      out.write("						<li><a data-href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/device/device.do?method=list\" data-title=\"设备管理\" href=\"javascript:void(0)\">设备管理</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("					 <ul>\r\n");
      out.write("						<li><a data-href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/device/deviceRepair.do?method=list\" data-title=\"设备维修\" href=\"javascript:void(0)\">设备维修</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</dd>\r\n");
      out.write("			  <!-- 以上是菜单 -->\r\n");
      out.write("			</dl>\r\n");
      out.write("		</div>\r\n");
      out.write("	</aside>\r\n");
      out.write("	<div class=\"dislpayArrow hidden-xs\">\r\n");
      out.write("		<a class=\"pngfix\" href=\"javascript:void(0);\" onClick=\"displaynavbar(this)\"></a>\r\n");
      out.write("	</div>\r\n");
      out.write("	<section class=\"Hui-article-box\">\r\n");
      out.write("		<div id=\"Hui-tabNav\" class=\"Hui-tabNav hidden-xs\">\r\n");
      out.write("			<div class=\"Hui-tabNav-wp\">\r\n");
      out.write("				<ul id=\"min_title_list\" class=\"acrossTab cl\">\r\n");
      out.write("					<li class=\"active\"><span title=\"我的桌面\" data-href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/system/index.do?method=toDesktop\">我的桌面</span> <em></em></li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"Hui-tabNav-more btn-group\">\r\n");
      out.write("				<a id=\"js-tabNav-prev\" class=\"btn radius btn-default size-S\" href=\"javascript:;\"><i class=\"Hui-iconfont\">&#xe6d4;</i></a><a id=\"js-tabNav-next\" class=\"btn radius btn-default size-S\" href=\"javascript:;\"><i class=\"Hui-iconfont\">&#xe6d7;</i></a>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div id=\"iframe_box\" class=\"Hui-article\">\r\n");
      out.write("			<div class=\"show_iframe\">\r\n");
      out.write("				<div style=\"display: none\" class=\"loading\"></div>\r\n");
      out.write("				<iframe scrolling=\"yes\" frameborder=\"0\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/system/index.do?method=toDesktop\"></iframe>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</section>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"contextMenu\" id=\"Huiadminmenu\">\r\n");
      out.write("		<ul>\r\n");
      out.write("			<li id=\"closethis\">关闭当前</li>\r\n");
      out.write("			<li id=\"closeall\">关闭全部</li>\r\n");
      out.write("		</ul>\r\n");
      out.write("	</div>\r\n");
      out.write("	<!--请在下方写此页面业务相关的脚本-->\r\n");
      out.write("	<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/lib/jquery.contextmenu/jquery.contextmenu.r2.js\"></script>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		$(function() {\r\n");
      out.write("			$(\"body\").Huitab({\r\n");
      out.write("				tabBar : \".navbar-wrapper .navbar-levelone\",\r\n");
      out.write("				tabCon : \".Hui-aside .menu_dropdown\",\r\n");
      out.write("				className : \"current\",\r\n");
      out.write("				index : 0,\r\n");
      out.write("			});\r\n");
      out.write("		});\r\n");
      out.write("		/*登出*/\r\n");
      out.write("		function logout(){\r\n");
      out.write("			layer.confirm('确认要退出吗？', function(index) {\r\n");
      out.write("				 location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/system/index.do?method=logout\";\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("		/*个人信息*/\r\n");
      out.write("		function myselfinfo() {\r\n");
      out.write("			layer_show(\"个人信息\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/system/user.do?method=toUpdate&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.assetuser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\", 800, 500);\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		 \r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_jk_005ftopper_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  jk:topper
    com.ossjk.tag.TopTag _jspx_th_jk_005ftopper_005f0 = new com.ossjk.tag.TopTag();
    _jsp_getInstanceManager().newInstance(_jspx_th_jk_005ftopper_005f0);
    try {
      _jspx_th_jk_005ftopper_005f0.setJspContext(_jspx_page_context);
      // /WEB-INF/page/index.jsp(21,3) name = logoName type = javax.servlet.jsp.tagext.JspFragment reqTime = true required = false fragment = true deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_jk_005ftopper_005f0.setLogoName("JKOSS");
      _jspx_th_jk_005ftopper_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_jk_005ftopper_005f0);
    }
    return false;
  }
}