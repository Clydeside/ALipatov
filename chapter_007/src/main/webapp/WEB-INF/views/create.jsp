<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<p>Please, fill the form:</p>
<form action = "${pageContext.servletContext.contextPath}/create" method = 'post'>
    <label for="name">Name:</label><input type='text' name='name' id="name"/><br>
    <label for="login">Login:</label><input type='text' name='login' id="login"/><br>
    <input type='submit'>
</form>
<br><a href="${pageContext.servletContext.contextPath}/">Back to list</a><br><br>
</body>
</html>
