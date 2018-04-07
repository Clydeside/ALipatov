<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
<p>Please, fill in Login and Password:</p>
<c:if test="${Error != ''}">
    <div style="background-color: red">
        <c:out value="${Error}"/>
    </div>
</c:if>
<form action = "${pageContext.servletContext.contextPath}/signIn" method = 'post'>
    <label for="login">Login:</label><input type='text' name='login' id="login"/><br>
    <label for="password">Password:</label><input type='password' name='password' id="password"/><br>
    <input type='submit' value="Sign In">
</form>
</body>
</html>
