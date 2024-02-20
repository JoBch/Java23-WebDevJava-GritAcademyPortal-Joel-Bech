/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-02-20 12:14:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddTeacherStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/JSP/NavBarTeacher.jsp", Long.valueOf(1708430463634L));
    _jspx_dependants.put("/JSP/Footer.jsp", Long.valueOf(1708338867629L));
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../CSS/Style.css\">\r\n");
      out.write("    <title>Lägg till ny student eller lärare</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<navbar class=\"mainNavbarStudent\">\r\n");
      out.write("    <banner>\r\n");
      out.write("        <h1>GRIT ACADEMY</h1>\r\n");
      out.write("        <!-- Vill vi få in namnet på den inloggade här i navbar titel kanske?-->\r\n");
      out.write("    </banner>\r\n");
      out.write("\r\n");
      out.write("    <nav>\r\n");
      out.write("        <a href=\"/\">HOME</a>\r\n");
      out.write("        <a href=\"/Courses\">COURSES</a>\r\n");
      out.write("        <a href=\"/Login\">LOGIN</a>\r\n");
      out.write("        <a href=\"/UserPage\">USERPAGE</a>\r\n");
      out.write("    </nav>\r\n");
      out.write("</navbar>");
      out.write("\r\n");
      out.write("<h1>Hello User!</h1>\r\n");
      out.write("<h5>Här kan du lägga till ny lärare eller student</h5>\r\n");
      out.write("<div>\r\n");
      out.write("<form class=\"AddForm\" action=\"/Enroll\" method=\"post\">\r\n");
      out.write("    <p class=\"ParagraphForm\">\r\n");
      out.write("        <label class=\"FormCell\" for=\"user_type\">Choose a user type:</label>\r\n");
      out.write("        <select id=\"user_type\" name=\"user_type\">\r\n");
      out.write("            <option value=\"student\">Student</option>\r\n");
      out.write("            <option value=\"teacher\">Teacher</option>\r\n");
      out.write("        </select><br>\r\n");
      out.write("    </p>\r\n");
      out.write("    <p class=\"ParagraphForm\">\r\n");
      out.write("        <label class=\"FormCell\" for=fname>Förnamn</label>\r\n");
      out.write("        <input class=\"FormCell\" name=\"fname\" id=\"fname\" type=\"text\"><br>\r\n");
      out.write("    </p>\r\n");
      out.write("    <p class=\"ParagraphForm\">\r\n");
      out.write("        <label class=\"FormCell\" for=lname>Efternamn</label>\r\n");
      out.write("        <input class=\"FormCell\" name=\"lname\" id=\"lname\" type=\"text\"><br>\r\n");
      out.write("    </p>\r\n");
      out.write("    <p class=\"ParagraphForm\">\r\n");
      out.write("        <label class=\"FormCell\" for=town>Stad</label>\r\n");
      out.write("        <input class=\"FormCell\" name=\"town\" id=\"town\" type=\"text\"><br>\r\n");
      out.write("    </p>\r\n");
      out.write("    <p class=\"ParagraphForm\">\r\n");
      out.write("        <label class=\"FormCell\" class=\"FormCell\" for=email>Email</label>\r\n");
      out.write("        <input class=\"FormCell\" class=\"FormCell\" name=\"email\" id=\"email\" type=\"text\"><br>\r\n");
      out.write("    </p>\r\n");
      out.write("    <p class=\"ParagraphForm\">\r\n");
      out.write("        <label class=\"FormCell\" for=phone>Telefonnummer</label>\r\n");
      out.write("        <input class=\"FormCell\" name=\"phone\" id=\"phone\" type=\"text\"><br>\r\n");
      out.write("    </p>\r\n");
      out.write("    <p class=\"ParagraphForm\">\r\n");
      out.write("        <label class=\"FormCell\" for=username>Username</label>\r\n");
      out.write("        <input class=\"FormCell\" name=\"username\" id=\"username\" type=\"text\"><br>\r\n");
      out.write("    </p>\r\n");
      out.write("    <p class=\"ParagraphForm\">\r\n");
      out.write("        <label class=\"FormCell\" for=password>Lösenord</label>\r\n");
      out.write("        <input class=\"FormCell\" name=\"password\" id=\"password\" type=\"text\"><br>\r\n");
      out.write("    </p>\r\n");
      out.write("\r\n");
      out.write("    <input name=\"login\" type=\"submit\">\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Site footer -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../CSS/FooterStyle.css\">\r\n");
      out.write("<footer class=\"site-footer\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-sm-12 col-md-6\">\r\n");
      out.write("                <h6>Om oss</h6>\r\n");
      out.write("                <p class=\"text-justify\">Detta är en portal för <i>studenter och lärare </i> på Grit Academy. För mer info om att gå med i kurser och liknande, ta kontakt med Admin på skolan</p>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-xs-6 col-md-3\">\r\n");
      out.write("                <ul class=\"footer-links\">\r\n");
      out.write("                    <li><a href=\"https://gritacademy.se/\">Besök vår hemsida för mer info</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <hr>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-8 col-sm-6 col-xs-12\">\r\n");
      out.write("                <p class=\"copyright-text\">Copyright &copy; 2017 All Rights Reserved by\r\n");
      out.write("                    <a href=\"https://www.facebook.com/andreas.martensson.12/\">Andreas Jabrell</a> och\r\n");
      out.write("                    <a href=\"https://www.facebook.com/joel.bech.9\">Joel Bech</a>.\r\n");
      out.write("                </p>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-4 col-sm-6 col-xs-12\">\r\n");
      out.write("                <ul class=\"social-icons\">\r\n");
      out.write("                    <li><a class=\"facebook\" href=\"https://www.facebook.com/gritacademy\"><i class=\"fa fa-facebook\"></i></a></li>\r\n");
      out.write("                    <li><a class=\"linkedin\" href=\"https://se.linkedin.com/school/grit-academy/\"><i class=\"fa fa-linkedin\"></i></a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>");
      out.write("\r\n");
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