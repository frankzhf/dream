/*    */ package net.frank.cms.web.common.actions;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import net.frank.framework.web.security.AuthenticatorHolder;
/*    */ import net.frank.framework.web.security.ClientSession;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.apache.struts.action.ActionMessage;
/*    */ import org.apache.struts.action.ActionMessages;
/*    */ 
/*    */ public class DashboardAction extends BaseAction
/*    */ {
/*    */   private static final String WELCOME_MESSAGE = "common.message.welcome";
/*    */ 
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 23 */     ActionMessages actionMessages = new ActionMessages();
/* 24 */     actionMessages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("common.message.welcome", AuthenticatorHolder.getClientSession().getLoginName()));
/*    */ 
/* 26 */     addMessages(request, actionMessages);
/* 27 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.common.actions.DashboardAction
 * JD-Core Version:    0.6.0
 */