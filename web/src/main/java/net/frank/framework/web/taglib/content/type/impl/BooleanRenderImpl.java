package net.frank.framework.web.taglib.content.type.impl;

import javax.servlet.jsp.PageContext;

import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;
import net.frank.framework.bo.BusinessObject;

public class BooleanRenderImpl extends DefaultRenderImpl {

	private final static String BOOLEAN_INPUT_TYPE = "checkbox";
	private final static String BOOLEAN_TRUE_VALUE = "true";
	private final static String CHECKED_VALUE = "checked";

	@Override
	public void editRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		out.startElement(Xhtml.Tag.INPUT);
		out.attribute(Xhtml.Attr.TYPE, BOOLEAN_INPUT_TYPE);
		String elementName = getElementName(fieldName, value, className, bo);
		out.attribute(Xhtml.Attr.NAME, elementName);
		out.attribute(Xhtml.Attr.ID, getElementId(elementName));
		out.attribute(Xhtml.Attr.VALUE, BOOLEAN_TRUE_VALUE);
		if (value instanceof Boolean && (Boolean) value)
			out.attribute(Xhtml.Attr.CHECKED, CHECKED_VALUE);
		out.endElement(Xhtml.Tag.INPUT);
	}
}
