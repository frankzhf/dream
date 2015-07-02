<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fk:cs />

<script
	src='${pageContext.request.contextPath}/dwr/interface/repositoryServiceAjax.js'></script>

<script type="text/javascript">
function deleteItem(itemId){
	var executeFun = function(){
		repositoryServiceAjax.deleteItem(itemId,function(flag){
			var funOK = function(){
				parent.openUrl(
						'<bean:message key="common.layout.title.my.recycle.bin" />',
						'${pageContext.request.contextPath}/repository/myRecycleBin.do');
			};
			$.processCmsMessage(flag,funOK);
		});
		top.$('#confirmDiv').window('close');
	};
	top.confirm("<bean:message key='common.warning' />",
			"<bean:message key='repository.warning.delete.file' />",
			executeFun, null);
	
}

function restoreItem(itemId){
	var _closeDialog = function(){
		top.$('#dialogDiv').window('close');
	};
	
	top.$('#dialogDiv').dialog({
		title : '<bean:message key="repository.recycle.bin.dialog.restore.folder" />',
		width : 300,
		height : 440,
		modal : true,
		content : '<iframe id="navigationDialog" style="width:100%;height:100%;" frameborder="0" src="${pageContext.request.contextPath}/repository/dialogMyDocumentTree.do"></iframe>',
		buttons : [{ 
			text : '<bean:message key="common.ok"/>',
			handler : function(){
				var selectedTreeNode = top.$("#navigationDialog")[0].contentWindow.tree.getSelected();
				var messageDiv = top.$("#navigationDialog")[0].contentWindow.document.getElementById("messageDiv");
				messageDiv.innerHTML='';
				if(selectedTreeNode == null){
					// unselected any note
					messageDiv.innerHTML='<font color="red"><bean:message key="repository.errors.restore.should.be.select.folder" /></font>';
				}else{
					if(selectedTreeNode.id == 0){
						//select is myReceived
						messageDiv.innerHTML='<font color="red"><bean:message key="repository.errors.restore.should.not.my.received" /></font>';
					}else{
						repositoryServiceAjax.restoreItem(selectedTreeNode.id,itemId,function(flag){
							_closeDialog();
							var funOK = function(){
								parent.openUrl(
										'<bean:message key="common.layout.title.my.recycle.bin" />',
										'${pageContext.request.contextPath}/repository/myRecycleBin.do');
							};
							var funExists = function(){
								top.confirm("<bean:message key='common.error' />",
										"<bean:message key='repository.errors.restore.item.exists' />",
										null, null);
							}
							$.processCmsMessage(flag,funOK,null,null,null,null,funExists,null);
						});
					}
				}
			}
		},{
			text : '<bean:message key="common.close"/>',
			handler : _closeDialog
		}]	
	});
}

</script>

<table width="100%" class="listTable">
	<tr>
		<th width="35%"><bean:message key="repository.recycle.bin.name" /></th>
		<th width="15%"><bean:message key="repository.recycle.bin.type" /></th>
		<th width="20%"><bean:message
				key="repository.recycle.bin.delete.time" /></th>
		<th><bean:message key="repository.recycle.bin.operate" /></th>
	</tr>
	<c:set var="fileCount" value="0" />
	<c:if test="${!empty myRecycleBin.children}">
		<c:forEach items="${myRecycleBin.children}" var="item"
			varStatus="loop">
			<fk:resource var="item" resourceId="${item.id}" />
			<tr>
				<td>${item.alias}</td>
				<td><c:if test="${item.typeId eq 50000}">
						<img
							src="${pageContext.request.contextPath}/global/images/xloadtree2b/file.png"
							alt="<bean:message key='repository.recycle.bin.type.file'/>">
					</c:if> <c:if test="${item.typeId ne 50000}">
						<img
							src="${pageContext.request.contextPath}/global/images/xloadtree2b/folder.png"
							alt="<bean:message key='repository.recycle.bin.type.folder'/>">
					</c:if></td>
				<td><fmt:formatDate value="${item.lastUpdatedDt}"
						pattern="dd/MM/yyyy HH:mm:ss" /></td>
				<td><a href="#" onclick="deleteItem(${item.id})"><bean:message
							key='repository.recycle.bin.delete' /></a> <a href="#"
					onclick="restoreItem(${item.id})"><bean:message
							key='repository.recycle.bin.restore' /></a></td>
			</tr>
			<c:set var="fileCount" value="${fileCount + 1}" />
		</c:forEach>
	</c:if>
	<c:if test="${fileCount eq 0}">
		<tr>
			<td colspan="4"><bean:message
					key="common.message.no.match.records" /></td>
		</tr>
	</c:if>
</table>