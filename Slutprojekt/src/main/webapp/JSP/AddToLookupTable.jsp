<%--
  Created by IntelliJ IDEA.
  User: joelb
  Date: 2024-02-21
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ta bort student/lärare/kurs</title>
    <link rel="stylesheet" href="../CSS/Style.css">
    <link rel="stylesheet" media="screen" href="https://fontlibrary.org//face/lato" type="text/css"/>
</head>
<body>
<%@include file="NavBarTeacher.jsp" %>
<h5>Välj först student/teacher tabell, klicka därefter i den användare du vill lägga till för en kurs</h5>
<%--
Denna delen används för att välja vilket table vi vill visa
--%>
<form action="/Show" method="post">
    <select id="whatTableShow" name="whatTableShow">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
        <input type="hidden" name="hiddenField" value="lookupTable">
    </select>
    <input type="submit" value="KÖR">
</form>
<form action="/Add" method="post">
    <%@include file="ShowTableDataRadio.jsp" %>
    <br>
    <table class="table">
        <c:forEach items="${coursesData}" var="dataPunkt" varStatus="loop">
            <c:if test="${loop.index == 0}">
                <tr id="tableRowHeader">
                    <c:forEach items="${dataPunkt}" var="columnName">
                        <th>${columnName}</th>
                    </c:forEach>
                    <th>Select</th>
                </tr>
            </c:if>
            <c:if test="${loop.index != 0}">
                <tr id="tableRowData">
                    <c:forEach items="${dataPunkt}" var="columnValue">
                        <td>${columnValue}</td>
                    </c:forEach>
                    <td><input type="radio" name="selectedId2" value="${dataPunkt[0]}"></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <br>
    <%--
        Denna delen används för att selecta från vilket table vi vill deleta, kanske sätta ihop med selecten där uppe?
    --%>
    <label for=whatTable>Vilken tabell vill du lägga till en kurs i?</label><br>
    <select id="whatTable" name="whatTable">
        <option value="students_courses">Student Courses</option>
        <option value="teachers_courses">Teacher Courses</option>
    </select>
    <!-- Add a submit button to submit the selected ID value -->
    <input type="submit" value="Add User">
</form>
<br>
<table class="table">
    <c:forEach items="${addTableData[0]}}" var="columnName" varStatus="loop">
        <c:if test="${loop.index == 0}">
            <tr>
                <c:forEach items="${dataPunkt}" var="columnName">
                    <th>${columnName}</th>
                </c:forEach>
            </tr>
        </c:if>
    </c:forEach>
    </tr>
    <c:forEach items="${addTableData}" var="dataPunkt" varStatus="loop">
        <c:if test="${loop.index != 0}">
            <tr>
                <!-- Access specific column values based on their indexes -->
                <td>${dataPunkt[0]}</td>
                <td>${dataPunkt[1]}</td>
                <td>${dataPunkt[2]}</td>
                <td>${dataPunkt[3]}</td>
                <td>${dataPunkt[4]}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
<%@include file="Footer.jsp" %>
</html>
