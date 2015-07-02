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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery-easyui-common.js"></script>	

<script type="text/javascript">
$(function() {
	$('#updatedFile').live('change', function() {
		if($(this).val()!=null && isImage($(this).val())){
			var _imageElement=parent.document.getElementById('viewImage');
			getPath(_imageElement,$(this));
		}else{
			$(this).val('');
			$("#msg").html('It should be Image file. (jpg,jpeg,png,gif)');
		}
	});
});

function isImage(fileName){
	var fileNameLength = fileName.length;
	if(fileName.indexOf(".jpeg") == fileNameLength-5){
		return true;
	}
	if(fileName.indexOf(".jpg") == fileNameLength-4){
		return true;
	}
	if(fileName.indexOf(".png") == fileNameLength-4){
		return true;
	}
	if(fileName.indexOf(".gif") == fileNameLength-4){
		return true;
	}
	return false;
}

var getPath=function(obj,fileQuery){
	if($.browser.msie){ 
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
	if($.browser.msie){
		var _imageElement = parent.document.getElementById('viewImage');
		var width_img,height_img;   
		width_img=_imageElement.offsetWidth;    
		height_img=_imageElement.offsetHeight;
		_imageElement.style.width=width_img;
		_imageElement.style.height = height_img;
	}
}

function updateImage(){
	if(($("#updatedFile").val()==null || $("#updatedFile").val()=='') && 
			!$("#chkSplit").attr('checked') ){
		$("#msg").html('Update file should be not empty  or Split Image should be checked');
	}else{
		if($("#chkSplit").attr('checked')){
			if($("#firstPointX").val()!=null && $("#firstPointX").val()!='' &&
				$("#firstPointY").val()!=null && $("#firstPointY").val()!='' &&
				$("#secondPointX").val()!=null && $("#secondPointX").val()!='' &&
				$("#secondPointY").val()!=null && $("#secondPointY").val()!=''){
				document.forms[0].submit();
			}else{
				$("#msg").html('No specify image split area.');
			}
		}else{
			document.forms[0].submit();
		}
	}
}

function splitImageTrigger(){
	var checked = document.getElementById('chkSplit').checked;
	if(checked){
		parent.initSplitImage();
	}else{
		parent.cancelSplitImage();
	}
}

<c:if test="${submitted}">
	parent.document.getElementById('viewImage').src = '${pageContext.request.contextPath}/image-service?resourceId=${resource.id}&elementId=content&flag='+<%=Math.random()%>;
	parent.document.getElementById('resource_longString_id_').value = ${resource.id};
</c:if>



</script>
</head>
<html:form action="/submitUpdateImage"  enctype="multipart/form-data">
	<html:hidden styleId="resource_longString_id_"
		property="resource.longString(id)" />
	<html:hidden styleId="firstPointX"
		property="firstPointX" />
	<html:hidden styleId="firstPointY"
		property="firstPointY" />
	<html:hidden styleId="secondPointX"
		property="secondPointX" />
	<html:hidden styleId="secondPointY"
		property="secondPointY" />
	<table width="100%">	
		<tr>
			<td width="25%">Image File</td>
			<td width="70%"><html:file styleId="updatedFile" property="updatedFile" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="<bean:message key='common.update.image.button' />" onclick="updateImage()">
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="checkbox" id="chkSplit" name="chkSplit" value="true" onclick="splitImageTrigger()"> Split Image
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
				<table width="100%">
					<tr>
						<td width="15%">Width:</td>
						<td width="35%"><div id="areaWidth">0px</div></td>
						<td width="15%">Height:</td>
						<td><div id="areaHeight">0px</div></td>
					</tr>
				</table>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="msg" class="errors"></div>
			</td>
		<td>&nbsp;</td>
		</tr>	
	</table>
</html:form>