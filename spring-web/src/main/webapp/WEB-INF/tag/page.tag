<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><spring:message code="application.name" /></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/default/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery/jquery-1.9.1.min.js"></script>
<body>
	<div class="container">
		<jsp:doBody />
	</div>
</body>
</html>