<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>

<%@ attribute name="category" type="com.heinqi.yangtes.jee.modules.cms.entity.Category" required="true" description="栏目对象"%>

<li><strong>当前位置：</strong><a href="${ctx}/index-${site.id}${urlSuffix}">首页</a></li><c:forEach items="${fnc:getCategoryListByIds(category.parentIds)}" var="tpl">
	<c:if test="${tpl.id ne '1'}"><li><span class="divider">/</span> <a href="${ctx}/list-${tpl.id}${urlSuffix}">${tpl.name}</a></li></c:if>
</c:forEach><li><span class="divider">/</span> <a href="${ctx}/list-${category.id}${urlSuffix}">${category.name}</a></li>