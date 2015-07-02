package net.frank.framework.web.spring.formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.frank.commons.CommonConstants;

import org.springframework.format.Formatter;

public final class DateFormatter implements Formatter<Date> {
	
	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Override
	public String print(Date object, Locale locale) {
		if(object ==null)
			return CommonConstants.EMPTY_STRING;
		return df.format(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		if(text==null || CommonConstants.EMPTY_STRING.equals(text)){
			return null;
		}
		Date _value = null;
		try {
			_value =  df.parse(text);
		} catch (ParseException e) {
			
		}
		return _value;
	}

}
