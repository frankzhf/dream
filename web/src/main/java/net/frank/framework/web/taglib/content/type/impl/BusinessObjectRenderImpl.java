package net.frank.framework.web.taglib.content.type.impl;

import javax.servlet.jsp.PageContext;

import net.frank.commons.CommonConstants;
import net.frank.framework.service.QueryService;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;

public class BusinessObjectRenderImpl extends DefaultRenderImpl {

	private QueryService queryService;

	protected static final String DIALOG_PREFFIX = "dialog_";

	protected static final String DIALOG_BUTTON_INPUT_TYPE = "button";

	protected static final String UI_DIALOG_BUTTON_LABEL = "...";

	protected static final String HTYPER_LINK = "#";

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public QueryService getQueryService() {
		return queryService;
	}

	@Override
	public void readRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		if (value != null && !CommonConstants.EMPTY_STRING.equals(value)) {
			out.startElement(Xhtml.Tag.A);
			out.attribute(Xhtml.Attr.HREF, HTYPER_LINK);
			if (value instanceof Resource) {
				out.attribute(Xhtml.Attr.ONCLICK, "directResource('"
						+ ((Resource) value).getId() + "')");
				Resource resource = getQueryService().getResource(
						((Resource) value).getId());
				String path = getQueryService().getResourcePath(resource);
				out.text(path);
			} else {
				out.attribute(Xhtml.Attr.ONCLICK,
						"directResource('" + value.toString() + "')");
				out.text(fieldName);
			}
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
		out.attribute(Xhtml.Attr.TYPE, DEFAULT_ELEMENT_INPUT_TYPE);
		String elementName = getElementName(fieldName, value, className, bo);
		String elementId = getElementId(elementName);
		out.attribute(Xhtml.Attr.NAME, DIALOG_PREFFIX + elementName);
		out.attribute(Xhtml.Attr.ID, DIALOG_PREFFIX + elementId);
		out.attribute(Xhtml.Attr.READONLY, CommonConstants.BOOLEAN_TRUE_STRING);
		out.attribute(
				Xhtml.Attr.VALUE,
				value != null ? ((Resource) value).getAlias() == null ? CommonConstants.EMPTY_STRING
						: ((Resource) value).getAlias()
						: CommonConstants.EMPTY_STRING);
		out.endElement(Xhtml.Tag.INPUT);
		out.text(Xhtml.EMPTY_STRING);
		out.startElement(Xhtml.Tag.INPUT);
		out.attribute(Xhtml.Attr.TYPE, DIALOG_BUTTON_INPUT_TYPE);
		out.attribute(Xhtml.Attr.VALUE, UI_DIALOG_BUTTON_LABEL);
		out.attribute(Xhtml.Attr.ONCLICK, "dialogSelector('" + elementName
				+ "')");
		out.endElement(Xhtml.Tag.INPUT);
		out.startElement(Xhtml.Tag.INPUT);
		out.attribute(Xhtml.Attr.TYPE, INPUT_TYPE_HIDDEN);
		out.attribute(Xhtml.Attr.NAME, elementName);
		out.attribute(Xhtml.Attr.ID, elementId);
		out.attribute(Xhtml.Attr.VALUE,
				prepareValue(fieldName, value, className, bo));
		out.endElement(Xhtml.Tag.INPUT);
	}

}
