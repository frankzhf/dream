<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script
	src='${pageContext.request.contextPath}/dwr/interface/repositoryServiceAjax.js'></script>

<script type="text/javascript">
function doRemoveStaffShareFile(aclId){
	
	repositoryServiceAjax.removeShareFile(aclId,function(flag){
		var funOK = function(){
			var href = '${pageContext.request.contextPath}/repository/queryOwnsForResource.do?file.id=${fileResourceId}';
			parent.$("#center").panel({
				modal:true,
				content : '<iframe frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>'
			});
		}
		$.processCmsMessage(flag,funOK);
	});
}
</script>

<table class="listTable">
	<tr>
		<th width="2%">&nbsp;</th>
		<th width="25%"><bean:message
				key="repository.file.list.dialog.share.file.staff.photo" /></th>
		<th width="15%"><bean:message
				key="repository.file.list.dialog.share.file.staff.id" /></th>
		<th width="20%"><bean:message
				key="repository.file.list.dialog.share.file.staff.english.Name" /></th>
		<th width="15%"><bean:message
				key="repository.file.list.dialog.share.file.staff.site" /></th>
		<th>&nbsp;</th>
	</tr>
<c:choose>
	<c:when test="${empty aclList}">
	<tr>
		<td colspan="6"><bean:message
				key="common.message.no.match.records" /></td>
	</tr>
	</c:when>
	<c:otherwise>
		<c:forEach items="${aclList}" var="acl" varStatus="loop">
				<fk:resource var="account" resourceId="${acl.ownId}" cs="${su}" />
				<fk:resource var="staff" resourceId="${account.object.staff$19.id}"
					cs="${su}" />
				<fk:resource var="person" resourceId="${staff.object.person$18.id}"
					cs="${su}" />
				<tr>
		<td>&nbsp;</td>
		<td><img width="32px" height="48px"
			src="${pageContext.request.contextPath}/image-service?resourceId=${person.object.photo$11.id}&elementId=content&flag="+Math.random()" >&nbsp;</td>
		<td>${staff.object.staffId} &nbsp;</td>
		<td>${person.object.englishName} &nbsp;</td>
		<td>${staff.object.sitePhone} &nbsp;</td>
		<td><a href="#" class="easyui-linkbutton" onclick="doRemoveStaffShareFile(${acl.id})"><bean:message
				key='repository.file.list.dialog.share.file.remove' /></a>
		</td>
	</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
</table>