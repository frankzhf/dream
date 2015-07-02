<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<table width="100%" class="listTable">
	<tr>
		<th width="2%">&nbsp;</th>
		<th width="43%"><bean:message key="core.override.date.time" /></th>
		<th width="25%"><bean:message key="core.override.executor" /></th>
		<th><bean:message key="core.compare.details" /></th>
	</tr>
	<c:if test="${!empty historyInfo}">
		<c:forEach items="${historyInfo}" var="sh" varStatus="loop">
			<fk:resource var="account" resourceId="${sh.opResoureId}" />
			<tr class="${loop.index %2 == 0? 'oddRow' :'evenRow'}">
				<td>&nbsp;</td>
				<td><fmt:formatDate value="${sh.logDate}"
						pattern="dd/MM/yyyy HH:mm:ss" /></td>
				<td>${account.object.loginName} &nbsp;</td>
				<td><a href="javascript:showHistoryInfo(${sh.id})"><bean:message
							key="core.show.history" /> &nbsp;</a></td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty historyInfo}">
		<tr>
			<td colspan="4"><bean:message
					key="core.not.watch.history.record" /></td>
		</tr>
	</c:if>
</table>