package net.frank.framework.web.taglib.paginator;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.commons.CommonConstants;
import net.frank.framework.dao.paginator.PaginatorData;
import net.frank.framework.writer.MarkupWriter;

public class PaginatorDataTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2386349328305134585L;
	private String var = "paginatorData";

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		PaginatorData paginatorData = (PaginatorData) pageContext
				.findAttribute(var);
		try {
			renderPaginatorData(out, paginatorData);
		} catch (IOException ioe) {
			throw new JspException(ioe);
		}
		return EVAL_PAGE;
	}

	protected void renderPaginatorData(JspWriter jspWriter,
			PaginatorData paginatorData) throws IOException {
		if (paginatorData == null || paginatorData.getCountPages() < 1
				|| paginatorData.getCountRecourds() <= 0) {
			return;
		}
		MarkupWriter mw = new MarkupWriter(jspWriter);
		mw.begin("input");
		mw.attribute("type", "hidden");
		mw.attribute("id", getVar() + ".pageSize");
		mw.attribute("name", getVar() + ".pageSize");
		mw.attribute("value", paginatorData.getPageSize()
				+ CommonConstants.EMPTY_STRING);
		mw.end();
		mw.begin("input");
		mw.attribute("type", "hidden");
		mw.attribute("id", getVar() + ".countRecourds");
		mw.attribute("name", getVar() + ".countRecourds");
		mw.attribute("value", paginatorData.getCountRecourds()
				+ CommonConstants.EMPTY_STRING);
		mw.end();
		mw.begin("input");
		mw.attribute("type", "hidden");
		mw.attribute("id", getVar() + ".currentPage");
		mw.attribute("name", getVar() + ".currentPage");
		mw.attribute("value", paginatorData.getCurrentPage()
				+ CommonConstants.EMPTY_STRING);
		mw.end();
		mw.begin("input");
		mw.attribute("type", "hidden");
		mw.attribute("id", getVar() + ".countPages");
		mw.attribute("name", getVar() + ".countPages");
		mw.attribute("value", paginatorData.getCountPages()
				+ CommonConstants.EMPTY_STRING);
		mw.end();
		if(paginatorData.getParamMap()!=null){
			
		}
		if(paginatorData.getOrderByList()!=null){
			
		}
	}
}
