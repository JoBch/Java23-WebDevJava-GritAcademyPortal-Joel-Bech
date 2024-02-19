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

@WebServlet("/Attendance")
public class AttendanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
        int id =-1;
        String fname = "";
        String lname = "";
        String username = "";
        String password = "";

        LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectAllFromStudentsWhere" + );
        JavaBean usersBean = new JavaBean(id, fname, lname, username, password);
        usersBean.setData(data);


        req.getSession().setAttribute("usersBean", usersBean);
        System.out.println(((JavaBean)(req.getSession().getAttribute("usersBean"))).getData());
        req.getRequestDispatcher("JSP/UserPage.jsp").forward(req, resp);*/
/*
        System.out.println(req.getParameter("JSP/Register.jsp"));
        System.out.println(data);
        System.out.println(req.getParameter("fname"));*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        //retrieving data from loginForm
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");

        LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectStudentCourses", fname, lname);
        JavaBean userBean = new JavaBean();
        userBean.setData(data);

        req.getSession().setAttribute("userBean", userBean);
        req.getRequestDispatcher("JSP/UserPage.jsp").forward(req, resp);

    }

}
