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
<fk:cs />
<script type="text/javascript">
	$(function() {
		$('#btnGrpMyRepositories').menubutton({
			menu: '#btnMyRepositories'
		});
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
		<c:if test="${cs.account.resource.id eq cs.account.resource.ownResourceId}">
		$('#btnMyDocument').click(function(){
			top.openUrl('<bean:message key="common.layout.title.my.files" />','${pageContext.request.contextPath}/repository/myFiles.do');
		});
		$('#btnProjectsDocument').click(function(){
			top.openUrl('<bean:message key="common.layout.title.my.projects" />','${pageContext.request.contextPath}/repository/myProjects.do');
		});
		$('#btnMyRecycleBin').click(function(){
			top.openUrl('<bean:message key="common.layout.title.my.recycle.bin" />','${pageContext.request.contextPath}/repository/myRecycleBin.do');
		});
		</c:if>
		<c:if test="${cs.account.resource.id ne cs.account.resource.ownResourceId}">
		$('#btnMyDocument').click(function(){
			top.$.messager.alert('<bean:message key="common.error" />',
			'<bean:message key="common.message.account.not.active" />');
		});
		$('#btnMyRecycleBin').click(function(){
			top.$.messager.alert('<bean:message key="common.error" />',
			'<bean:message key="common.message.account.not.active" />');
		});
		$('#btnProjectsDocument').click(function(){
			top.$.messager.alert('<bean:message key="common.error" />',
			'<bean:message key="common.message.account.not.active" />');
		});
		</c:if>
	});
</script>

<div id="btnGrpOthersDetails" style="width:80px">
	<div id="btnLogout"><bean:message key='common.header.logout' /></div>
	<div id="btnAbout"><bean:message key='common.header.about' /></div>
</div>
<div id="btnMyRepositories" style="width:120px">
	<div id="btnMyDocument"><bean:message key='memu.item.my.files' /></div>
	<div id="btnMyRecycleBin"><bean:message key='memu.item.my.recycle.bin' /></div>
	<div id="btnProjectsDocument"><bean:message key='memu.item.my.projects' /></div>
</div>

<table width="100%" height="65px" style="background:#3a6ea5 url(global/images/ncs.jpg) no-repeat fixed 0 0;">
	<tr>
		<td align="right" valign="bottom">
			<table>
				<tr>
					<td><a id="btnGrpMyRepositories" href="#"><bean:message key="common.header.my.repositories" /></a></td>
					<td><a id="btnGrpOthers" href="#"><bean:message key="common.header.others" /></a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>