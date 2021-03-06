function getNodeById(nodeId){
	if(webFXTreeHandler){
		return webFXTreeHandler.all[nodeId];
	}
	return null;
}
/**
 * 
 */
function UpdateTreeNode(nodeId){
	var needSelectedNode = getNodeById(nodeId);
	tree.setSelected(needSelectedNode);
	var funRemoveNode = function(_treeNode){
		while(_treeNode.hasChildren()){
			var firstNode = _treeNode.firstChild;
			funRemoveNode(firstNode);
		}
		var _parent =_treeNode.getParent();
		webFXTreeHandler.removeNode(_treeNode);
		_parent.remove(_treeNode);
	};
	var url = UiApp.contextPath +"/tree/getChildren/" + nodeId;
	jQuery.ajax({
		type : 'get',
		url : url,
        contentType: "application/xml",
		success : function(data) {
			var xmlObject = $(data);
			needSelectedNode.text = xmlObject.find("property[name=alias]").text();
			while(needSelectedNode.hasChildren()){
				funRemoveNode(needSelectedNode.firstChild);
			}
			xmlObject.find("property[name=children]").children().each(function(){
				var childId = $(this).attr("id");
				var callUrl = UiApp.contextPath +"/tree/getChildren/" + childId;
				jQuery.ajax({
					type : 'get',
					url : callUrl,
			        contentType: "application/xml",
					success : function(childData) {
						var childXml = $(childData);
						var _childId = childXml.find("property[name=id]").text();
						var _childName = childXml.find("property[name=alias]").text();
						var _childNode = new WebFXTreeItem(_childName,'javascript:showInformationDetails(tree.getSelected().getId())');
						_childNode.setId(_childId);
						processIcon2(childXml,_childNode);
						needSelectedNode.add(_childNode);
					},
					error : function() {
					}
				});
			});
			
		},
		error : function() {
		}
	});
}

/***
 * CMS re-write UpdateTreeNode 
 * this function need to refer
 * 		cmsMessageConfig.jsp
 * 		cmsAjax.js
 * add permission control && filter
 */
function UpdateTreeNode2(nodeId,filter){
	var funRemoveNode = function(_treeNode){
		while(_treeNode.hasChildren()){
			var firstNode = _treeNode.firstChild;
			funRemoveNode(firstNode);
		}
		var _parent =_treeNode.getParent();
		webFXTreeHandler.removeNode(_treeNode);
		_parent.remove(_treeNode);
	};
	var needSelectedNode = getNodeById(nodeId);
	tree.setSelected(needSelectedNode);
	cmsAjax.retrieveChildren(nodeId,function(resource){
		if(GLOBAL_CMS_MESSAGE_OK == resource.code){
			if(resource.children!=null && resource.children.length>0){
				while(needSelectedNode.hasChildren()){
					funRemoveNode(needSelectedNode.firstChild);
				}
				for(var i=0;i<resource.children.length;i++){
					var child = resource.children[i];
					cmsAjax.retrieveChildren(child.id,function(_child){
						if(GLOBAL_CMS_MESSAGE_OK == resource.code){
							var addOperator = false;
							if(filter == null){
								addOperator = true;
							}else{
								if(filter(_child)){
									addOperator = true;
								}
							}
							if(addOperator){
								var _childNode = new WebFXTreeItem(_child.alias,'javascript:showInformationDetails(tree.getSelected().getId())');
								_childNode.setId(_child.id);
								processIcon(_child,_childNode);
								needSelectedNode.add(_childNode);
							}
						}
					});
				}
			}
		}
	});
}

/**
 * used this function need check the node's children is empty. Main used dialog tree selector
 */
function retrieveChildren(nodeId,typeId){
	var needSelectedNode = getNodeById(nodeId);
	if(needSelectedNode==null){
		alert("Not match specify node.");
		return;
	}
	tree.setSelected(needSelectedNode);
	queryAjax.retrieveChildren(nodeId,typeId,function(currentNode){
		if(currentNode!=null){
			var _children = currentNode.children;
			if(_children != null && _children.length >0){
				for(var i=0;i<_children.length;i++){
					var _child = _children[i];
					if(webFXTreeHandler.all[_child.id] == null){
						var _childNode;
						if(_child.typeId == 3){
							_childNode = new WebFXTreeItem(_child.name,"javascript:retrieveChildren('"+_child.id+"','"+typeId+"')");
						}else{
							_childNode = new WebFXTreeItem(_child.name,"javascript:selectedEvent();");
						}
						_childNode.setId(_child.id);
						processIcon(_child,_childNode);
						needSelectedNode.add(_childNode);
					}else{
						webFXTreeHandler.all[_child.id].text = _child.name;
					}
				}
			}
		}
	});
}
/***
 * 
 * @param array
 * @param typeId
 * @param index
 * @param afterFun
 */
function retrieveChildrenArray(array,typeId,index,afterFun){
	var nodeId = array[index];
	var needSelectedNode = getNodeById(nodeId);
	queryAjax.retrieveChildren(nodeId,typeId,function(currentNode){
		if(currentNode!=null){
			var _children = currentNode.children;
			if(_children != null && _children.length >0){
				for(var i=0;i<_children.length;i++){
					var _child = _children[i];
					if(webFXTreeHandler.all[_child.id] == null){
						var _childNode;
						if(_child.typeId == 3){
							_childNode = new WebFXTreeItem(_child.name,"javascript:retrieveChildren('"+_child.id+"','"+typeId+"')");
						}else{
							_childNode = new WebFXTreeItem(_child.name,"javascript:selectedEvent();");
						}
						_childNode.setId(_child.id);
						processIcon(_child,_childNode);
						needSelectedNode.add(_childNode);
					}else{
						webFXTreeHandler.all[_child.id].text = _child.name;
					}
				}
				tree.setSelected(needSelectedNode);
				needSelectedNode.setExpanded(true);
				if(++index<array.length){
					retrieveChildrenArray(array,typeId,index);
				}else{
					if(afterFun){
						afterFun();
					}
				}
			}
		}
	});
}

function retrieveChildrenArray2(array,filter,index,afterFun){
	var nodeId = array[index];
	var needSelectedNode = getNodeById(nodeId);
	cmsAjax.retrieveChildren(nodeId,function(resource){
		if(GLOBAL_CMS_MESSAGE_OK == resource.code){
			if(resource.children!=null && resource.children.length>0){
				for(var i=0;i<resource.children.length;i++){
					var child = resource.children[i];
					cmsAjax.retrieveChildren(child.id,function(_child){
						if(GLOBAL_CMS_MESSAGE_OK == resource.code){
							var addOperator = false;
							if(filter == null){
								addOperator = true;
							}else{
								if(filter(_child)){
									addOperator = true;
								}
							}
							if(addOperator){
								var _childNode = new WebFXTreeItem(_child.alias,'javascript:showInformationDetails(tree.getSelected().getId())');
								_childNode.setId(_child.id);
								processIcon(_child,_childNode);
								needSelectedNode.add(_childNode);
								var nextIndex = index+1;
								if(array[nextIndex] == _child.id){
									tree.setSelected(needSelectedNode);
									needSelectedNode.setExpanded(true);
									retrieveChildrenArray2(array,filter,nextIndex);
								}
								if(_child.id == array[array.length-1]){
									tree.setSelected(_childNode);
									if(afterFun){
										afterFun();
									}
								}
							}
						}
					});
					
				}
			}
		}
	});
}


function processIcon(_child,_childNode){
	var typeId = _child.typeId;
	var icon = _TREE_NODE_ICON[typeId]['nodeIcon'];
	var open = _TREE_NODE_ICON[typeId]['nodeOpenIcon'];
	_childNode.setIcon(icon);
	_childNode.setOpenIcon(open);
}

function processIcon2(_child,_childNode){
	var typeId = _child.find("property[name=typeId]").text();
	var icon = _TREE_NODE_ICON[typeId]['nodeIcon'];
	var open = _TREE_NODE_ICON[typeId]['nodeOpenIcon'];
	_childNode.setIcon(icon);
	_childNode.setOpenIcon(open);
}
