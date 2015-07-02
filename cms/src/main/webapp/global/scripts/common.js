String.prototype.replaceAll  = function(s1,s2){    
	return this.replace(new RegExp(s1,"gm"),s2);    
};


function checkKey(e,fun){
	var charCode=(navigator.appName=="Netscape")?e.which:e.keyCode;
	//alert(charCode);
	if(charCode == 13){
		eval(fun);
	}
}


//create obj
var GLOBAL_NULL = '';
var REG_NATURAL_NUM = /^[1-9]\d*$/;
var REG_INT_NUM = /^-?\d+$/;
var REG_NUM = /^\-?\d+(.\d+)?$/;
var REG_2DECIMAL_NUM = /^\d+(\.\d{1,2})?$/;
var REG_1DECIMAL_NUM = /^\d+(\.\d{1})?$/;
var REG_8_12_DIGITS_NUM = /^\d{8,12}$/;
var REG_EMAIL = /^([a-zA-Z0-9_\-])([a-zA-Z0-9_\-\.]*)@(\[((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\.){3}|((([a-zA-Z0-9\-]+)\.)+))([a-zA-Z]{2,}|(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\])$/;
//var MUL_REG_EMAIL = /^([a-zA-Z0-9_\-])([a-zA-Z0-9_\-\.]*)@(\[((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\.){3}|((([a-zA-Z0-9\-]+)\.)+))([a-zA-Z]{2,}|(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\])((;([a-zA-Z0-9_\-])([a-zA-Z0-9_\-\.]*)@(\[((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\.){3}|((([a-zA-Z0-9\-]+)\.)+))([a-zA-Z]{2,}|(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\]))*)$/;
var REG_DATE_STRICT = /^(((0[1-9]|[12][0-9]|3[01])\/((0[13578]|1[02]))|((0[1-9]|[12][0-9]|30)\/(0[469]|11))|(0[1-9]|[1][0-9]|2[0-8])\/(02))\/([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3}))|(29\/02\/(([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00)))$/;
var REG_YEAR = /^(19|20)\d\d+$/;
var REG_POSITIVE = /^\d+(\.\d+)?$/;
var LEAP_YEAR = /^\d{2}([02468][048]|[13579][26])?$/;
var POS_WHOLE_NUM = /^\d+$/;
//var REG_DATE = /^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\d\d+$/;
var TWELVE_HOUR_TIME = /^((0[1-9])|(1[0-2])):([0-5][0-9])$/;
var REG_TWENTY_FOUR_HOUR_TIME = /^(([0-1][0-9])|(2[0-3])):([0-5][0-9])$/;
var NATURE_NUM = /^[1-9]\d*$/;
var REG_FULL_DATE_TIME = /^((((((0?[1-9])|([1-2][0-9])|(3[01]))\/((0?[13578])|(1[02])))|(((0?[1-9])|([1-2][0-9])|(30))\/((0?[469])|(11)))|(((0?[1-9])|([1-2][0-9]))\/02))\/\d{2}(([02468][048])|([13579][26])))|(((((0[1-9])|([1-2][0-9])|(3[01]))\/((0[13578])|(1[02])))|(((0[1-9])|([1-2][0-9])|(30))\/((0[469])|(11)))|(((0[1-9])|(1[0-9])|(2[0-8]))\/02))\/\d{2}(([02468][1235679])|([13579][01345789]))))(\s(([0-1][0-9])|(2[0-3]))\:([0-5][0-9]))$/
var REG_NUM_ALPHA = /^[A-Za-z0-9]+$/;
var REG_FULL_TIME = /^((0[0-9])|([1-2][0-3])|([1][4-9]))\:([0-5][0-9])$/;
var POSITIVE_NUM_WITH_ZERO = /^(0|[1-9]\d*)$/;
var ALL_NUM = /^\d+$/;
/**
 * use to format num, date, email and so on, any other request,
 * pls add the regular expression
 **/
function validateFormat(regExp,value)
{
    if(value != null && value != '')
    {
        return regExp.test(value);
    }else
        return true;
}

//Only use for section 1 to section 9
function gotoManageApplicant(){
	url = contextPath + "/application/manageApplications.do";
	location.href = url;
}

//key control: user only can input number key and 'Backspace' 'Delete' key
function keyControlForNo(e){
  	var key = window.event ? e.keyCode : e.which;
	if(!isIE()){
		if(key == 8 || key == 0){
			return true;
		}
	}
	if(48>key||key>57) {
		return false;
	}
} 

function cancelEnter(){
	if(promptMsg(prompt_com_continue)){
		document.forms[0].reset();
	}
}	

var CONST_MONEY_COLUMN_LENGTH = 9; //General money number length

// basic brand determination
function isNav() {
	return (navigator.appName == "Netscape" && !isOpera() && !isSafari());
}

function isIE() {
	return (navigator.appName == "Microsoft Internet Explorer");
}

function isOpera() {
	return (navigator.userAgent.indexOf("Opera") != -1);
}

function isSafari() {
	return (navigator.userAgent.indexOf("Safari") != -1);
}

// operating system platforms
function isWindows() {
	return (navigator.appVersion.indexOf("Win") != -1);
}

function isWin95NT() {
	return (isWindows() && (navigator.appVersion.indexOf("Win16") == -1 && navigator.appVersion.indexOf("Windows 3.1") == -1));
}

function isMac() {
	return (navigator.appVersion.indexOf("Mac") != -1);
}

function isMacPPC() {
	return (isMac() && (navigator.appVersion.indexOf("PPC") != -1 || navigator.appVersion.indexOf("PowerPC") != -1));
}

function isUnix() {
	return (navigator.appVersion.indexOf("X11") != -1);
}

/**********************************************************************
 * Component ID : isValidObject
 * Input        : Name          Type                    Description
 *                ------------- ----------------------- ------------
 *                objToTest		any						any objects
 * Output       : boolean
 * Description  : Returns true if element is not null and not "undefined".
 **********************************************************************
 */
function isValidObject(objToTest){
	if (null == objToTest) {
		return false;
	}
	if ("undefined" == typeof(objToTest) ) {
		return false;
	}
	return true;
}

/**********************************************************************
 * Component ID : isElementBoxChecked
 * Input        : Name          Type                    Description
 *                ------------- ----------------------- ------------
 *                elementBox	element/element[]		Can be either checkbox or radiobox elements
 * Output       : boolean
 * Description  : Returns true if element is checked.
 **********************************************************************
 */
function isElementBoxChecked(elementBox){
	if (elementBox != null){
		if(elementBox.length){
            if (elementBox.checked == true){
                return true;
            }
		}else{
			for (i = 0; i < elementBox.length; i++){
				if (elementBox[i].checked == true){
					return true;
				}
			}
		}
	}
	return false;
}

/**********************************************************************
 * Component ID : valueIsChecked
 * Input        : Name          Type                    Description
 *                ------------- ----------------------- ------------
 *                elementBox	element/element[]		Can be either checkbox or radiobox elements
 *                value			string					Value to check against
 * Output       : boolean
 * Description  : Returns true if element.value matching the input value is checked.
 **********************************************************************
 */
function valueIsChecked(elementBox, value){
	if (elementBox != null){
		if (elementBox.length == null){
				if (elementBox.checked == true){
					if (elementBox.value == value){
						return true;
					}
				}
		}else{
			for (i = 0; i < elementBox.length; i++){
				if (elementBox[i].checked == true){
					if (elementBox[i].value == value){
						return true;
					}
				}
			}
		}
	}
	return false;
}

/**********************************************************************
 * Component ID : fmtMoney
 * Input        : Name          Type                    Description
 *                ------------- ----------------------- ------------
 *                -				-						-
 * Output       : String
 * Description  : Format integer to money format. E.g 10000 --> 10,000.00
 **********************************************************************
 */
/**
fmtMoney = function(n, c, d, t){
    var m = (c = Math.abs(c) + 1 ? c : 2, d = d || ".", t = t || ",",
        /(\d+)(?:(\.\d+)|)/.exec(n + "")), x = m[1].length > 3 ? m[1].length % 3 : 0;
    return (x ? m[1].substr(0, x) + t : "") + m[1].substr(x).replace(/(\d{3})(?=\d)/g,
        "$1" + t) + (c ? d + (+m[2] || 0).toFixed(c).substr(2) : "");
};
**/

/**********************************************************************
 * Component ID : popupWindow
 * Input        : Name          Type                    Description
 *                ------------- ----------------------- ------------
 *                -				-						-
 * Output       : window
 * Description  : Return the window
 **********************************************************************
 */
function popupWindow(path,name,pHeight, pWidth){
    var  LeftPosition=(screen.width)?(screen.width-800)/2:100;
    var  TopPosition=(screen.height)?(screen.height-600)/2:100;
    var height = 600;
    var width = 800;
    if(pHeight)
        height = pHeight;
    if(pWidth)
        width = pWidth;
    win=window.open(path, name,'height=' + height + ',width=' + width + ',top='+TopPosition+',left='+LeftPosition+
                                       ',toolbar=no,directories=no,status=yes,scrollbars=yes,resizable=yes,menubar=no,location=no');
    try{
        win.focus();
    }catch(e) {}
    return win;
}
/**********************************************************************
 * Component ID : popupWindowParam
 * Input        : Name          Type                    Description
 *                ------------- ----------------------- ------------
 *                -				-						-
 * Output       : string
 * Description  : Return the param string containing the parameters
 *				  required for new popup windows.
 *                Return the param string.
 **********************************************************************
 */
function popupWindowParam(){
	var POPUP_PARAM = ",left=20,top=20,directories=0,resizable=0,status=1,toolbar=0,scrollbars=1";
	return POPUP_PARAM;
}

function removeSpecialChars(fieldName){
    var str = $F(fieldName.name);
    var paramArr = new Array("~","!","@","#","$","%","^","&","*");
    document.forms[0].elements[fieldName.name].value = formatStr(str, paramArr);
}

function formatStr(str, paramArray){
	for(var i=0; i<str.length; i++){
		var element = str.charAt(i);
		for(var j=0; j<paramArray.length; j++){
			if(element == paramArray[j]){
				str = str.replace(element, "");
				i--;
			}
		}
	}
	return str;
}

function setElementValue(elementName, value, formIndex) {
    var fi = 0;
    if(formIndex)
        fi = formIndex;
    var element = document.forms[fi].elements[elementName];
    if(element != null)
    {
        if (element.length)
        {
            if(element.type == 'select-one') {
                for(i = 0; i<element.length; i++)
                    if(element[i].value == value)
                    {
                        element[i].selected = true;
                        break;
                    }
            }
            else {
                for(i = 0; i<element.length; i++)
                    if(element[i].value == value)
                        element[i].checked = true;
                    else
                        element[i].checked = false;
            }
        }
        else if(element.type == 'checkbox' || element.type == 'radio') {
            element.checked = (element.value == value);
        }else if(element.type =="text"|| element.type =="textarea" || element.type == "hidden")
        {
            element.value = value;
        }
    }
}

function setElementDefaultValue(elementName,value,formIndex) {
    var fi = 0;
    if(formIndex)
        fi = formIndex;
    var element = document.forms[fi].elements[elementName];
    if(element != null) {
        if (element.length) {
            if(element.type == 'select-one') {
                for(var i=0; i<element.length; i++) {
                    element[i].defaultSelected = (element[i].value == value);
                }
            } else {
                for(var i=0; i<element.length; i++) {
                    element[i].defaultChecked = (element[i].value == value);
                }
            }
        } else if (element.type == 'checkbox' || element.type == 'radio') {
            element.defaultChecked = (element.value == value);
        } else if (element.type =="text"|| element.type =="textarea" || element.type == "hidden") {
            element.defaultValue = value;
        }
    }
}

function isInteger (str) {
    if (str == null || str.length == 0) {
        return true;
    }
    return validateFormat(REG_INT_NUM, str);
}

function isMoney(str) {
    var strArr, strLength;
    if (str == null || str.length == 0) {
        return true;
    }

    strArr = str.split('.');
    if (strArr.length > 0) {
        strLength = strArr[0].length;
    } else {
        strLength = str.length;
    }
    return (validateFormat(REG_2DECIMAL_NUM, str) && strLength <= CONST_MONEY_COLUMN_LENGTH);
}

function disableForm(formIndex) {
    var fi = 0;
    if(formIndex)
        fi = formIndex;
    var formLength = document.forms[fi].elements.length;
    var selectedForm = document.forms[fi];
    for (var i = 0; i < formLength ; i ++) {
    	if(selectedForm.elements[i].type != 'hidden')
	        selectedForm.elements[i].disabled = true;
    }
}

function enableForm(formIndex) {
    var fi = 0;
    if(formIndex)
        fi = formIndex;
    var formLength = document.forms[fi].elements.length;
    var selectedForm = document.forms[fi];
    for (var i = 0; i < formLength ; i ++) {
        selectedForm.elements[i].disabled = false;
    }
}

function readOnlyForm(formIndex) {
    var fi = 0;
    if(formIndex)
        fi = formIndex;
    var formLength = document.forms[fi].elements.length;
    var selectedForm = document.forms[fi];
    for (var i = 0; i < formLength ; i ++) {
        if (selectedForm.elements[i].type == 'text' || selectedForm.elements[i].type == 'textarea') {
            selectedForm.elements[i].disabled = false;
            selectedForm.elements[i].readOnly = true;
        } else if (selectedForm.elements[i].type != 'button') {
            selectedForm.elements[i].disabled = true;
        }
    }
}
function getFormElementValue(elementName,form) {
	var f = null;
	if(form)
		f = form;
	else
		f = document.forms[0];
	var element = f.elements[elementName];
    if(element != null)
    {
        if (element.length)
        {
            if(element.type == 'select-one') {
                for(i = 0; i<element.length; i++)
                    if(element[i].selected) return element[i].value;
            }
            else {
                for(i = 0; i<element.length; i++)
                    if(element[i].checked) return element[i].value;
            }
            return null;
        }
        else if(element.type == 'checkbox' || element.type == 'radio') {
            return (element.checked ? element.value : null);
        }
        else return element.value;
    }
    else return null;
}

function getElementValue(elementName,formIndex) {
    var fi = 0;
    if(formIndex)
        fi = formIndex;
    var element = document.forms[fi].elements[elementName];
    if(element != null)
    {
        if (element.length)
        {
            if(element.type == 'select-one') {
                for(i = 0; i<element.length; i++)
                    if(element[i].selected) return element[i].value;
            }
            else {
                //todo
                for(i = 0; i<element.length; i++)
                    if(element[i].checked) return element[i].value;
            }
            return null;
        }
        else if(element.type == 'checkbox' || element.type == 'radio') {
            return (element.checked ? element.value : null);
        }
        else return element.value;
    }
    else return null;
}

function getElementDefaultValue(elementName,formIndex ) {
    var fi = 0;
    if(formIndex)
        fi = formIndex;
    var element = document.forms[fi].elements[elementName];
    if (element != null) {
        if (element.length) {
            if (element.type == 'select-one') {
                for (i = 0; i < element.length; i++)
                    if (element[i].defaultSelected) return element[i].value;
            } else {
                for (i = 0; i < element.length; i++)
                    if (element[i].defaultChecked) return element[i].value;
            }
            return null;
        } else if (element.type == 'checkbox' || element.type == 'radio') {
            return (element.defaultChecked ? element.value : null);
        } else {
            return element.defaultValue;
        }
    } else {
        return null;
    }
}

function getDropdownDisplayValue(elementName,formIndex){
    var fi = 0;
    if(formIndex)
        fi = formIndex;
    var element = document.forms[fi].elements[elementName];
    if(element != null){
        if (element.length){
                for(i = 0; i<element.length; i++)
                    if(element[i].selected)
                        return element[i].text;
        }
    }
    return '';
}

function toggleElements(elements,disable,formIndex){
	for(var i=0;i<elements.length;i++) {
		toggleElementStatus(elements[i],disable,formIndex);
	}
}

/*
*modified by NCS,2008-08-06
*/
function toggleElementStatus( elementName, disable,formIndex) {
    var fi = 0;
    if(formIndex)
        fi = formIndex;
    var element = document.getElementById(elementName);
    if (element == null) {
		element=document.forms[fi].elements[elementName];
		if(element == null)
		return;
	}
    if (element.length) {
        if(element.type == 'select-one') {
           element.disabled = disable;
        } else {
            for (var i=0; i<element.length; i++) {
                element[i].disabled = disable;
            }
        }
    } else {
        element.disabled = disable;
    }
}

function showOrHideObject(dataFlag, showFlag) {
    var divObject = document.getElementById(dataFlag);
    if (divObject != null) {
        if(showFlag){
            for(var i = 0; i < divObject.all.length; i++){
                    divObject.all[i].disabled = false;
            }
            divObject.style.display = '';
        }else if(!showFlag){
            for(var i = 0; i < divObject.all.length; i++){
                divObject.all[i].disabled = true;
            }
            divObject.style.display = 'none';
        }
    }
}

function showOrHideObjectWithoutEnableDisable(dataFlag, showFlag) {
    var divObject = document.getElementById(dataFlag);
    if (divObject != null) {
        if(showFlag){
            divObject.style.display = '';
        }else if(!showFlag){
            divObject.style.display = 'none';
        }
    }
}

/**
 * show the div and enable the elements of the div
 **/
function showDiv(divName)
{
    var divObject = $(divName);
    if (divObject) {
        for(var i = 0; i < divObject.all.length; i++){
            divObject.all[i].disabled = false;
        }
        divObject.style.display = '';
    }
}
/**
 * hide the div and disable the elements of the div
 **/
function hideDiv(divName)
{
    var divObject = $(divName);
    if (divObject) {
        for(var i = 0; i < divObject.all.length; i++){
            divObject.all[i].disabled = true;
        }
        divObject.style.display = 'none';
    }
}

function showDivWithoutEnable(divName) {
  if($(divName)){
    $(divName).style.display = "";
  }
}

function hideDivWithoutDisable(divName)
{
    if($(divName)){
    $(divName).style.display = "none";
  }
}
/**********************************************************************
 * Component ID : isEmpty
 * Input        : Name          Type                    Description
 *                ------------- ----------------------- ------------
 *                string           string
 * Output       : boolean
 * Description  : To check whether a string is blank or disabled.
 *                Return true - if str is blank.
 *                       false - otherwise.
 **********************************************************************
 */
function isEmpty(field) {
	// check if field string value is blank
	if (field.disabled == true || field.value == null || trim(field.value) == ''){
		return true;
	}else{
		return false;
	}
}
/**********************************************************************
 * Component ID : isEmpty
 * Input        : Name          Type                    Description
 *                ------------- ----------------------- ------------
 *                string           string
 * Output       : boolean
 * Description  : To check whether a string is blank.
 *                Return true - if str is blank.
 *                       false - otherwise.
 **********************************************************************
 */
function isStringEmpty(string) {
	// check if field string value is blank
	if (string == null || trim(string) == ''){
		return true;
	}else{
		return false;
	}
}

function executeOnLoadCommon(fn) {
	addEvent2(window,"onload",fn);
	disableBackButton();
}

/*
  attach event to an object,usesage: addEvent2(window,"onload",function);
  modified by qusheng
*/
function addEvent2(obj, evType, fn) {
    /* adds an eventListener for browsers which support it
       Written by Scott Andrew: nice one, Scott */
    if (obj.addEventListener)
    {
    	if(obj.name == 'msg_main') //if is window onload, to change
    		document.addEventListener("DOMContentLoaded", fn, null);
    	else
        	obj.addEventListener(evType, fn, false);
    }
    else if (obj.attachEvent) {
	    var r = obj.attachEvent(evType, fn);
    }
}

/*
    parseInt,if failed,return a default value gived
    author:qusheng
*/
function parseIntDef(s,defValue) {
	var r = parseInt(s,10);
	if(typeof(defValue) == "undefined"){defValue = 0;}
	return isNaN(r)?defValue:r;
}

function parseFloatDef(s,defValue) {
	var r = parseFloat(s);
	if(typeof(defValue) == "undefined"){defValue = 0;}
	return isNaN(r)?defValue:r;
}

function executeOnLoadCommon(fn) {
	addEvent2(window,"onload",fn);
	disableBackButton();
}

function disableBackButton() {
    history.forward();
}

function checkTextAreaLen(obj, maxLength) {
	if (obj == null) {
		return;
	} else {
        //maxLength = changeMaxlength(maxLength, obj.value);
        /*
        if (obj.value.length > maxLength) {
            obj.value = obj.value.substring(0, maxLength);
        }
        */
        if (getStringLength(obj.value) > maxLength) {
            obj.value = substringb(obj.value,0, maxLength);
        }
    }
}
function getStringLength(str){
	var len=0;
	if(!isIE()){
		str=str.replaceAll('\n','\r\n');
	}
	for(var i=0;i<str.length;i++){
		len++;
		if(str.charCodeAt(i)>255){
			len+=2;
		}
	}
	return len;
}
function substringb(str,begin ,len) {
	if(!str || !len) { return ''; }
	var a = 0;
	var i = 0;
    var temp = '';
	for (i=begin;i<str.length;i++){         
		if (str.charCodeAt(i)>255){
			a+=3;
		}         
		else if(str.charAt(i)=='\n'&&!isIE()){
			a+=2;
		}
		else{
			a++;
		}
		if(a >len) {
			return temp; 
		}          
			temp += str.charAt(i);
	}
	return temp;
} 
function checkTextAreaLen2(obj, maxLength)
{
	if (obj == null)return;
    maxLength = changeMaxlength(maxLength, obj.value);
	b = obj.value.length < maxLength;
	switch (event.keyCode) {
	case 8:		//backspace
	case 9:		//tab
	case 45:	//insert
	case 36:	//home
	case 35:	//end
	case 46:	//delete
	case 37:	//left
	case 39:	//right
		b = true;
	}

	event.returnValue=b;
}

function fnOnTextAreaPaste(obj, maxLength)
{	
	
	sText = window.clipboardData.getData("Text");
	maxLength = changeMaxlength(maxLength, obj.value);

	

	if (getStringLength(obj.value)>=maxLength)
	{
		event.returnValue=false;
	}else if (getStringLength(obj.value)+getStringLength(sText)>maxLength)
	{
		l = maxLength-getStringLength(obj.value);
		if (l>0)
		{
//			sText = sText.substr(0,l);
			sText = substringb(sText,0,l);
			window.clipboardData.setData("Text",sText);
		}
	}
	/*
	if (obj.value.length>=maxLength)
	{
		event.returnValue=false;
	}else if (obj.value.length+sText.length>maxLength)
	{
		l = maxLength-obj.value.length;
		if (l>0)
		{
			//sText = sText.substr(0,l);
			window.clipboardData.setData("Text",sText);
		}
	}
	*/
	
	
}
function getElementStyleAttr(obj,attrName) {
  	try{
  		return obj.getAttribute(attrName);
  	}catch(e)
  	{
  		return obj.style.getAttribute("maxlength");
  	}
}

function addCommonEvent(obj,eventType,fn){
	if (obj.addEventListener){
    	if(obj.name == 'body') {
    		document.addEventListener("DOMContentLoaded", fn, null);
    	}else{
        	obj.addEventListener(eventType, fn, false);
    	}
    }else if (obj.attachEvent) {
	    var r = obj.attachEvent(eventType, fn);
    }
}

var limitTextAreaLength=function() {
	
	var fn = function(){
		//alert("fn");
		maxlength=parseIntDef(getElementStyleAttr(this,"maxlength"));
		checkTextAreaLen(this,maxlength);
	};
	
	var fnPaste = function(){
		//alert("fnPaste");
		maxlength=parseIntDef(getElementStyleAttr(this,"maxlength"));
		fnOnTextAreaPaste(this,maxlength);
	};
	var textareas = document.getElementsByTagName("textarea");
	for(var i=0;i<textareas.length;i++)
	{
		t = textareas[i];
        maxlength=parseIntDef(getElementStyleAttr(t,"maxlength"));
        if(maxlength>0)
		{
			if(t.addEventListener)
			{
				//alert(fn);
				//alert(fn.bind(t));
				//addCommonEvent(t,"keyup",fn);
				//addCommonEvent(t,"blur",fn);
				t.keyup = fn;
				t.blur = fn;
			}
			else
			{
				//alert(fn);
				//alert(fn.bind(t));
				t.onkeyup = fn;
				t.onpaste = fnPaste;
				//addCommonEvent(t,"onkeyup",fn);
				//addCommonEvent(t,"onpaste",fnPaste);
			}
		}
		
	}
};


function changeMaxlength(maxLength, val) {
    if (!isIE() && val != null) {
    	try{
        	return (maxLength - val.match(/\n/g).length);
        }catch(e){
        	return maxLength;
       	}
    } else {
        return maxLength;
    }
}

function focusObject(fileName)
{
    var obj = document.forms[0].elements[fileName];
    if(obj.type =="select-one") {
    	var isDisabled = obj.disabled;
    	obj.disabled = false;
      	obj.focus();
      	obj.disabled = isDisabled;
    }
    else if(obj.length >1 )
    {
        for(var i=0;i<obj.length;i++)
        {
            var isDisabled = obj[i].disabled;
    		obj[i].disabled = false;
          	obj[i].focus();
          	obj[i].disabled = isDisabled;
          	break;
        }
    }else{
        var isDisabled = obj.disabled;
    	obj.disabled = false;
        obj.focus();
        obj.disabled = isDisabled;
   	}
}
/**********************************************************************
 * Component Desc : toggle document status
 **********************************************************************
 */
var allElements = {
	linkArray : new Array(),
	inputArray : new Array(),
	selectArray : new Array(),
	textareaArray : new Array()
};
function Field(type, disabled, href, onclick){
	this.type = type;
  	this.disabled = disabled;
  	this.href = href;
  	this.onclick = onclick;
}

function initAllElementsObject(){
  	allElements.linkArray = null;
  	allElements.inputArray = null;
  	allElements.selectArray = null;
  	allElements.textareaArray = null;

  	allElements.linkArray = new Array();
  	allElements.inputArray = new Array();
  	allElements.selectArray = new Array();
  	allElements.textareaArray = new Array();
}
function getArrayByTagName(tagName){
	if(tagName == 'a')
  		return allElements.linkArray;
  	if(tagName == 'input')
  		return allElements.inputArray;
  	if(tagName == 'select')
  		return allElements.selectArray;
  	if(tagName == 'textarea')
  		return allElements.textareaArray;
}
function storeElementsStatus(){
  	initAllElementsObject();
  	storeElementStatus('a');
  	storeElementStatus('input');
  	storeElementStatus('select');
  	storeElementStatus('textarea');
}

function storeElementStatus(tagName){
	var elements = document.getElementsByTagName(tagName);
  	for(var i=0; i<elements.length; i++){
  		var fieldStatus = new Field(elements[i].type, elements[i].disabled, elements[i].href, elements[i].onclick);
  		getArrayByTagName(tagName)[getArrayByTagName(tagName).length] = fieldStatus;
  	}
}
function enableDocument(){
  	var linkElements = document.getElementsByTagName('a');
  	var inputElements = document.getElementsByTagName('input');
   	var selectElements = document.getElementsByTagName('select');
   	var textareaElements = document.getElementsByTagName('textarea');
   	for(var i=0; i<linkElements.length; i++){
  		linkElements[i].disabled = getArrayByTagName('a')[i].disabled;
  		linkElements[i].href = getArrayByTagName('a')[i].href;
  		linkElements[i].onclick = getArrayByTagName('a')[i].onclick;;
  	}
  	for(var i=0; i<inputElements.length; i++){
  		inputElements[i].disabled = getArrayByTagName('input')[i].disabled;
  	}
  	for(var i=0; i<selectElements.length; i++){
  		selectElements[i].disabled = getArrayByTagName('select')[i].disabled;
  	}
  	for(var i=0; i<textareaElements.length; i++){
  		textareaElements[i].disabled = getArrayByTagName('textarea')[i].disabled;
  	}
}
function disableDocument(){
	storeElementsStatus();

  	var linkElements = document.getElementsByTagName('a');
  	var inputElements = document.getElementsByTagName('input');
   	var selectElements = document.getElementsByTagName('select');
   	var textareaElements = document.getElementsByTagName('textarea');
  	for(var i=0; i<linkElements.length; i++){
  		linkElements[i].disabled = true;
  		linkElements[i].href = '#';
  		linkElements[i].onclick = null;
  	}
  	for(var i=0; i<inputElements.length; i++){
  		if(inputElements[i].name == 'button2')
  			continue;
  		inputElements[i].disabled = true;
  	}
  	for(var i=0; i<selectElements.length; i++){
  		selectElements[i].disabled = true;
  	}
  	for(var i=0; i<textareaElements.length; i++){
  		textareaElements[i].disabled = true;
  	}
}

/**********************************************************************
 * Component ID : checkPhoneNoLength
 * Input        : Name          Type                    Description
 *                ------------- ----------------------- ------------
 *                phNo			String					cannot be empty string
 * Output       : boolean
 * Description  : Returns true if the length of the phone number is at least 8 numbers.
 **********************************************************************
 */
function checkPhoneNoLength(phNo){
	if (phNo.length < 8)
		return false;

	return true;
}
/*********************************************************************
 	some common method for trim and upper case the field vale
**********************************************************************/
//eg: onblur="trimField(this)"
function trimField(obj)
{
    obj.value = trim(obj.value);
}
function trim(sInString)
{
    if(sInString != null)
        sInString = sInString.replace(/^\s+|\s+$/g, '');
    return sInString;
}
//eg: onblur="changeToUpperCase(this)"
function changeToUpperCase(obj)
{
   var tmpValue = obj.value;
   obj.value = tmpValue.toUpperCase();
}
function trimUpper(obj)
{
	var tmpValue = trim(obj.value);
   	obj.value = tmpValue.toUpperCase();
}
function trimAllTextBoxes()
{
	var inputElements = document.getElementsByTagName('input');
	for(var i=0; i<inputElements.length; i++)
	{
  		if(inputElements[i].type == 'text')
  			trimField(inputElements[i]);
  	}
}
function isFieldEmpty(formIndex,fieldName)
{
	var s = getElementValue(formIndex,fieldName);
	return isStringEmpty(s);
}
function isVisible(obj)
{
    var visAtt,disAtt;
    try
    {
        disAtt=obj.style.display;
        visAtt=obj.style.visibility;
    }catch(e){}
    if(disAtt=="none" || visAtt=="hidden")
        return false;
    return true;
}

function findObj(theObj, theDoc)
{
    var p, i, foundObj;
    if (!(foundObj = theDoc[theObj]) && theDoc.all)
        foundObj = theDoc.all[theObj];
    for (i = 0; !foundObj && i < theDoc.forms.length; i++)
        foundObj = theDoc.forms[i][theObj];
    for (i = 0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++)
        foundObj = findObj(theObj, theDoc.layers[i].document);
    if (!foundObj && document.getElementById)
        foundObj = document.getElementById(theObj);
    return foundObj;
}

function submitForm(form,confirmMsg) {
    var msg = prompt_com_continue;
    if(!isStringEmpty(confirmMsg))
        msg = confirmMsg;
    if(promptMsg(msg)){
        enableAllForms();
        trimTextFields(form);
        form.submit();
        disableAllForms();
    }else
    	safeLeave = false;
}

function submitFormWoMsg(form) {
    enableAllForms();
    trimTextFields(form);
    form.submit();
    disableAllForms();
}

function submitFormWoMsgWoEnable(form) {
    trimTextFields(form);
    form.submit();
}

function enableAllForms(){
	for(var i = 0; i < document.forms.length; i++){
		enableForm(i);
	}
}

function disableAllForms(){
	for(var i = 0; i < document.forms.length; i++){
		disableForm(i);
	}
}
/**
 *Remove node(s) from dropdown list.
 *elementName: dropdown element name
 *removeArray: array put codeId(s) which mapping to node(s) need to be reomved
*/
function removeNodeFromDropDown(elementName, removeArray){
    var obj = document.getElementById(elementName);

    if(obj != null && obj != 'undefined')
    for(var i = obj.length-1; i >= 0; i--)
    {
        if(arrayContainsElement(removeArray, obj.options[i].value)){
            obj.options[i].removeNode(true);
        }
    }
}

/*
  Jude a array whether contains an element that given
*/
function arrayContainsElement(arr, eleValue){
    try{
        for(var i = 0; i < arr.length; i++){
            if(eleValue == arr[i])
                return true;
        }
    }catch(e){
        return false;
    }
    return false;
}

/*
Used for adding method(s) into the onLoad method.
*/
function addLoadEvent( func ){
	var oldonload = window.onload;
	if(typeof window.onload != 'function' ){
		window.onload = func;
	}else{
		window.onload = function(){
			oldonload();
            func();
		};
	}
}

/***************************************
 * Functions for NRIC/FIN number handling  *
 ***************************************/
function validUin(strIcPassed)
{
     // The weights for computing the Check Digit for Singapore/Foreign IC.
     var sWeight = [2, 7, 6, 5, 4, 3, 2];
     // The Check Digits for Singapore IC.
     var sChkDigit = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'Z', 'J'];

     // The Check Digits for Foreign IC.
     var fChkDigit = ['K', 'L', 'M', 'N', 'P', 'Q', 'R', 'T', 'U', 'W', 'X'];

  	 // if length of IC is not 9, invalid
     if (strIcPassed.length != 9) {
         return false;
     }
     var upPassed = strIcPassed.toUpperCase();
     var icPassed = [upPassed.charAt(0),upPassed.charAt(1),upPassed.charAt(2),upPassed.charAt(3),
     		upPassed.charAt(4),upPassed.charAt(5),upPassed.charAt(6),upPassed.charAt(7),upPassed.charAt(8)];
     // if IC does not start with 'S', 'T', 'F' or 'G', invalid
     var char0 = icPassed[0];
     if(char0!='S' && char0 !='T' && char0!='F' && char0!='G')
     	  return false;
     var valid = false;
     var sum = 0;

     // add up the numeric values of the IC multiply by
     // the individual weightage for each specific position of
     // the IC number.
     for (var i = 0; i < 7; i++) {
         sum += ((icPassed[i + 1])*sWeight[i]);
     }
     if ((icPassed[0] == 'T') || (icPassed[0] == 'G')) { // DOB >= Yr 2000
         sum += 4;
     }
     sum = Math.abs(sum);
     if ( (icPassed[0] == 'S') || (icPassed[0] == 'T')) {
         valid = (sChkDigit[10-(sum % 11)] == icPassed[8]);
     }
     else { // IC starts with 'F' or 'G'
         valid = (fChkDigit[10-(sum % 11)] == icPassed[8]);
     }
     return valid;
}

function printOnClick(){
    window.print();
}

function isValidPostCode(postCode){
    var validateString=/^([0-9]{6})$/;
	return validateString.test(postCode);
}

/**********************************************************************
 * Component ID : replaceMsg
 * Input        : Name          Type                    Description
 *                ------------- ----------------------- ------------
 *                msg		    String					String
 *  			  params        String                  no limited arguments
 * Output       : replaced message string
 * Description  : The charactors like {?} are replaced with params string value, return the final message. 
 **********************************************************************
 */
function replaceMsg(msg) {
	var returnMsg = msg;
	for (var c=1; c< replaceMsg.arguments.length ;c=c+1 ) {
		if(replaceMsg.arguments[c] == undefined) break;
  		var repStr = "{" + (c-1) + "}";
  		if(returnMsg.indexOf(repStr) == -1) break;
  		returnMsg = returnMsg.replace(repStr, replaceMsg.arguments[c]);
	}
	return returnMsg;
}


function displayMsg (msg) { 
	var alertMsg = replaceMsg(msg, displayMsg.arguments[1], displayMsg.arguments[2], displayMsg.arguments[3],
      														displayMsg.arguments[4], displayMsg.arguments[5]);
	alert(alertMsg);
}


function promptMsg(msg) { 
	var alertMsg = replaceMsg(msg, promptMsg.arguments[1], promptMsg.arguments[2], promptMsg.arguments[3],
      														promptMsg.arguments[4], promptMsg.arguments[5]);
	return confirm(alertMsg);
} 

function promptForCancelBack() { 
	return confirm(prompt_com_back);
}
function promptForDelete() { 
	return confirm(prompt_com_del_prompt);
}


executeOnLoadCommon(limitTextAreaLength);

function checkAll(checkAllId,checkListId){
	var _checkAll = document.getElementById(checkAllId);	
	_checkAll.checked = true;
	
	var _checkList = document.getElementsByTagName("input");

	for(i=0;i<_checkList.length;i++){	
		if(_checkList[i].type == "checkbox" && _checkList[i].id == checkListId){
			if(_checkList[i].checked == false){
				_checkAll.checked = false;
				return;
			}
		}
	}
}
/**
var modified = false;
var safeLeave = false;

var limitFormFields=function() {

	var fn = function(){
		modified = true;
	}


	var inputFields = document.getElementsByTagName("input");
	var textAreas = document.getElementsByTagName("textarea");
	var selects = document.getElementsByTagName("select");
	bindOnchange(fn,inputFields);

	
	
}
function bindOnchange(fn,inputFields){
	for(var i=0;i<inputFields.length;i++)
	{
		t = inputFields[i];
		if(t.addEventListener)
		{
			addEvent2(t,"change",fn.bind(t));
			
		}else{
			addEvent2(t,"onchange",fn.bind(t));
		}
		
	}
}
**/
//executeOnLoadCommon(limitFormFields);

function onUnloadHandle(e){
	if(!safeLeave && modified){
		var msg = "Some records(s) have been modified, confirm to discard the changes?"; 
		 if(window.event)
            window.event.returnValue = msg;
         else
             e.returnValue = msg;
	}	
}
function trimTextFields(frm)
{
  if (frm && frm.elements && frm.elements.length)
  {
	for(i=0; i<frm.elements.length; i++)
	{
      if(frm.elements[i].type == 'text' || frm.elements[i].type == 'textarea')
  	    trimField(frm.elements[i]);
    }
  }
}

function disableCtrlKeyCombination(event, ieSpec){
	//list all CTRL + key combinations you want to disable
	var forbiddenKeys = new Array('n');//new Array('a', 'n', 'c', 'x', 'v', 'j');
	var key;
	var isCtrl;
	if(isIE()){//IE 
		if(ieSpec)
			key = event.keyCode;
		else
        	key = window.event.keyCode; 
        var flag;
        if(ieSpec)
        	flag = event.ctrlKey;
        else
        	flag = window.event.ctrlKey;
        if(flag)
			isCtrl = true;
        else
			isCtrl = false;
	} else { //firefox
		/*
		key = event.which;					 
		if(event.ctrlKey)
			isCtrl = true;
		else
			isCtrl = false;
		*/
	}
	
	//if ctrl is pressed check if other key is in forbidenKeys array
	if(isCtrl) {
		for(i=0; i<forbiddenKeys .length; i++) {
			//case-insensitive comparation
			if(forbiddenKeys[i].toLowerCase() == String.fromCharCode(key).toLowerCase()) {
				//alert('Key combination CTRL + ' + String.fromCharCode(key) + ' has been disabled.');
				return false;
			}
		}
	}
	return true;
}

function countdown(secondsLeft, countdownExecute){	
	if(secondsLeft<=0){
		countdownExecute();
	}else{
		setTimeout('countdown('+(--secondsLeft)+',' + countdownExecute + ')',1000);
	}
}
function autoRedirect(id,time,url){
	var span=document.getElementById(id);
	span.innerHTML=time;
	time--;
	if(time>=0){
		window.setTimeout("autoRedirect('"+id+"',"+time+",'"+url+"');",1000);
	}
	else{
		window.location.href=url;
	}
}

function goback(url){
	window.location.href=url;
}

function submitFormForSection1to8(form,confirmMsg) {
	var msg = prompt_com_continue;
    if(!isStringEmpty(confirmMsg))
        msg = confirmMsg;
    if(promptMsg(msg)){
        enableAllForms();
	    trimTextFields(form); 
	    upperTextFields(form);       
        form.submit();
        disableAllForms();
    }
}

//var elementNotUpperArray = new Array('applicantTO.emailAddress1','applicantTO.emailAddress2','password','confirmPsd','applicantTO.confirmEmailAddress');

function upperTextFields(frm)
{
	if(frm && frm.elements && frm.elements.length)
	{
		for(i=0; i<frm.elements.length; i++)
		{
			if(frm.elements[i].type == 'text' || frm.elements[i].type == 'textarea')
			{
				var count = 0;
				for(j=0; j<elementNotUpperArray.length; j++){
					if(frm.elements[i].name == elementNotUpperArray[j]){
						count++;
					}
				}
				if(count == 0){
					changeToUpperCase(frm.elements[i]);
				}
			}
		}
	}
}


/**
** selectAllCheckBoxes
**/
function selectAllCheckBoxes(masterId,sonIdPrefix,sonIdSuffix,formIndex){
	var masterBox = document.getElementById(masterId);
	if(masterBox!=null&&masterBox.type=='checkbox'){
		var checkedStatus = masterBox.checked;
		var formsId = 0;
		if(formIndex){
			formsId = formIndex;
		}
		var elements = document.forms[formsId].elements;
		for(var i=0;i<elements.length;i++){
			var _element = elements[i];
			if(_element.disabled==false
				&& _element.type=='checkbox'  
				&& _element.name.indexOf(sonIdPrefix)>-1 
				&& _element.name.indexOf(sonIdSuffix)>-1){
					_element.checked =checkedStatus;
				}
		}
	}
	
}

/**
** changeMasterCheckBox
**/
function changeMasterCheckBox(masterId,sonIdPrefix,sonIdSuffix,formIndex){
	var masterBox = document.getElementById(masterId);
	if(masterBox!=null&&masterBox.type=='checkbox'){			
		var fmIndex = 0;
		if(formIndex){
			fmIndex = formIndex;
		}
		
		var allChecked = true;
		
		var elements = document.forms[fmIndex].elements;
		for(var i=0;i<elements.length;i++){
			var _element = elements[i];
			if(_element.disabled==false
				&& _element.type=='checkbox'  
				&& _element.name.indexOf(sonIdPrefix)>-1 
				&& _element.name.indexOf(sonIdSuffix)>-1){
					if(_element.checked == false){
						allChecked = false;
						break;
					}
				}
		}

		masterBox.checked = allChecked;
		
	}
}

/**
** isElementChanged
**/
function isElementChanged( ele, i ) {

    var isEleChanged = false;

         //alert(ele[i].type);

         switch ( ele[i].type ) {

             case "text" :

             //alert(ele[i].value != ele[i].defaultValue );

                       if ( ele[i].value != ele[i].defaultValue ) {

                       //alert(ele[i].name);

                           return true;

                       }

                            break;

 

             case "textarea" :

            if ( ele[i].value != ele[i].defaultValue ) {

                return true;

            }

            break;

 

             case "radio" :

                       if ( ele[i].checked != ele[i].defaultChecked ) {

                           return true;

                       }

                            break;

 

             case "select-one" :

            if (ele[i].name != '') {
                //hasDefaultValue = false;

                for ( var x =0 ; x <ele[i].options.length; x++ ) {

                    if ( ele[i].options[ x ].defaultSelected ) {

                        if ( ele[i].options[ x ].selected != ele[i].options[ x ].defaultSelected ) {

                            return true;

                        }

                        //hasDefaultValue = true;

                    }

                }

                //For those default value is null

                //if ( !hasDefaultValue && ele[i].value != '' && ele[i].value != 'AM' ) {

                //    return true;

                //}

                return false;

            }

            break;

 

             case "select-multiple" :

                       for ( var x =0 ; x <ele[i].options.length; x++ ) {

                                if ( ele[i].options[ x ].selected != ele[i].options[ x ].defaultSelected ) {

                                    return true;

                                }

            }

            break;

 

             case "file" :

                       if ( ele[i].value != ele[i].defaultValue ) {

                           return true;

                       }

                       break;

                            

             case "checkbox" :

                       if ( ele[i].checked != ele[i].defaultChecked ) {

                           return true;

                       }

            break;

 

             default:

                       return false;

                 break;

    }

}



/**
** move selected item form one to another
** Add param clearSame(Y/N) to judge if there is value already existed in the to combox
**/
function moveItems(from,to,clearSame,formIndex) 
{
	var fi = 0;
    if(formIndex){
        fi = formIndex;
    }   
	if(clearSame==null||clearSame==''){
	  clearSame = 'N';
	}
	var selectFrom = document.forms[fi].elements[from];	
	var selectTo =  document.forms[fi].elements[to];
	var j=0;	 
	for (var i=0; i<selectFrom.length; i++)
	{
	   if(selectFrom.options[i].selected){
			var oOption = document.createElement("OPTION");
			oOption.text = selectFrom.options[i].text;
			oOption.value = selectFrom.options[i].value;
			if(clearSame=='Y'){
				if(!judgeSameValueExists(oOption.value,selectTo)){
					selectTo.options.add(oOption);
				}
			}else{		
				selectTo.options.add(oOption);
			}
		}
	}
	for(var i=selectFrom.length-1;i>=0;i--){
		if(selectFrom.options[i].selected)
 		selectFrom.remove(i);
	}
}

/**
**Judge same value Exists In Combox
**/
function judgeSameValueExists(val,tarCombo){
	var isexits = false;
	for (var i=0; i<tarCombo.length; i++){
		if(val==tarCombo.options[i].value){
			isexits =true;
			break;
		}
	}
	return isexits;
}

/**
** select all iemts of the multiple drop list down
**/
function selectAllItems(selectname,formIndex){
	var fi = 0;
    if(formIndex){
        fi = formIndex;
    }   
	var toselect = document.forms[fi].elements[selectname]; 
	if(toselect!=null){
		for (var i=0; i<toselect.length; i++)
		{
	      toselect.options[i].selected =true;	 
		}
	}
}

/**
** unselect all iemts of the multiple drop list down
**/
function unselectAllItems(selectname,formIndex){
	var fi = 0;
    if(formIndex){
        fi = formIndex;
    }   
	var toselect = document.forms[fi].elements[selectname]; 
	if(toselect!=null){
		for (var i=0; i<toselect.length; i++)
		{
	      toselect.options[i].selected =false;	 
		}
	}
}

/**
 * A tooltip will be shown for mouse moves over/out on a dropdown list for 
 * display selected items text
**/
function selectedOptionTextTip(obj){
	if(obj != null && obj.options != null && obj.options.length > 0){
		AzTip(obj.options[obj.selectedIndex].innerText);
	}
}

function checkExistsElement(elementPrefix,elementSuffix,formIndex){
	var _formIndex = 0;
	if(formIndex){
		_formIndex=formIndex;
	}
	var _elements = document.forms[_formIndex].elements;
	for(var i=0;i<_elements.length;i++){
		var _element = _elements[i];
		if(_element.id.indexOf(elementPrefix) == 0 &&
				_element.id.indexOf(elementSuffix) == (_element.id.length-elementSuffix.length)){
			return true;
		}
	}
	return false;
}

function checkSelected(elementPrefix,elementSuffix,formIndex){
	var _formIndex = 0;
	if(formIndex){
		_formIndex=formIndex;
	}
	var _elements = document.forms[_formIndex].elements;
	for(var i=0;i<_elements.length;i++){
		var _element = _elements[i];
		if(_element.id.indexOf(elementPrefix) == 0 &&
				_element.id.indexOf(elementSuffix) == (_element.id.length-elementSuffix.length)){
			if(_element.type == 'checkbox'){
				if(_element.checked){
					return true;
				}
			}
		}
	}
	return false;
}

function selecedAllCheckbox(controlElement,elementPrefix,elementSuffix,formIndex){
	if(!controlElement ||
			!controlElement.type ||
			controlElement.type!='checkbox'){
		return;
	}
	var _checked = controlElement.checked;
	var _formIndex = 0;
	if(formIndex){
		_formIndex=formIndex;
	}
	var _elements = document.forms[_formIndex].elements;
	for(var i=0;i<_elements.length;i++){
		var _element = _elements[i];
		if(_element.id.indexOf(elementPrefix) == 0 &&
				_element.id.indexOf(elementSuffix) == (_element.id.length-elementSuffix.length)){
			if(_element.type == 'checkbox'){
				_element.checked = _checked;
			}
		}
	}
}
