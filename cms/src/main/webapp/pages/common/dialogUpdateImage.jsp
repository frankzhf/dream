<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.frank.cms.common.CmsCommonConstants"%>


<html:html>
<head>
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

function initSplitImage(){
	var _image = $('#viewImage');
	x = _image.width;
	y = _image.height;
	var imgArea = _image.imgAreaSelect({
		instance : true,
		movable: ($.browser.msie || $.browser.safari) ? true : false,
		x1 : 0,
		y1 : 0,
		x2 : x,
		y2 : y,
		handles : true,
		onSelectEnd : function(img, selection) {
			$("#editFrame")[0].contentWindow.$('#areaHeight').html((selection.y2 - selection.y1) + " px");
			$("#editFrame")[0].contentWindow.$('#areaWidth').html((selection.x2 - selection.x1) + " px");
			$("#editFrame")[0].contentWindow.$('#firstPointX').val(selection.x1);
			$("#editFrame")[0].contentWindow.$('#firstPointY').val(selection.y1);
			$("#editFrame")[0].contentWindow.$('#secondPointX').val(selection.x2);
			$("#editFrame")[0].contentWindow.$('#secondPointY').val(selection.y2);
		},
		onInit : function(img){
			var _selection = imgArea.getSelection(true);
			$("#editFrame")[0].contentWindow.$('#firstPointX').val(0);
			$("#editFrame")[0].contentWindow.$('#firstPointY').val(0);
			$("#editFrame")[0].contentWindow.$('#secondPointX').val(img.offsetWidth);
			$("#editFrame")[0].contentWindow.$('#secondPointY').val(img.offsetHeight);
		}
	});
}
function cancelSplitImage(){
	var _image = $('#viewImage');
	_image.imgAreaSelect({instance:true}).cancelSelection();
	$("#editFrame")[0].contentWindow.$('#firstPointX').val(null);
	$("#editFrame")[0].contentWindow.$('#firstPointY').val(null);
	$("#editFrame")[0].contentWindow.$('#secondPointX').val(null);
	$("#editFrame")[0].contentWindow.$('#secondPointY').val(null);
}
</script>
</head>
<body>
	<table style="width:100%;">
		<tr>
			<td>
				<%
					String resoruceId = request.getParameter("resourceId");
					if (resoruceId != null
						&& !CmsCommonConstants.EMPTY_STRING.equals(resoruceId)) {
				%> 
			<img id="viewImage" class="scissor" alt="click&&cut" width="150px" height="220px"
				src="${pageContext.request.contextPath}/image-service?resourceId=<%=resoruceId%>&elementId=content&flag=<%=Math.random()%>"> 
				<%
 					} else {
 				%> 
 			<img id="viewImage" class="scissor" alt="click&&cut" width="150" height="220px"
				src="${pageContext.request.contextPath}/global/images/default.jpg"> 
				<%
 					}
 				%> 
 			<input type="hidden" id="resource_longString_id_"value="<%=resoruceId%>">
			</td>
			<td align="left" valign="top">
			<iframe id="editFrame" style="width:100%;height:100%" overflow="no" frameborder="0"src="${pageContext.request.contextPath}/common/updateImage.do?resource.longString(id)=<%=resoruceId%>"></iframe>
			</td>
		</tr>
	</table>
</body>
</html:html>
