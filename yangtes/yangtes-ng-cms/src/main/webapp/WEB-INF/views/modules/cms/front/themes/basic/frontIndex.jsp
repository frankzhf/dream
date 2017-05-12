<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout/front"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:cmsBasic title="首页">
	<div class="hero-unit" style="padding-bottom: 35px; margin: 10px 0;">
		<c:set var="article" value="${fnc:getArticle('2')}" />
		<h1>${fns:abbr(article.title,28)}</h1>
		<p></p>
		<p>${fns:abbr(fns:replaceHtml(article.articleData.content),260)}</p>
		<p>
			<a href="${article.url}" class="btn btn-primary btn-large">&nbsp;&nbsp;&nbsp;查看详情
				&raquo;&nbsp;&nbsp;&nbsp;</a>
		</p>
	</div>
	<div class="row">
		<div class="span6">
			<h4>
				<small><a href="${ctx}/list-2${urlSuffix}"
					class="pull-right">更多&gt;&gt;</a></small>J2EE知识库
			</h4>
			<ul>
				<c:forEach items="${fnc:getArticleList(site.id, 2, 8, '')}"
					var="article">
					<li><span class="pull-right"><fmt:formatDate
								value="${article.updateDate}" pattern="yyyy.MM.dd" /></span><a
						href="${article.url}" style="color:${article.color}">${fns:abbr(article.title,28)}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="span6">
			<h4>
				<small><a href="${ctx}/list-11${urlSuffix}"
					class="pull-right">更多&gt;&gt;</a></small>Yangtes
			</h4>
			<ul>
				<c:forEach items="${fnc:getArticleList(site.id, 11, 8, '')}"
					var="article">
					<li><span class="pull-right"><fmt:formatDate
								value="${article.updateDate}" pattern="yyyy.MM.dd" /></span><a
						href="${article.url}" style="color:${article.color}">${fns:abbr(article.title,28)}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</layout:cmsBasic>
