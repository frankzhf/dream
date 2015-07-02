<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fk:cs />

<script
	src='${pageContext.request.contextPath}/dwr/interface/repositoryUnitServiceAjax.js'></script>

<script type="text/javascript">
	var _closeDialog = function(){
		top.$('#dialogDiv').window('close');
	};
	function approvalShare(resourceId){
		top.$('#dialogDiv').dialog({
			title : '<bean:message  key="repository.file.list.dialog.title.share.file.project.create" />',
			width : 650,
			height : 430,
			modal : true,
			content : '<iframe id="approveShareDialog" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/repository/dialogApproveShare.do?file.id='+resourceId+'"></iframe>',
			buttons : [{ 
				text : '<bean:message key="common.ok"/>',
				handler : function(){
					var messageDiv = top.$('#approveShareDialog')[0].contentWindow.$("#detailsIframe")[0].contentWindow.$('#errorMessage');
					messageDiv.empty();
					var moveToResource = top.$('#approveShareDialog')[0].contentWindow.$("#navigation")[0].contentWindow.tree.getSelected();
					if(moveToResource == null){
						messageDiv.html("<font color='red'><bean:message key='repository.pending.unit.approve.error.move.to.empty' /></font>");
						return;
					}else{
						var moveToResourceId = moveToResource.getId();
						repositoryUnitServiceAjax.valiationApprovalShare(resourceId,moveToResourceId,function(flag){
							var funOK = function(){
								repositoryUnitServiceAjax.approvalShare(resourceId,moveToResourceId,function(flag){
									var funOK2 = function (){
										_closeDialog();
										parent.openUrl(
												'${pageContext.request.contextPath}/repository/pendingForUnit.do?folder.id='+ ${folder.id});
									}
									$.processCmsMessage(flag,funOK2);
								});
							};
							var funExist = function(){
								messageDiv.html("<font color='red'><bean:message key='repository.pending.unit.approve.error.move.to.same.file.exits' /></font>");
							}
							var funNotExist = function(){
								messageDiv.html("<font color='red'><bean:message key='repository.pending.unit.approve.error.move.to.not.repository.root' /></font>");
							}
							$.processCmsMessage(flag,funOK,null,null,null,funNotExist,funExist,null);
						});
					}	
				}
			},{
				text : '<bean:message key="common.close"/>',
				handler : _closeDialog
			}]
		});
	}
	 
	function approvalShare2(resourceId){
		top.$('#dialogDiv').dialog({
			title : '<bean:message  key="repository.file.list.dialog.title.share.file.project.remvoe" />',
			width : 650,
			height : 430,
			modal : true,
			content : '<iframe id="approveShareDialog" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/repository/dialogApproveShare2.do?file.id='+resourceId+'"></iframe>',
			buttons : [{ 
				text : '<bean:message key="common.ok"/>',
				handler : function(){
					repositoryUnitServiceAjax.approvalShare(resourceId,null,function(flag){
						var funOK2 = function (){
							_closeDialog();
							parent.openUrl(
									'${pageContext.request.contextPath}/repository/pendingForUnit.do?folder.id='+ ${folder.id});
						}
						$.processCmsMessage(flag,funOK2);
					});
				}
			},{
				text : '<bean:message key="common.close"/>',
				handler : _closeDialog
			}]
		});
	}
	 
	 
	 function rejectShare(resourceId){
		 var confirmOK = function(){
			repositoryUnitServiceAjax.rejectShare(resourceId,function(flag){
				var funOK = function(){
					parent.openUrl(
						'${pageContext.request.contextPath}/repository/pendingForUnit.do?folder.id='+ ${folder.id});
				};
				$.processCmsMessage(flag,funOK,null,null,null,null);
			});
			top.$('#confirmDiv').window('close');
		}
		top.confirm("<bean:message key='common.warning' />",
				"<bean:message key='repository.pending.unit.confirm.reject.share' />",
				confirmOK, null);
	 }
</script>
<table width="100%" class="listTable">
	<tr>
		<th width="35%"><bean:message key="repostiory.pending.unit.file.name" /></th>
		<th width="15%"><bean:message
				key="repostiory.pending.unit.applicant" /></th>
		<th width="20%"><bean:message
				key="repostiory.pending.unit.create.time" /></th>
		<th><bean:message key="repository.pending.unit.operate" /></th>
	</tr>
	<c:set var="fileCount" value="0" />
	<c:if test="${!empty folder.children}">
		<c:forEach items="${folder.children}" var="item" varStatus="loop">
			<fk:resource var="item" resourceId="${item.id}"/>
			<c:if test="${item.code eq 0 && item.typeId eq 38 && item.ownResourceId ne cs.account.resource.id}">
			<fk:resource var="file" resourceId="${item.object.file$50000.id}" cs="${su}"/>
			<fk:resource var="own" resourceId="${item.ownResourceId}" cs="${su}"/>
			<fk:resource var="staff" resourceId="${own.object.staff$19.id}" cs="${su}"/>
			<fk:resource var="person" resourceId="${staff.object.person$18.id}" cs="${su}"/>
	<tr>
		<td>${file.object.fileName}</td>
		<td>${person.object.englishName}</td>
		<td><fmt:formatDate value="${item.createdDt}" pattern="dd/MM/yyyy HH:mm:ss"/> </td>
		<td>
			<a href="${pageContext.request.contextPath}/attachment?resourceId=${file.id}">
				<bean:message key='repository.pending.unit.download' />
			</a>&nbsp;
			<c:if test="${item.object.action eq 'C'}">
			<a href="#" onclick="approvalShare(${item.id})">
			</c:if>
			<c:if test="${item.object.action eq 'D'}">
			<a href="#" onclick="approvalShare2(${item.id})">
			</c:if>
				<bean:message key='repository.pending.unit.approval' />
			</a>&nbsp;
			<a href="#"  onclick="rejectShare(${item.id})">
				<bean:message key='repository.pending.unit.reject' />
			</a>&nbsp;
		</td>
	</tr>
				<c:set var="fileCount" value="${fileCount + 1}" />
			</c:if>
		</c:forEach>
	</c:if>
	<c:if test="${fileCount eq 0}">
	<tr>
		<td colspan="4"><bean:message
						key="common.message.no.match.records" /></td>
	</tr>
	</c:if>
</table>