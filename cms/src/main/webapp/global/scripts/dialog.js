var _closeDialog = function() {
	top.$('#dialogDiv').window('close');
};

/**
 * 
 */
function dialogSelector(elementName) {
	var _element = $("input[name='" + elementName + "']");
	if (_element) {
		var value = _element.val();
		var url = WEB_ROOT + '/common/dialogSelector.do?fieldName='
				+ elementName + '&fieldValue=' + value;
		top
				.$('#dialogDiv')
				.dialog(
						{
							title : "Selector Dialog",
							width : 380,
							height : 480,
							modal : true,
							content : '<iframe id="selectorDialog" style="width:100%;height:100%;" frameborder="0" src="'
									+ url + '"></iframe>',
							buttons : [
									{
										text : 'Select',
										handler : function() {
											var treenode = top
													.$("#selectorDialog")[0].contentWindow.tree
													.getSelected();
											if(treenode.hasChildren()){
												//TODO fixed error message
												return;
											}
											_closeDialog();
											_element.attr('value', treenode.id);
											var _dailogElement = $("input[name='dialog_"
													+ elementName + "']");
											_dailogElement.attr("readonly",
													false);
											_dailogElement.attr("value",
													treenode.text);
											_dailogElement.attr("readonly",
													true);
										}
									},
									{
										text : 'Clear',
										handler : function() {
											_closeDialog();
											_element.attr('value', '');
											var _dailogElement = $("input[name='dialog_"
													+ elementName + "']");
											_dailogElement.attr("readonly",
													false);
											_dailogElement.attr("value", '');
											_dailogElement.attr("readonly",
													true);
										}
									}, {
										text : 'Cancel',
										handler : _closeDialog
									} ]
						});
	}
}
/*******************************************************************************
 * @param fieldName
 * @param fieldValue
 * @returns
 * 
 * var result={ flag:false, value: {fieldName :'${fieldName}', typeId
 * :'${typeId}', nodeId:'', alais:''} };
 * 
 */
function dialogSelector2(fieldName, fieldValue) {
	var windowWidth = $(window).width();
	var windowHeight = $(window).height();
	var returnValue = window.showModalDialog(WEB_ROOT
			+ '/common/dialogSelector.do?fieldName=' + fieldName
			+ '&fieldValue=' + fieldValue, "Selected Dialog",
			"dialogWidth:300px;dialogHeight:440px;dialogTop;dialogTop:"
					+ (windowHeight / 2 - 440 / 2) + "px;dialogLeft:"
					+ (windowWidth / 2 - 300 / 2) + "px;");
	return returnValue;
}

function dialogAcl(aclId, title) {
	var windowWidth = $(window).width();
	var windowHeight = $(window).height();
	var returnValue = window.showModalDialog(WEB_ROOT
			+ '/core/dialogAcl.do?acl.id=' + aclId + "&" + Math.random(),
			title, "dialogWidth:600px;dialogHeight:540px;dialogTop;dialogTop:"
					+ (windowHeight / 2 - 440 / 2) + "px;dialogLeft:"
					+ (windowWidth / 2 - 300 / 2) + "px;");
	return returnValue;
}

function dialogEditor(elementName, resourceId) {
	var _elemment = $("input[name='" + elementName + "']");
	if (_elemment) {
		var returnValue = window.showModalDialog(WEB_ROOT
				+ '/common/dialogEditor.do?elementId=' + elementName
				+ '&resourceId=' + resourceId, "Editor Dialog",
				"dialogWidth:800px;dialogHeight:660px");
		if (returnValue && returnValue.flag) {
			document.getElementById(elementName).value = returnValue.value;
		}
	}
}

function moveNode() {
	var node = tree.getSelected();
	if (node) {
		var resourceId = node.getId();
		var returnValue = window.showModalDialog(WEB_ROOT
				+ '/common/dialogMove.do?&resourceId=' + resourceId,
				"Move Dialog", "dialogWidth:300px;dialogHeight:440px");
		if (returnValue && returnValue.flag) {
			alert(returnValue.value.nodeId);
		}

	} else {
		alert("Please selected one node.");
	}
}

function viewEditor(elementName, resourceId) {
	var _elemment = $("input[name='" + elementName + "']");
	if (_elemment) {
		window.showModalDialog(WEB_ROOT + '/commmon/viewEditor.do?elementId='
				+ elementName + '&resourceId=' + resourceId, "View Document",
				"dialogWidth:800px;dialogHeight:660px");
	}
}

function dialogUpdateImage(elementName) {
	var _element = $("input[name='" + elementName + "']");
	if (_element) {
		var value = _element.val();
		var url = WEB_ROOT + '/pages/common/dialogUpdateImage.jsp?resourceId='
				+ value + '&flag=' + Math.random();
		top.$('#dialogDiv').dialog({
			title : "Selected Dialog",
			width : 450,
			height : 320,
			modal : true,
			content : '<iframe id="editImageDialog" style="width:100%;height:100%;" frameborder="0" src="'
					+ url + '"></iframe>',
			buttons : [{
				text : 'Close',
				handler : function(){
					_closeDialog();
					var _newImageResId = null;
					var _imageElement = $("img[id='image_" + elementName + "']");
					
					if (_element.val() == null || _element.val() == '') {
						_newImageResId = top.$("editImageDialog")[0].contentWindow.$('#resource_longString_id_').val();
						_element.attr("value", returnValue.resourceId);
					}else{
						_newImageResId = _element.val();
					}
					_imageElement.attr("src", WEB_ROOT + '/image-service?resourceId='
							+ _newImageResId + '&elementId=content&flag='
							+ Math.random());
				}	
			}]
		});
	}
}
