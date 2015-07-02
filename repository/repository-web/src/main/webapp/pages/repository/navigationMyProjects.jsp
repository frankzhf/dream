<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>



<script type="text/javascript">
	function showInformationDetails(id) {
		if(0 != id){
			var funfilter = function(resource){
				if(resource!=null && resource.typeId == 3){
					return true;
				}
				return false;
			}
			UpdateTreeNode2(id,funfilter);
			parent.openUrl(
				'${pageContext.request.contextPath}/repository/listProjectFiles.do?folder.id='+ id);
		}
	}
</script>
<body>
	<div style="position:absolute;top:0px;left:0px;overflow-y:auto;">
	<fk:tree rootName="root"
		builder="net.frank.repository.web.tags.MyProjectsTreeBuilder"
		callback="javascript:showInformationDetails(tree.getSelected().getId())" />
	</div>
</body>