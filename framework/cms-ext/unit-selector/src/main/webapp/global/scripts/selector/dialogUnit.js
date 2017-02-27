/**
 * the javascript depend on 
 * 		jquery.js, 
 * 		jquery-common.js,
 * 		jquery.easyui.min.js,
 * 		dialog.js
 */


/***
 * 
 * @param elementName
 */

function dialogSelectorUnit(elementName) {
	var _element = $("input[name='" + elementName + "']");
	if (_element) {
		var value = _element.val();
		var url = WEB_ROOT + '/common/selector/unit/dialogSelectorUnit.do?fieldName='
			+ elementName + '&fieldValue=' + value;
		top
		.$('#dialogDiv')
		.dialog(
				{
					title : "Selector Unit",
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
