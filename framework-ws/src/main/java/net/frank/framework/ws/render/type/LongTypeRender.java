package net.frank.framework.ws.render.type;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

public class LongTypeRender extends DefaultWsRender {
	
	private static final String DEFAULT_CLASS_NAME = "java.lang.Long";
	
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		String longValue = targetObject.getLongString(property);
		if (longValue != null
				&& !CommonConstants.EMPTY_STRING.equals(longValue)) {
			input.append(Property.BEGIN).append(property)
					.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
					.append(Property.BEGIN_3).append(longValue)
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
	public Long getObject(String text) {
		return Long.parseLong(text);
	}
}
