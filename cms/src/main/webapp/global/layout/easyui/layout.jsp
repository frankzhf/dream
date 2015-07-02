<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
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

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/project.css">

<script type="text/javascript">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>

<!-- DWR lib -->
<script type="text/javascript" 
	src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script type="text/javascript" 
	src='${pageContext.request.contextPath}/dwr/util.js'></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>

<script type="text/javascript">
$(function(){
	<c:if test="${!empty layout.north && !empty layout.north.link}" >
	openUrl('${layout.north.link}','north')
	</c:if>
	<c:if test="${!empty layout.south && !empty layout.south.link}" >
	openUrl('${layout.south.link}','south')
	</c:if>
	<c:if test="${!empty layout.west && !empty layout.west.link}" >
	openUrl('${layout.west.link}','west')
	</c:if>
	<c:if test="${!empty layout.east && !empty layout.east.link}" >
	openUrl('${layout.east.link}','east')
	</c:if>
	<c:if test="${!empty layout.center && !empty layout.center.link}" >
	openUrl('${layout.center.link}','center')
	</c:if>
})
function openUrl(href,layoutId){
	var _layoutId = null;
	if(layoutId != null &&  layoutId != ''){
		_layoutId = layoutId;
	}
	$("#"+_layoutId).panel({
		modal:true,
		content : '<iframe id="'+_layoutId+'details" frameborder="0" src="'+href+'" style="width:100%;height:100%;"></iframe>'
	});
}
</script>
</head>

<body class="easyui-layout">
<c:if test="${! empty layout.north}" >
<div id="north" region="north" border="false" 
	<c:if test="${! empty layout.north.title} ">
		title="<bean:message key='${layout.north.title}' />"
	</c:if>
	style="padding:0px;height: <c:if test='${!empty layout.north.height}'>${layout.north.height}px;</c:if>"
	<c:if test="${layout.north.split}">
	split="true"
	</c:if>
	></div>
</c:if>

<c:if test="${!empty layout.west}" >
<div id="west" region="west" border="false" 
	<c:if test="${!empty layout.west.title} ">
		title="<bean:message key='${layout.west.title}' />"
	</c:if>
	style="padding:0px;width:<c:if test='${!empty layout.west.width}'>${layout.west.width}px;</c:if>"
	<c:if test="${layout.west.split}">
	split="true"
	</c:if>
	></div>
</c:if>

<c:if test="${!empty layout.center}" >
<div id="center" region="center" border="false" 
	<c:if test="${!empty layout.center.title}">
		title="<bean:message key='${layout.center.title}' />"
	</c:if>
></div>
</c:if>

<c:if test="${!empty layout.south}" >
<div id="south" region="south" border="false" 
	<c:if test="${!empty layout.south.title} ">
		title="<bean:message key='${layout.south.title}' />"
	</c:if>
	style="padding:0px;height:<c:if test='${!empty layout.south.height}'>${layout.south.height}px;</c:if>"
	<c:if test="${layout.south.split}">
	split="true"
	</c:if>
	></div>
</c:if>

<c:if test="${!empty layout.east}" >
<div id="east" region="east" border="false" 
	<c:if test="${!empty layout.east.title}">
		title="<bean:message key='${layout.east.title}' />"
	</c:if>
	style="padding:0px;width:<c:if test='${!empty layout.east.width}'>${layout.east.width}px;</c:if>"
	<c:if test="${layout.east.split}">
	split="true"
	</c:if>
	></div>
</c:if>

</body>
</html:html>