<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Map,java.util.Iterator,java.util.HashMap"%>
<%@ page import="net.frank.framework.bo.BaseEntity,net.frank.framework.bo.Type"%>
<%@ page import="net.frank.framework.service.CacheService,net.frank.framework.service.ServiceNames"%>
<%@ page import="net.frank.framework.spring.SpringContextHolder"%>

<script>
///////////////////////////////////////////////////////////////////////////////
// WebFX Tree Config object                                                  //
///////////////////////////////////////////////////////////////////////////////
var webFXTreeConfig = {
	rootIcon        : "${pageContext.request.contextPath}/resources/xtree2/img/folder.png",
	openRootIcon    : "${pageContext.request.contextPath}/resources/xtree2/img/openfolder.png",
	folderIcon      : "${pageContext.request.contextPath}/resources/xtree2/img/folder.png",
	openFolderIcon  : "${pageContext.request.contextPath}/resources/xtree2/img/openfolder.png",
	fileIcon        : "${pageContext.request.contextPath}/resources/xtree2/img/file.png",
	iIcon           : "${pageContext.request.contextPath}/resources/xtree2/img/I.png",
	lIcon           : "${pageContext.request.contextPath}/resources/xtree2/img/L.png",
	lMinusIcon      : "${pageContext.request.contextPath}/resources/xtree2/img/Lminus.png",
	lPlusIcon       : "${pageContext.request.contextPath}/resources/xtree2/img/Lplus.png",
	tIcon           : "${pageContext.request.contextPath}/resources/xtree2/img/T.png",
	tMinusIcon      : "${pageContext.request.contextPath}/resources/xtree2/img/Tminus.png",
	tPlusIcon       : "${pageContext.request.contextPath}/resources/xtree2/img/Tplus.png",
	plusIcon        : "${pageContext.request.contextPath}/resources/xtree2/img/plus.png",
	minusIcon       : "${pageContext.request.contextPath}/resources/xtree2/img/minus.png",
	blankIcon       : "${pageContext.request.contextPath}/resources/xtree2/img/blank.png",
	defaultText     : "Tree Item",
	defaultAction   : null,
	defaultBehavior : "classic",
	usePersistence	: false
};


var _TREE_NODE_ICON = new Array();
<%
String imgPath = "resources/xtree2/img";
CacheService cacheService = (CacheService)SpringContextHolder.getApplicationContext().getBean(ServiceNames.CACHE_SERVICE);
Map<Long, Type> typeContent = cacheService.getTypeContent();
Map<Long, BaseEntity> typeClassMap = new HashMap<Long, BaseEntity>();
for (Iterator<Long> it = typeContent.keySet().iterator(); it.hasNext();) {
	Long resourceId = it.next();
	typeClassMap.put(
			resourceId,
			(BaseEntity) Class.forName(
					typeContent.get(resourceId).getEntityClassName())
					.newInstance());
}
request.setAttribute("typeClassMap", typeClassMap); 

for(Iterator<Long> it=typeClassMap.keySet().iterator();it.hasNext();){
	Long key=it.next();
	BaseEntity oo= typeClassMap.get(key);
	String imageFileName = oo.getNodeIcon().substring(oo.getNodeIcon().lastIndexOf("/"));
	String imageFileName2 = oo.getNodeOpenIcon().substring(oo.getNodeOpenIcon().lastIndexOf("/"));
%>
_TREE_NODE_ICON['<%=key%>'] = new Array();
_TREE_NODE_ICON['<%=key%>']['nodeIcon'] = '${pageContext.request.contextPath}/<%=imgPath+imageFileName%>';
_TREE_NODE_ICON['<%=key%>']['nodeOpenIcon'] = '${pageContext.request.contextPath}/<%=imgPath+imageFileName2%>';
<%}%>
	
</script>