<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="topnavbar" class="navbar navbar-inverse navbar-fixed-top">
	<div id="topnavbarinner" class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target="#header-nav-collapse"> <span class="icon-bar"></span>
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="logo brand" href="#">&nbsp;</a>
			
				
			<div id="header-nav-collapse" class="nav-collapse collapse nav_menu_width" style="padding-top: 30px; float:left;">
				<ul class="nav" style="float:left; margin-right: 0px;">
					<li id="cms" class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="menu.item.cms" /><b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li id="cmsBrowser"><a href="#" onclick="menuItemLocation('${pageContext.request.contextPath}/core/browser')"><span class="icon-hdd"></span><spring:message code="menu.item.resource.browser" /></a>
							<li id="cmsChmod"><a href="#" onclick="menuItemLocation('${pageContext.request.contextPath}/core/chmod')"><span class="icon-magic"></span><spring:message code="menu.item.resource.chmod" /></a>
							<li id="cmsMove"><a href="#" onclick="menuItemLocation('${pageContext.request.contextPath}/core/move')"><span class="icon-cogs"></span><spring:message code="menu.item.resource.move" /></a>
						</ul>
					</li>
					<li id="about"><a href="#" onclick="popupAbout()"><spring:message code="menu.item.about" /></a></li>
					<li id="logout"><a href="#" onclick="logout('<spring:message code="confirm.logout" />')"><spring:message code="menu.item.logout" /></a></li>
				</ul>
             </div>
		</div>
	</div>
</div>