<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>LogIn</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function validate() {
            var result = true;
            var login = document.getElementsByName("login")[0].value;
            var password = document.getElementsByName("password")[0].value;
            if (login === "" || password === "") {
                result = false;
                alert("Some fields are empty!");
            }
            return result;
        }
    </script>
</head>
<body>
<div style="width: 15%; margin: auto;">
    <c:if test="${Error != ''}">
        <div style="background-color: red">
            <c:out value="${Error}"/>
        </div>
    </c:if>
    <form action = "${pageContext.servletContext.contextPath}/signIn" onsubmit="return validate()" method = 'post' class="form-horizontal">
        <label for="login">Login:</label><input type='text' name='login' id="login" placeholder="Enter email" class="form-control"/><br>
        <label for="password">Password:</label><input type='password' name='password' id="password" placeholder="Enter password" class="form-control"/><br>
        <input type='submit' value="Sign In" class="btn btn-default">
    </form>
</div>
</body>
</html>
