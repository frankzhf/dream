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
_TREE_NODE_ICON['<%=key%>']['nodeIcon'] = '${pageContext.request.contextPath}/global/images/xloadtree2b/<%=imageFileName%>';
_TREE_NODE_ICON['<%=key%>']['nodeOpenIcon'] = '${pageContext.request.contextPath}/global/images/xloadtree2b/<%=imageFileName%>';
<%}%>
	
</script>