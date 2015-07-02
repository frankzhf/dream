package net.frank.framework.web.taglib.content.type.impl;

import javax.servlet.jsp.PageContext;

import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;
import net.frank.framework.bo.BusinessObject;

public class HiddenRenderImpl extends DefaultRenderImpl {

	private static final String HIDDEN_ELEMENT_TYPE = "hidden";

	@Override
	public void readRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		hiddenRender(out, fieldName, value, className, bo);
	}

	@Override
	public void editRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		hiddenRender(out, fieldName, value, className, bo);
	}

	private void hiddenRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo) {
		out.startElement(Xhtml.Tag.INPUT);
		String elementName = getElementName(fieldName, value, className, bo);
		out.attribute(Xhtml.Attr.NAME, elementName);
		out.attribute(Xhtml.Attr.ID, getElementId(elementName));
		out.attribute(Xhtml.Attr.VALUE,
				prepareValue(fieldName, value, className, bo));
		out.attribute(Xhtml.Attr.TYPE, HIDDEN_ELEMENT_TYPE);
		out.endElement(Xhtml.Tag.INPUT);
	}
}
