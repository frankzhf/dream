/*    */ package net.frank.cms.ws;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import javax.ws.rs.POST;
/*    */ import javax.ws.rs.Path;
/*    */ import javax.ws.rs.Produces;
/*    */ import javax.ws.rs.core.Context;
/*    */ import net.frank.aa.service.AaService;
/*    */ import net.frank.cms.common.BaseJersey;
/*    */ import net.frank.framework.security.Session;
/*    */ import net.frank.framework.web.security.ClientSession;
/*    */ import net.frank.framework.ws.define.WsAaInfo;
/*    */ import net.frank.framework.ws.process.BoXmlUtil;
/*    */ import org.apache.commons.logging.Log;
/*    */ 
/*    */ @Path("/welcome")
/*    */ public class Welcome extends BaseJersey
/*    */ {
/*    */   private BoXmlUtil boXmlUtil;
/*    */ 
/*    */   public Welcome()
/*    */   {
/* 25 */     this.boXmlUtil = ((BoXmlUtil)getBean("boXmlUtil"));
/*    */   }
/*    */   @POST
/*    */   @Path("/login")
/*    */   @Produces({"text/xml"})
/*    */   public String login(InputStream inputInfo, @Context HttpServletRequest request, @Context HttpServletResponse response) throws Exception {
/* 34 */     AaService aaService = (AaService)getBean("aaService");
/* 35 */     String strUserInfo = inputStream2String(inputInfo);
/* 36 */     WsAaInfo wsAaInfo = this.boXmlUtil.xml2Aa(strUserInfo);
/* 37 */     this.log.debug("loginName:" + wsAaInfo.getLoginName());
/* 38 */     this.log.debug("password:" + wsAaInfo.getPassword());
/* 39 */     Session cs = new ClientSession(wsAaInfo.getLoginName(), request.getLocalAddr());
/*    */ 
/* 41 */     cs = aaService.login(cs, wsAaInfo.getLoginName(), wsAaInfo.getPassword(), null);
/*    */ 
/* 43 */     request.getSession().setAttribute("CLIENT_SESSION", cs);
/* 44 */     if (Session.STATUS_LOGINED.equals(cs.getStatus())) {
/* 45 */       wsAaInfo.setPassword("****************************");
/* 46 */       wsAaInfo.setLoginStatus(WsAaInfo.LOGINED);
/* 47 */       return this.boXmlUtil.aa2Xml(wsAaInfo);
/*    */     }
/* 49 */     return this.boXmlUtil.aa2Xml(wsAaInfo);
/*    */   }
/*    */   @POST
/*    */   @Path("/logout")
/*    */   @Produces({"text/xml"})
/*    */   public String logout(InputStream inputInfo, @Context HttpServletRequest request) throws Exception {
/* 58 */     String strUserInfo = inputStream2String(inputInfo);
/* 59 */     WsAaInfo wsAaInfo = this.boXmlUtil.xml2Aa(strUserInfo);
/* 60 */     request.getSession(true).setMaxInactiveInterval(0);
/* 61 */     wsAaInfo.setLoginStatus(WsAaInfo.NO_LOGINED);
/* 62 */     return this.boXmlUtil.aa2Xml(wsAaInfo);
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.ws.Welcome
 * JD-Core Version:    0.6.0
 */