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
    <title>Title</title>
    <%@include file="HeaderLinks.jsp"%>
    <link rel="stylesheet" href="../CSS/Style.css">
</head>

<%--<body>
<h1>Hello World from Show Students!</h1>
<h3>${param.message}</h3>
<table class="table">
    <tr>
        <th>first name</th><th>last name</th>
    </tr>
    <c:forEach items="${usersBean.data}" var="dataPunkt" varStatus="loop"><%--Using the varStatus i can get the indexes of the loop--%
        <c:if test="${loop.index != 0}"> <%--Using this part to skip the first row in the array as it contains the headers--%
        <tr>
            <td>${dataPunkt[1]}</td><td>${dataPunkt[2]}</td>
        </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>--%>

<%--Denna biten är lite magisk och jag förstår mig inte riktigt på den men den är cool som fan. Skapar dynamiskt ALLA headers till vårt table
och populerar dem med data därefter.--%>
<%--<body>
<h1>Hello World from Show Students!</h1>
<h3>${param.message}</h3>
<table class="table">
    <c:forEach items="${usersBean.data}" var="dataPunkt" varStatus="loop">
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
</html>--%>

<%--Denna biten är lite magisk men den är ännu coolare som fan. Skapar dynamiskt headers som vi väljer till vårt table och populerar dem.
Alltså baserat på svaret vi från DB så plockar den ut headers, av dessa kan vi välja vilka headerindex vi vill använda dynamiskt
och sen dynamiskt fylla dessa. Egentligen ganska likt första utgåvan i detta dokumentet men coolare. Kanske om vi behöver
plocka ut column 1,2,3,4 ur 3 olika tables men de har olika headers så funkar denna ändå.--%>
<body>
<h1>Hello World from Show Students!</h1>
<h3>${param.message}</h3>
<table class="table">
    <tr>
        <!-- Specify the specific column headers you want to include based on their indexes -->
        <c:forEach items="${usersBean.data[0]}" var="columnName" varStatus="loop">
            <c:if test="${loop.index == 1 || loop.index == 2|| loop.index == 4|| loop.index == 5}">
                <th>${columnName}</th>
            </c:if>
        </c:forEach>
    </tr>
    <c:forEach items="${usersBean.data}" var="dataPunkt" varStatus="loop">
        <c:if test="${loop.index != 0}">
            <tr>
                <!-- Access specific column values based on their indexes -->
                <td>${dataPunkt[1]}</td><td>${dataPunkt[2]}</td><td>${dataPunkt[4]}</td><td>${dataPunkt[5]}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<br>
<table class="table">
    <tr>
        <!-- Specify the specific column headers you want to include based on their indexes -->
        <c:forEach items="${coursesBean.data1[0]}" var="columnName1" varStatus="loop">
            <c:if test="${loop.index == 1 || loop.index == 2|| loop.index == 3}">
                <th>${columnName1}</th>
            </c:if>
        </c:forEach>
    </tr>
    <c:forEach items="${coursesBean.data1}" var="dataPunkt1" varStatus="loop">
        <c:if test="${loop.index != 0}">
            <tr>
                <!-- Access specific column values based on their indexes -->
                <td>${dataPunkt1[1]}</td><td>${dataPunkt1[2]}</td><td>${dataPunkt1[3]}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
