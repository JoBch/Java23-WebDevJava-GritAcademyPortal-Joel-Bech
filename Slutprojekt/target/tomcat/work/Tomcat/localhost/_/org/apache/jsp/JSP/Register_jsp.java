/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-02-18 11:48:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/JSP/HeaderLinks.jsp", Long.valueOf(1708088075426L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>HeaderLinks</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../CSS/Style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("    <header class=\"headerLinks\">\r\n");
      out.write("    <div>\r\n");
      out.write("        <a href=\"Students\">Click here to add a student to the DB.</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>\r\n");
      out.write("        <a href=\"Courses\">Click here to add a course to the DB.</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>\r\n");
      out.write("        <a href=\"Attendance\">Click here to check who is studying what course.</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div>\r\n");
      out.write("        <a href=\"index.html\">Home Page</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../CSS/Style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h1>Följ instruktionerna för att lägga till en ny student</h1>\r\n");
      out.write("    <form style=text-align:center; action=AddStudentServlet\\ method=POST>\r\n");
      out.write("                    <label for=fname>Skriv in förnamn:</label><br>\r\n");
      out.write("                    <input type=text id=fname name=fname required><br>\r\n");
      out.write("                    <label for=lname>Skriv in efternamn:</label><br>\r\n");
      out.write("                    <input type=text id=lname name=lname required><br>\r\n");
      out.write("                    <label for=town>Vart bor studenten:</label><br>\r\n");
      out.write("                    <input type=text id=town name=town required><br>\r\n");
      out.write("                    <label for=hobby>Skriv in Hobby:</label><br>\r\n");
      out.write("                    <input type=text id=hobby name=hobby required><br>\r\n");
      out.write("\r\n");
      out.write("                    <label for=username>Skriv in önskat användarnamn:</label><br>\r\n");
      out.write("                    <input type=text id=username name=username required><br>\r\n");
      out.write("\r\n");
      out.write("                    <label for=password>Skriv in önskat lösenord:</label><br>\r\n");
      out.write("                    <input type=text id=password name=password required><br>\r\n");
      out.write("                    <input type=submit value=Submit>\r\n");
      out.write("                    </form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
