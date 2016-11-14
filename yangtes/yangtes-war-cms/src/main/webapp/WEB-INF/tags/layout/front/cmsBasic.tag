<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" type="java.lang.String" required="true"
	description="页面标题"%>
<%@ attribute name="bodyId" type="java.lang.String" required="false"%>

<%@ attribute name="description" type="java.lang.String" required="false"%>
<%@ attribute name="keywords" type="java.lang.String" required="false"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="ctx" value="${pageContext.request.contextPath}${fns:getFrontPath()}" scope="request" />
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/resources" scope="request" />
<c:set var="ctxStaticFront" value="${ctxStatic}/modules/cms/front" scope="request"/>
<c:set var="ctxStaticTheme" value="${ctxStaticFront}/themes/${site.theme}" scope="request"/>
<c:set var="urlSuffix" value="${fns:getUrlSuffix()}" scope="request"/>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<meta name="author" content="http://www.heinqi.com/"/>
	<meta http-equiv="X-UA-Compatible" content="IE=7,IE=9,IE=10" />
	<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/jquery/jquery-migrate-1.1.1.min.js" type="text/javascript"></script>
	<c:if test="${site.theme eq 'basic'}">
		<link href="${ctxStatic}/bootstrap/2.3.1/css_${not empty cookie.theme.value ? cookie.theme.value : 'cerulean'}/bootstrap.min.css" type="text/css" rel="stylesheet" />
		<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
		<!--[if lte IE 6]><link href="${ctxStatic}/bootstrap/bsie/css/bootstrap-ie6.min.css" type="text/css" rel="stylesheet" />
		<script src="${ctxStatic}/bootstrap/bsie/js/bootstrap-ie.min.js" type="text/javascript"></script><![endif]-->
		<link href="${ctxStatic}/common/yangtes.min.css" type="text/css" rel="stylesheet" />
		<link href="${ctxStaticTheme}/style.css" type="text/css" rel="stylesheet" />
		<script src="${ctxStaticTheme}/script.js" type="text/javascript"></script>
	</c:if>
	<title><%=title%>- Powered By Yangtes</title>
	<meta name="description" content="Yangtes <%=description%>" />
	<meta name="keywords" content="Yangtes <%=keywords%>" />
</head>
<body>
	<div class="navbar navbar-fixed-top"
		style="position: static; margin-bottom: 10px;">
		<div class="navbar-inner">
			<div class="container">
				<c:choose>
					<c:when test="${not empty site.logo}">
						<img alt="${site.title}" src="${site.logo}" class="container"
							onclick="location='${ctx}/index-${site.id}${fns:getUrlSuffix()}'">
					</c:when>
					<c:otherwise>
						<a class="brand"
							href="${ctx}/index-${site.id}${fns:getUrlSuffix()}">${site.title}</a>
					</c:otherwise>
				</c:choose>
				<div class="nav-collapse">
					<ul id="main_nav" class="nav nav-pills">
						<li class="${not empty isIndex && isIndex ? 'active' : ''}"><a
							href="${ctx}/index-1${fns:getUrlSuffix()}"><span>${site.id eq '1'?'首　 页':'返回主站'}</span></a></li>
						<c:forEach items="${fnc:getMainNavList(site.id)}" var="category"
							varStatus="status">
							<c:if test="${status.index lt 6}">
								<c:set var="menuCategoryId" value=",${category.id}," />
								<li
									class="${requestScope.category.id eq category.id||fn:indexOf(requestScope.category.parentIds,menuCategoryId) ge 1?'active':''}"><a
									href="${category.url}" target="${category.target}"><span>${category.name}</span></a></li>
							</c:if>
						</c:forEach>
						<li id="siteSwitch" class="dropdown"><a
							class="dropdown-toggle" data-toggle="dropdown" href="#"
							title="站点"><i class="icon-retweet"></i></a>
							<ul class="dropdown-menu">
								<c:forEach items="${fnc:getSiteList()}" var="site">
									<li><a href="#"
										onclick="location='${ctx}/index-${site.id}${urlSuffix}'">${site.title}</a></li>
								</c:forEach>
							</ul></li>
						<li id="themeSwitch" class="dropdown"><a
							class="dropdown-toggle" data-toggle="dropdown" href="#"
							title="主题切换"><i class="icon-th-large"></i></a>
							<ul class="dropdown-menu">
								<c:forEach items="${fns:getDictList('theme')}" var="dict">
									<li><a href="#"
										onclick="location='${pageContext.request.contextPath}/theme/${dict.value}?url='+location.href">${dict.label}</a></li>
								</c:forEach>
							</ul> <!--[if lte IE 6]><script type="text/javascript">$('#themeSwitch').hide();</script><![endif]-->
						</li>
					</ul>
					<form class="navbar-form pull-right" action="${ctx}/search"
						method="get">
						<input type="text" name="q" maxlength="20" style="width: 65px;"
							placeholder="全站搜索..." value="${q}">
					</form>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
		<div class="content" <c:if test="${!empty pageId}">id="${pageId}"</c:if>>
			<jsp:doBody />
		</div>
		<hr style="margin: 20px 0 10px;">
		<footer>
			<div class="footer_nav">
				<a href="${ctx}/guestbook" target="_blank">公共留言</a> | <a
					href="${ctx}/search" target="_blank">全站搜索</a> | <a
					href="${ctx}/map-${site.id}${fns:getUrlSuffix()}" target="_blank">站点地图</a>
				| <a href="mailto:thinkgem@163.com">技术支持</a> | <a
					href="${pageContext.request.contextPath}${fns:getAdminPath()}"
					target="_blank">后台管理</a>
			</div>
			<div class="pull-right">${fns:getDate('yyyy年MM月dd日')}</div>
			<div class="copyright">${site.copyright}</div>
		</footer>
	</div>
	<!-- /container -->
</body>
</html>