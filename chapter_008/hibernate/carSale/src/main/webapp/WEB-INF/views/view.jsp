<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CarSale</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>CarSale</h2>
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Марка</th>
            <th>Тип двигателя</th>
            <th>Коробка передач</th>
            <th>Трансмиссия</th>
        </tr>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td><c:out value="${car.id}"></c:out></td>
                <td><c:out value="${car.name}"></c:out></td>
                <td><c:out value="${car.engine}"></c:out></td>
                <td><c:out value="${car.gearbox}"></c:out></td>
                <td><c:out value="${car.transmission}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
    <div class="form-group form-inline">
        <form method="get" action="${pageContext.servletContext.contextPath}/add">
            <button class="btn btn-default" type="submit">Add New Car</button>
        </form>
        <form method="post" action="${pageContext.servletContext.contextPath}/delete">
            <input class="form-control" type="text" name="id" placeholder="Delete Car By Id">
            <button class="btn btn-default" type="submit">Delete</button>
        </form>
    </div>
    <div style="float: right" class="form-group form-inline">
        <form method="get" action="${pageContext.servletContext.contextPath}/carsByMark">
            <label for="mark">Find by mark:</label>
            <input class="form-control" type="text" name="mark" placeholder="Enter the mark" id="mark">
            <button class="btn btn-default" type="submit">Find</button>
        </form>
    </div>
    <div style="float: left">
        <form method="get" action="${pageContext.servletContext.contextPath}/cars">
            <button class="btn btn-default" type="submit">ShowAllCars</button>
        </form>
    </div>
</div>
</body>
</html>