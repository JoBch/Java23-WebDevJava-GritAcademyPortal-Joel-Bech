package Servlets;

import models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allFromCourses");
        req.getSession().setAttribute("data", data);
        req.getRequestDispatcher("JSP/Login.jsp").forward(req, response);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        //retrieving data from loginForm
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("user_type");
        req.setAttribute("username", username);
        req.setAttribute("password", password);

        System.out.println(username + " " + password + " " + userType);

        //comparing data with DB student or teacher
        if (userType.equals("student")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("studentLogin", username, password);
            //data object always returns row with column names
            if (data.size() > 1) {
                req.getSession().setMaxInactiveInterval(360);
                JavaBean userBean = new JavaBean((data.get(1))[0], USER_TYPE.student, PRIVILEGE_TYPE.user, STATE_TYPE.confirmed);
                req.getSession().setAttribute("userBean", userBean);
                userBean.setData(data);
                //Creating a bean that has a table for all the courses
                /***Kanske inte behövs? Men om vi skiter i det tänk på att nåt table är kopplat till det***/
                LinkedList<String[]> table = MySQLConnector.getConnector().selectQuery("allFromCourses", username, password);
                JavaBean coursesBean = new JavaBean();
                coursesBean.setData(table);
                req.getSession().setAttribute("coursesBean", coursesBean);
                //Printing out the bean
                req.getRequestDispatcher("JSP/UserPageStudent.jsp").forward(req, resp);
                System.out.println("ID: " + userBean.getId() + " UserType: " + userBean.getUserType() + " StateType: " + userBean.getStateType() + " PrivilegeType: " + userBean.getprivilegeType());
            } else {//Maybe put down some sort of errormessage aswell?
                req.getRequestDispatcher("JSP/Login.jsp").forward(req, resp);
            }
        } else if (userType.equals("teacher")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("teachersLogin", username, password);
            //data object always returns row with column names
            if (data.size() > 1) {
                req.getSession().setMaxInactiveInterval(360);
                JavaBean userBean = new JavaBean((data.get(1))[0], USER_TYPE.teacher, PRIVILEGE_TYPE.admin, STATE_TYPE.confirmed);
                req.getSession().setAttribute("userBean", userBean);
                userBean.setData(data);
                //Creating a bean that has a table for all the courses
                /***Kanske inte behövs? Men om vi skiter i det tänk på att nåt table är kopplat till det***/
                LinkedList<String[]> table = MySQLConnector.getConnector().selectQuery("allFromCourses");
                JavaBean coursesBean = new JavaBean();
                coursesBean.setData(table);
                req.getSession().setAttribute("coursesBean", coursesBean);
                //Printing out the bean
                System.out.println("ID: " + userBean.getId() + " UserType: " + userBean.getUserType() + " StateType: " + userBean.getStateType() + " PrivilegeType: " + userBean.getprivilegeType());
                req.getRequestDispatcher("JSP/UserPageTeacher.jsp").forward(req, resp);
            } else {//Maybe put down some sort of errormessage aswell?
                req.getRequestDispatcher("JSP/Login.jsp").forward(req, resp);
            }
        }

    }

}