/*     */ package net.frank.cms.ws;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import javax.ws.rs.GET;
/*     */ import javax.ws.rs.POST;
/*     */ import javax.ws.rs.Path;
/*     */ import javax.ws.rs.PathParam;
/*     */ import javax.ws.rs.Produces;
/*     */ import net.frank.cms.common.BaseJersey;
/*     */ import net.frank.commons.CommonConstants.TYPE;
/*     */ import net.frank.framework.bo.Article;
/*     */ import net.frank.framework.bo.BaseEntity;
/*     */ import net.frank.framework.bo.BusinessObject;
/*     */ import net.frank.framework.bo.Image;
/*     */ import net.frank.framework.bo.Resource;
/*     */ import net.frank.framework.service.QueryService;
/*     */ import net.frank.framework.ws.define.WsRequest;
/*     */ import net.frank.framework.ws.define.WsResponse;
/*     */ import net.frank.framework.ws.process.BoXmlUtil;
/*     */ 
/*     */ @Path("/rest")
/*     */ public class RestImpl extends BaseJersey
/*     */ {
/*     */   private BoXmlUtil boXmlUtil;
/*     */ 
/*     */   public RestImpl()
/*     */   {
/*  32 */     this.boXmlUtil = ((BoXmlUtil)getBean("boXmlUtil")); } 
/*  39 */   @GET
/*     */   @Path("/get2/{resourceId}")
/*     */   @Produces({"text/xml"})
/*     */   public String getResource(@PathParam("resourceId") Long resourceId) { QueryService queryService = (QueryService)getBean("queryService");
/*  40 */     Resource resource = queryService.getResource(resourceId);
/*  41 */     if (!CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
/*  42 */       BusinessObject bo = queryService.getBo(resource);
/*  43 */       resource.setObject(bo);
/*     */     } else {
/*  45 */       resource.setChildren(queryService.retrieveResourceByParent(resource.getId()));
/*     */     }
/*  47 */     WsResponse wsResponse = new WsResponse();
/*  48 */     wsResponse.setResource(resource);
/*  49 */     wsResponse.setMessageNumber(WsResponse.MESSAGE_OK);
/*  50 */     return this.boXmlUtil.wsResponse2Xml(wsResponse); } 
/*  57 */   @POST
/*     */   @Path("/get")
/*     */   @Produces({"text/xml"})
/*     */   public String getResource(InputStream inputInfo) throws Exception { QueryService queryService = (QueryService)getBean("queryService");
/*  58 */     long currentTime = System.currentTimeMillis();
/*     */     try {
/*  60 */       String wsRequestXml = inputStream2String(inputInfo);
/*  61 */       WsRequest wsRequest = this.boXmlUtil.xml2WsRequest(wsRequestXml);
/*  62 */       Long resourceId = wsRequest.getResource().getId();
/*  63 */       Resource resource = queryService.getResource(resourceId);
/*  64 */       if (!CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
/*  65 */         BusinessObject bo = queryService.getBo(resource);
/*  66 */         resource.setObject(bo);
/*     */       } else {
/*  68 */         resource.setChildren(queryService.retrieveResourceByParent(resource.getId()));
/*     */       }
/*  70 */       WsResponse wsResponse = new WsResponse();
/*  71 */       wsResponse.setResource(resource);
/*  72 */       wsResponse.setMessageNumber(WsResponse.MESSAGE_OK);
/*  73 */       String str1 = this.boXmlUtil.wsResponse2Xml(wsResponse);
/*     */       return str1; } finally { System.out.println(System.currentTimeMillis() - currentTime); } throw localObject;
/*     */   }
/*     */ 
/*     */   @POST
/*     */   @Path("/transferXml")
/*     */   @Produces({"text/xml"})
/*     */   public String transferXml(InputStream resourceInfo)
/*     */     throws Exception
/*     */   {
/* 103 */     byte[] buf = new byte[4096];
/* 104 */     int flag = -1;
/* 105 */     ByteArrayOutputStream bis = new ByteArrayOutputStream();
/* 106 */     while ((flag = resourceInfo.read(buf)) != -1) {
/* 107 */       bis.write(buf, 0, flag);
/*     */     }
/* 109 */     String strResourceInfo = new String(bis.toString());
/* 110 */     BoXmlUtil boXmlUtil = (BoXmlUtil)getBean("boXmlUtil");
/* 111 */     WsRequest wsRequest = boXmlUtil.xml2WsRequest(strResourceInfo);
/* 112 */     System.out.println(wsRequest);
/* 113 */     if ((wsRequest != null) && (wsRequest.getResource() != null)) {
/* 114 */       Resource resource = wsRequest.getResource();
/* 115 */       BaseEntity bo = toBo(resource);
/* 116 */       if ((bo instanceof BusinessObject)) {
/* 117 */         if (resource.getTypeId().equals(CommonConstants.TYPE.IMAGE)) {
/* 118 */           Image image = (Image)bo;
/* 119 */           FileOutputStream fos = new FileOutputStream("d:/temp/" + image.getImageName());
/* 120 */           fos.write(image.getContent());
/* 121 */           fos.flush();
/* 122 */           fos.close();
/*     */         }
/* 124 */         if (resource.getTypeId().equals(CommonConstants.TYPE.ARTICLE)) {
/* 125 */           Article article = (Article)bo;
/* 126 */           System.out.println(article.getContent());
/*     */         }
/*     */       }
/*     */     }
/* 130 */     return "<result>OK</result>";
/*     */   }
/*     */ 
/*     */   public BaseEntity toBo(Resource resource)
/*     */   {
/* 135 */     if (CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
/* 136 */       return resource;
/*     */     }
/* 138 */     BusinessObject bo = resource.getObject();
/* 139 */     bo.setResource(resource);
/* 140 */     resource.setObject(null);
/* 141 */     return bo;
/*     */   }
/*     */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.ws.RestImpl
 * JD-Core Version:    0.6.0
 */