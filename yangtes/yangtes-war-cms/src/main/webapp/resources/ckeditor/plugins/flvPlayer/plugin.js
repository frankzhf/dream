(function(){
	CKEDITOR.plugins.add('flvPlayer', {
		requires: ["dialog"],
		init : function(editor) {
			var pluginName = 'flvPlayer';
			editor.addCommand(pluginName, new CKEDITOR.dialogCommand(pluginName)); 
			// Register the dialog.
			editor.ui.addButton('flvPlayer', {
				label : '插入Flv视频',
				command : pluginName,
				icon : this.path + "g.ico"
			});
			CKEDITOR.dialog.add(pluginName, this.path + "dialogs/flvPlayer.js")  
		}
	});
})();