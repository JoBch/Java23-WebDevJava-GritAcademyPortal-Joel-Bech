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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

/*            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectAllFromStudents");
            JavaBean usersBean = new JavaBean(id, fname, lname, username, password);
            usersBean.setData(data);

            request.getSession().setAttribute("usersBean", usersBean);
            System.out.println(((JavaBean)(request.getSession().getAttribute("usersBean"))).getData());

            LinkedList<String[]> data1 = MySQLConnector.getConnector().selectQuery("selectAllFromCourses");
            JavaBean usersBean1 = new JavaBean(id, fname, lname, username, password);
            usersBean1.setData1(data1);

            request.getSession().setAttribute("coursesBean", usersBean1);
            System.out.println(((JavaBean)(request.getSession().getAttribute("coursesBean"))).getData1());
            request.getRequestDispatcher("JSP/UserPageStudent.jsp").forward(request, response);*/

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.getRequestDispatcher("JSP/UserPageStudent.jsp").forward(req, resp);

        resp.setContentType("text/html");
        //retrieving data from loginForm
        String id = req.getParameter("id");
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


        //comparing data with DB student or teacher
        if (whatTable.equals("student")) {
            MySQLConnector.getConnector().insertQuery("deleteFromStudents", id,"I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromStudents");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/Add.jsp").forward(req,resp);

        }else if (whatTable.equals("teacher")) {
            MySQLConnector.getConnector().insertQuery("deleteFromTeachers", id,"I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromTeachers");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/Add.jsp").forward(req,resp);

        }else if (whatTable.equals("courses")) {
            MySQLConnector.getConnector().insertQuery("deleteFromCourses", id,"I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromCourses");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/Add.jsp").forward(req,resp);

        }else if (whatTable.equals("students_courses")) {
            MySQLConnector.getConnector().insertQuery("deleteFromStudentsCourses", id,"I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectStudentCourses");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/Add.jsp").forward(req,resp);

        }else if (whatTable.equals("teachers_courses")) {
            MySQLConnector.getConnector().insertQuery("deleteFromTeachersCourses", id,"I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromStudents");
            req.setAttribute("data", data);
            req.getRequestDispatcher("JSP/Add.jsp").forward(req,resp);
        }
    }
}
