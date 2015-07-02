package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class Integer2String implements Converter<Integer, String> {

	@Override
	public String convert(Integer source) {
		if(source == null)
			return CommonConstants.EMPTY_STRING;
		else{
			String _value = source.toString();
			return _value;	
		}
	}

}
