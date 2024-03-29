/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-02-21 16:49:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Courses_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/JSP/NavBarTeacher.jsp", Long.valueOf(1708528382019L));
    _jspx_dependants.put("/JSP/Footer.jsp", Long.valueOf(1708506727560L));
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
      out.write("    <title>Lägg till ny kurs</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../CSS/Style.css\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../CSS/Navbar.css\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"mainNavbar\">\r\n");
      out.write("    <navbar>\r\n");
      out.write("        <banner>\r\n");
      out.write("\r\n");
      out.write("            <h1 class=\"navBarTitle\">GRIT ACADEMY</h1>\r\n");
      out.write("\r\n");
      out.write("            <!-- Vill vi få in namnet på den inloggade här i navbar titel kanske?-->\r\n");
      out.write("        </banner>\r\n");
      out.write("    <div id=\"menuLinks\">\r\n");
      out.write("        <nav class=\"navBarLinks\">\r\n");
      out.write("            <a class=\"navLink\" href=\"/Attendance\">HEM</a>\r\n");
      out.write("            <a class=\"navLink\" href=\"/Courses\">ADMIN KURSER</a>\r\n");
      out.write("            <a class=\"navLink\" href=\"/Add\">ADMIN LÄGG TILL ELEV/LÄRARE</a>\r\n");
      out.write("            <a class=\"navLink\" href=\"/Delete\">ADMIN TA BORT ELEV/LÄRARE</a>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <a class=\"navLink\" href=\"/logout\"><form style=text-align:center; action=\"/Login.jsp\" method=\"POST\"><input type=\"submit\" id=\"logout\" value=\"Logga ut\"></form></a>\r\n");
      out.write("    </div>\r\n");
      out.write("    </navbar>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form class=\"AddForm\" action=Courses method=POST>\r\n");
      out.write("    <label for=\"name\">Skriv in kursens namn:</label><br>\r\n");
      out.write("    <input type=text id=name name=name required><br>\r\n");
      out.write("    <label for=yhp>Skriv in Yrkeshögskolepoäng:</label><br>\r\n");
      out.write("    <input type=text id=yhp name=yhp required><br>\r\n");
      out.write("    <label for=description>Vad innehåller kursen?</label><br>\r\n");
      out.write("    <input type=text id=description name=description required><br>\r\n");
      out.write("\r\n");
      out.write("    <input type=submit value=Submit>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Site footer -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../CSS/FooterStyle.css\">\r\n");
      out.write("<footer class=\"site-footer\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-sm-12 col-md-6\">\r\n");
      out.write("                <h6 style=\"text-align: center\">Om oss</h6>\r\n");
      out.write("                <p style=\"text-align: center\" class=\"text-justify\">Detta är en portal för <i>studenter och lärare </i> på Grit Academy. För mer info om att gå med i kurser och liknande, ta kontakt med Admin på skolan</p>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div style=\"text-align: center\">\r\n");
      out.write("                <ul class=\"footer-links\">\r\n");
      out.write("                    <li><a href=\"https://gritacademy.se/\">Besök vår hemsida för mer info</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <hr>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div style=\"text-align: center\" class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <p class=\"copyright-text\">Copyright &copy; 2017 All Rights Reserved by\r\n");
      out.write("                    <a href=\"https://www.facebook.com/andreas.martensson.12/\">Andreas Jabrell</a> och\r\n");
      out.write("                    <a href=\"https://www.facebook.com/joel.bech.9\">Joel Bech</a>.\r\n");
      out.write("                </p>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-4 col-sm-6 col-xs-12\">\r\n");
      out.write("                <ul class=\"social-icons\">\r\n");
      out.write("                    <li><a class=\"facebook\" href=\"https://www.facebook.com/gritacademy\"><i class=\"facebook\"></i></a></li>\r\n");
      out.write("                    <li><a class=\"linkedin\" href=\"https://se.linkedin.com/school/grit-academy/\"><i class=\"linkedin\"></i></a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>");
      out.write("\r\n");
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
