<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags/cms" prefix="cms" %>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/dialog.js"></script>
<fk:cs />

<script>
	$(function(){
		$("input[name^='permission(']").each(function(){
			$(this).attr("disabled",true);
		});
		
		$('#resourceFullPath').validatebox({   
		    required:true  
		});
		
		$("#buuton_dialogSelector_account").attr("disabled",true);
		$("#buuton_dialogSelector_group").attr("disabled",true);
		
		$('#chagePermissionFlag').click(function(){
			if("checked" == $(this).attr("checked")){
				$("input[name^='permission(']").each(function(){
					$(this).attr("checked",null);
					$(this).attr("disabled",false);
				});
			}else{
				$("input[name^='permission(']").each(function(){
					$(this).attr("checked",null);
					$(this).attr("disabled",true);
				});
			}
		});
		$('#chageOwnFlag').click(function(){
			if("checked" == $(this).attr("checked")){
				$("#buuton_dialogSelector_account").attr("disabled",false);
			}else{
				$("#buuton_dialogSelector_account").attr("disabled",true);
			}
		});
		$('#chageGroupFlag').click(function(){
			if("checked" == $(this).attr("checked")){
				$("#buuton_dialogSelector_group").attr("disabled",false);
			}else{
				$("#buuton_dialogSelector_group").attr("disabled",true);
			}
		});	
	});
	
	function changePermission(){
		if(!$('#chagePermissionFlag').attr("checked") &&
				!$('#chageOwnFlag').attr("checked")&&
				!$('#chageGroupFlag').attr("checked")){
			top.$.messager.alert('<bean:message key="common.warning" />','<bean:message key="core.permission.least.one.option" />');
			return;
		}
		if($.validationForm('form[name=permissionForm] input[type!=hidden]')){
			$.submitFormWoMsg();	
		}
	}
</script>

<html:form action="/submitPermission">
	<input type="hidden" id="ownResourceId" name="ownResourceId" value="${cs.account.resource.id}">
	<input type="hidden" id="groupResourceId" name="groupResourceId" value="${cs.currentGroup.resource.id}">	
	<table style="width: 100%">
		<tr>
			<td width="20%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><bean:message key="core.permission.resource.path" />
			</td>
			<td><input type="text" id="resourceFullPath" name="resourceFullPath" style="width:70%" /> 
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="checkbox" id="chagePermissionFlag" name="chagePermissionFlag" value="true">
				<bean:message key="core.permission.change.permission" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table width="100%" class="listTable">
					<tr>
						<th width="20%">&nbsp;</th>
						<th width="25%"><bean:message key="common.read" /></th>
						<th width="25%"><bean:message key="common.write" /></th>
						<th><bean:message key="common.run" /></th>
					</tr>
					<tr class="oddRow">
						<td><bean:message key="common.current.user" /></td>
						<td><input type="checkbox" id="permission(0)" name="permission(0)" value="true"></td>
						<td><input type="checkbox" id="permission(1)" name="permission(1)" value="true"></td>
						<td><input type="checkbox" id="permission(2)" name="permission(2)" value="true"></td>
					</tr>
					<tr class="evenRow">
						<td><bean:message key="common.current.group" /></td>
						<td><input type="checkbox" id="permission(3)" name="permission(3)" value="true"></td>
						<td><input type="checkbox" id="permission(4)" name="permission(4)" value="true"></td>
						<td><input type="checkbox" id="permission(5)" name="permission(5)" value="true"></td>
					</tr>
					<tr class="oddRow">
						<td><bean:message key="common.others" /></td>
						<td><input type="checkbox" id="permission(6)" name="permission(6)" value="true"></td>
						<td><input type="checkbox" id="permission(7)" name="permission(7)" value="true"></td>
						<td><input type="checkbox" id="permission(8)" name="permission(8)" value="true"></td>
					</tr>
					
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="checkbox" id="chageOwnFlag" name="chageOwnFlag" value="true">
				<bean:message key="core.permission.chnage.own" />
			</td>
		</tr>
		<tr>
			<td><bean:message key="common.own" /></td>
			<td>
				<cms:account mode="edit" target="ownResourceId" elementId="dialog_ownResourceId" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="checkbox" id="chageGroupFlag" name="chageGroupFlag" value="true">
				<bean:message key="core.permission.change.group" />
			</td>
		</tr>
		<tr>
			<td><bean:message key="common.own.group" /></td>
			<td>
				<cms:group mode="edit" target="groupResourceId" elementId="dialog_groupResourceId"  />
			</td>
		</tr>
		<tr>
			<td><bean:message key="core.permission.recursive" />
			</td>
			<td><input type="checkbox" id="recursive" name="recursive" value="true">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="<bean:message key='common.submit' />" onclick="changePermission()">
			</td>
		</tr>
	</table>
</html:form>