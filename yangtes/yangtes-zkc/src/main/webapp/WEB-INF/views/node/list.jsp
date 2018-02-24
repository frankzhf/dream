<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
<meta http-equiv="keywords" content="zookeeper,console">
<meta http-equiv="description" content="Zookeeper Console">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<script src="${pageContext.request.contextPath}/resources/zkc/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/zkc/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/zkc/js/commonMethod.js"></script>
<script src="${pageContext.request.contextPath}/resources/zkc/js/jquery.ztree.core-3.4.js"></script>
<script src="${pageContext.request.contextPath}/resources/zkc/js/jquery.ztree.excheck-3.4.js"></script>
<script src="${pageContext.request.contextPath}/resources/zkc/js/lhgdialog.js"></script>
<script src="${pageContext.request.contextPath}/resources/zkc/js/node/node-manage.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/zkc/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/zkc/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/zkc/css/select.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/zkc/css/loading.css" />
<style type="text/css">
</style>
</head>

<body>
	<div class="r_content">
		<div class="header">
			<h3>节点管理</h3>
		</div>
		<div class="outer">
			<div class="origanization_left" style="overflow: auto;">
				<ul class="ztree" id="ztree"></ul>
			</div>
			<div class="origanization_right" id="childrenNode"></div>
		</div>
		<div id="rMenu" class="select"
			style="visibility: hidden; position: absolute;">
			<ul class="oSbox" style="width: 70px;">
				<li id="m_add">增加节点</li>
				<li id="m_edit">修改节点</li>
				<li id="m_del">删除节点</li>
			</ul>
		</div>
	</div>
	<div class="d_mask" style="display: none;"></div>
	<jsp:include page="../common/loading.jsp" />
</body>
<script type="text/javascript">
  var zTree;
  $(function(){
		var setting = {check: {enable: true},data: {simpleData: {enable: true}}, view : {showIcon: false}, callback: {beforeClick: function(treeId, treeNode, clickFlag){
			return false;
		}}};
		var setting = {
			check: {
				enable: false
			},
			async:{
				autoParam:["id"],
				contentType:"application/x-www-form-urlencoded",
				enable:true,
				type:"post",
				url:"ajaxGetChildren"
			},
			data:{
				simpleData :{
				   enable:true
				}
			},
			callback: {
				onClick: function(event, treeId, treeNode, clickFlag){
					var param = {
						id:treeNode.id
					};
					$('#childrenNode').load('childrenList',param,function(){
					});
				},
				onExpand: function(event, treeId, treeNode){
				},
				onRightClick : function(event, treeId, treeNode){
					zTree.selectNode(treeNode);
					showRMenu("node", event.clientX, event.clientY);
				}
				
			}
		};
		zTree = $.fn.zTree.init($('#ztree'), setting, ${rootNodeJson});
  });
  </script>
</html>
