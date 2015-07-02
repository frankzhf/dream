<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<html:html>
	
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/global/css/global.css" />
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/global/scripts/jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/global/scripts/jquery/themes/icon.css">
	<script type="text/javascript">
		var WEB_ROOT = '${pageContext.request.contextPath}';
	</script>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/global/scripts/dialog.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/global/scripts/jquery-common.js"></script>
	<script>
	function saveContent(){
		if($.validationForm('form[name=cmsForm] input[type!=hidden]')){
			document.forms[0].action = "${pageContext.request.contextPath}/saveContent.do";
			$.submitFormWoMsg();
		}
	}
	
	function cancel(){
		//alert("not implements.");
		document.forms[0].action = "${pageContext.request.contextPath}/viewContent.do";
		$.submitFormWoMsg();
	}

	
	</script>
	<table>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>
				<a href="#" class="easyui-linkbutton" onclick="saveContent()"><bean:message
									key='common.save' /></a>
				<a href="#" class="easyui-linkbutton" onclick="cancel()"><bean:message
									key='common.cancel' /></a>
			</td>
		</tr>
	</table>
	<html:form action="/editContent" enctype="multipart/form-data">
		<html:hidden styleId="resource.longString(id)"
			property="resource.longString(id)" />
		<html:hidden styleId="resource.longString(typeId)"
			property="resource.longString(typeId)" />
		<fk:content2 var="${content}" resourceName="${resourceName}" templateName="${templateName}" mode="edit" />
	</html:form>
</html:html>