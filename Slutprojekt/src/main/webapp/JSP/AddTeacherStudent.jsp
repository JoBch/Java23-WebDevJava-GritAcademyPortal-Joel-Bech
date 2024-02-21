<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 2024-02-20
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../CSS/Style.css">
    <title>Lägg till ny student/lärare</title>

</head>
<body>
<%@include file="NavBarTeacher.jsp"%>
<h1>Hello User!</h1>
<h5>Här kan du lägga till ny lärare eller student</h5>
<div>
<form class="AddForm" action="/Add" method="post">
    <p class="ParagraphForm">
        <label class="FormCell" for="whatTable">Choose a user type:</label>
        <select id="whatTable" name="whatTable">
            <option value="student">Student</option>
            <option value="teacher">Teacher</option>
        </select><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=fname>Förnamn</label>
        <input class="FormCell" name="fname" id="fname" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=lname>Efternamn</label>
        <input class="FormCell" name="lname" id="lname" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=town>Stad</label>
        <input class="FormCell" name="town" id="town" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=hobby>Stad</label>
        <input class="FormCell" name="hobby" id="hobby" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell"  for=email>Email</label>
        <input class="FormCell"  name="email" id="email" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=phone>Telefonnummer</label>
        <input class="FormCell" name="phone" id="phone" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=username>Username</label>
        <input class="FormCell" name="username" id="username" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=password>Lösenord</label>
        <input class="FormCell" name="password" id="password" type="text"><br>
    </p>

    <input name="login" type="submit">

</form>
    <table class="table">
        <!-- Header Row -->
        <tr>
            <!-- Assuming contains column names -->
            <c:forEach items="${data[0]}" var="columnName">
                <th>${columnName}</th>
            </c:forEach>
        </tr>
        <!-- Data Rows -->
        <c:forEach items="${data}" var="dataPunkt" varStatus="loop">
            <c:if test="${loop.index != 0}">
                <tr>
                    <!-- Access specific column values based on their indexes -->
                    <c:forEach items="${dataPunkt}" var="columnValue">
                        <td>${columnValue}</td>
                    </c:forEach>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>
<%@include file="Footer.jsp"%>
</body>
</html>
