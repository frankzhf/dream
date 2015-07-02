package net.frank.framework.ws.render.type;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

@Deprecated
public class DateTypeRender extends DefaultWsRender {
	
	//refer CommonConstants.DEFAULT_DATE_FORMAT
	private static final String FORMAT_INFO = "\" format=\""+CommonConstants.DEFAULT_DATE_FORMAT;
	private static final String DEFAULT_CLASS_NAME = "java.lang.Date";
	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		String strDate = targetObject.getDateString(property);
		if(strDate!=null && !CommonConstants.EMPTY_STRING.equals(strDate)){
			input.append(Property.BEGIN).append(property).append(FORMAT_INFO)
				.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
				.append(Property.BEGIN_3).append(strDate)
				.append(Property.END);
		}else{
			outputEmptyXml(property, input);
		}
	}
	
	@Override
	public String getClassName(String property) {
		return DEFAULT_CLASS_NAME;
	}
}
