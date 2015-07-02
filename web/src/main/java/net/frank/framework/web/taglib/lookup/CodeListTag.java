package net.frank.framework.web.taglib.lookup;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.framework.code.CodeService;
import net.frank.framework.spring.SpringContextHolder;

public class CodeListTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2753825741173501485L;

	private String var;

	private String codeTypeId;

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getCodeTypeId() {
		return codeTypeId;
	}

	public void setCodeTypeId(String codeTypeId) {
		this.codeTypeId = codeTypeId;
	}
	
	@Override
	public int doStartTag(){
		var = null;
		codeTypeId = null;
		return SKIP_BODY;
	}
	
	public void reset(){
		var = null;
		codeTypeId = null;
	}
	
	@Override
	public int doEndTag() throws JspException {
		CodeService codeService = (CodeService) SpringContextHolder
				.getApplicationContext().getBean(
						CodeService.CODE_SERVICE_BEAN_ID);
		pageContext.setAttribute(var, codeService.getCodeList(codeTypeId));
		reset();
		return EVAL_PAGE;
	}
	
	@Override
	public void release(){
		super.release();
		reset();
	}
	
}
