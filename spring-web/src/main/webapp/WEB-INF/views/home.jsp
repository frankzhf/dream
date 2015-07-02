<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head><spring:message code="welcome.title" /></head>
<body>
Language : <a href="?language=en_US">English</a>|<a href="?language=zh_CN">Chinese</a>

<spring:message code="login.name.label" />
</body>
</html>