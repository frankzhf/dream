package net.frank.framework.web.taglib.lookup;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.framework.code.CodeService;
import net.frank.framework.spring.SpringContextHolder;

public class CodeTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 948254699641503103L;
	private String codeTypeId;
	private Long codeId;
	public String getCodeTypeId() {
		return codeTypeId;
	}
	public void setCodeTypeId(String codeTypeId) {
		this.codeTypeId = codeTypeId;
	}
	public Long getCodeId() {
		return codeId;
	}
	public void setCodeId(Long codeId) {
		this.codeId = codeId;
	}
	
	@Override
	public int doStartTag(){
		codeTypeId = null;
		codeId = null;
		return SKIP_BODY;
	}
	
	public void reset(){
		codeTypeId = null;
		codeId = null;
	}
	
	@Override
	public int doEndTag() throws JspException {
		CodeService codeService = (CodeService) SpringContextHolder
				.getApplicationContext().getBean(
						CodeService.CODE_SERVICE_BEAN_ID);
		try {
			pageContext.getOut().write(codeService.getDesc(codeTypeId, codeId));
			pageContext.getOut().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reset();
		return EVAL_PAGE;
	}
	
	@Override
	public void release(){
		super.release();
		reset();
	}
}
