<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/global/scripts/jquery/jquery-ui/themes/base/jquery.ui.all.css">
<script src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-ui/ui/jquery.ui.core.js"></script>
<script src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-ui/ui/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-ui/ui/jquery.ui.position.js"></script>
<script src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-ui/ui/jquery.ui.autocomplete.js"></script>
<script
	src='${pageContext.request.contextPath}/dwr/interface/repositoryServiceAjax.js'></script>
	
<script type="text/javascript">
$(function() {
	$('#staffName').validatebox({   
	    required:true  
	});
	
	var staffs = [{
		value:"",
		label:""
	}
	<fk:resource path="/staff" var="staffRoot" />
	<c:forEach items="${staffRoot.children}" var="staffRes" varStatus="loop">
		<fk:resource var="staffRes" resourceId="${staffRes.id}" />	
		<c:if test="${0 eq staffRes.code}">
	,{
		value: "${staffRes.id}",
		label: "${staffRes.alias}"
	}
		</c:if>
	</c:forEach>
	];
	
	$("#staffName").autocomplete({
		minLength: 2,
		source: staffs,
		focus: function( event, ui ) {
			$(this).val( ui.item.label );
			return false;
		},
		select: function( event, ui ) {
			$("#staffResourceId").val(ui.item.value)
			return false;
		}
	});
	
	$("#center").panel({
		modal:true,
		content : '<iframe frameborder="0"  src="${pageContext.request.contextPath}/repository/queryOwnsForResource.do?file.id=${shareFile.id}" style="width:100%;height:100%;"></iframe>'
	});
});

function doQuery(){
	if($.validationForm('#staffName')){
		$("#center").panel({
			modal:true,
			content : '<iframe frameborder="0"  src="${pageContext.request.contextPath}/repository/queryOwnsForResource.do?file.id=${shareFile.id}&staff.id='+$("#staffResourceId").val()+'" style="width:100%;height:100%;"></iframe>'
		});
	}
}

function doShared(){
	var resourceId = ${shareFile.id};
	var _staffResId = $("#staffResourceId").val();
	$('#msg').html('');
	if(_staffResId!=null && _staffResId!=''){
		repositoryServiceAjax.validateShareFile(resourceId,_staffResId,function(flag){
			var funOK = function(){
				repositoryServiceAjax.shareFile(resourceId,_staffResId,function(flag){
					var _funOK = function(){
						$("#center").panel({
							modal:true,
							content : '<iframe frameborder="0" src="${pageContext.request.contextPath}/repository/queryOwnsForResource.do?file.id=${shareFile.id}" style="width:100%;height:100%;"></iframe>'
						});
					}
					$.processCmsMessage(flag,_funOK);
				});
			}
			var errorShareSelf = function(){
				$('#msg').html('<font color="red"><bean:message key="repository.errors.share.file.cannt.share.to.self" /></font>');
			}
			var errorShared = function(){
				$('#msg').html('<font color="red"><bean:message key="repository.errors.share.file.be.shared" /></font>');
			}
			$.processCmsMessage(flag,funOK,null,errorShareSelf,errorShared);
		});	
	}
}
</script>
<div id="north" region="north"
	border="false" style="height:70px;">
	<table width="100%">
		<tr>
			<td width="15%"><bean:message key="repository.file.list.dialog.share.file.name" /></td>
			<td colspan="2">${shareFile.alias}</td>
			</td>
		</tr>
		<tr>
			<td width="15%"><bean:message key="repository.file.list.dialog.share.to" /></td>
			<td width="25%">
				<input type="text" id="staffName" name="staffName">
				<input type="hidden" id="staffResourceId">
			</td>
			<td>
				<a href="#" class="easyui-linkbutton" onclick="doQuery()"><bean:message
								key='common.query' /></a>
				<a href="#" class="easyui-linkbutton" onclick="doShared()"><bean:message
								key='repository.file.list.dialog.button.share' /></a>
				<span id="msg"></span>
			</td>
		</tr>
	</table>
</div>
<div id="center" region="center" border="false">
</div>