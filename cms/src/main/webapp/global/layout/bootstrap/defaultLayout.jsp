<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragrma","no-cache");
	response.setDateHeader("Expires",0);
%>
<c:if test="${empty header['X-Requested-With']}">
<html>
<head>
<title><bean:message key="welcome.title" /></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/default/bootstrap.min.css" rel="stylesheet" media="screen">
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/font-awesome.min.css"
	rel="stylesheet" media="screen">
<!--[if IE 7]>
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/font-awesome-ie7.min.css" rel="stylesheet" media="screen">
<![endif]-->
<link
	href="${pageContext.request.contextPath}/resources/kendoui/styles/kendo.common.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/kendoui/styles/kendo.default.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/resources/select2/css/select2.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/resources/site/css/site.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/resources/commons/js/html5shiv-printshiv.js"></script>
<![endif]-->
<!--[if IE 7]>
<script src="${pageContext.request.contextPath}/resources/commons/js/json2.min.js"></script>
<![endif]-->
<script type="text/javascript">
	var CustomerConnect = {
	    contextPath : '${pageContext.request.contextPath}',
	    isLogin : true,
	    timeoutInterval	: '${pageContext.request.session.maxInactiveInterval}',
	    timeoutLogout : 5,
	    dateFormat: 'dd/MM/yyyy',
	    dateTimeFormat: 'dd/MM/yyyy HH:mm'
	};
</script>

<script src="${pageContext.request.contextPath}/resources/jquery/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/kendoui/js/kendo.web.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/kendoui/js/cultures/kendo.culture.zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/site/js/kendoui.culture.js"></script>
<script src="${pageContext.request.contextPath}/resources/select2/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/site/js/site.js?v=1.1.3"></script>
<script src="${pageContext.request.contextPath}/resources/highcharts/js/highcharts.js"></script>
<script src="${pageContext.request.contextPath}/resources/highcharts/js/highcharts-more.js"></script>
<script src="${pageContext.request.contextPath}/resources/highcharts/js/modules/funnel.js"></script>
<script src="${pageContext.request.contextPath}/resources/highcharts/js/themes/gray.js"></script>
<script src="${pageContext.request.contextPath}/resources/site/js/initcharts.js?v=1.1.3"></script>
<jsp:include page="/global/layout/bootstrap/validation.jsp"/>
<!--[if lt IE 9]>
<script type="text/javascript">$(document).ready(function(){$('#topnavbar').removeClass('navbar-inverse'); $('#topnavbarinner').removeClass('navbar-inner');})</script>
<![endif]-->
<jsp:include page="/global/layout/bootstrap/extension/header.jsp"/>
</head>
<body>
    <div id="wrap">
        <tiles:get name="menu" />
        <!-- /header -->
        <div class="container"> 	
</c:if>
			<div id="content-container" class="container" data-page-name="selfPage">
            	<script src="${pageContext.request.contextPath}/resources/site/js/loader.js?v=1.1.3"></script>
                <tiles:get name="content" />
            </div>
<c:if test="${empty header['X-Requested-With']}">
        </div>
        <!-- /container -->
        <div id="push"></div>
        <tiles:get name="session" />
    </div>
    <div id="footer">
        <div class="container">
            <jsp:include page="/global/layout/bootstrap/extension/footer.jsp"/>
        </div>
    </div>
</body>
</html>
</c:if>