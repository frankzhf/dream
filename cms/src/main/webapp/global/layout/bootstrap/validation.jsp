<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<script type="text/javascript">
	var vld = new Object();
	vld.ERR_TYPES = [ "Mandatory", "Number", "Decimal", "Email", "Phone", "Mobile",
			"Date", "Time", "Money", "Year", "Others" ];
	vld.AGR_EXP = /\{0\}/;
	vld.ERR_MSGS = new Array();
	
	vld.ERR_MSGS["Mandatory"] = '<bean:message key="common.validator.error.message.mandatory" />';
	vld.ERR_MSGS["Number"] = '<bean:message key="common.validator.error.message.number" />';
	vld.ERR_MSGS["Decimal"] = '<bean:message key="common.validator.error.message.decimal" />';
	vld.ERR_MSGS["Email"] = '<bean:message key="common.validator.error.message.email" />';
	vld.ERR_MSGS["Phone"] = '<bean:message key="common.validator.error.message.phone" />';
	vld.ERR_MSGS["Mobile"] = '<bean:message key="common.validator.error.message.mobile" />';	
	vld.ERR_MSGS["Date"] = '<bean:message key="common.validator.error.message.date" />';
	vld.ERR_MSGS["Money"] = '<bean:message key="common.validator.error.message.money" />';
	vld.ERR_MSGS["Year"] = '<bean:message key="common.validator.error.message.year" />';
	vld.ERR_MSGS["24Time"] = '<bean:message key="common.validator.error.message.time.12" />';
	vld.ERR_MSGS["12Time"] = '<bean:message key="common.validator.error.message.time.24" />';
	vld.ERR_MSGS["Others"] = '<bean:message key="common.validator.error.message.others" />';
	
	vld.VldObj = function(fieldName, labelCtx, errorType, validFunc, pars,
			pars1, pars2, pars3) {
		this.fieldName = fieldName;
		this.labelCtx = labelCtx;
		this.errorType = errorType;
		this.validFunc = validFunc;
		this.pars = pars;
		this.pars1 = pars1;
		this.pars2 = pars2;
		this.pars3 = pars3;
	}
	vld.ErrObj = function(fieldName, labelCtx, errorType) {
		this.fieldName = fieldName;
		this.labelCtx = labelCtx;
		this.errorType = errorType;
	}
	vld.Validation = function() {
		this.vldArray = new Array();
		this.errArray = new Array();
	}

	vld.Validation.prototype = {
		performValidation : function(errorType) {
			this.resetErrorArray();
			if (errorType.length
					&& /*errorType[0]*/(errorType[0] && typeof errorType != "string")) {
				for ( var i = 0; i < errorType.length; i++)
					this.validate(errorType[i], true);
			} else
				this.validate(errorType);
			var errMsg = this.toErrorString(errorType);
			return this.alertErrMsg(errMsg, errorType);
		},
		addValidObj : function(fieldName, labelCtx, errorType, validFunc, pars,
				pars1, pars2, pars3) {
			this.vldArray[this.vldArray.length] = new vld.VldObj(fieldName,
					labelCtx, errorType, validFunc, pars, pars1, pars2, pars3);
		},
		validate : function(errorType, ignoreResetErrorArray) {
			if (ignoreResetErrorArray != true)
				this.resetErrorArray();
			for ( var i = 0; i < this.vldArray.length; i++) {
				var obj = this.vldArray[i];
				if (this.isErrTypeMatches(obj, errorType)) {
					var isTrue = obj.validFunc.call(obj.validFunc,
							obj.fieldName, obj.pars, obj.pars1, obj.pars2,
							obj.pars3);
					if (!isTrue) {
						this.appendErrorObj(obj);
					}
				}
			}
		},
		isErrTypeMatches : function(obj, errorType) {
			var boo = false;
			if (errorType.length
					&& /*errorType[0]*/(errorType[0] && typeof errorType != "string")) {
				for ( var i = 0; i < errorType.length; i++) {
					if (errorType[i] == obj.errorType)
						boo = true;
				}
			} else
				boo = (isStringEmpty(errorType) || errorType == "undefined" || errorType
						.toLowerCase() == "all")
						|| errorType == obj.errorType;
			return boo;
		},
		appendErrorObj : function(obj) {
			this.errArray[this.errArray.length] = new vld.ErrObj(obj.fieldName,
					obj.labelCtx, obj.errorType);
		},
		resetErrorArray : function() {
			this.errArray.length = 0;
		},
		focusErrObject : function(errorType) {
			for ( var i = 0; i < this.errArray.length; i++) {
				var error = this.errArray[i];
				if (this.isErrTypeMatches(error, errorType)) {
					try {
						focusObject(error.fieldName);
					} catch (e) {
					}
					return;
				}
			}
		},
		toErrorString : function(errorType) {
			var errMsg = "";
			for ( var i = 0; i < this.errArray.length; i++) {
				var error = this.errArray[i];
				if (this.isErrTypeMatches(error, errorType)) {
					errMsg += (errMsg == "" ? "" : "<br>")
							+ vld.ERR_MSGS[error.errorType].replace(
									vld.AGR_EXP, error.labelCtx);
				}
			}
			return errMsg;
		},
		alertErrMsg : function(errMsg, errorType) {
			if (errMsg.length > 0) {
				$("#msg").addClass("alert alert-error");
        		$('#msg').html(errMsg);
        		$('#msg').show();
        		removeMask();
				this.focusErrObject(errorType);
				return false;
			} else
				return true;
		}
	}

	//some common checkers, you can define your own checker.
	vld.ComCheckers = function() {
	}
	vld.ComCheckers.checkMandatory = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		if (isFieldEmpty(fieldName, fi)) {
			return false;
		} else
			return true
	}
	vld.ComCheckers.checkDecimalFormat = function(fieldName, bitNumber, param) {
		var bit = 2;
		if (bitNumber)
			bit = bitNumber;
		var fi = 0;
		if (param)
			fi = param;
		var regExpStr = "^([0]|[1-9]\\d*)(\\.\\d{1,##bitNumber##})?$";
		regExpStr = regExpStr.replace("##bitNumber##", bit);
		if (fieldName == null || fieldName == '') {
			return true;
		}
		var fieldValue = $("#"+fieldName).val();
		if (fieldValue == null || fieldValue == '') {
			return true;
		}
		var regExp = new RegExp(regExpStr);
		return regExp.test(fieldValue);
	}

	vld.ComCheckers.checkDecimalFormat2 = function(fieldName, intNumber,
			bitNumber, param) {
		var bit = 2;
		if (bitNumber)
			bit = bitNumber;
		var number = 6;
		if (intNumber) {
			number = intNumber - 1
		}
		var fi = 0;
		if (param)
			fi = param;
		var regExpStr = "^([0]|[1-9]\\d{0,##intNumber##})(\\.\\d{1,##bitNumber##})?$";
		regExpStr = regExpStr.replace("##intNumber##", number);
		regExpStr = regExpStr.replace("##bitNumber##", bit);
		if (fieldName == null || fieldName == '') {
			return true;
		}
		var fieldValue = $("#"+fieldName).val();
		if (fieldValue == null || fieldValue == '') {
			return true;
		}
		var regExp = new RegExp(regExpStr);
		return regExp.test(fieldValue);
	}
	vld.ComCheckers.checkDecimalFormat3 = function(fieldName, bitNumber, param) {
		var bit = 2;
		if (bitNumber)
			bit = bitNumber;
		var fi = 0;
		if (param)
			fi = param;
		var regExpStr = "^\-?([0]|[1-9]\\d*)(\\.\\d{1,##bitNumber##})?$";
		regExpStr = regExpStr.replace("##bitNumber##", bit);
		if (fieldName == null || fieldName == '') {
			return true;
		}
		var fieldValue = $("#"+fieldName).val();
		if (fieldValue == null || fieldValue == '') {
			return true;
		}
		var regExp = new RegExp(regExpStr);
		return regExp.test(fieldValue);
	}

	vld.ComCheckers.checkNumberFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var fieldValue = $("#"+fieldName).val();
		if (!isStringEmpty(fieldValue)
				&& !validateFormat(NATURE_NUM, fieldValue)) {
			return false;
		} else
			return true;
	}
	//validate for number >= 0, msg type can use 'Number'
	vld.ComCheckers.checkPosotiveNumberFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !validateFormat(POSITIVE_NUM_WITH_ZERO, v)) {
			return false;
		} else {
			return true;
		}
	}
	//validate for numeric string which can start with 0 (eg.postal code),msg type can use 'Number'
	vld.ComCheckers.checkNumericStringFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !validateFormat(ALL_NUM, v)) {
			return false;
		} else {
			return true;
		}
	}
	vld.ComCheckers.checkPhoneFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !validateFormat(REG_8_12_DIGITS_NUM, v)) {
			return false;
		} else
			return true;
	}
	vld.ComCheckers.checkMobileFormat = function(fieldName,param){
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !validateFormat(REG_MOBILE, v)) {
			return false;
		} else
			return true;
	}
	
	vld.ComCheckers.checkEmailFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !validateFormat(REG_EMAIL, v)) {
			return false;
		} else
			return true;
	}

	vld.ComCheckers.checkMultiEmailFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !validateFormat(MUL_REG_EMAIL, v)) {
			return false;
		} else
			return true;
	}

	vld.ComCheckers.checkDateFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !validateFormat(REG_DATE_STRICT, v)) {
			return false;
		} else
			return true;
	}
	vld.ComCheckers.checkMoneyFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !isMoney(v)) {
			return false;
		} else
			return true;
	}
	/***
	vld.ComCheckers.checkMandatoryWhenVisible = function(fieldName, paramDiv) {
		var divObj = $(paramDiv);
		if (isVisible(divObj)) {
			return !isStringEmpty($F(fieldName));
		} else
			return true;
	}
	***/
	vld.ComCheckers.checkPosotiveFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !validateFormat(REG_POSITIVE, v)) {
			return false;
		} else
			return true;
	}
	/***
	vld.ComCheckers.check24TimeFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !is24HourTime(v)) {
			return false;
		} else
			return true;
	}
	vld.ComCheckers.check12TimeFormat = function(fieldName, param) {
		var fi = 0;
		if (param)
			fi = param;
		var v = $("#"+fieldName).val();
		if (!isStringEmpty(v) && !is12HourTime(v)) {
			return false;
		} else
			return true;
	}
	**/
	var VCC = vld.ComCheckers;
	
	
	function validateFormat(regExp,value){
	    if(value != null && value != ''){
	        return regExp.test(value);
	    }else{
	        return true;
	    }
	}
	
	function trim(sInString){
	    if(sInString != null)
	        sInString = sInString.replace(/^\s+|\s+$/g, '');
	    return sInString;
	}
	function isStringEmpty(string) {
		if (string == null || trim(string) == ''){
			return true;
		}else{
			return false;
		}
	}
	function isFieldEmpty(fieldName,fi){
		var s = $("#"+fieldName).val();
		return isStringEmpty(s);
	}
	
	
	
	//create obj
	var GLOBAL_NULL = '';
	var REG_NATURAL_NUM = /^[1-9]\d*$/;
	var REG_INT_NUM = /^-?\d+$/;
	var REG_NUM = /^\-?\d+(.\d+)?$/;
	var REG_2DECIMAL_NUM = /^\d+(\.\d{1,2})?$/;
	var REG_1DECIMAL_NUM = /^\d+(\.\d{1})?$/;
	var REG_8_12_DIGITS_NUM = /^\d{11}$/;
	var REG_MOBILE = /^((13[0-9])|(15[0-9])|(18[0-9]))\d{8}$/;
	var REG_EMAIL = /^([a-zA-Z0-9_\-])([a-zA-Z0-9_\-\.]*)@(\[((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\.){3}|((([a-zA-Z0-9\-]+)\.)+))([a-zA-Z]{2,}|(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\])$/;
	var MUL_REG_EMAIL = /^([a-zA-Z0-9_\-])([a-zA-Z0-9_\-\.]*)@(\[((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\.){3}|((([a-zA-Z0-9\-]+)\.)+))([a-zA-Z]{2,}|(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\])((;([a-zA-Z0-9_\-])([a-zA-Z0-9_\-\.]*)@(\[((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\.){3}|((([a-zA-Z0-9\-]+)\.)+))([a-zA-Z]{2,}|(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\]))*)$/;
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
</script>