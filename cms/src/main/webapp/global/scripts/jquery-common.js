/**
 * jquery EasyUI common lib
 */
var GLOBAL_NULL = null;
var GLOBAL_NULL_STRING = "";
var GLOBAL_POINT =".";
var GLOBAL_ELEMENT_VALIDATION_CLASS_PREFIX = "validatebox";
var GLOBAL_REGEX_IMAGE_FROMATS = /(..jpg|..jpeg|..png|..bmp|..gif|..JPG|..JPEG|..PNG|..BMP|..GIF)$/;
/**
 * implements button named is clearButton click event
 */
/**
$(function(){
	$("#clearButton").bind('click',function(){
		$("input[type!=hidden]").each(function(){
			$(this).val(GLOBAL_NULL_STRING);
		});
	});
});
**/
/**
 * implements form submit and validation
 */
$.extend({
	submitFormWoMsg:function(sectionName){
		document.forms[0].submit();
		$.disabledDocElement();
	},
	validationForm:function(filterString){
		var _validFlag = true;
		$(filterString).each(function() {
			if ($(this).context.className.indexOf(GLOBAL_ELEMENT_VALIDATION_CLASS_PREFIX)>-1 
					&& !$(this).validatebox('isValid')) {
				_validFlag = false;
			}
		});
		return _validFlag;
	},
	disabledDocElement:function(){
		$('input[type!=hidden]').each(function (){
			$(this).attr("disabled","disabled");
		});
		$('textarea').each(function (){
			$(this).attr("disabled","disabled");
		});
		$('a').each(function (){
			$(this).attr("herf","#");
			if($(this) && $(this).attr("id") == 'clearButton' ){
				$(this).unbind();
			}else{
				$(this).attr("onclick",function(){return false;});
			}
		});
	},
	upperLetter: function(e){
		var target = e.target;
		var currKey = e.which;
		if(currKey >=65 && currKey <=90){
			var jTarget = $(target);
			jTarget.val(jTarget.val().toUpperCase());
		}
	},
	onlyNumber : function(e){
		var tmpTxt = $(this).val();
		$(this).val(tmpTxt.replace(/\D/g,''));
	},
	isEmpty : function(elementId){
		var value = $("#"+elementId).val();
		if(value == null || value ==''){
			return true;
		}else{
			return false;
		}
	},
	fileFormat: function(fileName){
		var fileFormat = 'unknown';
		if(fileName!=null && fileName!=''
			&& fileName.lastIndexOf(GLOBAL_POINT)>-1){
			fileFormat = fileName.substring(fileName.lastIndexOf(GLOBAL_POINT)-1,fileName.length);
		}
		return fileFormat;
	},
	isImageFile: function(fileFormat){
		return GLOBAL_REGEX_IMAGE_FROMATS.test(fileFormat);
	}
});