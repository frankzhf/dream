<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
function selectedCurrentAccount(accountResId){
	$("#selectedId").val(accountResId);
}
</script>
<input type="hidden" id="selectedId" value="">
<table width="100%" class="listTable">
	<tr>
		<th width="5%"><bean:message key="task.dialog.list.select" /></th>
		<th width="40%"><bean:message key="task.dialog.list.login.name" /></th>
		<th><bean:message key="task.dialog.list.groups" /></th>
	</tr>
<c:if test="${!empty accountList}">
	<c:forEach items="${accountList}" var="av" varStatus="loop">
	<tr>
		<td><input type="radio" onclick="selectedCurrentAccount(${av.accountResId})"></td>
		<td>${av.loginName}</td>
		<td>${av.displayGroup}</td>
	</tr>
	</c:forEach>	
</c:if>
<c:if test="${empty accountList}">
	<tr>
		<td colspan="3"><bean:message key="common.message.no.match.records" /></td>
	</tr>
</c:if>	
</table>
<div id="errorMessage" />

