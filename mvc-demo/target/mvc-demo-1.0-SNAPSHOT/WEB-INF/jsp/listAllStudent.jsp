<%--
  Created by IntelliJ IDEA.
  User: zgy
  Date: 2022/4/13
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ListAllStudent</title>
</head>
<body>
    <h1>学生管理</h1>
    <a href="addStudent">添加学生</a>
    <a href="search">搜索</a>
    <table border="1" width="800">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>专业</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
<%--        <jsp:useBean id="students" scope="request" type="java.util.List<com.mvcdemo.mvcdemo.entity.Student>"/>--%>
<%--        <jsp:useBean id="page" scope="request" type="com.mvcdemo.mvcdemo.entity.Page"/>--%>
        <c:forEach var="student" items="${page.entityList}" varStatus="sts">
            <tr>
                <td>${sts.count}</td>
                <td>${student.sname}</td>
                <td>${student.sage}</td>
                <td>${student.major}</td>
                <td>
                    <c:if test="${student.status == 0}">在校</c:if>
                    <c:if test="${student.status == 1}">不在校</c:if>
                </td>
                <td>
                    <a href="update?sid=${student.sid}">修改</a>
                    |
                    <a href="deleteStudent?sid=${student.sid}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <p>${msg}</p>
    </table>
    <div>
        <c:if test="${page.currentPage != 1}">
            <a href="getByPage?page=${page.currentPage - 1}">上一页</a>
        </c:if>
        <c:forEach begin="1" end="${page.pageCount}" var="i">
            <a href="getByPage?page=${i}">${i}</a>|
        </c:forEach>
        <c:if test="${page.currentPage != page.pageCount}">
            <a href="getByPage?page=${page.currentPage + 1}">下一页</a>
        </c:if>
    </div>
</body>
</html>
