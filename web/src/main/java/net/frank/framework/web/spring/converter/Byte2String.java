package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class Byte2String implements Converter<Byte, String> {

	@Override
	public String convert(Byte source) {
		if(source == null){
			return CommonConstants.EMPTY_STRING;
		}else{
			return source.toString();
		}
	}

}
