package net.frank.framework.ws.render.type;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

public class BooleanTypeRender extends DefaultWsRender {
	private static final String DEFAULT_CLASS_NAME = "java.lang.Boolean";

	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		String strBoolean = targetObject.getBooleanString(property);
		if (strBoolean != null
				&& !CommonConstants.EMPTY_STRING.equals(strBoolean)) {
			input.append(Property.BEGIN).append(property)
					.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
					.append(Property.BEGIN_3).append(strBoolean)
					.append(Property.END);
		} else {
			outputEmptyXml(property, input);
		}
	}

	@Override
	public String getClassName(String property) {
		return DEFAULT_CLASS_NAME;
	}
	
	@Override
	public Boolean getObject(String text) {
		if(CommonConstants.BOOLEAN_TRUE_STRING.equals(text)){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
}
