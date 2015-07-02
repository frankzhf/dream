package net.frank.framework.web.taglib.content.type;

import javax.servlet.jsp.PageContext;

import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.bo.BusinessObject;

public interface TypeRender {
	public String DEFAULT_ELEMENT_INPUT_TYPE = "text";

	public String INPUT_TYPE_HIDDEN = "hidden";

	public void readRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo ,PageContext pageContext);

	public void editRender(JspResponseWriter out, String fieldName,
			Object value, String className, BusinessObject bo ,PageContext pageContext);
}
