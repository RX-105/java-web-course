<%@ page import="com.example.servletdemo.bean.Student" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<p>欢迎，${username}</p>
<br/>
<table border="1">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>专业</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${studentList }" var="item" varStatus="status">
        <c:if test="${status.index % 2 == 0}">
            <tr bgcolor="red">
        </c:if>
        <c:if test="${status.index % 2 != 0}">
            <tr>
        </c:if>
            <td>${item.sid }</td>
            <td>${item.sname }</td>
            <td>${item.major }</td>
            <td>${item.sage }</td>
            <td><a href="#">修改</a>|<a href="#">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>