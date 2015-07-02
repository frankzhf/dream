<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<script type="text/javascript" src='${pageContext.request.contextPath}/dwr/interface/taskAjax.js'></script>

<div id="myDrafts">
</div>
<div id="pendingTasks">
</div>
<div id="myUnits">
</div>
<div id="myTasks">
</div>

<script type="text/javascript">
$(function() {
	var parentWidth = $(window).width();
	var parentHeight = $(window).height();
	//Row 1
	$("#myDrafts").window({
		title:'<bean:message key="common.dashboard.my.drafts" />',
		closable:false,
		minimizable:false,
		maximizable:false,
		draggable:false,
		resizable:false,
		width:parentWidth/2-10,
		height:parentHeight/2-10,
		left: 5,
		top: 5
	});
	
	$("#pendingTasks").window({
		title:'<bean:message key="common.dashboard.pending.tasks" />',
		closable:false,
		minimizable:false,
		maximizable:false,
		draggable:false,
		resizable:false,
		width:parentWidth/2-10,
		height:parentHeight/2-10,
		left: parentWidth/2,
		top: 5
	});
	
	//Row 2
	$("#myUnits").window({
		title:'<bean:message key="common.dashboard.my.units" />',
		closable:false,
		minimizable:false,
		maximizable:false,
		draggable:false,
		resizable:false,
		width:parentWidth/2-10,
		height:parentHeight/2-10,
		left: 5,
		top: parentHeight/2
	});
	
	$("#myTasks").window({
		title:'<bean:message key="common.dashboard.my.tasks" />',
		closable:false,
		minimizable:false,
		maximizable:false,
		draggable:false,
		resizable:false,
		width:parentWidth/2-10,
		height:parentHeight/2-10,
		left: parentWidth/2,
		top: parentHeight/2
	});
	$("#myDrafts").window("refresh","${pageContext.request.contextPath}/dashboard/myDrafts.do");
	$("#pendingTasks").window("refresh","${pageContext.request.contextPath}/dashboard/pendingTasks.do");
	$("#myUnits").window("refresh","${pageContext.request.contextPath}/dashboard/myUnits.do");
	$("#myTasks").window("refresh","${pageContext.request.contextPath}/dashboard/myTasks.do");
	$(window).resize(function(){
		var parentWidth = $(window).width();
		$("#myDrafts").window({
			width:parentWidth/2-10,
			height:parentHeight/2-10,
			left: 5,
			top: 5
		});
		
		$("#pendingTasks").window({
			width:parentWidth/2-10,
			height:parentHeight/2-10,
			left: parentWidth/2,
			top: 5
		});
		$("#myUnits").window({
			width:parentWidth/2-10,
			height:parentHeight/2-10,
			left: 5,
			top: parentHeight/2
		});
		
		$("#myTasks").window({
			width:parentWidth/2-10,
			height:parentHeight/2-10,
			left: parentWidth/2,
			top: parentHeight/2
		});
	});
});
</script>
