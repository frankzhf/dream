package net.frank.framework.web.taglib.paginator;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.commons.CommonConstants;
import net.frank.framework.dao.paginator.OrderData;
import net.frank.framework.dao.paginator.PaginatorData;
import net.frank.framework.writer.MarkupWriter;

public class OrderTag extends TagSupport {
	
	private static final String IMG_PATH = "/global/scripts/jquery/themes/default/images/";
	
	private static final String UP_IMG = "datagrid_sort_asc.gif";
	
	private static final String DOWN_IMG = "datagrid_sort_desc.gif";
	
	private static final String NULL_IMG = "datagrid_sort_0.gif";
	

	private static final long serialVersionUID = -3750872991772285407L;

	private String var = "paginatorData";

	private String culumnDisplay;

	private String orderName;

	private String orderIndex;

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getCulumnDisplay() {
		return culumnDisplay;
	}

	public void setCulumnDisplay(String culumnDisplay) {
		this.culumnDisplay = culumnDisplay;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(String orderIndex) {
		this.orderIndex = orderIndex;
	}

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		PaginatorData paginatorData = (PaginatorData) pageContext
				.findAttribute(var);
		try {
			renderOrder(out, paginatorData);
		} catch (IOException ioe) {
			throw new JspException(ioe);
		}
		return EVAL_PAGE;
	}

	private void renderOrder(JspWriter jspWriter, PaginatorData paginatorData)
			throws IOException {
		MarkupWriter mw = new MarkupWriter(jspWriter);
		OrderData o = null;
		if (paginatorData != null && paginatorData.getOrderByList() != null
				&& paginatorData.getOrderBy(Integer.decode(orderIndex)) != null) {
			o = paginatorData.getOrderBy(Integer.decode(orderIndex));
		}
		String currentImg = "";
		if(o == null || o.isAsc() ==null ){
			currentImg = NULL_IMG;
		}else{
			if(o != null && o.isAsc()){
				currentImg = UP_IMG;
			}else{
				currentImg = DOWN_IMG;
			}
		}
		
		mw.begin("input");
		mw.attribute("type", "hidden");
		mw.attribute("id", getVar() + "." + "orderBy[" + getOrderIndex()
				+ "].fieldName");
		mw.attribute("name", getVar() + "." + "orderBy[" + getOrderIndex()
				+ "].fieldName");
		mw.attribute("value", getOrderName());

		mw.end();
		mw.begin("input");
		mw.attribute("type", "hidden");
		mw.attribute("id", getVar() + "." + "orderBy[" + getOrderIndex()
				+ "].booleanString(asc)");
		mw.attribute("name", getVar() + "." + "orderBy[" + getOrderIndex()
				+ "].booleanString(asc)");
		mw.attribute("value", o == null || o.isAsc() ==null ? CommonConstants.EMPTY_STRING
				: CommonConstants.EMPTY_STRING + o.isAsc());
		mw.end();
		
		
		mw.begin("a");
		mw.attribute("href", "#");
		mw.attribute("onclick", "orderPage("+orderIndex+")");
		mw.write(getCulumnDisplay());
		mw.end();
		mw.begin("img");
		mw.attribute("src",((HttpServletRequest) pageContext.getRequest())
				.getContextPath()+IMG_PATH+currentImg);
		mw.end();
	}
	
	/**
	private String processMessage(String key) {
		String returnValue = CommonConstants.EMPTY_STRING;
		try {
			returnValue = TagUtils.getInstance().message(pageContext, null,
					localeKey, key);
		} catch (JspException e) {
		}
		return returnValue;
	}
	**/
}
