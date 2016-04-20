<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragrma","no-cache");
	response.setDateHeader("Expires",0);
%>
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/icon.css">
<script type="text/javascript">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/dialog.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery-common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery-easyui-common.js"></script>	
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/paginator.js"></script>
<!-- DWR lib -->
<script type="text/javascript" src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<jsp:include page="../../jsp/cmsMessageConfig.jsp" />
</head>
<body class="easyui-layout">
<tiles:get name="content" />
</body>
</html>