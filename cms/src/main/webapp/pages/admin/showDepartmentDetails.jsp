<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script
	src='${pageContext.request.contextPath}/dwr/interface/adminAjax.js'></script>

<script type="text/javascript">

var _closeDialog = function(){
	top.$('#dialogDiv').window('close');
};

function appointManager(){
	top.$('#dialogDiv').dialog({
		title : '<bean:message  key="admin.show.department.dialog.appoint.manager.title" />',
		width : 650,
		height : 400,
		modal : true,
		content : '<iframe id="managerDialog" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/common/dialogStaffSelector.do"></iframe>',
		buttons : [ {
			text : '<bean:message key="common.ok"/>',
			handler : function (){
				if(top.$("#managerDialog")[0].contentWindow.$.validationForm('#staffName')){
					var rt = top.$("#managerDialog")[0].contentWindow.$("#staffResourceId").val();
					if(rt!=null && rt!=''){
						_closeDialog();
						adminAjax.validateAppointManager(${unit.resource.id},rt,function(flag){
							var funOK = function(){
								adminAjax.appointManager(${unit.resource.id},rt,function(flag){
									var _funOK = function(){
										parent.openUrl(
												'${pageContext.request.contextPath}/admin/showDepartmentDetails.do?resource.id='+ ${unit.resource.id});
									}
									$.processCmsMessage(flag,_funOK);
								});
							};
							var funExist = function(){
								top.confirm("<bean:message key='common.error' />",
										"<bean:message key='admin.navigation.department.errors.staff.has.is.this.unit.manager' />",
										null, null);
							}
							$.processCmsMessage(flag,funOK,null,null,null,null,funExist,null);
						});
					}
				}
			}
		}, {
			text : '<bean:message key="common.cancel"/>',
			handler : _closeDialog
		} ]
	});
	
}

function createUnit(){
	top.$('#dialogDiv').dialog({
		title : '<bean:message  key="admin.show.department.dialog.add.department.title" />',
		width : 450,
		height :150,
		modal : true,
		content : '<iframe id="newDepartmentDialog" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/admin/dialogAddDepartment.do"></iframe>',
		buttons : [ {
			text : '<bean:message key="common.ok"/>',
			handler : function (){
				if(top.$("#newDepartmentDialog")[0].contentWindow.$.validationForm('#departmentName,#departmentCode')){
					_closeDialog();
					var _departmentName =  top.$("#newDepartmentDialog")[0].contentWindow.$("#departmentName").val();
					var _departmentCode =  top.$("#newDepartmentDialog")[0].contentWindow.$("#departmentCode").val();
					adminAjax.validateAddDepartment(${unit.resource.id},_departmentName,_departmentCode,function(flag){
						var funOK = function(){
							adminAjax.addDepartment(${unit.resource.id},_departmentName,_departmentCode,function(flag){
								var _funOK = function(){
									parent.$("#navigation")[0].contentWindow.showInformationDetails(${unit.resource.id});
								}
								$.processCmsMessage(flag,_funOK);
							});
						};
						var funExist = function(){
							top.confirm("<bean:message key='common.error' />",
									"<bean:message key='admin.navigation.department.errors.duplicate.department.name' />",
									null, null);
						}
						var funNotExist = function(){
							top.confirm("<bean:message key='common.error' />",
									"<bean:message key='admin.navigation.department.errors.duplicate.department.code' />",
									null, null);
						}
						$.processCmsMessage(flag,funOK,null,null,null,funNotExist,funExist,null);
					});
				}
			}
		}, {
			text : '<bean:message key="common.cancel"/>',
			handler : _closeDialog
		} ]
	});
}

function groupUnitGroup(groupResId){
	top.$('#dialogDiv').dialog({
		title : '<bean:message  key="admin.show.department.dialog.grant.group" />',
		width : 650,
		height : 400,
		modal : true,
		content : '<iframe id="grantDialog" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/admin/grantUnitGroup.do?resource.id='+groupResId+'"></iframe>',
		buttons : [ {
			text : '<bean:message key="common.close"/>',
			handler : _closeDialog
		} ]
	});
}

$(function() {
	$('#tabInfo').tabs({
	});
});
</script>

<table class="pageContent">
	<tr>
		<td width="15%">&nbsp;</td>
		<td width="34%">&nbsp;</td>
		<td width="15%">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr class="title">
		<td colspan="4"><bean:message
				key="admin.show.department.details.title.department" /></td>
	</tr>
	<tr>
		<td colspan="4"><fk:content2 var="${unit}"
				resourceName="Unit"
				templateName="Unit.html" mode="view" /></td>
	</tr>
	<tr>
		<td colspan="4"><fk:hasPermission permission="write"
				resourceId="${unit.resource.id}">
				<a href="#" class="easyui-linkbutton" onclick="appointManager()"><bean:message
						key='admin.show.department.details.button.appoint.manager' /></a>
			</fk:hasPermission> <fk:resource var="unitChildren" parentResource="${unit.context$3}"
				alias="children" /> <fk:hasPermission permission="write"
				resourceId="${unitChildren.id}">
				<a href="#" class="easyui-linkbutton" onclick="createUnit()"><bean:message
						key='admin.show.department.details.button.add.department' /></a>
			</fk:hasPermission></td>
	</tr>
	<fk:resource var="unitGroupRes" parentResource="${unit.context$3}"
		alias="group" />
	<c:if test="${0 eq unitGroupRes.code}">
		<tr class="title">
			<td colspan="4"><bean:message
					key="admin.show.department.details.title.grant" /></td>
		</tr>
		<tr>
			<td colspan="4">
				<table class="listTable">
					<tr>
						<th width="2%">&nbsp;</th>
						<th width="25%"><bean:message
								key="admin.show.department.details.group.name" /></th>
						<th width="40%"><bean:message
								key="admin.show.department.details.group.desc" /></th>
						<th><bean:message key="admin.show.department.details.operate" /></th>
					</tr>
					<c:forEach items="${unitGroupRes.children}" var="groupRes"
						varStatus="loop">
						<tr>
							<td>&nbsp; <fk:resource var="groupRes"
									resourceId="${groupRes.id}" />
							</td>
							<td>${groupRes.object.groupName}</td>
							<td>${groupRes.object.groupDescirption} &nbsp;</td>
							<td>
							<a href="#"  class="easyui-linkbutton" onclick="groupUnitGroup(${groupRes.id})"> <bean:message
										key="admin.show.department.details.operate.grant" /></a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</c:if>
	<tr class="title">
		<td colspan="4"><bean:message
				key="admin.show.department.details.title.manager" /></td>
	</tr>
</table>
<div id="tabInfo"
	style="position: absolute; padding: 0px 5px; width: 780px; height: 480px">
	<div title="Personal">
		<fk:content2 var="${person}" resourceName="Person"
			templateName="Person.html" mode="view" />
	</div>
	<div title="Staff">
		<fk:content2 var="${staff}" resourceName="Staff"
			templateName="Staff.html" mode="view" />
	</div>
</div>