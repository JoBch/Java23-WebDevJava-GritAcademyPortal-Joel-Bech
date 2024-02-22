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

@WebServlet("/logout")
public class LogoutServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.getRequestDispatcher("JSP/AddTeacherStudent.jsp").forward(req, response);
        JavaBean userBean = (JavaBean) req.getSession().getAttribute("userBean");
        System.out.println("ID: " + userBean.getId() + " UserType: "+ userBean.getUserType() +" StateType: "+userBean.getStateType() +" PrivilegeType: "+ userBean.getprivilegeType());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("userBean") != null /*&& req.getParameter("logout") != null*/){
            System.out.println("Logging out user: " + req.getSession().getAttribute("userBean"));
            req.getSession().setAttribute("userBean", null);
            req.getSession().setMaxInactiveInterval(0);
            req.getSession().invalidate();

        }
        //JavaBean userBean = (JavaBean) req.getSession().getAttribute("userBean");
        //System.out.println("ID: " + userBean.getId() + " UserType: "+ userBean.getUserType() +" StateType: "+userBean.getStateType() +" PrivilegeType: "+ userBean.getprivilegeType());
        req.getRequestDispatcher("JSP/Index.jsp").forward(req, resp);
    }
}