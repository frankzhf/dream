function ajaxGet(url, callback) {
	jQuery.ajax({
		type : 'get',
		url : url,
		headers : {
			'X-Requested-With' : 'XMLHttpRequest'
		},
		success : function(data1) {
			if (callback === undefined) {
				$('#content-container').replaceWith(data1);
			} else {
				eval(callback).apply(null);
			}
			$("html, body").animate({
				scrollTop : 0
			}, "20");
		},
		error : function() {
		}
	});
}

function ajaxPost(url, data, callback) {
	jQuery.ajax({
		type : 'post',
		url : url,
		data : data,
		headers : {
			'X-Requested-With' : 'XMLHttpRequest'
		},
		success : function(data1) {
			if (callback == '' || callback === undefined) {
				$('#content-container').replaceWith(data1);
			} else {
				eval(callback).apply(null);
			}
			$("html, body").animate({
				scrollTop : 0
			}, "20");
		},
		error : function() {
		}
	});
}


function refreshGrid(gid) {
	$('#' + gid).data("kendoGrid").dataSource.read();
}

function clearFilterGrid(gid) {
	$('#' + gid).data("kendoGrid").dataSource.filter({});
}


function checkKey(e,keyValue,fun){
	var charCode=(navigator.appName=="Netscape")?e.which:e.keyCode;
	//alert(charCode);
	if(charCode == keyValue){
		eval(fun);
	}
}

function triggerMsgBox(msgDetails){
	$("#msgBox").find(".modal-body").find("p").html(msgDetails);
	$("#msgBox").modal("show");
}

function triggerErrorBox(errorDetails){
	$("#errorBox").find(".modal-body").find("p").html(errorDetails);
	$("#errorBox").modal("show");
}

function triggerConfrimBox(confirmDetails,callback){
	$("#confirmBox").find(".modal-body").find("p").html(confirmDetails);
	var confrimButton = $("#confirmBox").find(".modal-footer").find("#confirmButton");
	confrimButton.unbind("click");
	if(callback){
		confrimButton.bind("click",callback);
	}
	$("#confirmBox").modal("show");
}

function popupAbout(){
	
}

function logout(logoutDetails){
	var callback = function(){
		window.location = UiApp.contextPath + "/logout";
	};
	triggerConfrimBox(logoutDetails,callback);
}

function menuItemLocation(location){
	ajaxGet(location);
}
/**
 * init 2 modals on page: a.session reminder b.session timeout
 */
function sessionReminder() {
	$('#_session_modal').modal('hide');
	$('#_session_modal_timeout').modal('hide');
	if (typeof (timeoutReminder) !== 'undefined') {
		clearTimeout(timeoutReminder);
	}
	if (typeof (timeoutInformation) !== 'undefined') {
		clearTimeout(timeoutInformation);
	}
	if (!UiApp.isLogin)
		return;
	var _var1 = UiApp.timeoutInterval;
	var _var2 = UiApp.timeoutLogout;
	var _seconds = eval(_var1 - _var2 * 60);
	timeoutReminder = setTimeout(function() {
		$('#_session_modal').modal('show');
	}, _seconds * 1000);
	timeoutInformation = setTimeout(function() {
		clearTimeout(timeoutReminder);
		$('#_session_modal').modal('hide');
		$('#_session_modal_timeout').modal('show');
	}, _var1 * 1000);
}

/**
 * extend session expired time
 */
function refreshSession() {
	jQuery.ajax({
		type : 'get',
		url : UiApp.contextPath + "/ping",
		success : function(data1) {
			sessionReminder();
		}
	});
}


/**
 * 
 * remove load... after request complete
 * 
 */
$(document).ajaxComplete(function() {
	$('.k-loading-mask').remove();
});

jQuery.fn.center = function() {
	var w = $(window);
	this.css("position", "fixed");
	this.css("top", w.height() / 2 - this.height() / 2 + "px");
	this.css("left", w.width() / 2 - this.width() / 2 + "px");
	return this;
};

function showMask(id, width) {
	$("#" + id)
			.append(
					'<div id="content-container-mask" class="k-loading-mask" style="top: 0px; left: 0px; bottom: 0; right:0"><span class="k-loading-text">Loading...</span><div id="content-container-image" class="k-loading-image"></div><div class="k-loading-color"></div></div>');
	$('#content-container-mask').height($("#" + id).height());
	$('#content-container-mask').width($("#" + id).width() * width);
	$('#content-container-image').center();
}

function removeMask() {
	window.setTimeout(function() {
		$('#content-container-mask').remove();
	}, 500);
}

/**
 * 
 * to add loading... click on submit button
 * 
 */
function bindSubmitEvent() {
	$(".btn-primary").on("click", function() {
		showMask('content-container', 1.2);
	});
}


function getGridFilterConfiguration() {
	return {
		messages : {
			info : "Show items with value that:",
			filter : "Filter",
			clear : "Clear",
			and : "And",
			or : "Or"
		},
		operators : {
			string : {
				eq : "Is equal to",
				neq : "Is not equal to",
				startswith : "Starts with",
				contains : "contains",
				doesnotcontain : "Does not contain",
				endswith : "Ends with"
			},
			number : {
				eq : "Is equal to",
				neq : "Is not equal to",
				gte : "Is greater than or equal to",
				gt : "Is greater than",
				lte : "Is less than or equal to",
				lt : "Is less than"
			},
			date : {
				eq : "Is equal to",
				neq : "Is not equal to",
				gte : "Is after or equal to",
				gt : "Is after",
				lte : "Is before or qqual to",
				lt : "Is before"
			}
		}
	};
}
