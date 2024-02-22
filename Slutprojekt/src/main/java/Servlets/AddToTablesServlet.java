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

@WebServlet("/Add")
public class AddToTablesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String addWhat = req.getParameter("hiddenParameter");
        if (Objects.equals(addWhat, "courses")) {
            req.getRequestDispatcher("JSP/AddCourses.jsp").forward(req, resp);
        } else if (Objects.equals(addWhat, "stcourses")) {
            req.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, resp);
        }

        JavaBean userBean = (JavaBean) req.getSession().getAttribute("userBean");
        System.out.println("ID: " + userBean.getId() + " UserType: " + userBean.getUserType() + " StateType: " + userBean.getStateType() + " PrivilegeType: " + userBean.getprivilegeType());

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JavaBean userBean = (JavaBean) req.getSession().getAttribute("userBean");
        System.out.println("ID: " + userBean.getId() + " UserType: " + userBean.getUserType() + " StateType: " + userBean.getStateType() + " PrivilegeType: " + userBean.getprivilegeType());

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

        System.out.println(whatTable + "     " + fname + "   " + lname + "    " + username);

        //comparing data with DB student or teacher
        if (whatTable.equals("student")) {
            MySQLConnector.getConnector().insertQuery("insertIntoStudents", fname, lname, town, email, phone, username, password, "S", "S", "S", "S", "S", "S", "S");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromStudents");
            req.setAttribute("addTableData", data);
            req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, resp);

        } else if (whatTable.equals("teacher")) {
            MySQLConnector.getConnector().insertQuery("insertIntoTeachers", fname, lname, town, email, phone, username, password, "S", "S", "S", "S", "S", "S", "S");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromTeachers");
            req.setAttribute("addTableData", data);
            req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, resp);

        } else if (whatTable.equals("courses")) {
            MySQLConnector.getConnector().insertQuery("insertIntoCourses", name, YHP, description, "S", "I", "S");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromCourses");
            req.setAttribute("addTableData", data);
            req.getRequestDispatcher("JSP/AddCourses.jsp").forward(req, resp);

        } else if (whatTable.equals("students_courses")) {
            MySQLConnector.getConnector().insertQuery("insertIntoStudentsCourses", id1, id2, "I", "I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectStudentsCourses");
            req.setAttribute("addTableData", data);
            req.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(req, resp);

        } else if (whatTable.equals("teachers_courses")) {
            MySQLConnector.getConnector().insertQuery("insertIntoTeachersCourses", id1, id2, "I", "I");
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectTeachersCourses");
            req.setAttribute("addTableData", data);
            req.getRequestDispatcher("JSP/AddToLookupTable.jsp").forward(req, resp);
        }
    }
}
