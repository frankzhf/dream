/**
 * Override datebox date format dd/MM/yyyy
 */
$.extend(
	$.fn.datebox.defaults,{
		formatter:function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return (d<10?('0'+d):d)+'/'+(m<10?('0'+m):m)+'/'+y;
		},
		parser:function(s){
			if (!s) return new Date();
			var ss = s.split('/');
			var d = parseInt(ss[0],10);
			var m = parseInt(ss[1],10);
			var y = parseInt(ss[2],10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
				return new Date(y,m-1,d);
			} else {
				return new Date();
			}
		}
	}
);
/***
 * Extend Validation Rule
 */
$.extend(
	$.fn.validatebox.defaults.rules,{
		imageFormat: {
			validator: function(value){
				return GLOBAL_REGEX_IMAGE_FROMATS.test(value);
			},
			message: 'Invalid image file.'
		}
	},
	$.fn.validatebox.defaults.rules,{
		limitFileMaxSize:{
			validator:function(value,param){
				if(value!=null && value!=''){
					var fileSize = 0;
					if($.browser.msie){
						var objFSO = new ActiveXObject("Scripting.FileSystemObject");
						var objFile = objFSO.getFile(value);
						fileSize = objFile.size;	
					}else{
						fileSize = param[0].files[0].size;
					}
					return fileSize<(250*1024*1024);
				}else{
					return true;
				}
			},
			message:'Upload file too big.'
		}
	}
);