<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form action = "${pageContext.servletContext.contextPath}/delete" method = 'post'>
    <label for="id">User ID:</label>
    <input type='text' name='id' id="id"/>
    <input type='submit'>
</form>
<br><a href="${pageContext.servletContext.contextPath}/">Back to list</a><br><br>
</body>
</html>
