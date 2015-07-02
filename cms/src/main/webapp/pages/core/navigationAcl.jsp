<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script src='${pageContext.request.contextPath}/dwr/util.js'></script>
<script
	src='${pageContext.request.contextPath}/dwr/interface/cmsAjax.js'></script>

<script type="text/javascript">
	var GLOBAL_CMS_MESSAGE_OK = 0;
<c:if test="${empty selectedLinkList}">
	var selectedLinkList = '' ;
</c:if>
<c:if test="${!empty selectedLinkList}">
	var selectedLinkList = ${selectedLinkList} ;
</c:if>
	var funfilter = function(resource){
		if(resource!=null && (resource.typeId == 3 || resource.typeId == 5 || resource.typeId == 6 )){
			return true;
		}
		return false;
	}
	function showInformationDetails(nodeId){
		UpdateTreeNode2(nodeId,funfilter);
	}
	
</script>
<div style="height:300px;">
<fk:tree builder="net.frank.cms.web.core.tag.NavigationTree" rootName="root" 
	callback="javascript:showInformationDetails(tree.getSelected().getId())" />
</div>

<script>
function initSelectedTreeNode(){
	<c:if test="${empty acl.permission}">
	var permission = 0;
	</c:if>
	<c:if test="${!empty acl.permission}">
	var permission = ${acl.permission};
	</c:if>
	parent.openUrl('${pageContext.request.contextPath}/core/permissionAcl.do?permission='+permission+'&'+Math.random());
}
if(selectedLinkList != null && selectedLinkList.length > 0){
	retrieveChildrenArray2(selectedLinkList,funfilter,0);	
}
setTimeout(initSelectedTreeNode,500);
</script>