package net.frank.framework.ws.render.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.w3c.dom.Node;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.ws.render.DefaultWsRender;

public class TimestameTypeRender extends DefaultWsRender {

	// refer CommonConstants.DEFAULT_TIME_FORMAT
	private static final String FORMAT_INFO = "\" format=\""
			+ CommonConstants.DEFAULT_TIME_FORMAT;
	private static final String DEFAULT_CLASS_NAME = "java.util.Date";
	
	private static final String ATTRIBUTE_FORMAT = "format";
	private static final String ATTRIBUTE_LOCATE = "locate";
	private static final String LOCATE_SPLIT = "_";

	@Override
	public void outputXml(BaseEntity targetObject, String property,
			StringBuffer input) {
		String strDate = targetObject.getTimestampString(property);
		if (strDate != null && !CommonConstants.EMPTY_STRING.equals(strDate)) {
			input.append(Property.BEGIN).append(property).append(FORMAT_INFO)
					.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
					.append(Property.BEGIN_4)
					.append(Locale.getDefault().toString())
					.append(Property.BEGIN_3).append(strDate)
					.append(Property.END);
		} else {
			input.append(Property.BEGIN).append(property).append(FORMAT_INFO)
				.append(Property.BEGIN_2).append(DEFAULT_CLASS_NAME)
				.append(Property.BEGIN_4)
				.append(Locale.getDefault().toString())
				.append(Property.END_PROPERTY_EMPTY_END);
		}
	}

	@Override
	public void setProperty(BaseEntity targetObject, Node w3cNode) {
		String propertyName = w3cNode.getAttributes().getNamedItem(DEFAULT_ATTRIBUTE_NAME).getNodeValue();
		String format = w3cNode.getAttributes().getNamedItem(ATTRIBUTE_FORMAT).getNodeValue();
		String locale = w3cNode.getAttributes().getNamedItem(ATTRIBUTE_LOCATE).getNodeValue();
		String[] _locale = locale.split(LOCATE_SPLIT);
		String lanaguage = _locale[0];
		String country = _locale[1];
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format,
				new Locale(lanaguage, country));
		Object value = null;
		if(w3cNode.getFirstChild()!=null && w3cNode.getFirstChild().getNodeValue() != null
				&& w3cNode.getFirstChild().getNodeValue().length()>0){
			try {
				value = simpleDateFormat.parseObject(w3cNode.getFirstChild().getNodeValue());
			} catch (ParseException e) {
				log.error(ParseException.class.getName());
				throw new RuntimeException(e);
			}
		}
		if(value!=null){
			targetObject._setValue(propertyName, value);
		}else{
			targetObject._setValue(propertyName, null);
		}
	}

	@Override
	public String getClassName(String property) {
		return DEFAULT_CLASS_NAME;
	}
}
