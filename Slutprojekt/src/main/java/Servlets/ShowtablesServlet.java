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
import java.util.Objects;

@WebServlet("/Show")
public class ShowtablesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("JSP/DisplayTables.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JavaBean userBean = (JavaBean) req.getSession().getAttribute("userBean");
        System.out.println("ID: " + userBean.getId() + " UserType: " + userBean.getUserType() + " StateType: " + userBean.getStateType() + " PrivilegeType: " + userBean.getprivilegeType());

        resp.setContentType("text/html");
        //retrieving data from loginForm
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String whatTable = req.getParameter("whatTableShow");
        String whatJSP = req.getParameter("hiddenField");
        System.out.println(whatTable);

        //comparing data with DB student or teacher
        if (whatTable.equals("student")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromStudents");
            req.setAttribute("showTableData", data);
            if (Objects.equals(whatJSP, "displayTables")) {
                req.getRequestDispatcher("JSP/DisplayTables.jsp").forward(req, resp);
            } else if (Objects.equals(whatJSP, "lookupTable")) {
                req.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(req, resp);
            } else if (Objects.equals(whatJSP, "deleteFromTable")) {
                req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, resp);
            }
        } else if (whatTable.equals("teacher")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromTeachers");
            req.setAttribute("showTableData", data);
            if (Objects.equals(whatJSP, "displayTables")) {
                req.getRequestDispatcher("JSP/DisplayTables.jsp").forward(req, resp);
            } else if (Objects.equals(whatJSP, "lookupTable")) {
                req.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(req, resp);
            } else if (Objects.equals(whatJSP, "deleteFromTable")) {
                req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req, resp);
            }else {
                req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, resp);
            }

        } else if (whatTable.equals("courses")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromCourses");
            req.setAttribute("showTableData", data);
            if (Objects.equals(whatJSP, "displayTables")) {
                req.getRequestDispatcher("JSP/DisplayTables.jsp").forward(req, resp);
            } else if (Objects.equals(whatJSP, "lookupTable")) {
                req.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(req, resp);
            } else if (Objects.equals(whatJSP, "deleteFromTable")) {
                req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req, resp);
            }

        } else if (whatTable.equals("students_courses")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectStudentsCourses");
            req.setAttribute("showTableData", data);
            if (Objects.equals(whatJSP, "displayTables")) {
                req.getRequestDispatcher("JSP/DisplayTables.jsp").forward(req, resp);
            } else if (Objects.equals(whatJSP, "lookupTable")) {
                req.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(req, resp);
            } else if (Objects.equals(whatJSP, "deleteFromTable")) {
                req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req, resp);
            }
        } else if (whatTable.equals("teachers_courses")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectTeachersCourses");
            req.setAttribute("showTableData", data);
            if (Objects.equals(whatJSP, "displayTables")) {
                req.getRequestDispatcher("JSP/DisplayTables.jsp").forward(req, resp);
            } else if (Objects.equals(whatJSP, "lookupTable")) {
                req.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(req, resp);
            } else if (Objects.equals(whatJSP, "deleteFromTable")) {
                req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req, resp);
            }
        } else if (whatTable.equals("students_coursesWhere")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectStudentsCoursesWhere", fname, lname);
            req.setAttribute("showTableData", data);
            req.getRequestDispatcher("JSP/UserPageTeacher.jsp").forward(req, resp);

        } else if (whatTable.equals("teachers_coursesWhere")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectTeachersCoursesWhere", fname, lname);
            req.setAttribute("showTableData", data);
            req.getRequestDispatcher("JSP/UserPageTeacher.jsp").forward(req, resp);
        }
    }
}
