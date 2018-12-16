<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.12.2018
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Autorization</title>
</head>
<body>
<h3>Пожалуйста, авторизуйтесь</h3>
<spring:form action="/autorization" method="post"
             modelAttribute="userParam">
    <h3>Enter your name</h3>
    <spring:input path="name"/>
    <spring:errors path="name"/>
    <h3>Enter password</h3>
    <spring:password path="password"/>
    <spring:errors path="password"/>
    <h3>Confirm password</h3>
    <spring:password path="confirmPassword"/>
    <spring:errors path="confirmPassword"/>
    <input type = "submit" value = "Send"/>
</spring:form>
<h3>Выполните ввод или <a href=/reg>зарегистрируйтесь</a> </h3>
</body>
</html>
