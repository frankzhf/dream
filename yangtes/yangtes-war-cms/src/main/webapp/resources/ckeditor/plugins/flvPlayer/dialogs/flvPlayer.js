CKEDITOR.dialog.add("flvPlayer",function(editor){
	var escape=function(value){
		return value;
	};
	return {
		title : "插入Flv视频",
		resizable : CKEDITOR.DIALOG_RESIZE_BOTH,
		minHeight : 300,
		contents : [{
			id: 'info',  
            label: '常规',
            accessKey: 'P',
            elements:[{
            	type: 'hbox',
            	widths : [ '80%', '20%' ],
            	children:[{
                    id: 'src',
                    type: 'text',
                    label: '源文件'
                },{
                    type: 'button',
                    id: 'browse',
                    filebrowser: 'info:src',
                    hidden: true,
                    align: 'center',
                    label: '浏览服务器'
                }]
            },{
            	type: 'hbox',
            	widths : [ '35%', '35%', '30%' ],
            	children:[{
            		type:'text',
            		label:'视频宽度',
            		id:'mywidth',
            		'default':'470px',
            		style:'width:50px'
            	},{
            		type:'text',
            		label:'视频高度',
            		id:'myheight',
            		'default':'320px',
            		style:'width:50px'
            	},{
            		type:'select',
            		label:'自动播放',
            		id:'myloop',
            		required:true,
            		'default':'false',
            		items:[['是','true'],['否','false']]
            	}]
            },{
            	type:'textarea',
            	style:'width:300px;height:220px',
            	label:'预览',
            	id:'code'
            }]           
		},{
			id:'Upload',
            hidden:true,
            filebrowser:'uploadButton',
            label:'上传',
            elements:[{
				type:'file',
				id:'upload',
				label:'上传',
				size:38
            },{
            	type:'fileButton',
                id:'uploadButton',
                label:'发送到服务器',
                filebrowser:'info:src',
                'for': ['Upload', 'upload']
            }]
		}],
		onOk:function(){
			var mywidth=this.getValueOf('info','mywidth');
			var myheight=this.getValueOf('info','myheight');
			//myloop=this.getValueOf('info','myloop');
			var mysrc=this.getValueOf('info','src');
			var _url =''+escape(mysrc)+'';
			//TODO insert webapp context
			var base = document.getElementsByTagName('base')[0];
		    if (base && base.href && (base.href.length > 0)) {
		        base = base.href;
		    } else {
		        base = document.URL;
		    }
		    var _web_context = base.substr(0,
		        base.indexOf("/", base.indexOf("/", base.indexOf("//") + 2) + 1));
		    //http://localhost:18080/yangtes-war-cms
		    _web_context = _web_context.substr(_web_context.lastIndexOf("/"));
		    console.log("web_context :" + _web_context);
			var _content="<object \"classid\"=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" "+
			"\"codebase\"=\"http://www.macromedia.com/go/getflashplayer\" \"id\"=\"moviename\" width=\""+mywidth+"\" height=\""+myheight+"\">"+
			"<param name=\"movie\"  value=\""+_web_context+"/resources/flashls-0.4.4.23/flashlsChromeless.swf?url="+_url+"\" />"+
			"<param name=\"quality\" value=\"autohigh\" />"+
			"<param name=\"swliveconnect\" value=\"true\" />"+
			"<param name=\"allowScriptAccess\" value=\"sameDomain\" />"+
			"<param name=\"bgcolor\" value=\"#0\" />"+
			"<param name=\"allowFullScreen\" value=\"true\" />"+
			"<param name=\"wmode\" value=\"window\" />"+
			"<embed src=\"/yangtes-jee-cms-war/resources/flashls-0.4.4.23/flashlsChromeless.swf?url="+_url+"\" \"width\"=\""+mywidth+"\" \"height\"=\""+myheight+"\" \"name\"=\"moviename\" "+
				"\"quality\"=\"autohigh\" "+
				"\"bgcolor\"=\"#0\" "+
				"\"align\"=\"middle\" allowFullScreen=\"true\" "+
				"\"allowScriptAccess\"=\"sameDomain\" "+
				"\"type\"=\"application/x-shockwave-flash\" "+
				"\"swliveconnect\"=\"true\" "+
				"\"wmode\"=\"window\" "+
				"\"pluginspage\"=\"http://www.macromedia.com/go/getflashplayer\"> "+
			"</embed>"+
	    "</object>"
			editor.insertHtml(_content);
		},
		onLoad:function(){
			
		}
	}
});