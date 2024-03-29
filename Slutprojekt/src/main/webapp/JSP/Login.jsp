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
    <link rel="stylesheet" href="../CSS/Style.css">
    <link rel="stylesheet" media="screen" href="https://fontlibrary.org//face/lato" type="text/css"/>
    <title>Logga in Grit Academy Portal</title>
</head>
<body>
<%@include file="NavbarInlogg.jsp" %>
<h1>Hallå du</h1>
<h5>Välkommen till Grit Portalen, det enda du behöver gällande Grit Academy</h5>
<form action="/login" method="post">
    Username: <input name="username" type="text">
    <br>
    Password: <input name="password" type="password"><br><br>
    <label for="user_type">Lärare eller elev som loggar in?</label>
    <select id="user_type" name="user_type">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
    </select>
    <input name="login" type="submit" value="Logga in">
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
<%@include file="Footer.jsp" %>
</body>

</html>
