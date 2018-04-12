<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function validate() {
            var result = true;
            var name = document.getElementsByName("name")[0].value;
            var login = document.getElementsByName("login")[0].value;
            if (name === "" || login === "") {
                result = false;
                alert("Some fields are empty!");
            }
            return result;
        }
    </script>
</head>
<body class="col-sm-offset-2 col-sm-10" style="margin-left: 0%;">
<p>Please, fill the form:</p>
<form action = "${pageContext.servletContext.contextPath}/create" onsubmit="return validate()" method = 'post' class="form-horizontal">
    <label for="name">Name:</label><input type='text' name='name' id="name" class="form-control"/><br>
    <label for="login">Login:</label><input type='text' name='login' id="login" class="form-control"/><br>
    <input type='submit' class="btn btn-default">
</form>
<br><a href="${pageContext.servletContext.contextPath}/">Back to list</a><br><br>
</body>
</html>
