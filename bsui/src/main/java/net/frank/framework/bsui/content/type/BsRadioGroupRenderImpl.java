package net.frank.framework.bsui.content.type;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.PageContext;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Dictionary;
import net.frank.framework.bo.Resource;
import net.frank.framework.web.taglib.content.type.impl.BusinessObjectRenderImpl;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;

public abstract class BsRadioGroupRenderImpl extends BusinessObjectRenderImpl {
	public abstract List<Resource> generateData();

	public abstract Resource getSelectedData(Long resourceId);

	public abstract Long getTypeId();

	private static final String UI_INPUT_TYPE = "radio";

	@Override
	public void editRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		out.startElement(Xhtml.Tag.DIV);
		out.attribute(Xhtml.Attr.CLASS, "radio");
		String elementName = getElementName(fieldName, value, className, bo);
		String elementId = getElementId(elementName);
		String _value = prepareValue(fieldName, value, className, bo);
		boolean isFirst = true;
		List<Resource> data = generateData();
		for (Iterator<Resource> it = data.iterator(); it.hasNext();) {
			Resource dictionary = it.next();
			String __value = dictionary.getId() + CommonConstants.EMPTY_STRING;
			if (getTypeId().equals(dictionary.getTypeId())) {
				out.startElement(Xhtml.Tag.SPAN);
				if (isFirst) {
					out.attribute(Xhtml.Attr.STYLE, "display: inline-block;");
					isFirst = false;
				} else {
					out.attribute(Xhtml.Attr.STYLE,
							"display: inline-block;  padding-left: 40px;");
				}
				out.startElement(Xhtml.Tag.INPUT);
				out.attribute(Xhtml.Attr.ID, elementId);
				out.attribute(Xhtml.Attr.NAME, elementName);
				out.attribute(Xhtml.Attr.TYPE, UI_INPUT_TYPE);
				if (__value.equals(_value)) {
					out.attribute(Xhtml.Attr.CHECKED, "checked");
				}
				out.endElement(Xhtml.Tag.INPUT);
				// <label for="idValueMap[61]1"> … </label>
				out.startElement(Xhtml.Tag.LABEL);
				out.text(((Dictionary) dictionary.getObject()).getCodeDesc());
				out.endElement(Xhtml.Tag.LABEL);
				out.endElement(Xhtml.Tag.SPAN);
			}
		}
		out.endElement(Xhtml.Tag.DIV);
	}

	@Override
	public void readRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		if (value != null && !CommonConstants.EMPTY_STRING.equals(value)) {
			Long resourceId = ((Resource) value).getId();
			Resource currSelected = getSelectedData(resourceId);
			if (getTypeId()
					.equals(currSelected.getTypeId())) {
				out.text(((Dictionary) currSelected.getObject()).getCodeDesc());
			} else {
				out.text(Xhtml.EMPTY_STRING);
			}
		} else {
			out.text(Xhtml.EMPTY_STRING);
		}
	}
}
