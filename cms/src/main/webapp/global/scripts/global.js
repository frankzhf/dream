var browserVersion = parseInt(navigator.appVersion);

var isNetscape = navigator.appName.indexOf("Netscape") != -1;

var isIE = navigator.appName.indexOf("Microsoft") != -1;

var agent = navigator.userAgent.toLowerCase(  );

var isWindows = agent.indexOf("win") != -1;

var isMac = agent.indexOf("mac") != -1;

var isUnix = agent.indexOf("X11") != -1; 

/*
function isCheckBoxSelected(form){
	var elements = form.elements;
	for (var i = 0; i < elements.length; i++) {
		var element = elements[i];
		if (element.type == "checkbox") {
			if ( element.checked ){
				return true;
			}
		}
	}
	return false;
}
//*/

//*
function isCheckBoxSelected(form, chkname){
	var elements = form.elements;
	for (var i = 0; i < elements.length; i++) {
		var element = elements[i];
		if (element.type == "checkbox" && (chkname == null || element.name==chkname) && element.checked) {
			return true;
		}
	}
	return false;
}
//*/
function toggleDisabled(el) {
    try {
        el.disabled = true;
    }
    catch(E){}
    if (el.childNodes && el.childNodes.length > 0) {
        for (var x = 0; x < el.childNodes.length; x++) {
            if('text/css'!=el.childNodes[x].type)
            	toggleDisabled(el.childNodes[x]);
        }
    }
}

function toggleAbled(el) {
    try {
        el.disabled = false;
    }
    catch(E){}
    if (el.childNodes && el.childNodes.length > 0) {
        for (var x = 0; x < el.childNodes.length; x++) {
        	if('text/css'!=el.childNodes[x].type)
        		toggleAbled(el.childNodes[x]);
        }
    }
}

function selectAllCheckBoxByName(form, checkBoxName) {
	var elements = form.elements;
	var selectAllName = "selectAll[" + checkBoxName + "]";
	var checked = form[selectAllName].checked;		

	for (var i = 0; i < elements.length; i++) {
		var element = elements[i];
		
		if (element.type == "checkbox" &&
			element.name == checkBoxName) {
			element.checked = checked;
		}
	}
}

function setSelectAllStateByName(form, checkBoxName) {
	var elements = form.elements;
	var selectAllName = "selectAll[" + checkBoxName + "]";
	var checked = form[selectAllName].checked;		

	var checkBoxCount = 0;
	var checkedCheckBoxCount = 0;
	

	for (var i = 0; i < elements.length; i++) {
		var element = elements[i];
		
		if (element.type == "checkbox" &&
			element.name == checkBoxName) {
			checkBoxCount++;
			
			if (element.checked == true) {
				checkedCheckBoxCount++;
			}
		}
	}
	
		
	if (checkedCheckBoxCount < checkBoxCount &&
		checked != false) {
		form[selectAllName].checked = false;
		return;
	}
	
	if (checkedCheckBoxCount == checkBoxCount &&
		checked == false) {
		form[selectAllName].checked = true;
		return;		
	}
}

function mySelectAllCheckBoxByName(_form, selectAllName, checkBoxName) {
	var _elements = _form.elements;
	var _checked = _form[selectAllName].checked;		

	for (var i = 0; i < _elements.length; i++) {
		var _element = _elements[i];
		
		if (_element.type == "checkbox" &&
			_element.name == checkBoxName) {
			_element.checked = _checked;
		}
	}
}


function selectAllCheckBox(form) {
	var elements = form.elements;
	var checked = form.selectAll.checked;		

	for (var i = 0; i < elements.length; i++) {
		var element = elements[i];
		
		if (element.type == "checkbox" &&
			element.name != "selectAll") {
			element.checked = checked;
		}
	}
}

function setSelectAllState(form) {
	var elements = form.elements;
	var checked = form.selectAll.checked;		

	var checkBoxCount = 0;
	var checkedCheckBoxCount = 0;
	

	for (var i = 0; i < elements.length; i++) {
		var element = elements[i];
		
		if (element.type == "checkbox" &&
			element.name != "selectAll") {
			checkBoxCount++;
			
			if (element.checked == true) {
				checkedCheckBoxCount++;
			}
		}
	}
	
		
	if (checkedCheckBoxCount < checkBoxCount &&
		checked != false) {
		form.selectAll.checked = false;
		return;
	}
	
	if (checkedCheckBoxCount == checkBoxCount &&
		checked == false) {
		form.selectAll.checked = true;
		return;		
	}
}

var showSubmitConfirmation = false;
var submitConfirmationMsg = "";

function setConfirmationMessage(message) {
	showSubmitConfirmation = true;
	submitConfirmationMsg = message;
}

function confirmSubmit() {
	if (showSubmitConfirmation) {
		var confirmation = window.confirm(submitConfirmationMsg);
		
		if (confirmation == false) {
			showSubmitConfirmation = false;
		}
		return confirmation;
	} else {
		return true;
	}
}

function toggleDisplay(blockId, image, expandSrc, collapseSrc) {
	var element = document.getElementById(blockId);

	if (element.style.display=="none") {
		element.style.display="block";
		image.src=collapseSrc;
	} else if (element.style.display=="block") {
		element.style.display="none";
		image.src=expandSrc;	
	} else {
		element.style.display="none";
		image.src=expandSrc;	
	}
}


function toggleDisplay(id, image, collapseSrc, expandSrc) {
	var element = document.getElementById(id);

	if (element.style.display=="none") {
		element.style.display="block";
		image.src=collapseSrc;
	} else if (element.style.display=="block") {
		element.style.display="none";
		image.src=expandSrc;	
	} else {
		element.style.display="none";
		image.src=expandSrc;	
	}
}  

function disableEnterKey(event) {
	if (!event) event = window.event;
	var element = event.srcElement ? event.srcElement : event.target;
	
	if (event.keyCode == 13 &&
		element.type != "submit" &&
		element.type != "textarea" &&
		element.type != "reset") {

		if (window.event) {
			event.cancelBubble = true;
			event.returnValue = false;
		} else {
			event.stopPropagation();
			event.preventDefault();
		}

		return false;
	}
}

function formEnterKey(defaultSubmitId, event, ignore) {
	if(ignore == true){
		disableEnterKey(event);
		return;
	}
	var _submit = document.getElementById(defaultSubmitId);
	if(_submit == null){
		_submit = document.getElementsByName(defaultSubmitId)[0];
	}
	if(_submit == null){
		alert(defaultSubmitId + " not found");
		return true;
	}
	if (!event) event = window.event;
	var element = event.srcElement ? event.srcElement : event.target;
	
	if (event.keyCode == 13 && element.type != "submit" && element.type != "textarea" && element.type != "reset" && element.type != "image") {
		alert(_submit + " success");
		_submit.click();
		return false;
	}
	return true;
}



function justNumberText(event)
{
	if (!event) event = window.event;
	if (isIE) {
		if ( !(((event.keyCode >= 48) && (event.keyCode <= 57)) 
		|| (event.keyCode == 13) || (event.keyCode == 46) 
		|| (event.keyCode == 45) || (event.keyCode == 8))){
			event.keyCode = 0 ;
			event.cancelBubble = true;
			event.returnValue = false;
			return false;
		}
	}
	if (isNetscape){
		if ( !(((event.which >= 48) && (event.which <= 57)) 
		|| (event.which == 13) || (event.which == 46) 
		|| (event.which == 45)|| (event.which == 8))){
			event.stopPropagation();
			event.preventDefault();
			return false;
		}
	}
	return true;
} 

function iecompattest(){
	return (!window.opera && document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body
}

function insertHtml(object, code, isStart){  //???, ??, ???
	if(isIE)
		object.insertAdjacentHTML(isStart ? "afterbegin" : "beforeEnd",code);
	else{
		var range=object.ownerDocument.createRange();
		range.setStartBefore(object);
		var fragment = range.createContextualFragment(code);
		if(isStart)
	 		object.insertBefore(fragment, object.firstChild);
		else
			object.appendChild(fragment);
	}
}

function selectFirstNode(){
	try{
		var root = tree.getTree();
		var firstChild = root.getFirstChild();
		firstChild.expand();
		firstChild.select();
		firstChild.click();
	}catch(e){
	}
}
function expendFirstNode(){
	try{
		var root = tree.getTree();
		var firstChild = root.getFirstChild();
		firstChild.expand();
	}catch(e){
	}
}
