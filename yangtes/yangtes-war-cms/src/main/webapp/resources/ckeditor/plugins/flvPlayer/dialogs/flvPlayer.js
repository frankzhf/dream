CKEDITOR.dialog.add("flvPlayer",function(editor){
	var escape=function(value){
		return value;
	};
	var elementDom = null;
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
					label: '源文件',
					onShow : function( type, element ){
						//console.log("src.onShow()");
						if(elementDom){
							var children = elementDom.documentElement.childNodes;
							if(children){
								for(var i=0;i<children.length;i++){
									var child = children[i];
									if("cke:param" === child.tagName){
										var attrName = child.getAttribute("name");
										if("movie" === attrName){
											var _value = child.getAttribute("value")
											var startWith = _value.indexOf("?url=")+5
											var _url = _value.substr(startWith);
											//console.log("Varrible [_url] -> " + _url);
											var field = this;
											field.setValue(_url);
											break;
										}
									}
								}
							}	
						}
					}
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
            		style:'width:50px',
            		onShow : function( type, element ){
            			//console.log("mywidth.onShow()");
            			if(elementDom){
            				var field = this;
            				var _myWidth = elementDom.documentElement.getAttribute('width');
            				field.setValue(_myWidth);
            			}
            		}
            	},{
            		type:'text',
            		label:'视频高度',
            		id:'myheight',
            		'default':'320px',
            		style:'width:50px',
            		onShow : function( type, element ){
            			//console.log("myheight.onShow()");
            			if(elementDom){
            				var field = this;
            				var _myHeight = elementDom.documentElement.getAttribute('height');
            				field.setValue(_myHeight);
            			}
            		}
            	}
            	/***,{
            		type:'select',
            		label:'自动播放',
            		id:'myloop',
            		required:true,
            		'default':'false',
            		items:[['是','true'],['否','false']]
            	}***/]
            }/***,{
            	type:'textarea',
            	style:'width:300px;height:220px',
            	label:'预览',
            	id:'code'
            }***/]           
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
		
        onHide: function () {
        	console.log("flvPlayer.onHide()");
        	elementDom = null;
        },
		onShow : function(){
			//console.log("flvPlayer.onShow()");
			var editor = this.getParentEditor(),
			sel = editor.getSelection(),
			element = sel && sel.getSelectedElement();
			if(element!=null){
				var elementName = element.getName();
				var _data_relate = element.getAttribute('data-cke-realelement');
				var data_relate = unescape(_data_relate);
				try{
					elementDom=new ActiveXObject("Microsoft.XMLDOM");
					elementDom.async="false";
					elementDom.loadXML(data_relate);
				}catch(e){
					try{
						var parser = new DOMParser();
						elementDom = parser.parseFromString(data_relate,"text/xml");
					}catch(e){}
				}
				//console.log("flvPlayer.onShow() completed.");
			}
		},
		onOk:function(){
			var mywidth=this.getValueOf('info','mywidth');
			var myheight=this.getValueOf('info','myheight');
			//myloop=this.getValueOf('info','myloop');
			var mysrc=this.getValueOf('info','src');
			var _url =''+escape(mysrc)+'';
			var base = document.getElementsByTagName('base')[0];
			if (base && base.href && (base.href.length > 0)) {
				base = base.href;
			} else {
				base = document.URL;
			}
			var _web_context = base.substr(0,
			    base.indexOf("/", base.indexOf("/", base.indexOf("//") + 2) + 1));
			_web_context = _web_context.substr(_web_context.lastIndexOf("/"));
			var _content="<object \"classid\"=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" "+
			"\"codebase\"=\"http://www.macromedia.com/go/getflashplayer\" \"id\"=\"moviename\" width=\""+mywidth+"\" height=\""+myheight+"\">"+
			"<param name=\"movie\"  value=\""+_web_context+"/resources/flashls-0.4.4.23/flashlsChromeless.swf?url="+_url+"\" />"+
			"<param name=\"quality\" value=\"autohigh\" />"+
			"<param name=\"swliveconnect\" value=\"true\" />"+
			"<param name=\"allowScriptAccess\" value=\"sameDomain\" />"+
			"<param name=\"bgcolor\" value=\"#0\" />"+
			"<param name=\"allowFullScreen\" value=\"true\" />"+
			"<param name=\"wmode\" value=\"window\" />"+
			"<embed src=\""+_web_context+"/resources/flashls-0.4.4.23/flashlsChromeless.swf?url="+_url+"\" \"width\"=\""+mywidth+"\" \"height\"=\""+myheight+"\" \"name\"=\"moviename\" "+
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
			elementDom = null;
		}
	}
});