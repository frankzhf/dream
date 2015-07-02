<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.frank.cms.common.CmsCommonConstants"%>


<html:html>
<head>
<title><bean:message key="selector.resource" /></title>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/imgareaselect/css/imgareaselect-default.css" />
<script type="text/javascript">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/imgareaselect/scripts/jquery-1.6.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/imgareaselect/scripts/jquery.imgareaselect.js"></script>

<script type="text/javascript">
	var result = {
		flag : false,
		resourceId : ''
	};
	window.returnValue = result;

	function closeDialog() {
		result.flag = true;
		result.resourceId = document.getElementById('resource.longString(id)').value;
		self.close();
	}
	
	$(document).ready(function() {
		var x,y;
		var _image = $('#viewImage');
		var image = new Image();
		image.src = _image.attr('src');
		image.onload = function(){
			x = image.width;
			y = image.height;
			var imgArea = _image.imgAreaSelect({
				x1 : 1,
				y1 : 1,
				x2 : x-1,
				y2 : y-1,
				handles : true,
				onSelectEnd : function(img, selection) {
					$('#areaHeight').html((selection.y2 - selection.y1) + " px");
					$('#areaWidth').html((selection.x2 - selection.x1) + " px");
					editFrame.$('#firstPointX').val(selection.x1);
					editFrame.$('#firstPointY').val(selection.y1);
					editFrame.$('#secondPointX').val(selection.x2);
					editFrame.$('#secondPointY').val(selection.y2);
				}
			});
		};
	});
</script>
</head>
<body>
	<table border="1" style="width:100%;">
		<tr>
			<td>
				<%
					String resoruceId = request.getParameter("resourceId");
					if (resoruceId != null
						&& !CmsCommonConstants.EMPTY_STRING.equals(resoruceId)) {
				%> 
			<img id="viewImage" width="125px" height="180px" class="scissor" alt="click&&cut"
				src="${pageContext.request.contextPath}/image-service?resourceId=<%=resoruceId%>&elementId=content&flag=<%=Math.random()%>"> 
				<%
 					} else {
 				%> 
 			<img id="viewImage" width="125px" height="180px" class="scissor" alt="click&&cut"
				src="${pageContext.request.contextPath}/global/images/default.jpg"> 
				<%
 					}
 				%> 
 			<input type="hidden" id="resource.longString(id)"value="<%=resoruceId%>"><br>
			</td>
			<td>
			<iframe id="editFrame" style="width:100%;height:100%" frameborder="0"src="${pageContext.request.contextPath}/updateImage.do?resource.longString(id)=<%=resoruceId%>"></iframe>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table>
					<tr>
						<td>Area Width:</td>
						<td><div id="areaWidth"></div></td>
					</tr>
					<tr>
						<td>Area Height:</td>
						<td><div id="areaHeight"></div></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="Close"
				onclick="closeDialog()"></td>
		</tr>
	</table>
</body>
</html:html>
