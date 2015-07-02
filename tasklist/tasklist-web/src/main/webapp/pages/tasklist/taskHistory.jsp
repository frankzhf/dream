<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fk:resource var="taskContext" resourceId="${task.context$3.id}"/>
<fk:resource var="tokens" parentResource="${taskContext}" alias="token"/>
<c:if test="${!empty tokens.children}">
	<c:forEach items="${tokens.children}" var="token" varStatus="loop">
		<c:if test="${token.typeId eq 50003}">
<br>
<table width="100%">
	<tr>
		<td width="15%"><bean:message key="task.working.label.taken.operator" /></td>
		<td width="35%">
			<fk:resource var="token" resourceId="${token.id}"/>
			<fk:resource var="operator" resourceId="${token.object.account$5.id}"/>
			${operator.object.loginName}
		</td>
		<td width="15%"><bean:message key="task.working.label.taken.updated.dt" /></td>
		<td>
			<fmt:formatDate value="${token.createdDt}" pattern="dd/MM/yyyy HH:mm:ss"/>
			<bean:message key="common.due"/>
			<fmt:formatDate value="${token.lastUpdatedDt}" pattern="dd/MM/yyyy HH:mm:ss"/> 
		</td>
	</tr>
	<tr>
		<!-- Attaches -->
		
		<fk:resource var="tokenContent" resourceId="${token.object.context$3.id}"/>
		<fk:resource var="attaches" parentResource="${tokenContent}" alias="attaches"/>
		<fk:resource var="screenshots" parentResource="${tokenContent}" alias="screenshots"/>
		<fk:resource var="comments" parentResource="${tokenContent}" alias="comments"/>
		
			<c:if test="${!empty attaches.children}">
		<td colspan="4">
			<table width="100%">
				<tr>
					<th width="20%"><bean:message key="task.working.attach.label.download" /></th>
					<th width="30%"><bean:message key="task.working.attach.label.attach.name" /></th>
					<th><bean:message key="task.working.attach.label.create.date" /></th>
				</tr>
				<c:forEach items="${attaches.children}" var="attach" varStatus="loop">
					<fk:resource var="attach" resourceId="${attach.id}" />
					<fk:content2 templateName="net.frank.framework.bo.Attach.html" var="${attach.object}"  mode="view"
						resourceName="net.frank.framework.bo.Attach.properties" />
				</c:forEach>
			</table>
		</td>
			</c:if>
			<c:if test="${empty attaches.children}">
		<td colspan="4">
			<bean:message key="task.working.message.no.attach"/>
		</td>
			</c:if>
	</tr>
	<tr>
		<!-- Images -->
			<c:if test="${!empty screenshots.children}">
		<td colspan="4">
			<table width="100%">
				<tr>
					<th><bean:message key="task.working.screenshots" /></th>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
				<c:forEach items="${screenshots.children}" var="scrrenshot" varStatus="loop">
								<td>
					<img src="${pageContext.request.contextPath}/attachment?resourceId=${scrrenshot.id}&elementId=content" 
						alt="${scrrenshot.object.imageName}" width="103px" height="77px"/>
								<br>
								<fk:resource var="scrrenshot" resourceId="${scrrenshot.id}"/>
								<fmt:formatDate pattern="dd/MM HH:mm:ss" value="${scrrenshot.createdDt}"/>
								</td>
				</c:forEach>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
			</c:if>
			<c:if test="${empty screenshots.children}">
		<td colspan="4">
			<bean:message key="task.working.message.no.screenshot"/>
		</td>
			</c:if>
	</tr>
	<tr>
		<!-- Comments -->
			<c:if test="${!empty comments.children}">
		<td colspan="4">
			<table width="100%">
				<tr>
					<th><bean:message key="task.working.comments" /></th>
				</tr>
				<c:forEach items="${comments.children}" var="comment" varStatus="loop">
					<fk:resource var="comment" resourceId="${comment.id}" />
					<fk:content2 templateName="net.frank.framework.bo.Comment.html" var="${comment.object}"  mode="view"
						resourceName="net.frank.framework.bo.Comment.properties" />
				<tr>
					<td align="right">
						<fmt:formatDate value="${comment.createdDt}" pattern="dd/MM/yyyy HH:mm:ss"/>
					</td>
				</tr>
				</c:forEach>
			</table>
		</td>
			</c:if>
			<c:if test="${empty comments.children}" >
		<td colspan="4">
			<bean:message key="task.working.message.no.comment"/>
		</td>
			</c:if>
	</tr>
</table>
		</c:if>
	</c:forEach>
</c:if>


<c:if test="${empty tokens.children}">
<br>
<bean:message key="task.working.message.no.content"/>
</c:if>