/*    */ package net.frank.cms.web.taglib;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.jsp.JspContext;
/*    */ import javax.servlet.jsp.JspException;
/*    */ import javax.servlet.jsp.JspWriter;
/*    */ import javax.servlet.jsp.PageContext;
/*    */ import javax.servlet.jsp.tagext.SimpleTagSupport;
/*    */ import net.frank.framework.bo.BaseEntity;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.bo.Type;
/*    */ import net.frank.framework.service.CacheService;
/*    */ import net.frank.framework.spring.SpringContextUtil;
/*    */ import net.frank.framework.writer.JspResponseWriter;
/*    */ import net.frank.framework.xml.Xhtml.Attr;
/*    */ import net.frank.framework.xml.Xhtml.Tag;
/*    */ 
/*    */ public class TypeImageTag extends SimpleTagSupport
/*    */ {
/*    */   private static final String DEFAULT_TYPE_IMAGE = "/global/images/xloadtree2b/file.png";
/*    */   private Long typeId;
/* 31 */   private JspResponseWriter out = new JspResponseWriter();
/*    */ 
/*    */   public void setTypeId(Long typeId)
/*    */   {
/* 24 */     this.typeId = typeId;
/*    */   }
/*    */ 
/*    */   public Long getTypeId() {
/* 28 */     return this.typeId;
/*    */   }
/*    */ 
/*    */   public void doTag()
/*    */     throws JspException, IOException
/*    */   {
/* 34 */     CacheService cacheService = (CacheService)SpringContextUtil.getBean("cacheService");
/*    */ 
/* 36 */     PageContext pageContext = (PageContext)getJspContext();
/* 37 */     String contextPath = ((HttpServletRequest)pageContext.getRequest()).getContextPath();
/* 38 */     if ((getTypeId() != null) && (cacheService.getTypeContent().get(getTypeId()) != null))
/*    */     {
/* 40 */       String className = ((Type)cacheService.getTypeContent().get(getTypeId())).getEntityClassName();
/* 41 */       BaseEntity be = null;
/*    */       try {
/* 43 */         be = (BaseEntity)Class.forName(className).newInstance();
/*    */       } catch (Exception e) {
/* 45 */         be = new Resource();
/*    */       }
/* 47 */       this.out.startElement(Xhtml.Tag.IMG);
/* 48 */       this.out.attribute(Xhtml.Attr.SRC, contextPath + be.getNodeIcon());
/*    */ 
/* 51 */       this.out.endElement(Xhtml.Tag.IMG);
/*    */     } else {
/* 53 */       this.out.startElement(Xhtml.Tag.IMG);
/* 54 */       this.out.attribute(Xhtml.Attr.SRC, contextPath + "/global/images/xloadtree2b/file.png");
/* 55 */       this.out.endElement(Xhtml.Tag.IMG);
/*    */     }
/* 57 */     getJspContext().getOut().print(this.out.getBuffer());
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.taglib.TypeImageTag
 * JD-Core Version:    0.6.0
 */