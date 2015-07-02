package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class String2CharArray implements Converter<String, char[]> {
	
	@Override
	public char[] convert(String source) {
		if(source == null || CommonConstants.EMPTY_STRING.equals(source)){
			return null;
		}else{
			return source.toCharArray();
		}
	}

}
