/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-05-26 05:09:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tsgl.pojo.Book;
import com.tsgl.pojo.Comment;
import com.tsgl.service.BookService;
import com.tsgl.service.CommentService;
import com.tsgl.service.impl.BookServiceImpl;
import com.tsgl.service.impl.CommentServiceImpl;
import java.util.List;

public final class user_002dbook_002dinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.tsgl.pojo.Book");
    _jspx_imports_classes.add("com.tsgl.service.impl.BookServiceImpl");
    _jspx_imports_classes.add("com.tsgl.pojo.Comment");
    _jspx_imports_classes.add("com.tsgl.service.BookService");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.tsgl.service.CommentService");
    _jspx_imports_classes.add("com.tsgl.service.impl.CommentServiceImpl");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    // 获取绝对路径路径 ,开发项目一定要使用绝对路径，不然肯定出错
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath );
      out.write("\" />\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>图书详情</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        h1{\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        a{\r\n");
      out.write("            text-align:center;text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        a:hover{\r\n");
      out.write("            text-decoration: underline;font-size: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        #before{\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        #content{\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        #content-title{\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("          body{\r\n");
      out.write("            background: url(\"images/bg5.jpg\");\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            \r\n");
      out.write("            }\r\n");
      out.write("              a:hover{\r\n");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "user-top.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <h1>图书详情</h1>\r\n");
      out.write("    <hr>\r\n");
      out.write("    <div id=\"before\">\r\n");
      out.write("        <a href=\"user/user-home.jsp\">返回主页</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");

        // 获取bookid,添加评论之后跳转没有带参数
        Integer bookid = 0;
        if(request.getParameter("bookid")==null){
            bookid = (Integer) session.getAttribute("bookid");
        }else {
            bookid = Integer.parseInt(request.getParameter("bookid"));
        }


        BookService bookService = new BookServiceImpl();
        Book book = bookService.getBook(bookid);

        // 获取留言
        CommentService commentService = new CommentServiceImpl();
        List<Comment> list = commentService.selectComment(bookid);

    
      out.write("\r\n");
      out.write("    <table align=\"center\" cellpadding=\"20\" cellspacing=\"20\">\r\n");
      out.write("        <tr style=\"font-size: 20px\">\r\n");
      out.write("            <td>图书编号</td>\r\n");
      out.write("            <td>图书名称</td>\r\n");
      out.write("            <td>图书价格</td>\r\n");
      out.write("            <td>图书作者</td>\r\n");
      out.write("            <td>图书出版社</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>");
      out.print(book.getBookid());
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(book.getBookname());
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(book.getPrice());
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(book.getAuthor());
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(book.getPublish());
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td colspan=\"3\"></td>\r\n");
      out.write("            <td></td>\r\n");
      out.write("            <td colspan=\"2\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    <div style=\"text-align:center;\">\r\n");
      out.write("        <a  href=\"user/user-bookshelf-add.jsp?bookid=");
      out.print(book.getBookid());
      out.write("\">加入书架</a>\r\n");
      out.write("        <a  href=\"user/user-home.jsp\">图书列表</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");

        for(int i = 0;i<list.size();i++){
            Comment comment = list.get(i);
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <fieldset style=\"width:650px;margin: 0 auto;\">\r\n");
      out.write("        <legend>留言");
      out.print(comment.getCommentid());
      out.write("</legend>\r\n");
      out.write("        <div style=\"left: 900px\">\r\n");
      out.write("            用户：");
      out.print(comment.getUsername());
      out.write("    留言内容:");
      out.print(comment.getComment());
      out.write("    留言时间：");
      out.print(comment.getTime());
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </fieldset>\r\n");
      out.write("\r\n");
      out.write("    ");

        }
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <h4 id=\"content-title\">留言板</h4>\r\n");
      out.write("    <form action=\"user/user-comment-add.jsp?bookid=");
      out.print(book.getBookid());
      out.write("\" method=\"post\"  id=\"content\">\r\n");
      out.write("\r\n");
      out.write("        <textarea rows=\"10\" cols=\"80\" name=\"content\" ></textarea>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <button type=\"submit\">添加</button>\r\n");
      out.write("    </form>\r\n");
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