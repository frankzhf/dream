<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="net.frank.framework.bo.Resource,net.frank.repository.bo.SharedRequest" %>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

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

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
</head>
<body>
	<table width="100%">
		<fk:resource var="own" resourceId="${sharedRequest.ownResourceId}" cs="${su}"/>
		<fk:resource var="staff" resourceId="${own.object.staff$19.id}" cs="${su}"/>
		<fk:resource var="person" resourceId="${staff.object.person$18.id}" cs="${su}"/>
		<tr>
			<td width="15%"><bean:message key="repository.approve.share.applicant" /></td>
			<td>${person.object.englishName}</td>
		</tr>
		<tr>
			<td width="15%" valign="top"><bean:message key="repository.approve.share.desc" /></td>
			<%
			String text = new String(((SharedRequest)(((Resource)request.getAttribute("sharedRequest")).getObject())).getText());
			%>
			<td><textarea rows="2" cols="255" readonly="readonly"><%=text%></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="errorMessage">
				</div>
			</td>
		</tr>
	</table>
</body>
</html>