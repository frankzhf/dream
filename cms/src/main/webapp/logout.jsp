<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>

<script>
if($.browser.msie){
	if($.browser.version>=7){
		window.open('','_self','');
	}else{
		window.opener = null;
	}
}else{
	window.opener = '';	
}
window.close();
</script>