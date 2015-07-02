function ajaxGet(url, callback){
			jQuery.ajax({
		         type: 'get',
		         url: url,
		         headers: {'X-Requested-With': 'XMLHttpRequest'},
		         success: function (data1) {
		        	 if(callback === undefined){
		        		 $('#content-container').replaceWith(data1);
		        	 }else{
		        		 eval(callback).apply(null);
		        	 }
		        	 $("html, body").animate({scrollTop: 0}, "20");
		         },
		         error: function () {
		         }
		     });
}

function ajaxPost(url, data, callback){
			jQuery.ajax({
		        type: 'post',
		        url: url,
		        data: data,
		        headers: {'X-Requested-With': 'XMLHttpRequest'},
		        success: function (data1) {
		        	if(callback == '' || callback === undefined){
		        		 $('#content-container').replaceWith(data1);
		        	 }else{
		        		 eval(callback).apply(null);
		        	 }
		        	$("html, body").animate({scrollTop: 0}, "20");
		        },
		        error: function () {
		        }
		    });
}


function removeAttachment(attachmentId, componentId,url) {
	var dataObject = $("#" + componentId).attr("dataObject");
	var dataTableField = $("#" + componentId).attr("dataTableField");
	var param = "";
	if (typeof(dataObject) != "undefined" && dataObject != "") {
		param = "dataObjectId=" + dataObject;
	}
	if (typeof(dataTableField) != "undefined" && dataTableField != "") {
		param = param + "&dataTableFieldId=" + dataTableField;
	}
	
	//update upload-size
	var uploadSizeEle = "#upload_size_"+dataTableField;
    var uploadSize = $(uploadSizeEle).val();
    uploadSize = parseInt(uploadSize)-1;
    $(uploadSizeEle).attr("value",uploadSize);
    jQuery.ajax({
        type: 'get',
        data: param,
        url: url + "/"+ "remove" + "/" + attachmentId,
        success: function () {
            $("#" + attachmentId).remove();
            if ($("#" + componentId).children().length == 0) {
                $("#" + componentId).remove();
            }
        }
    });
   
};


function retrieveGroups(tenantId, target) {
    $("#" + target).empty();
    $("#" + target).append("<option value=''></option>");
    $("#" + target).select2("val", "");
    if (tenantId != '') {
        jQuery
            .ajax({
                type: 'post',
                url: CustomerConnect.contextPath + '/partnership/group/list/' + tenantId,
                success: function (data) {
                    if (data.success) {
                        $.each(data.object, function (i, item) {
                            $("#" + target).append("<option value='" + item.id + "'>" + item.name + "</option>");
                        });
                    }
                }
            });
    }
}

function retrieveOutCome(ruleAction, target) {
    $("#" + target).empty();
    $("#" + target).append("<option value=''></option>");
    $("#" + target).select2("val", "");
    if (ruleAction != '') {
        jQuery
            .ajax({
                type: 'post',
                //1 will not be used in backend, just hardcode as a placehold.
                url: CustomerConnect.contextPath + '/1/datatableruledefinition/outcome/list/' + ruleAction,
                success: function (data) {
                        $.each(data, function (i, item) {
                            $("#" + target).append("<option value='" + item.value + "'>" + item.key + "</option>");
                        });
                }
            });
    }
}
function removeSelfFromOptions(value, parentId) {
    $("#" + parentId + " option").each(function () {
        if (value === $(this).val()) {
            $(this).remove();
        }
    });
}


function submitBtn() {
    $("#submit").click(function () {
        ajaxPost($('#form').attr('action'), $('#form').serializeArray());
    });
}

function cancelBtn() {
    $("#cancel").click(function () {
    	var module = $(this).attr("module");
    	listEntity(module);
    });
}

function editBtn() {
    $("#edit").click(function () {
        var id = $(this).attr("entity_id");
        var module = $(this).attr("module");
        editEntity(id, module);
    });
}

function refreshGrid(gid) {
    $('#' + gid).data("kendoGrid").dataSource.read();
}

function clearFilterGrid(gid) {
    $('#' + gid).data("kendoGrid").dataSource.filter({});
}

function listEntity(module) {
    operateEntity(module+"/list", "get", "");
}

function createEntity(module) {
    showMask('grid', 1);
    operateEntity(module+"/create", "get", "");
}

function showEntity(id, module) {
    operateEntity(module+"/show", "get", id);
}

function editEntity(id, module) {
    operateEntity(module+"/update", "get", id);
}

function operateEntity(operation, type, id) {
    var url = CustomerConnect.contextPath+"/"+operation;
    if(id !== ''){
    	url = url+"/"+id;
    }
    ajaxGet(url);
}

function removeFile(sessionId, filePath, fieldPath, dataTableFieldId, btnEle){
	if (sessionId.length >0 && filePath.length >0 && fieldPath.length >0) {
		var fileNames = new Array();
		fileNames[0] = filePath;
		$.ajax({
			url: CustomerConnect.contextPath + "/" + "attachment" + "/" + "remove" + "/" + sessionId + "/" + fieldPath,
			type: 'post',
			data: "fileNames=" + fileNames,
			success: function (data, status){
				var ulEle = $(btnEle).parent().parent().parent();
				
				var liEle = $(btnEle).parent().parent();
				liEle.remove();
				if (ulEle.children().length == 0) {
					ulEle.empty();
					ulEle.remove();
				}
				//update upload-size
            	var uploadSizeEle = "#upload_size_"+dataTableFieldId;
                var uploadSize = $(uploadSizeEle).val();
                
            	if (uploadSize != '0') {
            		uploadSize = parseInt(uploadSize)-1;
                    $(uploadSizeEle).attr("value",uploadSize);
                }
			}
		});
	}
}

/**
 * used to remove edit table row in modal
 * 
 * @param e
 */
function editTableRow(e){
	var id = $(e).attr("row_id");
	var tblId = $(e).closest("table").attr("id");
	var url = $(".modal[target_tbl='"+tblId+"']").attr("edit_url");
	url = url + "/" + id; 
	$(".modal[target_tbl='"+ tblId +"']").modal({remote:url});
}

/**
 * used to remove table row
 * 
 * @param e
 */
function removeTableRow(e){
	var id = $(e).attr("row_id");
	var tblId = $(e).closest("table").attr("id");
	var url = $(".modal[target_tbl='"+tblId+"']").attr("delete_url");
	var default_url = $(".modal[target_tbl='"+tblId+"']").attr("default_url");
    jQuery.ajax({
        type: 'post',
        url: url,
        data: 'id=' + id,
        success: function (data) {
        	ajaxGet(default_url);
        }});
}

function loadPopup(){
	$('.popup').each(function(i, e){
		var $popup = $(e);
		var url = $popup.attr("url");
		var method = $popup.attr("method");
		var beforeSubmit = $popup.attr("beforeSubmit");
		$($popup).find('.btn-primary').on("click", function(evt){
			var isvalid = true;
			if (beforeSubmit !== null && beforeSubmit !== undefined && beforeSubmit !== ''){
				isvalid = eval(beforeSubmit);
				if (isvalid === undefined) {
					isvalid = false;
				}
			}
			if(url != '' && isvalid){
				$popup.modal('hide');
				if($popup.find("form").length>0){
					ajaxPost(url, $popup.find("form").serialize(), method);
				}else{
					ajaxGet(url, method);
				}
			} else {
				removeMask();
			}
		});
	});
}


function loadModal($scope) {

    // cleanup modal content
    $scope.find('.modal').on('hidden', function () {
        $(this).removeData('modal');
    });

    
    $scope.find('.modal').on('shown', function () {
    	var $this = $(this);
    	setTimeout(function(){
    		loadFields($this);
    	},0);
    });
  
    $scope.find('.modal').on('show', function(){
    	$(this).css({
    		'margin-left':	function(){
    			return -($(this).width()/2);
    		}
    	});
    });


    // popoup modal content
    $scope.find(".modal-create").each(function () {
        var target_modal = $(this).attr('target_modal');
        var create_url = $("#" + target_modal).attr("create_url");
        $(this).attr("data-toggle", "modal").attr("data-remote", create_url).attr("data-target", "#" + target_modal);
    });

    $scope.find(".modal").each(function () {
        var edit_url = $(this).attr('edit_url');
        var delete_url = $(this).attr('delete_url');
        var default_url = $(this).attr('default_url');
        var target_tbl = $(this).attr('target_tbl');
        var $this = $(this);
        $($this).delegate(".modal_submit", "click", function (e) {
            e.preventDefault();
            var form = $this.find("form")[0];
            jQuery.ajax({
                type: 'post',
                url: $(form).attr("action"),
                data: $(form).serialize(),
                headers: {'X-Requested-With': 'XMLHttpRequest'},
                success: function (data) {
                    if (data != null) {
                        data = $.trim(data);
                    }
                    if ($(data).find(".error").length > 0) {
                        $($this).children(".modal-body").html(data);
                        loadFields($this);
                    } else {
                        $($this).modal('hide');
                        $('#content-container').replaceWith(data);
                    }
                },
                error: function () {
                    $($this).modal('hide');
                    $("<div class='alert alert-error'><button type=button' class='close' data-dismiss='alert'>&times;</button>Something Wrong</div>").insertAfter($("legend")[0]);
                }

            });// end jQuery.ajax
        });
    });

}

function loadFields($scope) {
    //date component initialization
    $scope.find("[data-type=date]").each(function(i, e){
    	var $picker = $(e);
    	$picker.kendoDatePicker({format: CustomerConnect.dateFormat});
    	var html = "<span>&nbsp;&nbsp;<i class='icon-info-sign'/></span>";
    	var icon = $(html);
    	icon.insertAfter($(e).closest(".k-widget"));
    	icon.find("i:first").on("click", function(e){
    		$picker.data("kendoDatePicker").value(new Date());
    	}).css('cursor', 'pointer');
    });
    
    

    // datetime component initialization
    $scope.find("[data-type=datetime]").each(function(i, e){
    	var $picker = $(e);
    	$picker.kendoDateTimePicker({format: CustomerConnect.dateTimeFormat});
    	var html = "<span>&nbsp;&nbsp;<i class='icon-info-sign'/></span>";
    	var icon = $(html);
    	icon.insertAfter($(e).closest(".k-widget"));
    	icon.find("i:first").on("click", function(e){
    		$picker.data("kendoDateTimePicker").value(new Date());
    	}).css('cursor', 'pointer');
    });

    $scope.find("[data-type=currency]").each(function(i,e){
    	var eleValue = $(this).val();
    	 
    	if (typeof(eleValue)!='undefined' && eleValue.length > 0) {
    		if (eleValue.indexOf(',') != -1) {
    			var patt = /^(0|[1-9][0-9]{0,2}(,[0-9]{3})*(.[0-9]+)?)$/;
        		if (!patt.exec(eleValue)) {
        			return;
        		}
    		}
    		
    		eleValue = eleValue.replace(",","");
    		var reverseValue = '';
    		var formatValue = '';
    		if (eleValue.indexOf('.') != -1) {
    			reverseValue = eleValue.substring(0,eleValue.indexOf('.')).split("").reverse().join("");
    		} else {
    			reverseValue = eleValue.split("").reverse().join("");
    		}
    		if (reverseValue.length > 3) {
    			for (var i = 0;i<reverseValue.length;i++) {
    				if (i != 0 && i % 3 == 0) {
    					formatValue += ','+ reverseValue.charAt(i);
    				} else {
    					formatValue += reverseValue.charAt(i);
    				}
        		}
    			if (eleValue.indexOf('.') == -1) {
    				formatValue = formatValue.split("").reverse().join("");
    			} else {
    				formatValue = formatValue.split("").reverse().join("") + eleValue.substring(eleValue.indexOf('.'));;
    			}
    		} else {
    			formatValue = eleValue;
    		}
    		$(this).attr("value",formatValue);
    	}
    	
    	
    });
    
    // editor component initialization
	$scope.find("[data-type*=editor]").each(function(i,e){
		var display = $(this).attr("data-type").search("readonly");
		$(this).kendoEditor({encoded: false});
		if(display == true){
				$(".k-content").contents().find("body").attr("contenteditable","false");
				$(".k-editor-toolbar-wrap").remove();
		}
	});
    // select component initialization
    $scope.find("[data-type=select]").each(function(i, e){
    	var readonly = eval($(e).attr("data-readonly"));
    	$(e).select2({width: 'element',
            allowClear: !readonly
        });
    	if(readonly){
    		$(e).on("open", function(){
    			$(this).select2("close");
    		});
    	}
    });
    		

    // upload component initialzation
    $scope.find("[data-type=upload]").each(function (i, e) {
        var name = $(e).attr("name");
        var url = CustomerConnect.contextPath + "/" + "attachment";
        //$.ajaxSetup({ cache: false });
        var id = $(e).attr('data-session-id');
        var uploadSizeEle = "#upload_size_"+$(e).attr("dataTableField");
        var dataViewField = $(e).attr("dataViewField");
        var controlsEle = $(uploadSizeEle).parent().parent();
        var parentEle = $(controlsEle).parent();

        $(e).kendoUpload({
            async: {
                type: "POST",
                saveUrl: url + "/save/" + id +"/"+ name + "/" + dataViewField,
                removeUrl: url + "/remove/" +id+"/" + name ,
                autoUpload: true
            },
            localization: {
                "select": "Select"
            },
            upload: function (evt) {
                var files = evt.files;
                var dataFileSize = $(e).attr("data_max_filesize"); //format like 100||200
                var dataFileType = $(e).attr("data_file_type"); //format like: jsp||xml
                var dataMaxUpload = $(e).attr("data_max_upload");
                var uploadSize = $(uploadSizeEle).val();
                
                var fileTypes = new Array();
                var fileSize  = new Array();
                
                if (typeof($(e).attr("data_file_type")) != "undefined" && dataFileType != '') {
                	fileTypes = dataFileType.split("||");
                }
                if (typeof($(e).attr("data_max_filesize")) != "undefined" && dataFileSize !='') {
                	fileSize = dataFileSize.split("||");
                }
                if ( typeof(uploadSize) != "undefined" && typeof($(e).attr("data_max_upload")) != "undefined") {
                	if (0 != parseInt(dataMaxUpload) && parseInt(uploadSize) >= parseInt(dataMaxUpload)) {
                		evt.preventDefault();
                        $(this).modal('hide');
                        //show error beside select button
                        var className = parentEle.attr("class").replace("error","");
                        className = className + " " + "error";
                        parentEle.attr("class",className);
                        $(controlsEle).children(".help-inline").remove();
                        $(controlsEle).append($("<span class='help-inline'>The maximum number of attachment to upload is "+dataMaxUpload+".</span>"));
                	}
                }
                
                var indexForAllType = -1;
                for (var key = 0; key< fileTypes.length; key ++) {
        			if (fileTypes[key] == '*') {
        				indexForAllType = key;
        				break;
        			}
        		}
                $.each(files, function(indx, value) {
                	var extension = value.extension.replace(".","").toLowerCase();
                	var index = -1;
                	
                	
                	// Check the extension of each file and abort the upload if it is not data_file_type.
                	if (typeof($(e).attr("data_file_type")) != "undefined" && dataFileType != '') {
                		for (var key = 0; key< fileTypes.length; key ++) {
                			if (fileTypes[key] == extension || fileTypes[key].replace(".","") == extension) {
                				index = key;
                				break;
                			}
                		}
                		if (index == -1 && indexForAllType != -1) {
                			index = indexForAllType;
                		}
                		if (index == -1) {
                			evt.preventDefault();
                            $(this).modal('hide');
                            
                          //show error beside select button
                            var strFileTypes = "";
                            for (var key = 0; key< fileTypes.length; key ++) {
                    			if (key == 0) {
                    				strFileTypes = fileTypes[key];
                    			} else if (key != fileTypes.length - 1) {
                    				strFileTypes += ", " + fileTypes[key];
                    			} else {
                    				strFileTypes += " and " + fileTypes[key];
                    			}
                    		}
                            var className = parentEle.attr("class").replace("error","");
                            className = className + " " + "error";
                            parentEle.attr("class",className);
                            $(controlsEle).children(".help-inline").remove();
                            if (fileTypes.length > 1) {
                            	$(controlsEle).append($("<span class='help-inline'>Only "+ strFileTypes +" files are allowed.</span>"));
                            } else {
                            	$(controlsEle).append($("<span class='help-inline'>Only "+ strFileTypes +" file is allowed.</span>"));
                            }
                		}
                	}
                	
                	// Check the size of each file and abort the upload if it is exceed data_max_filesize bytes.
                    if (typeof($(e).attr("data_max_filesize")) != "undefined" && dataFileSize !=''&& value.size != null) {
                    	if (typeof(fileSize[index]) != 'undefined' && '0' != fileSize[index] && value.size > eval(parseInt(fileSize[index]))*1024) {
                    		evt.preventDefault();
                            $(this).modal('hide');
                            
                            //show error beside select button
                            var className = parentEle.attr("class").replace("error","");
                            className = className + " " + "error";
                            parentEle.attr("class",className);
                            $(controlsEle).children(".help-inline").remove();
                            $(controlsEle).append($("<span class='help-inline'>"+value.name+" has exceeded the configured maximum file size("+fileSize[index]+" KB).</span>"));
                    	}
                    }
                });
            },
            success: function (evt) {
                if ("upload" == evt.operation) {
                    var files = evt.files; 
                    var uploadSize = $(uploadSizeEle).val();
                    var hasError = false;
                    var errorMsg = "";
                    for (i = 0; i < files.length; i++) {
                    	if (null != evt.response) {
                    		if (null == evt.response.id) {
                    			files[i].name = evt.response.storagePath;
                                //update upload-size
                                uploadSize = parseInt(uploadSize)+1;
                                $(uploadSizeEle).attr("value",uploadSize);
                    		} else if (-1 == evt.response.id) {
                    			//for ie10 below versions don't support file.size
                    			hasError = true;
                    			errorMsg = "<span class='help-inline'>"+evt.response.fileName+" has exceeded the configured maximum file size("+evt.response.fileSize+" KB).</span>";
                    			var liLastEle = $(controlsEle).find("li:last");
                    			var parentULEle = $(liLastEle).parent();
                    			$(liLastEle).remove();
                    			if ($(parentULEle).children().length == 0) {
                    				$(parentULEle).remove();
                    			}
                    		}
                    	} else {
                    		hasError = true;
                            errorMsg = "<span class='help-inline'>File operation("+evt.operation+") failed.</span>";
                    	}
                    	if (hasError) {
                    		$(this).modal('hide');

                    		//show error beside select button
                            var className = parentEle.attr("class").replace("error","");
                            className = className + " " + "error";
                            parentEle.attr("class",className);
                            $(controlsEle).children(".help-inline").remove();
                            $(controlsEle).append($(errorMsg));
                            break;
                    	}
                    }
                }
            },
            remove: function (evt){
            	//update upload-size
                var uploadSize = $(uploadSizeEle).val();
                
            	if (uploadSize != '0') {
            		uploadSize = parseInt(uploadSize)-1;
                    $(uploadSizeEle).attr("value",uploadSize);
                } 
            },
            error: function (evt) {
            	$(this).modal('hide');
            	//show error beside select button
                var className = parentEle.attr("class").replace("error","");
                className = className + " " + "error";
                parentEle.attr("class",className);
                $(controlsEle).children(".help-inline").remove();
                $(controlsEle).append($("<span class='help-inline'>File operation("+evt.operation+") failed.</span>"));
            }
        });
    });
    
    $scope.find(".k-upload-files").each(function (i, e) {
    	var dataType = $(e).attr("data-type");
    	if (dataType == "download") {
    		var url = CustomerConnect.contextPath + "/" + "attachment";
        	var eleId = $(e).attr("id");
        	var operation = $(e).attr("operation");
        	var remove_btn = $(e).attr("remove-btn");
        	var items = $(e).attr("items"); //attachment ids
        	var param = '';
        	if (typeof(items) != "undefined" && items != "") {
        		param = 'items=' + items;
        	}
        	//keep file list when valid entity failure
        	var validResult = $(e).attr("validResult");
        	var fileNumInSession = 0;
        	
        	if (validResult == "false") {
        		
        		var path = $(e).attr("path");
        		var sessionId = $(e).attr('data-session-id');
        		jQuery.ajax({
        			url: url + "/" + "retrieveFiles" + "/" + sessionId + "/" + path,
        			type: 'post',
        			async:false,
        			success: function (data, status){
        				if (typeof(data.length) != "undefined" && data.length > 0) {
        					//update upload-size
        					var dataTableFieldId = $(e).attr("dataTableField");
        					var uploadSizeEle = "#upload_size_" + dataTableFieldId;
                            $(uploadSizeEle).attr("value",parseInt($(uploadSizeEle).val()) + data.length);
                            fileNumInSession = data.length;
                            
        					$.each(data, function () {
        						var filePath = this.value;
        						filePath = filePath.replace(/\\/g,"/");
                                var innerHtml = "<li class='k-file'>" + this.key;
                                innerHtml =  innerHtml +
                                	"<span>" +
                                    "<button class=\"k-button k-button-icontext k-upload-action\" type=\"button\" " +
                                    "onclick=\"removeFile('" + sessionId + "', '" + filePath + "', '" + path+"','" + dataTableFieldId + "',this);\"" + ">Remove</button>" +
                                    "</span>" ;
                                innerHtml = innerHtml + "</li>";
                                $(e).prepend($(innerHtml));
                            });
        				}
        			}
        		});
        	}
        	jQuery.ajax({
                url: url + "/" + "retrieve",
                type: 'post',
                data: param,
                success: function (data, status) {
                	if (0 == data.length && fileNumInSession == 0){
                		$(e).remove();
                	} else {
                		$.each(data, function () {
                            var innerHtml = "<li class='k-file' id='"+this.key+"'>" +
                            "<a href=" + url + "/" + "download/"+this.key+">"+this.value+"</a>" ;
                            if ("false" == remove_btn) {
                            	innerHtml =  innerHtml +
                            	"<span>" +
                                "<button class=\"k-button k-button-icontext k-upload-action\" type=\"button\" " +
                                "onclick=\"removeAttachment('" + this.key + "', '" + eleId + "', '" + url+"');\"" + ">Remove</button>" +
                                "</span>" ;
                            }
                            innerHtml = innerHtml + "</li>";
                            
                            $(e).append($(innerHtml));
                        });
                	}
                	//update upload-size
                	if (typeof(operation) != "undefined" && operation == "update") {
                		var uploadSizeEle = "#upload_size_"+$(e).attr("dataTableField");
                        var uploadSize = $(uploadSizeEle).val();
                        uploadSize = parseInt(uploadSize) + data.length;
                        $(uploadSizeEle).attr("value",uploadSize);
                	}
                }
            });
    	}
    	
    });

    $scope.find("[data-type=reference]").each(function (i, e) {
    	renderReference(e)
    });


    // table component initializtion
    $scope.find("[data-type=table]").kendoGrid({
        height: 250,
        sortable: true
    
    });
    
    $scope.find(".k-grid-header-wrap").find("colgroup col:last").css({width: '130px'});
    $scope.find(".k-grid-content").find("colgroup col:last").css({width: '130px'});
}

function renderSelect(e,param4Group){
	var isClient = $(e).attr("client");
    var entityName = $(e).attr("entityName");
    var url = CustomerConnect.contextPath + "/" + "finder" + "/" + entityName;
    var condition = $(e).attr("condition");
    var filter = $(e).attr("filter");
    var multiple = eval($(e).attr("data-multiple"));
    
	if (isClient === 'true') {
    	var data = 'client=true';
    	if (condition != '' && typeof(condition) != "undefined")
    		data = data + '&condition=' + condition;
    	if (filter != '' && typeof(filter) != "undefined")
    		data = data + '&filter=' + filter;
    	if($(e).attr("categorySupport")){
    		var category=$(e).attr("category");
            if (typeof( category) != "undefined"){
            	data = data + '&category=' + category;
            }else{
            	category= $('#reference_category').val();
            	if(typeof( category) != "undefined"){
            		if(category==0){
            			//ignore All Categories Option.
            		}
            		else{
            			data = data + '&category=' + category;
            		}
            	}
            }
    	} else if ("group" == entityName) {
    		data = param4Group;
    	}
        // reference client side load
        $.ajax({
            url: url,
            type: 'post',
            data: data,
            success: function (data, status) {
                var options = [];
                $.each(data, function () {
                    options.push({id: this.key, text: this.value});
                });

                $(e).select2(
                    {
                        initSelection: function (element, callback) {
                            var id = $(element).val();
                            if (id !== "") {
                                $.ajax(url + "/" + id).done(
                                    function (data) {
                                        callback({id: data.key, text: data.value});
                                    });
                            }
                        },
                        multiple: multiple,
                        allowClear: true,
                        data: options,
                        width: 'element'
                    }
                );
            }

        });
    } else {
        // reference server side loader
        $(e).select2(
            {
                allowClear: true,
                initSelection: function (element, callback) {
                    var ids = $(element).val();
                    if (ids !== "") {
                    	var selected = [];
                    	var idArray = ids.split(',');
                    	for(x in idArray){
                    		$.ajax({
                    			type:	'get',
                    			url:	url+"/"+idArray[x],
                    			async:	false,
                    			success:	function(data){
                    				selected.push({id: data.key, text: data.value});
                    			}
                    		});
                    	}
                    	if(selected.length > 0){
                    		if(multiple){
                        		callback(selected);
                        	}else{
                        		callback(selected[0]);
                        	}
                    	}
                    }
                },
                multiple: multiple,
                minimumInputLength: 3,
                ajax: {
                    type: 'post',
                    url: url,
                    quietMillis: 200,
                    data: function (term, page) {
                        var result = "term=" + term;
                        var category=$(e).attr("category");
                        if (condition != '')
                            result = result + '&condition=' + condition;
                        var filter = $(e).attr("filter");
                        if (filter != '' && typeof(filter) != "undefined")
                            result = result + '&filter=' + filter;
                        if (category != '' && typeof( $(e).attr("category")) != "undefined")
            				result = result + '&category=' + category;
                        if ("group" == entityName) {
                        	result += "&" + param4Group;
                        }
                        return result;
                    },
                    results: function (data, page) {
                    	var self = $("input[name=dataObject]").attr("value");
                    	var isObjectRef = ("dataobject" === entityName);
                        var options = [];
                        $.each(data, function () {
                        	if(!isObjectRef || self != this.key){
                        		options.push({id: this.key, text: this.value});
                        	}
                        });
                        return {results: options};
                    }
                },
                width: 'element'
            }
        );

    }
}

function renderReference(e){
    var isClient = $(e).attr("client");
    var entityName = $(e).attr("entityName");
    var url = CustomerConnect.contextPath + "/" + "finder" + "/" + entityName;
    var condition = $(e).attr("condition");
    var multiple = eval($(e).attr("data-multiple"));
    var param4Group = '';
    var hasParentGroup = false;
    var parentField = $(e).attr("parent-field");
    if ("group" == entityName) {
		var groupType = $(e).attr("group-type");
		var subGroupType = $(e).attr("sub-group-type");
		var belongTo = $(e).attr("belong-to");
		param4Group = 'belongTo=' + belongTo;
		if (groupType != '' && typeof(groupType) != "undefined") {
			param4Group += '&groupType='+groupType;
		}
		if (subGroupType != '' && typeof(subGroupType) != "undefined") {
			param4Group += '&subGroupType='+subGroupType;
		}
		if (parentField != '' && typeof(parentField) != "undefined") {
			if ($("input[id='"+parentField+"']").length > 0) {
				var parentGroup  = $("input[id='"+parentField+"']").val();
				if (parentGroup != '' && typeof(parentGroup) != "undefined") {
					param4Group += '&parentGroup='+parentGroup;
				}
				hasParentGroup = true;
			}
		}
		
	}
    
    renderSelect(e,param4Group);
    
    if (hasParentGroup) {
    	$("input[id='"+parentField+"']").on("change", function(){
    		if (-1 != param4Group.indexOf("&parentGroup")) {
    			param4Group = param4Group.substring(0,param4Group.indexOf("&parentGroup"));
    		}
    		if (''!= $(this).val()) {
    			param4Group += "&parentGroup="+$(this).val();
    		}
    		renderSelect(e,param4Group);
    	});
    }

}

function initializeDataSource(module,msg4delete) {

    return new kendo.data.DataSource({

        transport: {
            read: {
                url: CustomerConnect.contextPath+"/"+module+"/read",
                dataType: "json",
                contentType: "application/json",
                type: "POST"
            },
            destroy: {
					url: CustomerConnect.contextPath+"/"+module+"/delete",
            		type: "POST",
            		complete: function (e) {
            			//if delete entity occurs exception
            			if (e.responseText == "" || e.responseText == null) {
            				if ($("#grid").length > 0) {
                        		var grid = $("#grid").data("kendoGrid");
                        		grid.dataSource.read();
                        	}
            				$.each($(".alert-success"),function(){
            					$(this).remove();
            				});
            				$.each($(".alert-error"),function(){
            					$(this).remove();
            				});
            				$("<div class='alert alert-error'><button type=button' class='close' data-dismiss='alert'>&times;</button>" + msg4delete + "</div>").insertAfter($("legend")[0]);
            			} 
            		}
            },
            parameterMap: function (options, type) {
                if (type == "destroy")
                    return "id=" + options.id;
                if (options.filter) {
                    for (var i = 0; i < options.filter.filters.length; i++) {
                        if (options.filter.filters[i].value instanceof Date){
                            options.filter.filters[i].value = kendo.toString(options.filter.filters[i].value, CustomerConnect.dateTimeFormat);
                        }
                    }
                }
                return JSON.stringify(options);
            }
        },
        pageSize: 25,
        serverPaging: true,
        serverSorting: true,
        serverFiltering: true,
        //autoSync: true,
        schema: {
            model: {
                id: "id",
                fields: {
                    id: { field: "id" },
                    updatedDate: { type: "date", parse: function(data){return kendo.parseDate(data, CustomerConnect.dateTimeFormat)} },
                    effectiveDate: { type: "date", parse: function(data){return kendo.parseDate(data, CustomerConnect.dateTimeFormat)} },
                    expiryDate: { type: "date", parse: function(data){return kendo.parseDate(data, CustomerConnect.dateTimeFormat)} }
                }
            },
            data: "data",
            total: "total"
        }
    });
}

function categoryOnChange(e){
	var categoryId = e.value;
	if ($("#type").length > 0) {
		if (categoryId == 0) {
			categoryId = "";
		}
		$("#type").select2("val", "");
		$("#type").attr("category",categoryId);
		$("#type").select2("destroy");
		$("#type").removeClass("select2-offscreen");

		renderReference($("#type"));
	}
}
	
function changeDataObjectType(emptyTypesorStatuses){
	changeDataObjectStatus(emptyTypesorStatuses);
}
function changeDataObjectStatus(emptyTypesorStatuses){
	 if (emptyTypesorStatuses) {
		 return;
	 }
   	 jQuery.ajax({
         type: 'post',
         url:  $('#form').attr("action"),
         data: $('#form').serializeArray(),
         headers: {'X-Requested-With': 'XMLHttpRequest', 'submit_request':'false'},
         success: function (data1) {
             $('#content-container').replaceWith(data1);
         },
         error: function () {
             $("<div class='alert alert-error'><button type=button' class='close' data-dismiss='alert'>&times;</button>" + fail_msg + "</div>").insertAfter($("legend")[0]);
         }
     });
}

/**
 * init 2 modals on page:	a.session reminder	b.session timeout
 */
function sessionReminder(){
	$('#_session_modal').modal('hide');
	$('#_session_modal_timeout').modal('hide');
	if(typeof(timeoutReminder) !== 'undefined')
	{
		clearTimeout(timeoutReminder);	
	}
	if(typeof(timeoutInformation) !== 'undefined')
	{
		clearTimeout(timeoutInformation);
	}
	if(!CustomerConnect.isLogin)
		return;
	var _var1 = CustomerConnect.timeoutInterval;
	var _var2 =  CustomerConnect.timeoutLogout;
	var _seconds = eval(_var1 - _var2*60);
	timeoutReminder = setTimeout(function(){
			$('#_session_modal').modal('show');
			}, _seconds*1000);
	timeoutInformation = setTimeout(function(){
			clearTimeout(timeoutReminder);
			$('#_session_modal').modal('hide');
			$('#_session_modal_timeout').modal('show');
	}, _var1*1000);
	}

/**
 * extend session expired time
 */
function refreshSession(){
	jQuery.ajax({
        type: 'get',
        url: CustomerConnect.contextPath+"/ping"});
}

/**
 * 
 * this method is used to initalize chart defined on the page.
 * 
 */
function loadCharts(){
	$(".chart").each(function(i, e){
		var id = $(e).attr("id");
		var url = $(e).attr("data-url");
		jQuery.ajax({
	         type: 'post',
	         url:  url,
	         success: function (data) {
	        	 var type = data.type;
	        	 if("PieChart" === type){
	        		 pieInit(id, data);
	        	 }else if("FunnelChart" === type){
	        	 	 funnelInit(id, data);
	        	 }else if("BarChart" === type){
	        		 columnInit(id, data);
	        	 }else if("GaugeChart" === type){
	        		 gaugeInit(id, data);
	        	 }else if("TimeSeriesChart" == type){
	        		 timeInit(id, data);
	        	 }
	         },
	         error: function () {
	         }
	     });
		
	});
}

/**
 * 
 * remove load... after request complete
 * 
 */
$(document).ajaxComplete(function(){
	$('.k-loading-mask').remove();
});


jQuery.fn.center = function () {
    var w = $(window);
    this.css("position", "fixed");
    this.css("top", w.height() / 2 - this.height() / 2 + "px");
    this.css("left", w.width() / 2 - this.width() / 2 + "px");
    return this;
}

function showMask(id, width) {
    $("#" + id).append('<div id="content-container-mask" class="k-loading-mask" style="top: 0px; left: 0px; bottom: 0; right:0"><span class="k-loading-text">Loading...</span><div id="content-container-image" class="k-loading-image"></div><div class="k-loading-color"></div></div>');
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
function bindSubmitEvent(){
	$(".btn-primary").on("click", function (){
        showMask('content-container', 1.2);
	});
}

function retrieveRecallQuestion(btnEle,sourceEle,questionDiv,answerDiv,questionEle,usernameEmptyMsg,usernameNotExistMsg,noQuestionMsg){
	var username = $(sourceEle).val();
	var spanHelpEle = $(sourceEle).next();
	username = username.replace(/^\s+|\s+$/g,'');
	if (username.length == 0) {
		if ($(spanHelpEle).children().length > 1) {
			$(btnEle).prev().remove();
		}
		$(sourceEle).focus();
		$(spanHelpEle).prepend("<label style='color:red'>" + usernameEmptyMsg + "</label>");
		return;
	}
	
	$.ajax({
    		type: 'post',
            url: CustomerConnect.contextPath + "/forgetpassword/retrieveRecallQuestion" ,
            data: "username=" + username ,
            success: function (data) {
            		if ($(spanHelpEle).children().length > 1) {
            			$(btnEle).prev().remove();
            		}
            		if ("0" == data) {
            			$(sourceEle).focus();
            			$(spanHelpEle).prepend("<label style='color:red'>" + usernameNotExistMsg +"</label>");
            			return;
            		} else if ("1" == data) {
            			$(spanHelpEle).prepend("<label style='color:red'>" + noQuestionMsg + "</label>");
            			return;
            		} else if (data) {
            			$(questionDiv).attr("style","display:");
                    	$(answerDiv).attr("style","display:");
                    	$(questionEle).text(data);
                    	$(spanHelpEle).remove();
            		}
            }
    });
}

function checkRecallAnswer(btnEle, usernameEle, sourceEle, passwordDiv, passwordConfDiv, submitBtnDiv, answerEmptyMsg, answerIncorrectMsg){
	var username = $(usernameEle).val();
	var recallanswer = $(sourceEle).val();
	var spanHelpEle = $(sourceEle).next();
	username = username.replace(/^\s+|\s+$/g,'');
	recallanswer = recallanswer.replace(/^\s+|\s+$/g,'');
	if (recallanswer.length == 0) {
		if ($(spanHelpEle).children().length > 1) {
			$(btnEle).prev().remove();
		}
		$(sourceEle).focus();
		$(spanHelpEle).prepend("<label style='color:red'>" + answerEmptyMsg + "</label>");
		return;
	}
	
	$.ajax({
    		type: 'post',
            url: CustomerConnect.contextPath + "/forgetpassword/checkRecallAnswer" ,
            data: "username=" + username + "&recallanswer=" + recallanswer ,
            success: function (data) {
                	if ($(spanHelpEle).children().length > 1) {
            			$(btnEle).prev().remove();
            		}
            		if ("true" == data) {
            			$(passwordDiv).attr("style","display:");
                    	$(passwordConfDiv).attr("style","display:");
                    	$(submitBtnDiv).attr("style","display:");
                    	$(spanHelpEle).remove();
            		} else {
            			$(sourceEle).focus();
            			$(spanHelpEle).prepend("<label style='color:red'>" + answerIncorrectMsg + "</label>");
            		}
            }
    });
}

function resetPassword(usernameEle,passwordEle,passConfEle,passEmptyMsg,passNotMatchMsg,passMinLength,passMinLengthMsg){
	var username = $(usernameEle).val();
	var password = $(passwordEle).val();
	var passConf = $(passConfEle).val();
	username = username.replace(/^\s+|\s+$/g,'');
	password = password.replace(/^\s+|\s+$/g,'');
	passConf = passConf.replace(/^\s+|\s+$/g,'');
	
	
	if (password.length == 0) {
		$(passwordEle).focus();
		$(passwordEle).next().empty();
		$(passwordEle).next().append("<div style='float:left;'><span class='required'>" + passEmptyMsg + "</span></div>");
		return;
	} else if (password.length >0 && passMinLength > 0 && passMinLength > password.length) {
		$(passwordEle).focus();
		$(passwordEle).next().empty();
		$(passwordEle).next().append("<div style='float:left;'><span class='required'>" + passMinLengthMsg + "</span></div>");
		return;
	}
	
	if (password == passConf) {
		$.ajax({
    		type: 'post',
            url: CustomerConnect.contextPath + '/forgetpassword/resetpassword' ,
            data: "username=" + username + "&newpassword=" + password ,
            success: function (data) {
                	location.href="${pageContext.request.contextPath}/login";
            }
    	});
	} else {
		$(passwordEle).focus();
		$(passwordEle).next().empty();
		$(passwordEle).next().append("<div style='float:left;'><span class='required'>" + passNotMatchMsg + "</span></div>");
		$(passConfEle).next().empty();
		$(passConfEle).next().append("<div style='float:left;'><span class='required'>" + passNotMatchMsg + "</span></div>");
	}
	return false;
}


/**
 * @param id	id of attachment
 * 
 * this function is provided access for download attachment
 * 
 */
function downloadReport(id){
	window.location.href = CustomerConnect.contextPath + "/attachment/download/"+id;
}


/**
 * 
 * @param id	id of report template
 * 
 * this function will trig a request for generating report by specific report template id
 */
function runReport(id){
	$('.alert').remove();
	var html;
	jQuery.ajax({
		type:	'get',
		url:	CustomerConnect.contextPath + "/reporttemplate/checkmodifiable/"+id,
		async:	false,
		success:function(data){
			html = data;
		}
	});
	var isModifiable = $(html).find("select").length > 0;
	if(!isModifiable){
		jQuery.ajax({
	        type: 'get',
	        url: CustomerConnect.contextPath + "/reporttemplate/execute/" + id,
	        success: reportGenerationCallback
	    });
	}else{
		$("#popup").find(".modal-body").html(html);
		$("#popup").modal("show");
	}
}

function reportGenerationCallback(){
	ajaxCallback("Report generated already.");
}

function ajaxCallback(info){
	$("<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button>"+info+"</div>").insertAfter($("legend")[0]);
}

/**
 * 
 * this function will trig a one time report. no template depends on
 * 
 */
function runReportOnetime(){
	jQuery.ajax({
        type: "POST",
        url: CustomerConnect.contextPath+"/reporttemplate/execute",
        data: $('#form').serializeArray(),
        headers: {'X-Requested-With': 'XMLHttpRequest'},
        success: function (data1) {
            $('#content-container').replaceWith(data1);
            if ($(data1).find(".error").length > 0) {
            	
            }else{
            	reportGenerationCallback();
            }
            
        }
    });
}


/**
 * 
 * this function will hide tab name field when group type is not Tab
 */
function hasTabRoles(typeEle,tabType,tabNameEle,tabRoleEle,sizeEle,msg4TabName){
	var type = $(typeEle).val();
	if (type != tabType){
		$("#btn_0").attr("style","display:none");
		$(tabNameEle).attr("style","display:none");
		$(tabRoleEle).attr("name","indexRolesMap[-1]");
		var size = $(sizeEle).val();
		
		for (var i=1; i< parseInt(size);i++) {
			$("#tabRoles_" + i).empty();
			$("#tabRoles_" + i).remove();
		}
	}else {
		$("#btn_0").empty();
		$("#btn_0").prepend($("<i class='icon-plus'></i>"));
		$("#btn_0").attr("onclick","addTabRoleRow(this,'" + msg4TabName + "');");
		$("#btn_0").attr("style","display:");
		$(tabNameEle).attr("style","display:");
		$(tabNameEle).attr("value","");
		$(tabRoleEle).attr("name","indexRolesMap[0]");
	}
	$(sizeEle).attr("value",1);
}

/**
 * 
 * when click 'Add' btn, will add new Row for Tab-Role
 */
function addTabRoleRow(btnEle,msg4TabName){
	var size = $("#size").val();
	
	var currentIndex = $(btnEle).attr("index");
	var tabName = $("#indexTabMap_" + currentIndex).val();
	var role = $("#indexRolesMap_" + currentIndex).val();
	var errorMsgEle = $(btnEle).parent().next();
	
	if (tabName.length == 0 || tabName.replace(/^\s+|\s+$/g,'').length == 0) {
		$("#indexTabMap_" + currentIndex).focus();
		$(errorMsgEle).empty();
		$(errorMsgEle).append($("<span class='required'>" + msg4TabName + "</span>"));
		return;
	}
	$(errorMsgEle).empty();
	
	$(btnEle).empty();
	$(btnEle).prepend($("<i class='icon-minus'></i>"));
	$(btnEle).attr("onclick","removeTabRoleRow(this);");
	 
	var row = $("#tabRoles").clone();
	$(row).attr("id","tabRoles_" + size);
	$(row).attr("style","display:");
	
	$(row).find("input[type=text]").attr("name","indexTabMap[" + size + "]");
	$(row).find("input[type=text]").attr("id","indexTabMap_" + size);
	$(row).find("select").attr("id","indexRolesMap_" + size);
	$(row).find("select").attr("name","indexRolesMap[" + size + "]");
	$(row).find("select").attr("data-type","select");
	$(row).find("button").attr("index",size);
	$(row).find("button").attr("id","btn_" + size);

	$("#container").append($(row));
	loadFields($(row));
	size = parseInt(size) + 1;
	$("#size").attr("value",size);
	
}

/**
 * when click 'Remove' btn, will remove selected Row for Tab-Role
 * 
 */
function removeTabRoleRow(btnEle){
	var currentIndex = $(btnEle).attr("index");
	$("#tabRoles_" + currentIndex).attr("style","display:none");
	$("#tabRoles_" + currentIndex).find("input[type=text]").attr("value","");
	$("#tabRoles_" + currentIndex).find("select").select2("val","");
}




/**
 * this function is for user to edit profile
 * 
 */
function editProfile(formEle){
	ajaxPost(CustomerConnect.contextPath + "/user/editprofile", $(formEle).serialize());
}


/**
 * this function is for navmenu 'View Profile'
 * @param reqType : get/post
 * 
 */
function viewprofile(reqType){
	jQuery.ajax({
        type: reqType,
        url: CustomerConnect.contextPath + "/user/viewprofile" ,
        headers: {'X-Requested-With': 'XMLHttpRequest'},
        success: function (data1) {
            $('#content-container').replaceWith(data1);
        }
    });
}



function reflashCodeValues(type, valueId){
	$("#"+valueId).select2("destroy");
	$("#"+valueId+" option:gt(0)").remove();
	if($(type).attr("value")===""){
		$("#"+valueId).select2({width: 'element',allowClear: true});
		return;
	}
	
	jQuery.ajax({
		url: CustomerConnect.contextPath+ "/codevalue/parentcodevalues/" + $(type).attr("value"),
		type: 'post',
		async:false,
		success: function (data, status){
				for(var i=0;i<data.length;i++){
					$("#"+valueId).append("<option value='"+data[i].id+"'>"+data[i].label+"</option>");
				}
				$("#"+valueId).select2({width: 'element',allowClear: true});
			}
		});
}

/**
 * 
 * @param i
 * @param e
 */
function reflashCodeValueByParent(i, e)
{
	var $component = $(e);
	var parentField = $(e).attr("data-parent-field");
	var code = $(e).attr("data-code");
	if ('' == parentField || typeof(parentField) == 'undefined') {
		return;
	}
	// make the code selected when update
	if (-1 == parentField.indexOf(",")) {
		var value = $component.attr("value");
		$("select[id='"+parentField+"']").on("change", function(){
			var url = CustomerConnect.contextPath+ "/codevalue/reflash/" + code;
			$component.select2("destroy");
			$component.find("option").each(function(i,e){
				if($(e).attr("value")!="")
					$(e).remove();
			});
			if(this.value != ""){
				url = url +"/"+this.value;
				jQuery.ajax({
					url: url,
					type: 'post',
					async:false,
					success: function (data, status){
							for(var i=0;i<data.length;i++){
								$component.append("<option value='"+data[i].key+"'>"+data[i].value+"</option>");
							}
						}
					});
			}
			$component.select2({width: 'element',allowClear: true}).val(value).trigger("change");
		});
		$("select[id='"+parentField+"']").trigger("change");
	} else {
		var $target = $(e);
		var array = parentField.split(',');
		var set = eval($target.attr("data-code-set"));
		$("[id='"+array[0]+"'], [id='"+array[1]+"']").on("change", function(){
				var type1 = $("[id='"+array[0]+"']").val();
				var type2 = $("[id='"+array[1]+"']").val();
				var targetVal = "";
				for(var i in set){
					var kv = set[i].key.split("-");
					if((type1 == kv[0] && type2 == kv[1]) || (type1 == kv[1] && type2 == kv[0])){
						targetVal = set[i].value;
						break;
					}
				}
				$target.val(targetVal).trigger("change");
		});
		if(eval($target.attr("data-readonly"))){
			var $label = $("<div class='controls'><div class='display-values'>"+$target.find("option:selected").text()+"</div></div>");
			$target.on("change", function(){
				$label.find('.display-values').text($target.find("option:selected").text());
			});
			$target.closest(".control-group").append($label);
			$target.closest(".controls").hide();
		}
		
	}
	
	
}

/**
 * used to set min width when resize grid column
 * @param e
 */
function resizeGridColumnCallback(e){
	 $("#grid colgroup col").each(function(){
		if($(this).width()<10){
			$(this).css("width", "20px");
		} 
	 });
}

/**
 * this function is for UserGroupRoleAssignment, when roles changed, update groupRoleAssignment-role options.
 */
function roleOnChange(ele, sizeEle, assignmentRoleEleId) {
	var size = $(sizeEle).val();
	var ids = "";
	roleOptions = "<option value=''></option>";
	
	$.each($(ele).select2("data"), function() {
		roleOptions = roleOptions + "<option value='"+this.id+"'>"+this.text+"</option>"
		ids = ids + "id=" + this.id + ",";
	});
	
	for (var i = 0;i < size; i ++) {
		var selectedData = $(assignmentRoleEleId+i).select2("data");
		$(assignmentRoleEleId+i).select2("destroy");
		$(assignmentRoleEleId+i).empty();
		$(assignmentRoleEleId+i).append(roleOptions);
		$(assignmentRoleEleId+i).select2({width: 'element',allowClear: true});
		if ("undefined" != selectedData.id && ""!= selectedData.id) {
			if (-1 != ids.indexOf("id="+selectedData.id+",")) {
				$(assignmentRoleEleId+i).select2("data",selectedData);
			}
		}
	}
}

/**
 * this function is for UserGroupRoleAssignment, when groups changed, update groupRoleAssignment-group options.
 */
function groupOnChange (ele, sizeEle, assignmentGroupEleId) {
	var size = $(sizeEle).val();
	var ids = "";
	groupOptions = "<option value=''></option>";
	
	$.each($(ele).select2("data"), function() {
		groupOptions = groupOptions + "<option value='"+this.id+"'>"+this.text+"</option>"
		ids = ids + "id=" + this.id + ",";
	});
	
	for (var i = 0;i < size; i ++) {
		var selectedData = $(assignmentGroupEleId+i).select2("data");
		$(assignmentGroupEleId+i).select2("destroy");
		$(assignmentGroupEleId+i).empty();
		$(assignmentGroupEleId+i).append(groupOptions);
		$(assignmentGroupEleId+i).select2({width: 'element',allowClear: true});
		if ("undefined" != selectedData.id && ""!= selectedData.id) {
			if (-1 != ids.indexOf("id="+selectedData.id+",")) {
				$(assignmentGroupEleId+i).select2("data",selectedData);
			}
		}
	}
}

/**
 * this function is for UserGroupRoleAssignment to add new row of Group-Role mapping.
 */
function btnAddOnClick(sizeEle, templateEle, containerEle, assignmentGroupEleId, assignmentRoleEleId) {
	var size = $(sizeEle).val();
	var row = $(templateEle).clone();
	var btn = $(row).find("[type=button]")[0];
	$(btn).attr("value",size);
	
	if (parseInt(size) > 0) {
		var preAssignGroup = $('#'+assignmentGroupEleId + (parseInt(size)-1));
		var preAssignRole = $('#'+assignmentRoleEleId + (parseInt(size)-1));
		if ($(preAssignGroup).val() == "" || $(preAssignRole).val() == "") {
			$('#rowDiv_'+(parseInt(size) -1)).find(".help-inline").empty();
			$('#rowDiv_'+(parseInt(size) -1)).find(".help-inline").append("<span class='required'>"+notNullMsg+"</span>");
			return;
		}
		$('#rowDiv_'+(parseInt(size) -1)).find(".help-inline").empty();
	}

	$.each($(row).find("select"),function(i){
			$(this).attr('data-type','select');
		if (i == 0) {
			$(this).attr("id", assignmentGroupEleId + size);
			$(this).attr("name", "groupRoleAssignments[" + size + "].group");
			$('#'+assignmentGroupEleId + size+" option:gt(0)").remove();
			$(this).append(groupOptions);
		} else if (i == 1) {
			$(this).attr("id", assignmentRoleEleId + size);
			$(this).attr("name", "groupRoleAssignments[" + size + "].role");
			$('#'+assignmentRoleEleId + size+" option:gt(0)").remove();
			$(this).append(roleOptions);
		}
	});
	
	$(row).attr("id","rowDiv_"+size);
	$(row).show();
	$(sizeEle).attr("value",parseInt(size)+1);
	$(containerEle).append(row);
	loadFields($(row));
}

/**
 * this function is for UserGroupRoleAssignment to remove row of Group-Role mapping.
 * @param ele
 */
function btnRemoveOnClick(ele) {
	var index = $(ele).val();
	$("#rowDiv_"+index).hide();
	$("#rowDiv_"+index).find("[type=checkbox]").prop('checked', true);
}

/**
 * this function is for Highlighting of navmenu, remove the active LI and highlight the selected LI
 */
function highlightNavmenu () {
	var pageTag = $("#content-container").attr("data-page-name");
	// remove actived LI
	var activedLIs = $("#topnavbar li").filter(".active");
	for(var i=0;i< activedLIs.length ; i++){
		var li = $(activedLIs[i]);
		var liClass = li.attr("class");
		if(liClass == null){
			liClass="";	
		}
		liClass = liClass.replace(" active","");
		li.attr("class",liClass);
		var parentLI = $(li.parents(".dropdown")); 
		if(parentLI != null && parentLI.length > 0 ){
			var parentClass = parentLI.attr("class");
			parentClass = parentClass.replace(" active","");
			parentLI.attr("class",parentClass);
		}
	}
	//highlight the selected LI	
	//	var matchingLIs = $("#topnavbar li").find("[data-name="+pageTag+"]");
	var matchingLIs = $("#topnavbar li").filter("[data-name="+pageTag+"]"); 
	
	for(var i=0;i< matchingLIs.length ; i++){
		var li = $(matchingLIs[i]);
		var liClass = li.attr("class");
		if(liClass == null){
			liClass="";	
		}
		liClass += " active";
		li.attr("class",liClass);
		var parentLI = $(li.parents(".dropdown")); 
		if(parentLI != null && parentLI.length > 0 ){
			var parentClass = parentLI.attr("class");
			parentClass += " active";
			parentLI.attr("class",parentClass);
		}
	}
}


/**
 * 
 * this function is for DataViewField to add file type - max file size mapping.
 */
function addTypeSizeRow(btnEle, sizeEle, templateEle, typeErrorMsg, sizeErrorMsg) {
	var size = $(sizeEle).val();

	var currentIndex = $(btnEle).attr("index");
	var fileTypeEle = $("#fileTypeMap_" + currentIndex);
	var fileSizeEle = $("#fileSizeMap_" + currentIndex);
	var fileType = fileTypeEle.val();
	var fileSize = fileSizeEle.val();
	var errorMsgEle = $(btnEle).parent().next();

	$(errorMsgEle).empty();
	
	if (fileType.length == 0 || fileType.replace(/^\s+|\s+$/g,'').length == 0) {
		$(fileTypeEle).focus();
		$(errorMsgEle).append($("<span class='required'>" + typeErrorMsg + "</span>"));
		return;
	}
	fileSize = fileSize.replace(/^\s+|\s+$/g,'');
	if (isNaN(fileSize)) {
		$(fileSizeEle).focus();
		$(errorMsgEle).append($("<span class='required'>" + sizeErrorMsg + "</span>"));
		return;
	}
	$(btnEle).empty();
	$(btnEle).prepend($("<i class='icon-minus'></i>"));
	$(btnEle).attr("onclick","removeTypeSizeRow(this);");

	var row = $(templateEle).clone();
	$(row).attr("id","typeSizeMap_" + size);
	$(row).attr("style","display:");

	var inputs = $(row).find("input[type=text]");
	$(inputs[0]).attr("name","fileTypeMap[" + size + "]");
	$(inputs[0]).attr("id",  "fileTypeMap_" + size);
	
	$(inputs[1]).attr("name","fileSizeMap[" + size + "]");
	$(inputs[1]).attr("id",  "fileSizeMap_" + size);

	$(row).find("button").attr("index",size);

	$("#container").append($(row));
	size = parseInt(size) + 1;
	$(sizeEle).attr("value",size);
}

/**
 * 
 * this function is for DataViewField to remove file type - max file size mapping.
 */
function removeTypeSizeRow(btnEle) {
	var currentIndex = $(btnEle).attr("index");
	$("#typeSizeMap_" + currentIndex).attr("style","display:none");
	var inputs = $("#typeSizeMap_" + currentIndex).find("input[type=text]");
	$(inputs[0]).attr("value","");
	$(inputs[1]).attr("value","");
}


/**
 * 
 * this function is for Group to dynamic retrieve sub Group Type.
 */
function groupTypeOnChange(thisEle, subTypeEle, tobeHiddenEle, logicalTypeName, subType) {
	var type = $(thisEle).val();
	if (tobeHiddenEle != '' && logicalTypeName != '') {
		if (type == logicalTypeName) {
			$(tobeHiddenEle).attr("style","display:none");
			$(tobeHiddenEle).find("select").select2("val","");
		} else {
			$(tobeHiddenEle).attr("style","display:");
		}
	}
	
	
	if (type != "") {
		jQuery.ajax({
	        type: 'post',
	        async:false,
	        url: CustomerConnect.contextPath + "/group/getSubTypes/" + type,
	        success: function (data) {
	            if (data.length > 0) {
	            	$(subTypeEle).select2("destroy");
	            	$(subTypeEle+" option:gt(0)").remove();
	                 
	            	for(var i=0;i<data.length;i++){
						$(subTypeEle).append("<option value='"+data[i].key+"'>"+data[i].value+"</option>");
					}
					$(subTypeEle).select2({width: 'element',allowClear: true});
					$(subTypeEle).select2("val",subType);
	            }
	        }
	    });
	}
	
}

function getGridFilterConfiguration() {
	return {
		messages:{
			info:"Show items with value that:",
			filter:"Filter",
			clear:"Clear",
			and:"And",
			or:"Or"
		},
		operators: {
			string:{
				eq:"Is equal to",
				neq:"Is not equal to",
				startswith:"Starts with",
				contains:"contains",
				doesnotcontain:"Does not contain",
				endswith:"Ends with"
			},
			number:{
				eq:"Is equal to",
				neq:"Is not equal to",
				gte:"Is greater than or equal to",
				gt:"Is greater than",
				lte:"Is less than or equal to",
				lt:"Is less than"
			},
			date:{
				eq:"Is equal to",
				neq:"Is not equal to",
				gte:"Is after or equal to",
				gt:"Is after",
				lte:"Is before or qqual to",
				lt:"Is before"
			}
		}
	};
}
