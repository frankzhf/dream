<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script src='${pageContext.request.contextPath}/dwr/interface/queryAjax.js'></script>

<script type="text/javascript">
	function addACL() {
		var windowWidth = $(window).width();
		var windowHeight = $(window).height();
		var _closeDialog = function(){
			var _tab = $("#tabInfo").tabs('getSelected');
			_tab.panel('refresh','${pageContext.request.contextPath}/core/listAcl.do?acl.resourceId=${acl.resourceId}');
			top.$('#dialogDiv').window('close');
		};
		top.$('#dialogDiv').dialog({
			title : '<bean:message  key="core.acl.dialog.title" />',
			width : 650,
			height : 430,
			modal : true,
			content : '<iframe id="aclDialogIframe" frameborder="0" src="${pageContext.request.contextPath}/core/dialogAcl.do" style="width:100%;height:100%;"></iframe>',
			buttons : [{
				text : '<bean:message key="common.ok"/>',
				handler : function (){
					top.$("#aclDialogIframe")[0].contentWindow.
						$("#detailsIframe")[0].contentWindow.
						$("#errorMessage").html("");
					if(top.$("#aclDialogIframe")[0].contentWindow.$("#navigation")[0].contentWindow.tree.getSelected() !=null){
						var selectedResourceId = top.$("#aclDialogIframe")[0].contentWindow.$("#navigation")[0].contentWindow.tree.getSelected().getId();
						queryAjax.checkTypeId(selectedResourceId,function(resourceTypeId){
							if(resourceTypeId==5 || resourceTypeId==6 ){
								var _permission = 0;
								if(top.$("#aclDialogIframe")[0].contentWindow.
										$("#detailsIframe")[0].contentWindow.$("#r").attr("checked")){
									_permission = 4;
								}
								if(top.$("#aclDialogIframe")[0].contentWindow.
										$("#detailsIframe")[0].contentWindow.$("#w").attr("checked")){
									_permission+= 2;
								}
								if(top.$("#aclDialogIframe")[0].contentWindow.
										$("#detailsIframe")[0].contentWindow.$("#x").attr("checked")){
									_permission+= 1;
								}
								if(_permission == 0){
									top.$("#aclDialogIframe")[0].contentWindow.
									$("#detailsIframe")[0].contentWindow.
									$("#errorMessage").html("<font color='red'><bean:message key='core.acl.dialog.message.permission.required' /></font>");	
								}else{
									aclAjax.addAcl(${acl.resourceId},selectedResourceId,_permission,function(flag){
										_closeDialog();
									});
								}
							}else{
								top.$("#aclDialogIframe")[0].contentWindow.
								$("#detailsIframe")[0].contentWindow.
								$("#errorMessage").html("<font color='red'><bean:message key='core.acl.dialog.message.own.id.required' /></font>");
							}
						});
					}else{
						top.$("#aclDialogIframe")[0].contentWindow.
							$("#detailsIframe")[0].contentWindow.
							$("#errorMessage").html("<font color='red'><bean:message key='core.acl.dialog.message.own.id.required' /></font>");
					}
				}
			},{
				text : '<bean:message key="common.cancel"/>',
				handler : _closeDialog
			}]
		});
	}
	function editACL(aclId) {
		var windowWidth = $(window).width();
		var windowHeight = $(window).height();
		var _closeDialog = function(){
			var _tab = $("#tabInfo").tabs('getSelected');
			_tab.panel('refresh','${pageContext.request.contextPath}/core/listAcl.do?acl.resourceId=${acl.resourceId}');
			top.$('#dialogDiv').window('close');
		};
		top.$('#dialogDiv').dialog({
			title : '<bean:message  key="core.acl.dialog.title" />',
			width : 650,
			height : 430,
			modal : true,
			content : '<iframe id="aclDialogIframe" frameborder="0" src="${pageContext.request.contextPath}/core/dialogAcl.do?acl.id='+aclId+'" style="width:100%;height:100%;"></iframe>',
			buttons : [{
				text : '<bean:message key="common.ok"/>',
				handler : function (){
					top.$("#aclDialogIframe")[0].contentWindow.
						$("#detailsIframe")[0].contentWindow.
						$("#errorMessage").html("");
					var selectedResourceId = top.$("#aclDialogIframe")[0].contentWindow.$("#navigation")[0].contentWindow.tree.getSelected().getId();
					queryAjax.checkTypeId(selectedResourceId,function(resourceTypeId){
						if(resourceTypeId==5 || resourceTypeId==6 ){
							var _permission = 0;
							if(top.$("#aclDialogIframe")[0].contentWindow.
									$("#detailsIframe")[0].contentWindow.$("#r").attr("checked")){
								_permission = 4;
							}
							if(top.$("#aclDialogIframe")[0].contentWindow.
									$("#detailsIframe")[0].contentWindow.$("#w").attr("checked")){
								_permission+= 2;
							}
							if(top.$("#aclDialogIframe")[0].contentWindow.
									$("#detailsIframe")[0].contentWindow.$("#x").attr("checked")){
								_permission+= 1;
							}
							if(_permission == 0){
								top.$("#aclDialogIframe")[0].contentWindow.
								$("#detailsIframe")[0].contentWindow.
								$("#errorMessage").html("<font color='red'><bean:message key='core.acl.dialog.message.permission.required' /></font>");	
							}else{
								aclAjax.updateAcl(aclId,${acl.resourceId},selectedResourceId,_permission,function(flag){
									_closeDialog();
								});
							}
						}else{
							top.$("#aclDialogIframe")[0].contentWindow.
							$("#detailsIframe")[0].contentWindow.
							$("#errorMessage").html("<font color='red'><bean:message key='core.acl.dialog.message.own.id.required' /></font>");
						}
					});
				}
			},{
				text : '<bean:message key="common.cancel"/>',
				handler : _closeDialog	
			}]
		});
	}
	function deleteACL(aclId) {
		var funDeleteAcl = function(){
			aclAjax.deleteAcl(aclId,function(flag){
				if(flag == 0){		
					top.$('#confirmDiv').window('close');
					var _tab = $("#tabInfo").tabs('getSelected');
					_tab.panel('refresh','${pageContext.request.contextPath}/core/listAcl.do?acl.resourceId=${acl.resourceId}');
				}
			});
		}
		top.confirm("<bean:message key='common.warning' />",
				"<bean:message key='core.acl.message.delete.confirm' />",
				funDeleteAcl, null);
	}
</script>
<table width="100%" class="listTable">
	<tr>
		<th width="2%">&nbsp;</th>
		<th width="30%"><bean:message key="core.acl.own" /></th>
		<th width="10%"><bean:message key="core.acl.read" /></th>
		<th width="10%"><bean:message key="core.acl.write" /></th>
		<th width="10%"><bean:message key="core.acl.run" /></th>
		<th><bean:message key="core.acl.operate" /></th>
	</tr>
	<c:if test="${!empty aclListInfo}">
		<c:forEach items="${aclListInfo}" var="aclitem" varStatus="loop">
			<fk:resource var="own" resourceId="${aclitem.ownId}" />
			<tr class="${loop.index %2 == 0? 'oddRow' :'evenRow'}">
				<td>&nbsp;</td>
				<c:if test="${own.typeId eq 5}">
					<td>${own.object.loginName}</td>
				</c:if>
				<c:if test="${own.typeId ne 5}">
					<td>${own.object.groupName}</td>
				</c:if>
				<c:if
					test="${aclitem.permission eq 7 || aclitem.permission eq 4||aclitem.permission eq 5 || aclitem.permission eq 6}">
					<td><bean:message key="common.yes" />&nbsp;</td>
				</c:if>
				<c:if
					test="${!(aclitem.permission eq 7 || aclitem.permission eq 4||aclitem.permission eq 5 || aclitem.permission eq 6)}">
					<td><bean:message key="common.no" />&nbsp;</td>
				</c:if>
				<c:if
					test="${aclitem.permission eq 7 || aclitem.permission eq 2||aclitem.permission eq 3 || aclitem.permission eq 6}">
					<td><bean:message key="common.yes" />&nbsp;</td>
				</c:if>
				<c:if
					test="${!(aclitem.permission eq 7 || aclitem.permission eq 2||aclitem.permission eq 3 || aclitem.permission eq 6)}">
					<td><bean:message key="common.no" />&nbsp;</td>
				</c:if>
				<c:if
					test="${aclitem.permission eq 7 || aclitem.permission eq 1||aclitem.permission eq 3 || aclitem.permission eq 5}">
					<td><bean:message key="common.yes" />&nbsp;</td>
				</c:if>
				<c:if
					test="${!(aclitem.permission eq 7 || aclitem.permission eq 1||aclitem.permission eq 3 || aclitem.permission eq 5)}">
					<td><bean:message key="common.no" />&nbsp;</td>
				</c:if>
				<td><fk:hasPermission permission="write"
						resourceId="${acl.resourceId}">
						<a href="#" onclick="editACL(${aclitem.id})"><bean:message
								key="core.acl.operate.edit" /> &nbsp;</a>
						<a href="#" onclick="deleteACL(${aclitem.id})"><bean:message
								key="core.acl.operate.delete" /> &nbsp;</a>
					</fk:hasPermission>&nbsp;</td>
			</tr>
		</c:forEach>
		<fk:hasPermission permission="write" resourceId="${acl.resourceId}">
			<tr>
				<td colspan="6" align="right"><a href="#" onclick="addACL()"><bean:message
							key="core.acl.operate.add" /></a></td>
			</tr>
		</fk:hasPermission>
	</c:if>
	<c:if test="${empty aclListInfo}">
		<tr>
			<td colspan="6"><bean:message key="core.not.watch.acl.record" /></td>
		</tr>
		<fk:hasPermission permission="write" resourceId="${acl.resourceId}">
			<tr>
				<td colspan="6" align="right"><a href="#" onclick="addACL()"><bean:message
							key="core.acl.operate.add" /> &nbsp;</a></td>
			</tr>
		</fk:hasPermission>
	</c:if>
</table>