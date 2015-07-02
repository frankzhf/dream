<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ page import="net.frank.framework.web.security.ClientSession"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
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
	function openUrl(href){
	$("#center").panel({
		modal:true,
		content : '<iframe frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>'
	});
}
</script>
</head>



<body class="easyui-layout">
	<div id="west" region="west" border="false" split="true" title="Organization Chart"
	style="width: 220px; padding: 5px;">
		<iframe id="treeNav" name="treeNav" frameborder="0"  src="${pageContext.request.contextPath}/admin/staffTree.do" style="width:100%;height:100%;"></iframe>
	</div>
	<div id="center" region="center" border="false" title="Details">
	</div>
</body>
</html:html>