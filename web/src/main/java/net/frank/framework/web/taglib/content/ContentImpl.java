package net.frank.framework.web.taglib.content;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.ObjectUtil;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.taglib.content.type.TypeRender;
import net.frank.framework.writer.JspResponseWriter;
import net.frank.framework.xml.Xhtml;
import net.frank.framework.bo.BusinessObject;

public final class ContentImpl extends SimpleTagSupport {

	private static final String CLASS_NAME_DATE = "java.util.Date";

	private static final String[] IGRONE_PROPERTY_LIST = new String[] {
			"resourceAlias", "resource", "selected", "errorFieldsValue",
			"nodeIcon", "nodeOpenIcon", "relateResourceMap", "form",
			"clobStoreMap", "blobStoreMap", "params" };

	private static final String BO_PK = "id";

	private static final String PROPERTY = "Property";

	private static final String VALUE = "Value";

	private final static transient Log log = LogFactory
			.getLog(ContentImpl.class);

	private Object var;

	private Long typeResourceId;

	private String mode = CommonConstants.PAGE_MODE.VIEW;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Long getTypeResourceId() {
		return typeResourceId;
	}

	public void setTypeResourceId(Long typeResourceId) {
		this.typeResourceId = typeResourceId;
	}

	public void setVar(Object var) {
		this.var = var;
	}

	public Object getVar() {
		return var;
	}

	private JspResponseWriter out = new JspResponseWriter();

	public void doTag() throws JspException, IOException {
		ContentRenderProvider contentRenderProvider = (ContentRenderProvider) SpringContextUtil
				.getBean("contentRenderProvider");
		if (var == null) {
			throw new JspException("Content Tag can't process Null Object");
		}
		PageContext pageContext = (PageContext) getJspContext();
		log.debug("Input Object class ->" + var.getClass().getName());
		BusinessObject curr = (BusinessObject) var;
		Map<String, Object> objPropertiesMap = new HashMap<String, Object>();
		Map<String, String> classMap = new HashMap<String, String>();
		try {
			Class<?> type = var.getClass();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(var, new Object[0]);
					classMap.put(propertyName, readMethod.getReturnType()
							.getName());
					objPropertiesMap.put(propertyName, result);
				}
			}
		} catch (IntrospectionException e) {
			throw new JspException(e);
		} catch (IllegalAccessException e) {
			throw new JspException(e);
		} catch (InvocationTargetException e) {
			throw new JspException(e);
		}
		out.startElement(Xhtml.Tag.TABLE);
		out.attribute(Xhtml.Attr.CLASS, "listTable");
		out.attribute(Xhtml.Attr.STYLE, "width:100%;");
		out.startElement(Xhtml.Tag.TR);
		out.startElement(Xhtml.Tag.TH);
		out.attribute(Xhtml.Attr.STYLE, "width:40%;");
		out.text(PROPERTY);
		out.endElement(Xhtml.Tag.TH);
		out.startElement(Xhtml.Tag.TH);
		out.attribute(Xhtml.Attr.STYLE, "width:35%;");
		out.text(VALUE);
		out.endElement(Xhtml.Tag.TH);
		out.startElement(Xhtml.Tag.TH);
		out.text(Xhtml.EMPTY_STRING);
		out.endElement(Xhtml.Tag.TH);
		out.endElement(Xhtml.Tag.TR);
		if (!classMap.isEmpty()) {
			for (Iterator<String> it = classMap.keySet().iterator(); it
					.hasNext();) {
				String key = it.next();
				Object obj = objPropertiesMap.get(key);
				String className = classMap.get(key);
				TypeRender currentTypeRender = contentRenderProvider
						.getTypeRender(className);
				if (!isIgroneProperty(key)) {
					if (BO_PK.equals(key)) {
						contentRenderProvider.getTypeRender("hidden")
								.editRender(out, key, obj, className, curr,
										pageContext);
					} else {
						out.startElement(Xhtml.Tag.TR);
						out.startElement(Xhtml.Tag.TD);
						try {
							out.text(processLabel(key, className));
						} catch (ClassNotFoundException e) {
							throw new JspException(e);
						}
						out.endElement(Xhtml.Tag.TD);
						out.startElement(Xhtml.Tag.TD);
						if (CommonConstants.PAGE_MODE.EDIT.equals(mode)) {
							currentTypeRender.editRender(out, key, obj,
									className, curr, pageContext);
						} else {
							currentTypeRender.readRender(out, key, obj,
									className, curr, pageContext);
						}
						out.text("&nbsp;");
						out.endElement(Xhtml.Tag.TD);
						out.startElement(Xhtml.Tag.TD);
						out.text(Xhtml.EMPTY_STRING);
						out.endElement(Xhtml.Tag.TD);
						out.endElement(Xhtml.Tag.TR);
					}
				}
			}
		}
		out.endElement(Xhtml.Tag.TABLE);
		getJspContext().getOut().print(out.getBuffer());
	}

	private String processLabel(String key, String className)
			throws ClassNotFoundException {
		// log.debug("processLabel() --> input key -->" + key);
		// log.debug("processLabel() --> input className -->" + className);
		StringBuffer sb = new StringBuffer(CommonConstants.EMPTY_STRING);
		String processValue = null;
		if (!ObjectUtil.isBaseType(className)
				&& !Class.forName(className).isInterface()
				&& CommonConstants.BO_SUPER_CLASS_NAME.equals(Class
						.forName(className).getSuperclass().getName())) {
			processValue = key.substring(0,
					key.indexOf(CommonConstants.DATA_FIELD_REFER_SYMBOL_BEG));
		} else {
			processValue = key;
		}
		// log.debug("processLabel() --> processValue -->" + processValue);
		char firstChar = processValue.charAt(0);
		sb.append((firstChar + CommonConstants.EMPTY_STRING).toUpperCase());
		for (int i = 1; i < processValue.length(); i++) {
			char c = processValue.charAt(i);
			if (c < 97) {
				sb.append((CommonConstants.SPACE + c + CommonConstants.EMPTY_STRING)
						.toUpperCase());
			} else {
				sb.append(c);
			}
		}
		if (CLASS_NAME_DATE.equals(className)) {
			sb.append(CommonConstants.LEFT_BRACKET);
			sb.append(CommonConstants.DEFAULT_DATE_FORMAT);
			sb.append(CommonConstants.RIGHT_BRACKET);
		}
		// log.debug("processLabel() --> output -->" + sb.toString());
		return sb.toString();
	}

	private boolean isIgroneProperty(String propertyName) {
		boolean returnValue = false;
		for (int i = 0; i < IGRONE_PROPERTY_LIST.length; i++) {
			if (IGRONE_PROPERTY_LIST[i].equals(propertyName)) {
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
}
