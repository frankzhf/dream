<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="net.frank.framework.web.security.ClientSession" %>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragrma","no-cache");
	response.setDateHeader("Expires",0);
%>

<html:html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<title><bean:message key="welcome.title" /></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/jqplot/css/jquery.jqplot.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/project.css">
<script type="text/javascript">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jqplot/scripts/jquery.jqplot.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery-common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery-easyui-common.js"></script>	

<script type="text/javascript">
function confirm(confirmTitle, confirmMessage, successFunction,failureFunction) {
	var _defaultFunction = function (){$('#confirmDiv').window('close');};
	$('#confirmDiv').dialog({
		title : confirmTitle,
		width : 300,
		height : 150,
		modal : true,
		content : confirmMessage,
		buttons : [ {
			text : '<bean:message key="common.ok"/>',
			handler : successFunction !=null ? successFunction : _defaultFunction
		}, {
			text : '<bean:message key="common.cancel"/>',
			handler : failureFunction !=null ? failureFunction : _defaultFunction
		} ]
	});
}
function openUrl(title, href){
	$("#center").panel({  
		title: title,  
		modal:true,
		content : '<iframe frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>'
	});
}
</script>
</head>

<body class="easyui-layout">
<div id="north" region="north"
	border="false" style="height: 65px;" 
	href="${pageContext.request.contextPath}/common/<tiles:getAsString name='header'/>"></div>
<div id="center" region="center" border="false" title="<bean:message key='common.layout.dashboard' />"
	href="${pageContext.request.contextPath}/<tiles:getAsString name='body'/>"></div>
<div id="confirmDiv"></div>
<div id="dialogDiv"></div>
</body>
</html:html>