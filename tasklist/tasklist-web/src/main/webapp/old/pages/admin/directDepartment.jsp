<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>


<script type="text/javascript">
	$(function(){
		$('#tabInfo').tabs();
	});
</script>


<table width="100%">
	<tr>
		<td><bean:message key="common.resource.path" /></td>
		<td><fk:path resourceId="${resource.id}" /></td>
	</tr>
	<tr>
		<td colspan="2">
			&nbsp;
		</td>
	</tr>
</table>
<div id="tabInfo" style="position:absolute;padding:0px 5px;height:550px">
	<div title="Department Details">
		<iframe frameborder="0" 
			src="${pageContext.request.contextPath}/viewContent.do?resource.id=${resource.id}" style="width:100%;height:100%"></iframe>
	</div>
</div>