<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 2024-02-19
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../CSS/Navbar.css">

<div class="mainNavbar">
    <navbar>
        <banner>

            <h1 class="navBarTitle">GRIT ACADEMY</h1>

            <!-- Vill vi få in namnet på den inloggade här i navbar titel kanske?-->
        </banner>
    <div id="menuLinks">
        <nav class="navBarLinks">
            <a class="navLink" href="/Attendance">HEM</a>
            <a class="navLink" href="/Courses">ADMIN KURSER</a>
            <a class="navLink" href="/Add">ADMIN LÄGG TILL ELEV/LÄRARE</a>
            <a class="navLink" href="/Delete">ADMIN TA BORT ELEV/LÄRARE</a>
        </nav>

        <a class="navLink" href="/logout"><form style=text-align:center; action="/logout" method="POST"><input type="submit" id="logout" value="logout"></form></a>
    </div>
    </navbar>
</div>