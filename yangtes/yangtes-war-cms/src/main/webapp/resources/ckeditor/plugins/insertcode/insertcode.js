CKEDITOR.dialog.add('insertcode', function(a) {
	var b = a.lang.insertcode;
	return {
		title : b.title,
		resizable : CKEDITOR.DIALOG_RESIZE_BOTH,
		minWidth : 500,
		minHeight : 300,
		contents : [ {
			id : 'cb',
			elements : [
					{
						type : 'select',
						label : b.selectl,
						id : 'lang',
						required : true,
						items : [ [ 'asp/vb', 'vb' ],
								[ 'javascript', 'jscript' ], [ 'css', 'css' ],
								[ 'xml', 'xml' ], [ 'php', 'php' ],
								[ 'java', 'java' ], [ 'spl', 'spl' ] ],
						'default' : 'asp/vb'
					}, {
						type : 'textarea',
						label : b.inputc,
						id : 'code',
						rows : 14,
						'default' : ''
					} ]
		} ],
		onOk : function() {
			code = this.getValueOf('cb', 'code');
			lang = this.getValueOf('cb', 'lang');
			if (lang == "") {
				alert("请选择脚本语言");
				return false;
			} else if (code == "") {
				alert("请输入代码");
				return false;
			} else {
				a.insertHtml("<pre name=\"code\" class=\"" + lang + "\">"
						+ escape(code) + "</pre>");
			}
		},
		onLoad : function() {
		}
	};
});
