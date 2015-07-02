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
	src='${pageContext.request.contextPath}/dwr/interface/adminAjax.js'></script>

<script type="text/javascript">
$(function() {
	$('#staffName').validatebox({   
	    required:true  
	});
	
	var staffs = [
		{
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
		content : '<iframe frameborder="0"  src="${pageContext.request.contextPath}/admin/queryStaffByGroupAndLikeName.do?resource.id=${group.id}" style="width:100%;height:100%;"></iframe>'
	});
});

function doQuery(){
	if($.validationForm('#staffName')){
		var href = '${pageContext.request.contextPath}/admin/queryStaffByGroupAndLikeName.do?resource.id=${group.id}&staffName='+$('#staffName').val()
		$("#center").panel({
			modal:true,
			content : '<iframe frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>'
		});
	}
}

function doGrant(){
	$("#msg").html('');
	var _staffResId = $("#staffResourceId").val();
		if(_staffResId!=null && _staffResId!=''){
		adminAjax.validateStaffGroup(${group.id},_staffResId,function(flag){
			var _funOK = function(){
				adminAjax.grantStaffGroup(${group.id},_staffResId,function(flag){
					var funOK = function(){
						$("#staffName").val('');
						var href = '${pageContext.request.contextPath}/admin/queryStaffByGroupAndLikeName.do?resource.id=${group.id}';
						$("#center").panel({
							modal:true,
							content : '<iframe frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>'
						});
					}
					$.processCmsMessage(flag,funOK);
				});
			}
			var _funExists = function(){
				$("#msg").html('<bean:message key="admin.grant.unit.errors.group.exists" />');
			}
			$.processCmsMessage(flag,_funOK,null,null,null,null,_funExists,null);
		});
	}
}

</script>

<div id="north" region="north"
	border="false" style="height:30px;">
	<table width="100%">
		<tr>
			<td width="15%"><bean:message key="admin.grant.unit.group.staff.name" /></td>
			<td width="25%">
				<input type="text" id="staffName" name="staffName">
				<input type="hidden" id="staffResourceId">
			</td>
			<td>
				<a href="#" class="easyui-linkbutton" onclick="doQuery()"><bean:message
								key='common.query' /></a>
				<fk:hasPermission permission="write"
					resourceId="${grantFolder.id}">
					<a href="#" class="easyui-linkbutton" onclick="doGrant()"><bean:message
									key='admin.grant.unit.group.button.join' /></a>
					<span id="msg" style="font-color:red;"></span>
				</fk:hasPermission>
			</td>
		</tr>
		
	</table>
	
</div>
<div id="center" region="center" border="false">
</div>