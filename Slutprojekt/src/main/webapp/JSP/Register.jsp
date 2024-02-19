<%--
  Created by IntelliJ IDEA.
  User: joelb
  Date: 2024-02-16
  Time: 07:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="HeaderLinks.jsp"%>
    <link rel="stylesheet" href="../CSS/Style.css">
</head>
<body>
    <h1>Följ instruktionerna för att lägga till en ny student</h1>
    <form style=text-align:center; action=AddStudentServlet\ method=POST>
                    <label for=fname>Skriv in förnamn:</label><br>
                    <input type=text id=fname name=fname required><br>
                    <label for=lname>Skriv in efternamn:</label><br>
                    <input type=text id=lname name=lname required><br>
                    <label for=town>Vart bor studenten:</label><br>
                    <input type=text id=town name=town required><br>
                    <label for=hobby>Skriv in Hobby:</label><br>
                    <input type=text id=hobby name=hobby required><br>

                    <label for=username>Skriv in önskat användarnamn:</label><br>
                    <input type=text id=username name=username required><br>

                    <label for=password>Skriv in önskat lösenord:</label><br>
                    <input type=text id=password name=password required><br>
                    <input type=submit value=Submit>
                    </form>
</body>
</html>
