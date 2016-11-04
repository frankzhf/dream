package net.frank.framework.web.taglib.lang;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class RondomTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4508554188929963198L;
	private static final String DEFAULT_VAR_NAME = "rondom";
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
		
		pageContext.setAttribute(var, Math.random());
		reset();
		return EVAL_PAGE;
	}
	
	@Override
	public void release(){
		super.release();
		reset();
	}
	
}
