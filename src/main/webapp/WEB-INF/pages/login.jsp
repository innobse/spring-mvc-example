<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="<%=request.getContextPath()%>/resources/style.css" rel="stylesheet"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login page</title>
</head>

<body>
<form method="POST" action="<%=request.getContextPath()%>/checkCredentials" class="box login">
    <fieldset class="boxBody">
        <label> Username: </label> <input type='text' name='user_login' value=''>
        <label> Password: </label> <input type='password' name='password_login' />
        <%--<input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"--%>
               <%--value="<c:out value="${_csrf.token}"/>"/>--%>
    </fieldset>
    <footer>
        <input type="submit" class="btnLogin" value="Submit">
        <c:if test="${not empty error}">
            <span class="error">${error}</span>
        </c:if>
    </footer>
</form>
</body>
</html>