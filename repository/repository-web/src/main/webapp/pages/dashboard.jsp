<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="net.frank.framework.security.Session,net.frank.framework.bo.Limit,java.math.BigDecimal" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<fk:cs/>

<c:if test="${!(cs.account.resource.id eq cs.account.resource.ownResourceId)}">
<h2><bean:message key="common.message.account.not.active" /></h2>
</c:if>
<c:if test="${(cs.account.resource.id eq cs.account.resource.ownResourceId)}">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/jquery/jqplot/scripts/plugins/jqplot.pieRenderer.js"></script>
	
<%
	Session mySession = (Session)pageContext.getAttribute("cs");
	if(mySession.getAttribute("REPO_CAPACITY")!=null){
		Limit limit = (Limit)mySession.getAttribute("REPO_CAPACITY");
		Long total = limit.getLimitValue();
		Long current = limit.getCurrentValue();
		BigDecimal pu= new BigDecimal(1024*1024);
		BigDecimal _total = new BigDecimal(total);
		_total.setScale(2,BigDecimal.ROUND_HALF_UP);
		_total = _total.divide(pu);
		BigDecimal _current = null;
		if(current != 0){
			_current = new BigDecimal(current);
			_current.setScale(2,BigDecimal.ROUND_HALF_UP);
			_current = _current.divide(pu);
		}else{
			_current = new BigDecimal(current);
		}
		BigDecimal _unused = new BigDecimal(total - current);
		_unused.setScale(2,BigDecimal.ROUND_HALF_UP);
		_unused = _unused.divide(pu);
		
		String _currentValue = _current.toString();
		String _unusedValue = _unused.toString();
%>
<script type="text/javascript">
$(function(){
	var data =[['Used Area',<%=_currentValue%>],['Free Area',<%=_unusedValue%>]];
	$.jqplot('chartDiv',[data],
		{
			seriesDefaults:{
				renderer: jQuery.jqplot.PieRenderer,
				rendererOptions:{
					showDataLabels:true,
					
				}
			},
			legend:{show:true,location:'e'}
		}
	);
});
</script>
<%
	}
%>
<bean:message key="common.dashboard.your.repository.inform" />
<div id="chartDiv" style="height:400px;width:400px;"></div>
</c:if>