package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class String2Integer implements Converter<String, Integer> {
	@Override
	public Integer convert(String source) {
		if(source == null || CommonConstants.EMPTY_STRING.equals(source)){
			return null;
		}else{
			Integer _value = Integer.parseInt(source);
			return _value;
		}
	}
}
