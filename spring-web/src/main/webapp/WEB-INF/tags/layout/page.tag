<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@attribute name="pageTag" required="false" %>

<c:if test="${empty header['X-Requested-With']}">
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="application.name"/></title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/xtree2/css/xtree2.css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/default/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/font-awesome.min.css" rel="stylesheet" media="screen">
    <!--[if IE 7]>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/font-awesome-ie7.min.css" rel="stylesheet" media="screen">
    <![endif]-->
    <link href="${pageContext.request.contextPath}/resources/kendoui/styles/kendo.common.min.css" rel="stylesheet">
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
    <script src="${pageContext.request.contextPath}/init"></script>
    <script src="${pageContext.request.contextPath}/resources/jquery/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/jquery/jquery-migrate-1.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/kendoui/js/kendo.web.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/site/js/kendoui.culture.custom.js"></script>
    <script src="${pageContext.request.contextPath}/resources/site/js/kendoui.culture.js"></script>
    <script src="${pageContext.request.contextPath}/resources/kendoui/js/cultures/kendo.culture.zh-CN.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/select2/js/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/site/js/site.js"></script>
    <script src="${pageContext.request.contextPath}/resources/highcharts/js/highcharts.js"></script>
    <script src="${pageContext.request.contextPath}/resources/highcharts/js/highcharts-more.js"></script>
    <script src="${pageContext.request.contextPath}/resources/highcharts/js/modules/funnel.js"></script>
    <script src="${pageContext.request.contextPath}/resources/highcharts/js/themes/grid.js"></script>
    <script src="${pageContext.request.contextPath}/resources/site/js/initcharts.js"></script>
    <script src="${pageContext.request.contextPath}/resources/commons/js/datejs.js"></script>
    
    <script src="${pageContext.request.contextPath}/resources/echarts/r.js"></script>
    <script src="${pageContext.request.contextPath}/resources/echarts/echarts-plain-original-map.js"></script>
    <script src="${pageContext.request.contextPath}/resources/site/js/jquery.cloud-0.1.js"></script>
    <!--[if lt IE 9]>
    <script type="text/javascript">$(document).ready(function(){$('#topnavbar').removeClass('navbar-inverse'); $('#topnavbarinner').removeClass('navbar-inner');})</script>
    <![endif]-->
</head>
<body>
	<div id="wrap">
		<layout:navmenu />
</c:if>
		<div id="content-container" class="container" data-page-name="${pageTag}">
		<script src="${pageContext.request.contextPath}/resources/site/js/loader.js"></script>
		<jsp:doBody/>
		<layout:session styleId="_session_modal"/>
		</div>
<c:if test="${empty header['X-Requested-With']}">
        <!-- /container -->
        <layout:errorBox styleId="errorBox" />
        <layout:msgBox styleId="msgBox" />
        <layout:confirmBox styleId="confirmBox" />
		<div id="popup" />
		<%--
		<layout:footer />
	 --%>
	</div>
</body>
</html>
</c:if>