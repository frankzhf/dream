<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags/cms" prefix="cms"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<fk:cs />
<script>
<c:if test="${!empty cs.account.staff$16}">
<fk:resource resourceId="${cs.account.staff$16.id}" var="staff"/>
$(function() {
	$('#tabInfo').tabs({
	});
});
</c:if>

<c:if test="${empty cs.account.staff$16}">
function addPersonalInfo(){
	$.submitFormWoMsg();
}
</c:if>
</script>
<p></p>
<p></p>
<table width="100%">
	<tr>
		<td width="2%">&nbsp;</td>
		<td width="35%"><bean:message key="self.my.info.login.name" /></td>
		<td width="50%">${cs.loginName}</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td colspan="3">&nbsp;
		<c:if test="${empty cs.account.staff$16}">
<html:form action="/addPersonalInfo">
	<a href="#" class="easyui-linkbutton" onclick="addPersonalInfo()"><bean:message key='self.my.info.button.add.person' /></a>
</html:form>
</c:if>
		</td>
	</tr>
</table>


<c:if test="${!empty cs.account.staff$16}">
	<div id="tabInfo" style="position:absolute; padding:0px 5px;width:960px;height:500px">
		<div title="<bean:message key='self.my.info.tabs.title.personal'/>">
			<iframe frameborder="0" 
			src="${pageContext.request.contextPath}/common/viewContent.do?resource.id=${staff.object.person$15.id}" style="width:100%;height:100%"></iframe>
		</div>
		<div title="<bean:message key='self.my.info.tabs.title.staff'/>">
			<iframe frameborder="0" 
			src="${pageContext.request.contextPath}/common/viewContent.do?resource.id=${staff.id}" style="width:100%;height:100%"></iframe>
		</div>
	</div>	
</c:if>