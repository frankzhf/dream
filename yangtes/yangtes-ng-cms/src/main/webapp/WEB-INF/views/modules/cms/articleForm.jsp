<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>

<layout:default title="文章管理">
	<script type="text/javascript">
		$(document).ready(function() {
            if($("#link").val()){
                $('#linkBody').show();
                $('#url').attr("checked", true);
            }
			$("#title").focus();
			$("#input").validate({
				submitHandler: function(form){
                    if ($("#categoryId").val()==""){
                        $("#categoryName").focus();
                        alertx('请选择归属栏目');
                    }else if (CKEDITOR.instances.content.getData()=="" && $("#link").val().trim()==""){
                    	alertx('请填写正文');
                    }else{
                        loading('正在提交，请稍等...');
                        form.submit();
                    }
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					renderErrorMsg(error, element);
				}
			});
		});
	</script>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cms/article/?category.id=${article.category.id}">文章列表</a></li>
		<li class="active"><a href="<c:url value='${fns:getAdminPath()}/cms/article/?id=${article.id}&category.id=${article.category.id}'><c:param name='category.name' value='${article.category.name}'/></c:url>">文章<shiro:hasPermission name="cms:article:edit">${not empty article.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="cms:article:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="article"
		action="${ctx}/cms/article/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">归属栏目:</label>
				<div class="input-group">
					<sys:treeselect id="category" name="category.id" value="${article.category.id}" labelName="category.name" labelValue="${article.category.name}"
						title="栏目" url="/cms/category/treeData" module="article" selectScopeModule="true" notAllowSelectRoot="false" notAllowSelectParent="true" cssClass="required"/>
					<span>
	                    <input id="url" type="checkbox" onclick="if(this.checked){$('#linkBody').show()}else{$('#linkBody').hide()}$('#link').val()"><label for="url">外部链接</label>
	                </span>
				</div>
			</div>
			<div id="linkBody" class="form-group" style="display:none">
	            <label class="col-sm-2 control-label">外部链接:</label>
	            <div class="input-group">
	                <form:input path="link" htmlEscape="false" maxlength="200" class="input-xlarge"/>
	                <span class="help-inline">绝对或相对地址。</span>
	            </div>
	        </div>
			<div class="form-group">
				<label class="col-sm-2 control-label">标题:</label>
				<div class="input-group">
					<form:input path="title" htmlEscape="false" maxlength="200" class="input-xxlarge measure-input required"/>
					&nbsp;<label>颜色:</label>
					<form:select path="color" class="input-mini">
						<form:option value="" label="默认"/>
						<form:options items="${fns:getDictList('color')}" itemLabel="label" itemValue="value" htmlEscape="false" />
					</form:select>
				</div>
			</div>
	        
			<div class="form-group">
				<label class="col-sm-2 control-label">关键字:</label>
				<div class="input-group">
					<form:input path="keywords" htmlEscape="false" maxlength="200" class="input-xlarge"/>
					<span class="help-inline">多个关键字，用空格分隔。</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">权重:</label>
				<div class="input-group">
					<form:input path="weight" htmlEscape="false" maxlength="200" class="input-mini required digits"/>&nbsp;
					<span>
						<input id="weightTop" type="checkbox" onclick="$('#weight').val(this.checked?'999':'0')"><label for="weightTop">置顶</label>
					</span>
					&nbsp;过期时间：
					<input id="weightDate" name="weightDate" type="text" readonly="readonly" maxlength="20" class="input-small Wdate"
						value="<fmt:formatDate value="${article.weightDate}" pattern="yyyy-MM-dd"/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"/>
					<span class="help-inline">数值越大排序越靠前，过期时间可为空，过期后取消置顶。</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">摘要:</label>
				<div class="input-group">
					<form:textarea path="description" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">缩略图:</label>
				<div class="input-group">
	                <input type="hidden" id="image" name="image" value="${article.imageSrc}" />
					<sys:ckfinder input="image" type="thumb" uploadPath="/cms/article" selectMultiple="false"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">正文:</label>
				<div class="input-group">
					<form:textarea id="content" htmlEscape="true" path="articleData.content" rows="4" maxlength="200" class="input-xxlarge"/>
					<sys:ckeditor replace="content" uploadPath="/cms/article" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">来源:</label>
				<div class="input-group">
					<form:input path="articleData.copyfrom" htmlEscape="false" maxlength="200" class="input-xlarge"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">相关文章:</label>
				<div class="input-group">
					<form:hidden id="articleDataRelation" path="articleData.relation" htmlEscape="false" maxlength="200" class="input-xlarge"/>
					<ol id="articleSelectList"></ol>
					<a id="relationButton" href="javascript:" class="btn">添加相关</a>
					<script type="text/javascript">
						var articleSelect = [];
						function articleSelectAddOrDel(id,title){
							var isExtents = false, index = 0;
							for (var i=0; i<articleSelect.length; i++){
								if (articleSelect[i][0]==id){
									isExtents = true;
									index = i;
								}
							}
							if(isExtents){
								articleSelect.splice(index,1);
							}else{
								articleSelect.push([id,title]);
							}
							articleSelectRefresh();
						}
						function articleSelectRefresh(){
							$("#articleDataRelation").val("");
							$("#articleSelectList").children().remove();
							for (var i=0; i<articleSelect.length; i++){
								$("#articleSelectList").append("<li>"+articleSelect[i][1]+"&nbsp;&nbsp;<a href=\"javascript:\" onclick=\"articleSelectAddOrDel('"+articleSelect[i][0]+"','"+articleSelect[i][1]+"');\">×</a></li>");
								$("#articleDataRelation").val($("#articleDataRelation").val()+articleSelect[i][0]+",");
							}
						}
						$.getJSON("${ctx}/cms/article/findByIds",{ids:$("#articleDataRelation").val()},function(data){
							for (var i=0; i<data.length; i++){
								articleSelect.push([data[i][1],data[i][2]]);
							}
							articleSelectRefresh();
						});
						$("#relationButton").click(function(){
							var d = top.dialog({
								title: '添加相关',
								url: '${ctx}/cms/article/selectList?pageSize=8',
								width: 960,
								height: 600,
								button:[{
									id:"btnClose",
									value:"确定",
									autofocus :true,
									callback:function(event){
									}
								}]
							});
							d.showModal();
						});
					</script>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">是否允许评论:</label>
				<div class="input-group">
					<form:radiobuttons path="articleData.allowComment" items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">推荐位:</label>
				<div class="input-group">
					<form:checkboxes path="posidList" items="${fns:getDictList('cms_posid')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">发布时间:</label>
				<div class="input-group">
					<input id="createDate" name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
						value="<fmt:formatDate value="${article.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				</div>
			</div>
			<shiro:hasPermission name="cms:article:audit">
				<div class="form-group">
					<label class="col-sm-2 control-label">发布状态:</label>
					<div class="input-group">
						<form:radiobuttons path="delFlag" items="${fns:getDictList('cms_del_flag')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
						<span class="help-inline"></span>
					</div>
				</div>
			</shiro:hasPermission>
			<shiro:hasPermission name="cms:category:edit">
	            <div class="form-group">
	                <label class="col-sm-2 control-label">自定义内容视图:</label>
	                <div class="input-group">
	                      <form:select path="customContentView" class="input-medium">
	                          <form:option value="" label="默认视图"/>
	                          <form:options items="${contentViewList}" htmlEscape="false"/>
	                      </form:select>
	                      <span class="help-inline">自定义内容视图名称必须以"${article_DEFAULT_TEMPLATE}"开始</span>
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">自定义视图参数:</label>
	                <div class="input-group">
	                      <form:input path="viewConfig" htmlEscape="true"/>
	                      <span class="help-inline">视图参数例如: {count:2, title_show:"yes"}</span>
	                </div>
	            </div>
			</shiro:hasPermission>
			<c:if test="${not empty article.id}">
				<div class="form-group">
					<label class="col-sm-2 control-label">查看评论:</label>
					<div class="input-group">
						<input id="btnComment" class="btn" type="button" value="查看评论" 
							onclick="viewComment('${ctx}/cms/comment/?module=article&contentId=${article.id}&status=0')"/>
						<script type="text/javascript">
							function viewComment(href){
								var d = top.dialog({
									title: '查看评论',
									url: href,
									width: 960,
									height: 600,
									button:[{
										id:"btnClose",
										value:"关闭",
										autofocus :true,
										callback:function(event){
										}
									}]
								});
								d.showModal();
								return false;
							}
						</script>
					</div>
				</div>
			</c:if>
		</div>
		<div class="box-footer">
			<shiro:hasPermission name="cms:article:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</layout:default>