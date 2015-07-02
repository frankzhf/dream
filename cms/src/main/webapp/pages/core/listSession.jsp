<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<fk:cs/>
<script type="text/javascript">
	$(function(){
		$("#selectedAll").click(function(){
			var _checked = $(this).prop('checked');
			$("input[type=checkbox][name^=sessionView\\[][name$=\\]\\.selected]").each(function(){
				$(this).prop("checked",_checked);
			});
		});
	});
	function submitKillSession(){
		var _checked = false;
		$("input[type=checkbox][name^=sessionView\\[][name$=\\]\\.selected]").each(function(){
			if($(this).prop("checked")){
				_checked = true;
				return;
			};
		});
		if(!_checked){
			top.$.messager.alert('<bean:message key="common.warning" />','<bean:message key="core.list.session.no.selected.session" />');
			return;
		}else{
			var okCallback = function(){
				$.submitFormWoMsg();
			}
			top.confirm("<bean:message key='common.error' />",
					"<bean:message key='core.list.session.warn.confirm.kill.session' />",
					okCallback, null);
		}
	}
</script>
<html:form action="/killSession">
<table width="100%" class="listTable">
	<tr>
		<th width="5%"><input type="checkbox"  id="selectedAll"> <bean:message key="common.select.all"/> </th>
		<th width="15%" align="left"><bean:message key="core.list.session.client.ip" /></th>
		<th width="15%" align="left"><bean:message key="core.list.session.login.name" /></th>
		<th width="15%" align="left"><bean:message key="core.list.session.platform" /></th>
		<th width="15%" align="left"><bean:message key="core.list.session.application" /></th>
		<th align="left"><bean:message key="core.list.session.prev.request.time"/></th>
	</tr>
<c:if test="${empty sessionViewList}">
	<tr>
		<td colspan="6"><bean:message key="common.message.no.match.records" />
		</td>
	</tr>
</c:if>
<c:if test="${!empty sessionViewList}">
	<c:forEach items="${sessionViewList}" var="sessionView" varStatus="loop" >
	<tr>
		<td>
		<c:if test="${cs.clientIP eq sessionView.clientIp && cs.loginName eq sessionView.loginName}">
		&nbsp;
		</c:if>
		<c:if test="${!( cs.clientIP eq sessionView.clientIp && cs.loginName eq sessionView.loginName)}">
		<input type="checkbox" value="true" name="sessionView[${loop.index}].selected">
		</c:if>
		<input type="hidden" value="${sessionView.clientIp}" name="sessionView[${loop.index}].clientIp">
		<input type="hidden" value="${sessionView.loginName}" name="sessionView[${loop.index}].loginName">
		</td>
		<td>${sessionView.clientIp} &nbsp;</td>
		<td>${sessionView.loginName} &nbsp;</td>
		<td>${sessionView.platform} &nbsp;</td>
		<td>${sessionView.application} &nbsp;</td>
		<td>
			<fmt:formatDate value="${sessionView.prevRequestTime}" pattern="dd/MM/yyyy HH:mm:ss" />&nbsp;
		</td>
	</tr>
	</c:forEach>
</c:if>
	<tr>
		<td colspan="6">
			<input type="button"
				value="<bean:message key='common.submit' />" onclick="submitKillSession()">
		</td>
	</tr>
</table>
</html:form>