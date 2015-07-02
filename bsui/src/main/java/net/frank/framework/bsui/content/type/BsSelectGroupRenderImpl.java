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

public abstract class BsSelectGroupRenderImpl extends BusinessObjectRenderImpl {

	private static final String DATA_TYPE = "select";

	private static final String TAB_INDEX = "-1";

	private static final String STYLE_WIDTH = "width:260px";

	private static final String CLASS_SELECT2 = "select2-offscreen";

	public abstract List<Resource> generateData();

	public abstract Resource getSelectedData(Long resourceId);

	public abstract Long getTypeId();

	@Override
	public void editRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo,
			PageContext pageContext) {
		out.startElement(Xhtml.Tag.SELECT);
		String elementName = getElementName(fieldName, value, className, bo);
		out.attribute(Xhtml.Attr.NAME, elementName);
		out.attribute(Xhtml.Attr.ID, getElementId(elementName));
		out.attribute(Xhtml.Attr.CLASS, CLASS_SELECT2);
		out.attribute(Xhtml.Attr.STYLE, STYLE_WIDTH);
		out.attribute(Xhtml.Attr.TABINDEX, TAB_INDEX);
		out.attribute(Xhtml.Attr.DATATYPE, DATA_TYPE);
		out.attribute(Xhtml.Attr.DATAREADONLY,
				CommonConstants.BOOLEAN_FALSE_STRING);
		out.startElement(Xhtml.Tag.OPTION);
		out.attribute(Xhtml.Attr.VALUE, CommonConstants.EMPTY_STRING);
		out.text(CommonConstants.EMPTY_STRING);
		out.endElement(Xhtml.Tag.OPTION);
		String _value = prepareValue(fieldName, value, className, bo);
		List<Resource> data = generateData();
		for (Iterator<Resource> it = data.iterator(); it.hasNext();) {
			Resource dictionary = it.next();
			if (getTypeId().equals(dictionary.getTypeId())) {
				String _optValue = dictionary.getId()
						+ CommonConstants.EMPTY_STRING;
				out.startElement(Xhtml.Tag.OPTION);
				out.attribute(Xhtml.Attr.VALUE, _optValue);
				if (_optValue.equals(_value)) {
					out.attribute(Xhtml.Attr.SELECTED, "selected");
				}
				out.text(((Dictionary) dictionary.getObject()).getCodeDesc());
				out.endElement(Xhtml.Tag.OPTION);
			}
		}
		out.endElement(Xhtml.Tag.SELECT);
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
