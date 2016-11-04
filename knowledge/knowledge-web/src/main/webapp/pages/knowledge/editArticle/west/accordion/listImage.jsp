<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src='${pageContext.request.contextPath}/dwr/interface/knowledgeServiceAjax.js'></script>
	
<script type="text/javascript">
$(function(){
	$("#triggerUploadImage").click(function(){
		top.$('#dialogDiv').dialog({
			title : '<bean:message  key="knowledge.list.image.dialog.upload.image.title" />',
			width : 400,
			height : 350,
			modal : true,
			content : '<iframe frameborder="0" src="${pageContext.request.contextPath}/knowledge/uploadImage.do?article.resource.id=${knowledgeForm.article.resource.id}" style="width:100%;height:100%;" ></iframe>',
			buttons : [{
				text : '<bean:message key="common.close"/>',
				handler : function (){
					top.$('#dialogDiv').window('close');
					parent.refrushDiv('imageDiv','${pageContext.request.contextPath}/knowledge/listImage.do?article.resource.id=${knowledgeForm.article.resource.id}&'+Math.random()+'"');
				}
			}]
		});
	});
});

function deleteImage(resourceId){
	var deleteFunction = function(){
		top.$('#confirmDiv').window('close');
		knowledgeServiceAjax.deleteImage(resourceId,function(flag){
			var funOK = function(){
				parent.refrushDiv('imageDiv','${pageContext.request.contextPath}/knowledge/listImage.do?article.resource.id=${knowledgeForm.article.resource.id}&'+Math.random()+'"');
			}
			$.processCmsMessage(flag,funOK);
		});
	}
	top.confirm("<bean:message key='common.warning' />",
			"<bean:message key='knowledge.list.image.confirm.delete.image' />",
			deleteFunction, null);
}

</script>
<div id="north" region="north" border="false" style="height: 40px; padding: 0px;">
	<a id="triggerUploadImage"  class="easyui-linkbutton">
		<bean:message key='knowledge.list.image.button.upload.image' />
	</a>
</div>
<div id="center" region="center" border="false" style="padding: 0px;">
<fk:resource var="article" resourceId="${knowledgeForm.article.resource.id}"/>
<fk:resource var="context" resourceId="${article.object.context$3.id}"/>
<fk:resource var="imageFolder" parentResource="${context}" alias="image"/>
<table width="100%">
	<c:set var="imageCount" value="0" />
	<tr><td width="75%">&nbsp;</td><td>&nbsp;</td></tr>
<c:if test="${!empty imageFolder.children}">
	<c:forEach items="${imageFolder.children}" var="child" varStatus="loop">
		<fk:resource var="child" resourceId="${child.id}"/>
		<c:if test="${ 11 eq child.typeId}">
			<c:set var="imageCount" value="${imageCount+1}" />
			<fk:rondom />
			<tr><td>
			<img width="40px" height="45px" src="${pageContext.request.contextPath}/image-service?resourceId=${child.id}&elementId=content&flag=${rondom}">
			</td>
			<td><a class="easyui-linkbutton" onclick="deleteImage(${child.id})">
				<bean:message key='knowledge.list.image.button.delete' />
			</a></td>
			</tr>
		</c:if>
	</c:forEach>
</c:if>
<c:if test="${imageCount eq 0}">
		<tr><td><bean:message
						key="common.message.no.match.records" /></td></tr>
	</c:if>
</table>
</div>