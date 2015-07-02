<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fk:resource var="tokenContent" resourceId="${taskToken.context$3.id}"/>
<fk:resource var="attaches" parentResource="${tokenContent}" alias="attach"/>
<fk:resource var="screenshots" parentResource="${tokenContent}" alias="screenshot"/>
<fk:resource var="comments" parentResource="${tokenContent}" alias="comment"/>

<script type="text/javascript">
$(function() {
	$("#content_18__clobString_text_").validatebox({   
	    required:true  
	});

	$("#updateFile_content_11").validatebox({   
	    required:true  
	}).validatebox({
		validType:'imageFormat',
		invalidMessage:'<bean:message key="errors.invalid.img.format" />'
	});
	$("#updateFile_content_10").validatebox({   
	    required:true  
	});
});

var _commentParent = ${comments.id};
var _screenShotParent = ${screenshots.id};
var _attachParent = ${attaches.id};


function directResource(resourceId) {
	
}
function submitComment(){
	if($("#content_18__clobString_text_").validatebox('isValid')){
		$("#updateFile_content_10").attr("disabled","true");
		$("#updateFile_content_11").attr("disabled","true");
		$("#resource_longString_parentId_").val(_commentParent);
		document.forms[0].action = '${pageContext.request.contextPath}/tasklist/submitTaskTokenComment.do';
		$.submitFormWoMsg();
	}
}
function submitScreenShot(){
	if($("#updateFile_content_11").validatebox('isValid')){
		$("#resource_longString_typeId_").val("11");
		$("#content_12__clobString_text_").attr("disabled","true");
		$("#updateFile_content_10").attr("disabled","true");
		$("#resource_longString_parentId_").val(_screenShotParent);
		document.forms[0].action = '${pageContext.request.contextPath}/tasklist/submitTaskTokenScreenShot.do';
		$.submitFormWoMsg();
	}
}
function submitAttach(){
	if($("#updateFile_content_10").validatebox('isValid')){
		$("#content_12__clobString_text_").attr("disabled","true");
		$("#updateFile_content_11").attr("disabled","true");
		$("#resource_longString_typeId_").val("10");
		$("#resource_longString_parentId_").val(_attachParent);
		document.forms[0].action = '${pageContext.request.contextPath}/tasklist/submitTaskTokenAttach.do';
		$.submitFormWoMsg();
	}
}
</script>

<fk:content2 templateName="net.frank.tasklist.bo.viewTask.html" var="${task}"  mode="view"
	resourceName="net.frank.tasklist.bo.Task" />
<br>
<br>
<br>
<html:form action="/submitTaskTokenComment" enctype="multipart/form-data">
	<html:hidden property="resourceId" />
	<html:hidden property="resource.longString(parentId)" styleId="resource_longString_parentId_" value="${comments.id}"/>
	<html:hidden property="resource.longString(typeId)" styleId="resource_longString_typeId_" value="18"/>
	<html:hidden property="resource.longString(ownGroupResourceId)" styleId="resource_longString_ownGroupResourceId_" value="${tokenContent.ownGroupResourceId}"/>	
	<table width="100%">
		<tr>
			<td width="70%">
				<textarea id="content_18__clobString_text_" style="width:100%;" name="content(18).clobString(text)"></textarea>
			</td>
			<td valign="bottom">
				<input type="button" value="<bean:message key='task.working.add.comment' />" onclick="submitComment()">
			</td>
		</tr>
		<tr>
			<td>
				<input type="file" id="updateFile_content_11" name="updateFile(content)" >
			</td>
			<td>
				<input type="button" value="<bean:message key='task.working.add.screenshot' />" onclick="submitScreenShot()">
			</td>
		</tr>
		<tr>
			<td>
				<input type="file" id="updateFile_content_10" name="updateFile(content)" >
			</td>
			<td>
				<input type="button" value="<bean:message key='task.working.add.attach' />" onclick="submitAttach()">
			</td>
		</tr>
	</table>
</html:form>
<br>
<br>
<br>

<table width="100%">
	<tr>
		<td width="20%"><bean:message key="task.working.label.taken.operator" /></td>
		<td width="15%">
			<fk:resource var="operator" resourceId="${taskToken.account$5.id}"/>
			${operator.object.loginName}
		</td>
		<td width="20%"><bean:message key="task.working.label.taken.updated.dt" /></td>
		<td>
			<fmt:formatDate value="${taskToken.resource.createdDt}" pattern="dd/MM/yyyy HH:mm:ss"/>
			<bean:message key="common.due"/>
		</td>
	</tr>
	<tr>
		<!-- Attaches -->
		
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
						resourceName="net.frank.framework.bo.Attach" />
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
				<c:forEach items="${screenshots.children}" var="scrrenshot" varStatus="loop">
					<img src="${pageContext.request.contextPath}/attachment?resourceId=${scrrenshot.id}&elementId=content" 
						alt="${scrrenshot.object.imageName}" width="103px" height="77px"/>
				</c:forEach>
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
						resourceName="net.frank.tasklist.bo.Comment" />
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