<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<fk:cs/>
<c:if test="${cs.account.resource.id eq cs.account.resource.ownResourceId}">
<script type="text/javascript">
$(function() {
	top.openUrl('<bean:message key="common.layout.dashboard" />','${pageContext.request.contextPath}/desktop.do');
});
</script>
</c:if>

<c:if test="${!(cs.account.resource.id eq cs.account.resource.ownResourceId)}">
<h2><bean:message key="common.message.account.not.active" /></h2>
</c:if>