/*    */ package net.frank.cms.web.task.forms;
/*    */ 
/*    */ import net.frank.framework.struts.form.CmsForm;
/*    */ 
/*    */ public class ProcessTokenForm extends CmsForm
/*    */ {
/*    */   private static final long serialVersionUID = -2164359738077388277L;
/*    */   private Long resourceId;
/*    */ 
/*    */   public ProcessTokenForm()
/*    */     throws InstantiationException, IllegalAccessException, ClassNotFoundException
/*    */   {
/*    */   }
/*    */ 
/*    */   public Long getResourceId()
/*    */   {
/* 21 */     return this.resourceId;
/*    */   }
/*    */ 
/*    */   public void setResourceId(Long resourceId) {
/* 25 */     this.resourceId = resourceId;
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.task.forms.ProcessTokenForm
 * JD-Core Version:    0.6.0
 */