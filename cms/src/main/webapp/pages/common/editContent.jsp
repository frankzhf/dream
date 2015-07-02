<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>


<script>
function saveContent(){
	if($.validationForm('form[name=cmsForm] input[type!=hidden]')){
		document.forms[0].action = "${pageContext.request.contextPath}/common/saveContent.do";
		$.submitFormWoMsg();
	}
}

function cancel(){
	document.forms[0].action = "${pageContext.request.contextPath}/common/viewContent.do";
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
	<fk:content2 var="${content}" resourceName="${resourceName}" templateName="${templateName}" mode="edit" />
</html:form>