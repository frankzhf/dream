package net.frank.cms.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Account;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;

public class AccountTag extends SimpleTagSupport {

	private static final String ELEMENT_ID = "dialog_resource.longString(ownResourceId)";

	private static final String ELEMENT_ONCLICK_PREFFIX = "dialogSelector('";
	
	private static final String ELEMENT_ONCLICK_SUFFIX = "')";
		//"dialogSelector('resource.longString(ownResourceId)')";
	private static final String DEFAULT_BUTTON_ID = "buuton_dialogSelector_account";
	
	private String mode = CmsCommonConstants.PAGE_MODE.VIEW;

	private Long identifie;
	
	private String elementId = ELEMENT_ID;
	
	private String target;
	
	private String buttonId = DEFAULT_BUTTON_ID;

	private JspResponseWriter out = new JspResponseWriter();
	
	public String getElementId(){
		return elementId;
	}
	
	public void setElementId(String elementId){
		this.elementId = elementId;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Long getIdentifie() {
		return identifie;
	}

	public void setIdentifie(Long identifie) {
		this.identifie = identifie;
	}
	
	public String getTarget(){
		return target;
	}
	
	public void setTarget(String target){
		this.target = target;
	}
	
	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}

	public String getButtonId() {
		return buttonId;
	}
	
	public void doTag() throws JspException, IOException {
		QueryService queryService = (QueryService) SpringContextUtil
				.getBean(ServiceNames.QUERY_SERVICE);
		Account currentAccount = null;
		if(getIdentifie()!=null){
			currentAccount = (Account)queryService.getBo(getIdentifie());
		}
		if(currentAccount==null){
			currentAccount = AuthenticatorHolder.getClientSession().getAccount();
		}
		if(CmsCommonConstants.PAGE_MODE.VIEW.equals(getMode())){
			out.text(currentAccount.getLoginName() + CmsCommonConstants.HTML_DEF.SPACE);
		}else{
			out.startElement(Xhtml.Tag.INPUT);
			out.attribute(Xhtml.Attr.ID, getElementId());
			out.attribute(Xhtml.Attr.NAME, getElementId());
			out.attribute(Xhtml.Attr.TYPE, CmsCommonConstants.HTML_DEF.INPUT_TYPE.TEXT);
			out.attribute(Xhtml.Attr.READONLY, CmsCommonConstants.HTML_DEF.READONLY_VALUE);
			out.attribute(Xhtml.Attr.VALUE, currentAccount.getLoginName());
			out.endElement(Xhtml.Tag.INPUT);
			out.text(CmsCommonConstants.HTML_DEF.SPACE);
			out.startElement(Xhtml.Tag.INPUT);
			out.attribute(Xhtml.Attr.TYPE, CmsCommonConstants.HTML_DEF.INPUT_TYPE.BUTTON);
			out.attribute(Xhtml.Attr.ID, getButtonId());
			out.attribute(Xhtml.Attr.VALUE, CmsCommonConstants.HTML_DEF.BUTTON_DEFAULT_LABEL);
			StringBuffer sb = new StringBuffer(64);
			sb.append(ELEMENT_ONCLICK_PREFFIX).append(getTarget()).append(ELEMENT_ONCLICK_SUFFIX);
			out.attribute(Xhtml.Attr.ONCLICK, sb.toString());
			out.endElement(Xhtml.Tag.INPUT);
		}
		getJspContext().getOut().print(out.getBuffer());
	}

	
}
