<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/global/scripts/jquery/jquery-ui/themes/base/jquery.ui.all.css">
<script src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-ui/ui/jquery.ui.core.js"></script>
<script src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-ui/ui/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-ui/ui/jquery.ui.position.js"></script>
<script src="${pageContext.request.contextPath}/global/scripts/jquery/jquery-ui/ui/jquery.ui.autocomplete.js"></script>
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
	
});

function doCheck(){
	if($.validationForm('#staffName,#staffResourceId')){
		var href = '${pageContext.request.contextPath}/common/veiwStaffDetails.do?resource.id='+$('#staffResourceId').val()
		$("#center").panel({
			modal:true,
			content : '<iframe frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>'
		});
	}
}
</script>

<div id="north" region="north"
	border="false" style="height:30px;">
	<table width="100%">
		<tr>
			<td width="15%"><bean:message key="common.dialog.staff.selector.staff.name" /></td>
			<td width="25%">
				<input type="text" id="staffName" name="staffName">
				<input type="hidden" id="staffResourceId" value="">
			</td>
			<td>
				<a href="#" class="easyui-linkbutton" onclick="doCheck()"><bean:message
								key='common.check' /></a>
			</td>
		</tr>
	</table>
</div>
<div id="center" region="center" border="false">
</div>