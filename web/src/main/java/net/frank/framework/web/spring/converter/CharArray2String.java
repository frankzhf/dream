package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class CharArray2String implements Converter<char[], String>{

	@Override
	public String convert(char[] source) {
		if(source == null){
			return CommonConstants.EMPTY_STRING;
		}else{
			String _value = new String(source);
			return _value;
		}
	}

}
