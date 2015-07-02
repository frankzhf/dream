var vld = new Object();

vld.ERR_TYPES = ["Mandatory","Number","Decimal","Email","Phone","Date",
			"Time","Money","Year","Others"];
vld.AGR_EXP = /\{0\}/;
vld.ERR_MSGS = new Array();
vld.ERR_MSGS["Mandatory"] = "Mandatory Field: {0}";
vld.ERR_MSGS["Number"] = "Invalid Number Format: {0}";
vld.ERR_MSGS["Decimal"] = "Invalid Number Decimal: {0}";
vld.ERR_MSGS["Email"] = "Invalid Email Format: {0}";
vld.ERR_MSGS["Phone"] = "Invalid Phone No Format: {0}";
vld.ERR_MSGS["Mobile"] = 'Invalid Mobile Format: {0}" />';	
vld.ERR_MSGS["Date"] = "Date Format is Invalid: {0}. Please ensure date entered is in the following format: DD/MM/YYYY";
vld.ERR_MSGS["Money"] = "Invalid Money Format: {0}";
vld.ERR_MSGS["Year"] = "Invalid Number Format: {0}";
vld.ERR_MSGS["24Time"] = "Time Format is Invalid: {0}. Please ensure time entered is in the following format: HH:MM";
vld.ERR_MSGS["12Time"] = "Invalid Time Format: {0}. For time format, enter hh:mm";
vld.ERR_MSGS["Others"] = "{0}";

vld.VldObj = function(fieldName,labelCtx,errorType,validFunc,pars,pars1,pars2,pars3)
{
	this.fieldName = fieldName;
	this.labelCtx = labelCtx;
	this.errorType = errorType;
	this.validFunc = validFunc;
	this.pars = pars;
	this.pars1 = pars1;
	this.pars2 = pars2;
	this.pars3 = pars3;
}
vld.ErrObj = function(fieldName,labelCtx,errorType)
{
	this.fieldName = fieldName;
	this.labelCtx = labelCtx;
	this.errorType = errorType;
}
vld.Validation = function()
{
	this.vldArray = new Array();
    this.errArray = new Array();
}

/*
*modified by NCS,2008-08-06
*/
vld.Validation.prototype = 
{
	performValidation:function(errorType)
	{
		this.resetErrorArray();
		if(errorType.length && /*errorType[0]*/(errorType[0]&& typeof errorType!="string"))
		{	
			for(var i=0;i<errorType.length;i++)
				this.validate(errorType[i],true);
		}	
		else
			this.validate(errorType);
		var errMsg = this.toErrorString(errorType);
	  	return this.alertErrMsg(errMsg,errorType);
	},
	addValidObj:function(fieldName,labelCtx,errorType,validFunc,pars,pars1,pars2,pars3)
	{
		this.vldArray[this.vldArray.length] = new vld.VldObj(fieldName,labelCtx,errorType,validFunc,pars,pars1,pars2,pars3);
	},
	validate:function(errorType,ignoreResetErrorArray)
	{
		if(ignoreResetErrorArray != true)
			this.resetErrorArray();
		for(var i=0; i<this.vldArray.length;i++)
		{
			var obj = this.vldArray[i];
			if(this.isErrTypeMatches(obj,errorType))
			{
				var isTrue = obj.validFunc.call(obj.validFunc,obj.fieldName,obj.pars,obj.pars1,obj.pars2,obj.pars3);
				if(!isTrue) 
				{
					this.appendErrorObj(obj);
				}
			}
		}
	},
	isErrTypeMatches:function(obj,errorType)
	{
		var boo = false;
		if(errorType.length && /*errorType[0]*/(errorType[0]&& typeof errorType!="string"))
		{
			for(var i=0;i<errorType.length;i++)
			{
				if(errorType[i] == obj.errorType)
					boo = true;
			}
		}else
		    boo = (isStringEmpty(errorType) || errorType == "undefined" || errorType.toLowerCase() == "all") || errorType == obj.errorType;
		return boo;
	},
	appendErrorObj:function(obj)
	{
		this.errArray[this.errArray.length] = new vld.ErrObj(obj.fieldName,obj.labelCtx,obj.errorType);
	},
	resetErrorArray:function()
	{
		this.errArray.length = 0;
	},
	focusErrObject:function(errorType)
	{
		for(var i=0; i<this.errArray.length;i++)
		{	
			var error = this.errArray[i];
			if(this.isErrTypeMatches(error,errorType))
			{
				try{
					focusObject(error.fieldName);
				}catch(e){}
				return;
			}
		}
	},
	toErrorString:function(errorType)
	{	
		var errMsg = "";
		for(var i=0; i<this.errArray.length;i++)
		{	
			var error = this.errArray[i];
			if(this.isErrTypeMatches(error,errorType))
			{
				errMsg += (errMsg==""?"":"\n") + vld.ERR_MSGS[error.errorType].replace(vld.AGR_EXP,error.labelCtx);
			}
		}
		return errMsg;
	},
	alertErrMsg:function (errMsg,errorType)
	{
		if(errMsg.length > 0)
	  	{
	  		alert(errMsg);
	  		this.focusErrObject(errorType);
	  		return false;
	  	}else
	  		return true;
	}
}
//some common checkers, you can define your own checker.
vld.ComCheckers = function(){}
vld.ComCheckers.checkMandatory=function(fieldName,param)
{
    var fi = 0;
    if (param)
        fi = param;
	if(isFieldEmpty(fieldName, fi))
	{
		return false;
	}else
		return true
}
vld.ComCheckers.checkDecimalFormat = function(fieldName,bitNumber,param){
    var bit =2;
    if (bitNumber)
    	bit = bitNumber;
    var fi = 0;
    if (param)
        fi = param;
    var regExpStr = "^([0]|[1-9]\\d*)(\\.\\d{1,##bitNumber##})?$";
    regExpStr = regExpStr.replace("##bitNumber##",bit);
    if(fieldName== null || fieldName==''){
    	return true;
    }
    var fieldValue = getElementValue(fieldName,fi);
    if(fieldValue== null || fieldValue==''){
    	return true;
    }
    var regExp = new RegExp(regExpStr);
    return regExp.test(fieldValue);
}

vld.ComCheckers.checkDecimalFormat2 = function(fieldName,intNumber,bitNumber,param){
    var bit =2;
    if (bitNumber)
    	bit = bitNumber;
    var number = 6;
    if(intNumber){
    	number = intNumber-1
    }
    var fi = 0;
    if (param)
        fi = param;
    var regExpStr = "^([0]|[1-9]\\d{0,##intNumber##})(\\.\\d{1,##bitNumber##})?$";
    regExpStr = regExpStr.replace("##intNumber##",number);
    regExpStr = regExpStr.replace("##bitNumber##",bit);
    if(fieldName== null || fieldName==''){
    	return true;
    }
    var fieldValue = getElementValue(fieldName,fi);
    if(fieldValue== null || fieldValue==''){
    	return true;
    }
    var regExp = new RegExp(regExpStr);
    return regExp.test(fieldValue);
}
vld.ComCheckers.checkDecimalFormat3 = function(fieldName,bitNumber,param){
    var bit =2;
    if (bitNumber)
    	bit = bitNumber;
    var fi = 0;
    if (param)
        fi = param;
    var regExpStr = "^\-?([0]|[1-9]\\d*)(\\.\\d{1,##bitNumber##})?$";
    regExpStr = regExpStr.replace("##bitNumber##",bit);
    if(fieldName== null || fieldName==''){
    	return true;
    }
    var fieldValue = getElementValue(fieldName,fi);
    if(fieldValue== null || fieldValue==''){
    	return true;
    }
    var regExp = new RegExp(regExpStr);
    return regExp.test(fieldValue);
}

vld.ComCheckers.checkNumberFormat = function(fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
	var fieldValue = getElementValue(fieldName,fi);
	if(!isStringEmpty(fieldValue) && !validateFormat(NATURE_NUM,fieldValue))
	{
		return false;
	}else
		return true;
}
//validate for number >= 0, msg type can use 'Number'
vld.ComCheckers.checkPosotiveNumberFormat = function(fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
	var v = getElementValue(fieldName,fi);
	if(!isStringEmpty(v) && !validateFormat(POSITIVE_NUM_WITH_ZERO,v))
	{
		return false;
	}else{
		return true;
	}
}
//validate for numeric string which can start with 0 (eg.postal code),msg type can use 'Number'
vld.ComCheckers.checkNumericStringFormat = function(fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
	var v = getElementValue(fieldName,fi);
	if(!isStringEmpty(v) && !validateFormat(ALL_NUM,v))
	{
		return false;
	}else{
		return true;
	}
}
vld.ComCheckers.checkPhoneFormat=function(fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
	var v = getElementValue(fieldName,fi);
	if(!isStringEmpty(v) && !validateFormat(REG_8_12_DIGITS_NUM,v))
	{
		return false;
	}else
		return true;
}
vld.ComCheckers.checkEmailFormat = function(fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
	var v = getElementValue(fieldName,fi);
	if(!isStringEmpty(v) && !validateFormat(REG_EMAIL,v))
	{
		return false;
	}else
		return true;
}

var MUL_REG_EMAIL = /^([a-zA-Z0-9_\-])([a-zA-Z0-9_\-\.]*)@(\[((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\.){3}|((([a-zA-Z0-9\-]+)\.)+))([a-zA-Z]{2,}|(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\])((;([a-zA-Z0-9_\-])([a-zA-Z0-9_\-\.]*)@(\[((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\.){3}|((([a-zA-Z0-9\-]+)\.)+))([a-zA-Z]{2,}|(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\]))*)$/;
vld.ComCheckers.checkMultiEmailFormat = function(fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
    var v = getElementValue(fieldName,fi);
	if(!isStringEmpty(v) && !validateFormat(MUL_REG_EMAIL,v))
	{
		return false;
	}else
		return true;
}

vld.ComCheckers.checkDateFormat = function(fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
	var v = getElementValue(fieldName,fi);
	if(!isStringEmpty(v) && !validateFormat(REG_DATE_STRICT,v))
	{
		return false;
	}else
		return true;
}
vld.ComCheckers.checkMoneyFormat =function (fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
	var v = getElementValue(fieldName,fi);
	if(!isStringEmpty(v) && !isMoney(v))
	{
		return false;
	}else
		return true;
}
vld.ComCheckers.checkMandatoryWhenVisible=function(fieldName,paramDiv)
{
	var divObj = $(paramDiv);
	if(isVisible(divObj))
	{
		return !isStringEmpty($F(fieldName));
	}else return true;	
}
vld.ComCheckers.checkPosotiveFormat = function(fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
	var v = getElementValue(fieldName,fi);
	if(!isStringEmpty(v) && !validateFormat(REG_POSITIVE,v))
	{
		return false;
	}else
		return true;
}
vld.ComCheckers.check24TimeFormat = function(fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
	var v = getElementValue(fieldName,fi);
	if(!isStringEmpty(v) && !is24HourTime(v))
	{
		return false;
	}else
		return true;
}
vld.ComCheckers.check12TimeFormat = function(fieldName,param)
{
	var fi = 0;
    if (param)
        fi = param;
	var v = getElementValue(fieldName,fi);
	if(!isStringEmpty(v) && !is12HourTime(v))
	{
		return false;
	}else
		return true;
}
var VCC = vld.ComCheckers;

function checkPostalCodeFormart(num){
	var number = getElementValue(num);
	if(validateFormat(ALL_NUM, number)){
		return true;
	}
	return false;
}

function checkTelephoneNoFormat(couCode, arCode, num){
	var countryCode = getElementValue(couCode);
	var areaCode = getElementValue(arCode);
	var number = getElementValue(num);
	if((validateFormat(ALL_NUM, countryCode))
		&& (validateFormat(ALL_NUM, areaCode))
		&& (validateFormat(ALL_NUM, number))){
		return true;
	}
	return false;
}

function checkPhoneFormat(num){
	var number = getElementValue(num);
	if(validateFormat(ALL_NUM, number)){
		return true;
	}
	return false;
}
