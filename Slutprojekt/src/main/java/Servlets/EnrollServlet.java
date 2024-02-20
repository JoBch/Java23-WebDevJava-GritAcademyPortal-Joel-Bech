package Servlets;

import models.JavaBean;
import models.MySQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/Enroll")
public class EnrollServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("user_type") + " " + req.getParameter("fname") + " " +  req.getParameter("lname") +  " " + req.getParameter("town") +  " " + req.getParameter("email") +  " " + req.getParameter("phone") + " " +  req.getParameter("username") + " " +  req.getParameter("password"));
    }
}
