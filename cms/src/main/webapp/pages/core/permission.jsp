<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragrma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">

<%
request.setAttribute("permission",
		request.getParameter("permission"));
%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/icon.css">
<script type="text/javascrip">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>
	
<script src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script src='${pageContext.request.contextPath}/dwr/util.js'></script>
<script src='${pageContext.request.contextPath}/dwr/interface/queryAjax.js'></script>

<script type="text/javascript">
function submitDialog(){
	$("errorMessage").empty();
}
</script>
</head>
<body>
	
	<table width="100%" class="listTable">
		<tr>
			<th width="33%"><bean:message key="common.read" /></th>
			<th width="33%"><bean:message key="common.write" /></th>
			<th><bean:message key="common.run" /></th>
		</tr>
		<c:if test="${permission eq 0}">
			<tr>
				<td><input type="checkbox" id="r" value="4"></td>
				<td><input type="checkbox" id="w" value="2"></td>
				<td><input type="checkbox" id="x" value="1"></td>
			</tr>
		</c:if>
		<c:if test="${permission eq 1}">
			<tr>
				<td><input type="checkbox" id="r" value="4"></td>
				<td><input type="checkbox" id="w" value="2"></td>
				<td><input type="checkbox" id="x" value="1" checked="checked"></td>
			</tr>
		</c:if>
		<c:if test="${permission eq 2}">
			<tr>
				<td><input type="checkbox" id="r" value="4"></td>
				<td><input type="checkbox" id="w" value="2" checked="checked"></td>
				<td><input type="checkbox" id="x" value="1"></td>
			</tr>
		</c:if>
		<c:if test="${permission eq 3}">
			<tr>
				<td><input type="checkbox" id="r" value="4"></td>
				<td><input type="checkbox" id="w" value="2" checked="checked"></td>
				<td><input type="checkbox" id="x" value="1" checked="checked"></td>
			</tr>
		</c:if>
		<c:if test="${permission eq 4}">
			<tr>
				<td><input type="checkbox" id="r" value="4" checked="checked"></td>
				<td><input type="checkbox" id="w" value="2"></td>
				<td><input type="checkbox" id="x" value="1"></td>
			</tr>
		</c:if>
		<c:if test="${permission eq 5}">
			<tr>
				<td><input type="checkbox" id="r" value="4" checked="checked"></td>
				<td><input type="checkbox" id="w" value="2"></td>
				<td><input type="checkbox" id="x" value="1" checked="checked"></td>
			</tr>
		</c:if>
		<c:if test="${permission eq 6}">
			<tr>
				<td><input type="checkbox" id="r" value="4" checked="checked"></td>
				<td><input type="checkbox" id="w" value="2" checked="checked"></td>
				<td><input type="checkbox" id="x" value="1"></td>
			</tr>
		</c:if>
		<c:if test="${permission eq 7}">
			<tr>
				<td><input type="checkbox" id="r" value="4" checked="checked"></td>
				<td><input type="checkbox" id="w" value="2" checked="checked"></td>
				<td><input type="checkbox" id="x" value="1" checked="checked"></td>
			</tr>
		</c:if>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="errorMessage">
	</div>
</body>
</html>