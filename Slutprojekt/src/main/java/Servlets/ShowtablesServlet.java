package Servlets;

import models.JavaBean;
import models.MySQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;

@WebServlet("/Show")
public class ShowtablesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JavaBean userBean = (JavaBean) request.getSession().getAttribute("userBean");
        System.out.println("ID: " + userBean.getId() + " UserType: "+ userBean.getUserType() +" StateType: "+userBean.getStateType() +" PrivilegeType: "+ userBean.getprivilegeType());
        request.getRequestDispatcher("JSP/DisplayStudents.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JavaBean userBean = (JavaBean) req.getSession().getAttribute("userBean");
        System.out.println("ID: " + userBean.getId() + " UserType: "+ userBean.getUserType() +" StateType: "+userBean.getStateType() +" PrivilegeType: "+ userBean.getprivilegeType());

        resp.setContentType("text/html");
        //retrieving data from loginForm
        String whatTable = req.getParameter("whatTableShow");
        System.out.println(whatTable);

        //comparing data with DB student or teacher
        if (whatTable.equals("student")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromStudents");
            req.setAttribute("showTableData", data);
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req,resp);

        }else if (whatTable.equals("teacher")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromTeachers");
            req.setAttribute("showTableData", data);
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req,resp);

        }else if (whatTable.equals("courses")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromCourses");
            req.setAttribute("showTableData", data);
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req,resp);

        }else if (whatTable.equals("students_courses")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectStudentsCourses");
            req.setAttribute("showTableData", data);
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req,resp);

        }else if (whatTable.equals("teachers_courses")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectTeachersCourses");
            req.setAttribute("showTableData", data);
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req, resp);
        }
    }
}
