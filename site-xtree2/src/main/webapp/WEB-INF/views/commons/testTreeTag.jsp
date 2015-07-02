<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fk" uri="/tld/frank.tld" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:tree treeTag="testTree">

<script type="text/javascript">

jQuery(function(){
	alert("bb");
});
function showInformationDetails(id) {
	alert(id);
	UpdateTreeNode(id);
	//parent.parent.openUrl(
	//	'${pageContext.request.contextPath}/core/viewInformDetails.do?resource.id='+ id);
}
</script>
<div style="position:absolute;top:0px;left:0px;overflow-y:auto;">
<fk:tree rootName="root" 
	builder="net.frank.site.xtree2.builder.NavigationTree"
	callback="showInformationDetails(tree.getSelected().getId())"/>
</div>
</layout:tree>