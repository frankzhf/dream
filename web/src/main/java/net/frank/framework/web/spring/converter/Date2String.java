package net.frank.framework.web.spring.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class Date2String implements Converter<Date, String> {
	
	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Override
	public String convert(Date source) {
		if(source ==null)
			return CommonConstants.EMPTY_STRING;
		return df.format(source);
	}

}
