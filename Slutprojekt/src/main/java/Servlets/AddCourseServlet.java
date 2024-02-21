package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Courses")
public class AddCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("JSP/Courses.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("JSP/UserPageStudent.jsp").forward(req, resp);
        String name = req.getParameter("name");
        String yhp = req.getParameter("yhp");
        String description = req.getParameter("description");
        System.out.println("Kurs: " + name + ", YHP= " + yhp + ", innehåller " + description);

    }
}
