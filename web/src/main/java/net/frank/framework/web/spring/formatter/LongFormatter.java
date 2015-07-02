package net.frank.framework.web.spring.formatter;

import java.text.ParseException;
import java.util.Locale;

import net.frank.commons.CommonConstants;

import org.springframework.format.Formatter;

public final class LongFormatter implements Formatter<Long> {
	
	@Override
	public String print(Long object, Locale locale) {
		if(object == null)
			return CommonConstants.EMPTY_STRING;
		else{
			String _value = object.toString();
			return _value;	
		}
	}

	@Override
	public Long parse(String text, Locale locale) throws ParseException {
		if(text == null){
			return null;
		}else{
			Long _value = Long.decode(text);
			return _value;
		}
	}

}
