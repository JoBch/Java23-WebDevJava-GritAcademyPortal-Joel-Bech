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
    <title>Kurser</title>
    <link rel="stylesheet" href="../CSS/Style.css">
</head>
<body>
<!--
<%@include file="HeaderLinks.jsp"%>
-->
<%@include file="navbar.jsp"%>
<%@include file="Footer.jsp"%>
<form id="addStudent" action=Courses method=POST>
    <label for="name">Skriv in kursens namn:</label><br>
    <input type=text id=name name=name required><br>
    <label for=yhp>Skriv in Yrkeshögskolepoäng:</label><br>
    <input type=text id=yhp name=yhp required><br>
    <label for=description>Vad innehåller kursen?</label><br>
    <input type=text id=description name=description required><br>

    <input type=submit value=Submit>
</form>

</body>
</html>
