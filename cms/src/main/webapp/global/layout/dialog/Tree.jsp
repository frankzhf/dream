<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/panel.css" />
<link type="text/css" rel="stylesheet"
	href='${pageContext.request.contextPath}/global/css/xloadtree2b/xtree2.css' />
<script type="text/javascript">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/global.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/common.js"></script>
<!-- DWR lib -->
<script src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script src='${pageContext.request.contextPath}/dwr/util.js'></script>
<!-- prototype lib -->
<script src='${pageContext.request.contextPath}/global/scripts/prototype.js'></script>
<!-- Tree lib -->
<jsp:include page="/global/jsp/xloadtree2b/webFXTreeConfig2.jsp" />
<script
	src='${pageContext.request.contextPath}/global/scripts/xloadtree2b/xtree2.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/xloadtree2b/xmlextras.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/xloadtree2b/xloadtree2.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/tree-ext.js'></script>
	
<!-- Resource ajax function -->
<script
	src='${pageContext.request.contextPath}/dwr/interface/queryAjax.js'></script>
<script
	src='${pageContext.request.contextPath}/dwr/interface/cmsAjax.js'></script>

<script type="text/javascript">
	var result={
		flag:false,
		value: {fieldName :'${fieldName}',
				typeId :'${typeId}',
				nodeId:'',
				alais:''}
	};
	window.returnValue = result;
</script>

<tiles:get name="content" />

</html>