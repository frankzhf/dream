<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@attribute name="treeTag" required="false" %>

<!DOCTYPE html>
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">

<link type="text/css" rel="stylesheet"
	href='${pageContext.request.contextPath}/resources/xtree2/css/xtree2.css' />

<jsp:include page="/tree/config" />
<script type="text/javascript">
var UiApp = {
	contextPath : '${pageContext.request.contextPath}'
}
</script>
<script
	src='${pageContext.request.contextPath}/resources/xtree2/js/xtree2.js'></script>
<script
	src='${pageContext.request.contextPath}/resources/xtree2/js/xloadtree2.js'></script>
<script
	src='${pageContext.request.contextPath}/resources/xtree2/js/tree-ext.js'></script>
<script
	src='${pageContext.request.contextPath}/resources/jquery/jquery-1.9.1.min.js'></script>
</head>
<body>
	<jsp:doBody/>
</body>
</html>