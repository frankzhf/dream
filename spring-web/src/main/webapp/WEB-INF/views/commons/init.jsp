<%@page contentType="application/x-javascript; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fk" uri="http://www.frank.net/jsp/tags" %>

<fk:cs />

var UiApp = {
    contextPath : '${pageContext.request.contextPath}',
    isLogin : ${cs.status eq 1 ? true:false},
    timeoutInterval	: '${pageContext.request.session.maxInactiveInterval}',
    timeoutLogout : 10,
    dateFormat: 'dd/MM/yyyy',
    dateTimeFormat: 'dd/MM/yyyy HH:mm'
};