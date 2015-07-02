package net.frank.framework.web.spring.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class String2Date implements Converter<String, Date> {
	
	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Override
	public Date convert(String source) {
		if(source==null || CommonConstants.EMPTY_STRING.equals(source)){
			return null;
		}
		Date _value = null;
		try {
			_value =  df.parse(source);
		} catch (ParseException e) {
			
		}
		return _value;
	}

}
