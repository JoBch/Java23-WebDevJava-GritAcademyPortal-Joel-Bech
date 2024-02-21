package Servlets;

import models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/Add")
public class AddToTablesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        //retrieving data from loginForm
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String town = req.getParameter("town");
        String hobby = req.getParameter("hobby");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String YHP = req.getParameter("YHP");
        String description = req.getParameter("description");
        String privilage_type = req.getParameter("privilage_type");
        String whatTable = req.getParameter("whatTable");

        System.out.println(whatTable + "     " + fname +"   "+ lname + "    " + username);

        //comparing data with DB student or teacher
        if (whatTable.equals("student")) {
            MySQLConnector.getConnector().insertQuery("insertIntoStudents", fname, lname, town, hobby, email, phone, username, password,"S","S","S","S","S","S","S","S");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromStudents");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req,resp);

        }else if (whatTable.equals("teacher")) {
            MySQLConnector.getConnector().insertQuery("insertIntoTeachers",fname, lname, town, email, phone, username, password, privilage_type, "S","S","S","S","S","S","S","S");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromTeachers");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req,resp);

        }else if (whatTable.equals("courses")) {
            MySQLConnector.getConnector().insertQuery("insertIntoCourses", name, YHP, description, "S", "I", "S");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromCourses");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req,resp);

        }else if (whatTable.equals("students_courses")) {
            MySQLConnector.getConnector().insertQuery("insertIntoStudentsCourses", fname, lname, name, "S", "S", "S");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectStudentCourses");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req,resp);

        }else if (whatTable.equals("teachers_courses")) {
            MySQLConnector.getConnector().selectQuery("insertIntoTeachersCourses", fname, lname, name, "S", "S", "S");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromStudents");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req,resp);
        }
    }
}
