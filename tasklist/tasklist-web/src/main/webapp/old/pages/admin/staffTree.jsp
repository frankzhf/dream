<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
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
	src='${pageContext.request.contextPath}/dwr/interface/resourceAjax.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/xloadtree2b/xtree2.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/xloadtree2b/xloadtree2.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/tree-ext.js'></script>
<script
	src='${pageContext.request.contextPath}/dwr/interface/treeAjax.js'></script>
</head>
<script type="text/javascript">
	function showInformationDetails(id) {
		parent.openUrl(
			'${pageContext.request.contextPath}/admin/viewOrganizationDetails.do?resource.id='+ id);
	}
</script>

<body>
	<div style="position:absolute;top:0px;left:0px;overflow-y:auto;"><fk:tree rootName="root"
		builder="net.frank.web.admin.tag.StaffInformTree"
		callback="javascript:showInformationDetails(tree.getSelected().getId())" />
	</div>
</body>
</html>