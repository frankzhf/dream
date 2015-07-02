/*     */ package net.frank.cms.web.taglib;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import javax.servlet.jsp.JspContext;
/*     */ import javax.servlet.jsp.JspException;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import javax.servlet.jsp.tagext.SimpleTagSupport;
/*     */ import net.frank.framework.bo.Account;
/*     */ import net.frank.framework.service.QueryService;
/*     */ import net.frank.framework.spring.SpringContextUtil;
/*     */ import net.frank.framework.web.security.AuthenticatorHolder;
/*     */ import net.frank.framework.web.security.ClientSession;
/*     */ import net.frank.framework.writer.JspResponseWriter;
/*     */ import net.frank.framework.xml.Xhtml.Attr;
/*     */ import net.frank.framework.xml.Xhtml.Tag;
/*     */ 
/*     */ public class AccountTag extends SimpleTagSupport
/*     */ {
/*     */   private static final String ELEMENT_ID = "dialog_resource.longString(ownResourceId)";
/*     */   private static final String ELEMENT_ONCLICK_PREFFIX = "dialogSelector('";
/*     */   private static final String ELEMENT_ONCLICK_SUFFIX = "')";
/*     */   private static final String DEFAULT_BUTTON_ID = "buuton_dialogSelector_account";
/*  27 */   private String mode = "view";
/*     */   private Long identifie;
/*  31 */   private String elementId = "dialog_resource.longString(ownResourceId)";
/*     */   private String target;
/*  35 */   private String buttonId = "buuton_dialogSelector_account";
/*     */ 
/*  37 */   private JspResponseWriter out = new JspResponseWriter();
/*     */ 
/*     */   public String getElementId() {
/*  40 */     return this.elementId;
/*     */   }
/*     */ 
/*     */   public void setElementId(String elementId) {
/*  44 */     this.elementId = elementId;
/*     */   }
/*     */ 
/*     */   public String getMode() {
/*  48 */     return this.mode;
/*     */   }
/*     */ 
/*     */   public void setMode(String mode) {
/*  52 */     this.mode = mode;
/*     */   }
/*     */ 
/*     */   public Long getIdentifie() {
/*  56 */     return this.identifie;
/*     */   }
/*     */ 
/*     */   public void setIdentifie(Long identifie) {
/*  60 */     this.identifie = identifie;
/*     */   }
/*     */ 
/*     */   public String getTarget() {
/*  64 */     return this.target;
/*     */   }
/*     */ 
/*     */   public void setTarget(String target) {
/*  68 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public void setButtonId(String buttonId) {
/*  72 */     this.buttonId = buttonId;
/*     */   }
/*     */ 
/*     */   public String getButtonId() {
/*  76 */     return this.buttonId;
/*     */   }
/*     */ 
/*     */   public void doTag() throws JspException, IOException {
/*  80 */     QueryService queryService = (QueryService)SpringContextUtil.getBean("queryService");
/*     */ 
/*  82 */     Account currentAccount = null;
/*  83 */     if (getIdentifie() != null) {
/*  84 */       currentAccount = (Account)queryService.getBo(getIdentifie());
/*     */     }
/*  86 */     if (currentAccount == null) {
/*  87 */       currentAccount = AuthenticatorHolder.getClientSession().getAccount();
/*     */     }
/*  89 */     if ("view".equals(getMode())) {
/*  90 */       this.out.text(currentAccount.getLoginName() + "&nbsp;");
/*     */     } else {
/*  92 */       this.out.startElement(Xhtml.Tag.INPUT);
/*  93 */       this.out.attribute(Xhtml.Attr.ID, getElementId());
/*  94 */       this.out.attribute(Xhtml.Attr.NAME, getElementId());
/*  95 */       this.out.attribute(Xhtml.Attr.TYPE, "text");
/*  96 */       this.out.attribute(Xhtml.Attr.READONLY, "readonly");
/*  97 */       this.out.attribute(Xhtml.Attr.VALUE, currentAccount.getLoginName());
/*  98 */       this.out.endElement(Xhtml.Tag.INPUT);
/*  99 */       this.out.text("&nbsp;");
/* 100 */       this.out.startElement(Xhtml.Tag.INPUT);
/* 101 */       this.out.attribute(Xhtml.Attr.TYPE, "button");
/* 102 */       this.out.attribute(Xhtml.Attr.ID, getButtonId());
/* 103 */       this.out.attribute(Xhtml.Attr.VALUE, "...");
/* 104 */       StringBuffer sb = new StringBuffer(64);
/* 105 */       sb.append("dialogSelector('").append(getTarget()).append("')");
/* 106 */       this.out.attribute(Xhtml.Attr.ONCLICK, sb.toString());
/* 107 */       this.out.endElement(Xhtml.Tag.INPUT);
/*     */     }
/* 109 */     getJspContext().getOut().print(this.out.getBuffer());
/*     */   }
/*     */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.taglib.AccountTag
 * JD-Core Version:    0.6.0
 */