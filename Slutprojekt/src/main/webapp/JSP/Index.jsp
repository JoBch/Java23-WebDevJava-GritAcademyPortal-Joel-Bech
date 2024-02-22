<%--
  Created by IntelliJ IDEA.
  User: joelb
  Date: 2024-02-16
  Time: 07:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grit Academy Portal</title>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <link rel="stylesheet" href="../CSS/Style.css">
    <link rel="stylesheet" media="screen" href="https://fontlibrary.org//face/lato" type="text/css"/>
</head>
<%@include file="NavbarStudent.jsp" %>
<body class="body">

<h1>Hello User!</h1>
<h5>Please log in to the database to be able to display the information in the tables.</h5>
<a href="/login">Login</a>
</body>
</html>

