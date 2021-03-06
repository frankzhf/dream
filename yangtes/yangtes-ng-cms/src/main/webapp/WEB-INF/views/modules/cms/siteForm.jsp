<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<layout:default title="站点管理">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
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
		<li><a href="${ctx}/cms/site/">站点列表</a></li>
		<li class="active"><a href="${ctx}/cms/site/form?id=${site.id}">站点<shiro:hasPermission name="cms:site:edit">${not empty site.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="cms:site:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="site" action="${ctx}/cms/site/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">站点名称:</label>
				<div class="input-group">
					<form:input path="name" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">站点标题:</label>
				<div class="input-group">
					<form:input path="title" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">站点Logo:</label>
				<div class="input-group">
					<form:hidden path="logo" htmlEscape="false" maxlength="255" class="input-xlarge"/>
					<sys:ckfinder input="logo" type="images" uploadPath="/cms/site"/>
					<span class="help-inline">建议Logo大小：1000 × 145（像素）</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">描述:</label>
				<div class="input-group">
					<form:textarea path="description" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">关键字:</label>
				<div class="input-group">
					<form:input path="keywords" htmlEscape="false" maxlength="200"/>
					<span class="help-inline">填写描述及关键字，有助于搜索引擎优化</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">默认主题:</label>
				<div class="input-group">
					<form:select path="theme" class="input-medium">
						<form:options items="${fns:getDictList('cms_theme')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">版权信息:</label>
				<div class="input-group">
					<form:textarea id="copyright" htmlEscape="true" path="copyright" rows="4" maxlength="200" class="input-xxlarge"/>
					<sys:ckeditor replace="copyright" uploadPath="/cms/site" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">自定义首页视图:</label>
				<div class="input-group">
					<form:input path="customIndexView" htmlEscape="false" maxlength="200"/>
				</div>
			</div>
		</div>
		<div class="box-footer">
			<shiro:hasPermission name="cms:site:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</layout:default>