package net.frank.framework.bsui.content.type.impl;

import javax.servlet.jsp.PageContext;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.web.servlet.ImageContentServlet;
import net.frank.framework.web.taglib.content.type.impl.BusinessObjectRenderImpl;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;

public class ImageRenderImpl extends BusinessObjectRenderImpl {
	protected static final String UI_DIALOG_BUTTON_LABEL = "更新图片...";
	private static final String IMAGE_PREFFIX = "image_";
	private static final String IMAGE_STYLE = "width:125px;height:180px";

	@Override
	public void readRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		String elementName = getElementName(fieldName, value, className, bo);
		out.startElement(Xhtml.Tag.IMG);
		out.attribute(Xhtml.Attr.ID, IMAGE_PREFFIX + elementName);
		Resource res = null;
		if (value != null && !CommonConstants.EMPTY_STRING.equals(value)) {
			if (value instanceof Resource) {
				res = (Resource) value;
			}
			out.attribute(Xhtml.Attr.SRC, ImageContentServlet.WEB_CONTEXT
					+ "/image-service?resourceId=" + res.getId()
					+ "&elementId=content&flag=" + Math.random());
		} else {
			out.attribute(Xhtml.Attr.SRC, ImageContentServlet.WEB_CONTEXT
					+ "/global/images/default.jpg");
		}
		out.attribute(Xhtml.Attr.STYLE, IMAGE_STYLE);
		out.endElement(Xhtml.Tag.IMG);
	}

	@Override
	public void editRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		String elementName = getElementName(fieldName, value, className, bo);
		elementName += ".longString(id)";
		String elementId = getElementId(elementName);
		out.startElement(Xhtml.Tag.IMG);
		out.attribute(Xhtml.Attr.ID, IMAGE_PREFFIX + elementName);
		if (value != null && !CommonConstants.EMPTY_STRING.equals(value)) {
			Resource res = null;
			if (value instanceof Resource) {
				res = (Resource) value;
			}
			out.attribute(Xhtml.Attr.SRC, ImageContentServlet.WEB_CONTEXT
					+ "/image-service?resourceId=" + res.getId()
					+ "&elementId=content" + "&flag=" + Math.random());
		} else {
			out.attribute(Xhtml.Attr.SRC, ImageContentServlet.WEB_CONTEXT
					+ "/global/images/default.jpg");
		}
		out.attribute(Xhtml.Attr.STYLE, IMAGE_STYLE);
		out.endElement(Xhtml.Tag.IMG);
		out.text(Xhtml.EMPTY_STRING);
		out.startElement(Xhtml.Tag.BR);
		out.startElement(Xhtml.Tag.INPUT);
		out.attribute(Xhtml.Attr.TYPE, DIALOG_BUTTON_INPUT_TYPE);
		out.attribute(Xhtml.Attr.VALUE, UI_DIALOG_BUTTON_LABEL);
		out.attribute(Xhtml.Attr.ONCLICK, "dialogUpdateImage('" + elementName
				+ "')");
		out.attribute(Xhtml.Attr.DATATARGET, "#push");
		out.attribute(Xhtml.Attr.DATATOGGLE, "modal");
		out.attribute(Xhtml.Attr.CLASS, "btn btn-success");
		out.endElement(Xhtml.Tag.INPUT);
		out.startElement(Xhtml.Tag.INPUT);
		out.attribute(Xhtml.Attr.TYPE, INPUT_TYPE_HIDDEN);
		out.attribute(Xhtml.Attr.ID, elementId);
		out.attribute(Xhtml.Attr.NAME, elementName);
		out.attribute(Xhtml.Attr.VALUE,
				prepareValue(fieldName, value, className, bo));
		out.endElement(Xhtml.Tag.INPUT);
	}

}
