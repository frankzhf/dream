package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class Boolean2String implements Converter<Boolean, String>{

	@Override
	public String convert(Boolean source) {
		if(source == null){
			return CommonConstants.EMPTY_STRING;
		}else{
			if(source){
				return CommonConstants.BOOLEAN_TRUE_STRING;
			}else{
				return CommonConstants.BOOLEAN_FALSE_STRING;
			}
		}
	}

}
