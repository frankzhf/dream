<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script
	src='${pageContext.request.contextPath}/dwr/interface/adminAjax.js'></script>

<script type="text/javascript">
	function showInformationDetails(id) {
		var needSelectedNode = getNodeById(id);
		tree.setSelected(needSelectedNode);
		if (id != -1) {
			var funRemoveNode = function(_treeNode){
				while(_treeNode.hasChildren()){
					var firstNode = _treeNode.firstChild;
					funRemoveNode(firstNode);
				}
				var _parent =_treeNode.getParent();
				webFXTreeHandler.removeNode(_treeNode);
				_parent.remove(_treeNode);
			};
			adminAjax.getDepartmentChildren(id,function(rt){
				if(rt!=null){
					while(needSelectedNode.hasChildren()){
						funRemoveNode(needSelectedNode.firstChild);
					}
					for(var i=0;i<rt.length;i++){
						var _child = rt[i];
						var _childNode = new WebFXTreeItem(_child.name,'javascript:showInformationDetails(tree.getSelected().getId())');
						_childNode.setId(_child.id);
						processIcon(_child,_childNode);
						needSelectedNode.add(_childNode);
					}
				}
			});
			
			parent.openUrl(
					'${pageContext.request.contextPath}/admin/showDepartmentDetails.do?resource.id='+ id);
		} else {
			top.$.messager
					.alert('<bean:message key="common.warning" />',
							'<bean:message key="admin.navigation.department.errors.no.department.watched" />');
		}
	}
	
</script>
<body>
	<div style="position:absolute;top:0px;left:0px;overflow-y:auto;">
	<fk:tree rootName="root"
		builder="net.frank.cms.web.admin.tag.DeparentTreeBuilder"
		callback="javascript:showInformationDetails(tree.getSelected().getId())" />
	</div>
</body>