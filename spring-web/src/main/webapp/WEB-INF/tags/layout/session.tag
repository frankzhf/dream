<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@attribute name="styleId" required="true"%>


<div id="${styleId}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="sessionModal" aria-hidden="true"> 
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		<h3 id="sessionModal"><spring:message code="title.session.timeout"/></h3>
	</div>
	<div class="modal-body">
		<p><spring:message code="msg.session.timeout.notification" arguments="10" /></p>
	</div>
	<div class="modal-footer">
		<button id="reNewSession" class="btn btn-primary" data-dismiss="modal" aria-hidden="true"><spring:message code="button.session.continue"/></button>
		<button class="btn btn-special-primary" data-dismiss="modal" aria-hidden="true"><spring:message code="button.session.not.continue"/></button>
	</div>
</div>

<div id="${styleId}_timeout" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="timeoutModal" aria-hidden="true"> 
	<div class="modal-header">
		<h3 id="timeoutModal"><spring:message code="title.session.timeout"/></h3>
	</div>
	<div class="modal-body">
		<p><spring:message code="msg.session.timeout"/></p>
	</div>
	<div class="modal-footer">
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/login"><spring:message code="button.session.ok"/></a>
	</div>
</div>
<script>
<c:if test="${empty header['X-Requested-With']}">
$(document).ready(function(){
	sessionReminder();
	$("#reNewSession").bind("click",function(){
		refreshSession();
	});
});
</c:if>
<c:if test="${!empty header['X-Requested-With']}">
$(document).ajaxSuccess(function(){
	sessionReminder();
	$("#reNewSession").bind("click",function(){
		refreshSession();
	});
});
</c:if>
</script>
