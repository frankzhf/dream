package net.frank.framework.web.taglib.content.type.impl;

import javax.servlet.jsp.PageContext;

import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;
import net.frank.framework.bo.BusinessObject;

public class DateRenderImpl extends DefaultRenderImpl {

	private static final String CALENDAR_PREFIX = "calendar_";

	private static final String UI_CALENDAR_CLASS = "easyui-datebox";

	@Override
	public void editRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		out.startElement(Xhtml.Tag.INPUT);
		String elementName = getElementName(fieldName, value, className, bo);
		out.attribute(Xhtml.Attr.NAME, elementName);
		out.attribute(Xhtml.Attr.ID, CALENDAR_PREFIX
				+ getElementId(elementName));
		out.attribute(Xhtml.Attr.VALUE,
				prepareValue(fieldName, value, className, bo));
		out.attribute(Xhtml.Attr.TYPE, DEFAULT_ELEMENT_INPUT_TYPE);
		out.attribute(Xhtml.Attr.CLASS, UI_CALENDAR_CLASS);
		out.endElement(Xhtml.Tag.INPUT);
	}
}
