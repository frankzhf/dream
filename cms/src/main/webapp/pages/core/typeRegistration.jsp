<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags/cms" prefix="cms"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/global/scripts/jquery/dropdown/css/jquery.dropdown.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/dropdown/jquery.dropdown.js"></script>

<fk:resource var="applicationFolder" path="/opt" cs="${su}" />

<script type="text/javascript">


$(function(){
	$('#entityClassName').validatebox({   
	    required:true  
	});
	$('#typeKey').validatebox({   
	    required:true  
	});
	
	$("#appResourceName").dropdown({ vinputid: "appResourceId",
        selecteditem: { text: "<bean:message key='common.select'/>", value: "" },
        dropheight : 60,
        items: [
   				
<c:set var="isfirst" value="0"  />
<c:forEach items="${applicationFolder.children}" var="child" varStatus="loop">
	<fk:resource var="currResouce" resourceId="${child.id}" />
	<c:if test="${currResouce.typeId eq 12}">
		<c:choose>
			<c:when test="${isfirst eq 0}">
				{ text: "${currResouce.object.appName}", value: "${currResouce.id}"}
				<c:set var="isfirst" value="1"  />
			</c:when>
			<c:otherwise>
			,{ text: "${currResouce.object.appName}", value: "${currResouce.id}"}
			</c:otherwise>
		</c:choose>
	</c:if>
</c:forEach>  
               ]
    });
	
});

function submitTypeRegistration(){
	if($.validationForm('form[name=typeRegistrationForm] input[type!=hidden]')){
		$.submitFormWoMsg();	
	}R
}
</script>



<html:form action="/submitTypeRegistration">
	<table style="width: 100%">
		<tr>
			<td width="20%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td><bean:message key="core.type.registration.entity.class.name" /></td>
			<td><input type="text" id="entityClassName" name="entityClassName" maxlength="255"
				style="width: 70%" /></td>
		</tr>
		<tr>
			<td><bean:message key="core.type.registration.type.key" /></td>
			<td><input type="text" id="typeKey" name="typeKey" maxlength="255"
				style="width: 70%" /></td>
		</tr>
		<tr>
			<td><bean:message key="core.type.registration.description" /></td>
			<td><input type="text" id="description" name="description" maxlength="255"
				style="width: 70%" /></td>
		</tr>
		<tr>
			<td><bean:message key="core.type.registration.application" /></td>
			<td>

				
				<input id="appResourceName" type="text" class="_w150" >
				<input type="hidden" id="appResourceId" name="appResourceId" >
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button"
				value="<bean:message key='common.submit' />" onclick="submitTypeRegistration()">
			</td>
		</tr>
	</table>
</html:form>