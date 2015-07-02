<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fk:cs />

<script type="text/javascript">

</script>

<table width="100%" class="listTable">
	<tr>
		<th width="35%"><bean:message key="repository.my.received.file.name" /></th>
		<th width="15%"><bean:message
				key="repository.my.received.own" /></th>
		<th width="20%"><bean:message
				key="repository.my.received.size" /></th>
		<th><bean:message key="repository.my.received.operate" /></th>
	</tr>
	<c:set var="fileCount" value="0" />
	<c:if test="${!empty aclList}">
		<c:forEach items="${aclList}" var="acl" varStatus="loop">
			<fk:resource var="file" resourceId="${acl.resourceId}"/>
			<c:if test="${file.code eq 0 && file.typeId eq 50000}">
			<fk:resource var="own" resourceId="${file.ownResourceId}" cs="${su}"/>
			<fk:resource var="staff" resourceId="${own.object.staff$19.id}" cs="${su}"/>
			<fk:resource var="person" resourceId="${staff.object.person$18.id}" cs="${su}"/>	
	<tr>
		<td>${file.object.fileName}</td>
		<td>${person.object.englishName}</td>
		<td>${file.object.length}</td>
		<td><a href="${pageContext.request.contextPath}/attachment?resourceId=${file.id}">
			<bean:message key='repository.my.received.download' /></td>
	</tr>
				<c:set var="fileCount" value="${fileCount + 1}" />
			</c:if>
		</c:forEach>
	</c:if>
	<c:if test="${fileCount eq 0}">
	<tr>
		<td colspan="4"><bean:message
						key="common.message.no.match.records" /></td>
	</tr>
	</c:if>
</table>