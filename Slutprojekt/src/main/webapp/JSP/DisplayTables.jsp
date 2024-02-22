<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 2024-02-20
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../CSS/Style.css">
    <title>Visa studenter</title>
    <link rel="stylesheet" media="screen" href="https://fontlibrary.org//face/lato" type="text/css"/>
</head>

</head>
<body>
<%@include file="NavBarTeacher.jsp" %>
<h2>Välj vilken tabell du vill titta på</h2>
<h3>${param.message}</h3>
<form action="/Show" method="post">
    <select id="whatTableShow" name="whatTableShow">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
        <option value="courses">Courses</option>
        <option value="students_courses">Student Courses</option>
        <option value="teachers_courses">Teacher Courses</option>
    </select>
    <!-- Add a submit button to submit the selected ID value -->
    <input type="hidden" name="hiddenField" value="displayTables">
    <input type="submit" value="Show Table">
</form>
<table class="table">
    <c:forEach items="${showTableData}" var="dataPunkt" varStatus="loop">
        <c:if test="${loop.index == 0}">
            <tr>
                <c:forEach items="${dataPunkt}" var="columnName">
                    <th>${columnName}</th>
                </c:forEach>
            </tr>
        </c:if>
        <c:if test="${loop.index != 0}">
            <tr>
                <c:forEach items="${dataPunkt}" var="columnValue">
                    <td>${columnValue}</td>
                </c:forEach>
            </tr>
        </c:if>
    </c:forEach>
</table>
<br>
<%@include file="Footer.jsp" %>
</body>
</html>
