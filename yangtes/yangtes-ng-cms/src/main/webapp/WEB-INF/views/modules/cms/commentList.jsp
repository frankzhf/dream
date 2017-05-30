<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<layout:default title="评论管理">
	<script type="text/javascript">
		function view(href){
			top.$.jBox.open('iframe:'+href,'查看文档',$(top.document).width()-220,$(top.document).height()-180,{
				buttons:{"关闭":true},
				loaded:function(h){
					//$(".jbox-content", top.document).css("overflow-y","hidden");
					//$(".nav,.form-actions,[class=btn]", h.find("iframe").contents()).hide();
				}
			});
			return false;
		}
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/cms/comment/">评论列表</a></li><%--
		<shiro:hasPermission name="cms:comment:edit"><li><a href="${ctx}/cms/comment/form?id=${comment.id}">评论添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="comment" action="${ctx}/cms/comment/" method="post" class="row form-horizontal well">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		
		<div class="row">
			<div class="form-group col-sm-4">
				<label class="col-sm-6 control-label">文档标题：</label>
				<div class="col-sm-6">
					<form:input path="title" htmlEscape="false" maxlength="50" class="form-control"/>
				</div>
			</div>
			<div class="form-group col-sm-4">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			</div>
			<div class="form-group col-sm-4">
				<label class="col-sm-4 control-label">状态：</label>
				<div class="col-sm-8">
					<form:radiobuttons onclick="$('#searchForm').submit();" path="delFlag" 
						items="${fns:getDictList('cms_del_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</div>
			</div>
		</div>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-hover">
		<thead><tr><th>评论内容</th><th>文档标题</th><th>评论人</th><th>评论IP</th><th>评论时间</th><th nowrap="nowrap">操作</th></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="comment">
			<tr>
				<td><a href="javascript:" onclick="$('#c_${comment.id}').toggle()">${fns:abbr(fns:replaceHtml(comment.content),40)}</a></td>
				<td><a href="${pageContext.request.contextPath}${fns:getFrontPath()}/view-${comment.category.id}-${comment.contentId}${fns:getUrlSuffix()}" title="${comment.title}" onclick="return view(this.href);">${fns:abbr(comment.title,40)}</a></td>
				<td>${comment.name}</td>
				<td>${comment.ip}</td>
				<td><fmt:formatDate value="${comment.createDate}" type="both"/></td>
				<td><shiro:hasPermission name="cms:comment:edit">
					<c:if test="${comment.delFlag ne '2'}"><a href="${ctx}/cms/comment/delete?id=${comment.id}${comment.delFlag ne 0?'&isRe=true':''}" 
						onclick="return confirmx('确认要${comment.delFlag ne 0?'恢复审核':'删除'}该评论吗？', this.href)">${comment.delFlag ne 0?'恢复审核':'删除'}</a></c:if>
					<c:if test="${comment.delFlag eq '2'}"><a href="${ctx}/cms/comment/save?id=${comment.id}">审核通过</a></c:if></shiro:hasPermission>
				</td>
			</tr>
			<tr id="c_${comment.id}" style="background:#fdfdfd;display:none;"><td colspan="6">${fns:replaceHtml(comment.content)}</td></tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="box-tools">
		<ui:pagination object="${page}" />
	</div>
</layout:default>