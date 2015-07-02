<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragrma","no-cache");
	response.setDateHeader("Expires",0);
%>

<tiles:useAttribute name="centerHeader" classname="java.lang.String" />
<tiles:useAttribute name="rightHeader" classname="java.lang.String" />

<html:html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/project.css">

<script type="text/javascript">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>

<!-- DWR lib -->
<script type="text/javascript" 
	src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script type="text/javascript" 
	src='${pageContext.request.contextPath}/dwr/util.js'></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>

<script type="text/javascript">
	
function openUrl(href){
	$("#east").panel({
		modal:true,
		content : '<iframe id="rightDetails" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>'
	});
}
</script>
</head>

<body class="easyui-layout">
	<div id="center" region="center" border="false" title="<bean:message key='${centerHeader}' />" style="padding:0px;" >
<c:if test="${empty forwordParam}">
		<iframe id="navigation" frameborder="0"  src="${pageContext.request.contextPath}<tiles:getAsString name='centerLinker'/>" style="width:100%;height:100%;"></iframe>
</c:if>
<c:if test="${!empty forwordParam}">
		<iframe id="navigation" frameborder="0"  src="${pageContext.request.contextPath}<tiles:getAsString name='centerLinker'/>${forwordParam}" style="width:100%;height:100%;"></iframe>
</c:if>
	</div>
	<div id="east" region="east" border="false" title="<bean:message key='${rightHeader}' />" split="true" style="width: 220px; padding: 0px;"/>
	</div>
</body>
</html:html>