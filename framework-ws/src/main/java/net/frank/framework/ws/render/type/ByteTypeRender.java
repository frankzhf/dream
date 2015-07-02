package net.frank.framework.ws.render.type;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

public class ByteTypeRender extends DefaultWsRender {
	private static final String DEFAULT_CLASS_NAME = "java.lang.Byte";
	
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		String byteValue = targetObject.getByteString(property);
		if (byteValue != null
				&& !CommonConstants.EMPTY_STRING.equals(byteValue
						+ CommonConstants.EMPTY_STRING)) {
			input.append(Property.BEGIN).append(property)
					.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
					.append(Property.BEGIN_3).append(byteValue)
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
