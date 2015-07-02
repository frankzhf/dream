//get current date in dd/mm/yyyy format
function getCurrentDate() {
    var sysdate = new Date();
    var day = sysdate.getDate();
    var month = sysdate.getMonth() + 1;
    day = (day > 9)? day: '0' + day;
    month = (month > 9)? month: '0' + month;
    return day + '/' + month + '/' + sysdate.getFullYear();
}
//get current date in dd/mm/yyyy HHMM
function getCurrentDateTime(){
    var sysdate = new Date();
    var year = new String(sysdate.getFullYear());
    var month = new String(sysdate.getMonth()+1);
    var date = new String(sysdate.getDate());
    var hour=new String(sysdate.getHours());
    var minute=new String(sysdate.getMinutes());
    if(date.length < 2) {
        date = '0'+date;
    }
    if(month.length < 2) {
        month = '0'+month;
    }
    if(hour.length < 2) {
        hour = '0'+hour;
    }
    if(minute.length < 2) {
        minute = '0'+minute;
    }
    return date+'/'+month+'/'+year + ' ' + hour + minute;
}
//get current date in dd/mm/yyyy hh:mm
function getCurrentDateTime1(){
	var sysdate = new Date();
    var year = new String(sysdate.getFullYear());
    var month = new String(sysdate.getMonth()+1);
    var date = new String(sysdate.getDate());
    var hour=new String(sysdate.getHours());
    var minute=new String(sysdate.getMinutes());
    if(date.length < 2) {
        date = '0'+date;
    }
    if(month.length < 2) {
        month = '0'+month;
    }
    if(hour.length < 2) {
        hour = '0'+hour;
    }
    if(minute.length < 2) {
        minute = '0'+minute;
    }
    return date+'/'+month+'/'+year + ' ' + hour + ':' + minute;
}

//validate whether the input str is valid date
function isDate(str) {
    if (str == null || str.length == 0) {
        return true;
    }
    return validateFormat(REG_DATE_STRICT, str);
}

function is12HourTime (str) {
    if (str == null || str.length == 0) {
        return true;
    }
    return validateFormat(TWELVE_HOUR_TIME, str);
}

function is24HourTime(str) {
	if (str == null || str.length == 0) {
        return true;
    }
    return validateFormat(REG_TWENTY_FOUR_HOUR_TIME,str);
}

function isDateTime(str) {
    if (str == null || str.length == 0) {
        return true;
    }
    return validateFormat(REG_FULL_DATE_TIME, str);
}

function getAge(dateValue)
{
	var sysdate = new Date();
	var sysYear = sysdate.getFullYear();
	var year = dateValue.substring(6,10);
	return sysYear - year;
}
/* compare two date in dd/mm/yyyy
1: value1 > value2
0: value1 = value2 or one of them is empty
-1: value1 < value2
*/
function compareDate(value1, value2){
    var date1, date2;
    var month1, month2;
    var year1, year2;

    if (value1 == '' && value2 == '')
        return 0;

    date1 = value1.substring(0,2);
    month1 = value1.substring(3,5);
    year1 = value1.substring(6,10);
    date2 = value2.substring(0,2);
    month2 = value2.substring(3,5);
    year2 = value2.substring(6,10);

    if (year1 > year2) {
        return 1;
    } else if (year1 < year2) {
        return -1;
    } else if (month1 > month2) {
        return 1;
    } else if (month1 < month2) {
        return -1;
    } else if (date1 > date2) {
        return 1;
    } else if (date1 < date2) {
        return -1;
    } else {
        return 0;
    }
}

/* compare two time in HHXMM or HH:MM or HH.MM etc.
1: value1 > value2
0: value1 = value2 or one of them is empty
-1: value1 < value2
*/
function compareTime(value1, value2){
	if (value1 == '' && value2 == '')
        return 0;
    var hh1 = value1.substring(0,2);
    var hh2 = value2.substring(0,2);
    var mm1 = value1.substring(3,5);
    var mm2 = value2.substring(3,5);
    if(hh1 > hh2)
    	return 1;
    else if(hh1 < hh2)
    	return -1;
    else if(mm1 > mm2)
    	return 1;
    else if(mm1 < mm2)
    	return -1;
    else
    	return 0;
}
/* compare two time in HHMM
1: value1 > value2
0: value1 = value2 or one of them is empty
-1: value1 < value2
*/
function compareTimeWithFormatHHMM(value1, value2){
	if (value1 == '' && value2 == '')
        return 0;
    var hh1 = value1.substring(0,2);
    var hh2 = value2.substring(0,2);
    var mm1 = value1.substring(2,4);
    var mm2 = value2.substring(2,4);
    if(hh1 > hh2)
    	return 1;
    else if(hh1 < hh2)
    	return -1;
    else if(mm1 > mm2)
    	return 1;
    else if(mm1 < mm2)
    	return -1;
    else
    	return 0;
}

/* compare two date in dd/mm/yyyy HHXMM or dd/mm/yyyy HH:MM or dd/mm/yyyy HH.MM etc.
1: value1 > value2
0: value1 = value2 or one of them is empty
-1: value1 < value2
*/
function compareDateTime(value1, value2){
	if (value1 == '' && value2 == '')
        return 0;
	var dateValue1 = value1.substring(0,10);
	var dateValue2 = value2.substring(0,10);
	var result = compareDate(value1, value2);
	if(result!= 0)
		return result;
	var time1 = value1.substring(11,15);
	var time2 = value2.substring(11,15);
	return compareTime(time1, time2);	   
}

/* compare two date in dd/mm/yyyy HHMM
1: value1 > value2
0: value1 = value2 or one of them is empty
-1: value1 < value2
*/
function compareDateTimeWithTimeFormatHHMM(value1, value2){
	if (value1 == '' && value2 == '')
        return 0;
	var dateValue1 = value1.substring(0,10);
	var dateValue2 = value2.substring(0,10);
	var result = compareDate(value1, value2);
	if(result!= 0)
		return result;
	var time1 = value1.substring(11,15);
	var time2 = value2.substring(11,15);
	return compareTimeWithFormatHHMM(time1, time2);	   
}

/*return interval days between two dates in dd/mm/yyyy: date2 - date1*/
function daysBetween2Dates(date1, date2){
    if (date1 != "" && date2 != "") {
        day1 = date1.substring(0,2);
        month1 = date1.substring(3,5);
        year1 = date1.substring(6,10);
        day2 = date2.substring(0,2);
        month2 = date2.substring(3,5);
        year2 = date2.substring(6,10);
        milliSecPerDay = 86400000;
        diff = (new Date(year2, month2-1, day2, 00, 00, 00).getTime() - new Date(year1, month1-1, day1, 00, 00, 00).getTime())/milliSecPerDay;
        return diff;
    }
}   
/*return interval days between two dates in dd/mm/yyyy HHMM: date2 - date1*/
function daysBetween2DatesWithTime(dateTime1,dateTime2){
    if (dateTime1 != "" && dateTime2 != "") {
	        day1 = dateTime1.substring(0,2);
	        month1 = dateTime1.substring(3,5);
	        year1 = dateTime1.substring(6,10);
	        hour1 = dateTime1.substring(11,13);
	        minute1 = dateTime1.substring(13,15);
	        day2 = dateTime2.substring(0,2);
	        month2 = dateTime2.substring(3,5);
	        year2 = dateTime2.substring(6,10);
	        hour2 = dateTime2.substring(11,13);
	        minute2 = dateTime2.substring(13,15);
	        milliSecPerDay = 86400000;
	        diff = (new Date(year2, month2-1, day2, hour2, minute2, 00).getTime() - new Date(year1, month1-1, day1, hour1, minute1, 00).getTime())/milliSecPerDay;
	        return diff;
    	}
	}