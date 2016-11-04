package net.frank.framework.web.spring.converter;

import net.frank.commons.CommonConstants;

import org.springframework.core.convert.converter.Converter;

public final class String2Boolean implements Converter<String, Boolean>  {

	@Override
	public Boolean convert(String source) {
		if(source == null || CommonConstants.EMPTY_STRING.equals(source)){
			return null;
		}else{
			if(CommonConstants.BOOLEAN_TRUE_STRING.equals(source)){
				return Boolean.TRUE;
			}else{
				return Boolean.FALSE;
			}
		}
	}

}
