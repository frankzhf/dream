<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<script type="text/javascript">
function refrushDiv(divId,url){
	$("#"+divId).panel({
		content: '<iframe id="rightDetails" frameborder="0"  src="'+url+'" style="width:100%;height:100%;">'
	});
}

$(function(){
	$("#resourceArea").accordion();
	$("#imageDiv").panel({
		content: '<iframe id="rightDetails" frameborder="0"  src="${pageContext.request.contextPath}/knowledge/listImage.do?article.resource.id=${knowledgeForm.article.resource.id}" style="width:100%;height:100%;">'
	});
	/***
	$("#mediaDiv").panel({
		content: '<iframe id="rightDetails" frameborder="0"  src="${pageContext.request.contextPath}/knowledge/listImage.do?article.resource.id='+${knowledgeForm.article.resource.id}" style="width:100%;height:100%;">'
	});
	***/
});
</script>

<div id="resourceArea" style="width:100%;height:100%;overflow:hidden;" border="true"
	fit="true" class="easyui-accordion">
	<div id="imageDiv" title="Image" icon="icon-sys">
		
	</div>
	<div id="mediaDiv" title="Media" icon="icon-sys">
		
	</div>
</div>