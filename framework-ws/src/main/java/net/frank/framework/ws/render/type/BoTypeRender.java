package net.frank.framework.ws.render.type;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.ws.WsRenderProvider;
import net.frank.framework.ws.define.WsRender;
import net.frank.framework.ws.render.DefaultWsRender;

public class BoTypeRender extends DefaultWsRender {

	private static final String DEFAULT_WS_TYPE_RENDER = "default";

	private static final String DEFAULT_WS_RESOURCE_REF_RENDER = "defaultResourceRef";

	private static final String[] IGRONE_PROPERTY_LIST = new String[] {"wait", "equals",
		"toString", "hashCode", "getClass", "notify", "notifyAll",
		"setForm", "getForm", "getNodeIcon", "getNodeOpenIcon",
		"setErrorFieldsValue", "getErrorFieldsValue", "clone" ,"_setValue","_getValue",
		"getClobString","setClobString","getDateString","setDateString",
		"getTimestampString","setTimestampString","getBigDecimalString","setBigDecimalString",
		"getIntegerString","setIntegerString","getLongString","setLongString",
		"setBlobString","getBlobString","getBooleanString","setBooleanString",
		"getResource","setResource","getByteString","setByteString"};

	private static final String ATTRIBUTE_CLASS = "class";

	private static final String BYTE_ARRAY = "byte[]";

	private static final String CHAR_ARRAY = "char[]";

	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		java.lang.Object value = null;
		try {
			value = targetObject._getValue(property);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (value != null) {
			log.debug("Input Object class ->" + value.getClass());
			try {
				Class<?> type = value.getClass();
				Method[] methods = type.getMethods();
				for (int i = 0; i < methods.length; i++) {
					if (!isIgroneProperty(methods[i].getName()) && 
							methods[i].getName().indexOf(BaseEntity.GETTER_PREFIX)==0 ) {
						String propertyName = methods[i].getName().substring(3);
						log.info("call propertyName:"+propertyName);
						java.lang.Object result = methods[i].invoke(value,
								new java.lang.Object[0]);
						if (result != null) {
							if (result instanceof net.frank.framework.bo.Resource) {
								net.frank.framework.bo.Resource _self = (net.frank.framework.bo.Resource) result;
								getWsRenderPool().getWsRender(
										DEFAULT_WS_RESOURCE_REF_RENDER)
										.outputXml(_self, propertyName, input);
							} else if (!(result instanceof BusinessObject)) {
								BusinessObject _bo = (BusinessObject) value;
								WsRender currentPropertyRender = meetRender(result);
								currentPropertyRender.outputXml(_bo,
										propertyName, input);
							} else {
								BaseEntity _be = (BaseEntity) result;
								getWsRenderPool().getWsRender(
										DEFAULT_WS_TYPE_RENDER).outputXml(_be,
										propertyName, input);
							}
						} else {
							String className = methods[i].getReturnType()
									.getName();
							BusinessObject _bo = (BusinessObject) value;
							if (net.frank.framework.bo.Resource.class.getName()
									.equals(className)) {
								getWsRenderPool().getWsRender(
										DEFAULT_WS_RESOURCE_REF_RENDER)
										.outputXml(_bo, propertyName, input);
							} else {
								if (getWsRenderPool().getWsRender(className) != null) {
									getWsRenderPool()
											.getWsRender(className)
											.outputXml(_bo, propertyName, input);
								} else {
									getWsRenderPool().getWsRender(
											DEFAULT_WS_TYPE_RENDER).outputXml(
											_bo, propertyName, input);
								}
							}

						}
					}
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private WsRender meetRender(Object object) {
		WsRenderProvider currentWsRenderProvider = getWsRenderPool();
		if (currentWsRenderProvider.getWsRender(object.getClass().getName()) != null) {
			return currentWsRenderProvider.getWsRender(object.getClass()
					.getName());
		}
		if (object.getClass().getInterfaces() != null) {
			for (Class<?> currentInterface : object.getClass().getInterfaces()) {
				if (currentWsRenderProvider.getWsRender(currentInterface
						.getName()) != null) {
					return currentWsRenderProvider.getWsRender(currentInterface
							.getName());
				}
			}
		}
		return getWsRenderPool().getWsRender(DEFAULT_WS_TYPE_RENDER);
	}

	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		net.frank.framework.bo.Resource _resource = (net.frank.framework.bo.Resource) targetObject;
		BusinessObject _object = null;
		String className = w3cNode.getAttributes().getNamedItem(ATTRIBUTE_CLASS).getNodeValue();
		try {
			_object = (BusinessObject) Class.forName(className).newInstance();
			NodeList propertiesElement = w3cNode.getChildNodes();
			for (int i=0; i<propertiesElement.getLength();i++) {
				Node currElement = propertiesElement.item(i);
				String _p_className = currElement.getAttributes().getNamedItem(ATTRIBUTE_CLASS).getNodeValue();
				if (BYTE_ARRAY.equals(_p_className)) {
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_BLOB)
							.setProperty(_object, currElement);
				} else if (CHAR_ARRAY.equals(_p_className)) {
					getWsRenderPool().getWsRender(CLASS_NAME.CLASS_NAME_CLOB)
							.setProperty(_object, currElement);
				} else if (net.frank.framework.bo.Resource.class.getName()
						.equals(_p_className)) {
					getWsRenderPool().getWsRender(
							DEFAULT_WS_RESOURCE_REF_RENDER).setProperty(
							_object, currElement);
				} else if (getWsRenderPool().getWsRender(_p_className) != null) {
					getWsRenderPool().getWsRender(_p_className).setProperty(
							_object, currElement);
				} else {
					getWsRenderPool().getWsRender(DEFAULT_WS_TYPE_RENDER)
							.setProperty(_object, currElement);
				}
			}
		} catch (Exception e) {
			log.error("BoTypeRender.setProperty error.");
		}
		_resource.setObject(_object);
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

	@Override
	protected void outputEmptyXml(String property, StringBuffer input) {
		input.append(Property.BEGIN).append(property)
				.append(Property.END_PROPERTY_EMPTY_END);
	}

	@Override
	public String getClassName(String property) {
		throw new RuntimeException("Unable operate.");
	}
}
