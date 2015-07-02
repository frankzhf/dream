/*    */ package net.frank.cms.web.core.forms;
/*    */ 
/*    */ import org.apache.struts.action.ActionForm;
/*    */ 
/*    */ public class MoveForm extends ActionForm
/*    */ {
/*    */   private static final long serialVersionUID = -642091768978952607L;
/*    */   private String fromPath;
/*    */   private String toPath;
/* 13 */   private Boolean clone = Boolean.FALSE;
/*    */ 
/* 15 */   private Boolean recursive = Boolean.FALSE;
/*    */ 
/*    */   public String getFromPath() {
/* 18 */     return this.fromPath;
/*    */   }
/*    */ 
/*    */   public void setFromPath(String fromPath) {
/* 22 */     this.fromPath = fromPath;
/*    */   }
/*    */ 
/*    */   public String getToPath() {
/* 26 */     return this.toPath;
/*    */   }
/*    */ 
/*    */   public void setToPath(String toPath) {
/* 30 */     this.toPath = toPath;
/*    */   }
/*    */ 
/*    */   public Boolean getClone() {
/* 34 */     return this.clone;
/*    */   }
/*    */ 
/*    */   public void setClone(Boolean clone) {
/* 38 */     this.clone = clone;
/*    */   }
/*    */ 
/*    */   public Boolean getRecursive() {
/* 42 */     return this.recursive;
/*    */   }
/*    */ 
/*    */   public void setRecursive(Boolean recursive) {
/* 46 */     this.recursive = recursive;
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.forms.MoveForm
 * JD-Core Version:    0.6.0
 */