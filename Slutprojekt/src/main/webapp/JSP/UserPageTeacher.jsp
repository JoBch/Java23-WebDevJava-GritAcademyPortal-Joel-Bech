<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 2024-02-19
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<h1>Välkommen LÄRARE Grit Academy</h1>
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
                <td>${dataPunkt[1]}</td>
                <td>${dataPunkt[2]}</td>
                <td>${dataPunkt[4]}</td>
                <td>${dataPunkt[5]}</td>
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
