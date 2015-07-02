<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
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

<link type="text/css" rel="stylesheet"
	href='${pageContext.request.contextPath}/global/css/xloadtree2b/xtree2.css' />
<script src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script src='${pageContext.request.contextPath}/dwr/util.js'></script>
<jsp:include page="../../global/jsp/xloadtree2b/webFXTreeConfig.jsp" />
<script
	src='${pageContext.request.contextPath}/dwr/interface/queryAjax.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/xloadtree2b/xtree2.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/xloadtree2b/xloadtree2.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/tree-ext.js'></script>
</head>
<script type="text/javascript">
	function showInformationDetails(id) {
		UpdateTreeNode(id);
		parent.parent.openUrl(
			'${pageContext.request.contextPath}/core/viewInformDetails.do?resource.id='+ id);
	}
</script>

<body>
	<div style="position:absolute;top:0px;left:0px;overflow-y:auto;"><fk:tree rootName="root"
		builder="net.frank.cms.web.core.tag.ResourceSystemTree"
		callback="javascript:showInformationDetails(tree.getSelected().getId())" />
	</div>
</body>
</html>