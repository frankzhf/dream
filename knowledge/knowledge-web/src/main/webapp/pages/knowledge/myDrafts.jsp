<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fk:cs />

<script
	src='${pageContext.request.contextPath}/dwr/interface/knowledgeServiceAjax.js'></script>

<script type="text/javascript">
function doEditArticle(resourceId,articleTitle){
	parent.openUrl('<bean:message key="knowledge.edit.article.title" />' +"  -  "+articleTitle,
		'${pageContext.request.contextPath}/knowledge/editArticle.do?article.resource.id='+resourceId);
}
function doRenameArticle(resourceId){
	alert("Not Implements.");
}
function doRemoveArticle(resourceId){
	alert("Not Implements.");
}
function doCreateArticle(){
	var _closeDialog = function(){
		top.$('#dialogArticleName').validatebox('destroy');
		top.$('#dialogDiv').window('close');
	};
	top.$('#dialogDiv').dialog({
		title : '<bean:message  key="knowledge.my.draft.dialog.create.title" />',
		width : 300,
		height : 150,
		modal : true,
		content : '<br><bean:message  key="knowledge.my.draft.dialog.create.lable.article.name" /> <bean:message  key="common.colon" /> &nbsp;&nbsp; <input type="text" id="dialogArticleName"><script>$(function() {$("#dialogArticleName").validatebox({required:true});});<\/script\>',
		buttons : [ {
			text : '<bean:message key="common.ok"/>',
			handler : function (){
				if(top.$('#dialogArticleName').validatebox('isValid')){
					var articleName = top.$('#dialogArticleName').val();
					_closeDialog();
					knowledgeServiceAjax.createArticle(articleName,function(flag){
						var funOK = function(){
							parent.openUrl('<bean:message key="common.layout.title.my.drafts" />',
								'${pageContext.request.contextPath}/knowledge/myDrafts.do');
						};
						var funExist = function(){
							top.confirm("<bean:message key='common.error' />",
									"<bean:message key='knowledge.my.draft.dialog.create.error.article.name.exist' />",
									null, null);
						}
						$.processCmsMessage(flag,funOK,null,null,null,funExist);
					});
				}
			}
		}, {
			text : '<bean:message key="common.cancel"/>',
			handler : _closeDialog
		} ]
	});
}
</script>

<fk:resource var="myHomeRes" resourceId="${cs.account.home$3.id}"/>
<fk:resource var="knowlegdeRes" parentResource="${myHomeRes}" alias="knowledge" />
<fk:resource var="myDraftsRes" parentResource="${knowlegdeRes}" alias="myDrafts" />


<table width="100%" class="listTable">
	<tr>
		<th width="45%"><bean:message key="knowledge.my.draft.label.article.name" /></th>
		<th width="25%"><bean:message
			key="knowledge.my.draft.label.last.modify.time" /></th>
		<th><bean:message key="knowledge.my.draft.label.operate" /></th>
	</tr>
	<c:set var="articleCount" value="0" />
	<c:if test="${!empty myDraftsRes.children}">
		<c:forEach items="${myDraftsRes.children}" var="child" varStatus="loop">
			<fk:resource var="article" resourceId="${child.id}" />
			<c:if test="${article.typeId eq 9 }">
				<c:set var="articleCount" value="${articleCount + 1}" />
				
	<tr>
		<td>${article.alias}</td>
		<td><fmt:formatDate value="${article.lastUpdatedDt}" pattern="dd-MMM-yyyy HH:mm:ss"/> </td>
		<td><a class="easyui-linkbutton" href="#" onclick="doEditArticle(${article.id},'${article.alias}')"><bean:message
				key='knowledge.my.draft.button.edit' /></a>
			<a class="easyui-linkbutton" href="#" onclick="doRenameArticle(${article.id})"><bean:message
				key='knowledge.my.draft.button.rename' /></a>&nbsp;
			<a class="easyui-linkbutton" href="#" onclick="doRemoveArticle(${article.id})"><bean:message
				key='knowledge.my.draft.button.remove' /></a>&nbsp;	
		</td>
	</tr>
			</c:if>
		</c:forEach>
	</c:if>
	<c:if test="${articleCount eq 0}">
	 	<tr>
			<td colspan="3"><bean:message
						key="common.message.no.match.records" /></td>
		</tr>
	</c:if>
</table>
<br>
<a href="#" class="easyui-linkbutton" onclick="doCreateArticle()"><bean:message
	key='knowledge.my.draft.button.create' /> </a> &nbsp;
