/*     */ package net.frank.cms.web.taglib;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import javax.servlet.jsp.JspContext;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import javax.servlet.jsp.tagext.SimpleTagSupport;
/*     */ import net.frank.framework.bo.Group;
/*     */ import net.frank.framework.service.QueryService;
/*     */ import net.frank.framework.spring.SpringContextUtil;
/*     */ import net.frank.framework.web.security.AuthenticatorHolder;
/*     */ import net.frank.framework.web.security.ClientSession;
/*     */ import net.frank.framework.writer.JspResponseWriter;
/*     */ import net.frank.framework.xml.Xhtml.Attr;
/*     */ import net.frank.framework.xml.Xhtml.Tag;
/*     */ 
/*     */ public class GroupTag extends SimpleTagSupport
/*     */ {
/*     */   private static final String ELEMENT_ID = "dialog_resource.longString(ownGroupResourceId)";
/*     */   private static final String ELEMENT_ONCLICK_PREFFIX = "dialogSelector('";
/*     */   private static final String ELEMENT_ONCLICK_SUFFIX = "')";
/*     */   private static final String DEFAULT_BUTTON_ID = "buuton_dialogSelector_group";
/*  29 */   private String mode = "view";
/*     */ 
/*  31 */   private String elementId = "dialog_resource.longString(ownGroupResourceId)";
/*     */   private Long identifie;
/*     */   private String target;
/*  37 */   private String buttonId = "buuton_dialogSelector_group";
/*     */ 
/*  39 */   private JspResponseWriter out = new JspResponseWriter();
/*     */ 
/*     */   public String getElementId() {
/*  42 */     return this.elementId;
/*     */   }
/*     */ 
/*     */   public void setElementId(String elementId) {
/*  46 */     this.elementId = elementId;
/*     */   }
/*     */ 
/*     */   public String getMode() {
/*  50 */     return this.mode;
/*     */   }
/*     */ 
/*     */   public void setMode(String mode) {
/*  54 */     this.mode = mode;
/*     */   }
/*     */ 
/*     */   public Long getIdentifie() {
/*  58 */     return this.identifie;
/*     */   }
/*     */ 
/*     */   public void setIdentifie(Long identifie) {
/*  62 */     this.identifie = identifie;
/*     */   }
/*     */ 
/*     */   public String getTarget() {
/*  66 */     return this.target;
/*     */   }
/*     */ 
/*     */   public void setTarget(String target) {
/*  70 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public void setButtonId(String buttonId) {
/*  74 */     this.buttonId = buttonId;
/*     */   }
/*     */ 
/*     */   public String getButtonId() {
/*  78 */     return this.buttonId;
/*     */   }
/*     */ 
/*     */   public void doTag() throws JspException, IOException {
/*  82 */     QueryService queryService = (QueryService)SpringContextUtil.getBean("queryService");
/*     */ 
/*  84 */     Group currentGroup = null;
/*  85 */     if (getIdentifie() != null) {
/*  86 */       currentGroup = (Group)queryService.getBo(getIdentifie());
/*     */     }
/*  88 */     if (currentGroup == null) {
/*  89 */       currentGroup = AuthenticatorHolder.getClientSession().getCurrentGroup();
/*     */     }
/*  91 */     if ("view".equals(getMode())) {
/*  92 */       this.out.text(currentGroup.getGroupName() + "&nbsp;");
/*     */     } else {
/*  94 */       this.out.startElement(Xhtml.Tag.INPUT);
/*  95 */       this.out.attribute(Xhtml.Attr.ID, getElementId());
/*  96 */       this.out.attribute(Xhtml.Attr.NAME, getElementId());
/*  97 */       this.out.attribute(Xhtml.Attr.TYPE, "text");
/*  98 */       this.out.attribute(Xhtml.Attr.READONLY, "readonly");
/*  99 */       this.out.attribute(Xhtml.Attr.VALUE, currentGroup.getGroupName());
/* 100 */       this.out.endElement(Xhtml.Tag.INPUT);
/* 101 */       this.out.text("&nbsp;");
/* 102 */       this.out.startElement(Xhtml.Tag.INPUT);
/* 103 */       this.out.attribute(Xhtml.Attr.TYPE, "button");
/* 104 */       this.out.attribute(Xhtml.Attr.ID, getButtonId());
/* 105 */       this.out.attribute(Xhtml.Attr.VALUE, "...");
/* 106 */       StringBuffer sb = new StringBuffer(64);
/* 107 */       sb.append("dialogSelector('").append(getTarget()).append("')");
/* 108 */       this.out.attribute(Xhtml.Attr.ONCLICK, sb.toString());
/* 109 */       this.out.endElement(Xhtml.Tag.INPUT);
/*     */     }
/* 111 */     getJspContext().getOut().print(this.out.getBuffer());
/*     */   }
/*     */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.taglib.GroupTag
 * JD-Core Version:    0.6.0
 */