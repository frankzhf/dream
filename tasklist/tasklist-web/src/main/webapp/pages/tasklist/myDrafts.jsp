<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fk:cs/>
<fk:resource var="currentHome" resourceId="${cs.account.home$3.id}"/>
<fk:resource var="tasklist" parentResource="${currentHome}" alias="tasklist"/>
<fk:resource var="myDrafts" parentResource="${tasklist}" alias="draft"/>

<script type="text/javascript">
function editDraft(resourceId,taskSummary){
	top.openUrl('<bean:message key="dashboard.layout.edit.draft" />   '+taskSummary
			,'${pageContext.request.contextPath}/tasklist/editDraft.do?resource.id='+resourceId);
}

function openTask(resourceId){
	var goDashboardFun = function() {
		taskAjax.openTask(resourceId,function(value){
			if(value!=0){
				if(value==-2){
					top.$.messager.alert('<bean:message key="common.error" />',
						'<bean:message key="dashboard.errors.task.has.closed" />');
				}else if(value==-1){
					top.$.messager.alert('<bean:message key="common.error" />',
						'<bean:message key="errors.general" />');
				}
			}
			top.openUrl('<bean:message key="common.layout.dashboard" />','${pageContext.request.contextPath}/tasklist/dashboard.do');
		});
		top.$('#confirmDiv').window('close');
	};
	top.confirm("<bean:message key='common.warning' />",
			"<bean:message key='dashboard.message.do.you.open.task' />",
			goDashboardFun, null);
}

</script>

<table width="100%">
	<tr>
		<th><bean:message key="dashboard.my.drafts.task.summary" /></th>
		<th><bean:message key="dashboard.my.drafts.project.name" /></th>
		<th><bean:message key="dashboard.my.drafts.task.create.date" /></th>
		<th><bean:message key="dashboard.common.operate"/></th>
	</tr>
<c:if test="${empty myDrafts.children}">
	<tr>
		<td colspan="4"><bean:message key="common.message.no.match.records" /></td>
	</tr>
</c:if>
<c:if test="${!empty myDrafts.children}">
	<c:forEach items="${myDrafts.children}" var="currRes" varStatus="loop">
		<fk:resource var="currRes" resourceId="${currRes.id}" />
		<c:if test="${currRes.typeId eq 50002}">
	<tr>
			<fk:resource var="currUnit" resourceId="${currRes.object.unit$14.id}" />
		<td align="left">${currRes.alias}</td>
		<td align="left">${currUnit.alias}</td>
		<td align="left"><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${currRes.createdDt}" /></td>
		<td align="left">
			<input type="button" value="<bean:message key='common.edit' />" 
				onclick="editDraft(${currRes.id},'${currRes.alias}')">
			<input type="button" value="<bean:message key='dashboard.common.open' />" 
				onclick="openTask(${currRes.id})">
		</td>
	</tr>
		</c:if>
	</c:forEach>
</c:if>
</table>