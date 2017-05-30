<%@ page contentType="text/html;charset=UTF-8"%>

<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" type="java.lang.String" required="true"
	description="页面标题"%>
<%@ attribute name="bodyId" type="java.lang.String" required="false"%>

<%@ attribute name="description" type="java.lang.String" required="false"%>
<%@ attribute name="keywords" type="java.lang.String" required="false"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="ctx" value="${pageContext.request.contextPath}${fns:getFrontPath()}" scope="request" />
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/resources" scope="request" />
<c:set var="ctxStaticFront" value="${ctxStatic}/modules/cms/front" scope="request"/>
<c:set var="ctxStaticTheme" value="${ctxStaticFront}/themes/${site.theme}" scope="request"/>
<c:set var="urlSuffix" value="${fns:getUrlSuffix()}" scope="request"/>

<!DOCTYPE html>
<html>
<head>
	<title><%=title%>- Powered By Yangtes</title>
	<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="format-detection" content="telephone=no">
</head>
<body>
	<jsp:doBody/>
</body>
</html>