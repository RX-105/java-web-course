<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form action="cookie" method="post">
    <label>
        USERNAME:<input type="text" name="username" value="${cookie['username'].value}">
    </label>
    <label>
        PASSWORD:<input type="password" name="password" value="${cookie['password'].value}">
    </label>
    <label>
        <input type="checkbox" name="remember"/>Remember me
    </label>
    <label>
        <input type="submit" value="SUBMIT">
    </label>
</form>
</body>
</html>