package net.frank.framework.ws.render.type;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

public class ClobTypeRender extends DefaultWsRender {
	
	private static final String DEFAULT_CLASS_NAME = "char[]";

	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		char[] cvalue = null;
		try {
			cvalue = (char[]) targetObject._getValue(property);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(cvalue!=null){
			input.append(Property.BEGIN).append(property)
				.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
				.append(Property.BEGIN_3).append(CDATA.BEGIN);
			input.append(cvalue);	
			input.append(CDATA.END).append(Property.END);
		}else{
			outputEmptyXml(property, input);
		}
	}
	
	@Override
	public String getClassName(String property) {
		return DEFAULT_CLASS_NAME;
	}
	
	@Override
	public char[] getObject(String text) {
		return text.toCharArray();
	}
}
