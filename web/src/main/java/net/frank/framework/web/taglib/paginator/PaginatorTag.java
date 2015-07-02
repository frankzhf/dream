package net.frank.framework.web.taglib.paginator;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.commons.CommonConstants;
import net.frank.framework.dao.paginator.PaginatorData;
import net.frank.framework.writer.MarkupWriter;

public class PaginatorTag extends TagSupport {

	/**
	 * 
	 */
	public static final int FORSEE_SIZE = 2;

	private static final long serialVersionUID = 8181761430747610855L;

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
			renderPaginator(out, paginatorData);
		} catch (IOException ioe) {
			throw new JspException(ioe);
		}
		return EVAL_PAGE;
	}

	protected void renderPaginator(Writer jspWriter, PaginatorData paginatorData)
			throws IOException {
		if (paginatorData == null || paginatorData.getCountPages() < 1
				|| paginatorData.getCountRecourds() <= 0) {
			return;
		}
		MarkupWriter mw = new MarkupWriter(jspWriter);
		// mw.begin("table");
		// mw.attribute("class", "paginator");
		// mw.attribute("cellspacing", "0");
		// mw.attribute("cellpadding", "0");
		// mw.begin("tr");
		// The hidden data
		// mw.begin("td");
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
		// mw.end();

		// output currentPage/CountPages
		// if (itemCount != -1) {
		// mw.begin("td");
		// mw.attribute("class", "indicator");
		// mw.write("[").write(itemCount).write("]");
		// mw.end();
		// }

		// Preivouse Page Control
		// mw.begin("td");
		// mw.attribute("class", "previousPage");
		if (paginatorData.getCurrentPage() > 1) {
			mw.begin("a");
			mw.attribute("href", "#");
			mw.attribute("onclick",
					"gotoPage(" + (paginatorData.getCurrentPage() - 1) + ")");
		}
		mw.write("&lt;Prev&nbsp;Page");
		if (paginatorData.getCurrentPage() > 1) {
			mw.end();
		}
		// mw.end();

		// mw.begin("td");
		mw.write("&nbsp;&nbsp;&nbsp;&nbsp;");
		// mw.end();

		// Previous Pages before current Page.
		int _rlost = 0;
		int _llost = 0;
		if (paginatorData.getCountPages() - paginatorData.getCurrentPage() <= FORSEE_SIZE) {
			_llost = FORSEE_SIZE
					- (paginatorData.getCountPages() - paginatorData
							.getCurrentPage());
		}

		int startIndex = paginatorData.getCurrentPage() > FORSEE_SIZE ? paginatorData
				.getCurrentPage() - FORSEE_SIZE
				: 1;
		if (paginatorData.getCurrentPage() <= FORSEE_SIZE) {
			_rlost = FORSEE_SIZE - paginatorData.getCurrentPage() + 1;
		}
		if (startIndex != 1) {
			startIndex = startIndex - _llost > 0 ? startIndex - _llost : 1;
		}

		for (int i = startIndex; i < paginatorData.getCurrentPage(); i++) {
			// mw.begin("td");
			mw.begin("a");
			mw.attribute("href", "#");
			mw.attribute("onclick", "gotoPage(" + i + ")");
			mw.write(i);
			mw.end();
			mw.write("&nbsp;&nbsp;");
			// mw.end();
		}
		// Current Page
		// mw.begin("td");
		// mw.attribute("class", "currentPage");
		mw.write(paginatorData.getCurrentPage());
		// mw.end();

		// Next Pages after currnet page
		int endIndex = paginatorData.getCurrentPage() + FORSEE_SIZE + _rlost;
		if (endIndex > paginatorData.getCountPages()) {
			endIndex = paginatorData.getCountPages();
		}
		for (int i = paginatorData.getCurrentPage() + 1; i <= endIndex; i++) {
			// mw.begin("td");
			mw.write("&nbsp;&nbsp;");
			mw.begin("a");
			mw.attribute("href", "#");
			mw.attribute("onclick", "gotoPage(" + i + ")");
			mw.write(i);
			mw.end();
			// mw.end();
		}
		// mw.begin("td");
		mw.write("&nbsp;&nbsp;&nbsp;&nbsp;");
		// mw.end();
		// Next Page Control
		// mw.begin("td");
		// mw.attribute("class", "nextPage");
		if (paginatorData.getCurrentPage() < paginatorData.getCountPages()) {
			mw.begin("a");
			mw.attribute("href", "#");
			mw.attribute("onclick",
					"gotoPage(" + (paginatorData.getCurrentPage() + 1) + ")");
		}
		mw.write("Next&nbsp;Page&gt;");
		if (paginatorData.getCurrentPage() < paginatorData.getCountPages()) {
			mw.end();
		}
		// mw.end();
		// mw.end();
		// mw.end();
	}
}