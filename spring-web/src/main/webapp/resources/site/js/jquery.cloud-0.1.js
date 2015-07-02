/*******************************************************************************
 * 
 * options define { read:'{url}', debug: false, mode : 'read'|'write' }
 */
(function($) {
	var __CURRENT_ZONE = new Date().getTimezoneOffset();
	var __GLOBAL_ROW_FIELD_NUM = 1;
	function CloudResponse(){
		this.messageNumber = null;
		this.createDate = null;
		this.resource = null;
	};
	
	
	var __response = null;
	var data_key = "cloud";
	var completed = false;
	$.cloud = function(div, options) {
		var $div = div;
		if (options.debug) {
			if ($("#" + $div.attr('id') + "_data").length == 0) {
				$div.append("<textarea id=\"" + $div.attr('id') + "_data"
						+ "\" rows=\"6\" cols=\"128\"></textarea>");
			}
		}
		if (completed) {
			init();
			completed = true;
		}
		render();

		function init() {

		}
		function render() {
			$.ajax({
				url : options.url,
				type : 'get',
				contentType : "application/xml",
				async : false,
				success : function(data) {
					var xmlObject = $(data);
					if (options.debug) {
						$("#" + $div.attr('id') + "_data").val(data);
					}
					$div.data(data_key, xmlObject);
					if("WSRESPONSE" == xmlObject[0].nodeName){
						__response = new CloudResponse();
						xmlObject.find("property").each(function() {
							var propertyName = $(this).attr("name")
							if(propertyName == 'messageNumber'){
								__response.messageNumber = $(this).text();
							}else if(propertyName == 'createDate'){
								var format = $(this).attr("format");
								//var locate = $(this).attr("locate");
								var strDate = $(this).text();
								__response.createDate = Date.parse(strDate,format);
							}else if(propertyName == 'resource'){
								__response.resource = $(this);
							}
						});
						
						//TODO process messageNumber
						
						//TODO process resource
						readerResource(__response.resource);
					}
				},
				error : function() {

				}
			});
		}
		function readerResource(resource){
			
		}
	};

	$.fn.cloud = function(options) {
		options = options || {};
		options = $.extend({
			debug : true,
			mode : 'read'
		}, options);
		this.each(function() {
			if ($(this).data(data_key)) {
				$(this).data(data_key).remove();
				$(this).removeData(data_key);

			} else {
				new $.cloud($(this), options);
			}
		});
		return this;
	};
})(jQuery);