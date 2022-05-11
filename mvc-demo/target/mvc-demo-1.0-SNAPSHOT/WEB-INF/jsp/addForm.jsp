<%--
  Created by IntelliJ IDEA.
  User: zgy
  Date: 2022/4/13
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="msg" scope="request" type="java.lang.String"/>
<html>
<head>
    <title>AddStudent</title>
</head>
<body>
    <form method="post" action="addStudent">
        <label>
            姓名：<input type="text" name="sname"/><br/>
        </label>
        <label>
            年龄：<input type="text" name="sage"/><br/>
        </label>
        <label>
            专业：<input type="text" name="major"/><br/>
        </label>
        <label>
            状态：<input type="radio" name="status" value="0"/>在校
                 <input type="radio" name="status" value="1"/>不在校<br/>
        </label>
        <label>
            <input type="submit" value="提交"/>
        </label>
    </form>
    <p>${msg}</p>
</body>
</html>
