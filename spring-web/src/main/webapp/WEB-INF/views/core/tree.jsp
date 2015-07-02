<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="fk" uri="http://www.frank.net/jsp/tags"%>

<layout:tree treeTag="testTree">
<script type="text/javascript">
function showInformationDetails(id) {
	UpdateTreeNode(id);
	top.showDetails(id);
}
</script>
<fk:tree rootName="root" 
	builder="net.frank.site.xtree2.builder.NavigationTree"
	callback="showInformationDetails(tree.getSelected().getId())"/>
</layout:tree>