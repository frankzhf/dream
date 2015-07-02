package net.frank.framework.web.taglib.lookup;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.framework.web.security.AuthenticatorHolder;

public class ClientSessionTag  extends TagSupport {
	private static final long serialVersionUID = -7509567213237561638L;
	private static final String DEFAULT_VAR_NAME = "cs";
	private String var = DEFAULT_VAR_NAME;
	
	public String getVar() {
		return var;
	}
	
	public void setVar(String var) {
		this.var = var;
	}
	
	public void reset(){
		var = DEFAULT_VAR_NAME;
	}
	
	@Override
	public int doEndTag() throws JspException {
		pageContext.setAttribute(var, AuthenticatorHolder.getClientSession());
		reset();
		return EVAL_PAGE;
	}
	
	@Override
	public void release(){
		super.release();
		reset();
	}
}
