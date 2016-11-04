package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class String2Byte implements Converter<String,Byte>{

	@Override
	public Byte convert(String source) {
		if (source == null || CommonConstants.EMPTY_STRING.equals(source))
			return null;
		else{
			return Byte.parseByte(source);
		}
	}

}
