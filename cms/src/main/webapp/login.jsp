<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html:html>
<head>
<title><bean:message key="welcome.title" /></title>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/themes/icon.css">

<style type="text/css">
* {
	font-size: 12px;
}

body {
	font-family: helvetica, tahoma, verdana, sans-serif;
	padding: 20px;
	font-size: 13px;
	margin: 0;
}
</style>
<script type="text/javascript">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery-common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery-easyui-common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/common.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery.client.js"></script>

<script type="text/javascript">
	
	if (top.location != self.location)
		top.location = self.location;
	$(function() {
		$('#platform').val($.client.os);
		$('#application').val($.client.browser);
		$('#loginWindow').window({
			collapsible : false,
			minimizable : false,
			maximizable : false
		});
		$('#userName').validatebox({   
		    required:true  
		});
		$('#password').validatebox({   
		    required:true  
		});
		
		$("#clearButton").bind('click',function(){
			$("input[type!=hidden]").each(function(){
				$(this).val(GLOBAL_NULL_STRING);
			});
		});
	
	});
	
	function login() {
		if($.validationForm('form[name=loginForm] input[type!=hidden]')){
			$.submitFormWoMsg();
		}
	}
</script>
</head>
<body>
	<div id="loginWindow" class="easyui-window"
		title="<bean:message key='welcome.heading'/>"
		style="width: 450px; height: 240px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<html:form action="/login.do">
					<html:hidden styleId="platform" property="platform"/>
					<html:hidden styleId="application" property="application"/>
					<table width="100%">
						<tr>
							<td width="25%">&nbsp;</td>
							<td width="75%">&nbsp;</td>
						</tr>
						<tr>
							<td><bean:message key="login.user.id" /></td>
							<td><html:text styleId="userName" property="userName"
									maxlength="32" style="width:75%;" /></td>
						</tr>
						<tr>
							<td><bean:message key="login.password" /></td>
							<td><html:password styleId="password" property="password"
									maxlength="32" style="width:75%;" onkeydown="javascripts:checkKey(event,'login()')"/></td>
						</tr>
						<tr>
							<td colspan="2"><font color="red"><html:errors /></font></td>
						</tr>
					</table>
				</html:form>
			</div>
			<div region="south" border="false"
				style="text-align: right; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:void(0)" onclick="login();"><bean:message
						key="common.submit" /></a> <a id="clearButton" class="easyui-linkbutton"
					iconCls="icon-cancel" href="javascript:void(0)"><bean:message
						key="common.clear" /></a>
			</div>
		</div>
	</div>
</body>
</html:html>