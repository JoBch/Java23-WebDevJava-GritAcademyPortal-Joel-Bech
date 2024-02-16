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
    <title>Title</title>
    <%@include file="HeaderLinks.jsp"%>
    <link rel="stylesheet" href="../CSS/Style.css"></head>
<body>
<h1>Hello User!</h1>
<h5>Please log in to the database to be able to display the information in the tables.</h5>
<form action="/login" method="post">
    Username: <input name="username" type="text">
    <br>
    Password: <input name="password" type="password">
    <br><br>
    <input name="login" type="submit">
</form>
</body>
</html>
