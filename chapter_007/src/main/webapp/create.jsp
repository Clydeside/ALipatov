<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<p>Please, fill the form:</p>
<form action = "<%= request.getContextPath() %>/create" method = 'post'>
    <label>Name:</label><input type='text' name='name'/><br>
    <label>Login:</label><input type='text' name='login'/><br>
    <input type='submit'>
</form>
<br><a href="<%= request.getContextPath() %>/view.jsp">Back to list</a><br><br>
</body>
</html>
