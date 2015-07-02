package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class Long2String implements Converter<Long, String> {

	@Override
	public String convert(Long source) {
		if(source == null)
			return CommonConstants.EMPTY_STRING;
		else{
			String _value = source.toString();
			return _value;	
		}
	}
}
