<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@attribute name="styleId" required="true"%>

<div id="${styleId}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="errorBoxModal" aria-hidden="true"> 
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		<h3 id="sessionModal"><spring:message code="title.error.box"/></h3>
	</div>
	<div class="modal-body">
		<p><spring:message code="content.error.box"/></p>
	</div>
	<div class="modal-footer">
		<button class="btn btn-special-primary" data-dismiss="modal" aria-hidden="true"><spring:message code="button.session.ok"/></button>
	</div>
</div>