<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>AddCar</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="float: left; width: 15%">
    <form class="form-horizontal" action="${pageContext.servletContext.contextPath}/add" method="post">
        <label class="control-label" for="name">Марка:</label>
        <input class="form-control" type="text" placeholder="Марка" name="name" id="name">
        <label class="control-label" for="engine">Двигатель:</label>
        <select class="form-control" name="engine" id="engine">
            <option value="1">бензиновый</option>
            <option value="2">дизельный</option>
            <option value="3">газовый</option>
        </select>
        <label class="control-label" for="gearbox">Коробка передач:</label>
        <select class="form-control" name="gearbox" id="gearbox">
            <option value="1">механическая</option>
            <option value="2">автоматическая</option>
            <option value="3">роботизированная</option>
            <option value="4">вариативная</option>
        </select>
        <label class="control-label" for="transmission">Трансмиссия:</label>
        <select class="form-control" name="transmission" id="transmission">
            <option value="1">механическая</option>
            <option value="2">электрическая</option>
        </select>
        <button style="width: 40%" class="btn btn-default" type="submit">Add</button>
    </form>
    <form action="${pageContext.servletContext.contextPath}/cars" method="get">
        <button style="width: 40%; color: green" class="btn btn-default" class="w3-left w3-btn" type="submit">Go Back</button>
    </form>
</div>
</body>
</html>