<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<fk:hasPermission resourceId="${resource.id}" permission="write" >
<script>
function editContent(){
	$.submitFormWoMsg();
}
</script>
<table>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>
			<a href="#" class="easyui-linkbutton" onclick="editContent()"><bean:message
								key='common.edit' /></a>
		</td>
	</tr>
</table>
</fk:hasPermission>
<html:form action="/editContent" enctype="multipart/form-data">
	<fk:content2 var="${content}" resourceName="${resourceName}" templateName="${templateName}" mode="view" />
</html:form>