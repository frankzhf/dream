/*    */ package net.frank.cms.web.common.forms;
/*    */ 
/*    */ import org.apache.struts.action.ActionForm;
/*    */ 
/*    */ public class DialogForm extends ActionForm
/*    */ {
/*    */   private static final long serialVersionUID = 6385298769662513676L;
/*    */   private Long currentTime;
/*    */   private String fieldName;
/*    */   private String fieldValue;
/*    */   private String elementId;
/*    */   private Long resourceId;
/*    */ 
/*    */   public String getFieldName()
/*    */   {
/* 22 */     return this.fieldName;
/*    */   }
/*    */ 
/*    */   public void setFieldName(String fieldName) {
/* 26 */     this.fieldName = fieldName;
/*    */   }
/*    */ 
/*    */   public String getFieldValue() {
/* 30 */     return this.fieldValue;
/*    */   }
/*    */ 
/*    */   public void setFieldValue(String fieldValue) {
/* 34 */     this.fieldValue = fieldValue;
/*    */   }
/*    */ 
/*    */   public String getElementId() {
/* 38 */     return this.elementId;
/*    */   }
/*    */ 
/*    */   public void setElementId(String elementId) {
/* 42 */     this.elementId = elementId;
/*    */   }
/*    */ 
/*    */   public Long getResourceId() {
/* 46 */     return this.resourceId;
/*    */   }
/*    */ 
/*    */   public void setResourceId(Long resourceId) {
/* 50 */     this.resourceId = resourceId;
/*    */   }
/*    */ 
/*    */   public void setCurrentTime(Long currentTime) {
/* 54 */     this.currentTime = currentTime;
/*    */   }
/*    */ 
/*    */   public Long getCurrentTime() {
/* 58 */     return this.currentTime;
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.common.forms.DialogForm
 * JD-Core Version:    0.6.0
 */