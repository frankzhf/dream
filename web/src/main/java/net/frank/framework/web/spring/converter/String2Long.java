package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class String2Long implements Converter<String, Long> {
	@Override
	public Long convert(String source) {
		if(source == null || CommonConstants.EMPTY_STRING.equals(source)){
			return null;
		}else{
			Long _value = Long.decode(source);
			return _value;
		}
	}
}
