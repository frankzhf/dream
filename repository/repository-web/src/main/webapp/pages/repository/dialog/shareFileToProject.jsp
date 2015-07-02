<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$(function() {
});
</script>

<table width="100%">
	<tr>
		<td><bean:message key="repository.file.list.dialog.shared.file.project.to" /></td>
		<td><select class="easyui-combobox" style="width: 160px;"
			id="unit">
				<option value=""></option>
	<c:forEach items="${projectList}" var="project" varStatus="loop">
				<option value="${project.id}">${project.object.unitName}</option>
	</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td><bean:message key="repository.file.list.dialog.shared.file.project.desc" /></td>
		<td>
			<textarea id="text" rows="4" cols="255"></textarea>
		</td>
	</tr>
	<tr>
		<td><bean:message key="repository.file.list.dialog.shared.file.project.clone" /></td>
		<td>
			<input type="checkbox" id="cloneFlag">
		</td>
	</tr>
</table>