<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script
	src='${pageContext.request.contextPath}/dwr/interface/queryAjax.js'></script>
	
<script type="text/javascript">
	<c:if test="${empty selectedLinkList}">
		var selectedLinkList = '' ;
	</c:if>
	<c:if test="${!empty selectedLinkList}">
		var selectedLinkList = ${selectedLinkList} ;
	</c:if>
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
	}
</script>

<fk:tree builder="net.frank.cms.web.core.tag.DialogTree" rootName="root" 
	callback="javascript:triggerRetrieveChildren()" paramMap="${paramMap}" />
<script>
if(selectedLinkList != null && selectedLinkList.length > 0){
	//alert("call retrieveChildrenArray");
	retrieveChildrenArray(selectedLinkList,${typeId},0);
}
</script>