<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<table>
    <form action="meals" method="post">
        ID : <input type="text" readonly="readonly" name="mealId"
                        value="<c:out value="${meal.id}" />" /> <br />
        Дата/Время : <input type="datetime-local" name="dateTime"
                            value="<c:out value="${meal.dateTime}" />" /> <br />
        Описание : <input type="text" name="description"
                          value="<c:out value="${meal.description}" />" /> <br />
        Калории : <input type="text" name="calories"
                         value="<c:out value="${meal.calories}" />" /> <br />
        <input type="submit"  />
    </form>
</table>
</body>
</html>
