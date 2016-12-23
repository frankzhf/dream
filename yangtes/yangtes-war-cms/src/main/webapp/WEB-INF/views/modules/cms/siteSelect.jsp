<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<layout:default title="站点切换">
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/cms/site/select">站点切换</a></li>
	</ul>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>名称</th><shiro:hasPermission name="cms:view"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${fnc:getSiteList()}" var="site">
			<tr>
				<td><a href="${ctx}/cms/site/select?id=${site.id}">${site.name}</a> ${fnc:getCurrentSiteId() eq site.id ? ' <font color="red">[当前站点]</font>' : ''}</td>
				<shiro:hasPermission name="cms:view"><td>
    				<a href="${ctx}/cms/site/select?id=${site.id}">切换</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</layout:default>