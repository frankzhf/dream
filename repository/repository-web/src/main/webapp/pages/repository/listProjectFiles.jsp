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
function directPendingPage(resourceId){
	parent.openUrl(
		'${pageContext.request.contextPath}/repository/pendingForUnit.do?folder.id='+ resourceId);
}

function directArchivePage(resourceId){
	/***
	parent.openUrl(
			'${pageContext.request.contextPath}/repository/archiveForUnit.do?folder.id='+ resourceId);
	***/
	top.confirm("<bean:message key='common.warning' />",
			"<bean:message key='common.message.not.implements' />",
			null, null);
}

function doCreateFolder(){
	var _closeDialog = function(){
		top.$('#dialogFolderName').validatebox('destroy')
		top.$('#dialogDiv').window('close');
	};
	top.$('#dialogDiv').dialog({
		title : '<bean:message  key="repository.file.list.dialog.title.create.folder" />',
		width : 300,
		height : 150,
		modal : true,
		content : '<br><bean:message  key="repository.file.list.dialog.folder.name" /> <bean:message  key="common.colon" /> &nbsp;&nbsp; <input type="text" id="dialogFolderName"><script>$(function() {$("#dialogFolderName").validatebox({required:true});});<\/script\>',
		buttons : [ {
			text : '<bean:message key="common.ok"/>',
			handler : function (){
				if(top.$('#dialogFolderName').validatebox('isValid')){
					var folderName = top.$('#dialogFolderName').val();
					_closeDialog();
					repositoryUnitServiceAjax.createFolder(${folder.id},folderName,function(flag){
						var funOK = function(){
							parent.$("#navigation")[0].contentWindow.showInformationDetails(${folder.id});
						};
						var funExists = function(){
							top.confirm("<bean:message key='common.error' />",
									"<bean:message key='repository.errors.rename.file.exists' />",
									null, null);
						}
						var funNotExists = function(){
							top.confirm("<bean:message key='common.error' />",
									"<bean:message key='repository.pending.unit.approve.error.move.to.not.repository.root' />",
									null, null);
							
						};
						//processCmsMessage : function(message,ok,read,write,run,notExists,exists,unknown){
						$.processCmsMessage(flag,funOK,null,null,null,funNotExists,funExists,null);
					});
				}
			}
		}, {
			text : '<bean:message key="common.cancel"/>',
			handler : _closeDialog
		} ]
	});
}

function doDeleteFile(resourceId,fileName){
	var confirmOK = function(){
		repositoryUnitServiceAjax.deleteFile(resourceId,'Delete File:' + fileName,function(flag){
			var funOK = function(){
				parent.openUrl(
						'${pageContext.request.contextPath}/repository/listProjectFiles.do?folder.id='+ ${folder.id});
			};
			var funExist = function(){
				top.confirm("<bean:message key='common.error' />",
						"<bean:message key='repository.errors.delete.file.name.exists.recycle' />",
						null, null);
			}
			$.processCmsMessage(flag,funOK,null,null,null,funExist);
		});
		top.$('#confirmDiv').window('close');
	}
	top.confirm("<bean:message key='common.warning' />",
			"<bean:message key='repository.warning.delete.file' />",
			confirmOK, null);
}

</script>

<html:form action="/uploadFile.do" enctype="multipart/form-data">
	<html:hidden property="folder.id" value="${folder.id}"
		styleId="folder_id" />
	<html:hidden property="file.id" value="${file.id}" styleId="file_id" />
	<table width="100%" class="listTable">
		<tr>
			<th width="35%"><bean:message key="repository.file.list.name" /></th>
			<th width="15%"><bean:message
					key="repository.file.list.modify.time" /></th>
			<th width="20%"><bean:message
					key="repository.file.list.file.size" /></th>
			<th><bean:message key="repository.file.list.operate" /></th>
		</tr>
		<c:set var="fileCount" value="0" />
		<c:if test="${!empty folder.children}">
			<c:forEach items="${folder.children}" var="file" varStatus="loop">
				<fk:resource var="file" resourceId="${file.id}" />
				<c:if test="${file.typeId eq 50000}">
					<tr>
						<td>${file.object.fileName}</td>
						<td><fmt:formatDate value="${file.lastUpdatedDt}"
								pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td align="right">${file.object.length}</td>
						<td>
							<a href="${pageContext.request.contextPath}/attachment?resourceId=${file.id}"><bean:message
									key='repository.file.list.download' /></a> &nbsp;
							<c:if test="${isPublisher}">
								<a href="#" onclick="doDeleteFile(${file.id},'${file.object.fileName}')"><bean:message
									key='repository.file.list.delete.file' /></a>&nbsp;
							</c:if>
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
	<br /> 
	<fk:hasPermission permission="write" 
		resourceId="${folder.id}">
	<a href="#" class="easyui-linkbutton" onclick="doCreateFolder()"><bean:message
			key='repository.file.list.create.folder' /> </a> &nbsp;
	</fk:hasPermission>
	<br />
	<br />
	<c:if test="${isPublisher}">
	<a href="#" class="easyui-linkbutton" onclick="directPendingPage(${publisherFolder.id})"><bean:message
			key='repository.file.list.pending.file' /> </a> &nbsp;
	</c:if>
</html:form>
</div>