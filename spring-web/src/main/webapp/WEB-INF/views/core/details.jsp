<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fk" uri="http://www.frank.net/jsp/tags"%>

<script type="text/javascript">
</script>
<c:choose>
	<c:when
		test="${!empty CHECK_PERMISSIN && !CHECK_PERMISSIN}">
		<h3>
			<bean:message key="browser.error.insufficient.privileges" />
		</h3>
	</c:when>
	<c:otherwise>
<form:form modelAttribute="form" method="post" action="${pageContext.request.contextPath}/core/viewDetails" 
	enctype="multipart/form-data">
	 <form:hidden path="resource.id" />
	 <form:hidden path="resource.parentId" />
	 <form:hidden path="resource.typeId" />
	 <form:hidden path="resource.ownResourceId" />
	 <form:hidden path="resource.ownGroupResourceId" />
	 <form:hidden path="resource.createdDt" />
	 <form:hidden path="resource.lastUpdatedDt" />
</form:form>
	</c:otherwise>
</c:choose>	
			