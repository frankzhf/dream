package net.frank.framework.web.taglib.content.type.impl;

import javax.servlet.jsp.PageContext;

import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;
import net.frank.framework.bo.BusinessObject;

public class ClobRenderImpl extends DefaultRenderImpl {

	private static final String DEFAULT_ROWS_NUMBER = "4";

	@Override
	public void readRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		out.text(prepareReadValue(fieldName, value, className, bo));

	}

	@Override
	public void editRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		renderTextArea(out, fieldName, value, className, bo);
	}

	private void renderTextArea(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo) {
		out.setPrettyPrinting(Boolean.FALSE);
		String elementName = getElementName(fieldName, value, className, bo);
		String elementId = getElementId(elementName);
		out.startElement(Xhtml.Tag.TEXTAREA);
		// out.attribute(Xhtml.Attr.STYLE, "display:none");
		out.attribute(Xhtml.Attr.ID, elementId);
		out.attribute(Xhtml.Attr.NAME, elementName);
		out.attribute(Xhtml.Attr.ROWS, DEFAULT_ROWS_NUMBER);
		out.text(prepareValue(fieldName, value, className, bo));
		out.endElement2(Xhtml.Tag.TEXTAREA);
		out.setPrettyPrinting(Boolean.TRUE);
	}

}
