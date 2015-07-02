<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags/cms" prefix="cms"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script>
	$(function(){
		$("#selectedAll").click(function(){
			var _checked = $(this).prop('checked');
			$("input[type=checkbox][id^=resource_][id$=__selected]").each(function(){
				$(this).prop("checked",_checked);
			});
		});
	});
	function submitActivationAccount(){
		var _checked = false;
		$("input[type=checkbox][id^=resource_][id$=__selected]").each(function(){
			if($(this).prop("checked")){
				_checked = true;
				return;
			};
		});
		if(!_checked){
			top.$.messager.alert('<bean:message key="common.warning" />','<bean:message key="core.activation.error.no.selected.account" />');
			return;
		}else{
			$.submitFormWoMsg();
		}
	}
</script>
<fk:resource var="homeFolder" path="/home" />

<html:form action="/submitActivationAccount">
<table width="100%" class="listTable">
	<tr>
		<th width="5%"><input type="checkbox"  id="selectedAll"> <bean:message key="common.select.all"/> </th>
		<th align="left"><bean:message key="core.activation.account.account.list" /></th>
	</tr>
<c:if test="${empty homeFolder.children}">
	<tr>
		<td colspan="2"><bean:message key="common.message.no.match.records" />
		</td>
	</tr>
</c:if>
<c:if test="${!empty homeFolder.children}">
	<c:set var="number" value="0" />
	<c:forEach items="${homeFolder.children}" var="item" varStatus="loop">
		<fk:resource var="account" resourceId="${item.id}"/>
		<c:if test="${account.active && account.typeId eq 5 && account.id ne account.ownResourceId}">
			<tr>
				<td><input type="checkbox" value="true" name="resource[${number}].selected" id="resource_${number}__selected"></td>
				<td>
					<input type="hidden" value="${account.id}" name="resource[${number}].id" id="resource_${number}__id">
					${account.object.loginName}
				</td>
			</tr>
			<c:set var="number" value="${number+1}" />
		</c:if>
	</c:forEach>
	<c:if test="${number eq 0}">
		<tr>
			<td colspan="2"><bean:message key="common.message.no.match.records" />
			</td>
		</tr>
	</c:if>
</c:if>
	<tr>
		<td colspan="2">
			<input type="button"
				value="<bean:message key='common.submit' />" onclick="submitActivationAccount()">
		</td>
	</tr>
</table>
</html:form>