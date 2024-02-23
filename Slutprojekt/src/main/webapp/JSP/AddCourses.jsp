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
    <title>Lägg till ny kurs</title>
    <link rel="stylesheet" href="../CSS/Style.css">
    <link rel="stylesheet" media="screen" href="https://fontlibrary.org//face/lato" type="text/css"/>
    <%@include file="NavBarTeacher.jsp" %>
</head>
<body>

<div style="text-align: center; padding-top: 25px">
    <form class="AddForm" action=/Add method=POST>
        <label for="name">Skriv in kursens namn:</label><br>
        <input type=text id=name name=name required><br>
        <label for=yhp>Skriv in Yrkeshögskolepoäng:</label><br>
        <input type=number id=YHP name=YHP required><br>
        <label for=description>Vad innehåller kursen?</label><br>
        <input type=text id=description name=description required><br>
        <input type="hidden" name="whatTable" value="courses">
        <input type=submit value=Submit>
    </form>
</div>
<table class="table">
    <c:forEach items="${addTableData}" var="dataPunkt" varStatus="loop">
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
<%@include file="Footer.jsp" %>
</html>
