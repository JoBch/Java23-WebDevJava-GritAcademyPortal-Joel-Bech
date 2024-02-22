<%--
  Created by IntelliJ IDEA.
  User: joelb
  Date: 2024-02-16
  Time: 07:26
  To change this template use File | Settings | File Templates.
  Om taggen börjar med <c: så är det javakod, annars är det vanlig HTML kod
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Välkommen Student</title>
    <%@include file="NavbarStudent.jsp"%>
    <link rel="stylesheet" href="../CSS/Style.css">
</head>
<%--Denna biten är lite magisk och jag förstår mig inte riktigt på den men den är cool som fan. Skapar dynamiskt ALLA headers till vårt table
och populerar dem med data därefter.--%>
<body>
<h1>Välkommen STUDENT Grit Academy</h1>
<h3>${param.message}</h3>
<table class="table">
    <c:forEach items="${loginData}" var="dataPunkt" varStatus="loop">
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
            </tr>
        </c:if>
    </c:forEach>
</table>
<%@include file="Footer.jsp"%>
</body>
</html>