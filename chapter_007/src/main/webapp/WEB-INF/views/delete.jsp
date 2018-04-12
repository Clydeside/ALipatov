<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function validate() {
            var result = true;
            if (document.getElementsByName("id")[0].value === "") {
                result = false;
                alert("Please, enter the id!");
            }
            return result;
        }
    </script>
</head>
<body>
<form action = "${pageContext.servletContext.contextPath}/delete" method='post' onsubmit="return validate()" class="form-inline">
    <label for="id">User ID:</label>
    <input type='text' name='id' id="id" class="form-control"/>
    <input type='submit' class="btn btn-default">
</form>
<br><a href="${pageContext.servletContext.contextPath}/">Back to list</a><br><br>
</body>
</html>
