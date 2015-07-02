<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fk:cs/>
<fk:resource var="currentHome" resourceId="${cs.account.home$3.id}"/>
<fk:resource var="tasklist" parentResource="${currentHome}" alias="tasklist"/>
<fk:resource var="myTasks" parentResource="${tasklist}" alias="myTask"/>

<script type="text/javascript">
function viewTask(resourceId,taskId){
	top.openUrl('<bean:message key="dashboard.layout.view.task" />   '+taskId
			,'${pageContext.request.contextPath}/task/viewTask.do?resource.id='+resourceId);
}

function archiveTask(resourceId){
	var goDashboardFun = function(){
		taskAjax.archiveTask(resourceId,function(value){
			if(value!=0){
				if(value==-2){
					top.$.messager.alert('<bean:message key="common.error" />',
						'<bean:message key="dashboard.errors.task.has.opened" />');
				}else if(value==-1){
					top.$.messager.alert('<bean:message key="common.error" />',
						'<bean:message key="errors.general" />');
				}
			}
			top.openUrl('<bean:message key="common.layout.dashboard" />','${pageContext.request.contextPath}/desktop.do');
		});
		top.$('#confirmDiv').window('close');
	}
	top.confirm("<bean:message key='common.warning' />",
			"<bean:message key='dashboard.message.do.you.archive.task' />",
			goDashboardFun, null);
}

</script>

<table width="100%">
	<tr>
		<th><bean:message key="dashboard.own.task.id" /></th>
		<th><bean:message key="dashboard.own.task.summary" /></th>
		<th><bean:message key="dashboard.own.start.date" /></th>
		<th><bean:message key="dashboard.own.end.date" /></th>
		<th><bean:message key="dashboard.common.operate"/></th>
	</tr>
<c:if test="${empty myTasks.children}">
	<tr>
		<td colspan="5"><bean:message key="common.message.no.match.records" /></td>
	</tr>
</c:if>
<c:if test="${!empty myTasks.children}">
	<c:forEach items="${myTasks.children}" var="currRes" varStatus="loop">
		<fk:resource var="currRes" resourceId="${currRes.id}" />
		<c:if test="${currRes.typeId eq 50002}">
	<tr>
		<td align="left">${currRes.object.taskId}</td>
		<td align="left">${currRes.object.taskSummary}</td>
		<td align="left"><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${currRes.object.startDate}" /></td>
		<td align="left"><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${currRes.object.endDate}" /></td>
		<td align="left">
			<input type="button" value="<bean:message key='dashboard.own.view' />" 
				onclick="viewTask(${currRes.id},'${currRes.alias}')">
			<c:if test="${currRes.object.status eq 2}">
				<input type="button" value="<bean:message key='dashboard.own.archive' />" 
					onclick="archiveTask(${currRes.id})">
			</c:if>
		</td>
	</tr>
		</c:if>
	</c:forEach>
</c:if>
</table>