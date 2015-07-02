package net.frank.framework.ws.render;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Node;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.WsRenderProvider;
import net.frank.framework.ws.WsXmlConstants;
import net.frank.framework.ws.define.WsRender;

public class DefaultWsRender implements WsRender, WsXmlConstants {
	protected final transient Log log = LogFactory.getLog(getClass());
	private static final String DEFAULT_CLASS_NAME = "java.lang.String";

	public static final String DEFAULT_ATTRIBUTE_NAME = "name";

	private WsRenderProvider wsRenderProvider;

	public void setWsRenderProvider(WsRenderProvider wsRenderProvider) {
		this.wsRenderProvider = wsRenderProvider;
	}

	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		java.lang.Object value = null;
		try {
			value = targetObject._getValue(property);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (value != null
				&& !CommonConstants.EMPTY_STRING.equals(value
						+ CommonConstants.EMPTY_STRING)) {
			input.append(Property.BEGIN).append(property)
					.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
					.append(Property.BEGIN_3).append(value)
					.append(Property.END);
		} else {
			outputEmptyXml(property, input);
		}

	}

	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		String propertyName = w3cNode.getAttributes()
				.getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue();
		Object value = null;
		if (w3cNode.getFirstChild()!= null && w3cNode.getFirstChild().getNodeValue() != null
				&& w3cNode.getFirstChild().getNodeValue().length() > 0) {
			value = getObject(w3cNode.getFirstChild().getNodeValue());
		}
		if (value != null) {
			targetObject._setValue(propertyName, value);
		} else {
			targetObject._setValue(propertyName, null);
		}
	}

	protected void outputEmptyXml(String property, StringBuffer input) {
		input.append(Property.BEGIN).append(property).append(Property.BEGIN_2)
				.append(getClassName(property))
				.append(Property.END_PROPERTY_EMPTY_END);
	}

	@Override
	public WsRenderProvider getWsRenderPool() {
		return wsRenderProvider;
	}

	@Override
	public String getClassName(String property) {
		return DEFAULT_CLASS_NAME;
	}

	@Override
	public Object getObject(String text) {
		return text;
	}

}
