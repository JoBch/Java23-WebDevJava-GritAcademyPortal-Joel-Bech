package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("userBean") != null && req.getParameter("hiddenParameter") != null) {
            System.out.println("Logging out user: " + req.getSession().getAttribute("userBean"));
            req.getSession().setAttribute("userBean", null);
            req.getSession().setMaxInactiveInterval(0);
            req.getSession().invalidate();

        }
        req.getRequestDispatcher("JSP/Login.jsp").forward(req, resp);
    }
}