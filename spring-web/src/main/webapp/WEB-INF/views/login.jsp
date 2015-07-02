<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><spring:message code="application.name" /></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/default/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/kendoui/styles/kendo.common.min.css">
	
<style type="text/css">
/*** Override some default **/
html,body {
	background-color: #eee;
}

body {
	padding-top: 40px;
}

.container {
	width: 480px;
}

.container>.content {
	background-color: #fff;
	padding: 20px;
	margin: 0 -20px;
	-webkit-border-radius: 10px 10px 10px 10px;
	-moz-border-radius: 10px 10px 10px 10px;
	border-radius: 10px 10px 10px 10px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
}

.login-form {
	margin-left: 65px;
}

legend {
	margin-right: -50px;
	font-weight: hold;
	color: #404040;
}
</style>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/site.js"></script>	
	

<jsp:include page="/validation" />

</head>

<script type="text/javascript">	
<c:if test="${!empty header['X-Requested-With']}">
	self.location = '${pageContext.request.contextPath}/login';
</c:if>
	function doLogin(){
		var vldIns = new vld.Validation();
		vldIns.addValidObj('loginname', '<spring:message code="login.field.login.name"/>', 'Mandatory', VCC.checkMandatory);
		vldIns.addValidObj('password', '<spring:message code="login.field.password"/>', 'Mandatory', VCC.checkMandatory);
		if(vldIns.performValidation('All')){
			document.forms[0].submit();
			showMask('loginContainer',1.2);
		}
	}
	
	$(function(){
		$("#screenWith").val($(window).width());
		$("#screenHeight").val($(window).height());
		$("#btnLogin").click(function(){
			doLogin();
		});
		$("#btnClear").click(function(){
			$("#loginname").val('');
			$("#password").val('');
		});
		
		$("#loginname").bind('change',function(){
			if($(this).val()!=null && $(this).val()!=''){
				$("#loginnameError").removeClass("alert alert-error");
				$("#loginnameError").html("");
			}
		});
		$("#password").bind('change',function(){
			if($(this).val()!=null && $(this).val()!=''){
				$("#passwordError").removeClass("alert alert-error");
				$("#passwordError").html("");
			}
		});
	});
</script>

<body>
	<div id="loginContainer" class="container">
		<div class="content">
			<div class="row">
				<div class="login-form">
					<h2>
						<spring:message code="login.label.login" />
					</h2>
					<h5>
						<spring:message code="login.label.language" />
						<a href="?language=en_US"><spring:message code="login.label.language.en" /></a>|
						<a href="?language=zh_CN"><spring:message code="login.label.language.zh" /></a>
					</h5>
					<form:form modelAttribute="loginForm" action="${pageContext.request.contextPath}/doLogin">
						<form:hidden path="screenWith" />
						<form:hidden path="screenHeight" />
						<fieldset>
							<spring:message code="login.login.name.place.holder" var="loginnameHolder" />
							<div class="clearfix">
							<spring:bind path="loginname">
								<form:input path="loginname" id="loginname" 
									placeholder="${loginnameHolder}" />
								<c:choose>
									<c:when test="${status.error}">
										<form:errors path="loginname" cssClass="alert alert-error" />
									</c:when>
									<c:otherwise>
										<span id="loginnameError"></span>
									</c:otherwise>
								</c:choose>
							</spring:bind>
							</div>
							<spring:message code="login.passowrd.place.holder" var="pwdHolder" />
							<div class="clearfix">
							<spring:bind path="password">
								<form:password path="password" id="password"
									placeholder="${pwdHolder}" onkeydown="javascripts:checkKey(event,13,'doLogin()')" />
								<c:choose>
									<c:when test="${status.error}">
										<form:errors path="password" cssClass="alert alert-error" />
									</c:when>
									<c:otherwise>
										<span id="passwordError"></span>
									</c:otherwise>
								</c:choose>
							</spring:bind>
							</div>
							<button class="btn primary" type="button" id="btnLogin">
								<spring:message code="login.button.submit" />
							</button>
							<button class="btn" type="button" id="btnClear">
								<spring:message code="login.button.clear" />
							</button>
						</fieldset>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>