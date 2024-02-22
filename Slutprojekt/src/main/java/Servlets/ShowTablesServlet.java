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
public class ShowTablesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String addWhat = request.getParameter("hiddenParameter");
        if (Objects.equals(addWhat, "courses")) {
            request.getRequestDispatcher("JSP/AddCourses.jsp").forward(request, response);
        }else if (Objects.equals(addWhat, "stcourses")) {
            request.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("JSP/DisplayTables.jsp").forward(request, response);
        }
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
        LinkedList<String[]> data = new LinkedList<String[]>();
        //comparing data with DB student or teacher
        switch (whatTable) {
            case "student": {
                data = MySQLConnector.getConnector().selectQuery("allFromStudents");
                req.setAttribute("showTableData", data);
                data = MySQLConnector.getConnector().selectQuery("allFromCourses");
                req.setAttribute("coursesData", data);
                ifTeacher(req, resp, whatJSP);
                break;
            }
            case "teacher": {
                data = MySQLConnector.getConnector().selectQuery("allFromTeachers");
                req.setAttribute("showTableData", data);
                data = MySQLConnector.getConnector().selectQuery("allFromCourses");
                req.setAttribute("coursesData", data);
                ifTeacher(req, resp, whatJSP);
                break;
            }
            case "courses": {
                data = MySQLConnector.getConnector().selectQuery("allFromCourses");
                req.setAttribute("showTableData", data);
                ifTeachersCourses(req, resp, whatJSP, data);
                break;
            }
            case "students_courses": {
                data = MySQLConnector.getConnector().selectQuery("selectStudentsCourses");
                req.setAttribute("showTableData", data);
                ifTeachersCourses(req, resp, whatJSP, data);
                break;
            }
            case "teachers_courses": {
                data = MySQLConnector.getConnector().selectQuery("selectTeachersCourses");
                req.setAttribute("showTableData", data);
                ifTeachersCourses(req, resp, whatJSP, data);
                break;
            }
            case "students_coursesWhere": {
                data = MySQLConnector.getConnector().selectQuery("selectStudentsCoursesWhere", fname, lname);
                req.setAttribute("showTableData", data);
                req.getRequestDispatcher("JSP/UserPageTeacher.jsp").forward(req, resp);
                break;
            }
            case "teachers_coursesWhere": {
                data = MySQLConnector.getConnector().selectQuery("selectTeachersCoursesWhere", fname, lname);
                req.setAttribute("showTableData", data);
                req.getRequestDispatcher("JSP/UserPageTeacher.jsp").forward(req, resp);
                break;
            }
        }
    }

    //Handle some if-statements that determine which JSP the user gets redirected too
    private void ifTeacher(HttpServletRequest req, HttpServletResponse resp, String whatJSP) throws ServletException, IOException {
        if (Objects.equals(whatJSP, "displayTables")) {
            req.getRequestDispatcher("JSP/DisplayTables.jsp").forward(req, resp);
        } else if (Objects.equals(whatJSP, "lookupTable")) {
            req.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(req, resp);
        } else if (Objects.equals(whatJSP, "deleteFromTable")) {
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, resp);
        }
    }
    //Handle some if-statements that determine which JSP the user gets redirected too
    private void ifTeachersCourses(HttpServletRequest req, HttpServletResponse resp, String whatJSP, LinkedList<String[]> data) throws ServletException, IOException {
        req.setAttribute("showTableData", data);
        if (Objects.equals(whatJSP, "displayTables")) {
            req.getRequestDispatcher("JSP/DisplayTables.jsp").forward(req, resp);
        } else if (Objects.equals(whatJSP, "lookupTable")) {
            req.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(req, resp);
        } else if (Objects.equals(whatJSP, "deleteFromTable")) {
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req, resp);
        }
    }
}
