<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<table cellspacing="2" border="1" cellpadding="5" width="600">
    <thead>
    <tr>
        <th>Дата/Время</th>
        <th>Описание</th>
        <th>Калории</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mealToList}" var="mealTo">
        <tr style="${mealTo.excess ? 'background-color: red':'background-color: green'}">
        <td>
            <javatime:format value="${mealTo.dateTime}" pattern="yyyy-MM-dd HH:mm" />
        </td>
        <td>
            <c:out value="${mealTo.description}" />
        </td>
        <td>
            <c:out value="${mealTo.calories}" />
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
