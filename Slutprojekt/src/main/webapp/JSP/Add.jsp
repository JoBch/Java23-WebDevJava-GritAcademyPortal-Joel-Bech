<%--
  Created by IntelliJ IDEA.
  User: joelb
  Date: 2024-02-20
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Shit</title>
    <%@include file="NavBarTeacher.jsp"%>
    <link rel="stylesheet" href="../CSS/Style.css">
</head>
<body>
<c:choose>
    <c:when test="${userBean.userType == 'student'}">
        <!-- Code to execute if the user is a student -->
        <p>The user is a student.</p>
    </c:when>
    <c:when test="${userBean.userType == 'teacher'}">
        <!-- Code to execute if the user is a teacher -->
        <p>The user is a teacher.</p>
    </c:when>
    <c:otherwise>
        <!-- Code to execute if none of the above conditions are true -->
        <p>The user's type is unknown.</p>
    </c:otherwise>
</c:choose>

<form action="/Add" method="post">
    id : <input name="id" type="text">
    fname : <input name="fname" type="text">
    lname : <input name="lname" type="text">
    town : <input name="town" type="text">
    <%--Use this textfield only for user--%>
    hobby : <input name="hobby" type="text">
    email : <input name="email" type="text">
    phone : <input name="phone" type="text">
    Username : <input name="username" type="text">
    Password : <input name="password" type="password">
    name : <input name="name" type="text">
    YHP : <input name="YHP" type="text">
    Description : <input name="description" type="password">
<%--Use this select only for teacher--%>
        <select id="privilage_type" name="privilage_type">
        <option value="admin">Admin</option>
        <option value="user">User</option>
    </select>
    <br><br>
    <label for="whatTable">Choose a user type:</label>
    <select id="whatTable" name="whatTable">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
        <option value="courses">Courses</option>
    </select>
    <input name="add" type="submit">
</form>
<form action="Delete" method="post">
    <table class="table">
        <tr>
            <!-- Specify the specific column headers you want to include based on their indexes -->
            <c:forEach items="${data}}" var="columnName" varStatus="loop">
            <c:if test="${loop.index == 0}">
        <tr>
            <c:forEach items="${dataPunkt}" var="columnName">
                <th>${columnName}</th>
            </c:forEach>
        </tr>
        </c:if>
        </c:forEach>
        </tr>
        <c:forEach items="${data}" var="dataPunkt" varStatus="loop">
            <c:if test="${loop.index != 0}">
                <tr>
                    <!-- Access specific column values based on their indexes -->
                    <td>${dataPunkt[1]}</td><td>${dataPunkt[2]}</td><td>${dataPunkt[4]}</td><td>${dataPunkt[5]}</td>
                    <td><input type="radio" name="selectedId" value="${dataPunkt[0]}"></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
<%--    <select id="whatTable" name="whatTable">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
    </select>--%>
    <!-- Add a submit button to submit the selected ID value -->
    <input type="submit" value="Submit">
</form>
<%@include file="Footer.jsp"%>
</body>
</html>
