<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.12.2018
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Пожалуйста, зарегистрируйтесь:</h3>
<spring:form action="/registration" method="post"
             modelAttribute="userParam">
    <h3>Придумайте логин</h3>
    <spring:input path="name"/>
    <spring:errors path="name"/>
    <h3>Придумайте пароль</h3>
    <spring:password path="password"/>
    <spring:errors path="password"/>
    <h3>Повторитеввод пароля</h3>
    <spring:password path="confirmPassword"/>
    <spring:errors path="confirmPassword"/>
    <input type = "submit" value = "Registration"/>
</spring:form>
</body>
</html>
