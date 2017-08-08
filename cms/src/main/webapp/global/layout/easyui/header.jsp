<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragrma","no-cache");
	response.setDateHeader("Expires",0);
%>
<script src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script
	src='${pageContext.request.contextPath}/dwr/interface/headerAjax.js'></script>
<fk:cs />
<script type="text/javascript">
	$(function() {
		
		
		$('#btnGrpOthers').menubutton({
			menu: '#btnGrpOthersDetails'
		});
		
		$('#btnLogout').click(function(){
			var funLogout = function() {
				top.window.location = '${pageContext.request.contextPath}/logout.do';
			};
			top.confirm("<bean:message key='common.warning' />",
					"<bean:message key='common.message.logout.confirm' />",
					funLogout, null);
		});
		$('#btnAbout').click(function(){
			top.confirm("<bean:message key='common.about.title' />",
					"<bean:message key='common.about.content' />",
					null, null);
		});
		$("#currentGroupSelector").combobox({
			"onSelect":function(row){
				headerAjax.changeClientGroup(row.value,function(flag){
					if(!flag){
						top.$.messager.alert('<bean:message key="common.warning" />',
								'<bean:message key="common.message.group.change.failure" />');
						return;
					}
				});
			}
		});
		
	});
</script>

<div id="btnGrpOthersDetails" style="width:80px">
	<div id="btnLogout"><bean:message key='common.header.logout' /></div>
	<div id="btnAbout"><bean:message key='common.header.about' /></div>
</div>


<table width="100%" height="65px" style="background:#3a6ea5 no-repeat fixed 0 0;">
	<tr>
		<td align="right" valign="bottom">
			<table>
				<tr>
					<td><bean:message key="common.header.group" /></td>
					<td>
						<select id="currentGroupSelector" class="easyui-combobox">
						<c:forEach items="${cs.groups}" var="group" varStatus="loop">
							<option value="${group.id}">${group.alias}</option>
						</c:forEach>
						</select>
					</td>
					<td>&nbsp;</td>	
					<td>&nbsp;</td>
					<td><a id="btnGrpOthers" href="#"><bean:message key="common.header.others" /></a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>