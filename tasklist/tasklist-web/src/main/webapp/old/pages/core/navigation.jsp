<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>


<%
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragrma","no-cache");
	response.setDateHeader("Expires",0);
%>

<html:html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/css/project.css">

<script type="text/javascript">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>

<!-- DWR lib -->
<script type="text/javascript" 
	src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script type="text/javascript" 
	src='${pageContext.request.contextPath}/dwr/util.js'></script>
<script
	src='${pageContext.request.contextPath}/dwr/interface/queryAjax.js'></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>

<script type="text/javascript">
function createBusinessObject(){
	var tree = treeNav.tree;
	if(!tree.getSelected()){
		top.$.messager.alert('<bean:message key="common.warning" />','<bean:message key="core.navigation.errors.require.selecte.folder" />');
		return;
	}
	var id = tree.getSelected().getId();
	if(id ==null || id == ''){
		top.$.messager.alert('<bean:message key="common.warning" />','<bean:message key="core.navigation.errors.require.selecte.folder" />');
		return;
	}
	var _businessType = $('#businessType').combobox('getValue');
	queryAjax.checkResourceNode(id,function(isResourceNode){
		if(isResourceNode){
			parent.openUrl('${pageContext.request.contextPath}/core/createBusinessObject.do?resource.parentId='+ 
						id+"&resource.typeId="+_businessType);
		}else{
			top.$.messager.alert('<bean:message key="common.warning" />','<bean:message key="core.navigation.errors.require.selecte.folder" />');
		}
	});
}
</script>
</head>
<body class="easyui-layout">
	<div id="center" region="center" border="false">
		<iframe id="treeNav" name="treeNav" frameborder="0"
			src="${pageContext.request.contextPath}/core/tree.do" style="width:100%;height:100%;"></iframe>
	</div>
	<div id="south" region="south" border="false" style="height:80px; padding: 5px;">
		<table width="100%">
			<tr>
				<td><bean:message key="core.navigation.type" /></td>
				<td>
					<select class="easyui-combobox" style="width:160px;" id="businessType">
						<c:forEach items="${typeContentList}" var="type" varStatus="loopStatus">
							<option value="${type.resource.id}">${type.typeKey}</option>
						</c:forEach>
					</select>
					<input type="hidden" value="" id="targetResource"
						name="targetResource" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<a class="easyui-linkbutton" 
						href="#" onclick="createBusinessObject();">
						<bean:message key="core.navigation.create" />
					</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html:html>