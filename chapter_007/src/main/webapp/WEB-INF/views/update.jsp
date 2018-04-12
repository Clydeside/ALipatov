<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script>
    function validate() {
        var result = true;
        var id = document.getElementsByName("id")[0].value;
        var name = document.getElementsByName("name")[0].value;
        var login = document.getElementsByName("login")[0].value;
        if (id === "" || name === "" || login === "") {
            result = false;
            alert("Some fields are empty!");
        }
        return result;
    }
</script>
<body>
<form action = "${pageContext.servletContext.contextPath}/update" method='post' onsubmit="return validate()" class="form-inline">
    <label for="id">User ID:</label>
    <input type='text' name='id' id="id" class="form-control"/>
    <label for="name">Name:</label>
    <input type='text' name='name' id="name" class="form-control"/>
    <label for="login">Login:</label>
    <input type='text' name='login' id="login" class="form-control"/>
    <input type='submit' class="btn btn-default">
</form>
<br><a href="${pageContext.servletContext.contextPath}/">Back to list</a><br><br>
</body>
</html>
