<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery-common.js"></script>

<script type="text/javascript">
$(function(){
	<c:if test="${empty result}">
		<c:if test="${result eq 0}">
		$("#errorDiv").html("<bean:message key='knowledge.upload.image.message.upload.image.success'/>");
		</c:if>
		<c:if test="${result eq -5}">
		$("#errorDiv").html("<font color='red'><bean:message key='knowledge.upload.image.error.image.name.duplicate'/></font>");
		</c:if>
		<c:if test="${result eq -100}">
		$("#errorDiv").html("<font color='red'><bean:message key='knowledge.upload.image.error.image.transfer.invalid'/></font>");
		</c:if>
	</c:if>
});
function uploadImage(){
	$("#errorDiv").empty();
	if($.isEmpty('uploadFile')){
		$("#errorDiv").html("<font color='red'><bean:message key='knowledge.upload.image.select.file.placeholder'/></font>");
		return;
	}else{
		var fileName = $("#uploadFile").val();
		if($.isImageFile(fileName)){
			$.submitFormWoMsg();
		}else{
			$("#errorDiv").html("<font color='red'><bean:message key='knowledge.list.image.dialog.error.file.not.image.format'/></font>");
		}
	}
}
</script>
<html:form action="/submitUploadImage" enctype="multipart/form-data">
	<html:hidden property="article.resource.longString(id)" />
	<table width="100%">
		<tr>
			<td>
				<input type="file" id="uploadFile" name="uploadFile"
					placeholder="<bean:message key='knowledge.upload.image.select.file.placeholder'/>">
				<input type="button" value="<bean:message key='knowledge.list.image.dialog.button.upload' />"
					onclick="uploadImage()">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="errorDiv"></div>
			</td>
		</tr>
	</table>
</html:form>