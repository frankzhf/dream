<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html:html>
<head>
<title><bean:message key="selector.resource" />
</title>
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
	<c:if test="${empty selectedLinkList}">
		var selectedLinkList = '' ;
	</c:if>
	<c:if test="${!empty selectedLinkList}">
		var selectedLinkList = ${selectedLinkList} ;
	</c:if>
	
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/global.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/common.js"></script>
<!-- DWR lib -->
<script src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script src='${pageContext.request.contextPath}/dwr/util.js'></script>
<!-- Tree lib -->
<jsp:include page="../../global/jsp/xloadtree2b/webFXTreeConfig.jsp" />
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

<script type="text/javascript">
	function triggerRetrieveChildren(){
		var nodeId = tree.getSelected().getId();
		queryAjax.checkResourceNode(nodeId,function(isResourceNode){
			if(isResourceNode){
				var typeId = '${typeId}';
				retrieveChildren(nodeId,typeId);
			}
		});
	}
	function selectedEvent(){
		var selectedNode = tree.getSelected();
		parent.document.getElementById('src').value = 'http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/attachment?resourceId='+selectedNode.id;
		parent.ImageDialog.showPreviewImage(parent.document.getElementById('src').value);
	}
</script>
</head>
<body>
<div style="height:400px;">
<fk:tree builder="net.frank.cms.web.core.tag.DialogTree" rootName="root" 
	callback="javascript:triggerRetrieveChildren()" parameter="${typeId}" />
</div>
</body>
<script>
if(selectedLinkList != null && selectedLinkList.length > 0){
	retrieveChildrenArray(selectedLinkList,${typeId},0);
}
</script>
</html:html>