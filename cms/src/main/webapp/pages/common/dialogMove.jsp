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
<jsp:include page="../../global/jsp/xloadtree2b/webFXTreeConfig.jsp" />
<script
	src='${pageContext.request.contextPath}/global/scripts/xloadtree2b/xtree2.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/xloadtree2b/xmlextras.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/xloadtree2b/xloadtree2.js'></script>
<script
	src='${pageContext.request.contextPath}/global/scripts/tree-ext.js'></script>
<script
	src='${pageContext.request.contextPath}/dwr/interface/treeAjax.js'></script>

	
<!-- Resource ajax function -->
<script
	src='${pageContext.request.contextPath}/dwr/interface/resourceAjax.js'></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/validation.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/panel.js"></script>
<script type="text/javascript">
	var result={
		flag:false,
		value: {fieldName :'${fieldName}',
				nodeId:'',
				alais:''}
	};
	
	window.returnValue = result;
	<c:if test="${empty selectedLinkList}">
		var selectedLinkList = '' ;
	</c:if>
	<c:if test="${!empty selectedLinkList}">
		var selectedLinkList = ${selectedLinkList} ;
	</c:if>
	function triggerRetrieveChildren(){
		var nodeId = tree.getSelected().getId();
		resourceAjax.checkResourceNode(nodeId,function(isResourceNode){
			if(isResourceNode){
				var typeId = '${typeId}';
				retrieveChildren(nodeId,typeId);
			}
		});
	}
	
	function selectedEvent(){
		//alert("Trigger Selected Event");
		var selectedNode = tree.getSelected();
		
		result.flag = true;
		result.value.nodeId = selectedNode.id;
		result.value.alais = selectedNode.text;
		self.close();
	}
	function triggerSelectedEvent(){
		if(!tree.getSelected()){
			alert("Should be selected a Folder.");
			return;
		}
		selectedEvent()
	}
	
	function cancel(){
		result.flag = false;
		self.close();
	}
	
</script>
</head>

<body>
<div style="height:400px;">
<fk:tree builder="net.frank.web.common.tag.DialogTree" rootName="root" 
	callback="javascript:triggerRetrieveChildren()" parameter="${typeId}" />
</div>
<input type="button" value="<bean:message key='common.select' />" onclick="triggerSelectedEvent();"> &nbsp;
<input type="button" value="<bean:message key='common.cancel' />" onclick="cancel();">
</body>
<script>
if(selectedLinkList != null && selectedLinkList.length > 0){
	//alert("call retrieveChildrenArray");
	retrieveChildrenArray(selectedLinkList,${typeId},0,function(){
		var node = webFXTreeHandler.all["${fieldValue}"];
		alert(node.id);
		alert(node.hasChildren());
	<c:if test="${disabledFlag eq true}">
		if(node.hasChildren()){
			var nodes = node.getChildren();
			for(var i=0;i<nodes.length;i++){			
				var _node = nodes[i];
				alert(_node.id);
				_node.remove();
			}
		}
	</c:if>
		node.setAction(null);
	});
	
}


</script>
</html:html>