<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="net.frank.framework.bo.BaseEntity,java.util.Map,java.util.Iterator" %>
<script>
///////////////////////////////////////////////////////////////////////////////
// WebFX Tree Config object                                                  //
///////////////////////////////////////////////////////////////////////////////
var webFXTreeConfig = {
	rootIcon        : "${pageContext.request.contextPath}/global/images/xloadtree2b/folder.png",
	openRootIcon    : "${pageContext.request.contextPath}/global/images/xloadtree2b/openfolder.png",
	folderIcon      : "${pageContext.request.contextPath}/global/images/xloadtree2b/folder.png",
	openFolderIcon  : "${pageContext.request.contextPath}/global/images/xloadtree2b/openfolder.png",
	fileIcon        : "${pageContext.request.contextPath}/global/images/xloadtree2b/file.png",
	iIcon           : "${pageContext.request.contextPath}/global/images/xloadtree2b/I.png",
	lIcon           : "${pageContext.request.contextPath}/global/images/xloadtree2b/L.png",
	lMinusIcon      : "${pageContext.request.contextPath}/global/images/xloadtree2b/Lminus.png",
	lPlusIcon       : "${pageContext.request.contextPath}/global/images/xloadtree2b/Lplus.png",
	tIcon           : "${pageContext.request.contextPath}/global/images/xloadtree2b/T.png",
	tMinusIcon      : "${pageContext.request.contextPath}/global/images/xloadtree2b/Tminus.png",
	tPlusIcon       : "${pageContext.request.contextPath}/global/images/xloadtree2b/Tplus.png",
	plusIcon        : "${pageContext.request.contextPath}/global/images/xloadtree2b/plus.png",
	minusIcon       : "${pageContext.request.contextPath}/global/images/xloadtree2b/minus.png",
	blankIcon       : "${pageContext.request.contextPath}/global/images/xloadtree2b/blank.png",
	defaultText     : "Tree Item",
	defaultAction   : null,
	defaultBehavior : "classic",
	usePersistence	: false
};


var _TREE_NODE_ICON = new Array();
<%



Map<Long, BaseEntity> typeClassMap = (Map<Long, BaseEntity>)request.getAttribute("typeClassMap"); 
for(Iterator<Long> it=typeClassMap.keySet().iterator();it.hasNext();){
	Long key=it.next();
	BaseEntity oo= typeClassMap.get(key);
	String imageFileName = oo.getNodeIcon().substring(oo.getNodeIcon().lastIndexOf("/"));
	String imageFileName2 = oo.getNodeOpenIcon().substring(oo.getNodeOpenIcon().lastIndexOf("/"));
%>
_TREE_NODE_ICON['<%=key%>'] = new Array();
_TREE_NODE_ICON['<%=key%>']['nodeIcon'] = '${pageContext.request.contextPath}/global/images/xloadtree2b/<%=imageFileName%>';
_TREE_NODE_ICON['<%=key%>']['nodeOpenIcon'] = '${pageContext.request.contextPath}/global/images/xloadtree2b/<%=imageFileName2%>';
<%}%>

</script>