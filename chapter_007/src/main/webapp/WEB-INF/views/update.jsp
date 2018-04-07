<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action = "${pageContext.servletContext.contextPath}/update" method = 'post'>
    <label for="id">User ID:</label>
    <input type='text' name='id' id="id"/>
    <label for="name">Name:</label>
    <input type='text' name='name' id="name"/>
    <label for="login">Login:</label>
    <input type='text' name='login' id="login"/>
    <input type='submit'>
</form>
<br><a href="${pageContext.servletContext.contextPath}/">Back to list</a><br><br>
</body>
</html>
