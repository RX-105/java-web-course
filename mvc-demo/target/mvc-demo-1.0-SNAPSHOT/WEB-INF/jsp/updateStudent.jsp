<jsp:useBean id="student" scope="request" type="com.mvcdemo.mvcdemo.entity.Student"/>
<%@ page import="com.mvcdemo.mvcdemo.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: zgy
  Date: 2022/4/13
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UpdateStudent</title>
</head>
<body>
    <h1>修改信息</h1>
    <form method="post" action="update">
        <label style="display: none">
            <input type="text" name="sid" value="${student.sid}"/><br/>
        </label>
        <label>
            姓名：<input type="text" name="sname" value="${student.sname}"/><br/>
        </label>
        <label>
            年龄：<input type="text" name="sage" value="${student.sage}"/><br/>
        </label>
        <label>
            专业：<input type="text" name="major" value="${student.major}"/><br/>
        </label>
        <label>
            状态：
            <c:if test="${student.status == 1}">
                <input type="radio" name="status" value="0"/>在校
                <input type="radio" name="status" value="1" checked="checked"/>不在校<br/>
            </c:if>
            <c:if test="${student.status == 0}">
                <input type="radio" name="status" value="0" checked="checked"/>在校
                <input type="radio" name="status" value="1"/>不在校<br/>
            </c:if>
        </label>
        <label>
            <input type="submit" value="提交"/>
        </label>
    </form>
</body>
</html>
