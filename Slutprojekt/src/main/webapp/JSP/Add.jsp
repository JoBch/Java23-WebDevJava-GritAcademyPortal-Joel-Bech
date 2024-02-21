<%--
  Created by IntelliJ IDEA.
  User: joelb
  Date: 2024-02-20
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lägg till Student/Lärare/Kurs</title>
    <%@include file="NavBarTeacher.jsp"%>
    <link rel="stylesheet" href="../CSS/Style.css">
</head>
<body>
<c:choose>
    <c:when test="${userBean.userType == 'student'}">
        <!-- Code to execute if the user is a student -->
        <p>The user is a student.</p>
    </c:when>
    <c:when test="${userBean.userType == 'teacher'}">
        <!-- Code to execute if the user is a teacher -->
        <p>The user is a teacher.</p>
    </c:when>
    <c:otherwise>
        <!-- Code to execute if none of the above conditions are true -->
        <p>The user's type is unknown.</p>
    </c:otherwise>
</c:choose>

<form action="/Add" method="post">

    <p class="ParagraphForm">
        <label class="FormCell" for=fname>Förnamn</label>
        <input class="FormCell" name="fname" id="fname" type="text"><br>
    </p>

    <p class="ParagraphForm">
        <label class="FormCell" for=lname>Efternamn</label>
        <input class="FormCell" name="lname" id="lname" type="text"><br>
    </p>

    <p class="ParagraphForm">
        <label class="FormCell" for=town>Stad</label>
        <input class="FormCell" name="town" id="town" type="text"><br>
    </p>

    <%--Use this textfield only for user--%>
    <p class="ParagraphForm">
        <label class="FormCell" for=hobby>Hobby</label>
        <input class="FormCell" name="hobby" id="hobby" type="text"><br>
    </p>

    <p class="ParagraphForm">
        <label class="FormCell" for=email>Email</label>
        <input class="FormCell" name="email" id="email" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=phone>Telefon</label>
        <input class="FormCell" name="phone" id="phone" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=username>Username</label>
        <input class="FormCell" name="username" id="username" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=password>Password</label>
        <input class="FormCell" name="password" id="password" type="text"><br>
    </p>

    <h1>HÄR LÄGGER DU TILL FÖR KURSER JOEL</h1>
    <p class="ParagraphForm">
        <label class="FormCell" for=name>Namn på kurs</label>
        <input class="FormCell" name="name" id="name" type="text"><br>
    </p>

    <p class="ParagraphForm">
        <label class="FormCell" for=yhp>YHP</label>
        <input class="FormCell" name="yhp" id="yhp" type="text"><br>
    </p>
    <p class="ParagraphForm">
        <label class="FormCell" for=description>Beskrivning av kurs</label>
        <input class="FormCell" name="description" id="description" type="text"><br>
    </p>
<%--Use this select only for teacher--%>
    <br><br>
    <label for="whatTable">Choose a user type:</label>
    <select id="whatTable" name="whatTable">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
        <option value="courses">Courses</option>
    </select>
    <input name="add" type="submit">
</form>
<form action="Delete" method="post">
    <table class="table">
        <tr>
            <!-- Specify the specific column headers you want to include based on their indexes -->
            <c:forEach items="${data}}" var="columnName" varStatus="loop">
            <c:if test="${loop.index == 0}">
        <tr>
            <c:forEach items="${dataPunkt}" var="columnName">
                <th>${columnName}</th>
            </c:forEach>
        </tr>
        </c:if>
        </c:forEach>
        </tr>
        <c:forEach items="${data}" var="dataPunkt" varStatus="loop">
            <c:if test="${loop.index != 0}">
                <tr>
                    <!-- Access specific column values based on their indexes -->
                    <td>${dataPunkt[1]}</td><td>${dataPunkt[2]}</td><td>${dataPunkt[4]}</td><td>${dataPunkt[5]}</td>
                    <td><input type="radio" name="selectedId" value="${dataPunkt[0]}"></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
<%--    <select id="whatTable" name="whatTable">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
    </select>--%>
    <!-- Add a submit button to submit the selected ID value -->
    <input type="submit" value="Submit">
</form>
<%@include file="Footer.jsp"%>
</body>
</html>
