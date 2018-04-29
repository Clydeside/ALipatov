<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Todo</title>
</head>
<body>
<div>
    <h2>Your Todos are</h2>
    <table border='1' width='100%' style="border-collapse: collapse" class="table table-bordered">
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <c:forEach items = "${todos}" var="todo">
            <tr>
                <td><c:out value="${todo.id}"></c:out></td>
                <td><c:out value="${todo.name}"></c:out></td>
            </tr>
        </c:forEach>
    </table>

    <form method="POST" action="${pageContext.servletContext.contextPath}/add">
        New Todo : <input name="name" type="text" /> <input name="add"
                                                            type="submit" />
    </form>
    <form method="POST" action="${pageContext.servletContext.contextPath}/delete">
        Delete Todo By ID: <input name="id" type="text" /> <input name="id"
                                                            type="submit" />
    </form>
</div>
</body>
</html>