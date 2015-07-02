<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
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
	src="${pageContext.request.contextPath}/global/scripts/global.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery-common.js"></script>

<script type="text/javascript">
$(function() {
	$('#updatedFile').validatebox({
		required : true
	});
	$('#updatedFile').live('change', function() {
		var _imageElement=parent.document.getElementById('viewImage');
		getPath(_imageElement,$(this));
	});
});

var getPath=function(obj,fileQuery){
	if(window.navigator.userAgent.indexOf("MSIE")>=1){ 
		var path=fileQuery.val(); 
		obj.removeAttribute("src"); 
		obj.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+path+"', sizingMethod='scale');";
	}else{
		var file = fileQuery.get(0).files[0];
		var reader = new FileReader();  
		reader.onload = function(e){ 
			obj.setAttribute("src",e.target.result);
		};
		reader.readAsDataURL(file);
	}
	setTimeout("setImg()",100);
};

function setImg(){
	if(window.navigator.userAgent.indexOf("MSIE")>=1){
		var _imageElement = parent.document.getElementById('viewImage');
		var width_img,height_img;   
		width_img=_imageElement.offsetWidth;    
		height_img=_imageElement.offsetHeight;
		_imageElement.style.width=width_img;
		_imageElement.style.height = height_img;
	}
}

function updateImage(){
	if($.validationForm('form[name=updateImageForm] input[type!=hidden]')){
		$.submitFormWoMsg();
	}
}

<c:if test="${submitted}">
	parent.document.getElementById('viewImage').src = '${pageContext.request.contextPath}/image-service?resourceId=${resource.id}&elementId=content&flag='+<%=Math.random()%>;
	parent.document.getElementById('resource.longString(id)').value = ${resource.id};
</c:if>

</script>
</head>
<html:form action="/submitUpdateImage"  enctype="multipart/form-data">
	<html:hidden styleId="resource.longString(id)"
		property="resource.longString(id)" />
	<html:hidden styleId="image.longString(id)"
		property="image.longString(id)" />
	<html:hidden styleId="firstPointX"
		property="firstPointX" />
	<html:hidden styleId="firstPointY"
		property="firstPointY" />
	<html:hidden styleId="secondPointX"
		property="secondPointX" />
	<html:hidden styleId="secondPointY"
		property="secondPointY" />	
	<table>
		<tr>
			<td>Image Description</td>
			<td><html:text styleId="image.imageDescription"
					property="image.imageDescription" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>Image Content</td>
			<td><html:file styleId="updatedFile" property="updatedFile" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
			<div id="errorMessage"></div>	
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="<bean:message key='common.update.image.button' />" onclick="updateImage()">
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
</html:form>