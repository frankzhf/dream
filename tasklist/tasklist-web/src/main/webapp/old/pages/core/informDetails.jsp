<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ page import="net.frank.framework.web.security.ClientSession"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://www.frank.net/jsp/tags/cms" prefix="cms"%>
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
<script type="text/javascript">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/dialog.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery-common.js"></script>

<script type="text/javascript">
	$(function() {
		$('#tabInfo').tabs();
	});

	function editInformation() {
		document.forms[0].action = '${pageContext.request.contextPath}/core/editInformDetails.do';
		$.submitFormWoMsg();
	}
	function saveInformation() {
		document.forms[0].action = '${pageContext.request.contextPath}/core/saveInformDetails.do';
		$.submitFormWoMsg();
	}
	function cancelEdit() {
		$.submitFormWoMsg();
	}
	function directResource(resourceId) {
		document.forms[0].action = '${pageContext.request.contextPath}/core/viewInformDetails.do';
		document.getElementById("resource.longString(id)").value = resourceId;
		$.submitFormWoMsg();
	}
</script>
</head>
<body>
	<c:choose>
		<c:when
			test="${!empty checkPermission && 'failure' eq  checkPermission}">
			<h3>
				<bean:message key="common.insufficient.privileges" />
			</h3>
		</c:when>
		<c:otherwise>
			<html:form action="/viewInformDetails" enctype="multipart/form-data">
				<html:hidden styleId="resource.longString(id)"
					property="resource.longString(id)" />
				<html:hidden styleId="resource.longString(parentId)"
					property="resource.longString(parentId)" />
				<html:hidden styleId="resource.longString(typeId)"
					property="resource.longString(typeId)" />
				<html:hidden styleId="resource.longString(ownResourceId)"
					property="resource.longString(ownResourceId)" />
				<html:hidden styleId="resource.longString(ownGroupResourceId)"
					property="resource.longString(ownGroupResourceId)" />
				<html:hidden styleId="resource.timestampString(createdDt)"
					property="resource.timestampString(createdDt)" />
				<html:hidden styleId="resource.timestampString(lastUpdatedDt)"
					property="resource.timestampString(lastUpdatedDt)" />
				<c:if test="${!empty resource}">
					<table style="width: 100%">
						<tr>
							<td width="15%">&nbsp;</td>
							<td width="35%">&nbsp;</td>
							<td width="15%">&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4"><c:if test="${ mode eq 'view' }">
									<a href="#" class="easyui-linkbutton"
										onclick="editInformation()"><bean:message
											key='common.edit' />
									</a>
								</c:if> <c:if test="${ mode eq 'edit' }">
									<a href="#" class="easyui-linkbutton"
										onclick="saveInformation()"><bean:message
											key='common.save' />
									</a>
									<a href="#" class="easyui-linkbutton" onclick="cancelEdit()"><bean:message
											key='common.cancel' />
									</a>
								</c:if>
							</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td><bean:message key="common.resource.alias" /></td>
							<td><c:if test="${mode eq 'view' }">
								${resource.alias}
							</c:if> <c:if test="${mode eq 'edit' }">
									<html:text styleId="resource.alias" property="resource.alias" />
								</c:if></td>
							<td><bean:message key="common.resource.path" /></td>
							<td><c:if test="${!empty resource.id}">
									<fk:path resourceId="${resource.id}" />
								</c:if> <c:if test="${empty resource.id}">
									<fk:path resourceId="${resource.parentId}" />
								</c:if></td>
						</tr>
						<tr>
							<td><bean:message key="common.system.node" />
							</td>
							<td><c:if
									test="${(mode eq 'view') ||(mode eq 'edit' && !resource.privilege)}">
									<c:if test="${resource.systemNode}">
										<bean:message key="common.yes" />&nbsp;
						</c:if>
									<c:if test="${!resource.systemNode}">
										<bean:message key="common.no" />&nbsp;
						</c:if>
									<html:hidden styleId="resource.systemNode"
										property="resource.systemNode" />
								</c:if> <c:if test="${(mode eq 'edit') && resource.privilege}">
									<html:checkbox styleId="resource.systemNode"
										property="resource.systemNode" value="true" />
								</c:if>
							</td>
							<td><bean:message key="common.active" />
							</td>
							<td><c:if test="${mode eq 'view' }">
									<c:if test="${resource.active}">
										<bean:message key="common.yes" />&nbsp;
						</c:if>
									<c:if test="${!resource.active}">
										<bean:message key="common.no" />&nbsp;
						</c:if>
									<html:hidden styleId="resource.active"
										property="resource.active" />
								</c:if> <c:if test="${mode eq 'edit' }">
									<html:checkbox styleId="resource.active"
										property="resource.active" value="true" />
								</c:if>
							</td>
						</tr>
					</table>
					<br>
					<br>
					<div id="tabInfo" style="position:absolute; padding:0px 5px;width:960px;height:480px">
						<c:if test="${3 eq resource.typeId}">
							<div title="Resource List">
								<table width="100%" class="listTable">
									<tr>
										<th width="40%"><bean:message key="common.core.alias" />
										</th>
										<th width="10%"><bean:message key="common.core.type" />
										</th>
										<th width="25%"><bean:message key="common.core.own" />
										</th>
										<th><bean:message key="common.core.last.modfiy" />
										</th>
									</tr>
									<c:if test="${!empty listResource}">
										<c:forEach items="${listResource}" var="res" varStatus="loop">
											<tr class="${loop.index %2 == 0? 'oddRow' :'evenRow'}">
												<td>${res.alias}</td>
												<td><cms:typeImage typeId="${res.typeId}" />
												</td>
												<td><cms:account mode="view"
														identifie="${res.ownResourceId}" target="" /></td>
												<td><fmt:formatDate value="${res.lastUpdatedDt}"
														pattern="dd/MM/yyyy HH:mm:ss" /></td>
											</tr>
										</c:forEach>
									</c:if>
									<c:if test="${empty listResource}">
										<tr>
											<td colspan="4">&nbsp;</td>
										</tr>
									</c:if>
								</table>
							</div>
						</c:if>
						<c:if test="${3 ne resource.typeId}">
							<div title="Details">
								<fk:content var="${content}" typeResourceId="${resource.typeId}"
									mode="${mode}" />
							</div>
						</c:if>
						<div title="System">
							<table width="100%" class="listTable">
								<tr>
									<th width="20%">&nbsp;</th>
									<th width="25%"><bean:message key="common.read" />
									</th>
									<th width="25%"><bean:message key="common.write" />
									</th>
									<th><bean:message key="common.run" />
									</th>
								</tr>
								<c:set var="isDisable" value="${mode eq 'view' ? true : false}" />
								<tr class="oddRow">
									<td><bean:message key="common.current.user" />
									</td>
									<td><html:checkbox styleId="permission(0)"
											property="permission(0)" disabled="${isDisable}" />
									</td>
									<td><html:checkbox styleId="permission(1)"
											property="permission(1)" disabled="${isDisable}" />
									</td>
									<td><html:checkbox styleId="permission(2)"
											property="permission(2)" disabled="${isDisable}" />
									</td>
								</tr>
								<tr class="evenRow">
									<td><bean:message key="common.current.group" />
									</td>
									<td><html:checkbox styleId="permission(3)"
											property="permission(3)" disabled="${isDisable}" />
									</td>
									<td><html:checkbox styleId="permission(4)"
											property="permission(4)" disabled="${isDisable}" />
									</td>
									<td><html:checkbox styleId="permission(5)"
											property="permission(5)" disabled="${isDisable}" />
									</td>
								</tr>
								<tr class="oddRow">
									<td><bean:message key="common.others" />
									</td>
									<td><html:checkbox styleId="permission(6)"
											property="permission(6)" disabled="${isDisable}" />
									</td>
									<td><html:checkbox styleId="permission(7)"
											property="permission(7)" disabled="${isDisable}" />
									</td>
									<td><html:checkbox styleId="permission(8)"
											property="permission(8)" disabled="${isDisable}" />
									</td>
								</tr>

								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="2"><bean:message key="common.own" />
									</td>
									<td colspan="2"><cms:account mode="${mode}"
											target="resource.longString(ownResourceId)"
											identifie="${resource.ownResourceId}" /></td>
								</tr>
								<tr>
									<td colspan="2"><bean:message key="common.own.group" />
									</td>
									<td colspan="2"><cms:group mode="${mode}"
											target="resource.longString(ownGroupResourceId)"
											identifie="${resource.ownGroupResourceId}" /></td>
								</tr>
								<tr>
									<td colspan="2"><bean:message key="common.create.date" />
									</td>
									<td colspan="2"><fmt:formatDate
											value="${resource.createdDt}" pattern="dd/MM/yyyy HH:mm:ss" />
										&nbsp;</td>
								</tr>
								<tr>
									<td colspan="2"><bean:message
											key="common.lastest.update.date" />
									</td>
									<td colspan="2"><fmt:formatDate
											value="${resource.lastUpdatedDt}"
											pattern="dd/MM/yyyy HH:mm:ss" /> &nbsp;</td>
								</tr>
							</table>
						</div>
					</div>
				</c:if>
			</html:form>
		</c:otherwise>
	</c:choose>
</body>
</html:html>