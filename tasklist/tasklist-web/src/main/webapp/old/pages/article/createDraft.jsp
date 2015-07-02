<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script type="text/javascript" 
	src="${pageContext.request.contextPath}/tiny_mce/tiny_mce.js">
</script>

<script type="text/javascript">
tinyMCE.init({
	mode : "textareas",
	theme : "advanced",
	plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,wordcount,advlist",
	theme_advanced_buttons1 : "bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
	theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
	theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,advhr,|,print,|,ltr,rtl,|,fullscreen",
	theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft",
	theme_advanced_toolbar_location : "top",
	theme_advanced_toolbar_align : "left",
	theme_advanced_statusbar_location : "bottom",
	theme_advanced_resizing : false,
	content_css : "${pageContext.request.contextPath}/global/css/content.css",
	//template_external_list_url : "${pageContext.request.contextPath}/tiny/listTemplate",
	external_link_list_url : "${pageContext.request.contextPath}/tiny/listLink",
	external_image_list_url :"${pageContext.request.contextPath}/tiny/listImage",
	//media_external_list_url : "lists/media_list.js",
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
	//current_http_url : CURRENT_SERVICE_URL
});

</script>

<html:form action="/submitCreateDraft">
	<table class="contentPanel">
		<tr>
			<td width="20%">
				<bean:message key="net.frank.framework.bo.Article.title"/>
			</td>
			<td>
				<html:text property="content(9).title" />
			</td>
		</tr>
		<tr>
			<td width="20%">
				<bean:message key="net.frank.framework.bo.Article.key.word"/>
			</td>
			<td>
				<html:text property="content(9).keyWord" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea id="elm1" name="content(9).keyWord" rows="35" cols="128">
				</textarea>
			</td>
		</tr>
	</table>
</html:form>