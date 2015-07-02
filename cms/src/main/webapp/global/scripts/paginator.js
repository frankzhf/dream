function gotoPage(pageNumber){
	document.getElementById('paginatorData.currentPage').value = pageNumber;
	$.submitFormWoMsg();
}

function orderPage(index){
	var _e = document.getElementById("paginatorData.orderBy["+index+"].booleanString(asc)");
	var _value = _e.value;
	if(_value == null || _value == ''){
		_value = 'true';
	}else if(_value == 'true'){
		_value = 'false';
	}else if(_value == 'false'){
		_value = '';
	}
	_e.value=_value;
	$.submitFormWoMsg();
}