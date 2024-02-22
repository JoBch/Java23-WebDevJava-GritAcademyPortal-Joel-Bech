/***
 TROR INTE VI SKA ANVÄNDA DENNA
 ***/
/*package Servlets;

import models.JavaBean;
import models.MySQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/Enroll")
public class EnrollServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, resp);
        JavaBean userBean = (JavaBean) req.getSession().getAttribute("userBean");
        System.out.println("ID: " + userBean.getId() + " UserType: "+ userBean.getUserType() +" StateType: "+userBean.getStateType() +" PrivilegeType: "+ userBean.getprivilegeType());

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JavaBean userBean = (JavaBean) req.getSession().getAttribute("userBean");
        System.out.println("ID: " + userBean.getId() + " UserType: "+ userBean.getUserType() +" StateType: "+userBean.getStateType() +" PrivilegeType: "+ userBean.getprivilegeType());
    }
}*/
