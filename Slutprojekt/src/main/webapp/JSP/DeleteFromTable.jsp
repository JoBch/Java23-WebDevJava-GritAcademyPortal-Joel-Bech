<%--
  Created by IntelliJ IDEA.
  User: joelb
  Date: 2024-02-21
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ta bort student/lärare/kurs</title>
    <link rel="stylesheet" href="../CSS/Style.css"></head>
<body>
<%@include file="NavBarTeacher.jsp"%>
<h5>Choose what table you would like to delete from.</h5>
<%--
Denna delen används för att välja vilket table vi vill visa
--%>
<form action="/Show" method="post">
<select id="whatTableShow" name="whatTableShow">
    <option value="student">Student</option>
    <option value="teacher">Teacher</option>
    <option value="courses">Courses</option>
    <option value="students_courses">Student Courses</option>
    <option value="teachers_courses">Teacher Courses</option>
    <input type="hidden" name="hiddenField" value="deleteFromTable">

</select>
    <!-- Add a submit button to submit the selected ID value -->
    <input type="submit" value="Submit">
</form>
<form action="/Delete" method="post">
    <table class="table">
        <c:forEach items="${showTableData}" var="dataPunkt" varStatus="loop">
            <c:if test="${loop.index == 0}">
                <tr>
                    <c:forEach items="${dataPunkt}" var="columnName">
                        <th>${columnName}</th>
                    </c:forEach>
                    <th>Select</th>
                </tr>
            </c:if>
            <c:if test="${loop.index != 0}">
                <tr>
                    <c:forEach items="${dataPunkt}" var="columnValue">
                        <td>${columnValue}</td>
                    </c:forEach>
                    <td><input type="radio" name="selectedId" value="${dataPunkt[0]}"></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <br>
<%--
    Denna delen används för att selecta från vilket table vi vill deleta, kanske sätta ihop med selecten där uppe?
--%>
    <label for=whatTableDelete>Vilken tabell vill du radera ifrån?</label><br>
    <select id="whatTableDelete" name="whatTableDelete">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
        <option value="courses">Courses</option>
        <option value="students_courses">Student Courses</option>
        <option value="teachers_courses">Teacher Courses</option>
    </select>
    <br>
    <!-- Add a submit button to submit the selected ID value -->
    <input type="submit" value="Delete User">
</form>
</body>
<%@include file="Footer.jsp"%>
</html>
