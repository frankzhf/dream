/*    */ package net.frank.cms.web.common.forms;
/*    */ 
/*    */ import org.apache.struts.action.ActionForm;
/*    */ 
/*    */ public class LoginForm extends ActionForm
/*    */ {
/*    */   private static final long serialVersionUID = -832048549184658810L;
/*    */   private String userName;
/*    */   private String password;
/*    */   private String localCd;
/*    */ 
/*    */   public String getUserName()
/*    */   {
/* 12 */     return this.userName;
/*    */   }
/*    */   public void setUserName(String userName) {
/* 15 */     this.userName = userName;
/*    */   }
/*    */   public String getPassword() {
/* 18 */     return this.password;
/*    */   }
/*    */   public void setPassword(String password) {
/* 21 */     this.password = password;
/*    */   }
/*    */   public void setLocalCd(String localCd) {
/* 24 */     this.localCd = localCd;
/*    */   }
/*    */   public String getLocalCd() {
/* 27 */     return this.localCd;
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.common.forms.LoginForm
 * JD-Core Version:    0.6.0
 */