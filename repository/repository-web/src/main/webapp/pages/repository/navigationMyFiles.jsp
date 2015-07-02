<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script type="text/javascript">
	function deleteTreeNode(nodeId){
		var node = getNodeById(nodeId);
		var parent = node.getParent();
		parent.remove(node);
	}
	
	function addTreeNode(parentId,_child){
		var parentNode = getNodeById(parentId);
		var _childNode = new WebFXTreeItem(_child.alias,'javascript:showInformationDetails(tree.getSelected().getId())');
		_childNode.setId(_child.id);
		processIcon(_child,_childNode);
		parentNode.add(_childNode);
	}
	
	function updateTreeNodeName(folderId,name){
		var treeNode = getNodeById(folderId);
		treeNode.setText(name);
	}
	
	function showInformationDetails(id) {
		if(id!=0){
			parent.openUrl(
					'${pageContext.request.contextPath}/repository/listMyFiles.do?folder.id='+ id);
		}else{
			parent.openUrl(
					'${pageContext.request.contextPath}/repository/myReceived.do');
		}
	}
</script>

<body>
	<div style="position:absolute;top:0px;left:0px;overflow-y:auto;">
	<fk:tree rootName="root"
		builder="net.frank.repository.web.tags.MyFilesTreeBuilder"
		callback="javascript:showInformationDetails(tree.getSelected().getId())" />
	</div>
</body>