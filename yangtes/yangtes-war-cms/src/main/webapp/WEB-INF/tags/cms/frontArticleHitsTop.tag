<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>

<%@ attribute name="category" type="com.heinqi.yangtes.jee.modules.cms.entity.Category" required="true" description="栏目对象"%>
<%@ attribute name="pageSize" type="java.lang.Integer" required="false" description="页面大小"%>
<c:forEach items="${fnc:getArticleList(category.site.id, category.id, not empty pageSize?pageSize:8, 'posid:2, orderBy: \"hits desc\"')}" var="article">
	<li><a href="${ctx}/view-${article.category.id}-${article.id}${urlSuffix}" style="color:${article.color}" title="${article.title}">${fns:abbr(article.title,16)}</a></li>
</c:forEach>