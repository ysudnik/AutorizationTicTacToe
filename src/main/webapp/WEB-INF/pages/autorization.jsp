<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.12.2018
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spr" %>
<html>
<head>
    <title>Autorization</title>
</head>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=de">ru</a>
</span>
<p><sp:message code="autorization"/></p>
<spring:form action="/autorization" method="post"
             modelAttribute="userParam">
    <h3><spr:message code="name"/></h3>
    <spring:input path="name"/>
    <spring:errors path="name"/>
    <h3><spr:message code="password"/></h3>
    <spring:password path="password"/>
    <spring:errors path="password"/>
    <h3><spr:message code="confirmPassword"/></h3>
    <spring:password path="confirmPassword"/>
    <spring:errors path="confirmPassword"/>
    <input type="submit" value="Send"/>
</spring:form>
<h3><spr:message code="enter"/> <a href=/reg><spr:message code="registry"/></a></h3>
</body>
</html>
