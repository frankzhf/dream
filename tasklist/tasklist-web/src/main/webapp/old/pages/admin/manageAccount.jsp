<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script type="text/javascript">
function editAccount(accountId){
	alert("not implements.");
}
function queryAccount(){
	$.submitFormWoMsg();
}

</script>

<html:form action="/manageAccount">
	<input type="hidden" id="account.longString(id)"
		name="account.longString(id)" value="">
	<table>
		<tr>
			<td width="5%">&nbsp;</td>
			<td width="20%"><bean:message key="admin.account.uid" /></td>
			<td width="2%"><bean:message key="common.colon" /></td>
			<td width="35%"><html:text
				styleId="paginatorData.param(uid)"
				property="paginatorData.param(uid)" maxlength="255" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="4">
				<a href="#" class="easyui-linkbutton" onclick="queryAccount()">
					<bean:message key='common.query' /></a>
				<a id="clearButton" class="easyui-linkbutton"
					href="javascript:void(0)"><bean:message
					key="common.clear" /></a>
			</td>
		</tr>
	</table>
	
	<c:if test="${queryList!=null}">
			<c:if test="${!empty queryList}">
					<table class="easyui-datagrid" style="width:600px;height:auto;">
						<thead><tr>
							<th width="220px" field="uid"><fk:order orderName="loginName" orderIndex="0" culumnDisplay="admin.account.uid"/></th>
							<th width="350px" field="umask"><fk:order orderName="umask" orderIndex="1" culumnDisplay="admin.account.umask"/></th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${queryList}" var="item" varStatus="loopStatus">
							<tr>
								<td field="uid"><a href="#"
									onclick="editAccount('${item.id}')">${item.loginName}</a>
								</td>
								<td field="umask">${item.umask}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<fk:paginatxr />
				</c:if> <c:if test="${empty queryList}">
					<table class="easyui-datagrid" style="width:600px;height:auto;">
					 <thead>
						<tr>
							<th width="40%"><bean:message key="admin.account.uid" /></th>
							<th><bean:message key="admin.account.umask" /></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="2"><bean:message
								key="common.message.no.match.records" /></td>
						</tr>
					</tfoot>
					</table>
				</c:if>
		</c:if>
	
	
</html:form>