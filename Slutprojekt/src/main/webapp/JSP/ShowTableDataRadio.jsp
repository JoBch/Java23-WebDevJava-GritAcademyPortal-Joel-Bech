<%--
  Created by IntelliJ IDEA.
  User: joelb
  Date: 2024-02-22
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table">
    <c:forEach items="${showTableData}" var="dataPunkt" varStatus="loop">
        <c:if test="${loop.index == 0}">
            <tr>
                <c:forEach items="${dataPunkt}" var="columnName">
                    <th>${columnName}</th>
                </c:forEach>
                <th>Select</th>
            </tr>
        </c:if>
        <c:if test="${loop.index != 0}">
            <tr>
                <c:forEach items="${dataPunkt}" var="columnValue">
                    <td>${columnValue}</td>
                </c:forEach>
                <td><input type="radio" name="selectedId1" value="${dataPunkt[0]}"></td>
            </tr>
        </c:if>
    </c:forEach>
</table>
