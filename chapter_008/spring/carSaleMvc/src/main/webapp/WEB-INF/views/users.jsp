<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="width: 95%; margin: auto">
<h1>Users List</h1>
<form action = "${pageContext.servletContext.contextPath}/users.do" method = 'post'>
    <input type="text" name="name" class="btn btn-default">
    <input type="submit" class="btn btn-default">
</form>
<a href='users.do'>Add New User</a><br><br>
<table border='1' width='100%' style="border-collapse: collapse" class="table table-bordered">
    <tr>
        <th>Name</th>
    </tr>
    <c:forEach items = "${users}" var="user">
        <tr valign="top">
            <td><c:out value="${user.name}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
