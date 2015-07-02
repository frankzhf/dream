<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script type="text/javascript"
	src='${pageContext.request.contextPath}/dwr/interface/taskAjax.js'></script>

<fk:resource var="taskToken" resourceId="${resource.id}" />

<script type="text/javascript">
$(function() {
	$("#taskToken").panel({
		modal:true,
		content : '<iframe frameborder="0"  src="${pageContext.request.contextPath}/tasklist/processTaskToken.do?resourceId='+${resource.id}+'" style="width:100%;height:100%;"></iframe>'
	});
	$("#taskHis").panel({ 
		modal:true,
		content : '<iframe frameborder="0"  src="${pageContext.request.contextPath}/tasklist/viewTaskHistory.do?resource.id='+${resource.id}+'" style="width:100%;height:100%;"></iframe>'
	});
	$("#btnAssignTo").click(function(){
		dialogSelector('content(50003).account$5');
		var curr_operator = $("#org_assign").val();
		var next_operator = $("#content_50003__account_5").val();
		if(next_operator!=curr_operator){
			taskAjax.assignTask(${resource.id},next_operator,function(value){
				if(value!=0){
					if(value==-3){
						top.$.messager.alert('<bean:message key="common.error" />',
							'<bean:message key="task.working.errors.account.not.permission" />');
					}else if(value==-2){
						top.$.messager.alert('<bean:message key="common.error" />',
							'<bean:message key="task.working.errors.task.not.opened" />');
					}else if(value==-1){
						top.$.messager.alert('<bean:message key="common.error" />',
							'<bean:message key="errors.general" />');
					}
				}else{
					top.openUrl('<bean:message key="common.layout.dashboard" />','${pageContext.request.contextPath}/tasklist/dashboard.do');
				}
			});
		}
	});
	
	$("#gotoDesktop").click(function(){
		var goDashboardFun = function() {
			window.location = '${pageContext.request.contextPath}/tasklist/dashboard.do';
			top.$('#confirmDiv').window('close');
		};
		top.confirm("<bean:message key='common.warning' />",
				"<bean:message key='common.message.go.back.dashboard' />",
				goDashboardFun, null);
	});
	
	
});
</script>
<div id="taskToken" region="west" border="false" style="width: 550px;"
	split="true"></div>
<div id="taskHis" region="center" border="false"></div>
<div id="commandBar" region="south" border="false" style="height: 35px">
	<a class="easyui-linkbutton" iconCls="icon-undo"
		href="javascript:void(0)" id="gotoDesktop"><bean:message
			key="common.back" /></a> <a class="easyui-linkbutton"
		href="javascript:void(0)" id="btnAssignTo"><bean:message
			key="task.assign.to" /></a> <input type="hidden"
		id="content_50003__account_5" name="content(50003).account$5"
		value="${taskToken.object.account$5.id}"> <input type="hidden"
		id="org_assign" value="${taskToken.object.account$5.id}">
</div>

