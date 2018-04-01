<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form action = "<%= request.getContextPath() %>/delete" method = 'post'>
    <label>User ID:</label><input type='text' name='id'/>
    <input type='submit'>
</form>
<br><a href="<%= request.getContextPath() %>/view.jsp">Back to list</a><br><br>
</body>
</html>
