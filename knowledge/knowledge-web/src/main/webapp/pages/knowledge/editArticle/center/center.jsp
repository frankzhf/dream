<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<script type="text/javascript" 
	src="${pageContext.request.contextPath}/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-1.7.1.js"></script>

<script type="text/javascript">
$.extend({
	submitFormWoMsg:function(sectionName){
		document.forms[0].submit();
		$.disabledDocElement();
	},
	disabledDocElement:function(){
		$('input[type!=hidden]').each(function (){
			$(this).attr("disabled","disabled");
		});
		$('textarea').each(function (){
			$(this).attr("disabled","disabled");
		});
		$('a').each(function (){
			$(this).attr("herf","#");
			if($(this) && $(this).attr("id") == 'clearButton' ){
				$(this).unbind();
			}else{
				$(this).attr("onclick",function(){return false;});
			}
		});
	}
});

$(function(){
	<logic:notEmpty name="knowledgeForm" property="article.content">
	var _element = document.getElementById('elm1');
	_element.value = document.getElementById('article.clobString(content)').value;
	</logic:notEmpty>
	tinyMCE.init({
		mode : "textareas",
		theme : "advanced",
		plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,media,emotions,iespell,inlinepopups,insertdatetime,preview,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,wordcount,advlist",
		theme_advanced_buttons1 : "bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,media,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : true,
		content_css : "${pageContext.request.contextPath}/global/css/content.css",
		//template_external_list_url : "${pageContext.request.contextPath}/tiny/listTemplate",
		//external_link_list_url : "${pageContext.request.contextPath}/tiny/listLink",
		external_image_list_url :"${pageContext.request.contextPath}/tiny/listImage",
		//media_external_list_url : "${pageContext.request.contextPath}/tiny_mce/example/media_list.js",
		style_formats : [
			{title : 'Bold text', inline : 'b'},
			{title : 'Red text', inline : 'span', styles : {color : '#ff0000'}},
			{title : 'Red header', block : 'h1', styles : {color : '#ff0000'}},
			{title : 'Example 1', inline : 'span', classes : 'example1'},
			{title : 'Example 2', inline : 'span', classes : 'example2'},
			{title : 'Table styles'},
			{title : 'Table row 1', selector : 'tr', classes : 'tablerow1'}
		],
		formats : {
			alignleft : {selector : 'p,h1,h2,h3,h4,h5,h6,td,th,div,ul,ol,li,table,img', classes : 'left'},
			aligncenter : {selector : 'p,h1,h2,h3,h4,h5,h6,td,th,div,ul,ol,li,table,img', classes : 'center'},
			alignright : {selector : 'p,h1,h2,h3,h4,h5,h6,td,th,div,ul,ol,li,table,img', classes : 'right'},
			alignfull : {selector : 'p,h1,h2,h3,h4,h5,h6,td,th,div,ul,ol,li,table,img', classes : 'full'},
			bold : {inline : 'span', 'classes' : 'bold'},
			italic : {inline : 'span', 'classes' : 'italic'},
			underline : {inline : 'span', 'classes' : 'underline', exact : true},
			strikethrough : {inline : 'del'}
		}
	});
	
})

function getContent(){
	return tinyMCE.get('elm1').getContent();
}


</script>
<html:form action="/saveArtilce">
<textarea id="elm1" name="elm1" rows="20" style="width: 100%"></textarea>
<html:hidden property="article.longString(id)" />
<html:hidden property="article.title" />
<html:hidden property="article.keyWord" />
<html:hidden property="article.clobString(content)" styleId="article.clobString(content)" />
<html:hidden property="article.context$3.longString(id)" />
<html:hidden property="article.resource.longString(parentId)" />
<html:hidden property="article.resource.longString(typeId)" />
<html:hidden property="article.resource.longString(ownResourceId)" />
<html:hidden property="article.resource.longString(ownGroupResourceId)" />
<html:hidden property="article.resource.timestampString(createdDt)" />
<html:hidden property="article.resource.timestampString(lastUpdatedDt)" />
<html:hidden property="article.resource.alias" />
<html:hidden property="article.resource.booleanString(active)" />
<html:hidden property="article.resource.booleanString(systemNode)" />
<html:hidden property="article.resource.currentAccountPermission" />
<html:hidden property="article.resource.currentGroupPermission" />
<html:hidden property="article.resource.othersPermission" />
<html:hidden styleId="article_resource_id" property="article.resource.longString(id)" />
</html:form>