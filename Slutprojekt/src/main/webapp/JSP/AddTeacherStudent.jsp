<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 2024-02-20
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lägg till ny student eller lärare</title>
</head>
<body>
<h1>Hello User!</h1>
<h5>Här kan du lägga till ny lärare eller student</h5>
<form action="/Enroll" method="post">
    <label for="user_type">Choose a user type:</label>
    <select id="user_type" name="user_type">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
    </select><br>
    <label for=fname>Förnamn</label>
    <input name="fname" id="fname" type="text"><br>
    <label for=lname>Efternamn</label>
    <input name="lname" id="lname" type="text"><br>
    <label for=town>Stad</label>
    <input name="town" id="town" type="text"><br>
    <label for=email>Email</label>
    <input name="email" id="email" type="text"><br>
    <label for=phone>Telefonnummer</label>
    <input name="phone" id="phone" type="text"><br>
    <label for=username>Username</label>
    <input name="username" id="username" type="text"><br>
    <label for=password>Lösenord</label>
    <input name="password" id="password" type="text"><br>


    <input name="login" type="submit">
</form>
</body>
</html>
