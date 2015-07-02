<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fk:cs />
<fk:resource var="curentAccountHome" resourceId="${cs.account.home$3.id}" />
<fk:resource var="curentAccountMyDocument" parentResource="${curentAccountHome}" alias="myDocument" />

<script
	src='${pageContext.request.contextPath}/dwr/interface/repositoryServiceAjax.js'></script>

<script type="text/javascript">
$(function() {
	$("#uploadFileName").validatebox({   
	    required:true,
	    validType:"limitFileMaxSize[uploadFileName]"
	});
});

function doUploadFile(){
	if($("#uploadFileName").validatebox('isValid')){
		$("#btnUpdateFile").attr("disabled","disabled");
		$.submitFormWoMsg();
	}
}

function doDeleteFile(resourceId){
	var confirmOK = function(){
		repositoryServiceAjax.deleteFile(resourceId,function(flag){
			var funOK = function(){
				parent.openUrl(
						'${pageContext.request.contextPath}/repository/listMyFiles.do?folder.id='+ ${folder.id});
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
					repositoryServiceAjax.createFolder(${folder.id},folderName,function(flag){
						var funOK = function(){
							repositoryServiceAjax.getResource(${folder.id},folderName,function(returnValue){
								var addTreeNode = function(){
									parent.$("#navigation")[0].contentWindow.addTreeNode(${folder.id},returnValue);
								}
								$.processCmsMessage(returnValue.code,addTreeNode);
							});
						};
						$.processCmsMessage(flag,funOK);
					});
				}
			}
		}, {
			text : '<bean:message key="common.cancel"/>',
			handler : _closeDialog
		} ]
	});
}

function doRenameFile(resourceId){
	var _closeDialog = function(){
		top.$('#dialogNewFileName').validatebox('destroy')
		top.$('#dialogDiv').window('close');
	};
	top.$('#dialogDiv').dialog({
		title : '<bean:message  key="repository.file.list.dialog.title.rename.file" />',
		width : 300,
		height : 150,
		modal : true,
		content : '<br><bean:message  key="repository.file.list.dialog.new.file.name" /> <bean:message  key="common.colon" /> &nbsp;&nbsp; <input type="text" id="dialogNewFileName"><script>$(function() {$("#dialogNewFileName").validatebox({required:true});});<\/script\>',
		buttons : [ {
			text : '<bean:message key="common.ok"/>',
			handler : function (){
				if(top.$('#dialogNewFileName').validatebox('isValid')){
					var newFileName = top.$('#dialogNewFileName').val();
					_closeDialog();
					repositoryServiceAjax.renameFile(resourceId,newFileName,function(flag){
						var funOK = function(){
							parent.openUrl(
									'${pageContext.request.contextPath}/repository/listMyFiles.do?folder.id='+ ${folder.id});
						};
						var funExist = function(){
							top.confirm("<bean:message key='common.error' />",
									"<bean:message key='repository.errors.rename.file.exists' />",
									null, null);
						}
						$.processCmsMessage(flag,funOK,null,null,null,null,funExist,null);
					});
				}
			}
		}, {
			text : '<bean:message key="common.cancel"/>',
			handler : _closeDialog
		} ]
	});
}

function doSharedFile(resourceId){
	var _closeDialog = function(){
		top.$('#dialogDiv').window('close');
	}
	top.$('#dialogDiv').dialog({
		title : '<bean:message  key="repository.file.list.dialog.title.share.file.person" />',
		width : 650,
		height : 400,
		modal : true,
		content : '<iframe id="grantDialog" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/repository/shareFile.do?file.id='+resourceId+'"></iframe>',
		buttons : [ {
			text : '<bean:message key="common.close"/>',
			handler : _closeDialog
		} ]
	});
}

function doSharedProjectFile(resourceId){
	var _closeDialog = function(){
		top.$('#dialogDiv').window('close');
	}
	top.$('#dialogDiv').dialog({
		title : '<bean:message  key="repository.file.list.dialog.title.share.file.project" />',
		width : 480,
		height : 250,
		modal : true,
		content : '<iframe id="shareProjectDialog" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/repository/shareFileToProject.do"></iframe>',
		buttons : [{ 
			text : '<bean:message key="common.ok"/>',
			handler : function(){
				var unitRes = top.$("#shareProjectDialog")[0].contentWindow.$("#unit").combobox('getValue');
				var desc = top.$("#shareProjectDialog")[0].contentWindow.$("#text").val();
				var clone = top.$("#shareProjectDialog")[0].contentWindow.$("#cloneFlag").is(":checked");
				repositoryServiceAjax.validateShareFileToProject(resourceId,desc,unitRes,function(flag){
					var funRun = function(){
						top.confirm("<bean:message key='common.error' />",
								"<bean:message key='repository.errors.share.file.project.unit.cannot.empty' />",
								null, null);
					};
					var funRead = function(){
						top.confirm("<bean:message key='common.error' />",
								"<bean:message key='repository.errors.share.file.project.desc.cannot.empty' />",
								null, null);
					};
					var funExit = function(){
						top.confirm("<bean:message key='common.error' />",
								"<bean:message key='repository.errors.share.file.project.same.file.exists' />",
								null, null);
					}
					var funOK = function(){
						_closeDialog();
						repositoryServiceAjax.shareFileToProject(resourceId,unitRes,desc,clone,function(flag){
							var _funOK = function(){
								parent.openUrl(
										'${pageContext.request.contextPath}/repository/listMyFiles.do?folder.id='+ ${folder.id});
							}
							$.processCmsMessage(flag,_funOK,null,null,null,null,null,null);
						});
					};
					$.processCmsMessage(flag,funOK,funRead,null,funRun,null,funExit,null);
				});
			}
		},{
			text : '<bean:message key="common.close"/>',
			handler : _closeDialog
		}]
	});
}


function doRenameFolder(){
	var _closeDialog = function(){
		top.$('#dialogRenameFolderName').validatebox('destroy')
		top.$('#dialogDiv').window('close');
	};
	top.$('#dialogDiv').dialog({
		title : '<bean:message  key="repository.file.list.dialog.title.rename.folder" />',
		width : 300,
		height : 150,
		modal : true,
		content : '<br><bean:message  key="repository.file.list.dialog.rename.folder.name" /> <bean:message  key="common.colon" /> &nbsp;&nbsp; <input type="text" id="dialogRenameFolderName"><script>$(function() {$("#dialogRenameFolderName").validatebox({required:true});});<\/script\>',
		buttons : [ {
			text : '<bean:message key="common.ok"/>',
			handler : function (){
				if(top.$('#dialogRenameFolderName').validatebox('isValid')){
					var newFolderName = top.$('#dialogRenameFolderName').val();
					_closeDialog();
					repositoryServiceAjax.renameFolder(${folder.id},newFolderName,function(flag){
						var funOK = function(){
							parent.$("#navigation")[0].contentWindow.updateTreeNodeName(${folder.id},newFolderName);
						};
						var funExist = function(){
							top.confirm("<bean:message key='common.error' />",
									"<bean:message key='repository.errors.rename.folder.exists' />",
									null, null);
						}
						$.processCmsMessage(flag,funOK,null,null,null,null,funExist,null);
					});
				}
			}
		}, {
			text : '<bean:message key="common.cancel"/>',
			handler : _closeDialog
		} ]
	});
}

function doRemoveFolder(){
	var confirmOK = function(){
		repositoryServiceAjax.getResource2(${folder.id},function(resource){
			var funOK = function(){
				var parentId = resource.parentId;
				repositoryServiceAjax.deleteFolder(${folder.id},function(flag){
					var gotoParent = function(){
						parent.$("#navigation")[0].contentWindow.deleteTreeNode(${folder.id});
						parent.openUrl(
								'${pageContext.request.contextPath}/repository/listMyFiles.do?folder.id='+ parentId);
					};
					var funExist = function(){
						top.confirm("<bean:message key='common.error' />",
								"<bean:message key='repository.errors.delete.folder.name.exists.recycle' />",
								null, null);
					}
					$.processCmsMessage(flag,gotoParent,null,null,null,null,funExist);
				});
			};
			$.processCmsMessage(resource.code,funOK);
		});
		top.$('#confirmDiv').window('close');
	};
	top.confirm("<bean:message key='common.warning' />",
			"<bean:message key='repository.warning.delete.folder' />",
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
						<td><a href="${pageContext.request.contextPath}/attachment?resourceId=${file.id}"><bean:message
									key='repository.file.list.download' /></a>
							<a href="#" onclick="doRenameFile(${file.id})"><bean:message
									key='repository.file.list.rename.file' /></a>
							<a href="#" onclick="doDeleteFile(${file.id})"><bean:message
									key='repository.file.list.delete.file' /></a>
							<a href="#" onclick="doSharedFile(${file.id})"><bean:message
									key='repository.file.list.shared.file.person' /></a>
							<a href="#" onclick="doSharedProjectFile(${file.id})"><bean:message
									key='repository.file.list.shared.file.project' /></a>
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
	<br>

	<a href="#" class="easyui-linkbutton" onclick="doCreateFolder()"><bean:message
			key='repository.file.list.create.folder' /> </a> &nbsp;
	<c:if test="${curentAccountMyDocument.id ne folder.id}">
	<a href="#" class="easyui-linkbutton" onclick="doRenameFolder()"><bean:message
			key='repository.file.list.rename.folder' /> </a> &nbsp;
	<a href="#" class="easyui-linkbutton" onclick="doRemoveFolder()"><bean:message
			key='repository.file.list.delete.folder' /> </a> &nbsp;
	</c:if>
	<br>
	<br>
	<html:file property="uploadFile" styleId="uploadFileName" />
	<a href="#" id="btnUpdateFile" class="easyui-linkbutton" onclick="doUploadFile()"><bean:message
			key='repository.file.list.upload' /> </a>
	<br>
	<div id="uploadFileError"></div>
</html:form>
</div>