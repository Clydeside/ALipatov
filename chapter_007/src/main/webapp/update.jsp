<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action = "<%=request.getContextPath()%>/update" method = 'post'>
    <label>User ID:</label><input type='text' name='id'/>
    <label>Name:</label><input type='text' name='name'/>
    <label>Login:</label><input type='text' name='login'/>
    <input type='submit'>
    </form>
<br><a href="<%= request.getContextPath() %>/view.jsp">Back to list</a><br><br>
</body>
</html>
