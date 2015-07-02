package net.frank.framework.web.taglib.content.type.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import net.frank.commons.CommonConstants;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;
import net.frank.framework.bo.BusinessObject;

public class BlobRenderImpl extends DefaultRenderImpl {

	private final static String BLOB_INPUT_TYPE = "file";

	@Override
	public void readRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		String webRoot = (String) ((HttpServletRequest) pageContext
				.getRequest()).getContextPath();
		if (value != null) {
			out.startElement(Xhtml.Tag.A);
			out.attribute(Xhtml.Attr.HREF, webRoot
					+ CommonConstants.PROCESS_BLOB_SERVLET + "?resourceId="
					+ bo.getResource().getId() + "&elementId=" + fieldName);
			String alias = null;
			if (bo.getResource().getAlias() != null) {
				alias = bo.getResource().getAlias() + "' " + fieldName;
			} else {
				alias = "download";
			}
			out.text(alias);
			out.endElement(Xhtml.Tag.A);
		} else {
			out.text(Xhtml.EMPTY_STRING);
		}
	}

	@Override
	public void editRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		out.startElement(Xhtml.Tag.INPUT);
		out.attribute(Xhtml.Attr.ID, "updateFile_" + fieldName + "_");
		out.attribute(Xhtml.Attr.NAME, "updateFile(" + fieldName + ")");
		out.attribute(Xhtml.Attr.TYPE, BLOB_INPUT_TYPE);
		out.endElement(Xhtml.Tag.INPUT);
	}
}
