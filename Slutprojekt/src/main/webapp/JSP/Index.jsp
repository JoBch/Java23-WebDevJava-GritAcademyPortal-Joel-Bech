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
<%@include file="NavbarInlogg.jsp" %>
<body class="body">

<h1>Hej och välkommen till GritAcademy!</h1>
<h5>Vänligen klicka på login för att komma vidare till inloggningssidan!</h5>
<a href="/login">Logga In</a>
</body>
<%@include file="Footer.jsp"%>
</html>

