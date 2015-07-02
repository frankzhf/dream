package net.frank.framework.web.taglib.lookup;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.app.ApplicationTemplate;

public class ApplicationTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3235423891218321198L;

	private static final String DEFAULT_VAR_NAME = "application";
	
	private static final String DEFAULT_BEAN_ID= "applicationTemplate";
	
	private String var = DEFAULT_VAR_NAME;

	private String beanId = DEFAULT_BEAN_ID;

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}
	
	public void reset(){
		var = DEFAULT_VAR_NAME;
		beanId = DEFAULT_BEAN_ID;
	}
	
	@Override
	public int doEndTag() throws JspException {
		ApplicationTemplate application = (ApplicationTemplate) SpringContextHolder
				.getApplicationContext().getBean(beanId);
		pageContext.setAttribute(var, application);
		reset();
		return EVAL_PAGE;
	}
	
	@Override
	public void release(){
		super.release();
		reset();
	}

}
