<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>


<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragrma", "no-cache");
	response.setDateHeader("Expires", 0);
%>

<fk:display configfile="WEB-INF/menu/menu-cms.xml"
	rendererClass="net.frank.framework.web.taglib.navigator.renderer.JQueryEasyUiNavigationRenderer" />