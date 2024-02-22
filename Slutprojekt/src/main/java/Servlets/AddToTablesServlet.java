package Servlets;

import models.MySQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

@WebServlet("/Add")
public class AddToTablesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String addWhat = req.getParameter("hiddenParameter");
        if (Objects.equals(addWhat, "stcourses")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromCourses");
            req.setAttribute("coursesData", data);
            req.getRequestDispatcher("/JSP/AddToLookupTable.jsp").forward(req, resp);
        } else if (Objects.equals(addWhat, "courses")) {
            req.getRequestDispatcher("JSP/AddCourses.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //retrieving data from loginForm
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String town = req.getParameter("town");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String YHP = req.getParameter("YHP");
        String description = req.getParameter("description");
        String id1 = req.getParameter("selectedId1");
        String id2 = req.getParameter("selectedId2");
        String whatTable = req.getParameter("whatTable");
        //Deciding what insert to do with the help of whatTable
        switch (whatTable) {
            case "student":
                MySQLConnector.getConnector().insertQuery("insertIntoStudents", fname, lname, town, email, phone, username, password, "S", "S", "S", "S", "S", "S", "S");
                selectQueryAndForward("allFromStudents", "JSP/AddTeacherStudent.jsp", req, resp);

                break;
            case "teacher":
                MySQLConnector.getConnector().insertQuery("insertIntoTeachers", fname, lname, town, email, phone, username, password, "S", "S", "S", "S", "S", "S", "S");
                selectQueryAndForward("allFromTeachers", "JSP/AddTeacherStudent.jsp", req, resp);

                break;
            case "courses":
                MySQLConnector.getConnector().insertQuery("insertIntoCourses", name, YHP, description, "S", "I", "S");
                selectQueryAndForward("allFromCourses", "JSP/AddCourses.jsp", req, resp);

                break;
            case "students_courses":
                MySQLConnector.getConnector().insertQuery("insertIntoStudentsCourses", id1, id2, "I", "I");
                selectQueryAndForward("selectStudentsCourses", "JSP/AddToLookupTable.jsp", req, resp);

                break;
            case "teachers_courses":
                MySQLConnector.getConnector().insertQuery("insertIntoTeachersCourses", id1, id2, "I", "I");
                selectQueryAndForward("selectTeachersCourses", "JSP/AddToLookupTable.jsp", req, resp);
                break;
        }
    }

    //Just a small method to fetch the attributes needed to populate the chosen session attribute and then redirect user to correct JSP
    private void selectQueryAndForward(String queryName, String destinationJSP, HttpServletRequest req, HttpServletResponse resp) {
        LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery(queryName);
        req.setAttribute("addTableData", data);
        try {
            req.getRequestDispatcher(destinationJSP).forward(req, resp);
        } catch (ServletException | IOException e) {
            //Handle exception appropriately
            e.printStackTrace();
        }
    }
}
