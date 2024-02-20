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
    <%@include file="HeaderLinks.jsp"%>
    <link rel="stylesheet" href="../CSS/Style.css">
</head>
<body>
<form action="/Delete" method="post">
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
    </select>
    <input name="add" type="submit">
</form>
<table class="table">
    <c:forEach items="${data}" var="dataPunkt" varStatus="loop">
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
</body>
</html>
