<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script
	src='${pageContext.request.contextPath}/dwr/interface/adminAjax.js'></script>

<script type="text/javascript">
function doRemoveStaffGroup(a2gResourceId){
	adminAjax.removeStaffGroup(a2gResourceId,function(flag){
		var funOK = function(){
			var href = '${pageContext.request.contextPath}/admin/queryStaffByGroupAndLikeName.do?resource.id=${group.id}';
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
				key="admin.grant.unit.group.list.staff.photo" /></th>
		<th width="15%"><bean:message
				key="admin.grant.unit.group.list.staff.Id" /></th>
		<th width="20%"><bean:message
				key="admin.grant.unit.group.list.staff.english.Name" /></th>
		<th width="15%"><bean:message
				key="admin.grant.unit.group.list.site.phone" /></th>
		<th>&nbsp;</th>
	</tr>
<c:choose>
	<c:when test="${empty grantFolder.children}">
	<tr>
		<td colspan="6"><bean:message
				key="common.message.no.match.records" /></td>
	</tr>
	</c:when>
	<c:otherwise>
		<c:set var="staffCount" value="0" />
		<c:forEach items="${grantFolder.children}" var="a2g" varStatus="loop">
			<fk:resource var="a2g" resourceId="${a2g.id}" />
			<c:if test="${a2g.typeId eq 7  && a2g.object.group$6.id eq group.id}">
				<fk:resource var="account" resourceId="${a2g.object.account$5.id}"
					cs="${su}" />
				<fk:resource var="staff" resourceId="${account.object.staff$16.id}"
					cs="${su}" />
				<c:choose>
					<c:when test="${!empty staffName}">
						<c:if test="${fn:contains(staff.alias,staffName)}" >
							<fk:resource var="person" resourceId="${staff.object.person$15.id}" cs="${su}" />
	<tr>
		<td>&nbsp;</td>
		<td><img width="32px" height="48px"
			src="${pageContext.request.contextPath}/image-service?resourceId=${person.object.photo$11.id}&elementId=content&flag="+Math.random()" >&nbsp;</td>
		<td>${staff.object.staffId} &nbsp;</td>
		<td>${person.object.englishName} &nbsp;</td>
		<td>${staff.object.sitePhone} &nbsp;</td>
		
	</tr>
							<c:set var="staffCount" value="${staffCount + 1}" />
						</c:if>
					</c:when>
					<c:otherwise>
						<fk:resource var="person" resourceId="${staff.object.person$15.id}" cs="${su}" />
	<tr>
		<td>&nbsp;</td>
		<td><img width="32px" height="48px"
			src="${pageContext.request.contextPath}/image-service?resourceId=${person.object.photo$11.id}&elementId=content&flag="+Math.random()" >&nbsp;</td>
		<td>${staff.object.staffId} &nbsp;</td>
		<td>${person.object.englishName} &nbsp;</td>
		<td>${staff.object.sitePhone} &nbsp;</td>
		<td>
						<fk:hasPermission permission="write" resourceId="${grantFolder.id}">
			<a href="#" class="easyui-linkbutton" onclick="doRemoveStaffGroup(${a2g.id})"><bean:message
									key='admin.grant.unit.group.button.remove' /></a>
						</fk:hasPermission>
		&nbsp;</td>
	</tr>
						<c:set var="staffCount" value="${staffCount + 1}" />
					</c:otherwise>
				</c:choose>
			</c:if>
		</c:forEach>
		<c:if test="${staffCount eq 0}">
	<tr>
		<td colspan="6"><bean:message
			key="common.message.no.match.records" /> </td>
	</tr>
		</c:if>
	</c:otherwise>
</c:choose>
</table>