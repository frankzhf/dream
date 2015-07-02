<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html:html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<script type="text/javascript">
	var WEB_ROOT = '${pageContext.request.contextPath}';
</script>

<script type="text/javascript">
	function directParent() {
		parent.navigation.treeNav.UpdateTreeNode(${resource.parentId});
	}
</script>
</head>
<body>
<h3><bean:message key="common.confirm.success" /></h3>
<br/>
<br/>
<br/>
<input type="button" value="O.K" onclick="directParent()" />
</body>
</html:html>