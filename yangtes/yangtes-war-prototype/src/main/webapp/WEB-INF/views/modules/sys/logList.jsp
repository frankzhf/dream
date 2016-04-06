<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<layout:default title="日志管理">
	<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
	<!-- 	<ul class="nav nav-tabs"> -->
<%-- 		<li class="active"><a href="${ctx}/sys/log/">日志列表</a></li> --%>
<!-- 	</ul> -->
	<form:form id="searchForm" action="${ctx}/sys/log/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<div>
			<label>操作菜单：</label><input id="title" name="title" type="text" maxlength="50" class="input-mini" value="${log.title}"/>
			<label>用户ID：</label><input id="createBy.id" name="createBy.id" type="text" maxlength="50" class="input-mini" value="${log.createBy.id}"/>
			<label>URI：</label><input id="requestUri" name="requestUri" type="text" maxlength="50" class="input-mini" value="${log.requestUri}"/>
		</div><div style="margin-top:8px;">
			<label>日期范围：&nbsp;</label><input id="beginDate" name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
				value="<fmt:formatDate value="${log.beginDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			<label>&nbsp;--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
				value="<fmt:formatDate value="${log.endDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>&nbsp;&nbsp;
			&nbsp;<label for="exception"><input id="exception" name="exception" type="checkbox"${log.exception eq '1'?' checked':''} value="1"/>只查询异常信息</label>
			&nbsp;&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
		</div>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>操作菜单</th><th>操作用户</th><th>所在公司</th><th>所在部门</th><th>URI</th><th>提交方式</th><th>操作者IP</th><th>操作时间</th></thead>
		<tbody>
			<c:set var="strEnter" value="\n" />
			<c:set var="strTab" value="\t" />	
		<c:forEach items="${page.list}" var="log">
			<tr>
				<td>${log.title}</td>
				<td>${log.createBy.name}</td>
				<td>${log.createBy.company.name}</td>
				<td>${log.createBy.office.name}</td>
				<td><strong>${log.requestUri}</strong></td>
				<td>${log.method}</td>
				<td>${log.remoteAddr}</td>
				<td><fmt:formatDate value="${log.createDate}" type="both"/></td>
			</tr>
			<c:if test="${not empty log.exception}"><tr>
				<td colspan="8" style="word-wrap:break-word;word-break:break-all;">
<%-- 					用户代理: ${log.userAgent}<br/> --%>
<%-- 					提交参数: ${fns:escapeHtml(log.params)} <br/> --%>
					异常信息: <br/>
					${fn:replace(fn:replace(fns:escapeHtml(log.exception), strEnter, '<br/>'), strTab, '&nbsp; &nbsp; ')}</td>
			</tr></c:if>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</layout:default>