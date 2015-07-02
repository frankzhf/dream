<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/global/css/styles.css">
<style type="text/css">
</style>
</head>

<body>
<table width="100%" height="100%" align="left">
	<tr>
		<td valign="middle" >
			<fieldset class="section">
				<legend><bean:message key="welcome.heading"/></legend>
			</fieldset>
		</td>
	</tr>
</table>
</body>
</html>
