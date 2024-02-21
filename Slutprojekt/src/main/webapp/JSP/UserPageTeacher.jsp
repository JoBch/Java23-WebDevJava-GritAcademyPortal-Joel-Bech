<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 2024-02-19
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Välkommen Lärare</title>
    <%@include file="NavBarTeacher.jsp"%>
    <link rel="stylesheet" href="../CSS/Style.css">
</head>
<body>
<h1>Välkommen LÄRARE Grit Academy</h1>
<h3>${param.message}</h3>
<table class="table">
    <c:forEach items="${userBean.data}" var="dataPunkt" varStatus="loop">
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
<form action="/Attendance" method="post">
    First name: <input name="fname" type="text">
    Last name: <input name="lname" type="text">
    <input name="showStudents" type="submit">
</form>
<%@include file="Footer.jsp"%>
</body>
</html>
