<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<layout:default title="留言管理">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#reContent").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					renderErrorMsg(error, element);
				}
			});
		});
	</script>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cms/guestbook/">留言列表</a></li>
		<li class="active"><a href="${ctx}/cms/guestbook/form?id=${guestbook.id}">留言<shiro:hasPermission name="cms:guestbook:edit">${guestbook.delFlag eq '2'?'审核':'查看'}</shiro:hasPermission><shiro:lacksPermission name="cms:guestbook:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="guestbook" 
		action="${ctx}/cms/guestbook/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="delFlag"/>
		<sys:message content="${message}"/>
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">名称:</label>
				<div class="input-group">
					<c:out value="${guestbook.name}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">邮箱:</label>
				<div class="input-group">
					<c:out value="${guestbook.email}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">电话:</label>
				<div class="input-group">
					<c:out value="${guestbook.phone}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">单位:</label>
				<div class="input-group">
					<c:out value="${guestbook.workunit}"/>
				</div>
			</div>
			<div class="control-group">
				<label class="col-sm-2 control-label">留言分类:</label>
				<div class="input-group">
					<span style="font-weight:bold;"><c:out value="${fns:getDictLabel(guestbook.type, 'cms_guestbook', '无')}"/></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">IP:</label>
				<div class="input-group">
					<c:out value="${guestbook.ip}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">留言时间:</label>
				<div class="input-group">
					<fmt:formatDate value="${guestbook.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">留言内容:</label>
				<div class="input-group">
					<form:textarea path="content" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge" disabled="true"/>
				</div>
			</div>
			<c:if test="${not empty guestbook.reUser}">
				<div class="form-group">
					<label class="col-sm-2 control-label">回复人:</label>
					<div class="input-group">
						<c:out value="${guestbook.reUser.name}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">回复时间:</label>
					<div class="input-group">
						<fmt:formatDate value="${guestbook.reDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</div>
				</div>
			</c:if>
			<c:if test="${guestbook.delFlag eq '2'}">
			<div class="form-group">
				<label class="col-sm-2 control-label">回复内容:</label>
				<div class="input-group">
					<form:textarea path="reContent" htmlEscape="false" rows="4" maxlength="200" class="required input-xxlarge"/>
				</div>
			</div>
			</c:if>
		</div>
		<div class="box-footer">
			<c:if test="${guestbook.delFlag eq '2'}">
				<shiro:hasPermission name="cms:guestbook:edit">
					<input id="btnSubmit" class="btn btn-success" type="submit" value="通 过" onclick="$('#delFlag').val('0')"/>&nbsp;
					<input id="btnSubmit" class="btn btn-inverse" type="submit" value="驳 回" onclick="$('#delFlag').val('1')"/>&nbsp;
				</shiro:hasPermission>
			</c:if>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</layout:default>