<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.frank.framework.bo.Resource" %>

<fk:cs/>
<fk:resource var="currentHome" resourceId="${cs.account.home$3.id}"/>
<fk:resource var="pendingTasks" parentResource="${currentHome}" alias="pendingTask"/>

<script type="text/javascript" src='${pageContext.request.contextPath}/dwr/interface/taskAjax.js'></script>

<script>
function workingTask(resourceId,taskId){
	top.openUrl('<bean:message key="dashboard.layout.working.task" />   '+taskId
			,'${pageContext.request.contextPath}/task/workingTask.do?resource.id='+resourceId);
}

function assignTask(resourceId,accountResId){
	var returnValue = dialogSelector2('content(16).account$5',accountResId);
	if(returnValue && returnValue.flag){
		if(accountResId!=returnValue.value.nodeId){
			taskAjax.assignTask(resourceId,returnValue.value.nodeId,function(value){
				if(value!=0){
					if(value==-3){
						top.$.messager.alert('<bean:message key="common.error" />',
							'<bean:message key="dashboard.errors.account.not.permission" />');
					}else if(value==-2){
						top.$.messager.alert('<bean:message key="common.error" />',
							'<bean:message key="dashboard.errors.task.not.opened" />');
					}else if(value==-1){
						top.$.messager.alert('<bean:message key="common.error" />',
							'<bean:message key="errors.general" />');
					}
				}else{
					top.openUrl('<bean:message key="common.layout.dashboard" />','${pageContext.request.contextPath}/desktop.do');
				}
			});
		}
	}
}

function closeTask(resourceId){
	taskAjax.closeTask(resourceId,function(value){
		if(value!=0){
			if(value==-2){
				top.$.messager.alert('<bean:message key="common.error" />',
					'<bean:message key="dashboard.errors.task.not.opened" />');
			}else if(value==-1){
				top.$.messager.alert('<bean:message key="common.error" />',
					'<bean:message key="errors.general" />');
			}
		}else{
			top.openUrl('<bean:message key="common.layout.dashboard" />','${pageContext.request.contextPath}/desktop.do');
		}
	});
}

</script>

<table width="100%">
	<tr>
		<th><bean:message key="dashboard.pending.task.id" /></th>
		<th><bean:message key="dashboard.pending.task.summary" /></th>
		<th><bean:message key="dashboard.pending.task.own" /></th>
		<th><bean:message key="dashboard.pending.assign.time" /></th>
		<th><bean:message key="dashboard.common.operate"/></th>
	</tr>
<c:if test="${empty pendingTasks.children}">
	<tr>
		<td colspan="4"><bean:message key="common.message.no.match.records" /></td>
	</tr>
</c:if>
<c:if test="${!empty pendingTasks.children}">
	<c:forEach items="${pendingTasks.children}" var="currRes" varStatus="loop">
		<fk:resource var="currRes" resourceId="${currRes.id}" />
		<c:if test="${currRes.typeId eq 16}">
	<tr>	
			<fk:resource var="currTask" resourceId="${currRes.object.task$15.id}" />
			<fk:resource var="currOwn" resourceId="${currTask.ownResourceId}" />	
		<td align="left">${currTask.object.taskId}</td>
		<td align="left">${currTask.object.taskSummary}</td>
		<td align="left">
			${currOwn.object.loginName}</td>
		<td align="left"><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${currRes.createdDt}" /></td>
		<td align="left">
			<input type="button" value="<bean:message key='dashboard.pending.working' />" 
				onclick="workingTask(${currRes.id},'${currRes.alias}')">
			<input type="button" value="<bean:message key='dashboard.pending.assign' />" 
				onclick="assignTask(${currRes.id},${currRes.object.account$5.id})">
			<c:if test="${currTask.ownResourceId  eq cs.account.resource.id}">
				<input type="button" value="<bean:message key='dashboard.pending.close' />" 
				onclick="closeTask(${currRes.id})">
			</c:if>
		</td>
	</tr>
		</c:if>
	</c:forEach>
</c:if>
</table>