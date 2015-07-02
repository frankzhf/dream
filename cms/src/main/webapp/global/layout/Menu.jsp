<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/global/css/styles.css">
</head>
<body>
<table width="100%" height="100%" align="left" style="margin:0;padding:0;background:#FFFFFF;">
	<tr>
	<td valign="top">
	<fieldset class="section">
		<legend><bean:message key="common.menu"/></legend>
		<fk:display configfile="WEB-INF/menu/navigation.xml" />
	</fieldset>
	</td>
	</tr>
</table>
</body>