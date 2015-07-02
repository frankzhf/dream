package net.frank.framework.ws.render.type;

import net.frank.commons.util.Base64Util;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

public class BlobTypeRender extends DefaultWsRender {

	private static final String DEFAULT_CLASS_NAME = "byte[]";

	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		byte[] bvalue = null;
		try {
			bvalue = (byte[]) targetObject._getValue(property);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (bvalue != null) {
			input.append(Property.BEGIN).append(property)
					.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
					.append(Property.BEGIN_3).append(CDATA.BEGIN);
			input.append(
					Base64Util.encodeToString(bvalue,Base64Util.DEFAULT));
			input.append(CDATA.END).append(Property.END);
		} else {
			outputEmptyXml(property, input);
		}
	}
	
	@Override
	public String getClassName(String property) {
		return DEFAULT_CLASS_NAME;
	}
	
	@Override
	public byte[] getObject(String text) {
		byte[] value =null;
		value = Base64Util.decode(text,Base64Util.DEFAULT);
		return value;
	}
	
}
