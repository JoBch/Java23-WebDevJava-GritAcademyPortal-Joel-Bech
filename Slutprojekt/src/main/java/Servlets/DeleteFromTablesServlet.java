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

@WebServlet("/Delete")
public class DeleteFromTablesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req, resp);
        JavaBean userBean = (JavaBean) req.getSession().getAttribute("userBean");
        System.out.println("ID: " + userBean.getId() + " UserType: " + userBean.getUserType() + " StateType: " + userBean.getStateType() + " PrivilegeType: " + userBean.getprivilegeType());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        //retrieving data from loginForm
        String id = req.getParameter("selectedId1");
        String whatTableDelete = req.getParameter("whatTableDelete");
        System.out.println("id:  " + id);

        //comparing whatTable to determine where we want to send the user and what we want to delete
        switch (whatTableDelete) {
            case "student":
                MySQLConnector.getConnector().insertQuery("deleteFromStudents", id, "I");
                fetchDataAndForward("allFromStudents", req, resp);
                break;
            case "teacher":
                MySQLConnector.getConnector().insertQuery("deleteFromTeachers", id, "I");
                fetchDataAndForward("allFromteachers", req, resp);
                break;
            case "courses":
                MySQLConnector.getConnector().insertQuery("deleteFromCourses", id, "I");
                fetchDataAndForward("allFromCourses", req, resp);
                break;
            case "students_courses":
                MySQLConnector.getConnector().insertQuery("deleteFromStudentsCourses", id, "I");
                fetchDataAndForward("selectStudentCourses", req, resp);
                break;
            case "teachers_courses":
                MySQLConnector.getConnector().insertQuery("deleteFromTeachersCourses", id, "I");
                fetchDataAndForward("selectTeacherCourses", req, resp);
                break;
        }
    }

    //Just a small method to fetch the attributes needed to populate the chosen session attribute and then redirect user to correct JSP
    private void fetchDataAndForward(String queryName, HttpServletRequest req, HttpServletResponse resp) {
        LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery(queryName);
        req.setAttribute("showTableData", data);
        try {
            req.getRequestDispatcher("JSP/DeleteFromTable.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            //Handle exception appropriately
            e.printStackTrace();
        }
    }

}
