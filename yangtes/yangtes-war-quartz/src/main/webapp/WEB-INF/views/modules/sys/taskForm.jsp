<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<layout:default title="任务管理">
	<script type="text/javascript">
	</script>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/quartz/list">任务列表</a></li>
		<li class="active"><a href="${ctx}/quartz/form?id=${user.id}">任务<shiro:hasPermission name="sys:quartz:edit">修改</shiro:hasPermission><shiro:lacksPermission name="sys:quartz:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="form" action="${ctx}/quartz/save" method="post" class="form-horizontal">
		<form:hidden path="dataEntity.id"/>
		<form:hidden path="dataEntity.clazzName"/>
		<form:hidden path="dataEntity.branchId"/>
		<form:hidden path="condition.page.pageNo"/>
		<form:hidden path="condition.page.pageSize"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">任务描述:</label>
			<div class="controls">
				<form:input path="dataEntity.desc" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">定时描述:</label>
			<div class="controls">
				<form:input path="dataEntity.ruleDesc" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">状态:</label>
			<div class="controls">
				<c:choose>
					<c:when test="${form.dataEntity.status eq 1}">
						运行中
					</c:when>
					<c:when test="${form.dataEntity.status eq 2}">
						已暂停
					</c:when>
					<c:otherwise>
						异常
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">定时设置:</label>
			<div class="controls">
				<form:input path="dataEntity.timeRule" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:user:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
	
</layout:default>