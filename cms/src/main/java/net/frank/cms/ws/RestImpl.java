package net.frank.cms.ws;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;



import net.frank.cms.common.BaseJersey;
import net.frank.commons.CommonConstants;
import net.frank.commons.util.StringUtil;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.service.CacheService;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.ws.define.WsRequest;
import net.frank.framework.ws.define.WsResponse;
import net.frank.framework.ws.process.BoXmlUtil;

@Path("/rest")
public class RestImpl extends BaseJersey {

	private BoXmlUtil boXmlUtil;

	public RestImpl() {
		this.boXmlUtil = (BoXmlUtil) getBean("boXmlUtil");
	}

	@GET
	@Path("/getByPath/{path}")
	@Produces("text/xml")
	public String getResource(@PathParam("path") String path) {
		log.debug(path);
		String _path = path.replaceAll("_path_", "/");
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		Resource resource = cmsService.getResource(_path, getClientSession());
		WsResponse wsResponse = new WsResponse();
		wsResponse.setResource(resource);
		wsResponse.setMessageNumber(resource.getCode());
		return boXmlUtil.wsResponse2Xml(wsResponse);
	}

	/**
	 * 
	 * @return format 
	 * id#resourceId#typeKey#entityClassName#descriptsion
	 * ((##id#resourceId#typeKey#entityClassName#descriptsion)+)
	 */
	@GET
	@Path("/meta")
	@Produces("text/xml")
	public String getMetaInfo(){
		StringBuffer sb =  new StringBuffer(
				CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		CacheService cacheService = (CacheService) getBean(ServiceNames.CACHE_SERVICE);
		//PermissionService permissionService = (PermissionService) getBean(ServiceNames.PERMISSION_SERVICE);
		Map<Long,Type> typeContent = cacheService.getTypeContent();
		for(Iterator<Long> it= typeContent.keySet().iterator();it.hasNext();){
			Long key = it.next();
			Type currentType = typeContent.get(key);
			//if (permissionService.checkReadPermission(currentType.getResource(),getClientSession())){
				if(sb.length()!=0){
					sb.append(CommonConstants.ARRAY_SPLIT);
				}
				String typeKey = currentType.getTypeKey();
				String entityClassName = currentType.getEntityClassName();
				String description = currentType.getDescription();
				Long id = currentType.getId();
				Long resourceId = currentType.getResource().getId();
				sb.append(id).append(CommonConstants.ARRAY_SPLIT_SEC).append(resourceId).append(CommonConstants.ARRAY_SPLIT_SEC)
					.append(typeKey).append(CommonConstants.ARRAY_SPLIT_SEC).append(entityClassName).append(CommonConstants.ARRAY_SPLIT_SEC);
				if(StringUtil.isEmpty(description)){
					sb.append(CommonConstants.SPACE);
				}else{
					sb.append(description);
				}
			//}
		}
		return sb.toString();
	}

	@POST
	@Path("/get")
	@Produces("text/xml")
	public String getResource(InputStream inputInfo) throws Exception {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		long currentTime = System.currentTimeMillis();
		try {
			String wsRequestXml = inputStream2String(inputInfo);
			WsRequest wsRequest = boXmlUtil.xml2WsRequest(wsRequestXml);
			Long resourceId = wsRequest.getResource().getId();
			Resource resource = new Resource();
			resource.setId(resourceId);
			resource = cmsService.getResource(resource, getClientSession());
			WsResponse wsResponse = new WsResponse();
			wsResponse.setResource(resource);
			wsResponse.setMessageNumber(resource.getCode());
			return boXmlUtil.wsResponse2Xml(wsResponse);
		} finally {
			System.out.println(System.currentTimeMillis() - currentTime);
		}
	}
	
	@POST
	@Path("/save") 
	@Produces("text/xml")
	public String saveResource(InputStream resourceInfo)throws Exception{
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		long currentTime = System.currentTimeMillis();
		try {
			byte[] buf = new byte[4096]; 
			int flag = -1;
			ByteArrayOutputStream bis = new ByteArrayOutputStream();
			while((flag =resourceInfo.read(buf)) !=-1){
				bis.write(buf,0,flag);
			}
			String strResourceInfo = new String(bis.toString());
			BoXmlUtil boXmlUtil = (BoXmlUtil)getBean("boXmlUtil");
			WsRequest wsRequest = boXmlUtil.xml2WsRequest(strResourceInfo);
			WsResponse wsResponse = new WsResponse();
			if(wsRequest!=null && wsRequest.getResource()!=null){
				Resource resource = wsRequest.getResource();
				if(resource!=null){
					Resource rt = null;
					if(resource.getId()==null){
						rt = cmsService.createResource(resource, getClientSession());
					}else{
						rt = cmsService.updateResource(resource, getClientSession());
					}
					wsResponse.setResource(rt);
					wsResponse.setMessageNumber(rt.getCode());
				}else{
					wsResponse.setResource(null);
					wsResponse.setMessageNumber(CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS);
				}
				return boXmlUtil.wsResponse2Xml(wsResponse);
			}else{
				wsResponse.setResource(null);
				wsResponse.setMessageNumber(CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS);
				return boXmlUtil.wsResponse2Xml(wsResponse);
			}
		} finally {
			System.out.println(System.currentTimeMillis() - currentTime);
		}
		
	}
			
	
	/**
	 * @Path("/save/") public String saveResource(InputStream
	 *                 resourceInfo)throws Exception{ byte[] buf = new
	 *                 byte[4096]; int flag = -1; ByteArrayOutputStream bis =
	 *                 new ByteArrayOutputStream(); while((flag =
	 *                 resourceInfo.read(buf)) !=-1){ bis.write(buf,0,flag); }
	 *                 String strResourceInfo = new String(bis.toString());
	 *                 BoXmlUtil boXmlUtil = (BoXmlUtil)getBean("boXmlUtil");
	 *                 WsRequest wsRequest =
	 *                 boXmlUtil.xml2WsRequest(strResourceInfo);
	 *                 System.out.println(wsRequest);
	 * 
	 *                 }
	 * @Path("/delete/") public String deleteResource(){ return null; }
	 **/
	
	
	/***
	@POST
	@Path("/transferXml")
	@Produces("text/xml")
	public String transferXml(InputStream resourceInfo) throws Exception {
		byte[] buf = new byte[4096];
		int flag = -1;
		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		while ((flag = resourceInfo.read(buf)) != -1) {
			bis.write(buf, 0, flag);
		}
		String strResourceInfo = new String(bis.toString());
		BoXmlUtil boXmlUtil = (BoXmlUtil) getBean("boXmlUtil");
		WsRequest wsRequest = boXmlUtil.xml2WsRequest(strResourceInfo);
		System.out.println(wsRequest);
		if (wsRequest != null && wsRequest.getResource() != null) {
			Resource resource = wsRequest.getResource();
			BaseEntity bo = toBo(resource);
			if (bo instanceof BusinessObject) {
				if (resource.getTypeId().equals(CommonConstants.TYPE.IMAGE)) {
					Image image = (Image) bo;
					FileOutputStream fos = new FileOutputStream("d:/temp/"
							+ image.getImageName());
					fos.write(image.getContent());
					fos.flush();
					fos.close();
				}
				if (resource.getTypeId().equals(CommonConstants.TYPE.ARTICLE)) {
					Article article = (Article) bo;
					System.out.println(article.getContent());
				}
			}
		}
		return "<result>OK</result>";
	}
	
	private BaseEntity toBo(Resource resource) {
		if (CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
			return resource;
		} else {
			BusinessObject bo = resource.getObject();
			bo.setResource(resource);
			resource.setObject(null);
			return bo;
		}
	}
	***/
}
