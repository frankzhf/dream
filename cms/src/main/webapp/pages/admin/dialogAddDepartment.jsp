<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<script type="text/javascript">
$(function() {
	$('#departmentName').validatebox({   
	    required:true  
	});
	$('#departmentCode').validatebox({   
	    required:true  
	});
});
</script>
<div id="center" region="center" border="false">
	<table width="100%">
		<tr>
			<td width="30%"><bean:message key="admin.create.department.dialog.department.name" /></td>
			<td>
				<input type="text" id="departmentName" name="departmentName">
			</td>
		</tr>
		<tr>
			<td><bean:message key="admin.create.department.dialog.department.code" /></td>
			<td>
				<input type="text" id="departmentCode" name="departmentCode">
			</td>
		</tr>
	</table>
</div>