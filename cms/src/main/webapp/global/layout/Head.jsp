<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/global/css/style.css">
<style type="text/css">
<jsp:include page="/global/css/agd-mailer-css.jsp"/>
</style>
<script type="text/javascript">
function logout(){
	if (confirm("Do you logout?")) {
		//if(self.frameElement.tagName=='IFRAME'){
		self.parent.location = '${pageContext.request.contextPath}/logout.do';
		//}
	}
}
</script>
</head>
<fk:cs />
<body>
<table width="100%" class="head" border="0"> 
	<tr height="135px">
		<td align="center" valign="middle">
			<img alt="AGD-CMS" src="../images/Header.png" height="135px">
		</td>
	</tr>
	<tr class="head_below">
		<td>
			<table width="100%">
				<tr>
					<td width="50%" class="left">
						<bean:message key="head.welcome"/> &nbsp; 
						${cs.userDetails.name}&nbsp;
						<bean:message key="common.comma"/> 
						<a href="#" onclick="logout()"><bean:message key="head.logout"/></a>
					</td>
					<td class="right">
						<bean:message key="head.logged.time"/> &nbsp; 
						<bean:message key="common.colon"/> &nbsp; 
						<fmt:formatDate value="${cs.loginTime}" pattern="dd/MM/yyyy hh:mm:ss a"/>
					</td>
				</tr>
			</table>	
		</td>
	</tr>
</table>
</body>
</html>