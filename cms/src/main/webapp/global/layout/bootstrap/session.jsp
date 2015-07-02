<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<div id="_session_modal" class="modal hide fade" role="dialog"
	aria-labelledby="sessionModal" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
		<h3 id="sessionModal">
			<bean:message key="common.bootstrap.session.title"/> 
		</h3>
	</div>
	<div class="modal-body">
		<p>
			<bean:message key="common.bootstrap.session.notification.message" arg0="2"/>	
		</p>
		
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">
			<bean:message key="common.cancel"/>
		</button>
		<button class="btn btn-primary" onclick="refreshSession();">
			<bean:message key="common.ok"/>
		</button>
	</div>
</div>

<div id="_session_modal_timeout" class="modal hide fade" role="dialog"
	aria-labelledby="timeoutModal" aria-hidden="true">
	<div class="modal-header">
		<h3 id="timeoutModal">
			<bean:message key="common.bootstrap.session.title"/> 
		</h3>
	</div>
	<div class="modal-body">
		<p>
			<bean:message key="common.bootstrap.session.message"/>
		</p>
	</div>
	<div class="modal-footer">
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/logout.do"><bean:message key="common.ok"/></a>
	</div>
</div>

<script>
<c:if test="${empty header['X-Requested-With']}">
	$(document).ready(function() {
		sessionReminder();
	});
</c:if>
<c:if test="${!empty header['X-Requested-With']}">
	$(document).ajaxSuccess(function() {
		sessionReminder();
	});
</c:if>
</script>