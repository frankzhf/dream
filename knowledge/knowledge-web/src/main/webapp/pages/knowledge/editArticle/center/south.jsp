<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<script
	src='${pageContext.request.contextPath}/dwr/interface/knowledgeServiceAjax.js'></script>

<script type="text/javascript">
function doSave(){
	var content = parent.$("#centerdetails")[0].contentWindow.getContent();
	var resourceId  = ${knowledgeForm.article.resource.id};
	knowledgeServiceAjax.saveArticleContent(resourceId,content,function(flag){
		var funOK = function(){
			top.confirm("<bean:message key='common.warning' />",
					"<bean:message key='knowledge.edit.article.message.save.success' />",
					null, null);
		};
		var directMyDraft = function(){
			top.$('#confirmDiv').window('close');
			top.openUrl('<bean:message key="memu.item.my.drafts" />',
					'${pageContext.request.contextPath}/knowledge/myDrafts.do');
		};
		var funNotExist = function(){
			top.confirm("<bean:message key='common.error' />",
					"<bean:message key='knowledge.edit.article.error.article.not.exists' />",
					directMyDraft, null);
		};
		$.processCmsMessage(flag,funOK,null,null,null,funNotExist);
	});
}
</script>

<a class="easyui-linkbutton" onclick="doSave()"><bean:message
	key='knowledge.edit.article.button.save' /> </a>