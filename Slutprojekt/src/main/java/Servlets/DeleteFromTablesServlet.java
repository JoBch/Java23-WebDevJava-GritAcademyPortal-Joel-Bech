package Servlets;

import models.MySQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/Delete")
public class DeleteFromTablesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.getRequestDispatcher("JSP/UserPageStudent.jsp").forward(req, resp);

        resp.setContentType("text/html");
        //retrieving data from loginForm
        String id = req.getParameter("selectedId");
        String whatTableDelete = req.getParameter("whatTableDelete");
        System.out.println("id:  " + id);

        //comparing data with DB student or teacher
        if (whatTableDelete.equals("student")) {
            MySQLConnector.getConnector().insertQuery("deleteFromStudents", id, "I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromStudents");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req,resp);

        }else if (whatTableDelete.equals("teacher")) {
            MySQLConnector.getConnector().insertQuery("deleteFromTeachers", id,"I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromTeachers");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req,resp);

        }else if (whatTableDelete.equals("courses")) {
            MySQLConnector.getConnector().insertQuery("deleteFromCourses", id,"I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromCourses");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req,resp);

        }else if (whatTableDelete.equals("students_courses")) {
            MySQLConnector.getConnector().insertQuery("deleteFromStudentsCourses", id,"I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectStudentCourses");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req,resp);

        }else if (whatTableDelete.equals("teachers_courses")) {
            MySQLConnector.getConnector().insertQuery("deleteFromTeachersCourses", id,"I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectTeacherCourses");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req,resp);
        }
    }
}
