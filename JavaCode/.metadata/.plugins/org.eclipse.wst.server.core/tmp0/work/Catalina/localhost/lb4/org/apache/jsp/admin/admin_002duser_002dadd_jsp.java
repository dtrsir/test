/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-05-26 04:52:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_002duser_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>新增用户</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        h1 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h4 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: red;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("		 body{\r\n");
      out.write("            background: url(\"../images/bg5.jpg\");\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        div {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #before {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("            a:hover{\r\n");
      out.write("			color: #06f;\r\n");
      out.write("			padding: 5px 8px 3px 12px;\r\n");
      out.write("			background-color: 	#BDB76B;\r\n");
      out.write("			border-top: #717171;\r\n");
      out.write("			border-left: #717171;\r\n");
      out.write("			border-bottom: #eee;\r\n");
      out.write("			border-right: #eee;\r\n");
      out.write("				}\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../top.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h1>新增用户</h1>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<div id=\"before\">\r\n");
      out.write("     <a href=\"admin-home.jsp\">返回主页</a>\r\n");
      out.write("</div>\r\n");
      out.write("</br>\r\n");
      out.write("\r\n");
      out.write("<form action=\"admin-user-do-add.jsp\" method=\"post\" name=\"registerForm\">\r\n");
      out.write("    <div>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <label>账号：</label>\r\n");
      out.write("            <input type=\"text\" name=\"username\" id=\"username\" placeholder=\"用户名\" autofocus=\"autofocus\">\r\n");
      out.write("        </tr>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <label>密码：</label></td>\r\n");
      out.write("            <input type=\"text\" name=\"password\" id=\"password\" placeholder=\"密码\">\r\n");
      out.write("        </tr>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <label>邮箱：</label>\r\n");
      out.write("            <input type=\"text\" name=\"email\" id=\"email\" placeholder=\"邮箱\">\r\n");
      out.write("        </tr>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <label>电话：</label>\r\n");
      out.write("            <input type=\"text\" name=\"phone\" id=\"phone\" placeholder=\"电话\">\r\n");
      out.write("        </tr>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <label>是否管理员：</label>\r\n");
      out.write("            <input type=\"text\" name=\"isadmin\" id=\"isadmin\" placeholder=\"是否管理员（1是，0否）\">\r\n");
      out.write("        </tr>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"submitbtn\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <button type=\"submit\" onclick=\"return checkForm()\">添加</button>\r\n");
      out.write("            <button type=\"reset\">重置</button>\r\n");
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function checkForm() {\r\n");
      out.write("        var username = registerForm.username.value;\r\n");
      out.write("        var password = registerForm.password.value;\r\n");
      out.write("        if (username == \"\" || username == null) {\r\n");
      out.write("            alert(\"请输入用户名\");\r\n");
      out.write("            registerForm.username.focus();\r\n");
      out.write("            return false;\r\n");
      out.write("        } else if (password == \"\" || password == null) {\r\n");
      out.write("            alert(\"请输入密码\");\r\n");
      out.write("            registerForm.password.focus();\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        alert('添加成功！');\r\n");
      out.write("        return true;\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
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
}
