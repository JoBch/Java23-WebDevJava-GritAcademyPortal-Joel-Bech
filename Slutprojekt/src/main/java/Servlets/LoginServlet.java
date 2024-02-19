package Servlets;

import models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = req.getSession(false);
        String user = (String) session.getAttribute("username");
        out.println("<link rel=\"stylesheet\" href=\"/style.css\">");
        out.println("<html><body>");
        out.println("<header class=\"headerLinks\">"
                + "<div>"
                + "<a href=\"Attendance\">Click here to check who is studying what course.</a>"
                + "</div>"
                + "<div>"
                + "<a href=\"Courses\">Click here to add a course to the DB.</a>"
                + "</div>"
                + "<div>"
                + "<a href=\"Students\">Click here to add a student to the DB.</a>"
                + "</div>"
                + "<div>"
                + "<a href=\"Enroll\">Click here to enroll a student in a new course.</a>"
                + "</div>"
                + "<div>"
                + "<a href=\"index.html\">Home Page</a>"
                + "</div>"
                + "</header>"
        );
        out.println("<h2>Hello " + user + " from Java Servlet!</h2>");
        out.println(
                "<h2> välkommen" + user + "</h2>" +
                        "</body>" +
                        "</html>");
        out.close();*/
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        //retrieving data from loginForm
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("user_type");

        System.out.println(username + " " + password + " " + userType);

        //comparing data with DB student or teacher
        if (userType.equals("student")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("studentLogin", username, password);
            //data object always returns row with column names
            if (data.size() > 1) {
                req.getSession().setMaxInactiveInterval(360);
                JavaBean userBean = new JavaBean((data.get(1))[0], USER_TYPE.student, PRIVILEGE_TYPE.user, STATE_TYPE.confirmed);
                req.getSession().setAttribute("userBean", userBean);
                req.getRequestDispatcher("/userPage").forward(req,resp);
            }else{//if login not found goes back to login form and sows a message
                req.getSession().setAttribute("errorMessage","Student not found");
                req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);
            }
        }else if (userType.equals("teacher")) {
            List data = MySQLConnector.getConnector().selectQuery("teacherLogin", username, password);
            //data object always returns row with column names
            if (data.size() > 1) {
                resp.getWriter().print("LOGGED IN - ");
                //TODO similar to the student code
            }else{
                req.getRequestDispatcher("JSP/login.jsp").forward(req,resp);
            }
        }

        //Input credentials to check
        /*String user = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(true);
        session.setAttribute("username", user);
        session.setAttribute("password", password);

        response.sendRedirect("/login");*/
    }


}