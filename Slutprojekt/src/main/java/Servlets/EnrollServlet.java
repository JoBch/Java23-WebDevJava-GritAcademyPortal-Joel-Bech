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

@WebServlet("/Enroll")
public class EnrollServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

/*            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("selectAllFromStudents");
            JavaBean usersBean = new JavaBean(id, fname, lname, username, password);
            usersBean.setData(data);

            request.getSession().setAttribute("usersBean", usersBean);
            System.out.println(((JavaBean)(request.getSession().getAttribute("usersBean"))).getData());

            LinkedList<String[]> data1 = MySQLConnector.getConnector().selectQuery("selectAllFromCourses");
            JavaBean usersBean1 = new JavaBean(id, fname, lname, username, password);
            usersBean1.setData1(data1);

            request.getSession().setAttribute("coursesBean", usersBean1);
            System.out.println(((JavaBean)(request.getSession().getAttribute("coursesBean"))).getData1());
            request.getRequestDispatcher("JSP/UserPage.jsp").forward(request, response);*/

    }

    /*protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/gritacademy";

            HttpSession session = req.getSession(false);
            String user = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            Connection connection = DriverManager.getConnection(url);

            out.println("<link rel=\"stylesheet\" href=\"/style.css\">");
            out.println("<html><body>");
            out.println("<header class=\"headerLinks\">"
                    + "<div>"
                    + "<a href=\"Students\">Click here to add a student to the DB.</a>"
                    + "</div>"
                    + "<div>"
                    + "<a href=\"Courses\">Click here to add a course to the DB.</a>"
                    + "</div>"
                    + "<div>"
                    + "<a href=\"Attendance\">Click here to check who is studying what course.</a>"
                    + "</div>"
                    + "<div>"
                    + "<a href=\"index.html\">Home Page</a>"
                    + "</div>"
                    + "</header>"
            );
            out.println("<h1>Hello user. Insert name of student and course below to enroll students in a course.</h1>");
            out.println("<form method =\"post\" >"
                    + "First name: <input type=\"text\" name=\"fname\"><br>"
                    + "Last name: <input type=\"text\" name=\"lname\"><br>"
                    + "Course name: <input type=\"text\" name=\"course\"><br><br>"
                    + "<input type=\"submit\" value=\"Submit\"><br>"
                    + "</form>"
                    + "<form action=\"Enroll\" method =\"get\" >"
                    + "<input type=\"submit\" value=\"Display Students and Courses\"><br>"
                    + "</form>");

            String sql1 = "INSERT INTO attendance (studentsid, subjectsid) SELECT s.id AS studentsid, c.id AS subjectsid FROM students s " +
                    "JOIN courses c ON s.fname = ? AND s.lname = ? AND c.name = ?";

            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setString(1, req.getParameter("fname"));
            statement1.setString(2, req.getParameter("lname"));
            statement1.setString(3, req.getParameter("course"));

            int resultRows = statement1.executeUpdate();

            if (resultRows > 0) {
                out.println("<p><span style= \"background-color:green\">Student was added to the course!</span></p>");
            } else {
                out.println("<p><span style= \"background-color:red\">No student was added to a course!</span></p>");
            }

            String sql = "SELECT s.fname, s.lname, c.name AS coursename, c.YHP, c.description FROM students s JOIN attendance a " +
                    "ON a.studentsid = s.id JOIN courses c ON a.subjectsid = c.id ORDER BY s.fname";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            out.println("<table class=\"table\">");
            out.println("<tr><th>First Name</th><th>Last Name</th><th>Course Name</th><th>YHP</th><th>Description</th></tr>");

            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString(1) + "</td>");
                out.println("<td>" + resultSet.getString(2) + "</td>");
                out.println("<td>" + resultSet.getString(3) + "</td>");
                out.println("<td>" + resultSet.getInt(4) + "</td>");
                out.println("<td>" + resultSet.getString(5) + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            out.println("<p><span style= \"background-color:red\">Error: " + e.getMessage() + "</span></p>");
        } finally {
            out.close();
        }
    }*/
}
