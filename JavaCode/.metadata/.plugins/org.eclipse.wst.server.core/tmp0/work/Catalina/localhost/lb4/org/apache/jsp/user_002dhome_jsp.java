/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-05-23 14:34:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sjsq.po.Book;
import com.sjsq.service.impl.BookServiceImpl;
import java.util.List;

public final class user_002dhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.sjsq.service.impl.BookServiceImpl");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.sjsq.po.Book");
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>查看图书</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("     \r\n");
      out.write("    body{\r\n");
      out.write("            background: url(\"images/bg5.jpg\");\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            \r\n");
      out.write("            }\r\n");
      out.write("	  a:hover{\r\n");
      out.write("			color: #06f;\r\n");
      out.write("			padding: 5px 8px 3px 12px;\r\n");
      out.write("			background-color: 	#BDB76B;\r\n");
      out.write("			border-top: #717171;\r\n");
      out.write("			border-left: #717171;\r\n");
      out.write("			border-bottom: #eee;\r\n");
      out.write("			border-right: #eee;\r\n");
      out.write("				}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "user-top.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');


    // 获取上一个页面传过来的值
    String bookname = request.getParameter("bookname");

    System.out.println("书名:" + bookname);
    // 传入的空字符串处理,null不能使用equals
    if (bookname != null && bookname.equals("")) {
        bookname = null;
    }

    BookServiceImpl service = new BookServiceImpl();
    List<Book> list = service.select(bookname);

      out.write("\r\n");
      out.write("<h1>图书列表</h1>\r\n");
      out.write("<hr>\r\n");
      out.write("<div id=\"before\">\r\n");
      out.write("    <form action=\"user-home.jsp\" method=\"post\">\r\n");
      out.write("        请输入书名：<input type=\"text\" name=\"bookname\" placeholder=\"输入图书名称搜索\">\r\n");
      out.write("        <input type=\"submit\" value=\"查询\"/>\r\n");
      out.write("    </form>\r\n");
      out.write("    <h3>在这里你可以借阅以下图书</h3>\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      out.write("<table align=\"center\" cellspacing=\"0\">\r\n");
      out.write("    <tr bgcolor=\"#5f9ea0\" style=\"font-size: 20px;height:40px;text-align: center\">\r\n");
      out.write("        <td style=\"width: 120px\">编号</td>\r\n");
      out.write("        <td style=\"width: 120px\">书名</td>\r\n");
      out.write("        <td style=\"width: 120px\">价格</td>\r\n");
      out.write("        <td style=\"width: 120px\">作者</td>\r\n");
      out.write("        <td style=\"width: 120px\">出版社</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");

        String bg = null;
        for (int i = 0; i < list.size(); i++) {
            Book b = list.get(i);
            if (i % 2 == 0) {
                bg = "Azure ";
            } else {
                bg = "PowderBlue ";
            }

    
      out.write("\r\n");
      out.write("    <tr bgcolor=\"");
      out.print(bg);
      out.write("\" style=\"height:40px;text-align: center\">\r\n");
      out.write("        <td>");
      out.print(b.getBookid());
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("        <td><a href=\"user-book-info.jsp?bookid=");
      out.print(b.getBookid());
      out.write('"');
      out.write('>');
      out.print(b.getBookname());
      out.write("\r\n");
      out.write("        </a></td>\r\n");
      out.write("        <td>");
      out.print(b.getPrice() );
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("        <td>");
      out.print(b.getAuthor() );
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("        <td>");
      out.print(b.getPublish() );
      out.write("\r\n");
      out.write("        </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");

        }
    
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
