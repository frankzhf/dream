/*    */ package net.frank.cms.web.common.actions;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import net.frank.aa.service.AaService;
/*    */ import net.frank.cms.web.common.forms.LoginForm;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.security.Session;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import net.frank.framework.web.security.AuthenticatorHolder;
/*    */ import net.frank.framework.web.security.ClientSession;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.apache.struts.action.ActionMessage;
/*    */ import org.apache.struts.action.ActionMessages;
/*    */ 
/*    */ public class LoginAction extends BaseAction
/*    */ {
/*    */   private static final String LOGIN_ERROR_ACCOUNT_NOT_EXISTS = "aa.status.not.exists";
/*    */   private static final String LOGIN_ERROR_ACCOUNT_INCORRERT_PW = "aa.status.incorrert.pw";
/*    */   private static final String AA_SERVICE_BEAN_ID = "aaService";
/*    */   private static final String ADMIN_GROUP_PATH = "/groups/Admin";
/*    */   private static final String ADMIN_FORWARD = "successAdmin";
/*    */   private static final String NORMAL_FORWARD = "successNormal";
/*    */ 
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 42 */     ActionMessages actionMessages = new ActionMessages();
/* 43 */     LoginForm loginForm = (LoginForm)form;
/* 44 */     String username = loginForm.getUserName();
/* 45 */     String password = loginForm.getPassword();
/* 46 */     AaService aaService = (AaService)getBean("aaService");
/* 47 */     Session cs = new ClientSession(username, request.getLocalAddr());
/* 48 */     cs = aaService.login(cs, username, password, null);
/* 49 */     request.getSession().setAttribute("CLIENT_SESSION", cs);
/* 50 */     if (Session.STATUS_LOGINED.equals(cs.getStatus())) {
/* 51 */       AuthenticatorHolder.setClientSession((ClientSession)cs);
/* 52 */       if (isAdmin(cs)) {
/* 53 */         return mapping.findForward("successAdmin");
/*    */       }
/* 55 */       return mapping.findForward("successNormal");
/*    */     }
/*    */ 
/* 58 */     if (Session.STATUS_NOT_EXISTS.equals(cs.getStatus())) {
/* 59 */       actionMessages.add("", new ActionMessage("aa.status.not.exists"));
/*    */     }
/* 61 */     else if (Session.STATUS_INCORRERT_PW.equals(cs.getStatus())) {
/* 62 */       actionMessages.add("", new ActionMessage("aa.status.incorrert.pw"));
/*    */     }
/*    */ 
/* 65 */     addErrors(request, actionMessages);
/* 66 */     loginForm.setUserName("");
/* 67 */     loginForm.setPassword("");
/* 68 */     return mapping.findForward("failure");
/*    */   }
/*    */ 
/*    */   private boolean isAdmin(Session session)
/*    */   {
/* 73 */     session.setAttribute("cs-is-admin", Boolean.FALSE);
/* 74 */     QueryService queryService = (QueryService)getBean("queryService");
/* 75 */     Iterator it = session.getGroups().iterator();
/* 76 */     while (it.hasNext()) {
/* 77 */       Resource curr = (Resource)it.next();
/* 78 */       if ("/groups/Admin".equals(queryService.getResourcePath(curr))) {
/* 79 */         session.setAttribute("cs-is-admin", Boolean.TRUE);
/* 80 */         return true;
/*    */       }
/*    */     }
/* 83 */     return false;
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.common.actions.LoginAction
 * JD-Core Version:    0.6.0
 */