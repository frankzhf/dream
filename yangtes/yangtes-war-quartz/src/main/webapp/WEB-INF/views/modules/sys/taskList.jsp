<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<layout:default title="任务管理">
	<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
	    		return false;
	    }
		
		function editItem(dataEntityId){
			$("#dataEntityId").val(dataEntityId);
			$("#searchForm").attr("action",'${ctx}/quartz/form');
			$("#searchForm").submit();
		}
		
		function statusItem(dataEntityId){
			$("#dataEntityId").val(dataEntityId);
			$("#searchForm").attr("action",'${ctx}/quartz/status');
			$("#searchForm").submit();
		}
		
	</script>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/quartz/">任务列表</a></li>
		<%--
		<shiro:hasPermission name="sys:quartz:edit"><li><a href="${ctx}/sys/dict/form?sort=10">字典添加</a></li></shiro:hasPermission>
		 --%>
	</ul>
	<form:form id="searchForm" modelAttribute="form" action="${ctx}/quartz/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="condition.page.pageNo" type="hidden" value="${form.condition.page.pageNo}"/>
		<input id="pageSize" name="condition.page.pageSize" type="hidden" value="${form.condition.page.pageSize}"/>
		<input id="dataEntityId" name="dataEntity.id" type="hidden" value=""/>
		
	</form:form>
	<sys:message content="${message}"/>
	<c:set var="colspanValue" value="4" />
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>任务描述</th>
				<th>定时描述</th>
				<th>更新时间</th>
				<th>状态</th>
				<shiro:hasPermission name="sys:quartz:edit">
					<c:set var="colspanValue" value="5" />
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty form.condition.page.list}">
					<c:forEach items="${form.condition.page.list}" var="item" varStatus="loop">
						<tr>
							<td>${item.desc}</td>
							<td>${item.ruleDesc}</td>
							<td>
								<fmt:formatDate value="${item.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								<c:choose>
									<c:when test="${item.status eq 1}">
										运行中
									</c:when>
									<c:when test="${item.status eq 2}">
										已暂停
									</c:when>
									<c:otherwise>
										异常
									</c:otherwise>
								</c:choose>
							</td>
							<shiro:hasPermission name="sys:quartz:edit">
							<td>
								<a href="#" onclick="statusItem('${item.id}')">
									<c:choose>
									<c:when test="${item.status eq 1}">
										暂停
									</c:when>
									<c:otherwise>
										启动
									</c:otherwise>
									</c:choose>
								</a>
								<a href="#" onclick="editItem('${item.id}')">修改</a>
							</td>
							</shiro:hasPermission>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="${colspanValue}">没有数据</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<div class="pagination">${form.condition.page}</div>
</layout:default>