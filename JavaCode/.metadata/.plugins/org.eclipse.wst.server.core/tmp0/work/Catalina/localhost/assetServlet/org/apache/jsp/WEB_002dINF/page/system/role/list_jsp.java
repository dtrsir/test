/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-05-14 11:25:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.system.role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("jar:file:/D:/sourceCode/JavaCode/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/assetServlet/WEB-INF/lib/standard-1.1.2.jar!/META-INF/fn.tld", Long.valueOf(1098682290000L));
    _jspx_dependants.put("jar:file:/D:/sourceCode/JavaCode/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/assetServlet/WEB-INF/lib/standard-1.1.2.jar!/META-INF/c.tld", Long.valueOf(1098682290000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,role-scalable=no\" />\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/inc/common.jsp", out, false);
      out.write("\r\n");
      out.write("<title>管理员列表</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<nav class=\"breadcrumb\">\r\n");
      out.write("		<a class=\"btn-refresh btn btn-success radius r\" style=\"line-height: 1.6em; margin-top: 3px\" href=\"javascript:location.replace(location.href);\" title=\"刷新\"><i class=\"Hui-iconfont\">&#xe68f;</i></a>\r\n");
      out.write("	</nav>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"page-container\">\r\n");
      out.write("		<div class=\"text-c\">\r\n");
      out.write("			");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"cl pd-5 bg-1 bk-gray mt-20\">\r\n");
      out.write("			<span class=\"l\"><a href=\"javascript:;\" onclick=\"batchdel('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/system/role.do?method=batchDelete')\" class=\"btn btn-danger radius\"><i class=\"Hui-iconfont\">&#xe6e2;</i> 批量删除\r\n");
      out.write("			</a> <a href=\"javascript:;\" onclick=\"insert('添加','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/system/role.do?method=toInsert','800','500')\" class=\"btn btn-primary radius\"> <i class=\"Hui-iconfont\">&#xe600;</i> 添加\r\n");
      out.write("			</a> </span> </span>\r\n");
      out.write("		</div>\r\n");
      out.write("		<table class=\"table table-border table-bordered table-hover table-bg table-sort\">\r\n");
      out.write("			<thead>\r\n");
      out.write("				<tr class=\"text-c\">\r\n");
      out.write("					<th width=\"25\"><input type=\"checkbox\" name=\"\" value=\"\"></th>\r\n");
      out.write("					<th>ID</th>\r\n");
      out.write("					<th>名字</th>\r\n");
      out.write("					<th>备注</th>\r\n");
      out.write("					<th>操作</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</thead>\r\n");
      out.write("			<tbody>\r\n");
      out.write("				");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		$('.table-sort').dataTable({\r\n");
      out.write("			\"bFilter\" : true,//过滤功能\r\n");
      out.write("			\"bPaginate\" : true,//翻页信息\r\n");
      out.write("			\"bInfo\" : true,//数量信息\r\n");
      out.write("			\"aaSorting\" : [ [ 1, \"desc\" ] ],//默认第几个排序\r\n");
      out.write("			\"bStateSave\" : true,//状态保存\r\n");
      out.write("			\"aoColumnDefs\" : [\r\n");
      out.write("			//{\"bVisible\": false, \"aTargets\": [ 3 ]} //控制列的隐藏显示\r\n");
      out.write("			{\r\n");
      out.write("				\"orderable\" : false,\r\n");
      out.write("				\"aTargets\" : [ 0, ]\r\n");
      out.write("			} // 制定列不参与排序\r\n");
      out.write("			]\r\n");
      out.write("		});\r\n");
      out.write("		/*\r\n");
      out.write("		 参数解释：\r\n");
      out.write("		 title	标题\r\n");
      out.write("		 url		请求的url\r\n");
      out.write("		 id		需要操作的数据id\r\n");
      out.write("		 w		弹出层宽度（缺省调默认值）\r\n");
      out.write("		 h		弹出层高度（缺省调默认值）\r\n");
      out.write("		 */\r\n");
      out.write("		/*增加*/\r\n");
      out.write("		function insert(title, url, w, h) {\r\n");
      out.write("			//hui自己封装的方法\r\n");
      out.write("			//里面底层实现就是layer.open()\r\n");
      out.write("			layer_show(title, url, w, h);\r\n");
      out.write("		}\r\n");
      out.write("		/*编辑*/\r\n");
      out.write("		function update(title, url, id, w, h) {\r\n");
      out.write("			layer_show(title, url, w, h);\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function batchdel(url) {\r\n");
      out.write("			if ($(\".checkbox-box:checked\")) {\r\n");
      out.write("				if ($(\".checkbox-box:checked\").length > 0) {\r\n");
      out.write("					var pars = '';\r\n");
      out.write("					$(\".checkbox-box:checked\").each(function(i, v) {\r\n");
      out.write("						pars += '&ids=' + $(v).val();\r\n");
      out.write("					});\r\n");
      out.write("					layer.confirm('确认要删除吗？', function(index) {\r\n");
      out.write("						$.ajax({\r\n");
      out.write("							type : 'POST',\r\n");
      out.write("							url : url,\r\n");
      out.write("							data : pars,\r\n");
      out.write("							success : function(data) {\r\n");
      out.write("								commonreuslt(data);\r\n");
      out.write("							}\r\n");
      out.write("						});\r\n");
      out.write("					});\r\n");
      out.write("				} else {\r\n");
      out.write("					layer.msg(\"请选择你要删除的内容\", {\r\n");
      out.write("						icon : 5,\r\n");
      out.write("						time : 1000\r\n");
      out.write("					});\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		/*管理员-删除*/\r\n");
      out.write("		function del(obj, url) {\r\n");
      out.write("			layer.confirm('确认要删除吗？', function(index) {\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					type : 'POST',\r\n");
      out.write("					url : url,\r\n");
      out.write("					dataType : 'json',\r\n");
      out.write("					success : function(data) {\r\n");
      out.write("						commonreuslt(data);\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/page/system/role/list.jsp(45,4) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.records }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      // /WEB-INF/page/system/role/list.jsp(45,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("record");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("					<tr class=\"text-c\">\r\n");
            out.write("						<td><input type=\"checkbox\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" class=\"checkbox-box\"></td>\r\n");
            out.write("						<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("						<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("						<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.remarks }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("						<td class=\"td-manage\"><a title=\"编辑\" href=\"javascript:;\" onclick=\"update('编辑','");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("/system/role.do?method=toUpdate&id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("','1','800','500')\" class=\"ml-5\" style=\"text-decoration: none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> \r\n");
            out.write("						<a title=\"删除\" href=\"javascript:;\" onclick=\"del(this,'");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("/system/role.do?method=delete&id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("')\" class=\"ml-5\" style=\"text-decoration: none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a></td>\r\n");
            out.write("					</tr>\r\n");
            out.write("				");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
