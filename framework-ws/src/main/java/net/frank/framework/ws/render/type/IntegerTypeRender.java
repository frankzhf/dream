package net.frank.framework.ws.render.type;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

public class IntegerTypeRender extends DefaultWsRender {
	
	private static final String DEFAULT_CLASS_NAME = "java.lang.Integer";
	
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		String intValue = targetObject.getIntegerString(property);
		
		if (intValue != null
				&& !CommonConstants.EMPTY_STRING.equals(intValue
						+ CommonConstants.EMPTY_STRING)) {
			input.append(Property.BEGIN).append(property)
					.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
					.append(Property.BEGIN_3).append(intValue)
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
	public Integer getObject(String text) {
		return Integer.parseInt(text);
	}
}
