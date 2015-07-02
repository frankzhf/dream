/*    */ package net.frank.cms.web.common.ajaxs;
/*    */ 
/*    */ import net.frank.commons.util.PasswordUtil;
/*    */ import net.frank.framework.bo.Account;
/*    */ import net.frank.framework.bo.Group;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.web.ajax.BaseAjax;
/*    */ import net.frank.framework.web.security.AuthenticatorHolder;
/*    */ import net.frank.framework.web.security.ClientSession;
/*    */ 
/*    */ public class HeaderAjax extends BaseAjax
/*    */ {
/*    */   public boolean changeClientGroup(Long resourceId)
/*    */   {
/* 13 */     boolean flag = false;
/*    */     try {
/* 15 */       ClientSession cs = AuthenticatorHolder.getClientSession();
/* 16 */       QueryService queryService = (QueryService)getBean("queryService");
/* 17 */       cs.setCurrentGroup((Group)queryService.getBo(resourceId));
/* 18 */       flag = true;
/*    */     } catch (Exception e) {
/* 20 */       flag = false;
/*    */     }
/* 22 */     return flag;
/*    */   }
/*    */ 
/*    */   public boolean checkPassword(String oldPassword) {
/* 26 */     if ((oldPassword == null) || ("".equals(oldPassword))) {
/* 27 */       return true;
/*    */     }
/* 29 */     String _oldPassword = PasswordUtil.MD5encode(oldPassword);
/* 30 */     ClientSession cs = AuthenticatorHolder.getClientSession();
/* 31 */     return _oldPassword.equals(cs.getAccount().getPassword());
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.common.ajaxs.HeaderAjax
 * JD-Core Version:    0.6.0
 */