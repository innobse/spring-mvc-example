<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>

    </head>
    <body>
        <h1>Привет, ${name}</h1>
        <br />
        <hr />
        <c:forEach var="item" items="${list}">
            Запись: ${item}
            <br />
        </c:forEach>
    </body>
</html>