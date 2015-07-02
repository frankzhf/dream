<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html:html>
<head>
<title><bean:message key="welcome.title" />
</title>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
</head>
<frameset id="mainFrameSet" rows="195,*" frameborder="no" border="0"
	framespacing="0">
	<frame src="${pageContext.request.contextPath}/<tiles:getAsString name='head'/>"
		name="head" id="head" scrolling="no" noresize>
	<frameset id="mainFrameSet" cols="310,*" frameborder="no" border="0"
		framespacing="0">
		<frame src="${pageContext.request.contextPath}/<tiles:getAsString name='menu'/>"
			name="menu" id="menu" scrolling="no" noresize>
		<frame src="${pageContext.request.contextPath}/<tiles:getAsString name='body'/>"
			name="body" id="body" scrolling="auto" noresize>
	</frameset>
</frameset>
</html:html>
