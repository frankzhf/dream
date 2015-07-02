<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script type="text/javascript">

function showInformationDetails(nodeId){
	var funfilter = function(resource){
		if(resource!=null && (resource.typeId == 3)){
			return true;
		}
		return false;
	}
	UpdateTreeNode2(nodeId,funfilter);
}
parent.openUrl('${pageContext.request.contextPath}/repository/dialogOtherInfo.do?file.id='+${file.id}+'&'+Math.random());
</script>
<fk:tree rootName="root" builder="net.frank.repository.web.tags.PublishedTreeBuilder" showRoot="false"
	callback="javascript:showInformationDetails(tree.getSelected().getId())" paramMap="${paramMap}"/>