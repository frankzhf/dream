<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<html:html>
<head>

<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/icon.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#tabInfo').tabs();
	});
	function directResource(resourceId) {
		return;
	}
	function closeThisWin() {
		self.close();
	}
</script>
</head>
<body>
	<table width="100%">
		<tr>
			<td colspan="2"><a href="#" class="easyui-linkbutton"
				onclick="closeThisWin()"> <bean:message key='common.close' />
			</a></td>
		</tr>
		<tr>
			<td width="25%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><bean:message key="common.resource.alias" /></td>
			<td>${resource.alias}</td>
		</tr>
		<tr>
			<td><bean:message key="common.resource.path" /></td>
			<td><c:if test="${!empty resource.id}">
					<fk:path resourceId="${resource.id}" />
				</c:if> <c:if test="${empty resource.id}">
					<fk:path resourceId="${resource.parentId}" />
				</c:if></td>
		</tr>
		<tr>
			<td><bean:message key="common.system.node" /></td>
			<td><c:if test="${resource.systemNode}">
					<bean:message key="common.yes" />&nbsp;
				</c:if> <c:if test="${!resource.systemNode}">
					<bean:message key="common.no" />&nbsp;
				</c:if></td>
		</tr>
		<tr>
			<td><bean:message key="common.active" /></td>
			<td><c:if test="${resource.active}">
					<bean:message key="common.yes" />&nbsp;
				</c:if> <c:if test="${!resource.active}">
					<bean:message key="common.no" />&nbsp;
				</c:if></td>
		</tr>
	</table>
	<div id="tabInfo"
		style="position: absolute; padding: 0px 5px; width: 760px; height: 440px">
		<c:if test="${3 ne resource.typeId}">
			<div title="Details">
				<fk:content var="${content}" typeResourceId="${resource.typeId}" />
			</div>
		</c:if>
		<div title="System">
			<table width="100%" class="listTable">
				<tr>
					<th width="20%">&nbsp;</th>
					<th width="25%"><bean:message key="common.read" /></th>
					<th width="25%"><bean:message key="common.write" /></th>
					<th><bean:message key="common.run" /></th>
				</tr>
				<c:set var="isDisable" value="false" />
				<tr class="oddRow">
					<td><bean:message key="common.current.user" /></td>
					<td><c:set var="permission"
							value="${resource.currentAccountPermission}" /> <c:choose>
							<c:when test="${permission >= 4}">
								<bean:message key="common.yes" />&nbsp;
						<c:set var="permission" value="${permission-4}" />
							</c:when>
							<c:otherwise>
								<bean:message key="common.no" />&nbsp;
					</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${permission >= 2 }">
								<bean:message key="common.yes" />&nbsp;
						<c:set var="permission" value="${permission-2}" />
							</c:when>
							<c:otherwise>
								<bean:message key="common.no" />&nbsp;
					</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${permission >= 1 }">
								<bean:message key="common.yes" />&nbsp;
						<c:set var="permission" value="${permission-1}" />
							</c:when>
							<c:otherwise>
								<bean:message key="common.no" />&nbsp;
					</c:otherwise>
						</c:choose></td>
				</tr>
				<tr class="evenRow">
					<td><bean:message key="common.current.group" /></td>
					<td><c:set var="permission"
							value="${resource.currentGroupPermission}" /> <c:choose>
							<c:when test="${permission >= 4}">
								<bean:message key="common.yes" />&nbsp;
						<c:set var="permission" value="${permission-4}" />
							</c:when>
							<c:otherwise>
								<bean:message key="common.no" />&nbsp;
					</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${permission >= 2 }">
								<bean:message key="common.yes" />&nbsp;
						<c:set var="permission" value="${permission-2}" />
							</c:when>
							<c:otherwise>
								<bean:message key="common.no" />&nbsp;
					</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${permission >= 1 }">
								<bean:message key="common.yes" />&nbsp;
						<c:set var="permission" value="${permission-1}" />
							</c:when>
							<c:otherwise>
								<bean:message key="common.no" />&nbsp;
					</c:otherwise>
						</c:choose></td>
				</tr>
				<tr class="oddRow">
					<td><bean:message key="common.others" /></td>
					<td><c:set var="permission"
							value="${resource.othersPermission}" /> <c:choose>
							<c:when test="${permission >= 4}">
								<bean:message key="common.yes" />&nbsp;
						<c:set var="permission" value="${permission-4}" />
							</c:when>
							<c:otherwise>
								<bean:message key="common.no" />&nbsp;
					</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${permission >= 2 }">
								<bean:message key="common.yes" />&nbsp;
						<c:set var="permission" value="${permission-2}" />
							</c:when>
							<c:otherwise>
								<bean:message key="common.no" />&nbsp;
					</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${permission >= 1 }">
								<bean:message key="common.yes" />&nbsp;
						<c:set var="permission" value="${permission-1}" />
							</c:when>
							<c:otherwise>
								<bean:message key="common.no" />&nbsp;
					</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td colspan="4">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><bean:message key="common.own" /></td>
					<fk:resource var="currentAccount"
						resourceId="${resource.ownResourceId}" />
					<td colspan="2">${currentAccount.object.loginName}</td>
				</tr>
				<tr>
					<td colspan="2"><bean:message key="common.own.group" /></td>
					<fk:resource var="currentGroup"
						resourceId="${resource.ownGroupResourceId}" />
					<td colspan="2">${currentGroup.object.groupName}</td>
				</tr>
				<tr>
					<td colspan="2"><bean:message key="common.create.date" /></td>
					<td colspan="2"><fmt:formatDate value="${resource.createdDt}"
							pattern="dd/MM/yyyy HH:mm:ss" /> &nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><bean:message key="common.lastest.update.date" /></td>
					<td colspan="2"><fmt:formatDate
							value="${resource.lastUpdatedDt}" pattern="dd/MM/yyyy HH:mm:ss" />
						&nbsp;</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html:html>