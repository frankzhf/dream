<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>


<layout:default title="选择文章">
	<script type="text/javascript">
		$(document).ready(function() {
			$("input[name=id]").each(function(){
				var articleSelect = null;
				if (top.mainFrame.cmsMainFrame){
					articleSelect = top.mainFrame.cmsMainFrame.articleSelect;
				}else{
					articleSelect = top.mainFrame.articleSelect;
				}
				for (var i=0; i<articleSelect.length; i++){
					if (articleSelect[i][0]==$(this).val()){
						this.checked = true;
					}
				}
				$(this).click(function(){
					var id = $(this).val(), title = $(this).attr("title");
					if (top.mainFrame.cmsMainFrame){
						top.mainFrame.cmsMainFrame.articleSelectAddOrDel(id, title);
					}else{
						top.mainFrame.articleSelectAddOrDel(id, title);
					}
				});
			});
		});
		function view(href){
			top.$.jBox.open('iframe:'+href,'查看文章',$(top.document).width()-220,$(top.document).height()-120,{
				buttons:{"关闭":true},
				loaded:function(h){
					$(".jbox-content", top.document).css("overflow-y","hidden");
					$(".nav,.form-actions,[class=btn]", h.find("iframe").contents()).hide();
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
	<div style="margin:10px;">
		<form:form id="searchForm" modelAttribute="article" action="${ctx}/cms/article/selectList" method="post" class="row form-horizontal well">
			<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
			<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
			
			<div class="row">
				<div class="form-group col-sm-4">
					<label class="col-sm-4 control-label">栏目：</label>
					<div class="col-sm-8">
						<sys:treeselect id="category" name="category.id" value="${article.category.id}" labelName="category.name" 
							labelValue="${article.category.name}" title="栏目" url="/cms/category/treeData" module="article" 
							selectScopeModule="true" notAllowSelectRoot="false" notAllowSelectParent="true"/>
					</div>
				</div>
				<div class="form-group col-sm-4">
					<label class="col-sm-4 control-label">标题：</label>
					<div class="col-sm-8">
						<form:input path="title" htmlEscape="false" maxlength="50" class="form-control"/>
					</div>
				</div>
				<div class="form-group col-sm-4">
					<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
				</div>
			</div>
		</form:form>
		<table id="contentTable" class="table table-hover">
			<thead><tr><th style="text-align:center;">选择</th><th>栏目</th><th>标题</th><th>权重</th><th>点击数</th><th>发布者</th><th>更新时间</th></tr></thead>
			<tbody>
			<c:forEach items="${page.list}" var="article">
				<tr>
					<td style="text-align:center;"><input type="checkbox" name="id" value="${article.id}" title="${fns:abbr(article.title,40)}" /></td>
					<td><a href="javascript:" onclick="$('#categoryId').val('${article.category.id}');$('#categoryName').val('${article.category.name}');$('#searchForm').submit();return false;">${article.category.name}</a></td>
					<td><a href="${ctx}/cms/article/form?id=${article.id}" title="${article.title}" onclick="return view(this.href);">${fns:abbr(article.title,40)}</a></td>
					<td>${article.weight}</td>
					<td>${article.hits}</td>
					<td>${article.createBy.name}</td>
					<td><fmt:formatDate value="${article.updateDate}" type="both"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="box-tools">
			<ui:pagination object="${page}"/>
		</div>
	</div>
</layout:default>