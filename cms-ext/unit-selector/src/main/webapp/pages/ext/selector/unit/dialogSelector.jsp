<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<fk:tree builder="net.frank.cms.ext.selector.unit.tag.DialogUnitSelectorTreeBuilder" rootName="root" 
	paramMap="${paramMap}" />
<script type="text/javascript">
<c:if test="${empty selectedLinkList}">
var selectedLinkList = '' ;
</c:if>
<c:if test="${!empty selectedLinkList}">
var selectedLinkList = ${selectedLinkList} ;

if(selectedLinkList!=null && selectedLinkList.length >0){
	for(var i=0;i<selectedLinkList.length;i++){
		var nodeId = selectedLinkList[i];
		var needSelectedNode = getNodeById(nodeId);
		tree.setSelected(needSelectedNode);
		if(i< (selectedLinkList.length-1))
			needSelectedNode.setExpanded(true);
	}
}

</c:if>
</script>