<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.frank.framework.bo.Resource" %>

<fk:cs/>

<fk:resource var="currentHome" resourceId="${cs.account.home$3.id}"/>
<fk:resource var="tasklist" parentResource="${currentHome}" alias="tasklist"/>
<fk:resource var="pendingTasks" parentResource="${tasklist}" alias="pendingTask"/>

<script type="text/javascript" src='${pageContext.request.contextPath}/dwr/interface/taskAjax.js'></script>

<script>
function workingTask(resourceId,taskId){
	top.openUrl('<bean:message key="dashboard.layout.working.task" />   '+taskId
			,'${pageContext.request.contextPath}/tasklist/workingTask.do?resource.id='+resourceId);
}

function assignTask(resourceId,accountResId){
	var _closeDialog = function(){
		top.$('#dialogDiv').window('close');
	};
	var url = "${pageContext.request.contextPath}/tasklist/dialogAssignTask.do?resourceId=" + resourceId +"&accountResId=" +accountResId;
	top.$('#dialogDiv').dialog({
		title : '<bean:message  key="task.dialog.title.assign.to" />',
		width : 650,
		height : 430,
		modal : true,
		content : '<iframe id="assignTaskIframe" frameborder="0" src="' + url +'" style="width:100%;height:100%;"></iframe>',
		buttons : [{
			text : '<bean:message key="common.ok"/>',
			handler : function (){
				var newAccountResId = top.$("#assignTaskIframe")[0].contentWindow.$("#selectedId").val();
				if(newAccountResId == null || newAccountResId ==''){
					top.$("#assignTaskIframe")[0].contentWindow.$("#errorMessage").html("<font color='red'><bean:message key='dashboard.errors.assign.to.nobody' /></font>");
				}else{
					_closeDialog();
					taskAjax.assignTask(resourceId,newAccountResId,function(value){
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
							top.openUrl('<bean:message key="common.layout.dashboard" />','${pageContext.request.contextPath}/tasklist/dashboard.do');
						}
					});
				}	
			}
		},
		{
			text : '<bean:message key="common.cancel"/>',
			handler : _closeDialog
		}]
	});
	
	
	/***
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
					top.openUrl('<bean:message key="common.layout.dashboard" />','${pageContext.request.contextPath}/tasklist/dashboard.do');
				}
			});
		}
	}
	***/
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
			top.openUrl('<bean:message key="common.layout.dashboard" />','${pageContext.request.contextPath}/tasklist/dashboard.do');
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
		<c:if test="${currRes.typeId eq 50003}">
	<tr>	
			<fk:resource var="currTask" resourceId="${currRes.object.task$50002.id}" />
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
				onclick="assignTask(${currRes.id},${currOwn.id})">
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