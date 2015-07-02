package net.frank.framework.ws.render.type;

import java.math.BigDecimal;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

public class BigDecimalTypeRender extends DefaultWsRender {

	private static final String DEFAULT_CLASS_NAME = "java.math.BigDecimal";

	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		String bdvalue = targetObject.getBigDecimalString(property);
		if (bdvalue != null
				&& !CommonConstants.EMPTY_STRING.equals(bdvalue
						+ CommonConstants.EMPTY_STRING)) {
			input.append(Property.BEGIN).append(property)
					.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
					.append(Property.BEGIN_3).append(bdvalue)
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
	public BigDecimal getObject(String text) {
		BigDecimal value = new BigDecimal(text);
		return value;
	}
}
