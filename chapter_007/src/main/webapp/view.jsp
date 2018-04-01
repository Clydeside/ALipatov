<%@ page import="ru.job4j.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.job4j.resourses.UserStorage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<h1>Users List</h1>
<a href='create'>Add New User</a><br><br>
<table border='1' width='100%'>
    <tr>
        <th>Id</th><th>Name</th><th>Login</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <%UserStorage storage = UserStorage.getInstance();%>
    <%List<User> list = storage.getAllUsers();%>
    <%for (User user : list) {%>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getLogin()%></td>
        <td><a href='update'>Update</a></td>
        <td><a href='delete'>Delete</a></td>
    </tr>
    <%}%>
</table>
</table>
</body>
</html>
