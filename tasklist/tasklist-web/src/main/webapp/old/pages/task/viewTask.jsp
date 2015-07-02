<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script type="text/javascript" src='${pageContext.request.contextPath}/dwr/interface/taskAjax.js'></script>

<fk:resource var="taskToken" resourceId="${resource.id}"/>

<script type="text/javascript">
$(function() {
	$("#taskToken").panel({  
		//title: title,
		modal:true,
		content : '<iframe frameborder="0"  src="${pageContext.request.contextPath}/task/viewTaskDetails.do?resource.id='+${resource.id}+'" style="width:100%;height:100%;"></iframe>'
	});
	$("#taskHis").panel({  
		//title: title,
		modal:true,
		content : '<iframe frameborder="0"  src="${pageContext.request.contextPath}/task/viewTaskHistory2.do?resource.id='+${resource.id}+'" style="width:100%;height:100%;"></iframe>'
	});
	$("#goBack").bind('click',function(){
		window.location = '${pageContext.request.contextPath}/dashboard.do';
	});
});
</script>
<div id="taskToken" region="west" border="false" style="width:550px;" split="true">
</div>
<div id="taskHis" region="center" border="false">
</div>
<div id="commandBar" region="south" border="false" style="height:35px">
	<a class="easyui-linkbutton" iconCls="icon-undo" 
	href="javascript:void(0)" id="goBack"><bean:message
		key="common.back" /></a>
</div>

