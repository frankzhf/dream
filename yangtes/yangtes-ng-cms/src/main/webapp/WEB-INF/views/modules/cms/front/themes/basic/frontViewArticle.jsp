<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout/front"%>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld"%>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<layout:cmsBasic title="${article.title} - ${category.name}"
	description="${article.description} ${category.description}"
	keywords="${article.keywords} ${category.keywords}">
	<link href="${pageContext.request.contextPath}/resources/video-js-5.18.4/video-js.min.css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/resources/video-js-5.18.4/video.js"></script>
	<script src="${pageContext.request.contextPath}/resources/video-js-5.18.4/hls/videojs-contrib-hls.min.js"></script>
	<script type="text/javascript">
		$(document).ready(
				function() {
					if ("${category.allowComment}" == "1"
							&& "${article.articleData.allowComment}" == "1") {
						$("#comment").show();
						page(1);
					}
				});
		function page(n, s) {
			$.get("${ctx}/comment", {
				theme : '${site.theme}',
				'category.id' : '${category.id}',
				contentId : '${article.id}',
				title : '${article.title}',
				pageNo : n,
				pageSize : s,
				date : new Date().getTime()
			}, function(data) {
				$("#comment").html(data);
			});
		}
	</script>

	<div class="row">
		<div class="span2">
			<h4>栏目列表</h4>
			<ol>
				<cms:frontCategoryList categoryList="${categoryList}" />
			</ol>
			<h4>推荐阅读</h4>
			<ol>
				<cms:frontArticleHitsTop category="${category}" />
			</ol>
		</div>
		<div class="span10">
			<ul class="breadcrumb">
				<cms:frontCurrentPosition category="${category}" />
			</ul>
		</div>
		<div class="span10">
			<div class="row">
				<div class="span10">
					<h3
						style="color: #555555; font-size: 20px; text-align: center; border-bottom: 1px solid #ddd; padding-bottom: 15px; margin: 25px 0;">${article.title}</h3>
					<c:if test="${not empty article.description}">
						<div>摘要：${article.description}</div>
					</c:if>
					<div>${article.articleData.content}</div>
					<div
						style="border-top: 1px solid #ddd; padding: 10px; margin: 25px 0;">
						发布者：${article.user.name} &nbsp; 点击数：${article.hits} &nbsp; 发布时间：
						<fmt:formatDate value="${article.createDate}"
							pattern="yyyy-MM-dd HH:mm:ss" />
						&nbsp; 更新时间：
						<fmt:formatDate value="${article.updateDate}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					</div>
				</div>
			</div>
			<div class="row">
				<div id="comment" class="hide span10">正在加载评论...</div>
			</div>
			<div class="row">
				<div class="span10">
					<h5>相关文章</h5>
					<ol>
						<c:forEach items="${relationList}" var="relation">
							<li style="float: left; width: 230px;"><a
								href="${ctx}/view-${relation[0]}-${relation[1]}${urlSuffix}">${fns:abbr(relation[2],30)}</a></li>
						</c:forEach>
					</ol>
				</div>
			</div>
		</div>
	</div>
</layout:cmsBasic>
